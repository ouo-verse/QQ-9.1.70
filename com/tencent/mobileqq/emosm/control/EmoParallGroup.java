package com.tencent.mobileqq.emosm.control;

import kb1.b;

/* loaded from: classes6.dex */
public class EmoParallGroup extends EmoStepGroup implements b {
    protected int K;

    @Override // kb1.b
    public synchronized void a(EmoAsyncStep emoAsyncStep, int i3) {
        int i16 = this.K - 1;
        this.K = i16;
        if (i16 == 0) {
            i(7);
            this.G = null;
        }
        this.f204260h.f(this.G);
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoAsyncStep
    protected int e() {
        this.K = this.J.length;
        while (true) {
            EmoAsyncStep n3 = n();
            if (n3 != null && this.f204258e != 8) {
                n3.f204257d = this;
                this.f204260h.g(n3);
            } else {
                return 2;
            }
        }
    }
}
