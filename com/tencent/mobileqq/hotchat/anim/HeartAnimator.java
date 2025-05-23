package com.tencent.mobileqq.hotchat.anim;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HeartAnimator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Random f236862a;

    /* renamed from: b, reason: collision with root package name */
    public final a f236863b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f236864c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f236865d;

    /* renamed from: e, reason: collision with root package name */
    public Interpolator f236866e;

    /* renamed from: f, reason: collision with root package name */
    public Interpolator f236867f;

    /* renamed from: g, reason: collision with root package name */
    private c f236868g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends Animation {
        static IPatchRedirector $redirector_;
        public c C;
        public Interpolator D;

        /* renamed from: d, reason: collision with root package name */
        public PathMeasure f236891d;

        /* renamed from: e, reason: collision with root package name */
        public View f236892e;

        /* renamed from: f, reason: collision with root package name */
        public float f236893f;

        /* renamed from: h, reason: collision with root package name */
        public float f236894h;

        /* renamed from: i, reason: collision with root package name */
        public a f236895i;

        /* renamed from: m, reason: collision with root package name */
        public int f236896m;

        @TargetApi(11)
        public b(Path path, float f16, View view, View view2, a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, path, Float.valueOf(f16), view, view2, aVar);
                return;
            }
            this.f236896m = 0;
            PathMeasure pathMeasure = new PathMeasure(path, false);
            this.f236891d = pathMeasure;
            this.f236893f = pathMeasure.getLength();
            this.f236892e = view2;
            this.f236894h = f16;
            this.f236895i = aVar;
            view.setLayerType(2, null);
        }

        private static float a(int i3, float f16) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return (float) Math.pow(f16, 2.0d);
                }
                return (f16 * 0.5f) + 0.5f;
            }
            if (f16 < 0.8d) {
                return 0.0f;
            }
            return (f16 * 5.0f) - 4.0f;
        }

        @Override // android.view.animation.Animation
        @TargetApi(11)
        protected void applyTransformation(float f16, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), transformation);
                return;
            }
            this.f236891d.getMatrix(this.f236893f * f16, transformation.getMatrix(), 1);
            this.f236892e.setRotation(this.f236894h * f16 * a.f236874q);
            if (this.f236895i.f236890p) {
                float interpolation = this.D.getInterpolation(f16);
                this.f236892e.setScaleX(this.f236895i.f236889o * interpolation);
                this.f236892e.setScaleY(interpolation * this.f236895i.f236889o);
            }
            transformation.setAlpha(1.0f - a(this.f236896m, f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(Animation animation);

        void b(Animation animation);
    }

    public HeartAnimator(HeartLayout heartLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) heartLayout);
            return;
        }
        this.f236864c = new AtomicInteger(0);
        this.f236863b = new a(heartLayout);
        this.f236862a = new Random(System.currentTimeMillis());
        this.f236865d = new Handler(Looper.getMainLooper());
        this.f236866e = new OvershootInterpolator(1.0f);
        this.f236867f = new LinearInterpolator();
    }

    public Path b(int i3, int i16, AtomicInteger atomicInteger, View view) {
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 1;
        int i26 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Path) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), atomicInteger, view);
        }
        Random random = this.f236862a;
        Path path = new Path();
        a aVar = this.f236863b;
        if (!aVar.f236886l) {
            if (i3 >= 0 && i3 <= view.getWidth()) {
                a aVar2 = this.f236863b;
                aVar2.f236876b = i3 - (aVar2.f236883i / 2);
            } else {
                this.f236863b.f236876b = (view.getWidth() - this.f236863b.f236883i) / 2;
            }
            if (i16 >= 0 && i16 <= view.getHeight()) {
                this.f236863b.f236877c = (view.getHeight() - i16) + (this.f236863b.f236883i / 2);
            } else {
                a aVar3 = this.f236863b;
                aVar3.f236877c = aVar3.f236884j;
            }
            if (!this.f236862a.nextBoolean()) {
                i19 = -1;
            }
            int nextInt = random.nextInt(this.f236863b.f236878d);
            a aVar4 = this.f236863b;
            int i27 = (nextInt + aVar4.f236879e) * i19;
            int nextInt2 = i19 * (random.nextInt(aVar4.f236878d) + this.f236863b.f236879e);
            int height = view.getHeight() - this.f236863b.f236877c;
            float intValue = atomicInteger.intValue() * 4;
            a aVar5 = this.f236863b;
            int nextInt3 = ((int) (intValue * aVar5.f236875a)) + aVar5.f236882h + random.nextInt(aVar5.f236881g);
            int i28 = nextInt3 / this.f236863b.f236880f;
            int i29 = height - nextInt3;
            if (i29 < 0) {
                i18 = 0;
            } else {
                i18 = i29;
            }
            int i36 = height - (nextInt3 / 2);
            if (i36 >= 0) {
                i26 = i36;
            }
            path.moveTo(r3.f236876b, height);
            int i37 = this.f236863b.f236876b;
            float f16 = i37 + i27;
            float f17 = i26;
            int i38 = i18;
            path.cubicTo(i37, height - i28, i37 + i27, i26 + i28, f16, f17);
            path.moveTo(this.f236863b.f236876b + i27, f17);
            int i39 = i26 - i28;
            if (i39 >= 0) {
                int i46 = this.f236863b.f236876b;
                path.cubicTo(i27 + i46, i39, i46 + nextInt2, i38 + i28, i46 + nextInt2, i38);
            }
            return path;
        }
        int i47 = aVar.f236888n;
        int i48 = aVar.f236887m - (aVar.f236883i / 2);
        if (!this.f236862a.nextBoolean()) {
            i19 = -1;
        }
        int nextInt4 = random.nextInt(this.f236863b.f236878d);
        a aVar6 = this.f236863b;
        int i49 = nextInt4 + aVar6.f236879e;
        int nextInt5 = random.nextInt(aVar6.f236878d) + this.f236863b.f236879e;
        int abs = Math.abs(i47 - i16) / (this.f236862a.nextInt(3) + 2);
        if (i47 > i16) {
            i17 = i47 - abs;
        } else {
            i17 = i47 + abs;
        }
        a aVar7 = this.f236863b;
        path.moveTo(i3 - (aVar7.f236883i / 2), i16 - (aVar7.f236884j / 2));
        float f18 = i17;
        path.cubicTo(i3 + (i49 * i19), f18, i3 - (i19 * nextInt5), f18, i48, i47);
        return path;
    }

    public a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f236863b;
    }

    public float d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return (this.f236862a.nextInt(40) - 20) * 1.0f;
    }

    public void e(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f236868g = cVar;
        }
    }

    public void f(View view, float f16, float f17, int i3, int i16, ViewGroup viewGroup, long j3, int i17, Runnable runnable) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16), viewGroup, Long.valueOf(j3), Integer.valueOf(i17), runnable);
            return;
        }
        view.setTag(R.id.gqj, Boolean.TRUE);
        viewGroup.addView(view, new ViewGroup.LayoutParams(i3, i16));
        b bVar = new b(b((int) f16, (int) f17, this.f236864c, viewGroup), d(), viewGroup, view, this.f236863b);
        if (j3 > 0) {
            j16 = j3;
        } else {
            j16 = this.f236863b.f236885k;
        }
        bVar.setDuration(j16);
        bVar.setInterpolator(this.f236867f);
        bVar.f236896m = i17;
        bVar.C = this.f236868g;
        bVar.D = this.f236866e;
        bVar.setAnimationListener(new Animation.AnimationListener(viewGroup, view, runnable) { // from class: com.tencent.mobileqq.hotchat.anim.HeartAnimator.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ViewGroup f236869d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f236870e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Runnable f236871f;

            {
                this.f236869d = viewGroup;
                this.f236870e = view;
                this.f236871f = runnable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, HeartAnimator.this, viewGroup, view, runnable);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animation);
                    return;
                }
                HeartAnimator.this.f236865d.post(new Runnable() { // from class: com.tencent.mobileqq.hotchat.anim.HeartAnimator.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f236869d.removeView(anonymousClass1.f236870e);
                        Runnable runnable2 = AnonymousClass1.this.f236871f;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                });
                HeartAnimator.this.f236864c.decrementAndGet();
                if (HeartAnimator.this.f236868g != null) {
                    HeartAnimator.this.f236868g.b(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animation);
                    return;
                }
                HeartAnimator.this.f236864c.incrementAndGet();
                if (HeartAnimator.this.f236868g != null) {
                    HeartAnimator.this.f236868g.a(animation);
                }
            }
        });
        view.startAnimation(bVar);
    }

    public void g(View view, float f16, float f17, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Float.valueOf(f16), Float.valueOf(f17), viewGroup);
        } else {
            h(view, f16, f17, viewGroup, -1L, 0, null);
        }
    }

    public void h(View view, float f16, float f17, ViewGroup viewGroup, long j3, int i3, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Float.valueOf(f16), Float.valueOf(f17), viewGroup, Long.valueOf(j3), Integer.valueOf(i3), runnable);
        } else {
            a aVar = this.f236863b;
            f(view, f16, f17, aVar.f236883i, aVar.f236884j, viewGroup, j3, i3, runnable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: q, reason: collision with root package name */
        public static float f236874q;

        /* renamed from: a, reason: collision with root package name */
        public float f236875a;

        /* renamed from: b, reason: collision with root package name */
        public int f236876b;

        /* renamed from: c, reason: collision with root package name */
        public int f236877c;

        /* renamed from: d, reason: collision with root package name */
        public int f236878d;

        /* renamed from: e, reason: collision with root package name */
        public int f236879e;

        /* renamed from: f, reason: collision with root package name */
        public int f236880f;

        /* renamed from: g, reason: collision with root package name */
        public int f236881g;

        /* renamed from: h, reason: collision with root package name */
        public int f236882h;

        /* renamed from: i, reason: collision with root package name */
        public int f236883i;

        /* renamed from: j, reason: collision with root package name */
        public int f236884j;

        /* renamed from: k, reason: collision with root package name */
        public int f236885k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f236886l;

        /* renamed from: m, reason: collision with root package name */
        public int f236887m;

        /* renamed from: n, reason: collision with root package name */
        public int f236888n;

        /* renamed from: o, reason: collision with root package name */
        public float f236889o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f236890p;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72520);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f236874q = 1.0f;
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f236876b = 250;
            this.f236877c = 0;
            this.f236878d = 20;
            this.f236879e = 10;
            this.f236880f = 8;
            this.f236881g = 150;
            this.f236882h = 300;
            this.f236883i = 32;
            this.f236884j = 27;
            this.f236885k = 3000;
            this.f236886l = false;
            this.f236889o = 1.0f;
            this.f236890p = true;
        }

        public a(HeartLayout heartLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) heartLayout);
                return;
            }
            this.f236876b = 250;
            this.f236877c = 0;
            this.f236878d = 20;
            this.f236879e = 10;
            this.f236880f = 8;
            this.f236881g = 150;
            this.f236882h = 300;
            this.f236883i = 32;
            this.f236884j = 27;
            this.f236885k = 3000;
            this.f236886l = false;
            this.f236889o = 1.0f;
            this.f236890p = true;
            this.f236875a = heartLayout.getContext().getResources().getDisplayMetrics().density;
            float width = heartLayout.getWidth();
            float f16 = this.f236875a;
            this.f236876b = (int) ((width - (f16 * 32.0f)) / 2.0f);
            this.f236877c = (int) (f16 * 27.0f);
            this.f236883i = (int) (32.0f * f16);
            this.f236884j = (int) (27.0f * f16);
            this.f236878d = (int) (20.0f * f16);
            this.f236879e = (int) (10.0f * f16);
            this.f236881g = (int) (150.0f * f16);
            this.f236882h = (int) (f16 * 300.0f);
        }
    }
}
