package com.tencent.gamecenter.wadl.sdk.downloader.a.e;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public long f107300a;

    /* renamed from: b, reason: collision with root package name */
    public long f107301b;

    public b(long j3, long j16) {
        this.f107300a = j3;
        this.f107301b = j16;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f107300a == bVar.f107300a && this.f107301b == bVar.f107301b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "[" + this.f107300a + "," + this.f107301b + "]";
    }
}
