package com.tencent.jalpha.videoplayer.view;

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
import com.tencent.jalpha.common.IntervalFpsLogTimer;
import com.tencent.jalpha.common.Logger;
import com.tencent.jalpha.common.Utils;
import com.tencent.jalpha.videoplayer.decoder.HardwareFileDecoder;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.RenderFactory;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JalphaTextureView extends GLTextureView implements GLSurfaceView.Renderer {
    static IPatchRedirector $redirector_;
    private final int DEFAULT_FRAME_RATE;
    private String TAG;
    private boolean mContentVisible;
    private Context mContext;
    private int mCurFrameCount;
    private BaseRender mCurRender;
    private long mCurTime;
    private IVideoFileDecodeListener mDecodeListener;
    private Thread mDecodeThread;
    private RenderFactory mFactory;
    private String mFilepath;
    private int mFrameTime;
    private int mGLViewHeight;
    private int mGLViewWidth;
    private IVideoFileDecoder mHardDecoder;
    private Runnable mHardwareDecodeWaitForRunnable;
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

    public JalphaTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
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
        this.mVideoHeight = 0;
        this.mGLViewWidth = 0;
        this.mGLViewHeight = 0;
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
        this.mDecodeListener = new IVideoFileDecodeListener() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeEnd() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                Logger.e(JalphaTextureView.this.TAG, " onVideoDecodeEnd");
                JalphaTextureView.this.mVideoWidth = 0;
                JalphaTextureView.this.mVideoHeight = 0;
                JalphaTextureView.this.mFilepath = null;
                JalphaTextureView.this.onPause();
                JalphaTextureView.this.processDecodeEnd();
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    Logger.e(JalphaTextureView.this.TAG, "========= onVideoDecodeError errorCode = " + i3);
                    if (i3 == -101) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.mFilepath = null;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-11);
                        return;
                    }
                    if (i3 == -5) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-2);
                        return;
                    }
                    if (i3 == -3 || i3 == -2 || i3 == -1) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.mFilepath = null;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-1);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 8, (Object) this, i3);
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeFrame(long j3, byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Long.valueOf(j3), bArr);
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                Logger.e(JalphaTextureView.this.TAG, " onVideoDecodeStart");
                JalphaTextureView.this.mCurTime = 0L;
                JalphaTextureView.this.mCurFrameCount = 0;
                JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1.2
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
                        } else if (JalphaTextureView.this.mPlayListener != null) {
                            JalphaTextureView.this.mPlayListener.onStart();
                        }
                    }
                });
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecoderCreated(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                } else {
                    Logger.e(JalphaTextureView.this.TAG, " onVideoDecoderCreated");
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
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
                JalphaTextureView.this.mFrameTime = 1000000 / i3;
                Logger.v(JalphaTextureView.this.TAG, "mFrame Time  = " + JalphaTextureView.this.mFrameTime);
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoSize(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    Logger.e(JalphaTextureView.this.TAG, "onVideoSize() called with: width = [" + i3 + "], height = [" + i16 + "]");
                    JalphaTextureView.this.mVideoWidth = i3;
                    JalphaTextureView.this.mVideoHeight = i16;
                    JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1.1
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
                            } else if (JalphaTextureView.this.mPlayListener != null) {
                                JalphaTextureView.this.mPlayListener.onVideoSize(JalphaTextureView.this.mVideoWidth, JalphaTextureView.this.mVideoHeight);
                            }
                        }
                    });
                    JalphaTextureView.this.mNeedConfigViewport = true;
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        };
        this.mHardwareDecodeWaitForRunnable = new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (JalphaTextureView.this.mViewReady && JalphaTextureView.this.mHardDecoder != null && JalphaTextureView.this.mFilepath != null && JalphaTextureView.this.getSurface() != null) {
                    JalphaTextureView jalphaTextureView = JalphaTextureView.this;
                    jalphaTextureView.mCurRender = jalphaTextureView.mSurfaceTextureRender;
                    int createDecoder = JalphaTextureView.this.mHardDecoder.createDecoder(JalphaTextureView.this.mFilepath, JalphaTextureView.this.getSurface());
                    Logger.e(JalphaTextureView.this.TAG, " ret =" + createDecoder);
                    Logger.v(JalphaTextureView.this.TAG, "===============hardware decode create return = " + createDecoder);
                    if (createDecoder == 1) {
                        JalphaTextureView.this.mHardDecoder.decode();
                    } else {
                        Logger.e(JalphaTextureView.this.TAG, " \u4e0d\u5f00\u59cb\u89e3\u7801\u3002\u3002\u3002\u3002 ");
                    }
                }
            }
        };
        this.mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
        this.mContext = context;
        init();
    }

    private void callbackError(int i3) {
        Handler handler;
        if (this.mPlayListener != null && (handler = this.mViewHandler) != null) {
            handler.post(new Runnable(i3) { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$errorCode;

                {
                    this.val$errorCode = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (JalphaTextureView.this.mPlayListener != null) {
                        JalphaTextureView.this.mPlayListener.onError(this.val$errorCode);
                    }
                }
            });
        }
    }

    private void configViewportOnDraw() {
        if (this.mCurRender != null) {
            GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Surface getSurface() {
        BaseRender baseRender = this.mSurfaceTextureRender;
        if (baseRender != null) {
            return baseRender.getSurface();
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
        queueEvent(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    JalphaTextureView.this.releaseRenderGLThread();
                    JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.4.1
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
                            Logger.v(JalphaTextureView.this.TAG, "==============PlayView set gone");
                            JalphaTextureView.this.setVisibility(8);
                            if (JalphaTextureView.this.mPlayListener != null) {
                                JalphaTextureView.this.mPlayListener.onEnd();
                            }
                        }
                    });
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        if (JalphaTextureView.this.getVisibility() == 8) {
                            break;
                        }
                        Logger.v(JalphaTextureView.this.TAG, "==============PlayView wait set GONE");
                        try {
                            LockMethodProxy.sleep(50L);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                        if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                            Logger.v(JalphaTextureView.this.TAG, "==============PlayView set GONE time out");
                            break;
                        }
                    }
                    Logger.v(JalphaTextureView.this.TAG, "==============PlayView set GONE over");
                    JalphaTextureView.this.mPlayStarting = false;
                    JalphaTextureView.this.mViewReady = false;
                    if (JalphaTextureView.this.mStopping) {
                        JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.4.2
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
                                    JalphaTextureView.this.mStopping = false;
                                    if (JalphaTextureView.this.mTmpFilePath != null) {
                                        Logger.v(JalphaTextureView.this.TAG, "==============stopping need play file again");
                                        JalphaTextureView jalphaTextureView = JalphaTextureView.this;
                                        jalphaTextureView.playFile(jalphaTextureView.mTmpFilePath);
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
        queueEvent(new Runnable(i3) { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$errorCode;

            {
                this.val$errorCode = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    JalphaTextureView.this.releaseRenderGLThread();
                    JalphaTextureView.this.mPlayStarting = false;
                    JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.5.1
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
                            JalphaTextureView.this.setVisibility(8);
                            if (JalphaTextureView.this.mPlayListener != null) {
                                JalphaTextureView.this.mPlayListener.onError(AnonymousClass5.this.val$errorCode);
                            }
                        }
                    });
                    JalphaTextureView.this.mViewReady = false;
                    if (this.val$errorCode == -2) {
                        Log.v(JalphaTextureView.this.TAG, "  need switch software decode ");
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
            BaseRender createRender = this.mFactory.createRender();
            this.mSurfaceTextureRender = createRender;
            createRender.setup();
            setupFrameListenerOES();
        } catch (Exception e16) {
            Logger.v(this.TAG, "mSurfaceTextureRender Exception switch  soft decode Exception=" + e16);
            e16.printStackTrace();
        }
    }

    private void setupFrameListenerOES() {
        BaseRender baseRender = this.mSurfaceTextureRender;
        if (baseRender != null && baseRender.getRenderType() == 1 && this.mSurfaceTextureRender.getVideoTexture() != null) {
            this.mSurfaceTextureRender.getVideoTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                    }
                }

                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceTexture);
                    } else {
                        JalphaTextureView.this.requestRender();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mContentVisible;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) gl10);
            return;
        }
        if (this.mViewReady && this.mCurRender != null && (i3 = this.mVideoWidth) > 0 && (i16 = this.mVideoHeight) > 0) {
            if (this.mNeedConfigViewport && i3 > 0 && i16 > 0 && this.mGLViewWidth > 0 && this.mGLViewHeight > 0) {
                configViewportOnDraw();
                BaseRender baseRender = this.mSurfaceTextureRender;
                if (baseRender != null) {
                    baseRender.updateSize(this.mGLViewWidth, this.mGLViewHeight, this.mVideoWidth, this.mVideoHeight);
                }
                this.mNeedConfigViewport = false;
            }
            this.mCurRender.draw(null, this.mGLViewWidth, this.mGLViewHeight);
            if (this.mFrameTime > 0) {
                this.mCurFrameCount = this.mCurFrameCount + 1;
                this.mCurTime = r5 * r0;
                this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.8
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (JalphaTextureView.this.mPlayListener != null) {
                            JalphaTextureView.this.mPlayListener.onPlayAtTime(JalphaTextureView.this.mCurTime);
                        }
                    }
                });
            }
            if (this.mOnPreviewFrameLogTimer.isTimeToWriteLog()) {
                Logger.i(this.TAG, "onDrawFrame fps= " + this.mOnPreviewFrameLogTimer.getFps());
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, gl10, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Logger.e(this.TAG, "===================gl render onSurfaceChanged " + i3 + " h=" + i16);
        gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.mGLViewWidth = i3;
        this.mGLViewHeight = i16;
        this.mNeedConfigViewport = true;
        if (!this.mViewReady) {
            this.mViewReady = true;
            this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        JalphaTextureView.this.startDecode();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) gl10, (Object) eGLConfig);
        } else {
            Logger.e(this.TAG, "===================gl render onSurfaceCreated");
            setupDecodeRender();
        }
    }

    public void playFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (this.mStopping) {
            this.mTmpFilePath = str;
        } else {
            this.mTmpFilePath = null;
        }
        Logger.e(this.TAG, " playFile , want to play filepath =" + str);
        if (this.mPlayStarting) {
            Logger.v(this.TAG, " playFile , one has already in playing , return");
            return;
        }
        this.mPlayStarting = true;
        if (Utils.fileIsExists(str)) {
            this.mFilepath = str;
            this.mCurRender = null;
            new BaseThread(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        JalphaTextureView.this.onResume();
                    }
                }
            }).start();
            setVisibility(0);
            return;
        }
        Logger.e(this.TAG, " file , get error");
        callbackError(-1);
        this.mPlayStarting = false;
    }

    public void setContentVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mContentVisible = z16;
        }
    }

    public void setLoopState(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.mLoop = z16;
        IVideoFileDecoder iVideoFileDecoder = this.mHardDecoder;
        if (iVideoFileDecoder != null) {
            iVideoFileDecoder.setLoopState(z16);
        }
    }

    public void setNeedLowPrecision(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
    }

    public void setPlayListener(IVideoPLayListener iVideoPLayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVideoPLayListener);
        } else {
            this.mPlayListener = iVideoPLayListener;
        }
    }

    public void setRenderFactory(RenderFactory renderFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) renderFactory);
        } else {
            this.mFactory = renderFactory;
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
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
        setVisibility(8);
        this.mStopping = true;
    }

    public JalphaTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
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
        this.mVideoHeight = 0;
        this.mGLViewWidth = 0;
        this.mGLViewHeight = 0;
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
        this.mDecodeListener = new IVideoFileDecodeListener() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeEnd() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                Logger.e(JalphaTextureView.this.TAG, " onVideoDecodeEnd");
                JalphaTextureView.this.mVideoWidth = 0;
                JalphaTextureView.this.mVideoHeight = 0;
                JalphaTextureView.this.mFilepath = null;
                JalphaTextureView.this.onPause();
                JalphaTextureView.this.processDecodeEnd();
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    Logger.e(JalphaTextureView.this.TAG, "========= onVideoDecodeError errorCode = " + i3);
                    if (i3 == -101) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.mFilepath = null;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-11);
                        return;
                    }
                    if (i3 == -5) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-2);
                        return;
                    }
                    if (i3 == -3 || i3 == -2 || i3 == -1) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.mFilepath = null;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-1);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 8, (Object) this, i3);
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeFrame(long j3, byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Long.valueOf(j3), bArr);
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                Logger.e(JalphaTextureView.this.TAG, " onVideoDecodeStart");
                JalphaTextureView.this.mCurTime = 0L;
                JalphaTextureView.this.mCurFrameCount = 0;
                JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1.2
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
                        } else if (JalphaTextureView.this.mPlayListener != null) {
                            JalphaTextureView.this.mPlayListener.onStart();
                        }
                    }
                });
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecoderCreated(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                } else {
                    Logger.e(JalphaTextureView.this.TAG, " onVideoDecoderCreated");
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
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
                JalphaTextureView.this.mFrameTime = 1000000 / i3;
                Logger.v(JalphaTextureView.this.TAG, "mFrame Time  = " + JalphaTextureView.this.mFrameTime);
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoSize(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    Logger.e(JalphaTextureView.this.TAG, "onVideoSize() called with: width = [" + i3 + "], height = [" + i16 + "]");
                    JalphaTextureView.this.mVideoWidth = i3;
                    JalphaTextureView.this.mVideoHeight = i16;
                    JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1.1
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
                            } else if (JalphaTextureView.this.mPlayListener != null) {
                                JalphaTextureView.this.mPlayListener.onVideoSize(JalphaTextureView.this.mVideoWidth, JalphaTextureView.this.mVideoHeight);
                            }
                        }
                    });
                    JalphaTextureView.this.mNeedConfigViewport = true;
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        };
        this.mHardwareDecodeWaitForRunnable = new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (JalphaTextureView.this.mViewReady && JalphaTextureView.this.mHardDecoder != null && JalphaTextureView.this.mFilepath != null && JalphaTextureView.this.getSurface() != null) {
                    JalphaTextureView jalphaTextureView = JalphaTextureView.this;
                    jalphaTextureView.mCurRender = jalphaTextureView.mSurfaceTextureRender;
                    int createDecoder = JalphaTextureView.this.mHardDecoder.createDecoder(JalphaTextureView.this.mFilepath, JalphaTextureView.this.getSurface());
                    Logger.e(JalphaTextureView.this.TAG, " ret =" + createDecoder);
                    Logger.v(JalphaTextureView.this.TAG, "===============hardware decode create return = " + createDecoder);
                    if (createDecoder == 1) {
                        JalphaTextureView.this.mHardDecoder.decode();
                    } else {
                        Logger.e(JalphaTextureView.this.TAG, " \u4e0d\u5f00\u59cb\u89e3\u7801\u3002\u3002\u3002\u3002 ");
                    }
                }
            }
        };
        this.mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
        this.mContext = context;
        init();
    }

    public JalphaTextureView(Context context, IVideoPLayListener iVideoPLayListener) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) iVideoPLayListener);
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
        this.mVideoHeight = 0;
        this.mGLViewWidth = 0;
        this.mGLViewHeight = 0;
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
        this.mDecodeListener = new IVideoFileDecodeListener() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeEnd() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                Logger.e(JalphaTextureView.this.TAG, " onVideoDecodeEnd");
                JalphaTextureView.this.mVideoWidth = 0;
                JalphaTextureView.this.mVideoHeight = 0;
                JalphaTextureView.this.mFilepath = null;
                JalphaTextureView.this.onPause();
                JalphaTextureView.this.processDecodeEnd();
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    Logger.e(JalphaTextureView.this.TAG, "========= onVideoDecodeError errorCode = " + i3);
                    if (i3 == -101) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.mFilepath = null;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-11);
                        return;
                    }
                    if (i3 == -5) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-2);
                        return;
                    }
                    if (i3 == -3 || i3 == -2 || i3 == -1) {
                        JalphaTextureView.this.mVideoWidth = 0;
                        JalphaTextureView.this.mVideoHeight = 0;
                        JalphaTextureView.this.mFilepath = null;
                        JalphaTextureView.this.onPause();
                        JalphaTextureView.this.processDecodeError(-1);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 8, (Object) this, i3);
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeFrame(long j3, byte[] bArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Long.valueOf(j3), bArr);
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecodeStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                Logger.e(JalphaTextureView.this.TAG, " onVideoDecodeStart");
                JalphaTextureView.this.mCurTime = 0L;
                JalphaTextureView.this.mCurFrameCount = 0;
                JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1.2
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
                        } else if (JalphaTextureView.this.mPlayListener != null) {
                            JalphaTextureView.this.mPlayListener.onStart();
                        }
                    }
                });
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoDecoderCreated(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                } else {
                    Logger.e(JalphaTextureView.this.TAG, " onVideoDecoderCreated");
                }
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
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
                JalphaTextureView.this.mFrameTime = 1000000 / i3;
                Logger.v(JalphaTextureView.this.TAG, "mFrame Time  = " + JalphaTextureView.this.mFrameTime);
            }

            @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener
            public void onVideoSize(int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    Logger.e(JalphaTextureView.this.TAG, "onVideoSize() called with: width = [" + i3 + "], height = [" + i16 + "]");
                    JalphaTextureView.this.mVideoWidth = i3;
                    JalphaTextureView.this.mVideoHeight = i16;
                    JalphaTextureView.this.mViewHandler.post(new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.1.1
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
                            } else if (JalphaTextureView.this.mPlayListener != null) {
                                JalphaTextureView.this.mPlayListener.onVideoSize(JalphaTextureView.this.mVideoWidth, JalphaTextureView.this.mVideoHeight);
                            }
                        }
                    });
                    JalphaTextureView.this.mNeedConfigViewport = true;
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        };
        this.mHardwareDecodeWaitForRunnable = new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.JalphaTextureView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) JalphaTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (JalphaTextureView.this.mViewReady && JalphaTextureView.this.mHardDecoder != null && JalphaTextureView.this.mFilepath != null && JalphaTextureView.this.getSurface() != null) {
                    JalphaTextureView jalphaTextureView = JalphaTextureView.this;
                    jalphaTextureView.mCurRender = jalphaTextureView.mSurfaceTextureRender;
                    int createDecoder = JalphaTextureView.this.mHardDecoder.createDecoder(JalphaTextureView.this.mFilepath, JalphaTextureView.this.getSurface());
                    Logger.e(JalphaTextureView.this.TAG, " ret =" + createDecoder);
                    Logger.v(JalphaTextureView.this.TAG, "===============hardware decode create return = " + createDecoder);
                    if (createDecoder == 1) {
                        JalphaTextureView.this.mHardDecoder.decode();
                    } else {
                        Logger.e(JalphaTextureView.this.TAG, " \u4e0d\u5f00\u59cb\u89e3\u7801\u3002\u3002\u3002\u3002 ");
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
