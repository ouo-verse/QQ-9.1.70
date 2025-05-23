package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.content.Context;
import android.view.View;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/n;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "", "isSmallFloating", "", "y0", "v0", "updateFloatingView", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "Landroid/view/View;", "customView", "", "j", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "quitWindowFloat", "Landroid/content/Context;", "context", "B", "innerRoundCorners", "outerRoundCorners", "setRoundCorners", "initStatusReceiver", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "", "f", "J", "startShowTimeMs", "Ljava/lang/Runnable;", tl.h.F, "Ljava/lang/Runnable;", "hideRunnable", "i", "showRunnable", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class n extends com.tencent.mobileqq.qqfloatingwindow.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String f115293m;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startShowTimeMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable hideRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable showRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/n$a;", "", "", "CLASS_NAME", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "MIN_SHOW_DURATION_MS", "J", "TAG", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.floatwindow.n$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return n.f115293m;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/n$b", "Lgh2/f;", "", "c", "a", "", "canPlay", "d", "b", "e", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements gh2.f {
        b() {
        }

        @Override // gh2.f
        public void a() {
            n.this.aegisLog.i("ICGameFloatingProxyWrapper", "onWindowHide");
            QQLiveFloatWindowManager.f115256a.u();
            long currentTimeMillis = System.currentTimeMillis() - n.this.startShowTimeMs;
            if (currentTimeMillis > 1000) {
                ThreadManagerV2.getUIHandlerV2().post(n.this.hideRunnable);
            } else {
                ThreadManagerV2.getUIHandlerV2().postDelayed(n.this.hideRunnable, 1000 - currentTimeMillis);
            }
        }

        @Override // gh2.f
        public void b() {
            n.this.aegisLog.i("ICGameFloatingProxyWrapper", "onWindowDismiss");
        }

        @Override // gh2.f
        public void c() {
            n.this.aegisLog.i("ICGameFloatingProxyWrapper", "onWindowPause");
            ThreadManagerV2.getUIHandlerV2().post(n.this.hideRunnable);
        }

        @Override // gh2.f
        public void d(boolean canPlay) {
            n.this.aegisLog.i("ICGameFloatingProxyWrapper", "onWindowShow, canPlay:" + canPlay);
            QQLiveFloatWindowManager.f115256a.v();
            ThreadManagerV2.getUIHandlerV2().post(n.this.showRunnable);
        }

        @Override // gh2.f
        public void e() {
            n.this.aegisLog.i("ICGameFloatingProxyWrapper", "onWindowResume");
            ThreadManagerV2.getUIHandlerV2().post(n.this.showRunnable);
        }
    }

    static {
        String name = n.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "QQLiveFloatingProxyWrapper::class.java.name");
        f115293m = name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.hideRunnable = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.l
            @Override // java.lang.Runnable
            public final void run() {
                n.w0(n.this);
            }
        };
        this.showRunnable = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.m
            @Override // java.lang.Runnable
            public final void run() {
                n.x0(n.this);
            }
        };
    }

    private final void v0() {
        View A = A(R.id.m2t);
        if (A != null) {
            A.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(n this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(n this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.t() && this$0.u() != 0) {
            this$0.U(true);
        }
    }

    private final void y0(boolean isSmallFloating) {
        int i3;
        if (isSmallFloating) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        T(i3, i3, i3, i3);
        L(isSmallFloating);
        W(isSmallFloating);
        Context v3 = v();
        if (v3 != null) {
            v3.getResources();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(@Nullable Context context) {
        super.B(context);
        z().setBackgroundColor(0);
        z().setContentDescription("QQ\u76f4\u64ad\u60ac\u6d6e\u7a97");
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        this.aegisLog.i("ICGameFloatingProxyWrapper", "initStatusReceiver");
        g(-1, new b());
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(@NotNull FloatingScreenParams floatParams, @NotNull View customView) {
        Intrinsics.checkNotNullParameter(floatParams, "floatParams");
        Intrinsics.checkNotNullParameter(customView, "customView");
        this.aegisLog.i("ICGameFloatingProxyWrapper", "enterWindowFloat");
        int j3 = super.j(floatParams, customView);
        I();
        this.startShowTimeMs = System.currentTimeMillis();
        y0(true);
        QQLiveFloatWindowManager.f115256a.s();
        return j3;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int closeReason) {
        this.aegisLog.i("ICGameFloatingProxyWrapper", "quitWindowFloat");
        QQLiveFloatWindowManager.f115256a.t();
        super.quitWindowFloat(closeReason);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void setRoundCorners(int innerRoundCorners, int outerRoundCorners) {
        int dip2px = ViewUtils.dip2px(8.0f);
        super.setRoundCorners(dip2px, dip2px);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        super.updateFloatingView();
        v0();
    }
}
