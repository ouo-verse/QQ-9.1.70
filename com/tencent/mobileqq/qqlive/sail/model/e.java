package com.tencent.mobileqq.qqlive.sail.model;

import android.os.Bundle;
import android.view.Surface;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedReplaceSurfaceEvent;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.qqlive.widget.player.a;
import com.tencent.mobileqq.qqlive.widget.util.SizeParcelable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thumbplayer.api.common.TPVideoSeiInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001d\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001RB\u0019\u0012\u0006\u0010:\u001a\u000203\u0012\b\u0010=\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010&\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010(\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010)H\u0016J4\u00101\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\u0006H\u0016J2\u00107\u001a\u00020\u00132\u0006\u0010,\u001a\u00020+2\u0006\u00102\u001a\u00020\u001a2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000106H\u0016R\u0014\u0010:\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u00109\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/e;", "Lcom/tencent/mobileqq/qqlive/widget/player/a$a;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Landroid/os/Bundle;", HippyTKDListViewAdapter.X, "", "eventType", "params", "", "Z", "url", "prepare", "start", "pause", "replay", "stop", "release", "switchStream", "", "isOutputMute", "mute", "setOutputMute", "isPlaying", "Lcom/tencent/mobileqq/qqlive/widget/util/SizeParcelable;", "getVideoSize", "", "axis", "setXYAxis", "Landroid/view/Surface;", "surface", "o2", "Lcom/tencent/mobileqq/qqlive/widget/player/c;", "listener", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/qqlive/widget/player/f;", "J0", "Lcom/tencent/mobileqq/qqlive/widget/player/d;", "K3", "Lcom/tencent/mobileqq/qqlive/widget/player/e;", "Y2", "Lcom/tencent/mobileqq/qqlive/widget/player/b;", "V3", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extra", "onError", "what", "", "l", "l1", "", "onInfo", "d", "J", "roomId", "e", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "f", "Lcom/tencent/mobileqq/qqlive/widget/player/c;", "errorListener", h.F, "Lcom/tencent/mobileqq/qqlive/widget/player/f;", "switchDefinitionListener", "i", "Lcom/tencent/mobileqq/qqlive/widget/player/d;", "firstFrameRenderedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/widget/player/e;", "seiInfoListener", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/widget/player/b;", "bufferListener", "D", "lastSeiInfoTimestamp", "<init>", "(JLcom/tencent/superplayer/api/ISuperPlayer;)V", "E", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e extends a.AbstractBinderC8408a implements ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.player.b bufferListener;

    /* renamed from: D, reason: from kotlin metadata */
    private long lastSeiInfoTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ISuperPlayer superPlayer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.player.c errorListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.player.f switchDefinitionListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.player.d firstFrameRenderedListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.player.e seiInfoListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/e$a;", "", "", "EVENT_PARAM_ROOM_ID", "Ljava/lang/String;", "EVENT_PARAM_SWITCH_DEFINITION_URL", "EVENT_PARAM_XYAXIS", "", "SEI_INFO_INTERVAL", "J", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50352);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(long j3, @Nullable ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), iSuperPlayer);
            return;
        }
        this.roomId = j3;
        this.superPlayer = iSuperPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnErrorListener(this);
        }
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnInfoListener(this);
        }
    }

    private final void Z(String eventType, Bundle params) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleLiveFeedsPlayerEvent(eventType, params));
    }

    private final Bundle x() {
        Bundle bundle = new Bundle();
        bundle.putLong("param_live_roomid", this.roomId);
        return bundle;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void J0(@Nullable com.tencent.mobileqq.qqlive.widget.player.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) listener);
        } else {
            this.switchDefinitionListener = listener;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void K3(@Nullable com.tencent.mobileqq.qqlive.widget.player.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
        } else {
            this.firstFrameRenderedListener = listener;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void V3(@Nullable com.tencent.mobileqq.qqlive.widget.player.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        } else {
            this.bufferListener = listener;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void Y2(@Nullable com.tencent.mobileqq.qqlive.widget.player.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        } else {
            this.seiInfoListener = listener;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void a2(@Nullable com.tencent.mobileqq.qqlive.widget.player.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener);
        } else {
            this.errorListener = listener;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    @Nullable
    public SizeParcelable getVideoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SizeParcelable) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return new SizeParcelable(iSuperPlayer.getVideoWidth(), iSuperPlayer.getVideoHeight());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public boolean isOutputMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void o2(@Nullable Surface surface) {
        Unit unit;
        com.tencent.mobileqq.qqlive.widget.player.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) surface);
            return;
        }
        if (surface != null) {
            Z(QCircleLiveFeedsPlayerEvent.EVENT_IGNORE_LIFECYCLE, x());
            SimpleEventBus.getInstance().dispatchEvent(new QCircleLiveFeedReplaceSurfaceEvent(this.roomId, surface));
            ISuperPlayer iSuperPlayer = this.superPlayer;
            boolean z16 = false;
            if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
                z16 = true;
            }
            if (z16 && (dVar = this.firstFrameRenderedListener) != null) {
                dVar.onFirstFrameRendered();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("QQLive_Player|QCircleRemotePlayerBn", "changeSurface", "invalid surface");
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(@Nullable ISuperPlayer player, int module, int errorType, int errorCode, @Nullable String extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, player, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extra)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.widget.player.c cVar = this.errorListener;
        if (cVar != null) {
            cVar.onError(module, errorType, errorCode, extra);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(@NotNull ISuperPlayer player, int what, long l3, long l16, @Nullable Object extra) {
        int i3;
        com.tencent.mobileqq.qqlive.widget.player.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, player, Integer.valueOf(what), Long.valueOf(l3), Long.valueOf(l16), extra)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(player, "player");
        if (what != 3) {
            if (what != 105) {
                if (what != 126) {
                    if (what != 112) {
                        if (what == 113 && (bVar = this.bufferListener) != null) {
                            bVar.w();
                        }
                    } else {
                        com.tencent.mobileqq.qqlive.widget.player.b bVar2 = this.bufferListener;
                        if (bVar2 != null) {
                            bVar2.K();
                        }
                    }
                } else if ((extra instanceof TPVideoSeiInfo) && System.currentTimeMillis() - this.lastSeiInfoTimestamp > 300) {
                    VideoSeiInfo videoSeiInfo = new VideoSeiInfo();
                    TPVideoSeiInfo tPVideoSeiInfo = (TPVideoSeiInfo) extra;
                    videoSeiInfo.seiData = tPVideoSeiInfo.getSeiData();
                    byte[] seiData = tPVideoSeiInfo.getSeiData();
                    if (seiData != null) {
                        i3 = seiData.length;
                    } else {
                        i3 = 0;
                    }
                    videoSeiInfo.seiDataSize = i3;
                    videoSeiInfo.videoCodecType = tPVideoSeiInfo.getCodecType();
                    videoSeiInfo.videoSeiType = tPVideoSeiInfo.getSeiType();
                    com.tencent.mobileqq.qqlive.widget.player.e eVar = this.seiInfoListener;
                    if (eVar != null) {
                        eVar.q(videoSeiInfo);
                    }
                    this.lastSeiInfoTimestamp = System.currentTimeMillis();
                }
            } else {
                com.tencent.mobileqq.qqlive.widget.player.d dVar = this.firstFrameRenderedListener;
                if (dVar != null) {
                    dVar.onFirstFrameRendered();
                }
            }
        } else {
            com.tencent.mobileqq.qqlive.widget.player.f fVar = this.switchDefinitionListener;
            if (fVar != null) {
                fVar.o();
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("QQLive_Player|QCircleRemotePlayerBn", "pause");
            Z("pause", x());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void prepare(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("QQLive_Player|QCircleRemotePlayerBn", "release");
        pause();
        Bundle x16 = x();
        x16.putLong("param_live_roomid", -1L);
        Z(QCircleLiveFeedsPlayerEvent.EVENT_RECEIVE_LIFECYCLE, x16);
        this.errorListener = null;
        this.switchDefinitionListener = null;
        this.firstFrameRenderedListener = null;
        this.seiInfoListener = null;
        this.bufferListener = null;
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnInfoListener(null);
        }
        ISuperPlayer iSuperPlayer2 = this.superPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.setOnErrorListener(null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("QQLive_Player|QCircleRemotePlayerBn", "replay");
            Z("resume", x());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void setOutputMute(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, mute);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void setXYAxis(int axis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, axis);
            return;
        }
        Bundle x16 = x();
        x16.putInt(QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, axis);
        Z(QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, x16);
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void start(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
            return;
        }
        AegisLogger.INSTANCE.i("QQLive_Player|QCircleRemotePlayerBn", "start", "url=" + url);
        Bundle x16 = x();
        Z("start", x16);
        Z(QCircleLiveFeedsPlayerEvent.EVENT_IGNORE_LIFECYCLE, x16);
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("QQLive_Player|QCircleRemotePlayerBn", "stop");
        Z("stop", x());
        Bundle x16 = x();
        x16.putLong("param_live_roomid", -1L);
        Z(QCircleLiveFeedsPlayerEvent.EVENT_RECEIVE_LIFECYCLE, x16);
    }

    @Override // com.tencent.mobileqq.qqlive.widget.player.a
    public void switchStream(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
            return;
        }
        Bundle x16 = x();
        x16.putString("switchDefinitionUrl", url);
        Z(QCircleLiveFeedsPlayerEvent.EVENT_SWITCH_DEFINITION, x16);
    }
}
