package com.tencent.thumbplayer.core.codec.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thumbplayer.core.codec.capability.TPDrmSecureDeviceBlackWhiteList;
import com.tencent.thumbplayer.core.codec.common.TPDecoderUtils;
import com.tencent.thumbplayer.core.codec.common.TPMediaCodecInstanceCountMgr;
import com.tencent.thumbplayer.core.codec.tmediacodec.TCodecManager;
import com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec;
import com.tencent.thumbplayer.core.codec.tmediacodec.callback.SimpleCodecCallback;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@RequiresApi(api = 16)
/* loaded from: classes26.dex */
public abstract class TPBaseMediaCodecDecoder implements ITPMediaCodecDecoder {
    private static final int DUMP_BYTE_BUFFER_BYTES = 100;
    private static final int DUMP_ONE_LINE_BYTES = 20;
    private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
    private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 2000;
    private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 2000;
    private static final int MSG_FLUSH = 1002;
    private static final int MSG_RELEASE = 1003;
    private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
    private static final String MSG_RELEASE_OUTPUT_BUFFER_INDEX_KEY = "index";
    private static final String MSG_RELEASE_OUTPUT_BUFFER_RENDER_KEY = "render";
    private static final String MSG_RELEASE_OUTPUT_BUFFER_RENDER_TIME_NS_KEY = "renderTimestampNs";
    private static final int MSG_SET_OUTPUT_SURFACE = 1001;
    private static boolean sTMediaCodecInited = false;
    protected int mCodecId;
    private TMediaCodec mCodec = null;
    protected Surface mSurface = null;
    protected boolean mStarted = false;
    private TPFrameInfo mFrameInfo = new TPFrameInfo();
    private boolean mEnableSetOutputSurfaceApi = false;
    private boolean mEnableReleaseOutputBufferWithTimestamp = false;
    private boolean mDisableMediaDrmHWSecureComponent = false;
    private MediaCodec.CryptoInfo mCryptoInfo = null;
    protected MediaCrypto mMediaCrypto = null;
    private byte[] mMediaDrmSessionId = null;
    private String mMediaDrmUUID = "";
    protected boolean mEnableAsyncMode = false;
    private HandlerThread mDecodeThread = null;
    private AsyncDecodeHandler mDecoderHandler = null;
    private BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
    private BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
    private boolean mRestartCodecOnException = false;
    protected int mDrmType = -1;
    private boolean mEnableAudioPassThrough = false;
    protected boolean mEnableMediaCodecReuse = false;
    private final Object mThreadLock = new Object();
    private int mHandlerResult = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class AsyncDecodeHandler extends Handler {
        AsyncDecodeHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int onReleaseOutputBuffer;
            synchronized (TPBaseMediaCodecDecoder.this.mThreadLock) {
                switch (message.what) {
                    case 1000:
                        onReleaseOutputBuffer = TPBaseMediaCodecDecoder.this.onReleaseOutputBuffer(message.getData());
                        break;
                    case 1001:
                        onReleaseOutputBuffer = TPBaseMediaCodecDecoder.this.onSetOutputSurface((Surface) message.obj);
                        break;
                    case 1002:
                        onReleaseOutputBuffer = TPBaseMediaCodecDecoder.this.onFlush();
                        break;
                    case 1003:
                        onReleaseOutputBuffer = TPBaseMediaCodecDecoder.this.onRelease();
                        break;
                    default:
                        onReleaseOutputBuffer = 0;
                        break;
                }
                TPBaseMediaCodecDecoder.this.handleMessageComplete(onReleaseOutputBuffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 21)
    /* loaded from: classes26.dex */
    public class BufferCallback extends TMediaCodec.Callback {
        BufferCallback() {
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec.Callback
        public void onError(@NonNull TMediaCodec tMediaCodec, @NonNull MediaCodec.CodecException codecException) {
            TPNativeLog.printLog(0, TPBaseMediaCodecDecoder.this.getLogTag(), "onError: " + TPBaseMediaCodecDecoder.this.getStackTrace(codecException));
            TPBaseMediaCodecDecoder.this.handleRelease();
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec.Callback
        public void onInputBufferAvailable(@NonNull TMediaCodec tMediaCodec, int i3) {
            try {
                TPBaseMediaCodecDecoder.this.mInputQueue.put(Integer.valueOf(i3));
            } catch (Exception e16) {
                TPNativeLog.printLog(1, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e16));
            }
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo) {
            try {
                TPFrameInfo tPFrameInfo = new TPFrameInfo();
                tPFrameInfo.errCode = 0;
                tPFrameInfo.bufferIndex = i3;
                tPFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                TPBaseMediaCodecDecoder.this.processOutputBuffer(tMediaCodec, i3, bufferInfo, tPFrameInfo);
                TPBaseMediaCodecDecoder.this.mOutputQueue.put(tPFrameInfo);
            } catch (Exception e16) {
                TPNativeLog.printLog(1, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(e16));
            }
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec.Callback
        public void onOutputFormatChanged(@NonNull TMediaCodec tMediaCodec, @NonNull MediaFormat mediaFormat) {
            TPBaseMediaCodecDecoder.this.processOutputFormatChanged(mediaFormat);
        }
    }

    public TPBaseMediaCodecDecoder(int i3) {
        this.mCodecId = i3;
        initTMediaCodec();
    }

    private void bufferSizeCheck(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() < bArr.length) {
            TPNativeLog.printLog(0, getLogTag(), "decodeAsync, not enough space, byteBuffer.remaining:" + byteBuffer.remaining() + ", buffer size:" + bArr.length);
            try {
                dumpByteArray(bArr, 0, 100, 20);
            } catch (Exception e16) {
                TPNativeLog.printLog(0, getLogTag(), e16.toString());
            }
        }
    }

    @Nullable
    private UUID convertUUID(String str) {
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e16) {
            TPNativeLog.printLog(0, e16.getMessage());
            return null;
        }
    }

    @RequiresApi(api = 21)
    private int decodeAsync(byte[] bArr, boolean z16, long j3, boolean z17) {
        int i3;
        int i16;
        Integer poll = this.mInputQueue.poll();
        if (poll == null) {
            return 1;
        }
        try {
            ByteBuffer inputBuffer = this.mCodec.getInputBuffer(poll.intValue());
            if (inputBuffer != null) {
                bufferSizeCheck(inputBuffer, bArr);
                inputBuffer.put(bArr);
            }
            if (z17 && this.mCryptoInfo != null) {
                TMediaCodec tMediaCodec = this.mCodec;
                int intValue = poll.intValue();
                MediaCodec.CryptoInfo cryptoInfo = this.mCryptoInfo;
                if (z16) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                tMediaCodec.queueSecureInputBuffer(intValue, 0, cryptoInfo, j3, i16);
            } else {
                TMediaCodec tMediaCodec2 = this.mCodec;
                int intValue2 = poll.intValue();
                int length = bArr.length;
                if (z16) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                tMediaCodec2.queueInputBuffer(intValue2, 0, length, j3, i3);
            }
            return 0;
        } catch (Exception e16) {
            return onMediaCodecException(e16);
        }
    }

    private TPFrameInfo dequeueOutputBufferAsync() {
        this.mFrameInfo.errCode = 1;
        TPFrameInfo poll = this.mOutputQueue.poll();
        if (poll == null) {
            return this.mFrameInfo;
        }
        return poll;
    }

    private void dumpByteArray(byte[] bArr, int i3, int i16, int i17) throws IllegalArgumentException {
        if (bArr != null && i3 >= 0 && i16 > 0 && i3 < bArr.length && i3 < i16 && i17 > 0) {
            if (bArr.length <= i16) {
                i16 = bArr.length;
            }
            int min = Math.min(i16 - i3, 100) + i3;
            StringBuilder sb5 = new StringBuilder();
            TPNativeLog.printLog(2, getLogTag(), "dumpByteArray begin:");
            int i18 = 0;
            while (i3 < min) {
                String hexString = Integer.toHexString(bArr[i3] & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                sb5.append(hexString.toUpperCase());
                i18++;
                if (i18 % i17 == 0) {
                    TPNativeLog.printLog(2, getLogTag(), sb5.toString());
                    sb5.setLength(0);
                } else {
                    sb5.append(" ");
                }
                i3++;
            }
            TPNativeLog.printLog(2, getLogTag(), "dumpByteArray end.");
            return;
        }
        throw new IllegalArgumentException();
    }

    private void exitDecodeThread() {
        HandlerThread handlerThread = this.mDecodeThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.mDecodeThread.join();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }

    private int flushAsync() {
        TPNativeLog.printLog(2, getLogTag(), "flushAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1002;
        return waitingForHandleMessage(obtainMessage);
    }

    private int handleFlush() {
        TPNativeLog.printLog(2, getLogTag(), "handleFlush: ");
        TMediaCodec tMediaCodec = this.mCodec;
        if (tMediaCodec == null) {
            return 104;
        }
        try {
            tMediaCodec.flush();
            return 0;
        } catch (Exception e16) {
            return onMediaCodecException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessageComplete(int i3) {
        this.mHandlerResult = i3;
        this.mThreadLock.notify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int handleRelease() {
        TMediaCodec tMediaCodec = this.mCodec;
        if (tMediaCodec == null) {
            return 101;
        }
        boolean z16 = false;
        this.mStarted = false;
        try {
            try {
                tMediaCodec.stop();
                if (!needSkipReleaseWhenStopError(false)) {
                    this.mCodec.release();
                }
                TPMediaCodecInstanceCountMgr.sharedInstance().deregisterOneDecoder(this.mCodec.getCodecName());
                this.mCodec.release();
                this.mCodec = null;
                return 0;
            } catch (Exception e16) {
                TPNativeLog.printLog(0, getLogTag(), "stop: failed!" + getStackTrace(e16));
                if (e16 instanceof MediaCodec.CodecException) {
                    z16 = true;
                }
                if (!needSkipReleaseWhenStopError(z16)) {
                    this.mCodec.release();
                }
                TPMediaCodecInstanceCountMgr.sharedInstance().deregisterOneDecoder(this.mCodec.getCodecName());
                this.mCodec.release();
                this.mCodec = null;
                return 3;
            }
        } catch (Throwable th5) {
            if (!needSkipReleaseWhenStopError(false)) {
                this.mCodec.release();
            }
            TPMediaCodecInstanceCountMgr.sharedInstance().deregisterOneDecoder(this.mCodec.getCodecName());
            this.mCodec.release();
            this.mCodec = null;
            throw th5;
        }
    }

    private int handleReleaseOutputBuffer(int i3, boolean z16, long j3) {
        TMediaCodec tMediaCodec = this.mCodec;
        if (tMediaCodec != null && i3 >= 0) {
            try {
                if (this.mEnableReleaseOutputBufferWithTimestamp && z16) {
                    tMediaCodec.releaseOutputBuffer(i3, j3);
                    return 0;
                }
                tMediaCodec.releaseOutputBuffer(i3, z16);
                return 0;
            } catch (Exception e16) {
                return onMediaCodecException(e16);
            }
        }
        return 3;
    }

    private int handleSetOutputSurface(Surface surface) {
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurface: " + surface);
        Surface surface2 = this.mSurface;
        if (surface2 == surface) {
            TPNativeLog.printLog(1, getLogTag(), "setOutputSurface: set the same surface.");
            return 0;
        }
        this.mSurface = surface;
        if (this.mCodec == null) {
            return 0;
        }
        if (surface2 != null && surface != null) {
            try {
                if (surface.isValid() && this.mEnableSetOutputSurfaceApi) {
                    this.mCodec.setOutputSurface(surface);
                    return 0;
                }
            } catch (Exception e16) {
                TPNativeLog.printLog(0, getLogTag(), "setOutputSurface onMediaCodecException:\n" + getStackTrace(e16));
                return 3;
            }
        }
        return 3;
    }

    private int handleSignalEndOfStream(int i3) {
        try {
            this.mCodec.queueInputBuffer(i3, 0, 0, 0L, 4);
            return 0;
        } catch (Exception e16) {
            TPNativeLog.printLog(0, getLogTag(), "handleSignalEndOfStream: failed!" + getStackTrace(e16));
            return 3;
        }
    }

    private boolean initMediaCodecInternal() {
        boolean z16;
        boolean z17;
        boolean z18;
        try {
            List<String> mimeCandidates = getMimeCandidates();
            boolean z19 = false;
            String str = null;
            String str2 = null;
            for (int i3 = 0; i3 < mimeCandidates.size() && str == null; i3++) {
                str2 = mimeCandidates.get(i3);
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec with mime:" + str2 + " mDrmType:" + this.mDrmType);
                MediaCrypto mediaCrypto = this.mMediaCrypto;
                if (mediaCrypto != null) {
                    z18 = mediaCrypto.requiresSecureDecoderComponent(str2);
                } else {
                    z18 = false;
                }
                if (z18 && (this.mDisableMediaDrmHWSecureComponent || TPDrmSecureDeviceBlackWhiteList.isCurrentDeviceInDrmSecureComponentBlackList(this.mDrmType))) {
                    TPNativeLog.printLog(2, getLogTag(), "Device " + TPSystemInfo.getDeviceName() + " DrmType " + this.mDrmType + " fallback to L3.");
                    z19 = false;
                } else {
                    z19 = z18;
                }
                str = getCodecName(str2, z19);
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec got codecName:" + str + " secureComponent " + z19);
            }
            if ("audio/vnd.dts".equals(str2)) {
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec current mime type:" + str2 + " is audio dts, need set input timeout to 0!");
                MEDIA_CODEC_INPUT_TIMEOUT_US = 0L;
                MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0L;
            }
            if (!TextUtils.isEmpty(str)) {
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec by name: " + str);
                this.mCodec = TMediaCodec.createByCodecName(str);
            } else if (!TextUtils.isEmpty(str2)) {
                TPNativeLog.printLog(2, getLogTag(), "initMediaCodec by mimeType: " + str2);
                this.mCodec = TMediaCodec.createDecoderByType(str2);
            } else {
                TPNativeLog.printLog(0, getLogTag(), "initMediaCodec failed, codecName and mimeType is null");
                return false;
            }
            TMediaCodec tMediaCodec = this.mCodec;
            if (this.mEnableMediaCodecReuse && !this.mEnableAsyncMode) {
                z16 = true;
            } else {
                z16 = false;
            }
            tMediaCodec.setReuseEnable(z16);
            this.mCodec.setCodecCallback(new SimpleCodecCallback() { // from class: com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder.2
                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.callback.SimpleCodecCallback, com.tencent.thumbplayer.core.codec.tmediacodec.callback.CodecCallback
                public void onReuseCodecAPIException(String str3, Throwable th5) {
                    super.onReuseCodecAPIException(str3, th5);
                    TPMediaCodecManager.onMediaCodecException(TPBaseMediaCodecDecoder.this.mCodecId, str3);
                }

                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.callback.SimpleCodecCallback, com.tencent.thumbplayer.core.codec.tmediacodec.callback.CodecCallback
                public void onStarted(Boolean bool, String str3) {
                    super.onStarted(bool, str3);
                    TPMediaCodecManager.onMediaCodecReady(TPBaseMediaCodecDecoder.this.mCodecId, str3);
                }
            });
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codec name: " + str);
            if (this.mEnableAsyncMode) {
                TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode\uff01");
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MediaCodecThread");
                this.mDecodeThread = baseHandlerThread;
                baseHandlerThread.start();
                this.mDecoderHandler = new AsyncDecodeHandler(this.mDecodeThread.getLooper());
                this.mCodec.setCallback(new BufferCallback(), this.mDecoderHandler);
            }
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 1);
            configCodec(this.mCodec, str2);
            TPMediaCodecInstanceCountMgr.sharedInstance().registerOneDecoder(this.mCodec.getCodecName());
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 2);
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 3);
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec, start codec start");
            this.mCodec.start();
            TPNativeLog.printLog(2, getLogTag(), "initMediaCodec, start codec finished");
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 4);
            this.mStarted = true;
            if (this.mDrmType != -1) {
                if (TPDecoderUtils.getDecoderName(str2, true) != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                TPMediaDrmInfo tPMediaDrmInfo = new TPMediaDrmInfo();
                tPMediaDrmInfo.supportSecureDecoder = z17;
                tPMediaDrmInfo.supportSecureDecrypt = z19;
                tPMediaDrmInfo.componentName = str;
                tPMediaDrmInfo.drmType = this.mDrmType;
                TPNativeLog.printLog(2, getLogTag(), "DRM Info: supportSecureDecoder: " + tPMediaDrmInfo.supportSecureDecoder + " supportSecureDecrypt:" + tPMediaDrmInfo.supportSecureDecrypt + " componentName: " + tPMediaDrmInfo.componentName + " drmType: " + tPMediaDrmInfo.drmType);
                TPMediaCodecManager.onMediaDrmInfo(this.mCodecId, tPMediaDrmInfo);
            }
            return true;
        } catch (Exception e16) {
            TPMediaCodecManager.onMediaCodecReportEvent(this.mCodecId, 4);
            TPNativeLog.printLog(0, getLogTag(), getStackTrace(e16));
            return false;
        }
    }

    private static synchronized void initTMediaCodec() {
        synchronized (TPBaseMediaCodecDecoder.class) {
            if (sTMediaCodecInited) {
                return;
            }
            TCodecManager.init();
            TCodecManager.getInstance().setLogEnable(true);
            TCodecManager.getInstance().setLogProxy(new ILogProxy() { // from class: com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder.1
                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
                public void d(@NonNull String str, @NonNull String str2) {
                    TPNativeLog.printLog(3, str, str2);
                }

                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
                public void e(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
                    TPNativeLog.printLog(0, str, str2);
                }

                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
                public void i(@NonNull String str, @NonNull String str2) {
                    TPNativeLog.printLog(2, str, str2);
                }

                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
                public void v(@NonNull String str, @NonNull String str2) {
                    TPNativeLog.printLog(4, str, str2);
                }

                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
                public void w(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
                    TPNativeLog.printLog(1, str, str2);
                }
            });
            sTMediaCodecInited = true;
        }
    }

    private boolean needSkipReleaseWhenStopError(boolean z16) {
        if (z16 && !TextUtils.isEmpty(TPSystemInfo.getDeviceName()) && TPSystemInfo.getDeviceName().toLowerCase().startsWith("meizu") && Build.VERSION.SDK_INT == 30) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onFlush() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        int handleFlush = handleFlush();
        this.mCodec.start();
        return handleFlush;
    }

    private int onMediaCodecException(Exception exc) {
        TPNativeLog.printLog(0, getLogTag(), "onMediaCodecException!" + getStackTrace(exc));
        resetFrameInfo();
        processMediaCodecException(exc);
        if (this.mRestartCodecOnException) {
            initMediaCodecInternal();
            return 4;
        }
        handleRelease();
        return 103;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onRelease() {
        this.mInputQueue.clear();
        this.mOutputQueue.clear();
        return handleRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onReleaseOutputBuffer(Bundle bundle) {
        if (bundle == null) {
            return 3;
        }
        return handleReleaseOutputBuffer(bundle.getInt("index"), bundle.getBoolean("render"), bundle.getLong(MSG_RELEASE_OUTPUT_BUFFER_RENDER_TIME_NS_KEY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onSetOutputSurface(Surface surface) {
        return handleSetOutputSurface(surface);
    }

    private int queueInputBuffer(byte[] bArr, long j3, boolean z16) {
        MediaCodec.CryptoInfo cryptoInfo;
        try {
            ByteBuffer[] inputBuffers = this.mCodec.getInputBuffers();
            int dequeueInputBuffer = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                bufferSizeCheck(byteBuffer, bArr);
                byteBuffer.put(bArr);
                if (z16 && (cryptoInfo = this.mCryptoInfo) != null) {
                    this.mCodec.queueSecureInputBuffer(dequeueInputBuffer, 0, cryptoInfo, j3, 0);
                } else {
                    this.mCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j3, 0);
                }
                return 0;
            }
            if (dequeueInputBuffer == -1) {
                return 1;
            }
            return 103;
        } catch (Exception e16) {
            return onMediaCodecException(e16);
        }
    }

    private int releaseAsync() {
        TPNativeLog.printLog(2, getLogTag(), "releaseAsync: ");
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1003;
        int waitingForHandleMessage = waitingForHandleMessage(obtainMessage);
        exitDecodeThread();
        return waitingForHandleMessage;
    }

    private int releaseOutputBufferAsync(int i3, boolean z16, long j3) {
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1000;
        Bundle bundle = new Bundle();
        bundle.putInt("index", i3);
        bundle.putBoolean("render", z16);
        bundle.putLong(MSG_RELEASE_OUTPUT_BUFFER_RENDER_TIME_NS_KEY, j3);
        obtainMessage.setData(bundle);
        return waitingForHandleMessage(obtainMessage);
    }

    private void resetFrameInfo() {
        TPFrameInfo tPFrameInfo = this.mFrameInfo;
        tPFrameInfo.bufferIndex = -1000;
        tPFrameInfo.ptsUs = -1L;
        tPFrameInfo.renderTimestampNs = -1L;
        tPFrameInfo.data = null;
        tPFrameInfo.errCode = 103;
    }

    private MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    private void setMediaCodecParams(Bundle bundle) {
        if (this.mCodec != null && !bundle.isEmpty()) {
            try {
                TPNativeLog.printLog(2, getLogTag(), "setMediaCodecParams: " + bundle.toString());
                this.mCodec.setParameters(bundle);
            } catch (Exception unused) {
                TPNativeLog.printLog(1, getLogTag(), "setMediaCodecParams: " + bundle.toString() + " failed.");
            }
        }
    }

    private int setOutputSurfaceAsync(Surface surface) {
        TPNativeLog.printLog(2, getLogTag(), "setOutputSurfaceAsync: " + surface);
        Message obtainMessage = this.mDecoderHandler.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.obj = surface;
        return waitingForHandleMessage(obtainMessage);
    }

    private int signalEndOfStreamAsync() {
        Integer poll = this.mInputQueue.poll();
        if (poll == null) {
            return 1;
        }
        return handleSignalEndOfStream(poll.intValue());
    }

    private int waitingForHandleMessage(Message message) {
        synchronized (this.mThreadLock) {
            message.sendToTarget();
            try {
                LockMethodProxy.wait(this.mThreadLock);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        return this.mHandlerResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buildMediaCryptoIfNeeded() {
        UUID convertUUID;
        if (this.mMediaDrmSessionId == null || this.mMediaDrmUUID.isEmpty() || (convertUUID = convertUUID(this.mMediaDrmUUID)) == null) {
            return;
        }
        try {
            this.mMediaCrypto = new MediaCrypto(convertUUID, this.mMediaDrmSessionId);
        } catch (MediaCryptoException e16) {
            TPNativeLog.printLog(0, e16.getMessage());
        }
    }

    abstract void configCodec(@NonNull TMediaCodec tMediaCodec, @NonNull String str);

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int decode(byte[] bArr, boolean z16, long j3, boolean z17) {
        if (this.mStarted && this.mCodec != null) {
            if (this.mEnableAsyncMode) {
                return decodeAsync(bArr, z16, j3, z17);
            }
            return queueInputBuffer(bArr, j3, z17);
        }
        return 101;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public TPFrameInfo dequeueOutputBuffer() {
        if (this.mCodec == null) {
            return this.mFrameInfo;
        }
        resetFrameInfo();
        if (this.mEnableAsyncMode) {
            return dequeueOutputBufferAsync();
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer(bufferInfo, MEDIA_CODEC_OUTPUT_TIMEOUT_US);
            if (dequeueOutputBuffer >= 0) {
                int i3 = bufferInfo.flags;
                if (i3 == 4) {
                    TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM");
                    this.mFrameInfo.errCode = 2;
                } else if (i3 == 2 && this.mEnableAudioPassThrough) {
                    TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
                    TPFrameInfo tPFrameInfo = this.mFrameInfo;
                    tPFrameInfo.bufferIndex = dequeueOutputBuffer;
                    tPFrameInfo.ptsUs = bufferInfo.presentationTimeUs;
                    processOutputConfigData(this.mCodec, dequeueOutputBuffer, bufferInfo, tPFrameInfo);
                } else {
                    TPFrameInfo tPFrameInfo2 = this.mFrameInfo;
                    tPFrameInfo2.bufferIndex = dequeueOutputBuffer;
                    tPFrameInfo2.ptsUs = bufferInfo.presentationTimeUs;
                    tPFrameInfo2.renderTimestampNs = System.nanoTime();
                    TPFrameInfo tPFrameInfo3 = this.mFrameInfo;
                    tPFrameInfo3.errCode = 0;
                    processOutputBuffer(this.mCodec, dequeueOutputBuffer, bufferInfo, tPFrameInfo3);
                }
            } else if (dequeueOutputBuffer == -2) {
                processOutputFormatChanged(this.mCodec.getOutputFormat());
                this.mFrameInfo.errCode = 1;
            } else if (dequeueOutputBuffer == -1) {
                this.mFrameInfo.errCode = 1;
            } else if (dequeueOutputBuffer == -3) {
                TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
                this.mFrameInfo.errCode = 1;
            } else if (bufferInfo.flags == 4) {
                TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM!");
                this.mFrameInfo.errCode = 2;
            } else {
                TPNativeLog.printLog(0, getLogTag(), "dequeueOutputBuffer: TP_ERROR_DECODE_FAILED! index = " + dequeueOutputBuffer);
                this.mFrameInfo.errCode = 103;
            }
            return this.mFrameInfo;
        } catch (Exception e16) {
            this.mFrameInfo.errCode = onMediaCodecException(e16);
            return this.mFrameInfo;
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int flush() {
        TPNativeLog.printLog(2, getLogTag(), "flush: ");
        if (this.mCodec == null) {
            return 104;
        }
        if (this.mEnableAsyncMode) {
            return flushAsync();
        }
        return handleFlush();
    }

    abstract String getCodecName(@NonNull String str, boolean z16);

    abstract String getLogTag();

    abstract List<String> getMimeCandidates();

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStackTrace(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    abstract void processMediaCodecException(Exception exc);

    abstract void processOutputBuffer(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo, @NonNull TPFrameInfo tPFrameInfo);

    abstract void processOutputConfigData(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo, @NonNull TPFrameInfo tPFrameInfo);

    abstract void processOutputFormatChanged(@NonNull MediaFormat mediaFormat);

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int release() {
        if (this.mEnableAsyncMode) {
            return releaseAsync();
        }
        return handleRelease();
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int releaseOutputBuffer(int i3, boolean z16, long j3) {
        if (this.mCodec != null && i3 >= 0) {
            if (this.mEnableAsyncMode) {
                return releaseOutputBufferAsync(i3, z16, j3);
            }
            return handleReleaseOutputBuffer(i3, z16, j3);
        }
        return 3;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public void setCryptoInfo(int i3, @NonNull int[] iArr, @NonNull int[] iArr2, @NonNull byte[] bArr, @NonNull byte[] bArr2, int i16, int i17, int i18) {
        if (this.mCryptoInfo == null) {
            this.mCryptoInfo = new MediaCodec.CryptoInfo();
        }
        this.mCryptoInfo.set(i3, iArr, iArr2, bArr, bArr2, i16);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mCryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(i17, i18));
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int setOperateRate(float f16) {
        if (this.mCodec != null) {
            try {
                TPNativeLog.printLog(2, getLogTag(), "setOperateRate: " + f16);
                Bundle bundle = new Bundle();
                bundle.putShort("priority", (short) 0);
                bundle.putFloat("operating-rate", f16);
                this.mCodec.setParameters(bundle);
            } catch (Exception unused) {
                TPNativeLog.printLog(1, getLogTag(), "setOperateRate: " + f16 + " failed.");
            }
        }
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int setOutputSurface(Surface surface) {
        if (this.mEnableAsyncMode) {
            return setOutputSurfaceAsync(surface);
        }
        return handleSetOutputSurface(surface);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamBool(int i3, boolean z16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 7) {
                            if (i3 != 8) {
                                TPNativeLog.printLog(1, getLogTag(), "Unknown paramKey: " + i3);
                                return false;
                            }
                            this.mDisableMediaDrmHWSecureComponent = z16;
                        } else {
                            this.mEnableReleaseOutputBufferWithTimestamp = z16;
                        }
                    } else {
                        this.mEnableMediaCodecReuse = z16;
                    }
                } else {
                    this.mEnableAudioPassThrough = z16;
                    TPNativeLog.printLog(2, getLogTag(), "BOOL_SET_IS_AUDIO_PASSTHROUGH mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
                }
            } else if (!this.mStarted) {
                this.mEnableAsyncMode = z16;
            } else {
                TPNativeLog.printLog(1, getLogTag(), "BOOL_ENABLE_ASYNC_MODE must setup before started!");
            }
        } else {
            this.mEnableSetOutputSurfaceApi = z16;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamBytes(int i3, byte[] bArr) {
        if (i3 == 350) {
            this.mMediaDrmSessionId = bArr;
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamInt(int i3, int i16) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamLong(int i3, long j3) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamObject(int i3, Object obj) {
        if (i3 == 300) {
            this.mMediaCrypto = (MediaCrypto) obj;
            return true;
        }
        if (i3 == 9) {
            setMediaCodecParams((Bundle) obj);
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamString(int i3, String str) {
        if (i3 == 351) {
            this.mMediaDrmUUID = str;
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int signalEndOfStream() {
        TPNativeLog.printLog(2, getLogTag(), "signalEndOfStream: ");
        TMediaCodec tMediaCodec = this.mCodec;
        if (tMediaCodec == null) {
            return 3;
        }
        if (this.mEnableAsyncMode) {
            return signalEndOfStreamAsync();
        }
        int dequeueInputBuffer = tMediaCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
        if (dequeueInputBuffer >= 0) {
            return handleSignalEndOfStream(dequeueInputBuffer);
        }
        if (dequeueInputBuffer != -1) {
            return 3;
        }
        return 1;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean startDecoder() {
        return initMediaCodecInternal();
    }
}
