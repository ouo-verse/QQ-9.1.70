package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import g1.a;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: t0, reason: collision with root package name */
    private static final boolean f33803t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    @NonNull
    private static final Paint f33804u0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private Typeface D;
    private g1.a E;
    private g1.a F;

    @Nullable
    private CharSequence G;

    @Nullable
    private CharSequence H;
    private boolean I;
    private boolean K;

    @Nullable
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;

    @NonNull
    private final TextPaint V;

    @NonNull
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* renamed from: a, reason: collision with root package name */
    private final View f33805a;

    /* renamed from: a0, reason: collision with root package name */
    private float f33806a0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f33807b;

    /* renamed from: b0, reason: collision with root package name */
    private float f33808b0;

    /* renamed from: c, reason: collision with root package name */
    private float f33809c;

    /* renamed from: c0, reason: collision with root package name */
    private ColorStateList f33810c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33811d;

    /* renamed from: d0, reason: collision with root package name */
    private float f33812d0;

    /* renamed from: e, reason: collision with root package name */
    private float f33813e;

    /* renamed from: e0, reason: collision with root package name */
    private float f33814e0;

    /* renamed from: f, reason: collision with root package name */
    private float f33815f;

    /* renamed from: f0, reason: collision with root package name */
    private float f33816f0;

    /* renamed from: g, reason: collision with root package name */
    private int f33817g;

    /* renamed from: g0, reason: collision with root package name */
    private ColorStateList f33818g0;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final Rect f33819h;

    /* renamed from: h0, reason: collision with root package name */
    private float f33820h0;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final Rect f33821i;

    /* renamed from: i0, reason: collision with root package name */
    private float f33822i0;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final RectF f33823j;

    /* renamed from: j0, reason: collision with root package name */
    private float f33824j0;

    /* renamed from: k0, reason: collision with root package name */
    private StaticLayout f33826k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f33828l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f33830m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f33832n0;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f33833o;

    /* renamed from: o0, reason: collision with root package name */
    private CharSequence f33834o0;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f33835p;

    /* renamed from: q, reason: collision with root package name */
    private int f33837q;

    /* renamed from: r, reason: collision with root package name */
    private float f33839r;

    /* renamed from: s, reason: collision with root package name */
    private float f33841s;

    /* renamed from: t, reason: collision with root package name */
    private float f33843t;

    /* renamed from: u, reason: collision with root package name */
    private float f33844u;

    /* renamed from: v, reason: collision with root package name */
    private float f33845v;

    /* renamed from: w, reason: collision with root package name */
    private float f33846w;

    /* renamed from: x, reason: collision with root package name */
    private Typeface f33847x;

    /* renamed from: y, reason: collision with root package name */
    private Typeface f33848y;

    /* renamed from: z, reason: collision with root package name */
    private Typeface f33849z;

    /* renamed from: k, reason: collision with root package name */
    private int f33825k = 16;

    /* renamed from: l, reason: collision with root package name */
    private int f33827l = 16;

    /* renamed from: m, reason: collision with root package name */
    private float f33829m = 15.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f33831n = 15.0f;
    private boolean J = true;

    /* renamed from: p0, reason: collision with root package name */
    private int f33836p0 = 1;

    /* renamed from: q0, reason: collision with root package name */
    private float f33838q0 = 0.0f;

    /* renamed from: r0, reason: collision with root package name */
    private float f33840r0 = 1.0f;

    /* renamed from: s0, reason: collision with root package name */
    private int f33842s0 = StaticLayoutBuilderCompat.f33771n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC10346a {
        a() {
        }

        @Override // g1.a.InterfaceC10346a
        public void a(Typeface typeface) {
            b.this.Y(typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.material.internal.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0235b implements a.InterfaceC10346a {
        C0235b() {
        }

        @Override // g1.a.InterfaceC10346a
        public void a(Typeface typeface) {
            b.this.j0(typeface);
        }
    }

    public b(View view) {
        this.f33805a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f33821i = new Rect();
        this.f33819h = new Rect();
        this.f33823j = new RectF();
        this.f33815f = e();
        M(view.getContext().getResources().getConfiguration());
    }

    private Layout.Alignment C() {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f33825k, this.I ? 1 : 0) & 7;
        if (absoluteGravity != 1) {
            if (absoluteGravity != 5) {
                if (this.I) {
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            }
            if (this.I) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private void E(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f33831n);
        textPaint.setTypeface(this.f33847x);
        textPaint.setLetterSpacing(this.f33820h0);
    }

    private void F(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f33829m);
        textPaint.setTypeface(this.A);
        textPaint.setLetterSpacing(this.f33822i0);
    }

    private void G(float f16) {
        Rect rect;
        if (this.f33811d) {
            RectF rectF = this.f33823j;
            if (f16 < this.f33815f) {
                rect = this.f33819h;
            } else {
                rect = this.f33821i;
            }
            rectF.set(rect);
            return;
        }
        this.f33823j.left = L(this.f33819h.left, this.f33821i.left, f16, this.X);
        this.f33823j.top = L(this.f33839r, this.f33841s, f16, this.X);
        this.f33823j.right = L(this.f33819h.right, this.f33821i.right, f16, this.X);
        this.f33823j.bottom = L(this.f33819h.bottom, this.f33821i.bottom, f16, this.X);
    }

    private static boolean H(float f16, float f17) {
        if (Math.abs(f16 - f17) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    private boolean I() {
        if (ViewCompat.getLayoutDirection(this.f33805a) == 1) {
            return true;
        }
        return false;
    }

    private boolean K(@NonNull CharSequence charSequence, boolean z16) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (z16) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private static float L(float f16, float f17, float f18, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f18 = timeInterpolator.getInterpolation(f18);
        }
        return x0.a.a(f16, f17, f18);
    }

    private float N(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean R(@NonNull Rect rect, int i3, int i16, int i17, int i18) {
        if (rect.left == i3 && rect.top == i16 && rect.right == i17 && rect.bottom == i18) {
            return true;
        }
        return false;
    }

    private void V(float f16) {
        this.f33830m0 = f16;
        ViewCompat.postInvalidateOnAnimation(this.f33805a);
    }

    private boolean Z(Typeface typeface) {
        g1.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f33849z != typeface) {
            this.f33849z = typeface;
            Typeface b16 = g1.i.b(this.f33805a.getContext().getResources().getConfiguration(), typeface);
            this.f33848y = b16;
            if (b16 == null) {
                b16 = this.f33849z;
            }
            this.f33847x = b16;
            return true;
        }
        return false;
    }

    @ColorInt
    private static int a(@ColorInt int i3, @ColorInt int i16, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        float f17 = 1.0f - f16;
        return Color.argb(Math.round((Color.alpha(i3) * f17) + (Color.alpha(i16) * f16)), Math.round((Color.red(i3) * f17) + (Color.red(i16) * f16)), Math.round((Color.green(i3) * f17) + (Color.green(i16) * f16)), Math.round((Color.blue(i3) * f17) + (Color.blue(i16) * f16)));
    }

    private void b(boolean z16) {
        float f16;
        int i3;
        StaticLayout staticLayout;
        i(1.0f, z16);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f33826k0) != null) {
            this.f33834o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f33834o0;
        float f17 = 0.0f;
        if (charSequence2 != null) {
            this.f33828l0 = N(this.V, charSequence2);
        } else {
            this.f33828l0 = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f33827l, this.I ? 1 : 0);
        int i16 = absoluteGravity & 112;
        if (i16 != 48) {
            if (i16 != 80) {
                this.f33841s = this.f33821i.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
            } else {
                this.f33841s = this.f33821i.bottom + this.V.ascent();
            }
        } else {
            this.f33841s = this.f33821i.top;
        }
        int i17 = absoluteGravity & 8388615;
        if (i17 != 1) {
            if (i17 != 5) {
                this.f33844u = this.f33821i.left;
            } else {
                this.f33844u = this.f33821i.right - this.f33828l0;
            }
        } else {
            this.f33844u = this.f33821i.centerX() - (this.f33828l0 / 2.0f);
        }
        i(0.0f, z16);
        StaticLayout staticLayout2 = this.f33826k0;
        if (staticLayout2 != null) {
            f16 = staticLayout2.getHeight();
        } else {
            f16 = 0.0f;
        }
        StaticLayout staticLayout3 = this.f33826k0;
        if (staticLayout3 != null && this.f33836p0 > 1) {
            f17 = staticLayout3.getWidth();
        } else {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                f17 = N(this.V, charSequence3);
            }
        }
        StaticLayout staticLayout4 = this.f33826k0;
        if (staticLayout4 != null) {
            i3 = staticLayout4.getLineCount();
        } else {
            i3 = 0;
        }
        this.f33837q = i3;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f33825k, this.I ? 1 : 0);
        int i18 = absoluteGravity2 & 112;
        if (i18 != 48) {
            if (i18 != 80) {
                this.f33839r = this.f33819h.centerY() - (f16 / 2.0f);
            } else {
                this.f33839r = (this.f33819h.bottom - f16) + this.V.descent();
            }
        } else {
            this.f33839r = this.f33819h.top;
        }
        int i19 = absoluteGravity2 & 8388615;
        if (i19 != 1) {
            if (i19 != 5) {
                this.f33843t = this.f33819h.left;
            } else {
                this.f33843t = this.f33819h.right - f17;
            }
        } else {
            this.f33843t = this.f33819h.centerX() - (f17 / 2.0f);
        }
        j();
        p0(this.f33809c);
    }

    private void c() {
        g(this.f33809c);
    }

    private float d(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        float f17 = this.f33815f;
        if (f16 <= f17) {
            return x0.a.b(1.0f, 0.0f, this.f33813e, f17, f16);
        }
        return x0.a.b(0.0f, 1.0f, f17, 1.0f, f16);
    }

    private float e() {
        float f16 = this.f33813e;
        return f16 + ((1.0f - f16) * 0.5f);
    }

    private boolean f(@NonNull CharSequence charSequence) {
        boolean I = I();
        if (this.J) {
            return K(charSequence, I);
        }
        return I;
    }

    private void f0(float f16) {
        this.f33832n0 = f16;
        ViewCompat.postInvalidateOnAnimation(this.f33805a);
    }

    private void g(float f16) {
        float f17;
        G(f16);
        if (this.f33811d) {
            if (f16 < this.f33815f) {
                this.f33845v = this.f33843t;
                this.f33846w = this.f33839r;
                p0(0.0f);
                f17 = 0.0f;
            } else {
                this.f33845v = this.f33844u;
                this.f33846w = this.f33841s - Math.max(0, this.f33817g);
                p0(1.0f);
                f17 = 1.0f;
            }
        } else {
            this.f33845v = L(this.f33843t, this.f33844u, f16, this.X);
            this.f33846w = L(this.f33839r, this.f33841s, f16, this.X);
            p0(f16);
            f17 = f16;
        }
        TimeInterpolator timeInterpolator = x0.a.f446811b;
        V(1.0f - L(0.0f, 1.0f, 1.0f - f16, timeInterpolator));
        f0(L(1.0f, 0.0f, f16, timeInterpolator));
        if (this.f33835p != this.f33833o) {
            this.V.setColor(a(v(), t(), f17));
        } else {
            this.V.setColor(t());
        }
        float f18 = this.f33820h0;
        float f19 = this.f33822i0;
        if (f18 != f19) {
            this.V.setLetterSpacing(L(f19, f18, f16, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f18);
        }
        this.P = L(this.f33812d0, this.Z, f16, null);
        this.Q = L(this.f33814e0, this.f33806a0, f16, null);
        this.R = L(this.f33816f0, this.f33808b0, f16, null);
        int a16 = a(u(this.f33818g0), u(this.f33810c0), f16);
        this.S = a16;
        this.V.setShadowLayer(this.P, this.Q, this.R, a16);
        if (this.f33811d) {
            this.V.setAlpha((int) (d(f16) * this.V.getAlpha()));
        }
        ViewCompat.postInvalidateOnAnimation(this.f33805a);
    }

    private void h(float f16) {
        i(f16, false);
    }

    private void i(float f16, boolean z16) {
        boolean z17;
        float f17;
        float f18;
        boolean z18;
        boolean z19;
        boolean z26;
        if (this.G == null) {
            return;
        }
        float width = this.f33821i.width();
        float width2 = this.f33819h.width();
        boolean z27 = false;
        int i3 = 1;
        if (H(f16, 1.0f)) {
            f17 = this.f33831n;
            f18 = this.f33820h0;
            this.N = 1.0f;
            Typeface typeface = this.D;
            Typeface typeface2 = this.f33847x;
            if (typeface != typeface2) {
                this.D = typeface2;
                z18 = true;
            } else {
                z18 = false;
            }
        } else {
            float f19 = this.f33829m;
            float f26 = this.f33822i0;
            Typeface typeface3 = this.D;
            Typeface typeface4 = this.A;
            if (typeface3 != typeface4) {
                this.D = typeface4;
                z17 = true;
            } else {
                z17 = false;
            }
            if (H(f16, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = L(this.f33829m, this.f33831n, f16, this.Y) / this.f33829m;
            }
            float f27 = this.f33831n / this.f33829m;
            float f28 = width2 * f27;
            if (z16 || f28 <= width) {
                width = width2;
            } else {
                width = Math.min(width / f27, width2);
            }
            f17 = f19;
            f18 = f26;
            z18 = z17;
        }
        if (width > 0.0f) {
            if (this.O != f17) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (this.f33824j0 != f18) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (!z19 && !z26 && !this.U && !z18) {
                z18 = false;
            } else {
                z18 = true;
            }
            this.O = f17;
            this.f33824j0 = f18;
            this.U = false;
        }
        if (this.H == null || z18) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.D);
            this.V.setLetterSpacing(this.f33824j0);
            TextPaint textPaint = this.V;
            if (this.N != 1.0f) {
                z27 = true;
            }
            textPaint.setLinearText(z27);
            this.I = f(this.G);
            if (z0()) {
                i3 = this.f33836p0;
            }
            StaticLayout k3 = k(i3, width, this.I);
            this.f33826k0 = k3;
            this.H = k3.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i3, float f16, boolean z16) {
        StaticLayout staticLayout;
        Layout.Alignment C;
        try {
            if (i3 == 1) {
                C = Layout.Alignment.ALIGN_NORMAL;
            } else {
                C = C();
            }
            staticLayout = StaticLayoutBuilderCompat.b(this.G, this.V, (int) f16).d(TextUtils.TruncateAt.END).g(z16).c(C).f(false).i(i3).h(this.f33838q0, this.f33840r0).e(this.f33842s0).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e16) {
            Log.e("CollapsingTextHelper", e16.getCause().getMessage(), e16);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private boolean k0(Typeface typeface) {
        g1.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.C != typeface) {
            this.C = typeface;
            Typeface b16 = g1.i.b(this.f33805a.getContext().getResources().getConfiguration(), typeface);
            this.B = b16;
            if (b16 == null) {
                b16 = this.C;
            }
            this.A = b16;
            return true;
        }
        return false;
    }

    private void m(@NonNull Canvas canvas, float f16, float f17) {
        int alpha = this.V.getAlpha();
        canvas.translate(f16, f17);
        float f18 = alpha;
        this.V.setAlpha((int) (this.f33832n0 * f18));
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            TextPaint textPaint = this.V;
            textPaint.setShadowLayer(this.P, this.Q, this.R, z0.a.a(this.S, textPaint.getAlpha()));
        }
        this.f33826k0.draw(canvas);
        this.V.setAlpha((int) (this.f33830m0 * f18));
        if (i3 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, z0.a.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f33826k0.getLineBaseline(0);
        CharSequence charSequence = this.f33834o0;
        float f19 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f19, this.V);
        if (i3 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (!this.f33811d) {
            String trim = this.f33834o0.toString().trim();
            if (trim.endsWith("\u2026")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.V.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f33826k0.getLineEnd(0), str.length()), 0.0f, f19, (Paint) this.V);
        }
    }

    private void n() {
        if (this.L == null && !this.f33819h.isEmpty() && !TextUtils.isEmpty(this.H)) {
            g(0.0f);
            int width = this.f33826k0.getWidth();
            int height = this.f33826k0.getHeight();
            if (width > 0 && height > 0) {
                this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f33826k0.draw(new Canvas(this.L));
                if (this.M == null) {
                    this.M = new Paint(3);
                }
            }
        }
    }

    private void p0(float f16) {
        boolean z16;
        h(f16);
        if (f33803t0 && this.N != 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.K = z16;
        if (z16) {
            n();
        }
        ViewCompat.postInvalidateOnAnimation(this.f33805a);
    }

    private float r(int i3, int i16) {
        if (i16 != 17 && (i16 & 7) != 1) {
            if ((i16 & 8388613) != 8388613 && (i16 & 5) != 5) {
                if (this.I) {
                    return this.f33821i.right - this.f33828l0;
                }
                return this.f33821i.left;
            }
            if (this.I) {
                return this.f33821i.left;
            }
            return this.f33821i.right - this.f33828l0;
        }
        return (i3 / 2.0f) - (this.f33828l0 / 2.0f);
    }

    private float s(@NonNull RectF rectF, int i3, int i16) {
        if (i16 != 17 && (i16 & 7) != 1) {
            if ((i16 & 8388613) != 8388613 && (i16 & 5) != 5) {
                if (this.I) {
                    return this.f33821i.right;
                }
                return rectF.left + this.f33828l0;
            }
            if (this.I) {
                return rectF.left + this.f33828l0;
            }
            return this.f33821i.right;
        }
        return (i3 / 2.0f) + (this.f33828l0 / 2.0f);
    }

    @ColorInt
    private int u(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    @ColorInt
    private int v() {
        return u(this.f33833o);
    }

    private boolean z0() {
        if (this.f33836p0 > 1 && ((!this.I || this.f33811d) && !this.K)) {
            return true;
        }
        return false;
    }

    public float A() {
        return this.f33815f;
    }

    public int B() {
        return this.f33836p0;
    }

    @Nullable
    public CharSequence D() {
        return this.G;
    }

    public final boolean J() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f33835p;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f33833o) != null && colorStateList.isStateful())) {
            return true;
        }
        return false;
    }

    public void M(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f33849z;
            if (typeface != null) {
                this.f33848y = g1.i.b(configuration, typeface);
            }
            Typeface typeface2 = this.C;
            if (typeface2 != null) {
                this.B = g1.i.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f33848y;
            if (typeface3 == null) {
                typeface3 = this.f33849z;
            }
            this.f33847x = typeface3;
            Typeface typeface4 = this.B;
            if (typeface4 == null) {
                typeface4 = this.C;
            }
            this.A = typeface4;
            Q(true);
        }
    }

    void O() {
        boolean z16;
        if (this.f33821i.width() > 0 && this.f33821i.height() > 0 && this.f33819h.width() > 0 && this.f33819h.height() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f33807b = z16;
    }

    public void P() {
        Q(false);
    }

    public void Q(boolean z16) {
        if ((this.f33805a.getHeight() > 0 && this.f33805a.getWidth() > 0) || z16) {
            b(z16);
            c();
        }
    }

    public void S(int i3, int i16, int i17, int i18) {
        if (!R(this.f33821i, i3, i16, i17, i18)) {
            this.f33821i.set(i3, i16, i17, i18);
            this.U = true;
            O();
        }
    }

    public void T(@NonNull Rect rect) {
        S(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void U(int i3) {
        g1.d dVar = new g1.d(this.f33805a.getContext(), i3);
        if (dVar.i() != null) {
            this.f33835p = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f33831n = dVar.j();
        }
        ColorStateList colorStateList = dVar.f401061c;
        if (colorStateList != null) {
            this.f33810c0 = colorStateList;
        }
        this.f33806a0 = dVar.f401066h;
        this.f33808b0 = dVar.f401067i;
        this.Z = dVar.f401068j;
        this.f33820h0 = dVar.f401070l;
        g1.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        this.F = new g1.a(new a(), dVar.e());
        dVar.h(this.f33805a.getContext(), this.F);
        P();
    }

    public void W(ColorStateList colorStateList) {
        if (this.f33835p != colorStateList) {
            this.f33835p = colorStateList;
            P();
        }
    }

    public void X(int i3) {
        if (this.f33827l != i3) {
            this.f33827l = i3;
            P();
        }
    }

    public void Y(Typeface typeface) {
        if (Z(typeface)) {
            P();
        }
    }

    public void a0(int i3) {
        this.f33817g = i3;
    }

    public void b0(int i3, int i16, int i17, int i18) {
        if (!R(this.f33819h, i3, i16, i17, i18)) {
            this.f33819h.set(i3, i16, i17, i18);
            this.U = true;
            O();
        }
    }

    public void c0(@NonNull Rect rect) {
        b0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void d0(float f16) {
        if (this.f33822i0 != f16) {
            this.f33822i0 = f16;
            P();
        }
    }

    public void e0(int i3) {
        g1.d dVar = new g1.d(this.f33805a.getContext(), i3);
        if (dVar.i() != null) {
            this.f33833o = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f33829m = dVar.j();
        }
        ColorStateList colorStateList = dVar.f401061c;
        if (colorStateList != null) {
            this.f33818g0 = colorStateList;
        }
        this.f33814e0 = dVar.f401066h;
        this.f33816f0 = dVar.f401067i;
        this.f33812d0 = dVar.f401068j;
        this.f33822i0 = dVar.f401070l;
        g1.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new g1.a(new C0235b(), dVar.e());
        dVar.h(this.f33805a.getContext(), this.E);
        P();
    }

    public void g0(ColorStateList colorStateList) {
        if (this.f33833o != colorStateList) {
            this.f33833o = colorStateList;
            P();
        }
    }

    public void h0(int i3) {
        if (this.f33825k != i3) {
            this.f33825k = i3;
            P();
        }
    }

    public void i0(float f16) {
        if (this.f33829m != f16) {
            this.f33829m = f16;
            P();
        }
    }

    public void j0(Typeface typeface) {
        if (k0(typeface)) {
            P();
        }
    }

    public void l(@NonNull Canvas canvas) {
        boolean z16;
        int save = canvas.save();
        if (this.H != null && this.f33807b) {
            this.V.setTextSize(this.O);
            float f16 = this.f33845v;
            float f17 = this.f33846w;
            if (this.K && this.L != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            float f18 = this.N;
            if (f18 != 1.0f && !this.f33811d) {
                canvas.scale(f18, f18, f16, f17);
            }
            if (z16) {
                canvas.drawBitmap(this.L, f16, f17, this.M);
                canvas.restoreToCount(save);
                return;
            }
            if (z0() && (!this.f33811d || this.f33809c > this.f33815f)) {
                m(canvas, this.f33845v - this.f33826k0.getLineStart(0), f17);
            } else {
                canvas.translate(f16, f17);
                this.f33826k0.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void l0(float f16) {
        float clamp = MathUtils.clamp(f16, 0.0f, 1.0f);
        if (clamp != this.f33809c) {
            this.f33809c = clamp;
            c();
        }
    }

    public void m0(boolean z16) {
        this.f33811d = z16;
    }

    public void n0(float f16) {
        this.f33813e = f16;
        this.f33815f = e();
    }

    public void o(@NonNull RectF rectF, int i3, int i16) {
        this.I = f(this.G);
        rectF.left = r(i3, i16);
        rectF.top = this.f33821i.top;
        rectF.right = s(rectF, i3, i16);
        rectF.bottom = this.f33821i.top + q();
    }

    @RequiresApi(23)
    public void o0(int i3) {
        this.f33842s0 = i3;
    }

    public ColorStateList p() {
        return this.f33835p;
    }

    public float q() {
        E(this.W);
        return -this.W.ascent();
    }

    @RequiresApi(23)
    public void q0(float f16) {
        this.f33838q0 = f16;
    }

    @RequiresApi(23)
    public void r0(@FloatRange(from = 0.0d) float f16) {
        this.f33840r0 = f16;
    }

    public void s0(int i3) {
        if (i3 != this.f33836p0) {
            this.f33836p0 = i3;
            j();
            P();
        }
    }

    @ColorInt
    public int t() {
        return u(this.f33835p);
    }

    public void t0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        P();
    }

    public void u0(boolean z16) {
        this.J = z16;
    }

    public final boolean v0(int[] iArr) {
        this.T = iArr;
        if (J()) {
            P();
            return true;
        }
        return false;
    }

    public int w() {
        return this.f33837q;
    }

    public void w0(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            P();
        }
    }

    public float x() {
        F(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void x0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        P();
    }

    public float y() {
        F(this.W);
        return -this.W.ascent();
    }

    public void y0(Typeface typeface) {
        boolean Z = Z(typeface);
        boolean k06 = k0(typeface);
        if (Z || k06) {
            P();
        }
    }

    public float z() {
        return this.f33809c;
    }
}
