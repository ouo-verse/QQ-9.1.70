package com.tencent.luggage.wxa.n0;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int f135065a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f135066b;

    public g() {
        this(32);
    }

    public void a(long j3) {
        int i3 = this.f135065a;
        long[] jArr = this.f135066b;
        if (i3 == jArr.length) {
            this.f135066b = Arrays.copyOf(jArr, i3 * 2);
        }
        long[] jArr2 = this.f135066b;
        int i16 = this.f135065a;
        this.f135065a = i16 + 1;
        jArr2[i16] = j3;
    }

    public g(int i3) {
        this.f135066b = new long[i3];
    }

    public long a(int i3) {
        if (i3 >= 0 && i3 < this.f135065a) {
            return this.f135066b[i3];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i3 + ", size is " + this.f135065a);
    }

    public int a() {
        return this.f135065a;
    }
}
