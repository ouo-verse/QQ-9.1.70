package com.tencent.mobileqq.shortvideo.mtveffects;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class Mp4MaterialLoader implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener {
    private static final int MSG_DECODER_NEXT = 0;
    private static final int MSG_DECODER_PAUSE = 3;
    private static final int MSG_DECODER_RESUME = 4;
    private static final int MSG_DECODER_START = 1;
    private static final int MSG_DECODER_STOP = 2;
    private static final String TAG = "Mp4MaterialLoader";
    private DecodeHandler mDecodeHandler;
    private GPUOESBaseFilter mEncodeGPUOESFilter;
    private EglHandlerThreadEx mHandlerThread;
    private int mHeight;
    private RenderBuffer mMaterialCache;
    private boolean mStop;
    private int mWidth;
    private boolean mInited = false;
    private HWVideoDecoder mDecoder = new HWVideoDecoder();
    private int mTextureID = -1;
    private int mCacheRef = 0;
    private boolean mCacheAvailable = false;
    private Object mWaitRelease = new Object();
    private boolean mPause = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class DecodeHandler extends Handler {
        private WeakReference<HWVideoDecoder> mDecoderRef;

        public DecodeHandler(Looper looper, HWVideoDecoder hWVideoDecoder) {
            super(looper);
            this.mDecoderRef = new WeakReference<>(hWVideoDecoder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            HWVideoDecoder hWVideoDecoder = this.mDecoderRef.get();
            if (hWVideoDecoder == null) {
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                hWVideoDecoder.resumeDecode();
                                return;
                            }
                            return;
                        }
                        hWVideoDecoder.pauseDecode();
                        return;
                    }
                    hWVideoDecoder.stopDecode();
                    return;
                }
                Object obj = message.obj;
                if (obj != null) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length != 3) {
                        return;
                    }
                    DecodeConfig decodeConfig = new DecodeConfig((String) objArr[1], 0, true, false);
                    int intValue = ((Integer) objArr[0]).intValue();
                    Object obj2 = objArr[2];
                    hWVideoDecoder.startDecode(decodeConfig, intValue, (SurfaceTexture.OnFrameAvailableListener) obj2, (HWDecodeListener) obj2);
                    return;
                }
                return;
            }
            Object obj3 = message.obj;
            if (obj3 != null) {
                long longValue = ((Long) obj3).longValue();
                if (longValue >= 0) {
                    hWVideoDecoder.nextTo(longValue);
                }
                hWVideoDecoder.decodeFrame();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class EglHandlerThreadEx extends EglHandlerThread {
        private WeakReference<Object> mSynObjectRef;

        public EglHandlerThreadEx(String str, EGLContext eGLContext, Object obj) {
            super(str, eGLContext);
            if (obj != null) {
                this.mSynObjectRef = new WeakReference<>(obj);
            }
        }

        public void onLooperExited() {
            release();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread, android.os.HandlerThread
        public void onLooperPrepared() {
            Object obj;
            super.onLooperPrepared();
            WeakReference<Object> weakReference = this.mSynObjectRef;
            if (weakReference != null && (obj = weakReference.get()) != null) {
                synchronized (obj) {
                    obj.notify();
                }
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread, android.os.HandlerThread
        @TargetApi(18)
        public boolean quitSafely() {
            Looper looper = getLooper();
            if (looper != null) {
                looper.quitSafely();
                return true;
            }
            return false;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                super.run();
                onLooperExited();
            } catch (Exception unused) {
            }
        }
    }

    public int getCurrentTexture() {
        synchronized (this.mWaitRelease) {
            RenderBuffer renderBuffer = this.mMaterialCache;
            if (renderBuffer != null && this.mCacheAvailable) {
                this.mCacheRef++;
                return renderBuffer.getTexId();
            }
            return -1;
        }
    }

    @TargetApi(17)
    public void init(int i3, int i16) {
        this.mTextureID = GlUtil.createTexture(36197);
        this.mMaterialCache = new RenderBuffer(i3, i16, 33984);
        EglHandlerThreadEx eglHandlerThreadEx = this.mHandlerThread;
        if (eglHandlerThreadEx != null) {
            eglHandlerThreadEx.quitSafely();
        }
        EglHandlerThreadEx eglHandlerThreadEx2 = new EglHandlerThreadEx("MTVMaterialthread", EGL14.eglGetCurrentContext(), this);
        this.mHandlerThread = eglHandlerThreadEx2;
        eglHandlerThreadEx2.start();
        synchronized (this) {
            if (!this.mHandlerThread.isInitSuccess()) {
                try {
                    wait(1000L);
                } catch (InterruptedException unused) {
                }
            }
        }
        this.mDecodeHandler = new DecodeHandler(this.mHandlerThread.getLooper(), this.mDecoder);
        this.mInited = true;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public void nextTo(long j3) {
        if (this.mDecodeHandler != null) {
            Message obtain = Message.obtain();
            obtain.obj = Long.valueOf(j3);
            obtain.what = 0;
            this.mDecodeHandler.sendMessage(obtain);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.mStop) {
            return;
        }
        try {
            surfaceTexture.updateTexImage();
            synchronized (this.mWaitRelease) {
                if (this.mCacheRef > 0) {
                    try {
                        this.mWaitRelease.wait(1000L);
                    } catch (InterruptedException unused) {
                    }
                }
                if (this.mCacheRef == 0) {
                    float[] fArr = new float[16];
                    surfaceTexture.getTransformMatrix(fArr);
                    if (this.mEncodeGPUOESFilter == null) {
                        GPUOESBaseFilter gPUOESBaseFilter = new GPUOESBaseFilter();
                        this.mEncodeGPUOESFilter = gPUOESBaseFilter;
                        gPUOESBaseFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
                        this.mEncodeGPUOESFilter.init();
                    }
                    this.mMaterialCache.bind();
                    this.mEncodeGPUOESFilter.drawTexture(this.mTextureID, fArr, null);
                    this.mMaterialCache.unbind();
                    this.mCacheAvailable = true;
                }
            }
        } catch (Exception e16) {
            SLog.e(TAG, "onFrameAvailable exception");
            e16.printStackTrace();
        }
    }

    public void pause() {
        this.mPause = true;
        if (this.mDecodeHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.mDecodeHandler.sendMessage(obtain);
        }
    }

    public void releaseCurrentTexture() {
        synchronized (this.mWaitRelease) {
            if (this.mMaterialCache == null) {
                return;
            }
            int i3 = this.mCacheRef;
            if (i3 > 0) {
                this.mCacheRef = i3 - 1;
                this.mWaitRelease.notifyAll();
            }
        }
    }

    public void resume() {
        if (this.mPause && this.mDecodeHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            this.mDecodeHandler.sendMessage(obtain);
        }
    }

    public void start(String str) {
        this.mStop = false;
        if (this.mDecodeHandler != null && !TextUtils.isEmpty(str)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = new Object[]{Integer.valueOf(this.mTextureID), str, this};
            this.mDecodeHandler.sendMessage(obtain);
        }
    }

    public void stop() {
        this.mStop = true;
        if (this.mDecodeHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.mDecodeHandler.sendMessage(obtain);
        }
    }

    public void unInit() {
        stop();
        EglHandlerThreadEx eglHandlerThreadEx = this.mHandlerThread;
        if (eglHandlerThreadEx != null) {
            eglHandlerThreadEx.quitSafely();
            this.mHandlerThread = null;
        }
        this.mDecodeHandler = null;
        this.mInited = false;
        int i3 = this.mTextureID;
        if (i3 >= 0) {
            GlUtil.deleteTexture(i3);
            this.mTextureID = -1;
        }
        RenderBuffer renderBuffer = this.mMaterialCache;
        if (renderBuffer != null && renderBuffer.getTexId() >= 0) {
            GlUtil.deleteTexture(this.mMaterialCache.getTexId());
            this.mMaterialCache.destroy();
            this.mMaterialCache = null;
            this.mCacheRef = 0;
            this.mCacheAvailable = false;
        }
        GPUOESBaseFilter gPUOESBaseFilter = this.mEncodeGPUOESFilter;
        if (gPUOESBaseFilter != null) {
            gPUOESBaseFilter.destroy();
            this.mEncodeGPUOESFilter = null;
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeCancel() {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFinish() {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeRepeat() {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeStart() {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeSeekTo(long j3) {
    }

    public void seekTo(long j3) {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeError(int i3, Throwable th5) {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFrame(long j3, long j16) throws InterruptedException {
    }
}
