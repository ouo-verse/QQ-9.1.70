package com.tencent.mobileqq.qqnt.videoplay.player.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.player.PlayState;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u00015B\u0017\u0012\u0006\u00100\u001a\u00020(\u0012\u0006\u00101\u001a\u00020,\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\u001c\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J4\u0010\"\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\"\u0010#\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0012\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010&\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010'\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/b;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnSeekCompleteListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCaptureImageListener;", "Lcom/tencent/superplayer/view/ISPlayerVideoView$IVideoViewCallBack;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "p0", "", "onVideoPrepared", "", "what", "", "arg1", "arg2", "", "extra", "", "onInfo", "onSeekComplete", "onCompletion", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onError", "p1", "p2", "p3", "Landroid/graphics/Bitmap;", "p4", "onCaptureImageSucceed", "onCaptureImageFailed", "surfaceOrHolder", "onSurfaceCreated", "onSurfaceDestroy", "onSurfaceChanged", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/PlayCoreProxy;", "d", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/PlayCoreProxy;", "mPlayProxy", "Lcom/tencent/mobileqq/qqnt/videoplay/player/b;", "e", "Lcom/tencent/mobileqq/qqnt/videoplay/player/b;", "mCallback", "playProxy", "callback", "<init>", "(Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/PlayCoreProxy;Lcom/tencent/mobileqq/qqnt/videoplay/player/b;)V", "f", "a", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnCaptureImageListener, ISPlayerVideoView.IVideoViewCallBack {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PlayCoreProxy mPlayProxy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqnt.videoplay.player.b mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.player.impl.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39622);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull PlayCoreProxy playProxy, @NotNull com.tencent.mobileqq.qqnt.videoplay.player.b callback) {
        Intrinsics.checkNotNullParameter(playProxy, "playProxy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) playProxy, (Object) callback);
        } else {
            this.mPlayProxy = playProxy;
            this.mCallback = callback;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(@Nullable ISuperPlayer p06, int p16, int p26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, p06, Integer.valueOf(p16), Integer.valueOf(p26));
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(@Nullable ISuperPlayer p06, int p16, int p26, int p36, @Nullable Bitmap p46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, p06, Integer.valueOf(p16), Integer.valueOf(p26), Integer.valueOf(p36), p46);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(@Nullable ISuperPlayer p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCoreCallback", 2, "onCompletion");
        }
        this.mPlayProxy.d(PlayState.STATE_COMPLETE);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(@Nullable ISuperPlayer p06, int module, int errorType, int errorCode, @Nullable String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, p06, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo)).booleanValue();
        }
        QLog.e("VideoPlay_PlayCoreCallback", 1, "onError, module:" + module + ", errorType:" + errorType + ", errorCode:" + errorCode + ", extraInfo:" + extraInfo);
        this.mCallback.c(module, errorType, errorCode, extraInfo);
        this.mPlayProxy.d(PlayState.STATE_ERROR);
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(@Nullable ISuperPlayer p06, int what, long arg1, long arg2, @Nullable Object extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, p06, Integer.valueOf(what), Long.valueOf(arg1), Long.valueOf(arg2), extra)).booleanValue();
        }
        if (what != 105) {
            if (what != 108) {
                if (what != 201) {
                    if (what != 207) {
                        if (what != 112) {
                            if (what == 113) {
                                if (this.mPlayProxy.getPlayState().isPaused()) {
                                    this.mPlayProxy.d(PlayState.STATE_PAUSE);
                                } else {
                                    this.mPlayProxy.d(PlayState.STATE_PLAYING);
                                }
                                this.mCallback.onBufferEnd();
                            }
                        } else {
                            this.mPlayProxy.d(PlayState.STATE_BUFFERING);
                            this.mCallback.onBufferStart();
                        }
                    } else if (extra instanceof TPDownloadProgressInfo) {
                        this.mCallback.d(((TPDownloadProgressInfo) extra).getDownloadBytes());
                    }
                } else {
                    this.mCallback.onDownloadComplete();
                }
            } else {
                this.mCallback.b(this.mPlayProxy.getCurrentPositionMs());
            }
        } else {
            this.mCallback.onFirstFrameRendered();
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(@Nullable ISuperPlayer p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) p06);
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceChanged(@Nullable Object surfaceOrHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, surfaceOrHolder);
        } else if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCoreCallback", 1, "onSurfaceChanged");
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceCreated(@Nullable Object surfaceOrHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, surfaceOrHolder);
        } else if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCoreCallback", 1, "onSurfaceCreated");
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceDestroy(@Nullable Object surfaceOrHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, surfaceOrHolder);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCoreCallback", 1, "onSurfaceDestroy");
        }
        this.mCallback.onSurfaceDestroy();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(@Nullable ISuperPlayer p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCoreCallback", 2, "onVideoPrepared");
        }
        this.mPlayProxy.e();
        this.mCallback.onVideoPrepared();
    }
}
