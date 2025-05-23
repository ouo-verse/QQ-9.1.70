package cy0;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* compiled from: P */
    /* renamed from: cy0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C10144a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f392359d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f392360e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f392361f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f392362h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f392363i;

        C10144a(boolean z16, float f16, float f17, View view, d dVar) {
            this.f392359d = z16;
            this.f392360e = f16;
            this.f392361f = f17;
            this.f392362h = view;
            this.f392363i = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f392359d) {
                floatValue = new OvershootInterpolator().getInterpolation(floatValue);
            }
            float f16 = this.f392360e;
            float f17 = f16 + ((this.f392361f - f16) * floatValue);
            this.f392362h.setScaleX(f17);
            this.f392362h.setScaleY(f17);
            d dVar = this.f392363i;
            if (dVar != null) {
                dVar.a(this.f392362h, floatValue);
                if (floatValue >= 1.0f) {
                    this.f392363i.b(this.f392362h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f392364d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f392365e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f392366f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f392367h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f392368i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ d f392369m;

        b(float f16, float f17, View view, float f18, float f19, d dVar) {
            this.f392364d = f16;
            this.f392365e = f17;
            this.f392366f = view;
            this.f392367h = f18;
            this.f392368i = f19;
            this.f392369m = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f16 = this.f392364d;
            this.f392366f.setAlpha(f16 + ((this.f392365e - f16) * floatValue));
            float f17 = this.f392367h;
            float f18 = f17 + ((this.f392368i - f17) * floatValue);
            this.f392366f.setScaleX(f18);
            this.f392366f.setScaleY(f18);
            d dVar = this.f392369m;
            if (dVar != null) {
                dVar.a(this.f392366f, floatValue);
                if (floatValue >= 1.0f) {
                    this.f392369m.b(this.f392366f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f392370d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f392371e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f392372f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f392373h;

        c(float f16, float f17, View view, d dVar) {
            this.f392370d = f16;
            this.f392371e = f17;
            this.f392372f = view;
            this.f392373h = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f16 = this.f392370d;
            this.f392372f.setAlpha(f16 + ((this.f392371e - f16) * floatValue));
            d dVar = this.f392373h;
            if (dVar != null) {
                dVar.a(this.f392372f, floatValue);
                if (floatValue >= 1.0f) {
                    this.f392373h.b(this.f392372f);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface d {
        void a(View view, float f16);

        void b(View view);

        void onAnimationStart(View view);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static Interpolator f392374a = PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f);

        /* renamed from: b, reason: collision with root package name */
        public static Interpolator f392375b = PathInterpolatorCompat.create(0.4f, 0.0f, 1.0f, 1.0f);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public static Interpolator f392376a = PathInterpolatorCompat.create(0.1f, 0.8f, 0.2f, 1.0f);

        /* renamed from: b, reason: collision with root package name */
        public static Interpolator f392377b = PathInterpolatorCompat.create(0.1f, 0.8f, 0.2f, 1.0f);
    }

    public static void a(View view, float f16, float f17, long j3, Interpolator interpolator, d dVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j3);
        if (interpolator == null) {
            interpolator = new DecelerateInterpolator();
        }
        ofFloat.setInterpolator(interpolator);
        ofFloat.addUpdateListener(new c(f16, f17, view, dVar));
        ofFloat.start();
        if (dVar != null) {
            dVar.onAnimationStart(view);
        }
    }

    public static void b(View view, d dVar) {
        g(view, 1.0f, 0.5f, 1.0f, 0.0f, 225L, e.f392375b, dVar);
    }

    public static void c(View view) {
        a(view, 0.7f, 0.0f, 225L, e.f392375b, null);
    }

    public static void d(View view) {
        g(view, 0.5f, 1.0f, 0.0f, 1.0f, 225L, e.f392374a, null);
    }

    public static void e(View view) {
        a(view, 0.0f, 0.7f, 225L, e.f392374a, null);
    }

    public static void f(View view, float f16, float f17, long j3, d dVar, boolean z16) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j3);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new C10144a(z16, f16, f17, view, dVar));
        ofFloat.start();
        if (dVar != null) {
            dVar.onAnimationStart(view);
        }
    }

    public static void g(View view, float f16, float f17, float f18, float f19, long j3, Interpolator interpolator, d dVar) {
        Interpolator decelerateInterpolator;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j3);
        if (interpolator != null) {
            decelerateInterpolator = interpolator;
        } else {
            decelerateInterpolator = new DecelerateInterpolator();
        }
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new b(f18, f19, view, f16, f17, dVar));
        ofFloat.start();
        if (dVar != null) {
            dVar.onAnimationStart(view);
        }
    }
}
