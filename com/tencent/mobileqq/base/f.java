package com.tencent.mobileqq.base;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \"2\u00020\u0001:\u0001>B\u0019\u0012\u0006\u0010#\u001a\u00020\u0019\u0012\b\u0010&\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b<\u0010=J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0016H\u0016R\u0014\u0010#\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010'R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0018\u00105\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/base/f;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "info", "", "startPlayPosMs", "", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "j", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "listener", DomainData.DOMAIN_NAME, "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "l", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "loopback", "k", "", "xYaxis", "p", "mute", "o", "f", "e", "isSucceed", "onSDKInited", "I", WadlProxyConsts.SCENE_ID, "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "Ljava/lang/Long;", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Boolean;", "isLoopback", "D", "Ljava/lang/Integer;", "E", "isMute", UserInfo.SEX_FEMALE, "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "preparedListener", "G", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "errorListener", "H", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "infoListener", "<init>", "(ILcom/tencent/superplayer/view/ISPlayerVideoView;)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f implements SDKInitListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Boolean isLoopback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer xYaxis;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Boolean isMute;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ISuperPlayer.OnVideoPreparedListener preparedListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ISuperPlayer.OnErrorListener errorListener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ISuperPlayer.OnInfoListener infoListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int sceneId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISPlayerVideoView videoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISuperPlayer superPlayer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SuperPlayerVideoInfo info;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long startPlayPosMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/base/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.base.f$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(int i3, @Nullable ISPlayerVideoView iSPlayerVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) iSPlayerVideoView);
            return;
        }
        this.sceneId = i3;
        this.videoView = iSPlayerVideoView;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.base.e
            @Override // java.lang.Runnable
            public final void run() {
                f.c(f.this);
            }
        }, 16, null, false);
        this.superPlayer = d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this$0);
        }
    }

    private final ISuperPlayer d() {
        if (QQVideoPlaySDKManager.isSDKReady() && this.videoView != null) {
            QLog.i("QWalletSafeSuperPlayer", 1, "createMediaPlayer success");
            return SuperPlayerFactory.createMediaPlayer(MobileQQ.sMobileQQ, this.sceneId, this.videoView);
        }
        QLog.w("QWalletSafeSuperPlayer", 1, "createMediaPlayer error: not ready or videoView=" + this.videoView);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, f this$0) {
        SuperPlayerVideoInfo superPlayerVideoInfo;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            ISuperPlayer d16 = this$0.d();
            if (d16 != null) {
                ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener = this$0.preparedListener;
                if (onVideoPreparedListener != null) {
                    QLog.i("QWalletSafeSuperPlayer", 1, "setOnVideoPreparedListener: " + onVideoPreparedListener);
                    d16.setOnVideoPreparedListener(onVideoPreparedListener);
                }
                ISuperPlayer.OnErrorListener onErrorListener = this$0.errorListener;
                if (onErrorListener != null) {
                    QLog.i("QWalletSafeSuperPlayer", 1, "setOnErrorListener: " + onErrorListener);
                    d16.setOnErrorListener(onErrorListener);
                }
                ISuperPlayer.OnInfoListener onInfoListener = this$0.infoListener;
                if (onInfoListener != null) {
                    QLog.i("QWalletSafeSuperPlayer", 1, "setOnInfoListener: " + onInfoListener);
                    d16.setOnInfoListener(onInfoListener);
                }
                Boolean bool = this$0.isMute;
                if (bool != null) {
                    boolean booleanValue = bool.booleanValue();
                    QLog.i("QWalletSafeSuperPlayer", 1, "isOutputMute: " + booleanValue);
                    d16.setOutputMute(booleanValue);
                }
                Integer num = this$0.xYaxis;
                if (num != null) {
                    int intValue = num.intValue();
                    QLog.i("QWalletSafeSuperPlayer", 1, "setXYaxis: " + intValue);
                    d16.setXYaxis(intValue);
                }
                Boolean bool2 = this$0.isLoopback;
                if (bool2 != null) {
                    boolean booleanValue2 = bool2.booleanValue();
                    QLog.i("QWalletSafeSuperPlayer", 1, "setLoopback: " + booleanValue2);
                    d16.setLoopback(booleanValue2);
                }
                if (this$0.context != null && (superPlayerVideoInfo = this$0.info) != null) {
                    QLog.i("QWalletSafeSuperPlayer", 1, "openMediaPlayer: " + superPlayerVideoInfo + " startPlayPosMs=" + this$0.startPlayPosMs);
                    Context context = this$0.context;
                    SuperPlayerVideoInfo superPlayerVideoInfo2 = this$0.info;
                    Long l3 = this$0.startPlayPosMs;
                    if (l3 != null) {
                        j3 = l3.longValue();
                    } else {
                        j3 = 0;
                    }
                    d16.openMediaPlayer(context, superPlayerVideoInfo2, j3);
                }
            } else {
                d16 = null;
            }
            this$0.superPlayer = d16;
        }
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        QLog.w("QWalletSafeSuperPlayer", 1, "isOutputMute error: sdk not inited");
        return true;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        QLog.w("QWalletSafeSuperPlayer", 1, "isPlayingVideo error: sdk not inited");
        return false;
    }

    public final void h(@Nullable Context context, @Nullable SuperPlayerVideoInfo info, long startPlayPosMs) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, info, Long.valueOf(startPlayPosMs));
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.openMediaPlayer(context, info, startPlayPosMs);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "openMediaPlayer error: sdk not inited");
            this.context = context;
            this.info = info;
            this.startPlayPosMs = Long.valueOf(startPlayPosMs);
        }
    }

    public final void i() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "pause error: sdk not inited");
        }
    }

    public final void j() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "releasePlayer error: sdk not inited");
            this.info = null;
            this.startPlayPosMs = null;
            this.context = null;
            this.isLoopback = null;
            this.xYaxis = null;
            this.isMute = null;
            this.preparedListener = null;
            this.errorListener = null;
            this.infoListener = null;
            this.videoView = null;
        }
    }

    public final void k(boolean loopback) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, loopback);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(loopback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "setLoopback error: sdk not inited");
            this.isLoopback = Boolean.valueOf(loopback);
        }
    }

    public final void l(@Nullable ISuperPlayer.OnErrorListener listener) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnErrorListener(listener);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "setOnErrorListener error: sdk not inited");
            this.errorListener = listener;
        }
    }

    public final void m(@Nullable ISuperPlayer.OnInfoListener listener) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnInfoListener(listener);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "setOnInfoListener error: sdk not inited");
            this.infoListener = listener;
        }
    }

    public final void n(@Nullable ISuperPlayer.OnVideoPreparedListener listener) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(listener);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "setOnVideoPreparedListener error: sdk not inited");
            this.preparedListener = listener;
        }
    }

    public final void o(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, mute);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(mute);
        } else {
            this.isMute = Boolean.valueOf(mute);
            QLog.w("QWalletSafeSuperPlayer", 1, "setOutputMute error: sdk not inited");
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
    public void onSDKInited(final boolean isSucceed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, isSucceed);
            return;
        }
        QLog.i("QWalletSafeSuperPlayer", 1, "onSDKInited: " + isSucceed);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.base.d
            @Override // java.lang.Runnable
            public final void run() {
                f.g(isSucceed, this);
            }
        });
    }

    public final void p(int xYaxis) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, xYaxis);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setXYaxis(xYaxis);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "setXYaxis error: sdk not inited");
            this.xYaxis = Integer.valueOf(xYaxis);
        }
    }

    public final void q() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWalletSafeSuperPlayer", 1, "start error: sdk not inited");
        }
    }
}
