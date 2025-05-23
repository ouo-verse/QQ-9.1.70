package com.tencent.mobileqq.medalwall;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements ValueAnimator.AnimatorUpdateListener {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private long E;
    private Bitmap[] F;
    private float G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private final Rect M;
    private ValueAnimator N;
    private View P;
    protected Paint Q;
    protected float R;

    /* renamed from: d, reason: collision with root package name */
    private final int f245738d;

    /* renamed from: e, reason: collision with root package name */
    private final int f245739e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<C8021a> f245740f;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<C8021a> f245741h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<C8021a> f245742i;

    /* renamed from: m, reason: collision with root package name */
    private int f245743m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.medalwall.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8021a {
        static IPatchRedirector $redirector_;

        /* renamed from: q, reason: collision with root package name */
        public static int f245744q;

        /* renamed from: a, reason: collision with root package name */
        public int f245745a;

        /* renamed from: b, reason: collision with root package name */
        public long f245746b;

        /* renamed from: c, reason: collision with root package name */
        public float f245747c;

        /* renamed from: d, reason: collision with root package name */
        public float f245748d;

        /* renamed from: e, reason: collision with root package name */
        public float f245749e;

        /* renamed from: f, reason: collision with root package name */
        public float f245750f;

        /* renamed from: g, reason: collision with root package name */
        public int f245751g;

        /* renamed from: h, reason: collision with root package name */
        public int f245752h;

        /* renamed from: i, reason: collision with root package name */
        public float f245753i;

        /* renamed from: j, reason: collision with root package name */
        public float f245754j;

        /* renamed from: k, reason: collision with root package name */
        public float f245755k;

        /* renamed from: l, reason: collision with root package name */
        public float f245756l;

        /* renamed from: m, reason: collision with root package name */
        public float f245757m;

        /* renamed from: n, reason: collision with root package name */
        public float f245758n;

        /* renamed from: o, reason: collision with root package name */
        public float f245759o;

        /* renamed from: p, reason: collision with root package name */
        public float f245760p;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73031);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f245744q = 0;
            }
        }

        public C8021a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            int i3 = f245744q;
            f245744q = i3 + 1;
            this.f245745a = i3;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return String.format(Locale.getDefault(), "[id:%d, start: %d, x: %f, y: %f, vx: %f, vy: %f, size: %d", Integer.valueOf(this.f245745a), Long.valueOf(this.f245746b), Float.valueOf(this.f245747c), Float.valueOf(this.f245748d), Float.valueOf(this.f245749e), Float.valueOf(this.f245750f), Integer.valueOf(this.f245752h));
        }
    }

    public a(View view, int i3, int i16, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16), iArr);
            return;
        }
        this.G = 5.0E-4f;
        this.H = 60;
        this.I = 35;
        this.J = 160;
        this.K = 20;
        this.L = 150;
        this.M = new Rect();
        this.R = 1.0f;
        this.P = view;
        this.Q = new Paint();
        Resources resources = this.P.getResources();
        float f16 = resources.getDisplayMetrics().density;
        this.f245738d = i3;
        this.f245739e = i16;
        this.f245740f = new ArrayList<>(i16 / 2);
        if ((i3 & 1) == 1) {
            this.f245742i = new ArrayList<>(150);
        } else {
            this.f245742i = new ArrayList<>(1);
        }
        this.f245741h = new ArrayList<>(i16 / 3);
        this.f245743m = 0;
        this.F = new Bitmap[iArr.length];
        while (true) {
            Bitmap[] bitmapArr = this.F;
            if (i17 < bitmapArr.length) {
                try {
                    bitmapArr[i17] = BitmapFactory.decodeResource(resources, iArr[i17]);
                } catch (OutOfMemoryError e16) {
                    e16.printStackTrace();
                }
                i17++;
            } else {
                this.H = (int) (this.H * f16);
                this.I = (int) (this.I * f16);
                this.J = (int) (this.J * f16);
                this.K = (int) (this.K * f16);
                this.L = (int) (f16 * this.L);
                return;
            }
        }
    }

    public static double i(double d16, double d17) {
        return d16 + ((d17 - d16) * Math.random());
    }

    public boolean a(C8021a c8021a) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) c8021a)).booleanValue();
        }
        if (c8021a == null || (i3 = c8021a.f245752h) < 1 || c8021a.f245754j <= 0.05f) {
            return false;
        }
        float f16 = c8021a.f245747c;
        if ((i3 * 0.5f) + f16 < 0.0f) {
            return false;
        }
        float f17 = c8021a.f245748d;
        if ((i3 * 0.5f) + f17 < 0.0f || f16 - (i3 * 0.5f) > this.C || f17 - (i3 * 0.5f) > this.D) {
            return false;
        }
        return true;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ParticleSystem", 2, "destroy");
        }
        l();
        this.P = null;
    }

    public void c(Canvas canvas, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas, i3);
            return;
        }
        if (this.R <= 0.05f) {
            return;
        }
        if (i3 == 1 && (this.f245738d & 1) == 1 && this.f245742i.size() > 0) {
            d(canvas);
        }
        if (i3 == 2 && (this.f245738d & 2) == 2) {
            e(canvas);
        }
    }

    public void d(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        for (int size = this.f245742i.size() - 1; size >= 0; size--) {
            C8021a c8021a = this.f245742i.get(size);
            if (!a(c8021a)) {
                this.f245742i.remove(size);
                if (c8021a != null && this.f245743m < this.f245739e) {
                    this.f245740f.add(c8021a);
                    this.f245743m++;
                }
            }
        }
        Rect rect = this.M;
        for (int i3 = 0; i3 < this.f245742i.size(); i3++) {
            C8021a c8021a2 = this.f245742i.get(i3);
            if (c8021a2 != null) {
                this.Q.setAlpha(((int) (((this.R * c8021a2.f245754j) * 2.0f) * 255.0f)) % 256);
                float f16 = c8021a2.f245747c;
                int i16 = c8021a2.f245752h;
                int i17 = (int) (f16 - (i16 * 0.5f));
                rect.left = i17;
                int i18 = (int) (c8021a2.f245748d - (i16 * 0.5f));
                rect.top = i18;
                rect.bottom = i18 + i16;
                rect.right = i17 + i16;
                canvas.drawBitmap(this.F[c8021a2.f245751g], (Rect) null, rect, this.Q);
                float f17 = c8021a2.f245747c;
                float f18 = c8021a2.f245749e;
                c8021a2.f245747c = f17 + f18;
                float f19 = c8021a2.f245748d;
                float f26 = c8021a2.f245750f;
                c8021a2.f245748d = f19 + f26;
                c8021a2.f245749e = f18 * 0.98f;
                c8021a2.f245750f = (f26 * 0.98f) + this.G;
                c8021a2.f245754j *= c8021a2.f245755k;
            }
        }
    }

    public void e(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        for (int size = this.f245741h.size() - 1; size >= 0; size--) {
            C8021a c8021a = this.f245741h.get(size);
            if (!a(c8021a)) {
                this.f245741h.remove(size);
                if (c8021a != null) {
                    this.f245740f.add(c8021a);
                }
            }
        }
        if (Math.abs(SystemClock.elapsedRealtime() - this.E) > 64) {
            this.E = SystemClock.elapsedRealtime();
            f();
        }
        Rect rect = this.M;
        for (int i3 = 0; i3 < this.f245741h.size(); i3++) {
            C8021a c8021a2 = this.f245741h.get(i3);
            if (c8021a2 != null) {
                float abs = (float) Math.abs(Math.cos(c8021a2.f245756l) * c8021a2.f245754j);
                if (abs >= 0.01f) {
                    this.Q.setAlpha((int) (this.R * abs * 255.0f));
                    double cos = Math.cos(c8021a2.f245759o) * c8021a2.f245758n;
                    float f16 = c8021a2.f245747c;
                    int i16 = c8021a2.f245752h;
                    int i17 = (int) ((f16 - (i16 * 0.5f)) + cos);
                    rect.left = i17;
                    int i18 = (int) (c8021a2.f245748d - (i16 * 0.5f));
                    rect.top = i18;
                    rect.bottom = i18 + i16;
                    rect.right = i17 + i16;
                    canvas.drawBitmap(this.F[c8021a2.f245751g], (Rect) null, rect, this.Q);
                }
                c8021a2.f245747c += c8021a2.f245749e;
                c8021a2.f245748d += c8021a2.f245750f;
                c8021a2.f245754j *= c8021a2.f245755k;
                c8021a2.f245756l += c8021a2.f245757m;
                c8021a2.f245759o += c8021a2.f245760p;
            }
        }
    }

    public void f() {
        C8021a c8021a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        double i3 = i(this.J, -r0);
        double i16 = i(this.J, -r2);
        int random = (int) (Math.random() * this.F.length);
        float f16 = this.C * 0.5f;
        float f17 = this.D * 0.4f;
        if (this.f245743m < this.f245739e) {
            c8021a = new C8021a();
            this.f245743m++;
        } else if (this.f245740f.size() > 0) {
            c8021a = this.f245740f.remove(r7.size() - 1);
        } else {
            c8021a = null;
        }
        if (c8021a != null) {
            c8021a.f245747c = (float) (i3 + f16);
            c8021a.f245748d = (float) (i16 + f17);
            c8021a.f245749e = 0.0f;
            c8021a.f245750f = (float) i(-1.0d, -2.0d);
            c8021a.f245751g = random;
            c8021a.f245752h = (int) i(this.I, this.H);
            c8021a.f245753i = (float) i(0.9950000047683716d, 0.9980000257492065d);
            c8021a.f245754j = (float) i(1.0d, 1.0d);
            c8021a.f245755k = (float) i(0.9900000095367432d, 0.9800000190734863d);
            c8021a.f245756l = (float) i(0.0d, 3.141592653589793d);
            c8021a.f245757m = (float) i(0.01d, 0.001d);
            c8021a.f245758n = (float) i(20.0d, 5.0d);
            c8021a.f245759o = (float) i(0.0d, 3.141592653589793d);
            c8021a.f245760p = (float) i(0.01d, 0.1d);
            c8021a.f245746b = SystemClock.elapsedRealtime();
            this.f245741h.add(c8021a);
        }
    }

    public void g(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.C = i3;
        this.D = i16;
        int min = (int) (Math.min(i3, i16) * 0.4f);
        this.J = min;
        this.K = (int) (min * 0.6f);
        this.L = (int) (min * 0.8f);
        this.f245743m = 0;
        this.f245740f.clear();
        this.f245742i.clear();
        this.f245741h.clear();
        if ((this.f245738d & 1) == 1) {
            float f16 = this.C * 0.5f;
            float f17 = this.D * 0.4f;
            for (int i17 = 0; i17 < 150; i17++) {
                C8021a c8021a = new C8021a();
                h(f16, f17, c8021a);
                this.f245742i.add(c8021a);
            }
        }
        if ((this.f245738d & 2) == 2) {
            for (int i18 = 0; i18 < 40; i18++) {
                f();
            }
        }
        k();
    }

    public void h(float f16, float f17, C8021a c8021a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), c8021a);
            return;
        }
        if (c8021a != null) {
            double i3 = i(this.K, this.L);
            double i16 = i(0.0d, 6.283185307179586d);
            double cos = Math.cos(i16);
            double sin = Math.sin(i16);
            int random = (int) (Math.random() * this.F.length);
            c8021a.f245747c = (float) ((cos * i3) + f16);
            c8021a.f245748d = (float) ((i3 * sin) + f17);
            c8021a.f245749e = (float) (cos * i(5.0d, 10.0d));
            c8021a.f245750f = (float) (sin * i(5.0d, 10.0d));
            c8021a.f245751g = random;
            c8021a.f245752h = (int) i(this.I, this.H);
            c8021a.f245753i = (float) i(0.9800000190734863d, 0.9900000095367432d);
            c8021a.f245754j = (float) i(0.5d, 1.0d);
            c8021a.f245755k = (float) i(0.9800000190734863d, 0.9900000095367432d);
        }
    }

    public void j(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.R = f16;
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.N == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
            this.N = duration;
            duration.setRepeatCount(-1);
        }
        this.N.addUpdateListener(this);
        this.N.start();
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.N.removeUpdateListener(this);
            this.N.removeAllUpdateListeners();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) valueAnimator);
            return;
        }
        View view = this.P;
        if (view != null) {
            view.postInvalidate();
        }
    }
}
