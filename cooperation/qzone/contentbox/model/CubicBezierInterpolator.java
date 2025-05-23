package cooperation.qzone.contentbox.model;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class CubicBezierInterpolator implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    protected PointF f390857a;

    /* renamed from: b, reason: collision with root package name */
    protected PointF f390858b;

    /* renamed from: c, reason: collision with root package name */
    protected PointF f390859c;
    protected PointF end;
    protected PointF start;

    public CubicBezierInterpolator(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.f390857a = new PointF();
        this.f390858b = new PointF();
        this.f390859c = new PointF();
        float f16 = pointF.x;
        if (f16 >= 0.0f && f16 <= 1.0f) {
            float f17 = pointF2.x;
            if (f17 >= 0.0f && f17 <= 1.0f) {
                this.start = pointF;
                this.end = pointF2;
                return;
            }
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    private float getBezierCoordinateX(float f16) {
        PointF pointF = this.f390859c;
        PointF pointF2 = this.start;
        float f17 = pointF2.x * 3.0f;
        pointF.x = f17;
        PointF pointF3 = this.f390858b;
        float f18 = ((this.end.x - pointF2.x) * 3.0f) - f17;
        pointF3.x = f18;
        PointF pointF4 = this.f390857a;
        float f19 = (1.0f - pointF.x) - f18;
        pointF4.x = f19;
        return f16 * (pointF.x + ((pointF3.x + (f19 * f16)) * f16));
    }

    private float getXDerivate(float f16) {
        return this.f390859c.x + (f16 * ((this.f390858b.x * 2.0f) + (this.f390857a.x * 3.0f * f16)));
    }

    protected float getBezierCoordinateY(float f16) {
        PointF pointF = this.f390859c;
        PointF pointF2 = this.start;
        float f17 = pointF2.y * 3.0f;
        pointF.y = f17;
        PointF pointF3 = this.f390858b;
        float f18 = ((this.end.y - pointF2.y) * 3.0f) - f17;
        pointF3.y = f18;
        PointF pointF4 = this.f390857a;
        float f19 = (1.0f - pointF.y) - f18;
        pointF4.y = f19;
        return f16 * (pointF.y + ((pointF3.y + (f19 * f16)) * f16));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return getBezierCoordinateY(getXForTime(f16));
    }

    protected float getXForTime(float f16) {
        float f17 = f16;
        for (int i3 = 1; i3 < 14; i3++) {
            float bezierCoordinateX = getBezierCoordinateX(f17) - f16;
            if (Math.abs(bezierCoordinateX) < 0.001d) {
                break;
            }
            f17 -= bezierCoordinateX / getXDerivate(f17);
        }
        return f17;
    }

    public CubicBezierInterpolator(float f16, float f17, float f18, float f19) {
        this(new PointF(f16, f17), new PointF(f18, f19));
    }

    public CubicBezierInterpolator(double d16, double d17, double d18, double d19) {
        this((float) d16, (float) d17, (float) d18, (float) d19);
    }
}
