package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.jf;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes9.dex */
public class jg {

    /* renamed from: a, reason: collision with root package name */
    int f148872a;

    /* renamed from: b, reason: collision with root package name */
    jf f148873b;

    /* renamed from: c, reason: collision with root package name */
    jf f148874c;

    /* renamed from: d, reason: collision with root package name */
    Interpolator f148875d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<jf> f148876e;

    /* renamed from: f, reason: collision with root package name */
    jl f148877f;

    public jg(jf... jfVarArr) {
        this.f148872a = jfVarArr.length;
        ArrayList<jf> arrayList = new ArrayList<>();
        this.f148876e = arrayList;
        arrayList.addAll(Arrays.asList(jfVarArr));
        this.f148873b = this.f148876e.get(0);
        jf jfVar = this.f148876e.get(this.f148872a - 1);
        this.f148874c = jfVar;
        this.f148875d = jfVar.f148867c;
    }

    private static jg a(int... iArr) {
        int length = iArr.length;
        jf.b[] bVarArr = new jf.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (jf.b) jf.a();
            bVarArr[1] = (jf.b) jf.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (jf.b) jf.a(0.0f, iArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                bVarArr[i3] = (jf.b) jf.a(i3 / (length - 1), iArr[i3]);
            }
        }
        return new je(bVarArr);
    }

    public String toString() {
        String str = " ";
        for (int i3 = 0; i3 < this.f148872a; i3++) {
            str = str + this.f148876e.get(i3).d() + "  ";
        }
        return str;
    }

    private static jg a(double... dArr) {
        int length = dArr.length;
        jf.a[] aVarArr = new jf.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (jf.a) jf.b();
            aVarArr[1] = (jf.a) jf.a(1.0f, dArr[0]);
        } else {
            aVarArr[0] = (jf.a) jf.a(0.0f, dArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                aVarArr[i3] = (jf.a) jf.a(i3 / (length - 1), dArr[i3]);
            }
        }
        return new jc(aVarArr);
    }

    private static jg a(jf... jfVarArr) {
        int length = jfVarArr.length;
        int i3 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        for (jf jfVar : jfVarArr) {
            if (jfVar instanceof jf.a) {
                z16 = true;
            } else if (jfVar instanceof jf.b) {
                z17 = true;
            } else {
                z18 = true;
            }
        }
        if (z16 && !z17 && !z18) {
            jf.a[] aVarArr = new jf.a[length];
            while (i3 < length) {
                aVarArr[i3] = (jf.a) jfVarArr[i3];
                i3++;
            }
            return new jc(aVarArr);
        }
        if (z17 && !z16 && !z18) {
            jf.b[] bVarArr = new jf.b[length];
            while (i3 < length) {
                bVarArr[i3] = (jf.b) jfVarArr[i3];
                i3++;
            }
            return new je(bVarArr);
        }
        return new jg(jfVarArr);
    }

    public static jg a(Object... objArr) {
        int length = objArr.length;
        jf.c[] cVarArr = new jf.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (jf.c) jf.c();
            cVarArr[1] = (jf.c) jf.a(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (jf.c) jf.a(0.0f, objArr[0]);
            for (int i3 = 1; i3 < length; i3++) {
                cVarArr[i3] = (jf.c) jf.a(i3 / (length - 1), objArr[i3]);
            }
        }
        return new jg(cVarArr);
    }

    private void a(jl jlVar) {
        this.f148877f = jlVar;
    }

    @Override // 
    /* renamed from: a */
    public jg clone() {
        ArrayList<jf> arrayList = this.f148876e;
        int size = arrayList.size();
        jf[] jfVarArr = new jf[size];
        for (int i3 = 0; i3 < size; i3++) {
            jfVarArr[i3] = arrayList.get(i3).e();
        }
        return new jg(jfVarArr);
    }

    public Object a(float f16) {
        int i3 = this.f148872a;
        if (i3 == 2) {
            Interpolator interpolator = this.f148875d;
            if (interpolator != null) {
                f16 = interpolator.getInterpolation(f16);
            }
            return this.f148877f.a(f16, this.f148873b.d(), this.f148874c.d());
        }
        int i16 = 1;
        if (f16 <= 0.0f) {
            jf jfVar = this.f148876e.get(1);
            Interpolator interpolator2 = jfVar.f148867c;
            if (interpolator2 != null) {
                f16 = interpolator2.getInterpolation(f16);
            }
            jf jfVar2 = this.f148873b;
            float f17 = jfVar2.f148865a;
            return this.f148877f.a((f16 - f17) / (jfVar.f148865a - f17), jfVar2.d(), jfVar.d());
        }
        if (f16 >= 1.0f) {
            jf jfVar3 = this.f148876e.get(i3 - 2);
            Interpolator interpolator3 = this.f148874c.f148867c;
            if (interpolator3 != null) {
                f16 = interpolator3.getInterpolation(f16);
            }
            float f18 = jfVar3.f148865a;
            return this.f148877f.a((f16 - f18) / (this.f148874c.f148865a - f18), jfVar3.d(), this.f148874c.d());
        }
        jf jfVar4 = this.f148873b;
        while (i16 < this.f148872a) {
            jf jfVar5 = this.f148876e.get(i16);
            if (f16 < jfVar5.f148865a) {
                Interpolator interpolator4 = jfVar5.f148867c;
                if (interpolator4 != null) {
                    f16 = interpolator4.getInterpolation(f16);
                }
                float f19 = jfVar4.f148865a;
                return this.f148877f.a((f16 - f19) / (jfVar5.f148865a - f19), jfVar4.d(), jfVar5.d());
            }
            i16++;
            jfVar4 = jfVar5;
        }
        return this.f148874c.d();
    }
}
