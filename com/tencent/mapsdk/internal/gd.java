package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gd {

    /* renamed from: a, reason: collision with root package name */
    public ge f148475a;

    /* renamed from: b, reason: collision with root package name */
    public ge[] f148476b;

    /* renamed from: c, reason: collision with root package name */
    public float f148477c;

    public gd(ge geVar, ge[] geVarArr, float f16) {
        this.f148475a = geVar;
        this.f148476b = geVarArr;
        this.f148477c = f16;
    }

    private ge b() {
        return this.f148475a;
    }

    private ge[] c() {
        return this.f148476b;
    }

    private float d() {
        return this.f148477c;
    }

    public final void a(ge geVar, ge[] geVarArr, float f16) {
        this.f148475a = geVar;
        this.f148476b = geVarArr;
        this.f148477c = f16;
    }

    public final boolean a(gd gdVar) {
        ge[] geVarArr;
        ge geVar;
        if (gdVar == null || Float.compare(gdVar.f148477c, this.f148477c) > 0) {
            return true;
        }
        ge geVar2 = this.f148475a;
        if (geVar2 != null && (geVar = gdVar.f148475a) != null && lj.a(geVar2, geVar) > 50.0d) {
            return true;
        }
        ge[] geVarArr2 = this.f148476b;
        if (geVarArr2 != null && (geVarArr = gdVar.f148476b) != null && geVarArr2.length == geVarArr.length) {
            int i3 = 0;
            while (true) {
                ge[] geVarArr3 = this.f148476b;
                if (i3 >= geVarArr3.length) {
                    break;
                }
                if (lj.a(geVarArr3[i3], gdVar.f148476b[i3]) > 50.0d) {
                    return true;
                }
                i3++;
            }
        }
        return false;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final gd clone() {
        return new gd(this.f148475a, this.f148476b, this.f148477c);
    }
}
