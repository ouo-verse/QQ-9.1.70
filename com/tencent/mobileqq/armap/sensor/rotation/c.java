package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.luggage.wxa.uf.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Vector3> f199792a;

    /* renamed from: b, reason: collision with root package name */
    private Vector3 f199793b;

    /* renamed from: c, reason: collision with root package name */
    private Vector3 f199794c;

    /* renamed from: d, reason: collision with root package name */
    private Vector3 f199795d;

    /* renamed from: e, reason: collision with root package name */
    private Vector3 f199796e;

    /* renamed from: f, reason: collision with root package name */
    private Vector3 f199797f;

    /* renamed from: g, reason: collision with root package name */
    private Vector3 f199798g;

    /* renamed from: h, reason: collision with root package name */
    private Vector3 f199799h;

    /* renamed from: i, reason: collision with root package name */
    private Vector3 f199800i;

    /* renamed from: j, reason: collision with root package name */
    private Vector3 f199801j;

    /* renamed from: k, reason: collision with root package name */
    private Vector3 f199802k;

    /* renamed from: l, reason: collision with root package name */
    private Vector3 f199803l;

    /* renamed from: m, reason: collision with root package name */
    private Matrix4 f199804m;

    /* renamed from: n, reason: collision with root package name */
    private Matrix4 f199805n;

    /* renamed from: o, reason: collision with root package name */
    private List<Vector3> f199806o;

    /* renamed from: p, reason: collision with root package name */
    private e f199807p;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<Vector3> f199808q;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f199792a = new ArrayList<>(o.CTRL_INDEX);
        this.f199793b = new Vector3();
        this.f199794c = new Vector3();
        this.f199795d = new Vector3();
        this.f199796e = new Vector3();
        this.f199797f = new Vector3();
        this.f199798g = new Vector3();
        this.f199799h = new Vector3();
        this.f199800i = new Vector3();
        this.f199801j = new Vector3();
        this.f199802k = new Vector3();
        this.f199803l = new Vector3();
        this.f199804m = new Matrix4();
        this.f199805n = new Matrix4();
        this.f199806o = new ArrayList();
        this.f199807p = new e();
        this.f199808q = null;
        this.f199804m.setToOrtho2D(0.0f, 0.0f, 1.0f, -1.0f);
        for (int i3 = 0; i3 < 792; i3++) {
            this.f199792a.add(new Vector3());
        }
        this.f199806o.addAll(this.f199792a);
        this.f199806o.add(this.f199797f);
        this.f199806o.add(this.f199798g);
        this.f199806o.add(this.f199799h);
    }

    private void b() {
        this.f199797f.set(0.0f, 0.0f, 1.0f);
        this.f199798g.set(0.0f, 0.0f, -1.0f);
        if (this.f199808q == null) {
            this.f199808q = new ArrayList<>(o.CTRL_INDEX);
            for (int i3 = 0; i3 < 11; i3++) {
                int i16 = (i3 - 5) * 15;
                float cos = (float) Math.cos(i16 * 0.017453292f);
                float cos2 = (float) Math.cos((90 - i16) * 0.017453292f);
                for (int i17 = 0; i17 < 72; i17++) {
                    double d16 = i17 * 5 * 0.017453292f;
                    Vector3 vector3 = new Vector3(((float) Math.sin(d16)) * cos * 1.0f, (-((float) Math.cos(d16))) * cos * 1.0f, cos2 * 1.0f);
                    this.f199808q.add(vector3);
                    this.f199792a.get((i3 * 72) + i17).set(vector3);
                }
            }
        } else {
            int size = this.f199792a.size();
            for (int i18 = 0; i18 < size; i18++) {
                this.f199792a.get(i18).set(this.f199808q.get(i18));
            }
        }
        this.f199799h.set(this.f199792a.get(360));
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x029a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Matrix4 matrix4, int i3, float[] fArr) {
        float e16;
        float f16;
        Vector3 vector3;
        Vector3 vector32;
        boolean z16;
        int i16;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, matrix4, Integer.valueOf(i3), fArr);
            return;
        }
        c(matrix4, i3);
        Vector3 vector33 = this.f199798g;
        this.f199796e.set(500.0f, 500.0f, -1000.0f);
        float f17 = 0.0f;
        this.f199795d.set(500.0f, 500.0f, 0.0f);
        float c16 = d.c(this.f199796e, this.f199798g);
        float c17 = d.c(this.f199796e, this.f199797f);
        float c18 = d.c(this.f199795d, this.f199798g);
        float c19 = d.c(this.f199795d, this.f199796e);
        float c26 = d.c(this.f199798g, this.f199796e);
        float a16 = (d.a(c26, d.d(c18, c19, c26)) * 57.29578f) - 90.0f;
        if (c16 > c17) {
            a16 = -a16;
        }
        if (Float.isNaN(a16)) {
            a16 = 0.0f;
        }
        this.f199796e.set(500.0f, 500.0f, -1000.0f);
        if (Math.abs(a16) < 75.0f) {
            float f18 = Float.MAX_VALUE;
            int i26 = 0;
            for (int i27 = 0; i27 < 792; i27++) {
                Vector3 vector34 = this.f199792a.get(i27);
                if (vector34.f199788z < 0.0f) {
                    float c27 = d.c(this.f199796e, vector34);
                    if (c27 < f18) {
                        f18 = c27;
                        i26 = i27;
                    }
                }
            }
            int i28 = i26 % 72;
            if (i28 == 0) {
                i16 = i26 + 1;
                i18 = i26 + 72;
            } else {
                i16 = i26 + 1;
                if (i16 % 72 == 0) {
                    i16 = i26 - 1;
                    i18 = i26 - 72;
                } else {
                    i17 = i26 - 1;
                    int i29 = i17;
                    if (i16 < 0 && i29 >= 0 && i16 < 792 && i29 < 792) {
                        float c28 = d.c(this.f199796e, this.f199792a.get(i16));
                        c18 = d.c(this.f199796e, this.f199792a.get(i29));
                        if (c28 < c18) {
                            c18 = c28;
                        } else {
                            i16 = i29;
                        }
                        if (i16 >= i26 ? !(i28 != 0 || i16 != i29) : !((i26 + 1) % 72 == 0 && i16 == i29)) {
                            c19 = f18;
                            i19 = i16;
                        } else {
                            i19 = i26;
                            c19 = c18;
                            c18 = f18;
                        }
                    } else {
                        i19 = 0;
                        i16 = 0;
                    }
                    if (i16 <= 791 && i16 >= 0) {
                        vector33 = this.f199792a.get(i16);
                    }
                    e16 = d.e((((i19 % 72) * 5.0f) + (5.0f * ((Math.cos(d.b(c19, d.d(c18, c19, r1))) * c18) / d.c(this.f199792a.get(i26), vector33)))) - 180.0d);
                }
            }
            i17 = i18 - 1;
            int i292 = i17;
            if (i16 < 0) {
            }
            i19 = 0;
            i16 = 0;
            if (i16 <= 791) {
                vector33 = this.f199792a.get(i16);
            }
            e16 = d.e((((i19 % 72) * 5.0f) + (5.0f * ((Math.cos(d.b(c19, d.d(c18, c19, r1))) * c18) / d.c(this.f199792a.get(i26), vector33)))) - 180.0d);
        } else {
            this.f199800i.set(500.0f, 200.0f, 0.0f);
            this.f199801j.set(500.0f, 800.0f, 0.0f);
            this.f199802k.set(200.0f, 500.0f, 0.0f);
            this.f199803l.set(800.0f, 500.0f, 0.0f);
            float c29 = d.c(this.f199799h, this.f199800i);
            float c36 = d.c(this.f199799h, this.f199801j);
            float c37 = d.c(this.f199799h, this.f199802k);
            float c38 = d.c(this.f199799h, this.f199803l);
            float c39 = d.c(this.f199795d, this.f199799h);
            float c46 = d.c(this.f199795d, this.f199800i);
            float c47 = d.c(this.f199799h, this.f199800i);
            float f19 = (-d.a(c47, d.d(c39, c46, c47))) * 57.29578f;
            if (c29 < c36) {
                if (c37 < c38) {
                    f19 = 360.0f - f19;
                }
            } else if (c37 < c38) {
                f19 += 180.0f;
            } else {
                f19 = 180.0f - f19;
            }
            if (a16 > 0.0f) {
                f19 = 180.0f - f19;
            }
            e16 = d.e(f19);
        }
        if (Float.isNaN(e16)) {
            e16 = 0.0f;
        }
        if (Math.abs(a16) < 75.0f) {
            this.f199793b.set(500.0f, 200.0f, 0.0f);
            this.f199794c.set(500.0f, 800.0f, 0.0f);
            if (a16 < 0.0f) {
                vector3 = this.f199794c;
                vector32 = this.f199797f;
                z16 = false;
            } else {
                vector3 = this.f199793b;
                vector32 = this.f199798g;
                z16 = true;
            }
            float f26 = vector3.f199786x;
            Vector3 vector35 = this.f199795d;
            float f27 = vector35.f199786x;
            float f28 = (f26 - f27) * (f26 - f27);
            float f29 = vector3.f199787y;
            float f36 = vector35.f199787y;
            float sqrt = (float) Math.sqrt(f28 + ((f29 - f36) * (f29 - f36)));
            float f37 = vector3.f199786x;
            float f38 = vector32.f199786x;
            float f39 = (f37 - f38) * (f37 - f38);
            float f46 = vector3.f199787y;
            float f47 = vector32.f199787y;
            float sqrt2 = (float) Math.sqrt(f39 + ((f46 - f47) * (f46 - f47)));
            Vector3 vector36 = this.f199795d;
            float f48 = vector36.f199786x;
            float f49 = vector32.f199786x;
            float f56 = (f48 - f49) * (f48 - f49);
            float f57 = vector36.f199787y;
            float f58 = vector32.f199787y;
            float sqrt3 = (float) Math.sqrt(f56 + ((f57 - f58) * (f57 - f58)));
            float f59 = (((sqrt * sqrt) + (sqrt3 * sqrt3)) - (sqrt2 * sqrt2)) / ((sqrt * 2.0f) * sqrt3);
            if (f59 < 1.0f) {
                float acos = ((float) Math.acos(f59)) * 57.29578f;
                if (!z16 ? vector3.f199786x - vector32.f199786x > 0.0f : vector3.f199786x - vector32.f199786x < 0.0f) {
                    acos = -acos;
                }
                float e17 = d.e(acos);
                if (e17 > 3.0f && e17 < 357.0f) {
                    f16 = ((float) Math.round(e17 / 0.5d)) * 0.5f;
                    if (!Float.isNaN(f16)) {
                        f17 = f16;
                    }
                    fArr[0] = e16;
                    fArr[1] = a16;
                    fArr[2] = f17;
                }
            }
        }
        f16 = 0.0f;
        if (!Float.isNaN(f16)) {
        }
        fArr[0] = e16;
        fArr[1] = a16;
        fArr[2] = f17;
    }

    public void c(Matrix4 matrix4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) matrix4, i3);
            return;
        }
        b();
        this.f199805n.idt().mul(this.f199804m).mul(matrix4);
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
            } else {
                for (Vector3 vector3 : this.f199806o) {
                    this.f199807p.b(vector3.f199786x, -vector3.f199787y, -vector3.f199788z, 0.0f);
                    this.f199807p.a(this.f199805n);
                    e eVar = this.f199807p;
                    vector3.f199786x = ((-eVar.f199812a) * 500.0f) + 500.0f;
                    vector3.f199787y = ((-eVar.f199813b) * 500.0f) + 500.0f + 0.0f;
                    vector3.f199788z = eVar.f199814c * 500.0f;
                }
                return;
            }
        }
        for (Vector3 vector32 : this.f199806o) {
            this.f199807p.b(vector32.f199786x, -vector32.f199787y, -vector32.f199788z, 0.0f);
            this.f199807p.a(this.f199805n);
            e eVar2 = this.f199807p;
            vector32.f199786x = (eVar2.f199812a * 500.0f) + 500.0f;
            vector32.f199787y = (eVar2.f199813b * 500.0f) + 500.0f + 0.0f;
            vector32.f199788z = eVar2.f199814c * 500.0f;
        }
    }
}
