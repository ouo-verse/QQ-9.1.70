package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowOperateView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00016\u0018\u0000 B2\u00020\u0001:\u0002CDB\u001f\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R#\u0010*\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006E"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView;", "Landroid/widget/FrameLayout;", "", "o", "Landroid/content/Intent;", "resumeIntent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "childView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "Lcom/tencent/mobileqq/icgame/api/room/ILiveAudienceTPPlayerRoom;", "j", "Landroid/view/ViewGroup;", "l", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$b;", "listenerUI", "setFloatViewUIChangedListener", "", "p", "r", DomainData.DOMAIN_NAME, "i", "isMute", "setMute", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/i;", "d", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/i;", "qqLiveFloatWindowParams", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "operateCallback", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "Lfu0/c;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "k", "()Lfu0/c;", "liveRoomService", "Landroid/view/View;", "roomDisplayView", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView;", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView;", "floatWinOperateView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$b;", "floatViewUIChangedListener", "D", "Landroid/view/ViewGroup;", "netTipViewGroup", "com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$d", "E", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$d;", "roomStatusListener", "Lb32/a;", UserInfo.SEX_FEMALE, "Lb32/a;", "roomPlayerListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/i;Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;)V", "G", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveFloatWindowView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b floatViewUIChangedListener;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ViewGroup netTipViewGroup;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final d roomStatusListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b32.a roomPlayerListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveFloatWindowParams qqLiveFloatWindowParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveFloatWindowOperateView.a operateCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View roomDisplayView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveFloatWindowOperateView floatWinOperateView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$b;", "", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$c", "Lb32/a;", "", "startTime", "endTime", "", "onFirstFrameCome", "", "width", "height", "onVideoSizeChanged", "onPlayCompleted", "errorCode", "", "msg", "onError", "onResume", "onStartBuffer", "onStopBuffer", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPlay", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c extends b32.a {
        c() {
        }

        @Override // b32.a
        public void onError(int errorCode, @Nullable String msg2) {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onError, code:" + errorCode + " ,msg:" + msg2);
        }

        @Override // b32.a
        public void onFirstFrameCome(long startTime, long endTime) {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onFirstFrameCome");
        }

        @Override // b32.a
        public void onPause() {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onPause");
        }

        @Override // b32.a
        public void onPlay() {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onPlay");
            QQLiveFloatWindowView.this.floatWinOperateView.g();
        }

        @Override // b32.a
        public void onPlayCompleted() {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onPlayCompleted");
        }

        @Override // b32.a
        public void onResume() {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onResume");
            QQLiveFloatWindowView.this.floatWinOperateView.g();
        }

        @Override // b32.a
        public void onStartBuffer() {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onStartBuffer");
        }

        @Override // b32.a
        public void onStopBuffer() {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "AudienceRoomPlayerListener onStopBuffer");
        }

        @Override // b32.a
        public void onVideoSizeChanged(int width, int height) {
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "onVideoSizeChanged width:" + width + " , height:" + height);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$d", "Lb32/e;", "Lcom/tencent/mobileqq/qqlive/data/room/QQLiveRoomStatusInfo;", "info", "", "onRoomOpen", "onRoomClose", "onRoomPause", "onRoomResume", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements b32.e {
        d() {
        }

        @Override // b32.e
        public void onRoomClose(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "onRoomClose");
            QQLiveFloatWindowView.this.floatWinOperateView.f();
            b bVar = QQLiveFloatWindowView.this.floatViewUIChangedListener;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // b32.e
        public void onRoomOpen(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "onRoomOpen");
        }

        @Override // b32.e
        public void onRoomPause(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "onRoomPause");
        }

        @Override // b32.e
        public void onRoomResume(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            QQLiveFloatWindowView.this.aegisLog.i("ICGameFloatWindowView", "onRoomResume");
            QQLiveFloatWindowView.this.floatWinOperateView.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveFloatWindowView(@NotNull Context context, @NotNull QQLiveFloatWindowParams qqLiveFloatWindowParams, @NotNull QQLiveFloatWindowOperateView.a operateCallback) {
        super(context);
        Lazy lazy;
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(qqLiveFloatWindowParams, "qqLiveFloatWindowParams");
        Intrinsics.checkNotNullParameter(operateCallback, "operateCallback");
        this.qqLiveFloatWindowParams = qqLiveFloatWindowParams;
        this.operateCallback = operateCallback;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowView$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        ITPPlayerVideoView G = k().G();
        if (G != null) {
            view = G.getCurrentDisplayView();
        } else {
            view = null;
        }
        this.roomDisplayView = view;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        this.floatWinOperateView = new QQLiveFloatWindowOperateView(context2, qqLiveFloatWindowParams.getRoomCoverUrl(), null, 4, null);
        o();
        this.roomStatusListener = new d();
        this.roomPlayerListener = new c();
    }

    private final void f() {
        com.tencent.icgame.game.utils.k.b(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.j
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveFloatWindowView.g(QQLiveFloatWindowView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final QQLiveFloatWindowView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gv0.b bVar = gv0.b.f403419a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!bVar.a(context)) {
            com.tencent.icgame.game.utils.k.c(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveFloatWindowView.h(QQLiveFloatWindowView.this);
                }
            }, 300L);
            return;
        }
        ILiveAudienceTPPlayerRoom j3 = this$0.j();
        if (j3 != null) {
            j3.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QQLiveFloatWindowView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ILiveAudienceTPPlayerRoom j3 = this$0.j();
        if (j3 != null) {
            j3.pause();
        }
    }

    private final ILiveAudienceTPPlayerRoom j() {
        ILiveRoom z16 = ((fu0.c) qx0.a.b(fu0.c.class)).z(0L);
        if (z16 instanceof ILiveAudienceTPPlayerRoom) {
            return (ILiveAudienceTPPlayerRoom) z16;
        }
        return null;
    }

    private final fu0.c k() {
        return (fu0.c) this.liveRoomService.getValue();
    }

    private final void m(Intent resumeIntent) {
        this.aegisLog.i("ICGameFloatWindowView", "gotoLiveRoom");
        resumeIntent.putExtra("open_from_float_window", true);
        resumeIntent.addFlags(67108864);
        QQLiveFloatWindowManager.f115256a.x();
        BaseApplication.context.startActivity(resumeIntent);
    }

    private final void o() {
        removeAllViews();
        View view = this.roomDisplayView;
        if (view == null) {
            this.aegisLog.e("ICGameFloatWindowView", "roomDisplayView is null");
        } else {
            q(view);
            addView(this.roomDisplayView, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        QQLiveFloatWindowOperateView qQLiveFloatWindowOperateView = this.floatWinOperateView;
        addView(qQLiveFloatWindowOperateView);
        qQLiveFloatWindowOperateView.e();
        qQLiveFloatWindowOperateView.setMute(this.qqLiveFloatWindowParams.getPlayerMute());
        qQLiveFloatWindowOperateView.setOperateCallback(this.operateCallback);
        this.netTipViewGroup = (ViewGroup) this.floatWinOperateView.findViewById(R.id.f165240vb1);
    }

    private final void q(View childView) {
        if (childView != null) {
            try {
                ViewParent parent = childView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(childView);
            } catch (Exception e16) {
                this.aegisLog.e("ICGameFloatWindowView", "removeParent error:" + e16);
            }
        }
    }

    public final void i() {
        Intent resumeIntent = this.qqLiveFloatWindowParams.getResumeIntent();
        if (resumeIntent != null) {
            m(resumeIntent);
        }
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final ViewGroup getNetTipViewGroup() {
        return this.netTipViewGroup;
    }

    public final void n() {
        ILiveAudienceTPPlayerRoom j3 = j();
        if (j3 != null) {
            j3.unRegisterRoomPlayerListener(this.roomPlayerListener);
        }
        ILiveAudienceTPPlayerRoom j16 = j();
        if (j16 != null) {
            j16.unRegisterRoomStatusListener(this.roomStatusListener);
        }
    }

    public final boolean p() {
        View view = this.roomDisplayView;
        if (view == null || view.getWidth() <= view.getHeight()) {
            return false;
        }
        return true;
    }

    public final void r() {
        View view;
        ILiveAudienceTPPlayerRoom j3 = j();
        if (j3 != null) {
            j3.registerRoomPlayerListener(this.roomPlayerListener);
        }
        ILiveAudienceTPPlayerRoom j16 = j();
        if (j16 != null) {
            j16.registerRoomStatusListener(this.roomStatusListener);
        }
        ITPPlayerVideoView G = k().G();
        if (G != null) {
            view = G.getCurrentDisplayView();
        } else {
            view = null;
        }
        if (view != null) {
            f();
        }
    }

    public final void setFloatViewUIChangedListener(@NotNull b listenerUI) {
        Intrinsics.checkNotNullParameter(listenerUI, "listenerUI");
        this.floatViewUIChangedListener = listenerUI;
    }

    public final void setMute(boolean isMute) {
        this.floatWinOperateView.setMute(isMute);
    }
}
