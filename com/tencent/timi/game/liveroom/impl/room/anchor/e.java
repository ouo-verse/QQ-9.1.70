package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi;
import com.tencent.mobileqq.qqlive.api.player.IQQLivePlayerFactory;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.timi.game.liveroom.impl.room.anchor.RtmpAnchorVideoOperateView;
import com.tencent.timi.game.liveroom.impl.room.anchor.e;
import com.tencent.timi.game.liveroom.impl.room.live.widget.LiveTipsView;
import com.tencent.timi.game.sso.request.QQLiveAnchorStreamControlRequest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0002(.B!\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u00102\u001a\u00020-\u0012\b\u00108\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u00108\u001a\u0004\u0018\u0001038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010ER\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/e;", "", "", "url", "", "t", "D", BdhLogUtil.LogTag.Tag_Conn, "Lot3/e;", "rsp", "B", "E", "", "objectLevel", "r", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "j", "w", tl.h.F, "k", "", "videoLandScape", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "u", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/e$b;", "callback", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "play", "p", "mute", "o", DomainData.DOMAIN_NAME, AppConstants.Key.KEY_QZONE_VIDEO_URL, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", HippyTKDListViewAdapter.X, "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "getLiveContainer", "()Landroid/widget/FrameLayout;", "liveContainer", "Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView;", "b", "Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView;", "liveTipsView", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$b;", "c", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$b;", "getListener", "()Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$b;", "listener", "d", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "qqlivePlayer", "e", "Ljava/lang/String;", "previewVideoUrl", "f", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/e$b;", "previewCallback", "g", "I", "videoLandscapeMargin", "Z", "isClickPreviewVideo", "i", "isMuteState", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "netObserver", "<init>", "(Landroid/widget/FrameLayout;Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView;Lcom/tencent/timi/game/liveroom/impl/room/anchor/RtmpAnchorVideoOperateView$b;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout liveContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveTipsView liveTipsView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RtmpAnchorVideoOperateView.b listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQLivePlayer qqlivePlayer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String previewVideoUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b previewCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int videoLandscapeMargin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isClickPreviewVideo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isMuteState;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final INetEventHandler netObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/e$b;", "", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "", "a", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull IQQLivePlayer player);

        void b(@NotNull IQQLivePlayer player, int module, int errorType, int errorCode);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/e$c", "Lmi2/g;", "", "onVideoPrepared", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements mi2.g {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.s();
        }

        @Override // mi2.g
        public void onVideoPrepared() {
            AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "onVideoPrepared");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final e eVar = e.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.c.b(e.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/e$d", "Lmi2/d;", "", "onFirstFrameRendered", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements mi2.d {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IQQLivePlayer f377467e;

        d(IQQLivePlayer iQQLivePlayer) {
            this.f377467e = iQQLivePlayer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e this$0, IQQLivePlayer iQQLivePlayer) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            b bVar = this$0.previewCallback;
            if (bVar != null) {
                bVar.a(iQQLivePlayer);
            }
            this$0.getLiveTipsView().e();
        }

        @Override // mi2.d
        public void onFirstFrameRendered() {
            AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "onFirstFrameRendered");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final e eVar = e.this;
            final IQQLivePlayer iQQLivePlayer = this.f377467e;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.g
                @Override // java.lang.Runnable
                public final void run() {
                    e.d.b(e.this, iQQLivePlayer);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/e$e", "Lmi2/h;", "", "w", tl.h.F, "", "onVideoSizeChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.anchor.e$e, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9933e implements mi2.h {
        C9933e() {
        }

        @Override // mi2.h
        public void onVideoSizeChanged(int w3, int h16) {
            AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "onVideoSizeChanged", "w=" + w3 + ", h=" + h16);
            e.this.k(w3, h16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/e$f", "Lmi2/c;", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements mi2.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IQQLivePlayer f377470e;

        f(IQQLivePlayer iQQLivePlayer) {
            this.f377470e = iQQLivePlayer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, int i16, e this$0, IQQLivePlayer iQQLivePlayer, int i17) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "onError", "errType=" + i3 + ", errCode=" + i16);
            b bVar = this$0.previewCallback;
            if (bVar != null) {
                bVar.b(iQQLivePlayer, i17, i3, i16);
            }
        }

        @Override // mi2.c
        public void onError(final int module, final int errorType, final int errorCode, @Nullable String extraInfo) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final e eVar = e.this;
            final IQQLivePlayer iQQLivePlayer = this.f377470e;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.h
                @Override // java.lang.Runnable
                public final void run() {
                    e.f.b(errorType, errorCode, eVar, iQQLivePlayer, module);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/e$g", "Lmi2/a;", "", "K", "w", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements mi2.a {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getLiveTipsView().e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getLiveTipsView().g();
        }

        @Override // mi2.a
        public void K() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final e eVar = e.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.j
                @Override // java.lang.Runnable
                public final void run() {
                    e.g.d(e.this);
                }
            });
        }

        @Override // mi2.a
        public void w() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final e eVar = e.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.i
                @Override // java.lang.Runnable
                public final void run() {
                    e.g.c(e.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/e$h", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lot3/e;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "rsp", "", "onResponse", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h implements ILiveNetRequest.Callback<ot3.e> {
        h() {
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<ot3.e> rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (rsp.isFailed()) {
                AegisLogger.INSTANCE.e("Open_Live|PKWithOBS|PreviewVideoModel", "error", rsp.getRetCode() + " - " + rsp.getErrMsg());
                return;
            }
            ot3.e rsp2 = rsp.getRsp();
            if (rsp2 != null) {
                e eVar = e.this;
                eVar.B(rsp2);
                eVar.previewVideoUrl = eVar.E(rsp2);
                AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "previewVideoUrl:" + eVar.previewVideoUrl);
            }
        }
    }

    public e(@NotNull FrameLayout liveContainer, @NotNull LiveTipsView liveTipsView, @Nullable RtmpAnchorVideoOperateView.b bVar) {
        Intrinsics.checkNotNullParameter(liveContainer, "liveContainer");
        Intrinsics.checkNotNullParameter(liveTipsView, "liveTipsView");
        this.liveContainer = liveContainer;
        this.liveTipsView = liveTipsView;
        this.listener = bVar;
        this.previewVideoUrl = "";
        this.videoLandscapeMargin = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoTopMargin(true);
        this.isMuteState = true;
        C();
        liveTipsView.c();
        this.netObserver = new INetEventHandler() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.c
            @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
            public final void onNetChangeEvent(boolean z16) {
                e.w(e.this, z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(ot3.e rsp) {
        AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "GetLiveStreamsRsp sugLevel: " + rsp.f424035g);
        ot3.f[] fVarArr = rsp.f424031c;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "rsp.streams");
        int length = fVarArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            ot3.f fVar = fVarArr[i3];
            int i17 = i16 + 1;
            AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "streamIndex:" + i16 + ", frameSize:" + fVar.f424041a.length);
            ot3.b[] bVarArr = fVar.f424041a;
            Intrinsics.checkNotNullExpressionValue(bVarArr, "stream.frames");
            for (ot3.b bVar : bVarArr) {
                AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "Frame\u5206\u8fa8\u7387:" + bVar.f424013c);
                ot3.a[] aVarArr = bVar.f424012b;
                Intrinsics.checkNotNullExpressionValue(aVarArr, "frame.addresses");
                int length2 = aVarArr.length;
                int i18 = 0;
                int i19 = 0;
                while (i18 < length2) {
                    AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "index:" + i19 + ", url:" + aVarArr[i18].f424007a);
                    i18++;
                    i19++;
                    fVarArr = fVarArr;
                }
            }
            i3++;
            i16 = i17;
        }
    }

    private final void C() {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveAnchorStreamControlRequest(cVar.d().f(), cVar.d().n(), 1, Long.parseLong(QQLiveBusinessConfig.QQLIVE_APP_ID)), new h());
    }

    private final void D(String url) {
        AppNetConnInfo.unregisterNetEventHandler(this.netObserver);
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.release();
        }
        this.liveContainer.removeAllViews();
        this.qqlivePlayer = null;
        t(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String E(ot3.e rsp) {
        String r16;
        boolean isHighPerfDevice = DeviceInfoUtils.isHighPerfDevice();
        AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "tryGetVideoUrl", "highPerfDevice:" + isHighPerfDevice);
        try {
            if (isHighPerfDevice) {
                r16 = r(3, rsp);
            } else {
                r16 = r(1, rsp);
            }
            return r16;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|PKWithOBS|PreviewVideoModel", "tryGetVideoUrl", "exception:" + e16);
            return "";
        }
    }

    private final void j(IQQLivePlayer player) {
        if (player == null) {
            AegisLogger.INSTANCE.w("Open_Live|PKWithOBS|PreviewVideoModel", "addCallback", "invalid player");
            return;
        }
        player.registerVideoPreparedListener(new c());
        player.registerFirstFrameRenderedListener(new d(player));
        player.registerVideoSizeChangedListener(new C9933e());
        player.registerErrorListener(new f(player));
        player.registerBufferListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int w3, int h16) {
        final boolean z16;
        final ViewGroup viewGroup;
        if (w3 >= h16) {
            z16 = true;
        } else {
            z16 = false;
        }
        ViewParent parent = this.liveContainer.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (z16) {
            layoutParams2.topMargin = this.videoLandscapeMargin;
            layoutParams2.width = -1;
            layoutParams2.height = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoHeight(w3, h16);
        } else {
            layoutParams2.topMargin = 0;
            layoutParams2.width = -1;
            layoutParams2.height = -1;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.d
            @Override // java.lang.Runnable
            public final void run() {
                e.l(e.this, z16, viewGroup, layoutParams2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, boolean z16, ViewGroup liveContainerParent, RelativeLayout.LayoutParams params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(liveContainerParent, "$liveContainerParent");
        Intrinsics.checkNotNullParameter(params, "$params");
        this$0.m(z16);
        liveContainerParent.setLayoutParams(params);
        RtmpAnchorVideoOperateView.b bVar = this$0.listener;
        if (bVar != null) {
            bVar.a(params.width, params.height);
        }
    }

    private final void m(boolean videoLandScape) {
        IQQLivePlayer.XYAxis xYAxis;
        if (videoLandScape) {
            xYAxis = IQQLivePlayer.XYAxis.ORIGINAL_RATIO;
        } else {
            xYAxis = IQQLivePlayer.XYAxis.ORIGINAL_FULLSCREEN;
        }
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.setXYAxis(xYAxis);
            View videoView = iQQLivePlayer.getVideoView();
            if (videoView != null) {
                videoView.requestLayout();
            }
        }
    }

    private final String r(int objectLevel, ot3.e rsp) {
        boolean contains;
        boolean z16;
        int[] iArr = rsp.f424033e;
        Intrinsics.checkNotNullExpressionValue(iArr, "rsp.levelList");
        contains = ArraysKt___ArraysKt.contains(iArr, objectLevel);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|PKWithOBS|PreviewVideoModel", "objectLevel:" + objectLevel + ", hasObjectLevel:" + contains);
        ot3.f[] fVarArr = rsp.f424031c;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "rsp.streams");
        if (fVarArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            companion.e("Open_Live|PKWithOBS|PreviewVideoModel", "getUrl", "streams is empty");
            return "";
        }
        ot3.b[] bVarArr = rsp.f424031c[0].f424041a;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "rsp.streams[0].frames");
        for (ot3.b bVar : bVarArr) {
            if (contains) {
                if (bVar.f424011a == objectLevel) {
                    String str = bVar.f424012b[0].f424007a;
                    Intrinsics.checkNotNullExpressionValue(str, "frame.addresses[0].url");
                    return str;
                }
            } else if (bVar.f424011a != 0) {
                String str2 = bVar.f424012b[0].f424007a;
                Intrinsics.checkNotNullExpressionValue(str2, "frame.addresses[0].url");
                return str2;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        View videoView;
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null && (videoView = iQQLivePlayer.getVideoView()) != null && !fh4.g.d(this.liveContainer, videoView)) {
            this.liveContainer.addView(iQQLivePlayer.getVideoView(), new ConstraintLayout.LayoutParams(-1, -1));
            AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "width:" + this.liveContainer.getMeasuredWidth() + ", height:" + this.liveContainer.getMeasuredHeight());
        }
    }

    private final void t(String url) {
        if (this.qqlivePlayer == null) {
            IQQLivePlayer qQLivePlayer = ((IQQLivePlayerFactory) QRoute.api(IQQLivePlayerFactory.class)).getQQLivePlayer(new PlayerConfig(129, true, false, 0L, false, false, null, 0L, 0L, 0L, 0L, 0L, 0L, null, 0.0f, false, 0L, 0L, false, false, null, 0L, false, 8388604, null));
            this.qqlivePlayer = qQLivePlayer;
            j(qQLivePlayer);
        }
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.startPlay(url);
        }
        AppNetConnInfo.registerNetChangeReceiver(this.liveContainer.getContext(), this.netObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(e this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IQQLivePlayer iQQLivePlayer = this$0.qqlivePlayer;
        if (iQQLivePlayer != null && z16 && !iQQLivePlayer.isPlaying()) {
            iQQLivePlayer.replay();
        }
    }

    public final void A(@Nullable b callback) {
        AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "previewVideo", "previewVideoUrl:" + this.previewVideoUrl);
        this.previewCallback = callback;
        t(this.previewVideoUrl);
        this.isClickPreviewVideo = true;
    }

    public final void n() {
        AppNetConnInfo.unregisterNetEventHandler(this.netObserver);
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.release();
        }
        this.liveContainer.removeAllViews();
        this.qqlivePlayer = null;
        this.previewCallback = null;
        this.isClickPreviewVideo = false;
        RtmpAnchorVideoOperateView.b bVar = this.listener;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void o(boolean mute) {
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.setOutputMute(mute);
        }
    }

    public final void p(boolean play) {
        if (play) {
            IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
            if (iQQLivePlayer != null) {
                iQQLivePlayer.replay();
                return;
            }
            return;
        }
        IQQLivePlayer iQQLivePlayer2 = this.qqlivePlayer;
        if (iQQLivePlayer2 != null) {
            iQQLivePlayer2.pause();
        }
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final LiveTipsView getLiveTipsView() {
        return this.liveTipsView;
    }

    public final boolean u() {
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            return iQQLivePlayer.isOutputMute();
        }
        return false;
    }

    public final boolean v() {
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            return iQQLivePlayer.isPlaying();
        }
        return false;
    }

    public final void x() {
        AppNetConnInfo.unregisterNetEventHandler(this.netObserver);
        IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
        if (iQQLivePlayer != null) {
            iQQLivePlayer.release();
        }
        this.qqlivePlayer = null;
    }

    public final void y() {
        AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "onLinkScreenEnd", "previewVideoUrl:" + this.previewVideoUrl);
        if (this.isClickPreviewVideo) {
            D(this.previewVideoUrl);
            IQQLivePlayer iQQLivePlayer = this.qqlivePlayer;
            if (iQQLivePlayer != null) {
                iQQLivePlayer.setOutputMute(this.isMuteState);
                return;
            }
            return;
        }
        n();
    }

    public final void z(@NotNull String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        AegisLogger.INSTANCE.i("Open_Live|PKWithOBS|PreviewVideoModel", "onLinkScreenStart", "videoUrl:" + videoUrl);
        if (this.isClickPreviewVideo) {
            this.isMuteState = u();
            D(videoUrl);
        } else {
            t(videoUrl);
        }
    }
}
