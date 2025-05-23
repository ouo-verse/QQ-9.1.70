package com.tencent.android.androidbypass.enhance;

import android.text.TextPaint;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class i {
    static IPatchRedirector $redirector_;
    public int A;
    public int B;
    public int C;
    public float D;
    public int E;

    @ColorInt
    public int F;

    @ColorInt
    public int G;
    public float H;
    public int I;
    public float J;
    public int K;
    public float L;
    public int M;
    public boolean N;
    public float O;

    @ColorInt
    public int P;
    public float Q;
    public int R;
    public float S;
    public int T;
    public float U;
    public int V;
    public int W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<TextView> f72176a;

    /* renamed from: a0, reason: collision with root package name */
    public int f72177a0;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f72178b;

    /* renamed from: b0, reason: collision with root package name */
    public float f72179b0;

    /* renamed from: c, reason: collision with root package name */
    public float f72180c;

    /* renamed from: c0, reason: collision with root package name */
    public int f72181c0;

    /* renamed from: d, reason: collision with root package name */
    public int f72182d;

    /* renamed from: d0, reason: collision with root package name */
    public float f72183d0;

    /* renamed from: e, reason: collision with root package name */
    public float f72184e;

    /* renamed from: e0, reason: collision with root package name */
    public int f72185e0;

    /* renamed from: f, reason: collision with root package name */
    public int f72186f;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.android.androidbypass.enhance.e f72187f0;

    /* renamed from: g, reason: collision with root package name */
    public float f72188g;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.android.androidbypass.enhance.e f72189g0;

    /* renamed from: h, reason: collision with root package name */
    public float f72190h;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.android.androidbypass.enhance.e f72191h0;

    /* renamed from: i, reason: collision with root package name */
    public int f72192i;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.android.androidbypass.enhance.e f72193i0;

    /* renamed from: j, reason: collision with root package name */
    public float f72194j;

    /* renamed from: k, reason: collision with root package name */
    public int f72195k;

    /* renamed from: l, reason: collision with root package name */
    public String f72196l;

    /* renamed from: m, reason: collision with root package name */
    public float f72197m;

    /* renamed from: n, reason: collision with root package name */
    public float f72198n;

    /* renamed from: o, reason: collision with root package name */
    public int f72199o;

    /* renamed from: p, reason: collision with root package name */
    public String f72200p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f72201q;

    /* renamed from: r, reason: collision with root package name */
    public float f72202r;

    /* renamed from: s, reason: collision with root package name */
    public float f72203s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f72204t;

    /* renamed from: u, reason: collision with root package name */
    @ColorInt
    public int f72205u;

    /* renamed from: v, reason: collision with root package name */
    @ColorInt
    public int f72206v;

    /* renamed from: w, reason: collision with root package name */
    public float f72207w;

    /* renamed from: x, reason: collision with root package name */
    public float f72208x;

    /* renamed from: y, reason: collision with root package name */
    public float f72209y;

    /* renamed from: z, reason: collision with root package name */
    public int f72210z;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends com.tencent.android.androidbypass.enhance.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f72211a;

        a(WeakReference weakReference) {
            this.f72211a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) weakReference);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.e
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return i.j(this.f72211a, 1.0f, -16777216);
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @Override // com.tencent.android.androidbypass.enhance.a, com.tencent.android.androidbypass.enhance.e
        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return i.this.W;
        }

        @Override // com.tencent.android.androidbypass.enhance.a, com.tencent.android.androidbypass.enhance.e
        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends com.tencent.android.androidbypass.enhance.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f72213a;

        b(WeakReference weakReference) {
            this.f72213a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) weakReference);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.e
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return i.j(this.f72213a, i.this.f72188g, -16777216);
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends com.tencent.android.androidbypass.enhance.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f72215a;

        c(WeakReference weakReference) {
            this.f72215a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) weakReference);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.e
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            WeakReference weakReference = this.f72215a;
            i iVar = i.this;
            return i.j(weakReference, iVar.f72208x, iVar.f72205u);
        }

        @Override // com.tencent.android.androidbypass.enhance.a, com.tencent.android.androidbypass.enhance.e
        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            WeakReference weakReference = this.f72215a;
            i iVar = i.this;
            return i.j(weakReference, iVar.f72207w, iVar.f72206v);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d extends com.tencent.android.androidbypass.enhance.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.e
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return i.this.f72205u;
        }

        @Override // com.tencent.android.androidbypass.enhance.a, com.tencent.android.androidbypass.enhance.e
        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return i.this.f72206v;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e extends com.tencent.android.androidbypass.enhance.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f72218a;

        e(WeakReference weakReference) {
            this.f72218a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) weakReference);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.e
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            WeakReference weakReference = this.f72218a;
            i iVar = i.this;
            return i.j(weakReference, iVar.O, iVar.P);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        float[] fArr = {1.07f, 1.07f, 1.07f, 1.07f, 1.07f, 1.07f};
        this.f72178b = fArr;
        this.f72180c = 5.0f;
        this.f72182d = 1;
        this.f72184e = 7.0f;
        this.f72186f = 1;
        this.f72188g = 1.0f;
        this.f72190h = 6.0f;
        this.f72192i = 1;
        this.f72194j = 6.0f * 3.0f;
        this.f72195k = 1;
        this.f72196l = "\u2022 ";
        this.f72197m = 0.87f;
        this.f72198n = 8.0f;
        this.f72199o = 1;
        this.f72200p = "monospace";
        this.f72201q = true;
        this.f72202r = 1.0f;
        this.f72203s = 0.118f;
        this.f72204t = true;
        this.f72207w = 0.15f;
        this.f72208x = 0.4f;
        this.f72209y = 0.8666f;
        this.f72210z = 2;
        this.A = 1;
        this.B = -16;
        this.C = 0;
        this.D = 10.0f;
        this.E = 1;
        this.F = 863401848;
        this.G = -9013384;
        this.H = 12.0f;
        this.I = 2;
        this.J = 3.0f;
        this.K = 1;
        this.L = 4.0f;
        this.M = 1;
        this.N = true;
        this.O = 0.15f;
        this.Q = 1.0f;
        this.R = 1;
        this.S = 18.0f;
        this.T = 1;
        this.U = 7.0f;
        this.V = 1;
        this.W = -16777216;
        this.X = fArr[0];
        this.Y = 13.0f;
        this.Z = 7.0f;
        this.f72177a0 = 1;
        this.f72179b0 = 7.0f;
        this.f72181c0 = 1;
        this.f72183d0 = 5.0f;
        this.f72185e0 = 1;
    }

    @NonNull
    private com.tencent.android.androidbypass.enhance.e h(@Nullable WeakReference<TextView> weakReference) {
        if (this.N) {
            return new e(weakReference);
        }
        return f.a(this.P);
    }

    @NonNull
    private com.tencent.android.androidbypass.enhance.e i(@Nullable WeakReference<TextView> weakReference) {
        if (this.f72204t) {
            return new c(weakReference);
        }
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(@Nullable WeakReference<TextView> weakReference, @FloatRange(from = 0.0d, to = 1.0d) float f16, @ColorInt int i3) {
        TextView textView;
        if (weakReference != null) {
            textView = weakReference.get();
        } else {
            textView = null;
        }
        if (textView != null) {
            return ColorUtils.setAlphaComponent(textView.getCurrentTextColor(), com.tencent.android.androidbypass.enhance.b.a(f16));
        }
        return i3;
    }

    public void b(WeakReference<TextView> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference);
        } else {
            this.f72176a = weakReference;
        }
    }

    @Nullable
    public TextPaint c() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextPaint) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        WeakReference<TextView> weakReference = this.f72176a;
        if (weakReference != null) {
            textView = weakReference.get();
        } else {
            textView = null;
        }
        if (textView == null) {
            return null;
        }
        return textView.getPaint();
    }

    public com.tencent.android.androidbypass.enhance.e d(@Nullable WeakReference<TextView> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.android.androidbypass.enhance.e) iPatchRedirector.redirect((short) 10, (Object) this, (Object) weakReference);
        }
        if (weakReference == null) {
            weakReference = this.f72176a;
        }
        if (this.f72193i0 == null) {
            this.f72193i0 = new a(weakReference);
        }
        return this.f72193i0;
    }

    public com.tencent.android.androidbypass.enhance.e e(@Nullable WeakReference<TextView> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.android.androidbypass.enhance.e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) weakReference);
        }
        if (this.f72187f0 == null) {
            this.f72187f0 = new b(weakReference);
        }
        return this.f72187f0;
    }

    public com.tencent.android.androidbypass.enhance.e f(@Nullable WeakReference<TextView> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.android.androidbypass.enhance.e) iPatchRedirector.redirect((short) 8, (Object) this, (Object) weakReference);
        }
        if (this.f72191h0 == null) {
            this.f72191h0 = h(weakReference);
        }
        return this.f72191h0;
    }

    public com.tencent.android.androidbypass.enhance.e g(@Nullable WeakReference<TextView> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.android.androidbypass.enhance.e) iPatchRedirector.redirect((short) 6, (Object) this, (Object) weakReference);
        }
        if (this.f72189g0 == null) {
            this.f72189g0 = i(weakReference);
        }
        return this.f72189g0;
    }
}
