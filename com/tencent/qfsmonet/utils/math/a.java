package com.tencent.qfsmonet.utils.math;

import android.opengl.Matrix;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private float[] f342632a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f342633b;

    /* renamed from: c, reason: collision with root package name */
    private float[] f342634c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f342635d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f342636e;

    /* renamed from: f, reason: collision with root package name */
    private C9303a f342637f;

    /* renamed from: g, reason: collision with root package name */
    private int f342638g;

    /* renamed from: h, reason: collision with root package name */
    private float f342639h;

    /* renamed from: i, reason: collision with root package name */
    private float f342640i;

    /* renamed from: j, reason: collision with root package name */
    private float f342641j;

    /* renamed from: k, reason: collision with root package name */
    private float f342642k;

    /* renamed from: l, reason: collision with root package name */
    private float f342643l;

    /* renamed from: m, reason: collision with root package name */
    private float f342644m;

    /* renamed from: n, reason: collision with root package name */
    private float f342645n;

    /* renamed from: o, reason: collision with root package name */
    private float f342646o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f342647p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f342648q;

    /* compiled from: P */
    /* renamed from: com.tencent.qfsmonet.utils.math.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9303a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public float[] f342649a;

        /* renamed from: b, reason: collision with root package name */
        public float[] f342650b;

        public C9303a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342632a = new float[16];
        this.f342633b = new float[16];
        this.f342634c = new float[16];
        this.f342635d = new float[16];
        this.f342636e = new float[16];
        this.f342637f = new C9303a();
        this.f342638g = 1;
        this.f342639h = 0.7f;
        this.f342640i = 0.0f;
        this.f342641j = 0.0f;
        this.f342642k = 0.0f;
        this.f342643l = 0.0f;
        this.f342644m = 0.0f;
        this.f342645n = 1.5f;
        this.f342646o = 1.0f;
        this.f342647p = true;
        this.f342648q = false;
        c();
    }

    private void c() {
        C9303a c9303a = this.f342637f;
        c9303a.f342649a = new float[16];
        c9303a.f342650b = new float[16];
        Matrix.setIdentityM(this.f342632a, 0);
        Matrix.setIdentityM(this.f342634c, 0);
        Matrix.setIdentityM(this.f342633b, 0);
        Matrix.setIdentityM(this.f342637f.f342649a, 0);
        Matrix.setIdentityM(this.f342637f.f342650b, 0);
        com.tencent.qfsmonet.utils.a.c("Monet[MonetVRCamera.java]", "initMatrix, set matrix to the identity matrix");
    }

    private void i() {
        float f16 = this.f342640i;
        float f17 = this.f342641j;
        float f18 = this.f342642k;
        float f19 = this.f342643l;
        float f26 = this.f342644m;
        Matrix.setIdentityM(this.f342635d, 0);
        Matrix.setLookAtM(this.f342635d, 0, f16, f17, f18, f19, f26, -1.0f, 0.0f, 1.0f, 0.0f);
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.multiplyMM(fArr, 0, this.f342632a, 0, this.f342633b, 0);
        Matrix.multiplyMM(fArr, 0, this.f342634c, 0, fArr, 0);
        Matrix.multiplyMM(fArr, 0, this.f342635d, 0, fArr, 0);
        System.arraycopy(fArr, 0, this.f342635d, 0, 16);
        this.f342647p = false;
    }

    public C9303a a(@NonNull float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (C9303a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) fArr);
        }
        if (fArr.length != 16) {
            com.tencent.qfsmonet.utils.a.b("Monet[MonetVRCamera.java]", "the length of modelPosition is wrong.");
            return null;
        }
        if (this.f342647p) {
            i();
        }
        if (!this.f342648q) {
            h();
        }
        Matrix.multiplyMM(this.f342637f.f342649a, 0, this.f342635d, 0, fArr, 0);
        C9303a c9303a = this.f342637f;
        Matrix.multiplyMM(c9303a.f342650b, 0, this.f342636e, 0, c9303a.f342649a, 0);
        return this.f342637f;
    }

    protected float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.f342646o * this.f342639h;
    }

    public void d(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        if (i3 == 1) {
            Matrix.setIdentityM(this.f342634c, 0);
            Matrix.rotateM(this.f342634c, 0, f16, 1.0f, 0.0f, 0.0f);
        } else {
            Matrix.setIdentityM(this.f342633b, 0);
            Matrix.rotateM(this.f342633b, 0, -f16, 0.0f, 0.0f, 1.0f);
        }
        this.f342647p = true;
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f342638g = i3;
        }
    }

    public void f(@NonNull float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fArr);
        } else {
            if (fArr.length != 16) {
                return;
            }
            System.arraycopy(fArr, 0, this.f342632a, 0, 16);
            this.f342647p = true;
        }
    }

    public void g(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (i16 > 0 && i3 > 0) {
            this.f342645n = (i3 * 1.0f) / i16;
            h();
        }
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f342638g == 1) {
            float f16 = this.f342645n;
            Matrix.frustumM(this.f342636e, 0, (-f16) / 2.0f, f16 / 2.0f, -0.5f, 0.5f, b(), 500.0f);
        } else {
            Matrix.orthoM(this.f342636e, 0, -1.0f, 1.0f, -1.0f, 1.0f, b(), 500.0f);
        }
        this.f342648q = true;
    }
}
