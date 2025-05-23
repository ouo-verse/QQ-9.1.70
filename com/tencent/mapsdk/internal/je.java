package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.jf;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class je extends jg {

    /* renamed from: g, reason: collision with root package name */
    private int f148861g;

    /* renamed from: h, reason: collision with root package name */
    private int f148862h;

    /* renamed from: i, reason: collision with root package name */
    private int f148863i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f148864j;

    public je(jf.b... bVarArr) {
        super(bVarArr);
        this.f148864j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tencent.mapsdk.internal.jg
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public je clone() {
        ArrayList<jf> arrayList = this.f148876e;
        int size = arrayList.size();
        jf.b[] bVarArr = new jf.b[size];
        for (int i3 = 0; i3 < size; i3++) {
            bVarArr[i3] = (jf.b) arrayList.get(i3).e();
        }
        return new je(bVarArr);
    }

    @Override // com.tencent.mapsdk.internal.jg
    public final Object a(float f16) {
        return Integer.valueOf(b(f16));
    }

    public final int b(float f16) {
        int i3;
        int i16;
        int i17;
        int i18;
        float f17;
        int i19 = this.f148872a;
        if (i19 != 2) {
            if (f16 <= 0.0f) {
                jf.b bVar = (jf.b) this.f148876e.get(0);
                jf.b bVar2 = (jf.b) this.f148876e.get(1);
                i17 = bVar.f148870e;
                i18 = bVar2.f148870e;
                float f18 = bVar.f148865a;
                float f19 = bVar2.f148865a;
                Interpolator interpolator = bVar2.f148867c;
                if (interpolator != null) {
                    f16 = interpolator.getInterpolation(f16);
                }
                f17 = (f16 - f18) / (f19 - f18);
                jl jlVar = this.f148877f;
                if (jlVar != null) {
                    return ((Number) jlVar.a(f17, Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
                }
            } else if (f16 >= 1.0f) {
                jf.b bVar3 = (jf.b) this.f148876e.get(i19 - 2);
                jf.b bVar4 = (jf.b) this.f148876e.get(this.f148872a - 1);
                i17 = bVar3.f148870e;
                i18 = bVar4.f148870e;
                float f26 = bVar3.f148865a;
                float f27 = bVar4.f148865a;
                Interpolator interpolator2 = bVar4.f148867c;
                if (interpolator2 != null) {
                    f16 = interpolator2.getInterpolation(f16);
                }
                f17 = (f16 - f26) / (f27 - f26);
                jl jlVar2 = this.f148877f;
                if (jlVar2 != null) {
                    return ((Number) jlVar2.a(f17, Integer.valueOf(i17), Integer.valueOf(i18))).intValue();
                }
            } else {
                jf.b bVar5 = (jf.b) this.f148876e.get(0);
                int i26 = 1;
                while (true) {
                    int i27 = this.f148872a;
                    if (i26 < i27) {
                        jf.b bVar6 = (jf.b) this.f148876e.get(i26);
                        if (f16 < bVar6.f148865a) {
                            Interpolator interpolator3 = bVar6.f148867c;
                            if (interpolator3 != null) {
                                f16 = interpolator3.getInterpolation(f16);
                            }
                            float f28 = bVar5.f148865a;
                            f16 = (f16 - f28) / (bVar6.f148865a - f28);
                            i3 = bVar5.f148870e;
                            int i28 = bVar6.f148870e;
                            jl jlVar3 = this.f148877f;
                            if (jlVar3 != null) {
                                return ((Number) jlVar3.a(f16, Integer.valueOf(i3), Integer.valueOf(i28))).intValue();
                            }
                            i16 = i28 - i3;
                        } else {
                            i26++;
                            bVar5 = bVar6;
                        }
                    } else {
                        return ((Number) this.f148876e.get(i27 - 1).d()).intValue();
                    }
                }
            }
            return i17 + ((int) (f17 * (i18 - i17)));
        }
        if (this.f148864j) {
            this.f148864j = false;
            this.f148861g = ((jf.b) this.f148876e.get(0)).f148870e;
            int i29 = ((jf.b) this.f148876e.get(1)).f148870e;
            this.f148862h = i29;
            this.f148863i = i29 - this.f148861g;
        }
        Interpolator interpolator4 = this.f148875d;
        if (interpolator4 != null) {
            f16 = interpolator4.getInterpolation(f16);
        }
        jl jlVar4 = this.f148877f;
        if (jlVar4 == null) {
            i3 = this.f148861g;
            i16 = this.f148863i;
        } else {
            return ((Number) jlVar4.a(f16, Integer.valueOf(this.f148861g), Integer.valueOf(this.f148862h))).intValue();
        }
        return i3 + ((int) (f16 * i16));
    }
}
