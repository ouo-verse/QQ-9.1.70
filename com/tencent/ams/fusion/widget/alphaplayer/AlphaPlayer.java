package com.tencent.ams.fusion.widget.alphaplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.ams.fusion.widget.alphaplayer.gl.AlphaTextureRenderer;
import com.tencent.ams.fusion.widget.alphaplayer.gl.CompressAlphaTextureRenderer;
import com.tencent.ams.fusion.widget.alphaplayer.gl.FormatType;
import com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;
import com.tencent.ams.fusion.widget.alphaplayer.player.ManualDecoderPlayer;
import com.tencent.ams.fusion.widget.alphaplayer.player.SystemMediaPlayer;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* loaded from: classes3.dex */
public class AlphaPlayer {
    static IPatchRedirector $redirector_ = null;
    public static final int CODE_GL_INIT_FAILED = 9000;
    public static final int CODE_INIT_PLAYER_FAILED = 9002;
    public static final int CODE_PLAYER_START_FAILED = 9003;
    public static final int CODE_PREPARE_FAILED = 9001;
    public static final int CODE_PREPARE_FAILED_EMPTY_SOURCE = 9004;
    public static final int STATE_COMPLETED = 8;
    public static final int STATE_ERROR = 9;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_SEEK_COMPLETED = 7;
    public static final int STATE_STOPPED = 5;
    private static final String TAG = "AlphaPlayer";
    private Handler mAsyncTaskHandler;
    private HandlerThread mAsyncTaskHandlerThread;
    private String mDataSource;
    private volatile boolean mInitSuccesed;
    private final IPlayer.OnErrorListener mInnerOnErrorListener;
    private final IPlayer.OnInfoListener mInnerOnInfoListener;
    private final IPlayer.OnPreparedListener mInnerOnPreparedListener;
    private final IPlayer.OnSeekCompleteListener mInnerOnSeekCompleteListener;
    private AlphaPlayerListener mListener;
    private boolean mLoopPlay;
    private IPlayer.OnCompletionListener mOnCompletionListener;
    private IPlayer.OnErrorListener mOnErrorListener;
    private IPlayer.OnInfoListener mOnInfoListener;
    private IPlayer.OnPreparedListener mOnPreparedListener;
    private IPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private boolean mOutputMute;
    private int mPlayFailCode;
    private IPlayer mPlayer;
    private volatile int mPlayerState;
    private AlphaTextureRenderer mRenderer;
    private RendererInfo mRendererInfo;
    private boolean mTargetPlaying;
    private final IPlayer.OnCompletionListener onInnerCompletionListener;
    private final TextureSurfaceRenderer.RendererStatusChangeListener rendererStatusChangeListener;

    /* loaded from: classes3.dex */
    public interface AlphaPlayerListener {
        boolean executeTask(Runnable runnable);

        void onComplete();

        void onError(int i3);

        boolean onInfo(int i3, int i16);

        void onPause();

        void onPrepared(int i3, int i16);

        void onSeekComplete();

        void onStart();

        void onStop();
    }

