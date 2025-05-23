package com.tencent.qqperf.crashdefend;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f363090a = 0;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f363091b = new AtomicBoolean(false);

    public boolean a() {
        if (this.f363091b.get()) {
            return true;
        }
        if (this.f363090a >= 1 && this.f363090a < 1000) {
            return true;
        }
        return false;
    }

    public boolean b() {
        return this.f363091b.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        return this.f363090a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.f363091b.get()) {
            return;
        }
        this.f363090a = 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.f363091b.compareAndSet(false, true)) {
            this.f363090a = 1000;
            Log.i(getClass().getSimpleName(), "onHotFixSuccess!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i3) {
        if (!this.f363091b.get() && i3 > this.f363090a) {
            this.f363090a = i3;
        }
    }
}
