package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.jf;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class jc extends jg {

    /* renamed from: g, reason: collision with root package name */
    private double f148857g;

    /* renamed from: h, reason: collision with root package name */
    private double f148858h;

    /* renamed from: i, reason: collision with root package name */
    private double f148859i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f148860j;

    public jc(jf.a... aVarArr) {
        super(aVarArr);
        this.f148860j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.jg
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public jc clone() {
        ArrayList<jf> arrayList = this.f148876e;
        int size = arrayList.size();
        jf.a[] aVarArr = new jf.a[size];
        for (int i3 = 0; i3 < size; i3++) {
            aVarArr[i3] = (jf.a) arrayList.get(i3).e();
        }
        return new jc(aVarArr);
    }

    @Override // com.tencent.mapsdk.internal.jg
    public final Object a(float f16) {
        return Double.valueOf(b(f16));
    }

    public final double b(float f16) {
        double d16;
        double d17;
        float f17;
        int i3 = this.f148872a;
        if (i3 == 2) {
            if (this.f148860j) {
                this.f148860j = false;
                this.f148857g = ((jf.a) this.f148876e.get(0)).f148869e;
                double d18 = ((jf.a) this.f148876e.get(1)).f148869e;
                this.f148858h = d18;
                this.f148859i = d18 - this.f148857g;
            }
            Interpolator interpolator = this.f148875d;
            if (interpolator != null) {
                f16 = interpolator.getInterpolation(f16);
            }
            jl jlVar = this.f148877f;
            if (jlVar == null) {
                return this.f148857g + (f16 * this.f148859i);
            }
            return ((Number) jlVar.a(f16, Double.valueOf(this.f148857g), Double.valueOf(this.f148858h))).doubleValue();
        }
        if (f16 <= 0.0f) {
            jf.a aVar = (jf.a) this.f148876e.get(0);
            jf.a aVar2 = (jf.a) this.f148876e.get(1);
            d16 = aVar.f148869e;
            d17 = aVar2.f148869e;
            float f18 = aVar.f148865a;
            float f19 = aVar2.f148865a;
            Interpolator interpolator2 = aVar2.f148867c;
            if (interpolator2 != null) {
                f16 = interpolator2.getInterpolation(f16);
            }
            f17 = (f16 - f18) / (f19 - f18);
            if (this.f148877f != null) {
                return ((Number) r0.a(f17, Double.valueOf(d16), Double.valueOf(d17))).floatValue();
            }
        } else if (f16 >= 1.0f) {
            jf.a aVar3 = (jf.a) this.f148876e.get(i3 - 2);
            jf.a aVar4 = (jf.a) this.f148876e.get(this.f148872a - 1);
            d16 = aVar3.f148869e;
            d17 = aVar4.f148869e;
            float f26 = aVar3.f148865a;
            float f27 = aVar4.f148865a;
            Interpolator interpolator3 = aVar4.f148867c;
            if (interpolator3 != null) {
                f16 = interpolator3.getInterpolation(f16);
            }
            f17 = (f16 - f26) / (f27 - f26);
            if (this.f148877f != null) {
                return ((Number) r0.a(f17, Double.valueOf(d16), Double.valueOf(d17))).floatValue();
            }
        } else {
            jf.a aVar5 = (jf.a) this.f148876e.get(0);
            int i16 = 1;
            while (true) {
                if (i16 < this.f148872a) {
                    jf.a aVar6 = (jf.a) this.f148876e.get(i16);
                    if (f16 < aVar6.f148865a) {
                        Interpolator interpolator4 = aVar6.f148867c;
                        if (interpolator4 != null) {
                            f16 = interpolator4.getInterpolation(f16);
                        }
                        float f28 = aVar5.f148865a;
                        float f29 = (f16 - f28) / (aVar6.f148865a - f28);
                        double d19 = aVar5.f148869e;
                        double d26 = aVar6.f148869e;
                        return this.f148877f == null ? d19 + (f29 * (d26 - d19)) : ((Number) r4.a(f29, Double.valueOf(d19), Double.valueOf(d26))).floatValue();
                    }
                    i16++;
                    aVar5 = aVar6;
                } else {
                    return ((Number) this.f148876e.get(r3 - 1).d()).floatValue();
                }
            }
        }
        return d16 + (f17 * (d17 - d16));
    }
}