    public AlphaPlayer(RendererInfo rendererInfo, AlphaPlayerListener alphaPlayerListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rendererInfo, (Object) alphaPlayerListener);
            return;
        }
        this.mPlayerState = 0;
        this.mTargetPlaying = false;
        this.mInitSuccesed = false;
        this.rendererStatusChangeListener = new TextureSurfaceRenderer.RendererStatusChangeListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer.RendererStatusChangeListener
            public void onGLComponentsDestroy() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                } else {
                    Logger.d(AlphaPlayer.TAG, "onGLComponentsDestroy");
                    AlphaPlayer.this.mInitSuccesed = false;
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer.RendererStatusChangeListener
            public void onGLComponentsInitFailed() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                } else {
                    Logger.w(AlphaPlayer.TAG, "onGLComponentsInitFailed");
                    AlphaPlayer.this.mInitSuccesed = false;
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer.RendererStatusChangeListener
            public void onGLComponentsInitSuccess() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                } else {
                    Logger.d(AlphaPlayer.TAG, "onGLComponentsInitSuccess");
                    AlphaPlayer.this.executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.1.2
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
                                return;
                            }
                            if (!AnimatorConfig.isRebuildRenderOnceSurfaceDestroyed()) {
                                AlphaPlayer.this.initPlayerAndPrepare();
                                return;
                            }
                            if (!AlphaPlayer.this.mInitSuccesed) {
                                AlphaPlayer.this.initPlayerAndPrepare();
                                AlphaPlayer.this.mInitSuccesed = true;
                                return;
                            }
                            IPlayer iPlayer = AlphaPlayer.this.mPlayer;
                            AlphaTextureRenderer alphaTextureRenderer = AlphaPlayer.this.mRenderer;
                            if (iPlayer != null && alphaTextureRenderer != null) {
                                Logger.d("onGLComponentsInitSuccess again refresh surface ");
                                iPlayer.setSurface(new Surface(alphaTextureRenderer.getVideoTexture()));
                                try {
                                    alphaTextureRenderer.setVideoSize(iPlayer.getVideoWidth(), iPlayer.getVideoHeight());
                                } catch (Throwable th5) {
                                    Logger.e(AlphaPlayer.TAG, "setVideoSize failed", th5);
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer.RendererStatusChangeListener
            public void onGLDestroy() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, (Object) this);
                } else {
                    Logger.d(AlphaPlayer.TAG, "onGLDestroy");
                    AlphaPlayer.this.mInitSuccesed = false;
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer.RendererStatusChangeListener
            public void onGLInitFailed() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                } else {
                    Logger.w(AlphaPlayer.TAG, "onGLInitFailed");
                    AlphaPlayer.this.executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.1.1
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
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                AlphaPlayer.this.notifyListenerError(9000);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.gl.TextureSurfaceRenderer.RendererStatusChangeListener
            public void onGLInitSuccess() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    Logger.d(AlphaPlayer.TAG, "onGLInitSuccess");
                }
            }
        };
        this.mInnerOnPreparedListener = new IPlayer.OnPreparedListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iPlayer);
                    return;
                }
                Logger.d(AlphaPlayer.TAG, "onPrepared");
                IPlayer.OnPreparedListener onPreparedListener = AlphaPlayer.this.mOnPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(iPlayer);
                }
                AlphaPlayer.this.prepare(iPlayer);
            }
        };
        this.mInnerOnInfoListener = new IPlayer.OnInfoListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer.OnInfoListener
            public boolean onInfo(IPlayer iPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    IPlayer.OnInfoListener onInfoListener = AlphaPlayer.this.mOnInfoListener;
                    if (onInfoListener != null) {
                        onInfoListener.onInfo(iPlayer, i3, i16);
                    }
                    if (AlphaPlayer.this.mListener == null) {
                        return false;
                    }
                    return AlphaPlayer.this.mListener.onInfo(i3, i16);
                }
                return ((Boolean) iPatchRedirector2.redirect((short) 2, this, iPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
        };
        this.onInnerCompletionListener = new IPlayer.OnCompletionListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer.OnCompletionListener
            public void onCompletion(IPlayer iPlayer) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iPlayer);
                    return;
                }
                Logger.d(AlphaPlayer.TAG, "onCompletion");
                IPlayer.OnCompletionListener onCompletionListener = AlphaPlayer.this.mOnCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(iPlayer);
                }
                AlphaPlayer.this.executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.4.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            AlphaPlayer.this.setPlayerState(8);
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        };
        this.mInnerOnErrorListener = new IPlayer.OnErrorListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer.OnErrorListener
            public boolean onError(IPlayer iPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, this, iPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                }
                Logger.w(AlphaPlayer.TAG, "onError what:" + i3 + ", extra:" + i16);
                IPlayer.OnErrorListener onErrorListener = AlphaPlayer.this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(iPlayer, i3, i16);
                }
                AlphaPlayer.this.executeTask(new Runnable(i16) { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.5.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$code;

                    {
                        this.val$code = i16;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, i16);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            AlphaPlayer.this.notifyListenerError(this.val$code);
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return false;
            }
        };
        this.mInnerOnSeekCompleteListener = new IPlayer.OnSeekCompleteListener() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer.OnSeekCompleteListener
            public void onSeekComplete(IPlayer iPlayer) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    IPlayer.OnSeekCompleteListener onSeekCompleteListener = AlphaPlayer.this.mOnSeekCompleteListener;
                    if (onSeekCompleteListener != null) {
                        onSeekCompleteListener.onSeekComplete(iPlayer);
                    }
                    AlphaPlayer.this.executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.6.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                AlphaPlayer.this.setPlayerState(7);
                                if (AlphaPlayer.this.mTargetPlaying) {
                                    AlphaPlayer.this.mTargetPlaying = false;
                                    AlphaPlayer.this.startPlay();
                                    return;
                                }
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    });
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iPlayer);
            }
        };
        this.mRendererInfo = rendererInfo;
        this.mListener = alphaPlayerListener;
        initRenderer(rendererInfo);
    }

    private void ensureHandlerCreated() {
        ensureHandlerThreadCreated();
        if (this.mAsyncTaskHandler == null) {
            synchronized (this) {
                if (this.mAsyncTaskHandler == null) {
                    this.mAsyncTaskHandler = new Handler(this.mAsyncTaskHandlerThread.getLooper());
                }
            }
        }
    }

    private void ensureHandlerThreadCreated() {
        if (this.mAsyncTaskHandlerThread == null) {
            synchronized (this) {
                if (this.mAsyncTaskHandlerThread == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AlphaPlayer-Handler-Thread");
                    this.mAsyncTaskHandlerThread = baseHandlerThread;
                    baseHandlerThread.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask(Runnable runnable) {
        if (runnable != null) {
            try {
                AlphaPlayerListener alphaPlayerListener = this.mListener;
                if (alphaPlayerListener == null || !alphaPlayerListener.executeTask(runnable)) {
                    ensureHandlerCreated();
                    this.mAsyncTaskHandler.post(runnable);
                }
            } catch (Throwable th5) {
                Logger.e(TAG, "executeTask failed", th5);
            }
        }
    }

    private void initMediaPlayer() {
        Logger.d(TAG, "initMediaPlayer()");
        try {
            this.mPlayer = this.mRendererInfo.getDecoderPlayer();
            Logger.i(TAG, "initMediaPlayer: create from decoder player: " + this.mPlayer);
            if (this.mPlayer == null) {
                if (this.mRendererInfo.getDecoderType() == 1) {
                    this.mPlayer = new ManualDecoderPlayer();
                    Logger.i(TAG, "initMediaPlayer: create ManualDecoderPlayer");
                } else {
                    this.mPlayer = new SystemMediaPlayer();
                    Logger.i(TAG, "initMediaPlayer: create SystemMediaPlayer");
                }
            }
            this.mPlayer.setOnPreparedListener(this.mInnerOnPreparedListener);
            this.mPlayer.setOnInfoListener(this.mInnerOnInfoListener);
            this.mPlayer.setOnSeekCompleteListener(this.mInnerOnSeekCompleteListener);
            this.mPlayer.setOnCompletionListener(this.onInnerCompletionListener);
            this.mPlayer.setOnErrorListener(this.mInnerOnErrorListener);
            setPlayerState(0);
        } catch (Throwable th5) {
            th5.printStackTrace();
            Logger.d(TAG, "initMediaPlayer() Throwable");
            this.mPlayer = null;
            notifyListenerError(9002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPlayerAndPrepare() {
        initMediaPlayer();
        prepare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlayerState(int i3) {
        if (this.mPlayer != null && this.mPlayerState == i3) {
            return true;
        }
        return false;
    }

    private void notifyListener(int i3) {
        int i16;
        AlphaPlayerListener alphaPlayerListener = this.mListener;
        if (alphaPlayerListener == null) {
            return;
        }
        switch (i3) {
            case 2:
                IPlayer iPlayer = this.mPlayer;
                int i17 = 0;
                if (iPlayer != null) {
                    i16 = iPlayer.getVideoWidth();
                } else {
                    i16 = 0;
                }
                IPlayer iPlayer2 = this.mPlayer;
                if (iPlayer2 != null) {
                    i17 = iPlayer2.getVideoHeight();
                }
                this.mListener.onPrepared(i16, i17);
                return;
            case 3:
                alphaPlayerListener.onStart();
                return;
            case 4:
                alphaPlayerListener.onPause();
                return;
            case 5:
                alphaPlayerListener.onStop();
                return;
            case 6:
            default:
                return;
            case 7:
                alphaPlayerListener.onSeekComplete();
                return;
            case 8:
                alphaPlayerListener.onComplete();
                return;
            case 9:
                alphaPlayerListener.onError(this.mPlayFailCode);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenerError(int i3) {
        Logger.d(TAG, "notifyListenerError code: " + i3);
        this.mPlayFailCode = i3;
        setPlayerState(9);
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare() {
        Logger.d(TAG, "prepare() " + this.mPlayer + ", " + this.mPlayerState);
        if (this.mPlayer == null || !isPlayerState(0)) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.mDataSource)) {
                this.mPlayer.setDataSource(this.mDataSource);
                setOutputMute(this.mOutputMute);
                this.mPlayer.setLooping(this.mLoopPlay);
                this.mPlayer.setSurface(new Surface(this.mRenderer.getVideoTexture()));
                this.mPlayer.prepareAsync();
                setPlayerState(1);
                return;
            }
            notifyListenerError(9004);
            Logger.w(TAG, "prepare() failed: data source not set!");
        } catch (Throwable th5) {
            notifyListenerError(9001);
            Logger.e(TAG, "checkPrepare failed", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerState(int i3) {
        if (this.mPlayerState != i3) {
            Logger.d(TAG, "setPlayerState() " + i3);
            this.mPlayerState = i3;
            notifyListener(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        Logger.d(TAG, "start()");
        try {
            IPlayer iPlayer = this.mPlayer;
            if (iPlayer != null) {
                iPlayer.start();
                setPlayerState(3);
                AlphaTextureRenderer alphaTextureRenderer = this.mRenderer;
                if (alphaTextureRenderer != null) {
                    alphaTextureRenderer.onStart();
                }
            }
        } catch (Throwable th5) {
            Logger.e(TAG, "start failed", th5);
            notifyListenerError(9003);
        }
    }

    public long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        try {
            if (this.mPlayer != null) {
                return r0.getDuration();
            }
            return 0L;
        } catch (Throwable th5) {
            Logger.e(TAG, "getDuration failed", th5);
            return 0L;
        }
    }

    public long getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        try {
            if (this.mPlayer != null) {
                return r0.getCurrentPosition();
            }
            return 0L;
        } catch (Throwable th5) {
            Logger.e(TAG, "getPosition failed", th5);
            return 0L;
        }
    }

    public synchronized void initRenderer(RendererInfo rendererInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rendererInfo);
            return;
        }
        if (rendererInfo != null && rendererInfo.getSurface() != null && rendererInfo.getWidth() != 0 && rendererInfo.getHeight() != 0) {
            Logger.i(TAG, "initRenderer() " + rendererInfo.toString());
            if (rendererInfo.getFormatType() == FormatType.COMPRESS) {
                this.mRenderer = new CompressAlphaTextureRenderer(rendererInfo.getSurface(), rendererInfo.getWidth(), rendererInfo.getHeight(), rendererInfo.getScaleType(), this.rendererStatusChangeListener, rendererInfo.getRenderExecutor());
            } else {
                this.mRenderer = new AlphaTextureRenderer(rendererInfo.getSurface(), rendererInfo.getWidth(), rendererInfo.getHeight(), rendererInfo.getScaleType(), this.rendererStatusChangeListener, rendererInfo.getRenderExecutor());
            }
        }
    }

    public boolean isCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (this.mPlayer != null && isPlayerState(8)) {
            return true;
        }
        return false;
    }

    public boolean isPausing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.mPlayer != null && isPlayerState(4)) {
            return true;
        }
        return false;
    }

    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (this.mPlayer != null && isPlayerState(3)) {
            return true;
        }
        return false;
    }

    public void pause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        Logger.d(TAG, "pause(), isClearSurface:" + z16);
        executeTask(new Runnable(z16) { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.10
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$isClearSurface;

            {
                this.val$isClearSurface = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AlphaPlayer.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (AlphaPlayer.this.mPlayer != null && AlphaPlayer.this.isPlayerState(3)) {
                        AlphaPlayer.this.mPlayer.pause();
                        AlphaPlayer.this.setPlayerState(4);
                    }
                    if (AlphaPlayer.this.mRenderer != null) {
                        AlphaPlayer.this.mRenderer.onPause(this.val$isClearSurface);
                    }
                } catch (Throwable th5) {
                    Logger.e(AlphaPlayer.TAG, "pause failed", th5);
                }
            }
        });
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            Logger.d(TAG, "release()");
            executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.14
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (AlphaPlayer.this.mPlayer != null) {
                            AlphaPlayer.this.mPlayer.release();
                            AlphaPlayer.this.mPlayer = null;
                            AlphaPlayer.this.mInitSuccesed = false;
                            AlphaPlayer.this.setPlayerState(0);
                        }
                        AlphaPlayer.this.releaseRenderer();
                        AlphaPlayer.this.mListener = null;
                    } catch (Throwable th5) {
                        Logger.e(AlphaPlayer.TAG, "release failed", th5);
                    }
                }
            });
        }
    }

    public synchronized void releaseRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AlphaTextureRenderer alphaTextureRenderer = this.mRenderer;
        if (alphaTextureRenderer != null) {
            alphaTextureRenderer.onPause(true);
            if (AnimatorConfig.isRebuildRenderOnceSurfaceDestroyed()) {
                try {
                    this.mRenderer.finalize();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            Logger.d(TAG, "resume()");
            executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.11
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (AlphaPlayer.this.mPlayer != null && AlphaPlayer.this.isPlayerState(4)) {
                            AlphaPlayer.this.mPlayer.start();
                            AlphaPlayer.this.setPlayerState(3);
                            if (AlphaPlayer.this.mRenderer != null) {
                                AlphaPlayer.this.mRenderer.onStart();
                            }
                        }
                    } catch (Throwable th5) {
                        Logger.e(AlphaPlayer.TAG, "resume failed", th5);
                        AlphaPlayer.this.notifyListenerError(9003);
                    }
                }
            });
        }
    }

    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        Logger.d(TAG, "seekTo() " + i3);
        executeTask(new Runnable(i3) { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.12
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$position;

            {
                this.val$position = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (AlphaPlayer.this.mPlayer != null) {
                        AlphaPlayer.this.mPlayer.seekTo(this.val$position);
                    }
                } catch (Throwable th5) {
                    Logger.e(AlphaPlayer.TAG, "seekTo position:" + this.val$position + " failed", th5);
                }
            }
        });
    }

    public void setDataSource(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            Logger.w(TAG, "setDataSource with empty dataSource, prepare failed");
        } else {
            executeTask(new Runnable(str) { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.7
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$dataSource;

                {
                    this.val$dataSource = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Logger.d(AlphaPlayer.TAG, "setDataSource() " + this.val$dataSource);
                    AlphaPlayer.this.mDataSource = this.val$dataSource;
                    AlphaPlayer.this.prepare();
                }
            });
        }
    }

    public void setLoopPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        Logger.d(TAG, "setLoopPlay() " + z16);
        this.mLoopPlay = z16;
        executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.15
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (AlphaPlayer.this.mPlayer != null) {
                        Logger.d(AlphaPlayer.TAG, "setLoopPlay() real");
                        AlphaPlayer.this.mPlayer.setLooping(AlphaPlayer.this.mLoopPlay);
                    }
                } catch (Throwable th5) {
                    Logger.e(AlphaPlayer.TAG, "setLoopPlay failed", th5);
                }
            }
        });
    }

    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) onCompletionListener);
        } else {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) onErrorListener);
        } else {
            this.mOnErrorListener = onErrorListener;
        }
    }

    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) onInfoListener);
        } else {
            this.mOnInfoListener = onInfoListener;
        }
    }

    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) onPreparedListener);
        } else {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) onSeekCompleteListener);
        } else {
            this.mOnSeekCompleteListener = onSeekCompleteListener;
        }
    }

    public boolean setOutputMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, z16)).booleanValue();
        }
        Logger.d(TAG, "setOutputMute() " + z16);
        this.mOutputMute = z16;
        try {
            if (this.mPlayer != null && z16) {
                Logger.d(TAG, "setOutputMute() real");
                this.mPlayer.setVolume(0.0f, 0.0f);
                return true;
            }
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public void setSurfaceSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Logger.d(TAG, "setSurfaceSize w: " + i3 + ", h: " + i16);
        this.mRenderer.setSurfaceSize(i3, i16);
    }

    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        try {
            if (this.mPlayer != null) {
                Logger.d(TAG, "setVolume() index = " + f16);
                if (f16 > 0.0f) {
                    z16 = false;
                }
                this.mOutputMute = z16;
                this.mPlayer.setVolume(f16, f16);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void setVolumeOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            if (this.mPlayer != null) {
                Logger.d(TAG, "setVolumeOff()");
                this.mOutputMute = true;
                this.mPlayer.setVolume(0.0f, 0.0f);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void setVolumeOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            if (this.mPlayer != null) {
                Logger.d(TAG, "setVolumeOn()");
                this.mOutputMute = false;
                this.mPlayer.setVolume(1.0f, 1.0f);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            Logger.d(TAG, "startPlay()");
            executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (AlphaPlayer.this.isPlayerState(4)) {
                        AlphaPlayer.this.resume();
                        return;
                    }
                    if (AlphaPlayer.this.isPlayerState(2) || AlphaPlayer.this.isPlayerState(7)) {
                        AlphaPlayer.this.startPlay();
                        return;
                    }
                    if (AlphaPlayer.this.isPlayerState(8)) {
                        AlphaPlayer.this.seekTo(0);
                    }
                    AlphaPlayer.this.mTargetPlaying = true;
                }
            });
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            Logger.d(TAG, "stop()");
            executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (AlphaPlayer.this.mPlayer != null) {
                            AlphaPlayer.this.mPlayer.stop();
                            AlphaPlayer.this.mInitSuccesed = false;
                            AlphaPlayer.this.setPlayerState(5);
                        }
                    } catch (Throwable th5) {
                        Logger.e(AlphaPlayer.TAG, "stop failed", th5);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(IPlayer iPlayer) {
        executeTask(new Runnable(iPlayer) { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.8
            static IPatchRedirector $redirector_;
            final /* synthetic */ IPlayer val$mp;

            {
                this.val$mp = iPlayer;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphaPlayer.this, (Object) iPlayer);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AlphaPlayer.this.setPlayerState(2);
                    try {
                        AlphaPlayer.this.mRenderer.setVideoSize(this.val$mp.getVideoWidth(), this.val$mp.getVideoHeight());
                    } catch (Exception e16) {
                        Logger.e(AlphaPlayer.TAG, "prepare failed", e16);
                    }
                    if (AlphaPlayer.this.mTargetPlaying) {
                        AlphaPlayer.this.mTargetPlaying = false;
                        AlphaPlayer.this.executeTask(new Runnable() { // from class: com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.8.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    AlphaPlayer.this.startPlay();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
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
}
