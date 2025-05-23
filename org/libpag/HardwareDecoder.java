package org.libpag;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.libpag.d;

/* compiled from: P */
/* loaded from: classes29.dex */
class HardwareDecoder {

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f423674f = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    private MediaCodec f423676b;

    /* renamed from: a, reason: collision with root package name */
    private VideoSurface f423675a = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f423677c = true;

    /* renamed from: d, reason: collision with root package name */
    private MediaCodec.BufferInfo f423678d = new MediaCodec.BufferInfo();

    /* renamed from: e, reason: collision with root package name */
    private int f423679e = -1;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class a implements d.b {

        /* renamed from: a, reason: collision with root package name */
        private MediaCodec f423680a;

        /* renamed from: b, reason: collision with root package name */
        private long f423681b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MediaFormat f423682c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoSurface f423683d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MediaCodec[] f423684e;

        a(MediaFormat mediaFormat, VideoSurface videoSurface, MediaCodec[] mediaCodecArr) {
            this.f423682c = mediaFormat;
            this.f423683d = videoSurface;
            this.f423684e = mediaCodecArr;
        }

        @Override // org.libpag.d.b
        public void a(boolean z16) {
            if (z16 && this.f423680a != null) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f423681b;
                try {
                    this.f423680a.stop();
                } catch (Exception unused) {
                }
                try {
                    this.f423680a.release();
                } catch (Exception unused2) {
                }
                this.f423680a = null;
                this.f423683d.a();
                new RuntimeException("init decoder timeout. cost: " + uptimeMillis + "ms").printStackTrace();
            }
            if (!z16) {
                this.f423684e[0] = this.f423680a;
            }
            HardwareDecoder.f423674f.getAndDecrement();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f423681b = SystemClock.uptimeMillis();
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.f423682c.getString("mime"));
                this.f423680a = createDecoderByType;
                createDecoderByType.configure(this.f423682c, this.f423683d.getInputSurface(), (MediaCrypto) null, 0);
                this.f423680a.start();
            } catch (Exception unused) {
                Log.e("HardwareDecoder", "create and config hardware decoder have exception");
                MediaCodec mediaCodec = this.f423680a;
                if (mediaCodec != null) {
                    mediaCodec.release();
                    this.f423680a = null;
                    this.f423683d.a();
                }
            }
        }
    }

    HardwareDecoder() {
    }

    private static HardwareDecoder Create(MediaFormat mediaFormat) {
        VideoSurface a16;
        AtomicInteger atomicInteger = f423674f;
        if (atomicInteger.get() >= 10 || (a16 = VideoSurface.a(mediaFormat.getInteger("width"), mediaFormat.getInteger("height"))) == null) {
            return null;
        }
        atomicInteger.getAndIncrement();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("libpag_GPUDecoder_init_decoder");
        try {
            baseHandlerThread.start();
            MediaCodec[] mediaCodecArr = {null};
            boolean a17 = new d(baseHandlerThread.getLooper()).a(new a(mediaFormat, a16, mediaCodecArr), 2000L);
            baseHandlerThread.quitSafely();
            if (!a17) {
                return null;
            }
            HardwareDecoder hardwareDecoder = new HardwareDecoder();
            hardwareDecoder.f423675a = a16;
            hardwareDecoder.f423676b = mediaCodecArr[0];
            return hardwareDecoder;
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            f423674f.getAndDecrement();
            return null;
        }
    }

    private int dequeueInputBuffer() {
        try {
            return this.f423676b.dequeueInputBuffer(1000L);
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private int dequeueOutputBuffer() {
        try {
            return this.f423676b.dequeueOutputBuffer(this.f423678d, 1000L);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private ByteBuffer getInputBuffer(int i3) {
        try {
            return this.f423676b.getInputBuffer(i3);
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private VideoSurface getVideoSurface() {
        return this.f423675a;
    }

    private int onDecodeFrame() {
        releaseOutputBuffer();
        try {
            int dequeueOutputBuffer = dequeueOutputBuffer();
            if ((this.f423678d.flags & 4) != 0) {
                if (dequeueOutputBuffer >= 0) {
                    this.f423679e = dequeueOutputBuffer;
                    return -3;
                }
                return -3;
            }
            if (dequeueOutputBuffer >= 0) {
                this.f423679e = dequeueOutputBuffer;
            }
            if (this.f423679e == -1) {
                return -1;
            }
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }

    private int onEndOfStream() {
        int dequeueInputBuffer = dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            return queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        }
        return -1;
    }

    private void onFlush() {
        if (this.f423677c) {
            return;
        }
        try {
            this.f423676b.flush();
            this.f423678d = new MediaCodec.BufferInfo();
            this.f423679e = -1;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void onRelease() {
        if (this.f423676b == null) {
            return;
        }
        releaseOutputBuffer();
        try {
            this.f423676b.stop();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            this.f423676b.release();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        this.f423676b = null;
        this.f423675a.a();
    }

    private boolean onRenderFrame() {
        int i3 = this.f423679e;
        if (i3 == -1) {
            return false;
        }
        int releaseOutputBuffer = releaseOutputBuffer(i3, true);
        this.f423679e = -1;
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
            return queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.limit(), j3, 0);
        }
        return -1;
    }

    private long presentationTime() {
        return this.f423678d.presentationTimeUs;
    }

    private int queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        try {
            this.f423676b.queueInputBuffer(i3, i16, i17, j3, i18);
            this.f423677c = false;
            return 0;
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }

    private void releaseOutputBuffer() {
        int i3 = this.f423679e;
        if (i3 != -1) {
            releaseOutputBuffer(i3, false);
            this.f423679e = -1;
        }
    }

    private int releaseOutputBuffer(int i3, boolean z16) {
        try {
            this.f423676b.releaseOutputBuffer(i3, z16);
            return 0;
        } catch (Error | Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }
}
