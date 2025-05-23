package com.tencent.luggage.wxa.tn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f141523a = false;

    public void a() {
        synchronized (this) {
            this.f141523a = false;
        }
    }

    public boolean b() {
        return this.f141523a;
    }

    public void c() {
        synchronized (this) {
            boolean z16 = this.f141523a;
            this.f141523a = true;
            if (!z16) {
                notifyAll();
            }
        }
    }

    public String toString() {
        return "MMConditionVariable[" + hashCode() + "," + b() + "]";
    }
}
