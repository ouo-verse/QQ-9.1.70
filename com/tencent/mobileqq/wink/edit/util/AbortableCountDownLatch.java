package com.tencent.mobileqq.wink.edit.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import w53.b;

/* compiled from: P */
/* loaded from: classes21.dex */
public class AbortableCountDownLatch extends CountDownLatch {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f318490a;

    /* renamed from: b, reason: collision with root package name */
    protected String f318491b;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class AbortedException extends InterruptedException {
        public AbortedException() {
        }

        public AbortedException(String str) {
            super(str);
        }
    }

    public AbortableCountDownLatch(int i3) {
        super(i3);
        this.f318490a = false;
        this.f318491b = "";
    }

    public void a() {
        b.d("AbortableCountDownLatch", "not error abort", new RuntimeException());
        if (getCount() == 0) {
            return;
        }
        this.f318490a = true;
        while (getCount() > 0) {
            countDown();
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public boolean await(long j3, TimeUnit timeUnit) throws InterruptedException {
        boolean await = super.await(j3, timeUnit);
        if (this.f318490a) {
            throw new AbortedException(this.f318491b);
        }
        return await;
    }

    public void b(String str) {
        b.d("AbortableCountDownLatch", "not error abort", new RuntimeException());
        this.f318491b = str;
        if (getCount() == 0) {
            return;
        }
        this.f318490a = true;
        while (getCount() > 0) {
            countDown();
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public void await() throws InterruptedException {
        super.await();
        if (this.f318490a) {
            throw new AbortedException(this.f318491b);
        }
    }
}
