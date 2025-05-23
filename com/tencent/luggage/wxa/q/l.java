package com.tencent.luggage.wxa.q;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface l {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f137771a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f137772b;

        /* renamed from: c, reason: collision with root package name */
        public final int f137773c;

        /* renamed from: d, reason: collision with root package name */
        public final int f137774d;

        public a(int i3, byte[] bArr, int i16, int i17) {
            this.f137771a = i3;
            this.f137772b = bArr;
            this.f137773c = i16;
            this.f137774d = i17;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f137771a == aVar.f137771a && this.f137773c == aVar.f137773c && this.f137774d == aVar.f137774d && Arrays.equals(this.f137772b, aVar.f137772b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f137771a * 31) + Arrays.hashCode(this.f137772b)) * 31) + this.f137773c) * 31) + this.f137774d;
        }
    }

    int a(e eVar, int i3, boolean z16);

    void a(long j3, int i3, int i16, int i17, a aVar);

    void a(com.tencent.luggage.wxa.m.j jVar);

    void a(com.tencent.luggage.wxa.n0.l lVar, int i3);
}
