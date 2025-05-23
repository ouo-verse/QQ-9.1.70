package com.tencent.kuikly.core.views;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020(\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J8\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J(\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/kuikly/core/views/p;", "", "", "style", "", "g", "b", "l", "()V", "", HippyTKDListViewAdapter.X, "y", "k", "i", "centerX", "centerY", "radius", "startAngle", "endAngle", "", "counterclockwise", "a", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Lcom/tencent/kuikly/core/base/h;", "color", DomainData.DOMAIN_NAME, "Lcom/tencent/kuikly/core/views/CanvasLinearGradient;", NodeProps.LINEAR_GRADIENT, "o", "f", "width", "j", tl.h.F, "x0", "y0", "x1", "y1", "d", "Lcom/tencent/kuikly/core/base/RenderView;", "Lcom/tencent/kuikly/core/base/RenderView;", "renderView", "<init>", "(Lcom/tencent/kuikly/core/base/RenderView;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RenderView renderView;

    public p(RenderView renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        this.renderView = renderView;
    }

    private final void g(String style) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", style);
        RenderView.b(this.renderView, "lineCap", eVar.toString(), null, 4, null);
    }

    public void b() {
        RenderView.b(this.renderView, "beginPath", "", null, 4, null);
    }

    public void c() {
        RenderView.b(this.renderView, com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_CLOSEPATH, "", null, 4, null);
    }

    public CanvasLinearGradient d(float x06, float y06, float x16, float y16) {
        return new CanvasLinearGradient(x06, y06, x16, y16);
    }

    public void e() {
        RenderView.b(this.renderView, com.tencent.qqmini.miniapp.widget.CanvasView.CUSTOM_ACTION_FILL, "", null, 4, null);
    }

    public void f(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", color.toString());
        RenderView.b(this.renderView, "fillStyle", eVar.toString(), null, 4, null);
    }

    public void h() {
        g("round");
    }

    public void i(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        RenderView.b(this.renderView, com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_LINETO, eVar.toString(), null, 4, null);
    }

    public void j(float width) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("width", Float.valueOf(width));
        RenderView.b(this.renderView, "lineWidth", eVar.toString(), null, 4, null);
    }

    public void k(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        RenderView.b(this.renderView, com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_MOVETO, eVar.toString(), null, 4, null);
    }

    public final void l() {
        RenderView.b(this.renderView, "reset", "", null, 4, null);
    }

    public void m() {
        RenderView.b(this.renderView, "stroke", "", null, 4, null);
    }

    public void n(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", color.toString());
        RenderView.b(this.renderView, "strokeStyle", eVar.toString(), null, 4, null);
    }

    public void o(CanvasLinearGradient linearGradient) {
        Intrinsics.checkNotNullParameter(linearGradient, "linearGradient");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", linearGradient.toString());
        RenderView.b(this.renderView, "strokeStyle", eVar.toString(), null, 4, null);
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
        RenderView.b(this.renderView, com.tencent.qqmini.miniapp.widget.CanvasView.ACTION_ARC, eVar.toString(), null, 4, null);
    }
}
