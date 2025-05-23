package com.tencent.mobileqq.shortvideo.util;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
class NativeSoLoader$1 implements Runnable {
    NativeSoLoader$1() {
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        atomicBoolean = e.f288251c;
        if (!atomicBoolean.get()) {
            boolean c16 = e.c("TKGLRenderer");
            atomicBoolean2 = e.f288251c;
            atomicBoolean2.getAndSet(c16);
        }
    }
}
