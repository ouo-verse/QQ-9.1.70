package fw0;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lfw0/e;", "", "Landroid/graphics/PointF;", "end", "start", "", "width", "", "e", "t", "p0", "p1", "p2", "a", "b", "percent", "c", "d", "", "Z", "getCurveByLEFT", "()Z", "f", "(Z)V", "curveByLEFT", "Landroid/graphics/PointF;", "getControlPoint", "()Landroid/graphics/PointF;", "setControlPoint", "(Landroid/graphics/PointF;)V", "controlPoint", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean curveByLEFT = true;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF controlPoint = new PointF();

    private final float a(float t16, PointF p06, PointF p16, PointF p26) {
        float f16 = 1 - t16;
        return (f16 * f16 * p06.x) + (2 * t16 * f16 * p16.x) + (t16 * t16 * p26.x);
    }

    private final float b(float t16, PointF p06, PointF p16, PointF p26) {
        float f16 = 1 - t16;
        return (f16 * f16 * p06.y) + (2 * t16 * f16 * p16.y) + (t16 * t16 * p26.y);
    }

    private final void e(PointF end, PointF start, float width) {
        if (this.curveByLEFT) {
            PointF pointF = this.controlPoint;
            pointF.x = end.x - width;
            float f16 = end.y;
            float f17 = start.y;
            pointF.y = ((f16 - f17) * 0.5f) + f17;
            return;
        }
        PointF pointF2 = this.controlPoint;
        pointF2.x = start.x + width;
        float f18 = end.y;
        float f19 = start.y;
        pointF2.y = ((f18 - f19) * 0.5f) + f19;
    }

    public final float c(@NotNull PointF start, @NotNull PointF end, float width, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        e(end, start, width);
        return a(percent, start, this.controlPoint, end);
    }

    public final float d(@NotNull PointF start, @NotNull PointF end, float width, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        e(end, start, width);
        return b(percent, start, this.controlPoint, end);
    }

    public final void f(boolean z16) {
        this.curveByLEFT = z16;
    }
}
