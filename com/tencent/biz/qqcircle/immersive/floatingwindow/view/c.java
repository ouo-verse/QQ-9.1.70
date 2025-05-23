package com.tencent.biz.qqcircle.immersive.floatingwindow.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p40.u;
import tl.h;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u001a\u0010\u001b\u001a\u00020\u00168\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u00168\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/floatingwindow/view/c;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "", "o0", "Landroid/content/Context;", "context", "B", "Landroid/view/View;", "customView", "initWidgetWrapper", "updateFloatingView", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "", "j", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "quitWindowFloat", "innerRoundCorners", "outerRoundCorners", "setRoundCorners", "shapeType", "m0", "", "e", "Ljava/lang/String;", "getSP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_X", "()Ljava/lang/String;", "SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_X", "f", "getSP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_Y", "SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_Y", "Lcom/tencent/biz/qqcircle/immersive/floatingwindow/view/QFSVideoFloatWindowView;", h.F, "Lcom/tencent/biz/qqcircle/immersive/floatingwindow/view/QFSVideoFloatWindowView;", "floatView", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends com.tencent.mobileqq.qqfloatingwindow.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_X;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_Y;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSVideoFloatWindowView floatView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_X = "sp_key_qfs_video_floating_window_location_x";
        this.SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_Y = "sp_key_qfs_video_floating_window_location_y";
    }

    private final void o0() {
        T(2, 2, 2, 2);
        L(true);
        W(true);
        Context v3 = v();
        if (v3 != null) {
            v3.getResources();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(@Nullable Context context) {
        super.B(context);
        z().setBackgroundColor(0);
        z().setContentDescription("\u5c0f\u4e16\u754c\u60ac\u6d6e\u7a97");
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void initWidgetWrapper(@Nullable View customView) {
        QFSVideoFloatWindowView qFSVideoFloatWindowView;
        super.initWidgetWrapper(customView);
        if (customView instanceof QFSVideoFloatWindowView) {
            qFSVideoFloatWindowView = (QFSVideoFloatWindowView) customView;
        } else {
            qFSVideoFloatWindowView = null;
        }
        this.floatView = qFSVideoFloatWindowView;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(@Nullable FloatingScreenParams floatParams, @Nullable View customView) {
        int j3 = super.j(floatParams, customView);
        I();
        o0();
        QFSVideoFloatWindowView qFSVideoFloatWindowView = this.floatView;
        if (qFSVideoFloatWindowView != null) {
            qFSVideoFloatWindowView.i();
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void m0(int shapeType) {
        if (shapeType != q()) {
            H();
            super.m0(shapeType);
            H();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int closeReason) {
        super.quitWindowFloat(closeReason);
        QFSVideoFloatWindowView qFSVideoFloatWindowView = this.floatView;
        if (qFSVideoFloatWindowView != null) {
            qFSVideoFloatWindowView.h();
        }
        k.a().m(this.SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_X, r());
        k.a().m(this.SP_KEY_QFS_VIDEO_FLOATING_WINDOW_LOCATION_Y, s());
        u.H().w0();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void setRoundCorners(int innerRoundCorners, int outerRoundCorners) {
        int dip2px = ViewUtils.dip2px(8.0f);
        super.setRoundCorners(dip2px, dip2px);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        super.updateFloatingView();
        View A = A(R.id.m2t);
        if (A != null) {
            A.setVisibility(8);
        }
    }
}
