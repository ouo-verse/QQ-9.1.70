package com.tencent.avcore.jni.codec;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class AndroidCodec extends AndroidCodecBase {
    static IPatchRedirector $redirector_ = null;
    public static int DEC_CODEC = 0;
    public static int ENC_CODEC = 0;
    private static final int TIMEOUT_CREATE_START_CODEC_MS = 500;
    private static final int TIMEOUT_STOP_RELEASE_FLUSH_CODEC_MS = 200;
    private static final int TIMEOUT_US = 33000;
    protected static boolean fInvokeAPILevel21;
    protected static Method fgetInputBuffer21;
    protected static Method fgetOutputBuffer21;
    protected static Method fgetOutputFormat21;
    protected static Method fsetParameters19;
    private boolean hadCallHwCodecFuncTimeOut;
    protected ByteBuffer[] inputBuffers;
    private AndroidCodecStatus mAndroidCodecStatus;
    private boolean mCallHwCodcFuncTimeoutFlag;
    protected int mCodecType;
    protected MediaFormat mFormat;
    public boolean mIsSetMediaCodecCallbackSuc;
    protected MediaCodec mMediaCodec;
    protected MediaFormat mOutputFormat;
    protected AndroidCodecStatusCallback mStatusCallback;
    final String mTAG;
    protected ByteBuffer[] outputBuffers;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MediaCodecOperation {
        private static final /* synthetic */ MediaCodecOperation[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MediaCodecOperation kFlush;
        public static final MediaCodecOperation kRelease;
        public static final MediaCodecOperation kStart;
        public static final MediaCodecOperation kStop;
        private final String operationName;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14129);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            MediaCodecOperation mediaCodecOperation = new MediaCodecOperation("kStart", 0, "start");
            kStart = mediaCodecOperation;
            MediaCodecOperation mediaCodecOperation2 = new MediaCodecOperation("kStop", 1, "stop");
            kStop = mediaCodecOperation2;
            MediaCodecOperation mediaCodecOperation3 = new MediaCodecOperation("kFlush", 2, HippyQQPagView.FunctionName.FLUSH);
            kFlush = mediaCodecOperation3;
            MediaCodecOperation mediaCodecOperation4 = new MediaCodecOperation("kRelease", 3, "release");
            kRelease = mediaCodecOperation4;
            $VALUES = new MediaCodecOperation[]{mediaCodecOperation, mediaCodecOperation2, mediaCodecOperation3, mediaCodecOperation4};
        }

        MediaCodecOperation(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.operationName = str2;
            }
        }

        public static MediaCodecOperation valueOf(String str) {
            return (MediaCodecOperation) Enum.valueOf(MediaCodecOperation.class, str);
        }

        public static MediaCodecOperation[] values() {
            return (MediaCodecOperation[]) $VALUES.clone();
        }

        public String getOperationName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.operationName;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14152);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        ENC_CODEC = 1;
        DEC_CODEC = 0;
        fInvokeAPILevel21 = true;
    }

    @Deprecated
    public AndroidCodec() {
        this("unknown");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static boolean checkAPILevel21Valid(String str) {
        invoke21Apis(str);
        return fInvokeAPILevel21;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.avcore.jni.codec.AndroidCodec$3] */
    private Void configureCodecWithTimeOut(MediaCodec mediaCodec, MediaFormat mediaFormat, int i3, long j3) {
        if (j3 <= 0 || j3 >= 500) {
            j3 = 500;
        }
        Callable<Void> init = new Callable<Void>() { // from class: com.tencent.avcore.jni.codec.AndroidCodec.3
            static IPatchRedirector $redirector_;
            private int flag;
            private MediaFormat format;
            private MediaCodec mediaCodec;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AndroidCodec.this);
                }
            }

            public Callable<Void> init(MediaCodec mediaCodec2, MediaFormat mediaFormat2, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Callable) iPatchRedirector.redirect((short) 2, this, mediaCodec2, mediaFormat2, Integer.valueOf(i16));
                }
                this.mediaCodec = mediaCodec2;
                this.format = mediaFormat2;
                this.flag = i16;
                return this;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Void) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                if (this.mediaCodec == null) {
                    AVCoreLog.e(AndroidCodec.this.mTAG, "mMediaCodec null configure " + this.flag);
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                AndroidCodec.this.mMediaCodec.configure(this.format, (Surface) null, (MediaCrypto) null, this.flag);
                long currentTimeMillis2 = System.currentTimeMillis();
                AVCoreLog.e(AndroidCodec.this.mTAG, "mMediaCodec.configure " + this.flag + ", time: " + (currentTimeMillis2 - currentTimeMillis));
                return null;
            }
        }.init(this.mMediaCodec, mediaFormat, i3);
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(init);
        boolean z16 = true;
        try {
            submit.get(j3, TimeUnit.MILLISECONDS);
            z16 = false;
        } catch (TimeoutException unused) {
            this.hadCallHwCodecFuncTimeOut = true;
            AVCoreLog.e(this.mTAG, "mMediaCodec.configure " + i3 + " timeout");
            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorConfigureCodecTimeOut;
            submit.cancel(true);
        } catch (Exception unused2) {
            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorConfigureCodecException;
        }
        newSingleThreadExecutor.shutdown();
        if (z16) {
            if (Build.VERSION.SDK_INT >= 29) {
                stop();
                release();
            }
            this.mMediaCodec = null;
        }
        return null;
    }

    private AndroidCodecStatus getAndroidCodecStatus(MediaCodecOperation mediaCodecOperation, boolean z16, boolean z17) {
        if (z16) {
            if (mediaCodecOperation == MediaCodecOperation.kStart) {
                return AndroidCodecStatus.ErrorStartCodecException;
            }
            if (mediaCodecOperation == MediaCodecOperation.kFlush) {
                return AndroidCodecStatus.ErrorFlushCodecException;
            }
            if (mediaCodecOperation == MediaCodecOperation.kStop) {
                return AndroidCodecStatus.ErrorStopCodecException;
            }
            if (mediaCodecOperation == MediaCodecOperation.kRelease) {
                return AndroidCodecStatus.ErrorReleaseCodecException;
            }
        } else if (z17) {
            if (mediaCodecOperation == MediaCodecOperation.kStart) {
                return AndroidCodecStatus.ErrorStartCodecTimeOut;
            }
            if (mediaCodecOperation == MediaCodecOperation.kFlush) {
                return AndroidCodecStatus.ErrorFlushCodecTimeOut;
            }
            if (mediaCodecOperation == MediaCodecOperation.kStop) {
                return AndroidCodecStatus.ErrorStopCodecTimeOut;
            }
            if (mediaCodecOperation == MediaCodecOperation.kRelease) {
                return AndroidCodecStatus.ErrorReleaseCodecTimeOut;
            }
        }
        return AndroidCodecStatus.OK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void invoke21Apis() {
        invoke21Apis("unknown");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0062  */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.avcore.jni.codec.AndroidCodec$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Void mediaCodecOperationWithTimeOut(MediaCodecOperation mediaCodecOperation, long j3) {
        if (j3 <= 0 || j3 >= 500) {
            j3 = 500;
        }
        Callable<Void> init = new Callable<Void>() { // from class: com.tencent.avcore.jni.codec.AndroidCodec.1
            static IPatchRedirector $redirector_;
            private MediaCodec mediaCodec;
            private MediaCodecOperation operation;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AndroidCodec.this);
                }
            }

            public Callable<Void> init(MediaCodec mediaCodec, MediaCodecOperation mediaCodecOperation2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Callable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaCodec, (Object) mediaCodecOperation2);
                }
                this.mediaCodec = mediaCodec;
                this.operation = mediaCodecOperation2;
                return this;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Void) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                if (this.mediaCodec == null) {
                    AVCoreLog.e(AndroidCodec.this.mTAG, "mMediaCodec null " + this.operation.getOperationName());
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                MediaCodecOperation mediaCodecOperation2 = this.operation;
                if (mediaCodecOperation2 == MediaCodecOperation.kStart) {
                    this.mediaCodec.start();
                } else if (mediaCodecOperation2 == MediaCodecOperation.kFlush) {
                    this.mediaCodec.flush();
                } else if (mediaCodecOperation2 == MediaCodecOperation.kStop) {
                    this.mediaCodec.stop();
                } else if (mediaCodecOperation2 == MediaCodecOperation.kRelease) {
                    this.mediaCodec.release();
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                AVCoreLog.e(AndroidCodec.this.mTAG, "mMediaCodec." + this.operation.getOperationName() + ", time: " + (currentTimeMillis2 - currentTimeMillis));
                return null;
            }
        }.init(this.mMediaCodec, mediaCodecOperation);
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(init);
        boolean z16 = false;
        try {
            submit.get(j3, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            this.hadCallHwCodecFuncTimeOut = true;
            AVCoreLog.e(this.mTAG, "mMediaCodec." + mediaCodecOperation.getOperationName() + " timeout");
            this.mAndroidCodecStatus = getAndroidCodecStatus(mediaCodecOperation, false, true);
            submit.cancel(true);
            z16 = true;
            newSingleThreadExecutor.shutdown();
            if (z16) {
            }
            return null;
        } catch (Exception unused2) {
            this.mAndroidCodecStatus = getAndroidCodecStatus(mediaCodecOperation, true, false);
            z16 = true;
            newSingleThreadExecutor.shutdown();
            if (z16) {
            }
            return null;
        }
        newSingleThreadExecutor.shutdown();
        if (z16) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (mediaCodecOperation != MediaCodecOperation.kStart && mediaCodecOperation != MediaCodecOperation.kFlush) {
                    if (mediaCodecOperation == MediaCodecOperation.kStop && z16) {
                        release();
                    }
                } else {
                    stop();
                    release();
                }
            }
            this.mMediaCodec = null;
        }
        return null;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public boolean checkCallHwCodecFuncTimeOut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.hadCallHwCodecFuncTimeOut;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public synchronized BufferData dequeueDecoderOutputBuffer(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BufferData) iPatchRedirector.redirect((short) 10, (Object) this, j3);
        }
        if (this.mMediaCodec == null) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTAG, "dequeueDecoderOutputBuffer mMediaCodec is null");
            }
            return null;
        }
        BufferData bufferData = new BufferData();
        long j16 = 0;
        while (j16 < j3) {
            long nanoTime = System.nanoTime();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferData.info, 3000L);
            j16 += System.nanoTime() - nanoTime;
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer != -1) {
                        if (dequeueOutputBuffer < 0) {
                            return null;
                        }
                        bufferData.index = dequeueOutputBuffer;
                        try {
                            try {
                                try {
                                    bufferData.buffer = (ByteBuffer) fgetOutputBuffer21.invoke(this.mMediaCodec, Integer.valueOf(dequeueOutputBuffer));
                                    bufferData.format = (MediaFormat) fgetOutputFormat21.invoke(this.mMediaCodec, Integer.valueOf(dequeueOutputBuffer));
                                } catch (IllegalAccessException e16) {
                                    e16.printStackTrace();
                                    bufferData.success = false;
                                    this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueOutputBuffer;
                                }
                            } catch (IllegalArgumentException e17) {
                                e17.printStackTrace();
                                bufferData.success = false;
                                this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueOutputBuffer;
                            }
                        } catch (InvocationTargetException e18) {
                            e18.printStackTrace();
                            bufferData.success = false;
                            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueOutputBuffer;
                        }
                        return bufferData;
                    }
                    bufferData.index = -1;
                    return bufferData;
                }
                bufferData.index = -2;
                MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                this.mOutputFormat = outputFormat;
                if (outputFormat != null) {
                    try {
                        int integer = outputFormat.getInteger("color-format");
                        AndroidCodecStatusCallback androidCodecStatusCallback = this.mStatusCallback;
                        if (androidCodecStatusCallback != null) {
                            androidCodecStatusCallback.onOutputFormatChange(integer);
                        }
                        if (AVCoreLog.isLogColorOrGary()) {
                            AVCoreLog.e(this.mTAG, "dequeueDecoderOutputBuffer New color format " + integer + "[0x" + Integer.toHexString(integer) + "]");
                        }
                    } catch (Exception unused) {
                        if (AVCoreLog.isLogColorOrGary()) {
                            AVCoreLog.e(this.mTAG, "dequeueDecoderOutputBuffer Exception,INFO_OUTPUT_FORMAT_CHANGED");
                        }
                    }
                }
            }
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTAG, "dequeueDecoderOutputBuffer INFO_OUTPUT_BUFFERS_CHANGED");
            }
            this.outputBuffers = this.mMediaCodec.getOutputBuffers();
            bufferData.index = -3;
        }
        return null;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public synchronized BufferData dequeueOutputBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (BufferData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.mMediaCodec == null) {
            return null;
        }
        BufferData bufferData = new BufferData();
        int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferData.info, 33000L);
        if (dequeueOutputBuffer != -3) {
            if (dequeueOutputBuffer != -2) {
                if (dequeueOutputBuffer != -1) {
                    if (AVCoreLog.isLogColorOrGary()) {
                        AVCoreLog.e(this.mTAG, "dequeueOutputBuffer, outIndex[" + dequeueOutputBuffer + "]");
                    }
                    if (dequeueOutputBuffer < 0) {
                        return null;
                    }
                    bufferData.index = dequeueOutputBuffer;
                    try {
                        try {
                            bufferData.buffer = (ByteBuffer) fgetOutputBuffer21.invoke(this.mMediaCodec, Integer.valueOf(dequeueOutputBuffer));
                            bufferData.format = (MediaFormat) fgetOutputFormat21.invoke(this.mMediaCodec, Integer.valueOf(dequeueOutputBuffer));
                        } catch (IllegalAccessException e16) {
                            e16.printStackTrace();
                            bufferData.success = false;
                            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueOutputBuffer;
                        } catch (IllegalArgumentException e17) {
                            e17.printStackTrace();
                            bufferData.success = false;
                            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueOutputBuffer;
                        }
                    } catch (InvocationTargetException e18) {
                        e18.printStackTrace();
                        bufferData.success = false;
                        this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueOutputBuffer;
                    }
                    return bufferData;
                }
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.e(this.mTAG, "dequeueOutputBuffer, INFO_TRY_AGAIN_LATER");
                }
                bufferData.index = -1;
                return bufferData;
            }
            bufferData.index = -2;
            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            this.mOutputFormat = outputFormat;
            if (outputFormat != null) {
                if (this.mCodecType == DEC_CODEC) {
                    try {
                        int integer = outputFormat.getInteger("color-format");
                        if (AVCoreLog.isLogColorOrGary()) {
                            AVCoreLog.e(this.mTAG, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, colorformat[" + integer + "|0x" + Integer.toHexString(integer).toUpperCase() + "]");
                        }
                    } catch (Exception e19) {
                        if (AVCoreLog.isLogColorOrGary()) {
                            AVCoreLog.e(this.mTAG, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, Exception", e19);
                        }
                    }
                } else if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.e(this.mTAG, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, CodecType[" + this.mCodecType + "]");
                }
            } else if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTAG, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, null");
            }
        }
        this.outputBuffers = this.mMediaCodec.getOutputBuffers();
        bufferData.index = -3;
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.e(this.mTAG, "dequeueOutputBuffer, INFO_OUTPUT_BUFFERS_CHANGED");
        }
        return null;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public void flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            if (this.mCallHwCodcFuncTimeoutFlag) {
                mediaCodecOperationWithTimeOut(MediaCodecOperation.kFlush, 200L);
            } else {
                mediaCodec.flush();
            }
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public BufferData getInputBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BufferData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.mMediaCodec == null) {
            return null;
        }
        BufferData bufferData = new BufferData();
        int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(33000L);
        if (dequeueInputBuffer < 0) {
            return null;
        }
        synchronized (this) {
            bufferData.index = dequeueInputBuffer;
            try {
                try {
                    bufferData.buffer = (ByteBuffer) fgetInputBuffer21.invoke(this.mMediaCodec, Integer.valueOf(dequeueInputBuffer));
                } catch (IllegalArgumentException e16) {
                    e16.printStackTrace();
                    bufferData.success = false;
                    this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueInputBuffer;
                } catch (InvocationTargetException e17) {
                    e17.printStackTrace();
                    bufferData.success = false;
                    this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueInputBuffer;
                }
            } catch (IllegalAccessException e18) {
                e18.printStackTrace();
                bufferData.success = false;
                this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueInputBuffer;
            }
        }
        return bufferData;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public ByteBuffer getOutputBuffer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ByteBuffer) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        try {
            return (ByteBuffer) fgetOutputBuffer21.invoke(this.mMediaCodec, Integer.valueOf(i3));
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTAG, "invoke getOutputBuffer exception", e16);
            }
            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorGetOutputBufferWithIndex;
            return null;
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public MediaFormat getOutputFormat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (MediaFormat) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        try {
            return (MediaFormat) fgetOutputFormat21.invoke(this.mMediaCodec, Integer.valueOf(i3));
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTAG, "invoke getOutputFormat exception", e16);
            }
            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorGetOutputFormatWithIndex;
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.avcore.jni.codec.AndroidCodec$4] */
    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public boolean init(String str, MediaFormat mediaFormat, String str2, boolean z16, IMediaCodecCallback iMediaCodecCallback) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, str, mediaFormat, str2, Boolean.valueOf(z16), iMediaCodecCallback)).booleanValue();
        }
        this.mFormat = mediaFormat;
        this.mCallHwCodcFuncTimeoutFlag = z16;
        this.hadCallHwCodecFuncTimeOut = false;
        MediaCodecInfo codecInfo = AndroidCodecBase.getCodecInfo(str2);
        if (codecInfo == null || !codecInfo.isEncoder()) {
            i3 = 0;
        } else {
            this.mCodecType = ENC_CODEC;
            i3 = 1;
        }
        try {
            if (this.mCallHwCodcFuncTimeoutFlag) {
                Callable<MediaCodec> init = new Callable<MediaCodec>() { // from class: com.tencent.avcore.jni.codec.AndroidCodec.4
                    static IPatchRedirector $redirector_;
                    private String codecName;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AndroidCodec.this);
                        }
                    }

                    public Callable<MediaCodec> init(String str3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (Callable) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str3);
                        }
                        this.codecName = str3;
                        return this;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public MediaCodec call() throws Exception {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            return (MediaCodec) iPatchRedirector2.redirect((short) 3, (Object) this);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        MediaCodec createByCodecName = MediaCodec.createByCodecName(this.codecName);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        AVCoreLog.e(AndroidCodec.this.mTAG, "createByCodecName " + this.codecName + ", time " + (currentTimeMillis2 - currentTimeMillis));
                        return createByCodecName;
                    }
                }.init(str2);
                ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
                Future submit = newSingleThreadExecutor.submit(init);
                try {
                    try {
                        this.mMediaCodec = (MediaCodec) submit.get(500L, TimeUnit.MILLISECONDS);
                    } catch (Exception e16) {
                        this.mMediaCodec = null;
                        this.mAndroidCodecStatus = AndroidCodecStatus.ErrorCreateByCodecNameException;
                        e16.printStackTrace();
                    }
                } catch (TimeoutException unused) {
                    this.mMediaCodec = null;
                    this.hadCallHwCodecFuncTimeOut = true;
                    AVCoreLog.e(this.mTAG, "mMediaCodec createByCodecName timeout");
                    this.mAndroidCodecStatus = AndroidCodecStatus.ErrorCreateByCodecNameTimeOut;
                    submit.cancel(true);
                }
                newSingleThreadExecutor.shutdown();
            } else {
                this.mMediaCodec = MediaCodec.createByCodecName(str2);
            }
            if (AndroidCodecAdapterProxy.getInstance().isSupportHWDecLowLatency()) {
                MediaCodecHelper.setDecoderLowLatencyOptions(mediaFormat, codecInfo, str);
            }
            try {
                MediaCodec mediaCodec = this.mMediaCodec;
                if (mediaCodec != null) {
                    this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(mediaCodec, iMediaCodecCallback);
                    if (this.mCallHwCodcFuncTimeoutFlag) {
                        configureCodecWithTimeOut(this.mMediaCodec, this.mFormat, i3, 500L);
                    } else {
                        this.mMediaCodec.configure(this.mFormat, (Surface) null, (MediaCrypto) null, i3);
                    }
                }
                return this.mMediaCodec != null;
            } catch (Exception e17) {
                e17.printStackTrace();
                this.mAndroidCodecStatus = AndroidCodecStatus.ErrorConfigureCodecException;
                return false;
            }
        } catch (Exception e18) {
            e18.printStackTrace();
            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorCreateByCodecNameException;
            return false;
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public synchronized void queueInputBuffer(int i3, int i16, long j3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
            return;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.queueInputBuffer(i3, 0, i16, j3, i17);
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTAG, "queueInputBuffer exception, index[" + i3 + "], sampleSize[" + i16 + "], timestamp[" + j3 + "], flags[" + i17 + "]", e16);
            }
            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorQueueInputBuffer;
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.inputBuffers = null;
        this.outputBuffers = null;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            if (this.mCallHwCodcFuncTimeoutFlag) {
                mediaCodecOperationWithTimeOut(MediaCodecOperation.kRelease, 200L);
            } else {
                mediaCodec.release();
            }
            this.mMediaCodec = null;
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public synchronized void releaseOutputBuffer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return;
        }
        mediaCodec.releaseOutputBuffer(i3, false);
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public synchronized void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    public void setAndroidCodecStatusCallback(AndroidCodecStatusCallback androidCodecStatusCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) androidCodecStatusCallback);
        } else {
            this.mStatusCallback = androidCodecStatusCallback;
        }
    }

    boolean setMediaCodecCallback(MediaCodec mediaCodec, IMediaCodecCallback iMediaCodecCallback) {
        AndroidCodecStatusCallback androidCodecStatusCallback;
        if (iMediaCodecCallback != null && (androidCodecStatusCallback = this.mStatusCallback) != null && androidCodecStatusCallback.isSupportAsyncApi()) {
            mediaCodec.setCallback(new MediaCodec.Callback(iMediaCodecCallback) { // from class: com.tencent.avcore.jni.codec.AndroidCodec.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMediaCodecCallback val$cb;

                {
                    this.val$cb = iMediaCodecCallback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AndroidCodec.this, (Object) iMediaCodecCallback);
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onError(MediaCodec mediaCodec2, MediaCodec.CodecException codecException) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaCodec2, (Object) codecException);
                        return;
                    }
                    IMediaCodecCallback iMediaCodecCallback2 = this.val$cb;
                    if (iMediaCodecCallback2 != null) {
                        iMediaCodecCallback2.onError(mediaCodec2, codecException);
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onInputBufferAvailable(MediaCodec mediaCodec2, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaCodec2, i3);
                        return;
                    }
                    IMediaCodecCallback iMediaCodecCallback2 = this.val$cb;
                    if (iMediaCodecCallback2 != null) {
                        iMediaCodecCallback2.onInputBufferAvailable(mediaCodec2, i3);
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputBufferAvailable(MediaCodec mediaCodec2, int i3, MediaCodec.BufferInfo bufferInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, mediaCodec2, Integer.valueOf(i3), bufferInfo);
                        return;
                    }
                    IMediaCodecCallback iMediaCodecCallback2 = this.val$cb;
                    if (iMediaCodecCallback2 != null) {
                        iMediaCodecCallback2.onOutputBufferAvailable(mediaCodec2, i3, bufferInfo);
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputFormatChanged(MediaCodec mediaCodec2, MediaFormat mediaFormat) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) mediaCodec2, (Object) mediaFormat);
                        return;
                    }
                    IMediaCodecCallback iMediaCodecCallback2 = this.val$cb;
                    if (iMediaCodecCallback2 != null) {
                        iMediaCodecCallback2.onOutputFormatChanged(mediaCodec2, mediaFormat);
                    }
                }
            });
            return false;
        }
        return false;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public void setParameters(Bundle bundle) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) bundle);
            return;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null && (method = fsetParameters19) != null) {
            try {
                method.invoke(mediaCodec, bundle);
            } catch (IllegalAccessException e16) {
                if (AVCoreLog.isDevelopLevel()) {
                    AVCoreLog.e(this.mTAG, "setParameters, IllegalAccessException", e16);
                }
                this.mAndroidCodecStatus = AndroidCodecStatus.ErrorSetParametersWithBundle;
            } catch (IllegalArgumentException e17) {
                if (AVCoreLog.isDevelopLevel()) {
                    AVCoreLog.e(this.mTAG, "setParameters, IllegalArgumentException", e17);
                }
                this.mAndroidCodecStatus = AndroidCodecStatus.ErrorSetParametersWithBundle;
            } catch (InvocationTargetException e18) {
                if (AVCoreLog.isDevelopLevel()) {
                    AVCoreLog.e(this.mTAG, "setParameters, InvocationTargetException", e18);
                }
                this.mAndroidCodecStatus = AndroidCodecStatus.ErrorSetParametersWithBundle;
            }
        }
    }

    public void setSurface(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surface);
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public boolean start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                if (this.mCallHwCodcFuncTimeoutFlag) {
                    mediaCodecOperationWithTimeOut(MediaCodecOperation.kStart, 500L);
                    return true;
                }
                mediaCodec.start();
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            if (this.mCallHwCodcFuncTimeoutFlag) {
                mediaCodecOperationWithTimeOut(MediaCodecOperation.kStop, 200L);
            } else {
                mediaCodec.stop();
            }
        }
    }

    public AndroidCodec(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.mCallHwCodcFuncTimeoutFlag = false;
        this.mAndroidCodecStatus = AndroidCodecStatus.OK;
        this.hadCallHwCodecFuncTimeOut = false;
        this.mCodecType = DEC_CODEC;
        this.mIsSetMediaCodecCallbackSuc = false;
        String str2 = str + "_AndroidCodec";
        this.mTAG = str2;
        invoke21Apis(str2);
        if (fsetParameters19 == null) {
            try {
                fsetParameters19 = MediaCodec.class.getMethod("setParameters", Bundle.class);
            } catch (NoSuchMethodException unused) {
                fsetParameters19 = null;
            }
        }
    }

    protected static void invoke21Apis(String str) {
        try {
            if (fgetInputBuffer21 == null) {
                fgetInputBuffer21 = MediaCodec.class.getMethod("getInputBuffer", Integer.TYPE);
            }
            if (fgetOutputBuffer21 == null) {
                fgetOutputBuffer21 = MediaCodec.class.getMethod("getOutputBuffer", Integer.TYPE);
            }
            if (fgetOutputFormat21 == null) {
                fgetOutputFormat21 = MediaCodec.class.getMethod("getOutputFormat", Integer.TYPE);
            }
        } catch (Exception unused) {
            fgetInputBuffer21 = null;
            fgetOutputBuffer21 = null;
            fgetOutputFormat21 = null;
            fInvokeAPILevel21 = false;
        }
        if (AVCoreLog.isDevelopLevel() || !fInvokeAPILevel21) {
            AVCoreLog.e(str, "invoke21Apis, fInvokeAPILevel21[" + fInvokeAPILevel21 + "]");
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public AndroidCodecStatus getAndroidCodecStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? this.mAndroidCodecStatus : (AndroidCodecStatus) iPatchRedirector.redirect((short) 22, (Object) this);
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public ByteBuffer getInputBuffer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ByteBuffer) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        try {
            return (ByteBuffer) fgetInputBuffer21.invoke(this.mMediaCodec, Integer.valueOf(i3));
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e(this.mTAG, "invoke getInputBuffer exception", e16);
            }
            this.mAndroidCodecStatus = AndroidCodecStatus.ErrorDequeueInputBufferWithIndex;
            return null;
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public boolean init(String str, MediaFormat mediaFormat, String str2, Surface surface, IMediaCodecCallback iMediaCodecCallback) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, str, mediaFormat, str2, surface, iMediaCodecCallback)).booleanValue();
        }
        this.mFormat = mediaFormat;
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str2);
            MediaCodecInfo codecInfo = AndroidCodecBase.getCodecInfo(str2);
            if (codecInfo == null || !codecInfo.isEncoder()) {
                i3 = 0;
            } else {
                this.mCodecType = ENC_CODEC;
                i3 = 1;
            }
            try {
                MediaCodec mediaCodec = this.mMediaCodec;
                if (mediaCodec != null) {
                    this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(mediaCodec, iMediaCodecCallback);
                    this.mMediaCodec.configure(this.mFormat, surface, (MediaCrypto) null, i3);
                }
                return this.mMediaCodec != null;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecBase
    public boolean init(String str, MediaFormat mediaFormat, int i3, IMediaCodecCallback iMediaCodecCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, str, mediaFormat, Integer.valueOf(i3), iMediaCodecCallback)).booleanValue();
        }
        this.mFormat = mediaFormat;
        if (i3 == DEC_CODEC) {
            try {
                this.mMediaCodec = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        } else {
            try {
                this.mMediaCodec = MediaCodec.createEncoderByType(mediaFormat.getString("mime"));
            } catch (Exception e17) {
                e17.printStackTrace();
                return false;
            }
        }
        this.mCodecType = i3;
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                int i16 = i3 == ENC_CODEC ? 1 : 0;
                this.mIsSetMediaCodecCallbackSuc = setMediaCodecCallback(mediaCodec, iMediaCodecCallback);
                this.mMediaCodec.configure(this.mFormat, (Surface) null, (MediaCrypto) null, i16);
            }
            return this.mMediaCodec != null;
        } catch (Exception e18) {
            e18.printStackTrace();
            return false;
        }
    }
}
