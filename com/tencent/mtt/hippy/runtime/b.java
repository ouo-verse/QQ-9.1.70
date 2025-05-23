package com.tencent.mtt.hippy.runtime;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private a[] f337565a;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        a[] aVarArr = new a[this.f337565a.length];
        int i3 = 0;
        while (true) {
            a[] aVarArr2 = this.f337565a;
            if (i3 < aVarArr2.length) {
                aVarArr[i3] = aVarArr2[i3].clone();
                i3++;
            } else {
                bVar.f337565a = aVarArr;
                return bVar;
            }
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        for (a aVar : this.f337565a) {
            sb5.append("at ");
            sb5.append(aVar.d());
            sb5.append(" (");
            sb5.append(aVar.c());
            sb5.append(":");
            sb5.append(aVar.a());
            sb5.append(":");
            sb5.append(aVar.b());
            sb5.append("\n");
        }
        int length = sb5.length() - 1;
        if (length >= 0) {
            sb5.deleteCharAt(length);
        }
        return sb5.toString();
    }
}
