package com.tencent.mobileqq.qqlive.widget.floatwindow;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/floatwindow/g;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "", "B0", "w0", "", "show", "z0", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "x0", "updateFloatingView", "Landroid/view/View;", "customView", "initWidgetWrapper", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "", "j", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "quitWindowFloat", "Landroid/content/Context;", "context", "B", "innerRoundCorners", "outerRoundCorners", "setRoundCorners", "initStatusReceiver", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "e", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "", "f", "J", "startShowTimeMs", "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/QQLiveFloatWindowView2;", h.F, "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/QQLiveFloatWindowView2;", "floatView", "i", "Z", "isWindowShow", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "hideRunnable", BdhLogUtil.LogTag.Tag_Conn, "showRunnable", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g extends com.tencent.mobileqq.qqfloatingwindow.a {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Runnable showRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startShowTimeMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveFloatWindowView2 floatView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isWindowShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable hideRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/floatwindow/g$a;", "", "", "KEY_QQLIVE_FLOAT_WINDOW_IS_SHOW", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.floatwindow.g$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/widget/floatwindow/g$b", "Lgh2/f;", "", "c", "a", "", "canPlay", "d", "b", "e", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements gh2.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // gh2.f
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            g.this.aegisLog.i("QQLiveFloatWindowWrapper", "onWindowShow");
            g.this.isWindowShow = false;
            g.this.w0();
        }

        @Override // gh2.f
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                g.this.aegisLog.i("QQLiveFloatWindowWrapper", "onWindowDismiss");
            }
        }

        @Override // gh2.f
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                g.this.aegisLog.i("QQLiveFloatWindowWrapper", "onWindowPause");
                ThreadManagerV2.getUIHandlerV2().post(g.this.hideRunnable);
            }
        }

        @Override // gh2.f
        public void d(boolean canPlay) {
            com.tencent.mobileqq.qqlive.sail.room.e x06;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                g.this.aegisLog.i("QQLiveFloatWindowWrapper", "onWindowShow, canPlay:" + canPlay);
                boolean z16 = true;
                g.this.isWindowShow = true;
                com.tencent.mobileqq.qqlive.sail.room.e x07 = g.this.x0();
                if (x07 == null || x07.isPlaying()) {
                    z16 = false;
                }
                if (z16 && (x06 = g.this.x0()) != null) {
                    x06.resume();
                }
                ThreadManagerV2.getUIHandlerV2().post(g.this.showRunnable);
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, canPlay);
        }

        @Override // gh2.f
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            g.this.aegisLog.i("QQLiveFloatWindowWrapper", "onWindowResume");
            boolean e16 = ct3.a.e("qqlive_key_audience_show_float_window_in_background", false);
            g.this.aegisLog.i("QQLiveFloatWindowWrapper", "onWindowResume, shouldShowInBackground=" + e16);
            if (g.this.isWindowShow || e16) {
                ThreadManagerV2.getUIHandlerV2().post(g.this.showRunnable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35334);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.hideRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.floatwindow.e
            @Override // java.lang.Runnable
            public final void run() {
                g.y0(g.this);
            }
        };
        this.showRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.floatwindow.f
            @Override // java.lang.Runnable
            public final void run() {
                g.A0(g.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.t() && this$0.u() != 0) {
            this$0.U(true);
        }
    }

    private final void B0() {
        T(2, 2, 2, 2);
        L(true);
        W(true);
        Context v3 = v();
        if (v3 != null) {
            v3.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (r0.i() == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w0() {
        boolean z16;
        com.tencent.mobileqq.qqlive.sail.room.e x06;
        boolean e16 = ct3.a.e("qqlive_key_audience_show_float_window_in_background", false);
        this.aegisLog.i("QQLiveFloatWindowWrapper", "onWindowHide, shouldShowInBackground=" + e16);
        if (e16) {
            return;
        }
        QQLiveFloatWindowView2 qQLiveFloatWindowView2 = this.floatView;
        if (qQLiveFloatWindowView2 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 && (x06 = x0()) != null) {
            x06.pause();
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            U(false);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(this.hideRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U(false);
    }

    private final void z0(boolean show) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
        from.encodeBool("key_qqlive_float_window_is_show", show);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        super.B(context);
        z().setBackgroundColor(0);
        z().setContentDescription("QQ\u76f4\u64ad\u60ac\u6d6e\u7a97");
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.aegisLog.i("QQLiveFloatWindowWrapper", "initStatusReceiver");
        this.startShowTimeMs = System.currentTimeMillis();
        if (!BaseGesturePWDUtil.getAppForground(BaseApplication.context)) {
            this.aegisLog.i("QQLiveFloatWindowWrapper", "\u5c0f\u7a97\u521d\u59cb\u5316\u9636\u6bb5 app is background");
            w0();
        }
        g(-1, new b());
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void initWidgetWrapper(@Nullable View customView) {
        QQLiveFloatWindowView2 qQLiveFloatWindowView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) customView);
            return;
        }
        super.initWidgetWrapper(customView);
        if (customView instanceof QQLiveFloatWindowView2) {
            qQLiveFloatWindowView2 = (QQLiveFloatWindowView2) customView;
        } else {
            qQLiveFloatWindowView2 = null;
        }
        this.floatView = qQLiveFloatWindowView2;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(@NotNull FloatingScreenParams floatParams, @NotNull View customView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) floatParams, (Object) customView)).intValue();
        }
        Intrinsics.checkNotNullParameter(floatParams, "floatParams");
        Intrinsics.checkNotNullParameter(customView, "customView");
        this.aegisLog.i("QQLiveFloatWindowWrapper", "enterWindowFloat");
        int j3 = super.j(floatParams, customView);
        I();
        B0();
        QQLiveFloatWindowView2 qQLiveFloatWindowView2 = this.floatView;
        if (qQLiveFloatWindowView2 != null) {
            qQLiveFloatWindowView2.y();
        }
        z0(true);
        return j3;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int closeReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, closeReason);
            return;
        }
        this.aegisLog.i("QQLiveFloatWindowWrapper", "quitWindowFloat");
        super.quitWindowFloat(closeReason);
        QQLiveFloatWindowView2 qQLiveFloatWindowView2 = this.floatView;
        if (qQLiveFloatWindowView2 != null) {
            qQLiveFloatWindowView2.z();
        }
        this.floatView = null;
        z0(false);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void setRoundCorners(int innerRoundCorners, int outerRoundCorners) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(innerRoundCorners), Integer.valueOf(outerRoundCorners));
        } else {
            int dip2px = ViewUtils.dip2px(8.0f);
            super.setRoundCorners(dip2px, dip2px);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.updateFloatingView();
        View A = A(R.id.m2t);
        if (A != null) {
            A.setVisibility(8);
        }
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.room.e x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QQLiveFloatWindowView2 qQLiveFloatWindowView2 = this.floatView;
        if (qQLiveFloatWindowView2 != null) {
            return qQLiveFloatWindowView2.k();
        }
        return null;
    }
}
