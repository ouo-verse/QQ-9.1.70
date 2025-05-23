package com.tencent.ntcompose.material;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J6\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\nJ6\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002R&\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/ntcompose/material/ab;", "", "", "centerX", "centerY", "radius", "startAngle", "endAngle", "", "counterclockwise", "", "b", "Ljava/util/ArrayList;", "Lcom/tencent/ntcompose/material/g;", "Lkotlin/collections/ArrayList;", "e", HippyTKDListViewAdapter.X, "y", "g", "f", "a", "d", "controlPoint1X", "controlPoint1Y", "controlPoint2X", "controlPoint2Y", "pointX", "pointY", "c", "Ljava/util/ArrayList;", "drawCallbackTrace", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ArrayList<CanvasViewMethod> drawCallbackTrace = new ArrayList<>();

    public final void c(float controlPoint1X, float controlPoint1Y, float controlPoint2X, float controlPoint2Y, float pointX, float pointY) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("cp1x", Float.valueOf(controlPoint1X));
        eVar.v("cp1y", Float.valueOf(controlPoint1Y));
        eVar.v("cp2x", Float.valueOf(controlPoint2X));
        eVar.v("cp2y", Float.valueOf(controlPoint2Y));
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(pointX));
        eVar.v("y", Float.valueOf(pointY));
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_QBEZIER_CURVETO, eVar.toString(), null, 4, null));
    }

    public final void d() {
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_CLOSEPATH, "", null, 4, null));
    }

    public final ArrayList<CanvasViewMethod> e() {
        return this.drawCallbackTrace;
    }

    public final void f(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_LINETO, eVar.toString(), null, 4, null));
    }

    public final void g(float x16, float y16) {
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v(HippyTKDListViewAdapter.X, Float.valueOf(x16));
        eVar.v("y", Float.valueOf(y16));
        this.drawCallbackTrace.add(new CanvasViewMethod(CanvasView.ACTION_MOVETO, eVar.toString(), null, 4, null));
    }

    public final void a(float centerX, float centerY, float radius, float startAngle, float endAngle, boolean counterclockwise) {
        b(centerX, centerY, radius, (startAngle * 3.1415927f) / 180.0f, (endAngle * 3.1415927f) / 180.0f, counterclockwise);
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
}
