package org.light.tavcodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import org.light.device.LightDeviceProperty;
import org.light.tavcodec.SynchronizeHandler;

/* loaded from: classes29.dex */
public class GPUDecoder {
    private static final int DECODER_THREAD_MAX_COUNT = 10;
    private static final int END_OF_STREAM = -3;
    private static final int ERROR = -2;
    private static final int INIT_DECODER_TIMEOUT_MS = 2000;
    private static final int SUCCESS = 0;
    private static final int TIMEOUT_US = 1000;
    private static final int TRY_AGAIN_LATER = -1;
    private static final AtomicInteger decoderThreadCount = new AtomicInteger();
    private MediaCodec decoder;
    private Surface outputSurface = null;
    private HashSet<Long> pendingTimes = new HashSet<>();
    private boolean queueEOSBuffer = false;
    private boolean errorInsufficientResource = false;
    private boolean disableFlush = true;
    private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private int lastOutputBufferIndex = -1;
    private long lastPresentationTime = 0;
    private boolean released = false;

    private static GPUDecoder Create(Surface surface) {
        if (forceSoftwareDecoder()) {
            return null;
        }
        GPUDecoder gPUDecoder = new GPUDecoder();
        gPUDecoder.outputSurface = surface;
        return gPUDecoder;
    }

