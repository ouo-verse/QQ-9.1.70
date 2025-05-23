package com.tencent.ntcompose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.views.CanvasLinearGradient;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yo3.Offset;
import yo3.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bZ\u0010[J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J:\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J8\u0010\u0011\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0002H\u0002J\b\u0010.\u001a\u00020\rH\u0002J\u001d\u0010\u001a\u001a\u00020\r2\u0006\u00100\u001a\u00020/H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u00101J\u0010\u00103\u001a\u00020\r2\u0006\u0010\f\u001a\u000202H\u0002J8\u0010:\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0002H\u0002J\u0006\u0010;\u001a\u00020\rJ\u0006\u0010<\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020\rJ\u000e\u0010@\u001a\u00020\r2\u0006\u0010?\u001a\u00020>J@\u0010A\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010B\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010C\u001a\u00020'2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010I\u001a\u00020D8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010E\u001a\u0004\bF\u0010G\"\u0004\b\u0019\u0010HR\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00120O8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010P\u001a\u0004\bQ\u0010RR&\u0010X\u001a\u0012\u0012\u0004\u0012\u00020U0Tj\b\u0012\u0004\u0012\u00020U`V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010WR&\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020U0Tj\b\u0012\u0004\u0012\u00020U`V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010W\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\\"}, d2 = {"Lcom/tencent/ntcompose/material/k;", "Lcom/tencent/ntcompose/material/j;", "", "startAngle", "sweepAngle", "", "useCenter", "Lyo3/a;", "topLeft", "Lyo3/d;", "size", "Lcom/tencent/ntcompose/material/l;", "style", "", "g", "center", "a", "b", "", WidgetCacheConstellationData.NUM, "i", "Lcom/tencent/ntcompose/material/ab;", "path", "l", "c", HippyTKDListViewAdapter.X, "y", "v", "t", "centerX", "centerY", "radius", "endAngle", "counterclockwise", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, DomainData.DOMAIN_NAME, "Lcom/tencent/kuikly/core/base/h;", "color", "B", "Lcom/tencent/kuikly/core/views/CanvasLinearGradient;", NodeProps.LINEAR_GRADIENT, BdhLogUtil.LogTag.Tag_Conn, "o", "p", "width", "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ntcompose/material/ae;", "strokeCap", "(I)V", "", "r", "controlPoint1X", "controlPoint1Y", "controlPoint2X", "controlPoint2Y", "pointX", "pointY", "d", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "Lcom/tencent/kuikly/core/base/RenderView;", "renderView", "f", tl.h.F, "k", "gradientColor", "Lcom/tencent/kuikly/core/views/p;", "Lcom/tencent/kuikly/core/views/p;", "getContext", "()Lcom/tencent/kuikly/core/views/p;", "(Lcom/tencent/kuikly/core/views/p;)V", "context", "Lyo3/d;", "getSize", "()Lyo3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lyo3/d;)V", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroidx/compose/runtime/MutableState;", "flag", "Ljava/util/ArrayList;", "Lcom/tencent/ntcompose/material/g;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "drawCallbackTrace", "lastDrawCallbackTrace", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public com.tencent.kuikly.core.views.p context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Size size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MutableState<Integer> flag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<CanvasViewMethod> drawCallbackTrace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<CanvasViewMethod> lastDrawCallbackTrace;

    public k() {
        MutableState<Integer> mutableStateOf$default;
        ArrayList<CanvasViewMethod> arrayListOf;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.flag = mutableStateOf$default;
        this.drawCallbackTrace = new ArrayList<>();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new CanvasViewMethod("", null, null, 6, null));
        this.lastDrawCallbackTrace = arrayListOf;
    }

    private final void A() {
        this.drawCallbackTrace.add(new CanvasViewMethod("stroke", "", null, 4, null));
    }

    private final void B(com.tencent.kuikly.core.base.h color) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", color.toString());
        this.drawCallbackTrace.add(new CanvasViewMethod("strokeStyle", eVar.toString(), null, 4, null));
    }

    private final void C(CanvasLinearGradient linearGradient) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", linearGradient.toString());
        this.drawCallbackTrace.add(new CanvasViewMethod("strokeStyle", eVar.toString(), null, 4, null));
    }

    private final void c() {
        this.drawCallbackTrace.add(new CanvasViewMethod("beginPath", "", null, 4, null));
    }

    private final void d(float controlPoint1X, float controlPoint1Y, float controlPoint2X, float controlPoint2Y, float pointX, float pointY) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("cp1x", Float.valueOf(controlPoint1X));
        eVar.v("cp1y", Float.valueOf(controlPoint1Y));
        eVar.v("cp2x", Float.valueOf(controlPoint2X));
        eVar.v("cp2y", Float.valueOf(controlPoint2Y));
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(pointX));
        eVar.v("y", Float.valueOf(pointY));
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_QBEZIER_CURVETO, eVar.toString(), null, 4, null));
    }

    private final void l(ab path, l style) {
        c();
        boolean z16 = style instanceof Stroke;
        u(z16 ? ((Stroke) style).getWidth() : 0.0f);
        this.drawCallbackTrace.addAll(path.e());
        if (z16) {
            y(((Stroke) style).getCap());
            A();
        } else {
            s();
            n();
        }
    }

    private final void n() {
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.CUSTOM_ACTION_FILL, "", null, 4, null));
    }

    private final void o(com.tencent.kuikly.core.base.h color) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", color.toString());
        this.drawCallbackTrace.add(new CanvasViewMethod("fillStyle", eVar.toString(), null, 4, null));
    }

    private final void p(CanvasLinearGradient linearGradient) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", linearGradient.toString());
        this.drawCallbackTrace.add(new CanvasViewMethod("fillStyle", eVar.toString(), null, 4, null));
    }

    private final void r(String style) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("style", style);
        this.drawCallbackTrace.add(new CanvasViewMethod("lineCap", eVar.toString(), null, 4, null));
    }

    private final void s() {
        r("square");
    }

    private final void t(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_LINETO, eVar.toString(), null, 4, null));
    }

    private final void u(float width) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("width", Float.valueOf(width));
        this.drawCallbackTrace.add(new CanvasViewMethod("lineWidth", eVar.toString(), null, 4, null));
    }

    private final void v(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_MOVETO, eVar.toString(), null, 4, null));
    }

    private final void y(int strokeCap) {
        if (ae.g(strokeCap)) {
            return;
        }
        r(ae.e(strokeCap));
    }

    @Override // com.tencent.ntcompose.material.j
    public void a(ab path, CanvasLinearGradient gradientColor, l style) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(gradientColor, "gradientColor");
        Intrinsics.checkNotNullParameter(style, "style");
        C(gradientColor);
        p(gradientColor);
        l(path, style);
    }

    public final void e() {
        this.drawCallbackTrace.clear();
    }

    public final void f(RenderView renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Iterator<CanvasViewMethod> it = this.drawCallbackTrace.iterator();
        while (it.hasNext()) {
            CanvasViewMethod next = it.next();
            renderView.a(next.getMethodName(), next.getParams(), next.a());
        }
    }

    @Override // com.tencent.ntcompose.material.j
    public Size getSize() {
        Size size = this.size;
        if (size != null) {
            return size;
        }
        Intrinsics.throwUninitializedPropertyAccessException("size");
        return null;
    }

    public void h(com.tencent.kuikly.core.base.h color, float startAngle, float sweepAngle, boolean useCenter, Offset topLeft, Size size, l style) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(style, "style");
        B(color);
        o(color);
        g(startAngle, sweepAngle, useCenter, topLeft, size, style);
    }

    public void k(ab path, com.tencent.kuikly.core.base.h color, l style) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(style, "style");
        B(color);
        o(color);
        l(path, style);
    }

    public final boolean m() {
        if (this.drawCallbackTrace.size() != this.lastDrawCallbackTrace.size()) {
            return false;
        }
        int size = this.drawCallbackTrace.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(this.drawCallbackTrace.get(i3), this.lastDrawCallbackTrace.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final MutableState<Integer> q() {
        return this.flag;
    }

    public final void w() {
        this.lastDrawCallbackTrace.clear();
        this.lastDrawCallbackTrace.addAll(this.drawCallbackTrace);
    }

    public void x(com.tencent.kuikly.core.views.p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<set-?>");
        this.context = pVar;
    }

    public void z(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.size = size;
    }

    private final void g(float startAngle, float sweepAngle, boolean useCenter, Offset topLeft, Size size, l style) {
        c();
        boolean z16 = style instanceof Stroke;
        u(z16 ? ((Stroke) style).getWidth() : 0.0f);
        float f16 = 2;
        Offset offset = new Offset(topLeft.getX() + (size.getWidth() / f16), topLeft.getY() + (size.getHeight() / f16));
        float width = size.getWidth() / f16;
        float height = size.getHeight() / f16;
        double d16 = (startAngle / 180.0f) * 3.1415927f;
        Offset offset2 = new Offset(offset.getX() + (((float) Math.cos(d16)) * width), offset.getY() + (((float) Math.sin(d16)) * height));
        if (useCenter && Math.abs(sweepAngle) < 360.0f) {
            v(offset.getX(), offset.getY());
            t(offset2.getX(), offset2.getY());
        } else {
            v(offset2.getX(), offset2.getY());
        }
        j(this, offset, width, height, startAngle, sweepAngle, 0, 32, null);
        if (useCenter && Math.abs(sweepAngle) < 360.0f) {
            t(offset.getX(), offset.getY());
        }
        if (z16) {
            y(((Stroke) style).getCap());
            A();
        } else {
            s();
            n();
        }
    }

    static /* synthetic */ void j(k kVar, Offset offset, float f16, float f17, float f18, float f19, int i3, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            i3 = 360;
        }
        kVar.i(offset, f16, f17, f18, f19, i3);
    }

    private final void b(float centerX, float centerY, float radius, float startAngle, float endAngle, boolean counterclockwise) {
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
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_ARC, eVar.toString(), null, 4, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v84 */
    private final void i(Offset center, float a16, float b16, float startAngle, float sweepAngle, int num) {
        int i3 = 1;
        float f16 = 3.1415927f;
        float f17 = 180.0f;
        if ((a16 == b16) == true) {
            b(center.getX(), center.getY(), a16, (startAngle / 180.0f) * 3.1415927f, ((startAngle + sweepAngle) / 180.0f) * 3.1415927f, sweepAngle < 0.0f);
            return;
        }
        if ((startAngle == 0.0f) != false) {
            if ((sweepAngle == 90.0f) != false) {
                t(center.getX() + a16, center.getY());
                d(center.getX() + a16, ((float) (b16 * 0.551915024494d)) + center.getY(), ((float) (a16 * 0.551915024494d)) + center.getX(), center.getY() + b16, center.getX(), center.getY() + b16);
                return;
            }
        }
        if ((startAngle == 90.0f) != false) {
            if ((sweepAngle == 90.0f) != false) {
                t(center.getX(), center.getY() + b16);
                d(center.getX() - ((float) (a16 * 0.551915024494d)), center.getY() + b16, center.getX() - a16, center.getY() + ((float) (b16 * 0.551915024494d)), center.getX() - a16, center.getY());
                return;
            }
        }
        if ((startAngle == 180.0f) != false) {
            if ((sweepAngle == 90.0f) != false) {
                t(center.getX() - a16, center.getY());
                d(center.getX() - a16, center.getY() - ((float) (b16 * 0.551915024494d)), center.getX() - ((float) (a16 * 0.551915024494d)), center.getY() - b16, center.getX(), center.getY() - b16);
                return;
            }
        }
        if ((startAngle == 270.0f) != false) {
            if (sweepAngle == 90.0f) {
                t(center.getX(), center.getY() - b16);
                d(((float) (a16 * 0.551915024494d)) + center.getX(), center.getY() - b16, center.getX() + a16, center.getY() - ((float) (b16 * 0.551915024494d)), center.getX() + a16, center.getY());
                return;
            }
        }
        float f18 = sweepAngle / num;
        if (1 > num) {
            return;
        }
        int i16 = 1;
        while (true) {
            float f19 = ((startAngle + ((i16 - 1) * f18)) / f17) * f16;
            float f26 = ((startAngle + (i16 * f18)) / f17) * f16;
            double d16 = f19;
            Offset offset = new Offset(center.getX() + (((float) Math.cos(d16)) * a16), center.getY() + (((float) Math.sin(d16)) * b16));
            double d17 = f26;
            float f27 = f18;
            int i17 = i16;
            Offset offset2 = new Offset(center.getX() + (((float) Math.cos(d17)) * a16), center.getY() + (((float) Math.sin(d17)) * b16));
            float f28 = i3;
            double d18 = (f26 - f19) / 4;
            float f29 = -a16;
            Offset offset3 = new Offset(offset.getX() + (((float) Math.tan(d18)) * f28 * ((float) Math.sin(d16)) * f29), offset.getY() + (((float) Math.tan(d18)) * f28 * ((float) Math.cos(d16)) * b16));
            Offset offset4 = new Offset(offset2.getX() - ((((float) Math.tan(d18)) * f28) * (f29 * ((float) Math.sin(d17)))), offset2.getY() - ((f28 * ((float) Math.tan(d18))) * (((float) Math.cos(d17)) * b16)));
            d(offset3.getX(), offset3.getY(), offset4.getX(), offset4.getY(), offset2.getX(), offset2.getY());
            if (i17 == num) {
                return;
            }
            i16 = i17 + 1;
            f18 = f27;
            i3 = 1;
            f16 = 3.1415927f;
            f17 = 180.0f;
        }
    }
}
