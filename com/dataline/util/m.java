package com.dataline.util;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private boolean f32467a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f32468b;

    public m(boolean z16, boolean z17) {
        this.f32467a = z16;
        this.f32468b = z17;
    }

    public synchronized void a() {
        if (!this.f32467a) {
            this.f32467a = true;
        }
    }

    public boolean b(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.f32467a) {
            try {
                LockMethodProxy.sleep(1L);
            } catch (InterruptedException unused) {
            }
            if (j3 != -1 && System.currentTimeMillis() - currentTimeMillis >= j3) {
                return false;
            }
        }
        synchronized (this) {
            if (this.f32468b && this.f32467a) {
                this.f32467a = true;
            }
        }
        return true;
    }
}
