package com.tencent.mobileqq.qqlive.sail.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import com.tencent.biz.richframework.video.RFWMediaFocusManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.api.player.QQLivePlayerListenerDispatcher;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbilityKt;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mi2.c;
import mi2.d;
import mi2.e;
import mi2.f;
import mi2.g;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00ab\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001K\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001RB\u0019\u0012\u0006\u0010=\u001a\u00020:\u0012\b\b\u0002\u0010A\u001a\u00020>\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010%\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010(\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010)\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010,\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010/\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00101\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u000100H\u0016J\u0012\u00102\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u000100H\u0016J\u0012\u00104\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u000103H\u0016J\u0012\u00105\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u000103H\u0016J\u0012\u00107\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u000106H\u0016J\u0012\u00108\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u000106H\u0016J\u0006\u00109\u001a\u00020\u0005R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010ER\u001c\u0010J\u001a\n H*\u0004\u0018\u00010G0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoPlayer;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "Lcom/tencent/mobileqq/qqlive/sail/player/b;", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "i", "", "j", "l", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "prepare", "startPlay", "pause", "replay", "stop", "release", "url", "switchStream", "", "isOutputMute", "mute", "setOutputMute", "isPlaying", "Landroid/util/Size;", "getVideoSize", "Landroid/view/View;", "getVideoView", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "axis", "setXYAxis", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "getPlayerQuality", "Lmi2/d;", "listener", "registerFirstFrameRenderedListener", "unRegisterFirstFrameRenderedListener", "Lmi2/h;", "registerVideoSizeChangedListener", "unRegisterVideoSizeChangedListener", "Lmi2/b;", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmi2/c;", "registerErrorListener", "unRegisterErrorListener", "Lmi2/a;", "registerBufferListener", "unRegisterBufferListener", "Lmi2/f;", "registerSwitchDefinitionListener", "unRegisterSwitchDefinitionListener", "Lmi2/e;", "registerSeiInfoListener", "unRegisterSeiInfoListener", "Lmi2/g;", "registerVideoPreparedListener", "unRegisterVideoPreparedListener", h.F, "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "e", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", DownloadInfo.spKey_Config, "", "f", "J", "roomId", "Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerListenerDispatcher;", "Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerListenerDispatcher;", "listenerDispatcher", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoContext;", "videoContext", "Lcom/tencent/biz/richframework/video/RFWMediaFocusManager;", "kotlin.jvm.PlatformType", "Lcom/tencent/biz/richframework/video/RFWMediaFocusManager;", "mRFWMediaFocusManager", "com/tencent/mobileqq/qqlive/sail/player/LiveVideoPlayer$avBlockReceiver$1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoPlayer$avBlockReceiver$1;", "avBlockReceiver", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;J)V", "D", "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveVideoPlayer extends b implements IQQLivePlayer {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveVideoPlayer$avBlockReceiver$1 avBlockReceiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PlayerConfig config;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLivePlayerListenerDispatcher listenerDispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveVideoContext videoContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final RFWMediaFocusManager mRFWMediaFocusManager;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoPlayer$a;", "", "", "ACTION_AV_BLOCK", "Ljava/lang/String;", "EXTRA_BLOCK_BUSINESS", "TAG", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.player.LiveVideoPlayer$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ LiveVideoPlayer(PlayerConfig playerConfig, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(playerConfig, (i3 & 2) != 0 ? 0L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, playerConfig, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveVideoContext i() {
        LiveVideoContext liveVideoContext = this.videoContext;
        if (liveVideoContext != null) {
            return liveVideoContext;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("QQLive_Player|LiveVideoPlayer", "ensureVideoContext", "roomId=" + this.roomId);
        }
        LiveVideoContext liveVideoContext2 = new LiveVideoContext();
        liveVideoContext2.w(this.config);
        liveVideoContext2.x(SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext().getApplicationContext(), this.config.s()));
        liveVideoContext2.y(this.roomId);
        liveVideoContext2.r(this.listenerDispatcher);
        this.videoContext = liveVideoContext2;
        return liveVideoContext2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        QLog.d("QQLive_Player|LiveVideoPlayer", 1, "registerAVBlockReceiver");
        try {
            MobileQQ.sMobileQQ.registerReceiver(this.avBlockReceiver, new IntentFilter("action_av_block"));
        } catch (Throwable th5) {
            QLog.e("QQLive_Player|LiveVideoPlayer", 1, "registerAVBlockReceiver exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        QLog.d("QQLive_Player|LiveVideoPlayer", 1, "unRegisterAVBlockReceiver");
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.avBlockReceiver);
        } catch (Throwable th5) {
            QLog.e("QQLive_Player|LiveVideoPlayer", 1, "unRegisterAVBlockReceiver exception:", th5);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public com.tencent.mobileqq.qqlive.sail.model.player.a getPlayerQuality() {
        a k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.qqlive.sail.model.player.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        LiveVideoContext liveVideoContext = this.videoContext;
        if (liveVideoContext != null && (k3 = liveVideoContext.k()) != null) {
            return k3.c();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public Size getVideoSize() {
        int i3;
        ISuperPlayer h16;
        ISuperPlayer h17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Size) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        LiveVideoContext liveVideoContext = this.videoContext;
        int i16 = 0;
        if (liveVideoContext != null && (h17 = liveVideoContext.h()) != null) {
            i3 = h17.getVideoWidth();
        } else {
            i3 = 0;
        }
        LiveVideoContext liveVideoContext2 = this.videoContext;
        if (liveVideoContext2 != null && (h16 = liveVideoContext2.h()) != null) {
            i16 = h16.getVideoHeight();
        }
        if (i3 > 0 && i16 > 0) {
            return new Size(i3, i16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public View getVideoView() {
        ISPlayerVideoView iSPlayerVideoView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        LiveVideoContext liveVideoContext = this.videoContext;
        if (liveVideoContext != null) {
            iSPlayerVideoView = liveVideoContext.j();
        } else {
            iSPlayerVideoView = null;
        }
        if (!(iSPlayerVideoView instanceof View)) {
            return null;
        }
        return (View) iSPlayerVideoView;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("QQLive_Player|LiveVideoPlayer", "clearListeners", "roomId=" + this.roomId);
        this.listenerDispatcher.release();
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public boolean isOutputMute() {
        ISuperPlayer h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        LiveVideoContext liveVideoContext = this.videoContext;
        if (liveVideoContext != null && (h16 = liveVideoContext.h()) != null) {
            return h16.isOutputMute();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public boolean isPlaying() {
        ISuperPlayer h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        LiveVideoContext liveVideoContext = this.videoContext;
        if (liveVideoContext != null && (h16 = liveVideoContext.h()) != null) {
            return h16.isPlaying();
        }
        return false;
    }

    public void k(@Nullable mi2.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addCompletedListener(listener);
        }
    }

    public void m(@Nullable mi2.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeCompletedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$pause$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void prepare(@NotNull String videoUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoUrl);
        } else {
            Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$prepare$1(this, videoUrl, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addBufferListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerErrorListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addErrorListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerFirstFrameRenderedListener(@Nullable d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addFirstFrameRenderedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerSeiInfoListener(@Nullable e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addSeiInfoListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerSwitchDefinitionListener(@Nullable f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addSwitchDefinitionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addVideoPreparedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerVideoSizeChangedListener(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.addVideoSizeChangedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$release$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$replay$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void setOutputMute(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$setOutputMute$1(this, mute, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void setXYAxis(@NotNull IQQLivePlayer.XYAxis axis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) axis);
        } else {
            Intrinsics.checkNotNullParameter(axis, "axis");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$setXYAxis$1(this, axis, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void startPlay(@Nullable String videoUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$startPlay$1(this, videoUrl, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoUrl);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$stop$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void switchStream(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveVideoPlayer$switchStream$1(this, url, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeBufferListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterErrorListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeErrorListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterFirstFrameRenderedListener(@Nullable d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeFirstFrameRenderedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterSeiInfoListener(@Nullable e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeSeiInfoListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterSwitchDefinitionListener(@Nullable f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeSwitchDefinitionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeVideoPreparedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterVideoSizeChangedListener(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
        } else {
            this.listenerDispatcher.removeVideoSizeChangedListener(listener);
        }
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [com.tencent.mobileqq.qqlive.sail.player.LiveVideoPlayer$avBlockReceiver$1] */
    public LiveVideoPlayer(@NotNull PlayerConfig config, long j3) {
        int i3;
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, config, Long.valueOf(j3));
            return;
        }
        this.config = config;
        this.roomId = j3;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!from.decodeBool(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_HAS_DETECTED, false)) {
            try {
                i3 = com.tencent.superplayer.utils.e.d(172, 102).getMaxLevel();
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("QQLive_Player|LiveVideoPlayer", "init", "error, ", e16);
                i3 = -1;
            }
            from.encodeInt(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_SUPPORT_LEVEL, i3);
            from.encodeBool(IQQLiveHEVCAbilityKt.KEY_QQLIVE_HEVC_HAS_DETECTED, true);
        }
        this.listenerDispatcher = new QQLivePlayerListenerDispatcher();
        this.mRFWMediaFocusManager = RFWMediaFocusManager.createMediaFocusManager("QQ\u76f4\u64ad");
        this.avBlockReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqlive.sail.player.LiveVideoPlayer$avBlockReceiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveVideoPlayer.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                Object obj;
                long j16;
                RFWMediaFocusManager rFWMediaFocusManager;
                Bundle extras;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                String str = null;
                if (intent != null && (extras = intent.getExtras()) != null) {
                    obj = extras.get("extra_block_business");
                } else {
                    obj = null;
                }
                if (Intrinsics.areEqual("QQ\u76f4\u64ad", obj)) {
                    QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                    if (c16 != null) {
                        str = c16.n();
                    }
                    boolean isPlaying = LiveVideoPlayer.this.isPlaying();
                    QLog.d("QQLive_Player|LiveVideoPlayer", 1, "action_av_block, isPlaying:" + isPlaying);
                    if (!isPlaying) {
                        rFWMediaFocusManager = LiveVideoPlayer.this.mRFWMediaFocusManager;
                        if (rFWMediaFocusManager != null) {
                            rFWMediaFocusManager.requestMediaUnFocus();
                        }
                        LiveVideoPlayer.this.l();
                    }
                    IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
                    QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                    if (str == null) {
                        str = "";
                    }
                    QQLiveQualityReportData.Builder eventId = builder.traceId(str).eventId(QQLiveReportConstants.Event.E_QQ_LIVE_AV_BLOCK);
                    j16 = LiveVideoPlayer.this.roomId;
                    QQLiveQualityReportData.Builder roomId = eventId.roomId(String.valueOf(j16));
                    String str2 = "1";
                    QQLiveQualityReportData.Builder ext6 = roomId.ext6("1");
                    if (!isPlaying) {
                        str2 = "0";
                    }
                    iQQLiveReportApi.qualityReport(ext6.ext7(str2));
                }
            }
        };
    }
}
