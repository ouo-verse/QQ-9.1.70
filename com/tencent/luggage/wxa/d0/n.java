package com.tencent.luggage.wxa.d0;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f124048a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m.j[] f124049b;

    /* renamed from: c, reason: collision with root package name */
    public int f124050c;

    public n(com.tencent.luggage.wxa.m.j... jVarArr) {
        boolean z16;
        if (jVarArr.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        this.f124049b = jVarArr;
        this.f124048a = jVarArr.length;
    }

    public com.tencent.luggage.wxa.m.j a(int i3) {
        return this.f124049b[i3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f124048a == nVar.f124048a && Arrays.equals(this.f124049b, nVar.f124049b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f124050c == 0) {
            this.f124050c = Arrays.hashCode(this.f124049b) + 527;
        }
        return this.f124050c;
    }

    public int a(com.tencent.luggage.wxa.m.j jVar) {
        int i3 = 0;
        while (true) {
            com.tencent.luggage.wxa.m.j[] jVarArr = this.f124049b;
            if (i3 >= jVarArr.length) {
                return -1;
            }
            if (jVar == jVarArr[i3]) {
                return i3;
            }
            i3++;
        }
    }
}
