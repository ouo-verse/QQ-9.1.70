package com.tencent.av.app;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s extends e {

    /* renamed from: d, reason: collision with root package name */
    protected long f73208d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected int f73209e = 0;

    public int a() {
        return this.f73209e;
    }

    public long b() {
        return this.f73208d;
    }

    public void c(int i3) {
        this.f73209e = i3;
    }

    public void d(long j3) {
        QLog.i("SessionInfoBase", 1, "setRoomId old room id[" + this.f73208d + "], new room id[" + j3 + "].");
        this.f73208d = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f73208d == ((s) obj).f73208d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j3 = this.f73208d;
        return (int) (j3 ^ (j3 >>> 32));
    }
}
