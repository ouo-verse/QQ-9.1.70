package com.tencent.mobileqq.zplan.smallhome.floatwindow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001*\u0018\u0000 42\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "", "w0", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/c;", "u0", "updateFloatingView", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "Landroid/view/View;", "customView", "", "j", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "quitWindowFloat", "Landroid/content/Context;", "context", "B", "initWidgetWrapper", "initStatusReceiver", "e", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/c;", "animationHelper", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;", "f", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/ZPlanSmallHomeFloatView;", "floatView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "cacheCloseView", "i", "I", "mapId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", ZPlanPublishSource.FROM_SCHEME, "", BdhLogUtil.LogTag.Tag_Conn, "J", "startShowTimeMs", "com/tencent/mobileqq/zplan/smallhome/floatwindow/e$b", "D", "Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e$b;", "dragListener", "Ljava/lang/Runnable;", "E", "Ljava/lang/Runnable;", "runnable", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends com.tencent.mobileqq.qqfloatingwindow.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String F;

    /* renamed from: C, reason: from kotlin metadata */
    private long startShowTimeMs;

    /* renamed from: D, reason: from kotlin metadata */
    private final b dragListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final Runnable runnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.smallhome.floatwindow.c animationHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanSmallHomeFloatView floatView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView cacheCloseView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mapId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String scheme;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/floatwindow/e$a;", "", "", "CLASS_NAME", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "MIN_SHOW_DURATION_MS", "J", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.smallhome.floatwindow.e$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return e.F;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/floatwindow/e$b", "Lgh2/b;", "", "screenWidth", "newTop", "newLeft", "", "d", "newCenterX", "newCenterY", "", "e", "onDragEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements gh2.b {
        b() {
        }

        @Override // gh2.b
        public boolean d(int screenWidth, int newTop, int newLeft) {
            QLog.i("ZPlanFloatingProxyWrapper", 1, "dragListener#interuptOnDragToEdge, floatingContainerCenterX= " + e.this.r() + ", floatingContainerCenterY= " + e.this.s() + ", newTop= " + newTop + ", newLeft= " + newLeft);
            com.tencent.mobileqq.zplan.smallhome.floatwindow.c cVar = e.this.animationHelper;
            if (cVar != null) {
                cVar.f(screenWidth, newTop, newLeft);
            }
            return true;
        }

        @Override // gh2.b
        public void e(int newCenterX, int newCenterY) {
            QLog.i("ZPlanFloatingProxyWrapper", 1, "dragListener#onDragging, newCenterX= " + newCenterX + ", newCenterY= " + newCenterY);
            ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = e.this.floatView;
            if (zPlanSmallHomeFloatView != null) {
                ZPlanSmallHomeFloatView.r(zPlanSmallHomeFloatView, false, 1, null);
            }
        }

        @Override // gh2.b
        public void onDragEnd() {
            QLog.i("ZPlanFloatingProxyWrapper", 1, "dragListener#onDragEnd, floatingContainerCenterX= " + e.this.r() + ", floatingContainerCenterY= " + e.this.s());
            ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = e.this.floatView;
            if (zPlanSmallHomeFloatView != null) {
                zPlanSmallHomeFloatView.m();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/smallhome/floatwindow/e$c", "Lgh2/f;", "", "c", "a", "", "canPlay", "d", "b", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements gh2.f {
        c() {
        }

        @Override // gh2.f
        public void d(boolean canPlay) {
            QLog.d("ZPlanFloatingProxyWrapper", 1, "onWindowShow, canPlay:" + canPlay + ", " + e.this.r() + ", " + e.this.s());
            if (e.this.t() || e.this.u() == 0) {
                return;
            }
            e.this.U(true);
            ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = e.this.floatView;
            if (zPlanSmallHomeFloatView != null) {
                zPlanSmallHomeFloatView.k();
            }
        }

        @Override // gh2.f
        public void e() {
            QLog.d("ZPlanFloatingProxyWrapper", 1, "onWindowResume");
            if (!ZPlanFloatWindowManager.f335646d.i()) {
                QLog.d("ZPlanFloatingProxyWrapper", 1, "app is not foreground, return");
            } else {
                if (e.this.t() || e.this.u() == 0) {
                    return;
                }
                e.this.U(true);
            }
        }

        @Override // gh2.f
        public void a() {
            QLog.d("ZPlanFloatingProxyWrapper", 1, "onWindowHide");
            long currentTimeMillis = System.currentTimeMillis() - e.this.startShowTimeMs;
            if (currentTimeMillis > 1000) {
                ThreadManagerV2.getUIHandlerV2().post(e.this.runnable);
            } else {
                ThreadManagerV2.getUIHandlerV2().postDelayed(e.this.runnable, 1000 - currentTimeMillis);
            }
        }

        @Override // gh2.f
        public void b() {
            QLog.d("ZPlanFloatingProxyWrapper", 1, "onWindowDismiss");
        }

        @Override // gh2.f
        public void c() {
            QLog.d("ZPlanFloatingProxyWrapper", 1, "onWindowPause");
            e.this.U(false);
        }
    }

    static {
        String name = e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ZPlanFloatingProxyWrapper::class.java.name");
        F = name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mapId = -1;
        this.scheme = "";
        this.dragListener = new b();
        this.runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.smallhome.floatwindow.d
            @Override // java.lang.Runnable
            public final void run() {
                e.v0(e.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U(false);
    }

    private final void w0() {
        View n3 = n();
        Intrinsics.checkNotNull(n3, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) n3;
        imageView.setImageResource(R.drawable.ihm);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.removeRule(10);
        layoutParams2.removeRule(9);
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        float dimension = imageView.getContext().getResources().getDimension(R.dimen.f12377a);
        float dimension2 = imageView.getContext().getResources().getDimension(R.dimen.f12367_);
        layoutParams2.width = (int) dimension;
        layoutParams2.height = (int) dimension2;
        imageView.setPadding(com.tencent.sqshow.zootopia.utils.i.b(1), com.tencent.sqshow.zootopia.utils.i.b(1), com.tencent.sqshow.zootopia.utils.i.a(4.5f), com.tencent.sqshow.zootopia.utils.i.a(5.5f));
        this.cacheCloseView = imageView;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(Context context) {
        super.B(context);
        z().setBackgroundColor(0);
        z().setContentDescription("\u5c0f\u7a9d\u60ac\u6d6e\u7a97");
        w0();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void initWidgetWrapper(View customView) {
        super.initWidgetWrapper(customView);
        ZPlanSmallHomeFloatView zPlanSmallHomeFloatView = customView instanceof ZPlanSmallHomeFloatView ? (ZPlanSmallHomeFloatView) customView : null;
        this.floatView = zPlanSmallHomeFloatView;
        this.animationHelper = new com.tencent.mobileqq.zplan.smallhome.floatwindow.c(this, zPlanSmallHomeFloatView);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(FloatingScreenParams floatParams, View customView) {
        Intrinsics.checkNotNullParameter(floatParams, "floatParams");
        Intrinsics.checkNotNullParameter(customView, "customView");
        QLog.d("ZPlanFloatingProxyWrapper", 1, "enterWindowFloat");
        int j3 = super.j(floatParams, customView);
        I();
        R(this.dragListener);
        this.startShowTimeMs = System.currentTimeMillis();
        return j3;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int closeReason) {
        QLog.d("ZPlanFloatingProxyWrapper", 1, "quitWindowFloat, " + r() + ", " + s());
        ZPlanFloatWindowManager.f335646d.k(r(), s());
        super.quitWindowFloat(closeReason);
    }

    /* renamed from: u0, reason: from getter */
    public final com.tencent.mobileqq.zplan.smallhome.floatwindow.c getAnimationHelper() {
        return this.animationHelper;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        super.updateFloatingView();
        QLog.d("ZPlanFloatingProxyWrapper", 1, "updateFloatingView, " + r() + ", " + s());
        T(0, 0, 0, 0);
        V(null);
        P(null);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        QLog.d("ZPlanFloatingProxyWrapper", 1, "initStatusReceiver");
        g(-1, new c());
    }
}
