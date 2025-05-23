package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.liveroom.impl.room.anchor.e;
import com.tencent.timi.game.liveroom.impl.room.anchor.m;
import com.tencent.timi.game.liveroom.impl.room.live.widget.LiveTipsView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001J\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0002XYB\u001d\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0016R$\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020(8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010:\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010+R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006Z"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "", "O0", "M0", "N0", "L0", "", "show", ICustomDataEditor.STRING_ARRAY_PARAM_1, "c1", "b1", "d1", "mute", "Y0", "play", "Z0", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "P0", "Landroid/widget/FrameLayout;", "liveContainer", "Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView;", "liveTipsView", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$b;", "listener", "Q0", "", "roomId", "S0", "T0", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "V0", "U0", "W0", "X0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "<set-?>", "d", "Landroid/widget/TextView;", "getPreviewTipsTv", "()Landroid/widget/TextView;", "previewTipsTv", "e", "previewButton", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "videoControlPlay", tl.h.F, "videoControlVoice", "i", "videoControlPreview", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "noVideoPushTipsTv", BdhLogUtil.LogTag.Tag_Conn, "J", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/e;", "D", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/e;", "previewVideoModel", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/m;", "E", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/m;", "rtmpPushStateChecker", UserInfo.SEX_FEMALE, "Z", "rtmpPushInLiving", "G", "buttonIsPlaying", "com/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$d", "H", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$d;", "pushStateCallback", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "I", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "netObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class RtmpAnchorVideoOperateView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private e previewVideoModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private m rtmpPushStateChecker;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean rtmpPushInLiving;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean buttonIsPlaying;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final d pushStateCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final INetEventHandler netObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView previewTipsTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView previewButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView videoControlPlay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView videoControlVoice;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView videoControlPreview;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView noVideoPushTipsTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$b;", "", "", "width", "height", "", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(int width, int height);

        void b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$c", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/e$b;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "", "a", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements e.b {
        c() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.anchor.e.b
        public void a(@NotNull IQQLivePlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            RtmpAnchorVideoOperateView.this.c1(false);
            RtmpAnchorVideoOperateView.this.a1(true);
            RtmpAnchorVideoOperateView.this.Z0(player.isPlaying());
            RtmpAnchorVideoOperateView.this.Y0(player.isOutputMute());
            RtmpAnchorVideoOperateView.this.rtmpPushStateChecker.i(RtmpAnchorVideoOperateView.this.pushStateCallback);
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.anchor.e.b
        public void b(@NotNull IQQLivePlayer player, int module, int errorType, int errorCode) {
            Intrinsics.checkNotNullParameter(player, "player");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$d", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/m$b;", "", "isLiving", "", "onResult", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements m.b {
        d() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.anchor.m.b
        public void onResult(boolean isLiving) {
            if (RtmpAnchorVideoOperateView.this.rtmpPushInLiving != isLiving) {
                RtmpAnchorVideoOperateView.this.rtmpPushInLiving = isLiving;
                RtmpAnchorVideoOperateView.this.b1(!isLiving);
                if (isLiving && RtmpAnchorVideoOperateView.this.buttonIsPlaying) {
                    RtmpAnchorVideoOperateView.this.d1();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RtmpAnchorVideoOperateView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void L0() {
        AppNetConnInfo.unregisterNetEventHandler(this.netObserver);
        this.rtmpPushStateChecker.j();
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            eVar.n();
            a1(false);
            b1(false);
            c1(true);
        }
    }

    private final void M0() {
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            boolean v3 = eVar.v();
            eVar.p(!v3);
            Z0(!v3);
        }
    }

    private final void N0() {
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            boolean u16 = eVar.u();
            eVar.o(!u16);
            Y0(!u16);
        }
    }

    private final void O0() {
        AppNetConnInfo.registerNetChangeReceiver(getContext(), this.netObserver);
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            eVar.A(new c());
        }
    }

    private final URLDrawable.URLDrawableOptions P0() {
        Drawable drawable = getResources().getDrawable(R.drawable.trans);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026sparentDrawable\n        }");
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(RtmpAnchorVideoOperateView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(boolean mute) {
        String str;
        if (mute) {
            str = "https://downv6.qq.com/video_story/qcircle/qqlive/tg_icon_anchor_video_voice_disable.png";
        } else {
            str = "https://downv6.qq.com/video_story/qcircle/qqlive/tg_icon_anchor_video_voice_enable.png";
        }
        this.videoControlVoice.setImageDrawable(URLDrawable.getDrawable(str, P0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(boolean play) {
        String str;
        this.buttonIsPlaying = play;
        if (play) {
            str = "https://downv6.qq.com/video_story/qcircle/qqlive/tg_icon_anchor_video_play.png";
        } else {
            str = "https://downv6.qq.com/video_story/qcircle/qqlive/tg_icon_anchor_video_pause.png";
        }
        this.videoControlPlay.setImageDrawable(URLDrawable.getDrawable(str, P0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(boolean show) {
        int i3;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.videoControlPlay.setVisibility(i3);
        this.videoControlVoice.setVisibility(i3);
        this.videoControlPreview.setVisibility(i3);
        if (show) {
            this.videoControlPreview.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/video_story/qcircle/qqlive/tg_icon_anchor_video_preview_open.png", P0()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(boolean show) {
        int i3;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (i3 == this.noVideoPushTipsTv.getVisibility()) {
            return;
        }
        this.noVideoPushTipsTv.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(boolean show) {
        int i3;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.previewButton.setVisibility(i3);
        this.previewTipsTv.setVisibility(i3);
        if (show) {
            setBackgroundColor(Color.parseColor("#05001F"));
        } else {
            setBackground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1() {
        if (this.previewButton.getVisibility() == 0) {
            AegisLogger.INSTANCE.i("Open_Live|RtmpAnchorVideoOperateView", "tryResumePlay", "Preview button is visible.");
            return;
        }
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            if (eVar.v()) {
                AegisLogger.INSTANCE.i("Open_Live|RtmpAnchorVideoOperateView", "tryResumePlay", "is playing.");
            } else {
                eVar.p(true);
            }
        }
    }

    public final void Q0(@NotNull FrameLayout liveContainer, @NotNull LiveTipsView liveTipsView, @NotNull b listener) {
        Intrinsics.checkNotNullParameter(liveContainer, "liveContainer");
        Intrinsics.checkNotNullParameter(liveTipsView, "liveTipsView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.previewVideoModel = new e(liveContainer, liveTipsView, listener);
    }

    public final void S0(long roomId) {
        this.roomId = roomId;
    }

    public final void T0() {
        L0();
        this.rtmpPushStateChecker.j();
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            eVar.x();
        }
        AppNetConnInfo.unregisterNetEventHandler(this.netObserver);
    }

    public final void U0() {
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            eVar.y();
        }
        setVisibility(0);
    }

    public final void V0(@NotNull String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        e eVar = this.previewVideoModel;
        if (eVar != null) {
            eVar.z(videoUrl);
        }
        setVisibility(8);
    }

    public final void W0() {
        e eVar;
        if (getVisibility() == 0 && (eVar = this.previewVideoModel) != null && eVar.v() && eVar.u()) {
            M0();
        }
    }

    public final void X0() {
        e eVar;
        if (getVisibility() == 0 && (eVar = this.previewVideoModel) != null && !eVar.v() && eVar.u()) {
            M0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.f1178572k) {
            O0();
        } else if (id5 == R.id.f1177972e) {
            M0();
        } else if (id5 == R.id.f1183473w) {
            N0();
        } else if (id5 == R.id.f1178672l) {
            L0();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public /* synthetic */ RtmpAnchorVideoOperateView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RtmpAnchorVideoOperateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rtmpPushStateChecker = new m(com.tencent.mobileqq.qqlive.sail.c.f272176a.d().f());
        View.inflate(context, R.layout.hwa, this);
        View findViewById = findViewById(R.id.f1179272r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_preview_tips)");
        this.previewTipsTv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f1178572k);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.video_preview_button)");
        this.previewButton = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f1177972e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.video_play_control_button)");
        this.videoControlPlay = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.f1183473w);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.video_voice_control_button)");
        this.videoControlVoice = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f1178672l);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.video_preview_control_button)");
        this.videoControlPreview = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f166417zs0);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.no_video_push_tips)");
        this.noVideoPushTipsTv = (TextView) findViewById6;
        this.previewButton.setOnClickListener(this);
        this.videoControlPlay.setOnClickListener(this);
        this.videoControlVoice.setOnClickListener(this);
        this.videoControlPreview.setOnClickListener(this);
        a1(false);
        b1(false);
        c1(true);
        this.pushStateCallback = new d();
        this.netObserver = new INetEventHandler() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.k
            @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
            public final void onNetChangeEvent(boolean z16) {
                RtmpAnchorVideoOperateView.R0(RtmpAnchorVideoOperateView.this, z16);
            }
        };
    }
}
