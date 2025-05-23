package he0;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f404782a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f404783b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f404784c;

    /* renamed from: d, reason: collision with root package name */
    private final PointF f404785d;

    /* renamed from: e, reason: collision with root package name */
    private final PointF f404786e;

    public a(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.f404784c = new PointF();
        this.f404785d = new PointF();
        this.f404786e = new PointF();
        float f16 = pointF.x;
        if (f16 >= 0.0f && f16 <= 1.0f) {
            float f17 = pointF2.x;
            if (f17 >= 0.0f && f17 <= 1.0f) {
                this.f404782a = pointF;
                this.f404783b = pointF2;
                return;
            }
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    private float a(float f16) {
        PointF pointF = this.f404786e;
        PointF pointF2 = this.f404782a;
        float f17 = pointF2.x * 3.0f;
        pointF.x = f17;
        PointF pointF3 = this.f404785d;
        float f18 = ((this.f404783b.x - pointF2.x) * 3.0f) - f17;
        pointF3.x = f18;
        PointF pointF4 = this.f404784c;
        float f19 = (1.0f - pointF.x) - f18;
        pointF4.x = f19;
        return f16 * (pointF.x + ((pointF3.x + (f19 * f16)) * f16));
    }

    private float c(float f16) {
        return this.f404786e.x + (f16 * ((this.f404785d.x * 2.0f) + (this.f404784c.x * 3.0f * f16)));
    }

    protected float b(float f16) {
        PointF pointF = this.f404786e;
        PointF pointF2 = this.f404782a;
        float f17 = pointF2.y * 3.0f;
        pointF.y = f17;
        PointF pointF3 = this.f404785d;
        float f18 = ((this.f404783b.y - pointF2.y) * 3.0f) - f17;
        pointF3.y = f18;
        PointF pointF4 = this.f404784c;
        float f19 = (1.0f - pointF.y) - f18;
        pointF4.y = f19;
        return f16 * (pointF.y + ((pointF3.y + (f19 * f16)) * f16));
    }

    protected float d(float f16) {
        float f17 = f16;
        for (int i3 = 1; i3 < 14; i3++) {
            float a16 = a(f17) - f16;
            if (Math.abs(a16) < 0.001d) {
                break;
            }
            f17 -= a16 / c(f17);
        }
        return f17;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return b(d(f16));
    }

    public a(float f16, float f17, float f18, float f19) {
        this(new PointF(f16, f17), new PointF(f18, f19));
    }
}
