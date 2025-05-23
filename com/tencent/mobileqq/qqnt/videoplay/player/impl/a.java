package com.tencent.mobileqq.qqnt.videoplay.player.impl;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.param.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018R\u0016\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u001e\u0010%\u001a\n #*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/a;", "", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "e", "", "d", "c", "", "time", "", "i", "b", "", "g", "l", h.F, "isPlayError", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "filePath", "a", "isMute", "j", "f", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "playParam", "k", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "videoParam", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/b;", "Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/b;", "delegate", "Lcom/tencent/superplayer/api/ISuperPlayer;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "mPlayer", "kotlin.jvm.PlatformType", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "mPlayerView", "<init>", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/b;)V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c videoParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b delegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISuperPlayer mPlayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ISPlayerVideoView mPlayerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/player/impl/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.player.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39608);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull c videoParam, @NotNull b delegate) {
        Intrinsics.checkNotNullParameter(videoParam, "videoParam");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) videoParam, (Object) delegate);
            return;
        }
        this.videoParam = videoParam;
        this.delegate = delegate;
        this.mPlayerView = SuperPlayerFactory.createPlayerVideoView(BaseApplication.context);
    }

    public final boolean a(@NotNull String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) filePath)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new File(filePath).exists();
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.mPlayer != null) {
            m(false);
            QLog.i("VideoPlay_PlayCore", 2, "[createPlayer] stop previous, player: " + this.mPlayer + ", playerCore: " + this);
        }
        this.mPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.context, this.videoParam.c(), this.mPlayerView);
        if (this.videoParam.a().e()) {
            ISuperPlayer iSuperPlayer = this.mPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.setXYaxis(2);
            }
        } else {
            ISuperPlayer iSuperPlayer2 = this.mPlayer;
            if (iSuperPlayer2 != null) {
                iSuperPlayer2.setXYaxis(0);
            }
        }
        if (this.videoParam.a().d() > 0) {
            ISuperPlayer iSuperPlayer3 = this.mPlayer;
            if (iSuperPlayer3 != null) {
                iSuperPlayer3.setLoopback(this.videoParam.a().b(), 0L, this.videoParam.a().d());
            }
        } else {
            ISuperPlayer iSuperPlayer4 = this.mPlayer;
            if (iSuperPlayer4 != null) {
                iSuperPlayer4.setLoopback(this.videoParam.a().b());
            }
        }
        ISuperPlayer iSuperPlayer5 = this.mPlayer;
        if (iSuperPlayer5 != null) {
            iSuperPlayer5.setOutputMute(this.videoParam.a().c());
        }
        ISuperPlayer iSuperPlayer6 = this.mPlayer;
        if (iSuperPlayer6 != null) {
            iSuperPlayer6.setOnVideoPreparedListener(this.delegate);
        }
        ISuperPlayer iSuperPlayer7 = this.mPlayer;
        if (iSuperPlayer7 != null) {
            iSuperPlayer7.setOnCompletionListener(this.delegate);
        }
        ISuperPlayer iSuperPlayer8 = this.mPlayer;
        if (iSuperPlayer8 != null) {
            iSuperPlayer8.setOnSeekCompleteListener(this.delegate);
        }
        ISuperPlayer iSuperPlayer9 = this.mPlayer;
        if (iSuperPlayer9 != null) {
            iSuperPlayer9.setOnInfoListener(this.delegate);
        }
        ISuperPlayer iSuperPlayer10 = this.mPlayer;
        if (iSuperPlayer10 != null) {
            iSuperPlayer10.setOnErrorListener(this.delegate);
        }
        ISuperPlayer iSuperPlayer11 = this.mPlayer;
        if (iSuperPlayer11 != null) {
            iSuperPlayer11.setOnCaptureImageListener(this.delegate);
        }
        this.mPlayerView.addViewCallBack(this.delegate);
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_PlayCore", 2, "createPlayer, player: " + this.mPlayer + ", playerCore: " + this);
        }
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPositionMs();
        }
        return 0L;
    }

    public final long d() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            j3 = iSuperPlayer.getDurationMs();
        } else {
            j3 = 0;
        }
        if (j3 <= 0) {
            return this.videoParam.g().c();
        }
        return j3;
    }

    @Nullable
    public final ISPlayerVideoView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ISPlayerVideoView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mPlayerView;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g() {
        boolean z16;
        c cVar;
        boolean z17;
        c cVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        c cVar3 = this.videoParam;
        boolean z18 = false;
        boolean z19 = true;
        if (cVar3.b() && cVar3.e() != null) {
            String e16 = cVar3.e();
            Intrinsics.checkNotNull(e16);
            if (a(e16)) {
                z16 = true;
                cVar = null;
                if (!z16) {
                    cVar3 = null;
                }
                if (cVar3 == null) {
                    SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(cVar3.e(), cVar3.g().d(), cVar3.g().b());
                    ISuperPlayer iSuperPlayer = this.mPlayer;
                    if (iSuperPlayer != null) {
                        iSuperPlayer.openMediaPlayer(BaseApplication.context, createVideoInfoForUrl, cVar3.a().f());
                    }
                    cVar3.a().j(0L);
                    z17 = true;
                } else {
                    z17 = false;
                }
                cVar2 = this.videoParam;
                if (!cVar2.b() && cVar2.d() != null) {
                    z18 = true;
                }
                if (z18) {
                    cVar = cVar2;
                }
                if (cVar == null) {
                    SuperPlayerVideoInfo createVideoInfoForUrl2 = SuperPlayerFactory.createVideoInfoForUrl(cVar.d(), cVar.g().d(), cVar.g().b(), cVar.f());
                    QLog.i("VideoPlay_PlayCore", 2, "openPlayer, videoDurationMs: " + cVar.g().c());
                    createVideoInfoForUrl2.setVideoDurationMs(cVar.g().c());
                    createVideoInfoForUrl2.setCookies(cVar.g().a());
                    ISuperPlayer iSuperPlayer2 = this.mPlayer;
                    if (iSuperPlayer2 != null) {
                        iSuperPlayer2.openMediaPlayer(BaseApplication.context, createVideoInfoForUrl2, cVar.a().f());
                    }
                    cVar.a().j(0L);
                } else {
                    z19 = z17;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("VideoPlay_PlayCore", 2, "openPlayer, result: " + z19 + ", " + this.mPlayer);
                }
                return z19;
            }
        }
        z16 = false;
        cVar = null;
        if (!z16) {
        }
        if (cVar3 == null) {
        }
        cVar2 = this.videoParam;
        if (!cVar2.b()) {
            z18 = true;
        }
        if (z18) {
        }
        if (cVar == null) {
        }
        if (QLog.isColorLevel()) {
        }
        return z19;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            if (!iSuperPlayer.isPlaying()) {
                iSuperPlayer = null;
            }
            if (iSuperPlayer != null) {
                iSuperPlayer.pause();
            }
        }
    }

    public final void i(int time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, time);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo(time, 3);
        }
    }

    public final void j(boolean isMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, isMute);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(isMute);
        }
    }

    public final void k(@NotNull c playParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) playParam);
        } else {
            Intrinsics.checkNotNullParameter(playParam, "playParam");
            this.videoParam = playParam;
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }

    public final void m(boolean isPlayError) {
        ISuperPlayer iSuperPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, isPlayError);
            return;
        }
        this.mPlayerView.removeViewCallBack(this.delegate);
        if (!isPlayError && (iSuperPlayer = this.mPlayer) != null) {
            iSuperPlayer.stop();
        }
        ISuperPlayer iSuperPlayer2 = this.mPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.release();
        }
        ISuperPlayer iSuperPlayer3 = this.mPlayer;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setOnCaptureImageListener(null);
        }
        this.mPlayer = null;
        QLog.i("VideoPlay_PlayCore", 2, "stop and release, player: " + ((Object) null) + ", playcore: " + this);
    }
}