    private int dequeueInputBuffer() {
        try {
            return this.decoder.dequeueInputBuffer(1000L);
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private int dequeueOutputBuffer() {
        try {
            return this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private static boolean forceSoftwareDecoder() {
        if (LightDeviceProperty.VERSION.SDK_INT < 21) {
            return true;
        }
        return false;
    }

    private ByteBuffer getInputBuffer(int i3) {
        try {
            if (LightDeviceProperty.VERSION.SDK_INT >= 21) {
                return this.decoder.getInputBuffer(i3);
            }
            return this.decoder.getInputBuffers()[i3];
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private boolean initDecoder(final MediaFormat mediaFormat) {
        AtomicInteger atomicInteger = decoderThreadCount;
        if (atomicInteger.get() >= 10) {
            return false;
        }
        atomicInteger.getAndIncrement();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("libpag_GPUDecoder_init_decoder");
        baseHandlerThread.start();
        final MediaCodec[] mediaCodecArr = {null};
        boolean runSync = new SynchronizeHandler(baseHandlerThread.getLooper()).runSync(new SynchronizeHandler.TimeoutRunnable() { // from class: org.light.tavcodec.GPUDecoder.1
            private MediaCodec decoder;
            private long startTime;

            @Override // org.light.tavcodec.SynchronizeHandler.TimeoutRunnable
            public void afterRun(boolean z16) {
                if (z16 && this.decoder != null) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
                    try {
                        this.decoder.stop();
                    } catch (Exception unused) {
                    }
                    try {
                        this.decoder.release();
                    } catch (Exception unused2) {
                    }
                    this.decoder = null;
                    new RuntimeException("init decoder timeout. cost: " + uptimeMillis + "ms").printStackTrace();
                }
                if (!z16) {
                    mediaCodecArr[0] = this.decoder;
                }
                GPUDecoder.decoderThreadCount.getAndDecrement();
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16 = false;
                GPUDecoder.this.errorInsufficientResource = false;
                this.startTime = SystemClock.uptimeMillis();
                try {
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
                    this.decoder = createDecoderByType;
                    createDecoderByType.configure(mediaFormat, GPUDecoder.this.outputSurface, (MediaCrypto) null, 0);
                    this.decoder.start();
                } catch (Exception e16) {
                    if (e16 instanceof MediaCodec.CodecException) {
                        GPUDecoder gPUDecoder = GPUDecoder.this;
                        if (((MediaCodec.CodecException) e16).getErrorCode() == 1100) {
                            z16 = true;
                        }
                        gPUDecoder.errorInsufficientResource = z16;
                    }
                    MediaCodec mediaCodec = this.decoder;
                    if (mediaCodec != null) {
                        mediaCodec.release();
                        this.decoder = null;
                    }
                }
            }
        }, 2000L);
        baseHandlerThread.quitSafely();
        if (!runSync) {
            return false;
        }
        MediaCodec mediaCodec = mediaCodecArr[0];
        this.decoder = mediaCodec;
        if (mediaCodec == null) {
            return false;
        }
        return true;
    }

    private boolean isErrorInsufficientResource() {
        return this.errorInsufficientResource;
    }

    private boolean onConfigure(MediaFormat mediaFormat) {
        if (this.outputSurface == null) {
            return false;
        }
        return initDecoder(mediaFormat);
    }

    private int onDecodeFrame() {
        try {
            int dequeueOutputBuffer = dequeueOutputBuffer();
            MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
            if ((bufferInfo.flags & 4) != 0) {
                if (dequeueOutputBuffer >= 0) {
                    this.queueEOSBuffer = false;
                    releaseOutputBuffer(dequeueOutputBuffer, false);
                }
                return -3;
            }
            if (dequeueOutputBuffer >= 0) {
                this.lastPresentationTime = bufferInfo.presentationTimeUs;
                releaseOutputBuffer();
                this.lastOutputBufferIndex = dequeueOutputBuffer;
                this.pendingTimes.remove(Long.valueOf(this.bufferInfo.presentationTimeUs));
                if (this.pendingTimes.isEmpty() && this.queueEOSBuffer) {
                    int i3 = 100;
                    while (true) {
                        int i16 = i3 - 1;
                        if (i3 <= 0) {
                            break;
                        }
                        int dequeueOutputBuffer2 = dequeueOutputBuffer();
                        if (dequeueOutputBuffer2 > 0) {
                            if ((this.bufferInfo.flags & 4) != 0) {
                                this.queueEOSBuffer = false;
                                releaseOutputBuffer(dequeueOutputBuffer2, false);
                                break;
                            }
                            Log.e("GPUDecoder", "dequeue non-EOS buffer when pendingTimes is empty!");
                        }
                        LockMethodProxy.sleep(1L);
                        i3 = i16;
                    }
                    return -3;
                }
            }
            if (dequeueOutputBuffer >= 0) {
                return 0;
            }
            return -1;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }

    private int onEndOfStream() {
        int dequeueInputBuffer = dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            int queueInputBuffer = queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            if (queueInputBuffer == 0) {
                this.queueEOSBuffer = true;
            }
            return queueInputBuffer;
        }
        return -1;
    }

    private void onFlush() {
        if (this.disableFlush) {
            return;
        }
        try {
            this.decoder.flush();
            this.bufferInfo = new MediaCodec.BufferInfo();
            releaseOutputBuffer();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.pendingTimes.clear();
        this.queueEOSBuffer = false;
    }

    private void onRelease() {
        if (this.released) {
            return;
        }
        this.released = true;
        releaseOutputBuffer();
        releaseDecoder();
    }

    private boolean onRenderFrame() {
        int i3 = this.lastOutputBufferIndex;
        if (i3 == -1) {
            return false;
        }
        int releaseOutputBuffer = releaseOutputBuffer(i3, true);
        this.lastOutputBufferIndex = -1;
        if (releaseOutputBuffer != 0) {
            return false;
        }
        return true;
    }

    private int onSendBytes(ByteBuffer byteBuffer, long j3) {
        int dequeueInputBuffer = dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            ByteBuffer inputBuffer = getInputBuffer(dequeueInputBuffer);
            if (inputBuffer == null) {
                return -2;
            }
            inputBuffer.clear();
            byteBuffer.position(0);
            inputBuffer.put(byteBuffer);
            int queueInputBuffer = queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.limit(), j3, 0);
            if (queueInputBuffer == 0) {
                this.pendingTimes.add(Long.valueOf(j3));
            }
            return queueInputBuffer;
        }
        return -1;
    }

    private long presentationTime() {
        MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
        if ((bufferInfo.flags & 4) == 0) {
            return bufferInfo.presentationTimeUs;
        }
        return this.lastPresentationTime;
    }

    private int queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        try {
            this.decoder.queueInputBuffer(i3, i16, i17, j3, i18);
            this.disableFlush = false;
            return 0;
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }

    private void releaseAsync(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        decoderThreadCount.getAndIncrement();
        final BaseHandlerThread baseHandlerThread = new BaseHandlerThread("libpag_GPUDecoder_release_decoder");
        baseHandlerThread.start();
        new Handler(baseHandlerThread.getLooper()).post(new Runnable() { // from class: org.light.tavcodec.GPUDecoder.3
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                GPUDecoder.decoderThreadCount.getAndDecrement();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: org.light.tavcodec.GPUDecoder.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        baseHandlerThread.quitSafely();
                    }
                });
            }
        });
    }

    private void releaseDecoder() {
        if (this.decoder == null) {
            return;
        }
        releaseAsync(new Runnable() { // from class: org.light.tavcodec.GPUDecoder.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GPUDecoder.this.decoder.stop();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                try {
                    GPUDecoder.this.decoder.release();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                GPUDecoder.this.decoder = null;
            }
        });
    }

    private void releaseOutputBuffer() {
        int i3 = this.lastOutputBufferIndex;
        if (i3 != -1) {
            releaseOutputBuffer(i3, false);
            this.lastOutputBufferIndex = -1;
        }
    }

    private int releaseOutputBuffer(int i3, boolean z16) {
        try {
            this.decoder.releaseOutputBuffer(i3, z16);
            return 0;
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }
}
