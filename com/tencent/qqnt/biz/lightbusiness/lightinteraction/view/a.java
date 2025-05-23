package com.tencent.qqnt.biz.lightbusiness.lightinteraction.view;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0006B'\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/a;", "Landroid/view/animation/Interpolator;", "", "input", "getInterpolation", "", "a", "I", "mLastI", "Landroid/graphics/PointF;", "b", "Landroid/graphics/PointF;", "mControlPoint1", "c", "mControlPoint2", "x1", "y1", "x2", "y2", "<init>", "(FFFF)V", "d", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements Interpolator {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mLastI;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mControlPoint1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF mControlPoint2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/a$a;", "", "", "t", "value0", "value1", "value2", "value3", "a", "", "ACCURACY", "I", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final double a(double t16, double value0, double value1, double value2, double value3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Double) iPatchRedirector.redirect((short) 2, this, Double.valueOf(t16), Double.valueOf(value0), Double.valueOf(value1), Double.valueOf(value2), Double.valueOf(value3))).doubleValue();
            }
            double d16 = 1 - t16;
            double d17 = t16 * t16;
            double d18 = d16 * d16;
            double d19 = 3;
            return (d18 * d16 * value0) + (d18 * d19 * t16 * value1) + (d19 * d16 * d17 * value2) + (d17 * t16 * value3);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29953);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        PointF pointF = new PointF();
        this.mControlPoint1 = pointF;
        PointF pointF2 = new PointF();
        this.mControlPoint2 = pointF2;
        pointF.x = f16;
        pointF.y = f17;
        pointF2.x = f18;
        pointF2.y = f19;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(input))).floatValue();
        }
        float f16 = input;
        double d16 = f16;
        if (d16 <= 0.001d) {
            this.mLastI = 0;
        }
        int i3 = this.mLastI;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            f16 = (i3 * 1.0f) / 4096;
            if (INSTANCE.a(f16, 0.0d, this.mControlPoint1.x, this.mControlPoint2.x, 1.0d) >= d16) {
                this.mLastI = i3;
                break;
            }
            i3++;
        }
        double a16 = INSTANCE.a(f16, 0.0d, this.mControlPoint1.y, this.mControlPoint2.y, 1.0d);
        if (a16 > 0.999d) {
            this.mLastI = 0;
            a16 = 1.0d;
        }
        return (float) a16;
    }
}
