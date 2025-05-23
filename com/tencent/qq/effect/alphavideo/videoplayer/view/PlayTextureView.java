package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.alphavideo.common.IntervalFpsLogTimer;
import com.tencent.qq.effect.alphavideo.videoplayer.decoder.HardwareFileDecoder;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender;
import com.tencent.qq.effect.alphavideo.videoplayer.render.SurfaceTextureBlendRender;
import com.tencent.qq.effect.utils.LogUtil;
import com.tencent.qq.effect.utils.QEffectUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes22.dex */
public class PlayTextureView extends GLTextureView implements GLSurfaceView.Renderer {
    static IPatchRedirector $redirector_;
    private final int DEFAULT_FRAME_RATE;
    private String TAG;
    private boolean mContentVisible;
    private Context mContext;
    private float mCropValue;
    private int mCurFrameCount;
    private BaseRender mCurRender;
    private long mCurTime;
    private IVideoFileDecodeListener mDecodeListener;
    private Thread mDecodeThread;
    private String mFilepath;
    private int mFrameTime;
    private int mGLViewHeight;
    private int mGLViewWidth;
    private int mHalfVideoWidth;
    private IVideoFileDecoder mHardDecoder;
    private Runnable mHardwareDecodeWaitForRunnable;
    private boolean mIsPortrait;
    private Object mLock;
    private boolean mLoop;
    private boolean mNeedConfigViewport;
    private IntervalFpsLogTimer mOnPreviewFrameLogTimer;
    private IVideoPLayListener mPlayListener;
    private boolean mPlayStarting;
    private boolean mStopping;
    private BaseRender mSurfaceTextureRender;
    private String mTmpFilePath;
    private int mVideoHeight;
    private int mVideoWidth;
    private Handler mViewHandler;
    private boolean mViewReady;

