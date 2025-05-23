package com.tencent.luggage.wxa.o8;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f136231a;

    /* renamed from: b, reason: collision with root package name */
    public final long f136232b;

    /* renamed from: c, reason: collision with root package name */
    public final long f136233c;

    public c(long j3, long j16, long j17) {
        this.f136231a = j3;
        this.f136232b = j16;
        this.f136233c = j17;
    }

    public final long a() {
        return this.f136232b;
    }

    public final long b() {
        return this.f136231a;
    }

    public final long c() {
        return this.f136233c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f136231a == cVar.f136231a && this.f136232b == cVar.f136232b && this.f136233c == cVar.f136233c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.f136231a) * 31) + androidx.fragment.app.a.a(this.f136232b)) * 31) + androidx.fragment.app.a.a(this.f136233c);
    }

    public String toString() {
        return "V8RawPointer(isolatePtr=" + this.f136231a + ", contextPtr=" + this.f136232b + ", uvLoopPtr=" + this.f136233c + ')';
    }
}
