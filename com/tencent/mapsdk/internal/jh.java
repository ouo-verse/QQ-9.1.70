package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jh extends jm {

    /* renamed from: b, reason: collision with root package name */
    int f148878b;

    jh(iu iuVar) {
        super(iuVar);
    }

    private void a(int i3) {
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr != null) {
            ji jiVar = jiVarArr[0];
            this.f148912l.remove(Integer.valueOf(jiVar.f148881a));
            this.f148912l.put(Integer.valueOf(i3), jiVar);
        }
        this.f148878b = i3;
    }

    private jh e(long j3) {
        super.b(j3);
        return this;
    }

    private int o() {
        return this.f148878b;
    }

    private iu p() {
        return this.f148913m;
    }

    private jh q() {
        return (jh) super.clone();
    }

    @Override // com.tencent.mapsdk.internal.jm, com.tencent.mapsdk.internal.ix
    public final /* bridge */ /* synthetic */ ix b(long j3) {
        super.b(j3);
        return this;
    }

    @Override // com.tencent.mapsdk.internal.jm, com.tencent.mapsdk.internal.ix
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (jh) super.clone();
    }

    @Override // com.tencent.mapsdk.internal.jm, com.tencent.mapsdk.internal.ix
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ ix clone() {
        return (jh) super.clone();
    }

    @Override // com.tencent.mapsdk.internal.jm
    public final String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f148913m;
        if (this.f148911k != null) {
            for (int i3 = 0; i3 < this.f148911k.length; i3++) {
                str = str + "\n    " + this.f148911k[i3].toString();
            }
        }
        return str;
    }

    jh(iu iuVar, int i3) {
        super(iuVar);
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr != null) {
            ji jiVar = jiVarArr[0];
            this.f148912l.remove(Integer.valueOf(jiVar.f148881a));
            this.f148912l.put(Integer.valueOf(i3), jiVar);
        }
        this.f148878b = i3;
    }

    public static jh a(iu iuVar, int... iArr) {
        jh jhVar = new jh(iuVar, 0);
        jhVar.a(iArr);
        return jhVar;
    }

    public static jh a(iu iuVar, int i3, double... dArr) {
        jh jhVar = new jh(iuVar, i3);
        jhVar.a(dArr);
        return jhVar;
    }

    public static jh a(iu iuVar, jl jlVar, Object[] objArr) {
        jh jhVar = new jh(iuVar, 1);
        jhVar.a(objArr);
        jhVar.a((jl<?>) jlVar);
        return jhVar;
    }

    private static jh a(iu iuVar, ji... jiVarArr) {
        jh jhVar = new jh(iuVar);
        jhVar.a(jiVarArr);
        return jhVar;
    }

    @Override // com.tencent.mapsdk.internal.jm
    public final void a(int... iArr) {
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr == null || jiVarArr.length == 0) {
            a(ji.a(this.f148878b, iArr));
        } else {
            super.a(iArr);
        }
    }

    @Override // com.tencent.mapsdk.internal.jm
    public final void a(double... dArr) {
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr == null || jiVarArr.length == 0) {
            a(ji.a(this.f148878b, dArr));
        } else {
            super.a(dArr);
        }
    }

    @Override // com.tencent.mapsdk.internal.jm
    public final void a(Object... objArr) {
        ji[] jiVarArr = this.f148911k;
        if (jiVarArr == null || jiVarArr.length == 0) {
            a(ji.a(this.f148878b, objArr));
        } else {
            super.a(objArr);
        }
    }
}
