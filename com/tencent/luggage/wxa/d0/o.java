package com.tencent.luggage.wxa.d0;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o {

    /* renamed from: d, reason: collision with root package name */
    public static final o f124051d = new o(new n[0]);

    /* renamed from: a, reason: collision with root package name */
    public final int f124052a;

    /* renamed from: b, reason: collision with root package name */
    public final n[] f124053b;

    /* renamed from: c, reason: collision with root package name */
    public int f124054c;

    public o(n... nVarArr) {
        this.f124053b = nVarArr;
        this.f124052a = nVarArr.length;
    }

    public n a(int i3) {
        return this.f124053b[i3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f124052a == oVar.f124052a && Arrays.equals(this.f124053b, oVar.f124053b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f124054c == 0) {
            this.f124054c = Arrays.hashCode(this.f124053b);
        }
        return this.f124054c;
    }

    public int a(n nVar) {
        for (int i3 = 0; i3 < this.f124052a; i3++) {
            if (this.f124053b[i3] == nVar) {
                return i3;
            }
        }
        return -1;
    }
}
