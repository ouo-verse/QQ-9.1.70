package com.tencent.ntcompose.material;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.views.CanvasBlendMode;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010.\u001a\u00020\u001a\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J8\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016R\u0017\u0010.\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b,\u0010-R.\u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R.\u00107\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R.\u0010?\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u0001088\u0000@@X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010D\u001a\u0012\u0012\u0004\u0012\u00020A0@j\b\u0012\u0004\u0012\u00020A`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/ntcompose/material/i;", "", "", "style", "", tl.h.F, "methodName", "params", "c", "Lkotlin/Pair;", "", "point", "o", "newPoint", "u", DomainData.DOMAIN_NAME, "b", HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "centerX", "centerY", "radius", "startAngle", "endAngle", "", "counterclockwise", "a", "d", ReportConstant.COSTREPORT_PREFIX, "e", "Lcom/tencent/kuikly/core/base/h;", "color", "t", "f", "width", "l", "j", "i", "Lcom/tencent/kuikly/core/views/CanvasBlendMode;", com.tencent.luggage.wxa.c8.c.W, "r", "Z", "g", "()Z", "undoEnable", "Lkotlin/Pair;", "getCurPoint", "()Lkotlin/Pair;", "setCurPoint", "(Lkotlin/Pair;)V", "curPoint", "getLastPoint", "setLastPoint", "lastPoint", "Lcom/tencent/kuikly/core/views/CanvasView;", "value", "Lcom/tencent/kuikly/core/views/CanvasView;", "getCanvasView$ntcompose_release", "()Lcom/tencent/kuikly/core/views/CanvasView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/kuikly/core/views/CanvasView;)V", "canvasView", "Ljava/util/ArrayList;", "Lcom/tencent/ntcompose/material/g;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "lazyCanvasDrawApiTasks", "<init>", "(Z)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {

    /* renamed from: f, reason: collision with root package name */
    public static final int f339424f = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean undoEnable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Pair<Float, Float> curPoint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Pair<Float, Float> lastPoint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CanvasView canvasView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<CanvasViewMethod> lazyCanvasDrawApiTasks;

    public i() {
        this(false, 1, null);
    }

    private final void c(String methodName, String params) {
        CanvasView canvasView = this.canvasView;
        if (canvasView == null) {
            this.lazyCanvasDrawApiTasks.add(new CanvasViewMethod(methodName, params, null, 4, null));
        } else if (canvasView != null) {
            AbstractBaseView.callRenderViewMethod$default(canvasView, methodName, params, null, 4, null);
        }
    }

    private final void h(String style) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", style);
        c("lineCap", eVar.toString());
    }

    private final void o(Pair<Float, Float> point) {
        this.curPoint = point;
        this.lastPoint = point;
    }

    private final void u(Pair<Float, Float> newPoint) {
        if (newPoint.getFirst().floatValue() == this.curPoint.getFirst().floatValue()) {
            if (newPoint.getSecond().floatValue() == this.curPoint.getSecond().floatValue()) {
                return;
            }
        }
        this.lastPoint = this.curPoint;
        this.curPoint = newPoint;
    }

    public void d() {
        c(com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_CLOSEPATH, "");
    }

    public void e() {
        c(com.tencent.qqmini.miniapp.widget.CanvasView.CUSTOM_ACTION_FILL, "");
    }

    public void f(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", color.toString());
        c("fillStyle", eVar.toString());
    }

    /* renamed from: g, reason: from getter */
    public final boolean getUndoEnable() {
        return this.undoEnable;
    }

    public void i() {
        h("butt");
    }

    public void j() {
        h("round");
    }

    public void k(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        u(new Pair<>(Float.valueOf(x16), Float.valueOf(y16)));
        c(com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_LINETO, eVar.toString());
    }

    public void l(float width) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("width", Float.valueOf(width));
        c("lineWidth", eVar.toString());
    }

    public void m(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        o(new Pair<>(Float.valueOf(x16), Float.valueOf(y16)));
        c(com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_MOVETO, eVar.toString());
    }

    public void r(CanvasBlendMode blendMode) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        c("setClearBlendMode", String.valueOf(blendMode.ordinal()));
    }

    public void s() {
        c("stroke", "");
    }

    public void t(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", color.toString());
        c("strokeStyle", eVar.toString());
    }

    public i(boolean z16) {
        this.undoEnable = z16;
        Float valueOf = Float.valueOf(0.0f);
        this.curPoint = new Pair<>(valueOf, valueOf);
        this.lastPoint = new Pair<>(valueOf, valueOf);
        this.lazyCanvasDrawApiTasks = new ArrayList<>();
    }

    public void b() {
        p(this, null, 1, null);
        c("beginPath", "");
    }

    public final void n() {
        p(this, null, 1, null);
        c("reset", "");
    }

    public final void q(CanvasView canvasView) {
        if (canvasView != null && !Intrinsics.areEqual(this.canvasView, canvasView)) {
            this.canvasView = canvasView;
            for (CanvasViewMethod canvasViewMethod : this.lazyCanvasDrawApiTasks) {
                c(canvasViewMethod.getMethodName(), canvasViewMethod.getParams());
            }
            this.lazyCanvasDrawApiTasks.clear();
        }
        this.canvasView = canvasView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void p(i iVar, Pair pair, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            pair = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        }
        iVar.o(pair);
    }

    public /* synthetic */ i(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }

    public void a(float centerX, float centerY, float radius, float startAngle, float endAngle, boolean counterclockwise) {
        if (6.2831855f + startAngle == endAngle) {
            endAngle -= 0.01f;
            counterclockwise = false;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(centerX));
        eVar.v("y", Float.valueOf(centerY));
        eVar.v("r", Float.valueOf(radius));
        eVar.v("sAngle", Float.valueOf(startAngle));
        eVar.v("eAngle", Float.valueOf(endAngle));
        eVar.t("counterclockwise", com.tencent.kuikly.core.base.d.b(counterclockwise));
        c(com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_ARC, eVar.toString());
    }
}
