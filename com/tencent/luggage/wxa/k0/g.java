package com.tencent.luggage.wxa.k0;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f131405a;

    /* renamed from: b, reason: collision with root package name */
    public final f[] f131406b;

    /* renamed from: c, reason: collision with root package name */
    public int f131407c;

    public g(f... fVarArr) {
        this.f131406b = fVarArr;
        this.f131405a = fVarArr.length;
    }

    public f a(int i3) {
        return this.f131406b[i3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            return Arrays.equals(this.f131406b, ((g) obj).f131406b);
        }
        return false;
    }

    public int hashCode() {
        if (this.f131407c == 0) {
            this.f131407c = Arrays.hashCode(this.f131406b) + 527;
        }
        return this.f131407c;
    }

    public f[] a() {
        return (f[]) this.f131406b.clone();
    }
}
