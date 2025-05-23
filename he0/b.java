package he0;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    private static Interpolator a() {
        return new a(0.42f, 0.0f, 1.0f, 1.0f);
    }

    private static Interpolator b() {
        return new a(0.0f, 0.0f, 0.58f, 1.0f);
    }

    private static Interpolator c() {
        return new a(0.68f, 1.6f, 0.37f, 0.89f);
    }

    private static void d(Object obj, int i3, float f16) {
        if (i3 == R.anim.f154973ug) {
            k(obj, a());
            j(obj, f16 * 100.0f);
        } else if (i3 == R.anim.f154974uh) {
            k(obj, a());
            j(obj, f16 * 150.0f);
        } else if (i3 == R.anim.f154975ui) {
            k(obj, a());
            j(obj, f16 * 200.0f);
        }
    }

    private static void e(Object obj, int i3, float f16) {
        if (i3 == R.anim.f154976uj) {
            k(obj, b());
            j(obj, f16 * 100.0f);
        } else if (i3 == R.anim.f154977uk) {
            k(obj, b());
            j(obj, f16 * 150.0f);
        } else if (i3 == R.anim.f154978ul) {
            k(obj, b());
            j(obj, f16 * 200.0f);
        }
    }

    private static void f(Object obj, int i3, float f16) {
        if (i3 == R.anim.f154979um) {
            k(obj, c());
            j(obj, f16 * 100.0f);
        } else if (i3 == R.anim.f154980un) {
            k(obj, c());
            j(obj, f16 * 150.0f);
        } else if (i3 == R.anim.f154981uo) {
            k(obj, c());
            j(obj, f16 * 200.0f);
        }
    }

    private static void g(Object obj, int i3, float f16) {
        if (i3 == R.anim.f154982up) {
            k(obj, i());
            j(obj, f16 * 100.0f);
        } else if (i3 == R.anim.f154983uq) {
            k(obj, i());
            j(obj, f16 * 150.0f);
        } else if (i3 == R.anim.f154984ur) {
            k(obj, i());
            j(obj, f16 * 200.0f);
        }
    }

    private static void h(Object obj, int i3, float f16) {
        if (i3 == R.anim.f154985us) {
            k(obj, n());
            j(obj, f16 * 100.0f);
        } else if (i3 == R.anim.f154986ut) {
            k(obj, n());
            j(obj, f16 * 150.0f);
        } else if (i3 == R.anim.f154987uu) {
            k(obj, n());
            j(obj, f16 * 200.0f);
        }
    }

    private static Interpolator i() {
        return new a(0.25f, 0.25f, 0.75f, 0.75f);
    }

    private static void j(Object obj, long j3) {
        if (obj instanceof Animator) {
            ((Animator) obj).setDuration(j3);
        } else if (obj instanceof Animation) {
            ((Animation) obj).setDuration(j3);
        } else if (obj instanceof ViewPropertyAnimator) {
            ((ViewPropertyAnimator) obj).setDuration(j3);
        }
    }

    private static void k(Object obj, Interpolator interpolator) {
        if (obj instanceof Animator) {
            ((Animator) obj).setInterpolator(interpolator);
        } else if (obj instanceof Animation) {
            ((Animation) obj).setInterpolator(interpolator);
        } else if (obj instanceof ViewPropertyAnimator) {
            ((ViewPropertyAnimator) obj).setInterpolator(interpolator);
        }
    }

    public static void l(Object obj, int i3) {
        m(obj, i3, 1.0f);
    }

    public static void m(Object obj, int i3, float f16) {
        if (!(obj instanceof Animator) && !(obj instanceof Animation) && !(obj instanceof ViewPropertyAnimator)) {
            throw new RuntimeException("animationInstance wrong type!");
        }
        e(obj, i3, f16);
        d(obj, i3, f16);
        h(obj, i3, f16);
        g(obj, i3, f16);
        f(obj, i3, f16);
    }

    private static Interpolator n() {
        return new a(0.5f, 0.0f, 0.5f, 1.0f);
    }
}
