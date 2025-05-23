package com.tencent.aio.widget.interpolators;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/widget/interpolators/a;", "Landroid/view/animation/Interpolator;", "", "input", "getInterpolation", "", "a", "I", "mInterpolatorType", "<init>", "(I)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements Interpolator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mInterpolatorType;

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mInterpolatorType = i3;
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        float f16;
        float f17;
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Float) iPatchRedirector.redirect((short) 1, this, Float.valueOf(input))).floatValue();
        }
        if (this.mInterpolatorType != b.d()) {
            f16 = b.f69982c;
            f17 = b.f(input);
            float f19 = f16 * f17;
            if (f19 > 0) {
                f18 = b.f69983d;
                return f19 + f18;
            }
            return f19;
        }
        float f26 = 1.0f - input;
        return 1.0f - (f26 * f26);
    }
}
