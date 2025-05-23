package com.tencent.mobileqq.qqlive.sail.room;

import android.util.Size;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoPlayer;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 @2\u00020\u0001:\u0001\u0018B#\u0012\u0006\u00106\u001a\u000202\u0012\u0006\u00109\u001a\u000207\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b>\u0010?J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010+\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010.\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010,H\u0016J\u0012\u00100\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00101\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010/H\u0016J\u0006\u00103\u001a\u000202R\u0014\u00106\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/n;", "Lcom/tencent/mobileqq/qqlive/sail/room/h;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "newPlayer", "", DomainData.DOMAIN_NAME, "", "url", "prepare", "", "isPlaying", "switchStream", "k", "pauseVideo", "stopVideo", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "axis", "setXYAxis", "mute", "y", "Landroid/util/Size;", "getVideoSize", "Landroid/view/View;", "getVideoView", "a", "c", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "getPlayerQuality", "Lmi2/h;", "listener", "registerVideoSizeChangedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmi2/c;", HippyTKDListViewAdapter.X, "r", "Lmi2/d;", "registerFirstFrameRenderedListener", "u", "Lmi2/f;", "registerSwitchDefinitionListener", ReportConstant.COSTREPORT_PREFIX, "Lmi2/a;", "registerBufferListener", "w", "Lmi2/g;", "registerVideoPreparedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lmi2/e;", "registerSeiInfoListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "e", "d", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "playerConfig", "", "J", "roomId", "f", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "outPlayer", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;JLcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;)V", tl.h.F, "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class n implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PlayerConfig playerConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQLivePlayer player;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.room.n$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n(@NotNull PlayerConfig playerConfig, long j3, @Nullable IQQLivePlayer iQQLivePlayer) {
        Intrinsics.checkNotNullParameter(playerConfig, "playerConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, playerConfig, Long.valueOf(j3), iQQLivePlayer);
            return;
        }
        this.playerConfig = playerConfig;
        this.roomId = j3;
        this.player = iQQLivePlayer == null ? new LiveVideoPlayer(playerConfig, j3) : iQQLivePlayer;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void A(@Nullable mi2.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.unRegisterSeiInfoListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.release();
        }
    }

    public final void c() {
        LiveVideoPlayer liveVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("QQLive_Player|RoomPlayerProxyImpl", "destroyPlayer player:" + this.player);
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.release();
        }
        IQQLivePlayer iQQLivePlayer2 = this.player;
        if (iQQLivePlayer2 instanceof LiveVideoPlayer) {
            liveVideoPlayer = (LiveVideoPlayer) iQQLivePlayer2;
        } else {
            liveVideoPlayer = null;
        }
        if (liveVideoPlayer != null) {
            liveVideoPlayer.h();
        }
    }

    @NotNull
    public final PlayerConfig e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (PlayerConfig) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.playerConfig;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    @Nullable
    public com.tencent.mobileqq.qqlive.sail.model.player.a getPlayerQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.qqlive.sail.model.player.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            return iQQLivePlayer.getPlayerQuality();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    @Nullable
    public Size getVideoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Size) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            return iQQLivePlayer.getVideoSize();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    @Nullable
    public View getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            return iQQLivePlayer.getVideoView();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            return iQQLivePlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void k(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) url);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.startPlay(url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void m(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.unRegisterVideoSizeChangedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void n(@Nullable IQQLivePlayer newPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newPlayer);
            return;
        }
        a();
        if (newPlayer == null) {
            newPlayer = new LiveVideoPlayer(this.playerConfig, this.roomId);
        }
        this.player = newPlayer;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void pauseVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.pause();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void prepare(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.prepare(url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void r(@Nullable mi2.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.unRegisterErrorListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.registerBufferListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerFirstFrameRenderedListener(@Nullable mi2.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.registerFirstFrameRenderedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerSeiInfoListener(@Nullable mi2.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.registerSeiInfoListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerSwitchDefinitionListener(@Nullable mi2.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.registerSwitchDefinitionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerVideoPreparedListener(@Nullable mi2.g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.registerVideoPreparedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerVideoSizeChangedListener(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.registerVideoSizeChangedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void s(@Nullable mi2.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.unRegisterSwitchDefinitionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void setXYAxis(@NotNull IQQLivePlayer.XYAxis axis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) axis);
            return;
        }
        Intrinsics.checkNotNullParameter(axis, "axis");
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.setXYAxis(axis);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void stopVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.stop();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void switchStream(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.switchStream(url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void u(@Nullable mi2.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.unRegisterFirstFrameRenderedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void w(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.unRegisterBufferListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void x(@Nullable mi2.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.registerErrorListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void y(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, mute);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.setOutputMute(mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void z(@Nullable mi2.g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) listener);
            return;
        }
        IQQLivePlayer iQQLivePlayer = this.player;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.unRegisterVideoPreparedListener(listener);
        }
    }

    public /* synthetic */ n(PlayerConfig playerConfig, long j3, IQQLivePlayer iQQLivePlayer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(playerConfig, j3, (i3 & 4) != 0 ? null : iQQLivePlayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, playerConfig, Long.valueOf(j3), iQQLivePlayer, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
