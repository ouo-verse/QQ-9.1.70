package com.tencent.mobileqq.search.util;

/* compiled from: P */
/* loaded from: classes18.dex */
public class an {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f285006a;

    public an(boolean[] zArr) {
        this.f285006a = zArr;
    }

    private void b(boolean[] zArr) {
        this.f285006a = zArr;
    }

    public boolean a(boolean[] zArr) {
        boolean[] zArr2 = this.f285006a;
        if (zArr2 == null || zArr == null || zArr.length != zArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < zArr.length; i3++) {
            if (zArr[i3] != this.f285006a[i3]) {
                b(zArr);
                return true;
            }
        }
        return false;
    }
}