    public PlayTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        this.TAG = "VideoPlayer|PlayView";
        this.mFilepath = null;
        this.mViewHandler = new Handler();
        this.mHardDecoder = null;
        this.mSurfaceTextureRender = null;
        this.mCurRender = null;
        this.mDecodeThread = null;
        this.mPlayListener = null;
        this.mLoop = false;
        this.mVideoWidth = 0;
        this.mHalfVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mGLViewWidth = 0;
        this.mGLViewHeight = 0;
        this.mCropValue = 0.0f;
        this.mIsPortrait = true;
        this.mNeedConfigViewport = true;
        this.mContentVisible = true;
        this.mFrameTime = 0;
        this.mLock = new Object();
        this.mCurTime = 0L;
        this.mCurFrameCount = 0;
        this.mStopping = false;
        this.mTmpFilePath = null;
        this.mViewReady = false;
        this.mPlayStarting = false;
        this.DEFAULT_FRAME_RATE = 25;
        this.mDecodeListener = new IVideoFileDecodeListener() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeEnd() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                LogUtil.e(PlayTextureView.this.TAG, " onVideoDecodeEnd");
                PlayTextureView.this.mVideoWidth = 0;
                PlayTextureView.this.mVideoHeight = 0;
                PlayTextureView.this.mHalfVideoWidth = 0;
                PlayTextureView.this.mFilepath = null;
                PlayTextureView.this.onPause();
                PlayTextureView.this.processDecodeEnd();
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    LogUtil.e(PlayTextureView.this.TAG, "========= onVideoDecodeError errorCode = " + i3);
                    if (i3 == -101) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.mFilepath = null;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-11);
                        return;
                    }
                    if (i3 == -5) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-2);
                        return;
                    }
                    if (i3 == -3 || i3 == -2 || i3 == -1) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.mFilepath = null;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-1);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 8, (Object) this, i3);
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeFrame(long j3, byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Long.valueOf(j3), bArr);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                LogUtil.e(PlayTextureView.this.TAG, " onVideoDecodeStart");
                PlayTextureView.this.mCurTime = 0L;
                PlayTextureView.this.mCurFrameCount = 0;
                PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else if (PlayTextureView.this.mPlayListener != null) {
                            PlayTextureView.this.mPlayListener.onStart();
                        }
                    }
                });
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecoderCreated(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                } else {
                    LogUtil.e(PlayTextureView.this.TAG, " onVideoDecoderCreated");
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            @RequiresApi(api = 16)
            public void onVideoFormat(MediaFormat mediaFormat) {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) mediaFormat);
                    return;
                }
                if (mediaFormat != null && mediaFormat.containsKey("frame-rate")) {
                    i3 = mediaFormat.getInteger("frame-rate");
                } else {
                    i3 = 0;
                }
                if (i3 <= 0) {
                    i3 = 25;
                }
                PlayTextureView.this.mFrameTime = 1000000 / i3;
                LogUtil.v(PlayTextureView.this.TAG, "mFrame Time  = " + PlayTextureView.this.mFrameTime);
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoSize(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LogUtil.e(PlayTextureView.this.TAG, "onVideoSize() called with: width = [" + i3 + "], height = [" + i16 + "]");
                    PlayTextureView.this.mVideoWidth = i3;
                    PlayTextureView.this.mHalfVideoWidth = i3 / 2;
                    PlayTextureView.this.mVideoHeight = i16;
                    PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (PlayTextureView.this.mPlayListener != null) {
                                PlayTextureView.this.mPlayListener.onVideoSize(PlayTextureView.this.mVideoWidth, PlayTextureView.this.mVideoHeight);
                            }
                        }
                    });
                    if (PlayTextureView.this.mVideoWidth > 0 && PlayTextureView.this.mVideoHeight > 0 && PlayTextureView.this.mGLViewWidth > 0 && PlayTextureView.this.mGLViewHeight > 0) {
                        PlayTextureView.this.mNeedConfigViewport = true;
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        };
        this.mHardwareDecodeWaitForRunnable = new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (PlayTextureView.this.mViewReady && PlayTextureView.this.mHardDecoder != null && PlayTextureView.this.mFilepath != null && PlayTextureView.this.getSurface() != null) {
                    PlayTextureView playTextureView = PlayTextureView.this;
                    playTextureView.mCurRender = playTextureView.mSurfaceTextureRender;
                    int createDecoder = PlayTextureView.this.mHardDecoder.createDecoder(PlayTextureView.this.mFilepath, PlayTextureView.this.getSurface());
                    LogUtil.e(PlayTextureView.this.TAG, " ret =" + createDecoder);
                    LogUtil.v(PlayTextureView.this.TAG, "===============hardware decode create return = " + createDecoder);
                    if (createDecoder == 1) {
                        PlayTextureView.this.mHardDecoder.decode();
                    } else {
                        LogUtil.e(PlayTextureView.this.TAG, " \u4e0d\u5f00\u59cb\u89e3\u7801\u3002\u3002\u3002\u3002 ");
                    }
                }
            }
        };
        this.mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
        this.mContext = context;
        init();
    }

    private float CalCrop(int i3, int i16, int i17, int i18) {
        if (i16 == 0 || i17 == 0 || i3 == 0 || i18 == 0) {
            return 0.0f;
        }
        int i19 = i16 * i17;
        int i26 = i3 * i18;
        if (i19 == i26) {
            LogUtil.v(this.TAG, " crop 0");
            return 0.0f;
        }
        if (i19 > i26) {
            float f16 = 0.5f - ((((i18 * i3) * 0.5f) / i17) / i16);
            LogUtil.v(this.TAG, " crop height = " + f16);
            return f16;
        }
        float f17 = ((((i17 * i16) * 0.5f) / i18) / i3) - 0.5f;
        LogUtil.v(this.TAG, " crop width = " + f17);
        return f17;
    }

    private void _calcCropValue() {
        if (this.mIsPortrait) {
            int i3 = this.mHalfVideoWidth;
            int i16 = this.mVideoHeight;
            if (i3 > i16) {
                this.mCropValue = CalCrop(i16, i3, this.mGLViewWidth, this.mGLViewHeight);
                return;
            } else {
                this.mCropValue = CalCrop(i3, i16, this.mGLViewWidth, this.mGLViewHeight);
                return;
            }
        }
        int i17 = this.mHalfVideoWidth;
        int i18 = i17 * 9;
        int i19 = this.mVideoHeight;
        if (i18 >= i19 * 16) {
            this.mCropValue = CalCrop(i17, i19, this.mGLViewWidth, this.mGLViewHeight);
        } else {
            this.mCropValue = 0.0f;
        }
    }

    private void callbackError(int i3) {
        Handler handler;
        if (this.mPlayListener != null && (handler = this.mViewHandler) != null) {
            handler.post(new Runnable(i3) { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$errorCode;

                {
                    this.val$errorCode = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlayTextureView.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (PlayTextureView.this.mPlayListener != null) {
                        PlayTextureView.this.mPlayListener.onError(this.val$errorCode);
                    }
                }
            });
        }
    }

    private void configViewportOnDraw() {
        if (this.mIsPortrait) {
            int i3 = this.mHalfVideoWidth;
            int i16 = this.mVideoHeight;
            if (i3 < i16) {
                BaseRender baseRender = this.mCurRender;
                if (baseRender != null) {
                    baseRender.setCropValue(this.mCropValue);
                    GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
                    return;
                }
                return;
            }
            int i17 = this.mGLViewWidth;
            int i18 = (i17 * 9) / 16;
            if (i3 != 0) {
                i18 = (i17 * i16) / i3;
            }
            int i19 = ((this.mGLViewHeight - i18) * 2) / 3;
            BaseRender baseRender2 = this.mCurRender;
            if (baseRender2 != null) {
                baseRender2.setCropValue(this.mCropValue);
                GLES20.glViewport(0, i19, this.mGLViewWidth, i18);
                return;
            }
            return;
        }
        int i26 = this.mHalfVideoWidth;
        int i27 = i26 * 9;
        int i28 = this.mVideoHeight;
        if (i27 >= i28 * 16) {
            BaseRender baseRender3 = this.mCurRender;
            if (baseRender3 != null) {
                baseRender3.setCropValue(this.mCropValue);
                GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
                return;
            }
            return;
        }
        int i29 = (i26 * this.mGLViewHeight) / i28;
        int i36 = (this.mGLViewWidth - i29) / 2;
        BaseRender baseRender4 = this.mCurRender;
        if (baseRender4 != null) {
            baseRender4.setCropValue(this.mCropValue);
            GLES20.glViewport(i36, 0, i29, this.mGLViewHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Surface getSurface() {
        BaseRender baseRender = this.mSurfaceTextureRender;
        if (baseRender != null && (baseRender instanceof SurfaceTextureBlendRender)) {
            return ((SurfaceTextureBlendRender) baseRender).getSurface();
        }
        return null;
    }

    private void init() {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        setRenderMode(0);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDecodeEnd() {
        queueEvent(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PlayTextureView.this.releaseRenderGLThread();
                    PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            LogUtil.v(PlayTextureView.this.TAG, "==============PlayView set gone");
                            PlayTextureView.this.setVisibility(8);
                            if (PlayTextureView.this.mPlayListener != null) {
                                PlayTextureView.this.mPlayListener.onEnd();
                            }
                        }
                    });
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        if (PlayTextureView.this.getVisibility() == 8) {
                            break;
                        }
                        LogUtil.v(PlayTextureView.this.TAG, "==============PlayView wait set GONE");
                        try {
                            LockMethodProxy.sleep(50L);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                        if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                            LogUtil.v(PlayTextureView.this.TAG, "==============PlayView set GONE time out");
                            break;
                        }
                    }
                    LogUtil.v(PlayTextureView.this.TAG, "==============PlayView set GONE over");
                    PlayTextureView.this.mPlayStarting = false;
                    PlayTextureView.this.mViewReady = false;
                    if (PlayTextureView.this.mStopping) {
                        PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.4.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    PlayTextureView.this.mStopping = false;
                                    if (PlayTextureView.this.mTmpFilePath != null) {
                                        LogUtil.v(PlayTextureView.this.TAG, "==============stopping need play file again");
                                        PlayTextureView playTextureView = PlayTextureView.this;
                                        playTextureView.playFile(playTextureView.mTmpFilePath);
                                        return;
                                    }
                                    return;
                                }
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        });
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDecodeError(int i3) {
        queueEvent(new Runnable(i3) { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$errorCode;

            {
                this.val$errorCode = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlayTextureView.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PlayTextureView.this.releaseRenderGLThread();
                    PlayTextureView.this.mPlayStarting = false;
                    PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.5.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            PlayTextureView.this.setVisibility(8);
                            if (PlayTextureView.this.mPlayListener != null) {
                                PlayTextureView.this.mPlayListener.onError(AnonymousClass5.this.val$errorCode);
                            }
                        }
                    });
                    PlayTextureView.this.mViewReady = false;
                    if (this.val$errorCode == -2) {
                        Log.v(PlayTextureView.this.TAG, "  need switch software decode ");
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseRenderGLThread() {
        BaseRender baseRender = this.mSurfaceTextureRender;
        if (baseRender != null) {
            baseRender.destroy();
            this.mSurfaceTextureRender = null;
        }
    }

    private void setupDecodeRender() {
        HardwareFileDecoder hardwareFileDecoder = new HardwareFileDecoder(this.mLoop);
        this.mHardDecoder = hardwareFileDecoder;
        hardwareFileDecoder.setDecodeListener(this.mDecodeListener);
        try {
            SurfaceTextureBlendRender surfaceTextureBlendRender = new SurfaceTextureBlendRender();
            this.mSurfaceTextureRender = surfaceTextureBlendRender;
            surfaceTextureBlendRender.setup();
            setupFrameListenerOES();
        } catch (Exception e16) {
            LogUtil.v(this.TAG, "mSurfaceTextureRender Exception switch  soft decode Exception=" + e16);
            e16.printStackTrace();
        }
    }

    private void setupFrameListenerOES() {
        BaseRender baseRender = this.mSurfaceTextureRender;
        if (baseRender != null && baseRender.getRenderType() == 1 && ((SurfaceTextureBlendRender) this.mSurfaceTextureRender).getVideoTexture() != null) {
            ((SurfaceTextureBlendRender) this.mSurfaceTextureRender).getVideoTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                    }
                }

                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceTexture);
                    } else {
                        PlayTextureView.this.requestRender();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDecode() {
        this.mFrameTime = 0;
        BaseThread baseThread = new BaseThread(this.mHardwareDecodeWaitForRunnable);
        this.mDecodeThread = baseThread;
        baseThread.start();
    }

    public boolean getContentVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mContentVisible;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) gl10);
            return;
        }
        if (this.mViewReady && this.mCurRender != null && (i3 = this.mVideoWidth) > 0 && (i16 = this.mVideoHeight) > 0) {
            if (this.mNeedConfigViewport && i3 > 0 && i16 > 0 && this.mGLViewWidth > 0 && this.mGLViewHeight > 0) {
                _calcCropValue();
                configViewportOnDraw();
                this.mNeedConfigViewport = false;
            }
            this.mCurRender.draw(null, 0, 0, false);
            if (this.mFrameTime > 0) {
                this.mCurFrameCount = this.mCurFrameCount + 1;
                this.mCurTime = r4 * r0;
                this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.8
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (PlayTextureView.this.mPlayListener != null) {
                            PlayTextureView.this.mPlayListener.onPlayAtTime(PlayTextureView.this.mCurTime);
                        }
                    }
                });
            }
            if (this.mOnPreviewFrameLogTimer.isTimeToWriteLog()) {
                LogUtil.i(this.TAG, "onDrawFrame fps= " + this.mOnPreviewFrameLogTimer.getFps());
            }
            if (!this.mContentVisible) {
                GLES20.glClear(16384);
                GLES20.glFinish();
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, gl10, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        LogUtil.e(this.TAG, "===================gl render onSurfaceChanged " + i3 + " h=" + i16);
        gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.mGLViewWidth = i3;
        this.mGLViewHeight = i16;
        if (i3 <= i16) {
            z16 = true;
        }
        this.mIsPortrait = z16;
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0 && i3 > 0 && i16 > 0) {
            this.mNeedConfigViewport = true;
        }
        if (!this.mViewReady) {
            this.mViewReady = true;
            this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        PlayTextureView.this.startDecode();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) gl10, (Object) eGLConfig);
        } else {
            LogUtil.e(this.TAG, "===================gl render onSurfaceCreated");
            setupDecodeRender();
        }
    }

    public void playFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (this.mStopping) {
            this.mTmpFilePath = str;
        } else {
            this.mTmpFilePath = null;
        }
        LogUtil.e(this.TAG, " playFile , want to play filepath =" + str);
        if (this.mPlayStarting) {
            LogUtil.v(this.TAG, " playFile , one has played , return");
            return;
        }
        if (this.mViewReady) {
            LogUtil.v(this.TAG, " playFile , view not ready , return ");
            return;
        }
        this.mPlayStarting = true;
        if (QEffectUtils.fileIsExists(str)) {
            this.mFilepath = str;
            this.mCurRender = null;
            new BaseThread(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PlayTextureView.this.onResume();
                    }
                }
            }).start();
            setVisibility(0);
            return;
        }
        LogUtil.e(this.TAG, " file , get error");
        callbackError(-1);
        this.mPlayStarting = false;
    }

    public void setContentVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mContentVisible = z16;
        }
    }

    public void setLoopState(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        this.mLoop = z16;
        IVideoFileDecoder iVideoFileDecoder = this.mHardDecoder;
        if (iVideoFileDecoder != null) {
            iVideoFileDecoder.setLoopState(z16);
        }
    }

    public void setPlayListener(IVideoPLayListener iVideoPLayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVideoPLayListener);
        } else {
            this.mPlayListener = iVideoPLayListener;
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Log.v(this.TAG, "==============PlayView Stop");
        if (!this.mViewReady) {
            return;
        }
        IVideoFileDecoder iVideoFileDecoder = this.mHardDecoder;
        if (iVideoFileDecoder != null) {
            iVideoFileDecoder.stop();
        }
        this.mStopping = true;
    }

    public PlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.TAG = "VideoPlayer|PlayView";
        this.mFilepath = null;
        this.mViewHandler = new Handler();
        this.mHardDecoder = null;
        this.mSurfaceTextureRender = null;
        this.mCurRender = null;
        this.mDecodeThread = null;
        this.mPlayListener = null;
        this.mLoop = false;
        this.mVideoWidth = 0;
        this.mHalfVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mGLViewWidth = 0;
        this.mGLViewHeight = 0;
        this.mCropValue = 0.0f;
        this.mIsPortrait = true;
        this.mNeedConfigViewport = true;
        this.mContentVisible = true;
        this.mFrameTime = 0;
        this.mLock = new Object();
        this.mCurTime = 0L;
        this.mCurFrameCount = 0;
        this.mStopping = false;
        this.mTmpFilePath = null;
        this.mViewReady = false;
        this.mPlayStarting = false;
        this.DEFAULT_FRAME_RATE = 25;
        this.mDecodeListener = new IVideoFileDecodeListener() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeEnd() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                LogUtil.e(PlayTextureView.this.TAG, " onVideoDecodeEnd");
                PlayTextureView.this.mVideoWidth = 0;
                PlayTextureView.this.mVideoHeight = 0;
                PlayTextureView.this.mHalfVideoWidth = 0;
                PlayTextureView.this.mFilepath = null;
                PlayTextureView.this.onPause();
                PlayTextureView.this.processDecodeEnd();
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    LogUtil.e(PlayTextureView.this.TAG, "========= onVideoDecodeError errorCode = " + i3);
                    if (i3 == -101) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.mFilepath = null;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-11);
                        return;
                    }
                    if (i3 == -5) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-2);
                        return;
                    }
                    if (i3 == -3 || i3 == -2 || i3 == -1) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.mFilepath = null;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-1);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 8, (Object) this, i3);
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeFrame(long j3, byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Long.valueOf(j3), bArr);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                LogUtil.e(PlayTextureView.this.TAG, " onVideoDecodeStart");
                PlayTextureView.this.mCurTime = 0L;
                PlayTextureView.this.mCurFrameCount = 0;
                PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else if (PlayTextureView.this.mPlayListener != null) {
                            PlayTextureView.this.mPlayListener.onStart();
                        }
                    }
                });
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecoderCreated(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                } else {
                    LogUtil.e(PlayTextureView.this.TAG, " onVideoDecoderCreated");
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            @RequiresApi(api = 16)
            public void onVideoFormat(MediaFormat mediaFormat) {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) mediaFormat);
                    return;
                }
                if (mediaFormat != null && mediaFormat.containsKey("frame-rate")) {
                    i3 = mediaFormat.getInteger("frame-rate");
                } else {
                    i3 = 0;
                }
                if (i3 <= 0) {
                    i3 = 25;
                }
                PlayTextureView.this.mFrameTime = 1000000 / i3;
                LogUtil.v(PlayTextureView.this.TAG, "mFrame Time  = " + PlayTextureView.this.mFrameTime);
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoSize(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LogUtil.e(PlayTextureView.this.TAG, "onVideoSize() called with: width = [" + i3 + "], height = [" + i16 + "]");
                    PlayTextureView.this.mVideoWidth = i3;
                    PlayTextureView.this.mHalfVideoWidth = i3 / 2;
                    PlayTextureView.this.mVideoHeight = i16;
                    PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (PlayTextureView.this.mPlayListener != null) {
                                PlayTextureView.this.mPlayListener.onVideoSize(PlayTextureView.this.mVideoWidth, PlayTextureView.this.mVideoHeight);
                            }
                        }
                    });
                    if (PlayTextureView.this.mVideoWidth > 0 && PlayTextureView.this.mVideoHeight > 0 && PlayTextureView.this.mGLViewWidth > 0 && PlayTextureView.this.mGLViewHeight > 0) {
                        PlayTextureView.this.mNeedConfigViewport = true;
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        };
        this.mHardwareDecodeWaitForRunnable = new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (PlayTextureView.this.mViewReady && PlayTextureView.this.mHardDecoder != null && PlayTextureView.this.mFilepath != null && PlayTextureView.this.getSurface() != null) {
                    PlayTextureView playTextureView = PlayTextureView.this;
                    playTextureView.mCurRender = playTextureView.mSurfaceTextureRender;
                    int createDecoder = PlayTextureView.this.mHardDecoder.createDecoder(PlayTextureView.this.mFilepath, PlayTextureView.this.getSurface());
                    LogUtil.e(PlayTextureView.this.TAG, " ret =" + createDecoder);
                    LogUtil.v(PlayTextureView.this.TAG, "===============hardware decode create return = " + createDecoder);
                    if (createDecoder == 1) {
                        PlayTextureView.this.mHardDecoder.decode();
                    } else {
                        LogUtil.e(PlayTextureView.this.TAG, " \u4e0d\u5f00\u59cb\u89e3\u7801\u3002\u3002\u3002\u3002 ");
                    }
                }
            }
        };
        this.mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
        this.mContext = context;
        init();
    }

    public PlayTextureView(Context context, IVideoPLayListener iVideoPLayListener) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) iVideoPLayListener);
            return;
        }
        this.TAG = "VideoPlayer|PlayView";
        this.mFilepath = null;
        this.mViewHandler = new Handler();
        this.mHardDecoder = null;
        this.mSurfaceTextureRender = null;
        this.mCurRender = null;
        this.mDecodeThread = null;
        this.mPlayListener = null;
        this.mLoop = false;
        this.mVideoWidth = 0;
        this.mHalfVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mGLViewWidth = 0;
        this.mGLViewHeight = 0;
        this.mCropValue = 0.0f;
        this.mIsPortrait = true;
        this.mNeedConfigViewport = true;
        this.mContentVisible = true;
        this.mFrameTime = 0;
        this.mLock = new Object();
        this.mCurTime = 0L;
        this.mCurFrameCount = 0;
        this.mStopping = false;
        this.mTmpFilePath = null;
        this.mViewReady = false;
        this.mPlayStarting = false;
        this.DEFAULT_FRAME_RATE = 25;
        this.mDecodeListener = new IVideoFileDecodeListener() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeEnd() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                LogUtil.e(PlayTextureView.this.TAG, " onVideoDecodeEnd");
                PlayTextureView.this.mVideoWidth = 0;
                PlayTextureView.this.mVideoHeight = 0;
                PlayTextureView.this.mHalfVideoWidth = 0;
                PlayTextureView.this.mFilepath = null;
                PlayTextureView.this.onPause();
                PlayTextureView.this.processDecodeEnd();
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    LogUtil.e(PlayTextureView.this.TAG, "========= onVideoDecodeError errorCode = " + i3);
                    if (i3 == -101) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.mFilepath = null;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-11);
                        return;
                    }
                    if (i3 == -5) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-2);
                        return;
                    }
                    if (i3 == -3 || i3 == -2 || i3 == -1) {
                        PlayTextureView.this.mVideoWidth = 0;
                        PlayTextureView.this.mVideoHeight = 0;
                        PlayTextureView.this.mHalfVideoWidth = 0;
                        PlayTextureView.this.mFilepath = null;
                        PlayTextureView.this.onPause();
                        PlayTextureView.this.processDecodeError(-1);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 8, (Object) this, i3);
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeFrame(long j3, byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Long.valueOf(j3), bArr);
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                LogUtil.e(PlayTextureView.this.TAG, " onVideoDecodeStart");
                PlayTextureView.this.mCurTime = 0L;
                PlayTextureView.this.mCurFrameCount = 0;
                PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else if (PlayTextureView.this.mPlayListener != null) {
                            PlayTextureView.this.mPlayListener.onStart();
                        }
                    }
                });
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecoderCreated(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                } else {
                    LogUtil.e(PlayTextureView.this.TAG, " onVideoDecoderCreated");
                }
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            @RequiresApi(api = 16)
            public void onVideoFormat(MediaFormat mediaFormat) {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) mediaFormat);
                    return;
                }
                if (mediaFormat != null && mediaFormat.containsKey("frame-rate")) {
                    i3 = mediaFormat.getInteger("frame-rate");
                } else {
                    i3 = 0;
                }
                if (i3 <= 0) {
                    i3 = 25;
                }
                PlayTextureView.this.mFrameTime = 1000000 / i3;
                LogUtil.v(PlayTextureView.this.TAG, "mFrame Time  = " + PlayTextureView.this.mFrameTime);
            }

            @Override // com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoSize(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LogUtil.e(PlayTextureView.this.TAG, "onVideoSize() called with: width = [" + i3 + "], height = [" + i16 + "]");
                    PlayTextureView.this.mVideoWidth = i3;
                    PlayTextureView.this.mHalfVideoWidth = i3 / 2;
                    PlayTextureView.this.mVideoHeight = i16;
                    PlayTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (PlayTextureView.this.mPlayListener != null) {
                                PlayTextureView.this.mPlayListener.onVideoSize(PlayTextureView.this.mVideoWidth, PlayTextureView.this.mVideoHeight);
                            }
                        }
                    });
                    if (PlayTextureView.this.mVideoWidth > 0 && PlayTextureView.this.mVideoHeight > 0 && PlayTextureView.this.mGLViewWidth > 0 && PlayTextureView.this.mGLViewHeight > 0) {
                        PlayTextureView.this.mNeedConfigViewport = true;
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        };
        this.mHardwareDecodeWaitForRunnable = new Runnable() { // from class: com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlayTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (PlayTextureView.this.mViewReady && PlayTextureView.this.mHardDecoder != null && PlayTextureView.this.mFilepath != null && PlayTextureView.this.getSurface() != null) {
                    PlayTextureView playTextureView = PlayTextureView.this;
                    playTextureView.mCurRender = playTextureView.mSurfaceTextureRender;
                    int createDecoder = PlayTextureView.this.mHardDecoder.createDecoder(PlayTextureView.this.mFilepath, PlayTextureView.this.getSurface());
                    LogUtil.e(PlayTextureView.this.TAG, " ret =" + createDecoder);
                    LogUtil.v(PlayTextureView.this.TAG, "===============hardware decode create return = " + createDecoder);
                    if (createDecoder == 1) {
                        PlayTextureView.this.mHardDecoder.decode();
                    } else {
                        LogUtil.e(PlayTextureView.this.TAG, " \u4e0d\u5f00\u59cb\u89e3\u7801\u3002\u3002\u3002\u3002 ");
                    }
                }
            }
        };
        this.mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
        this.mContext = context;
        this.mPlayListener = iVideoPLayListener;
        init();
    }
}
