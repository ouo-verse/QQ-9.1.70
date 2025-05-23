package com.tencent.mobileqq.emosm.control;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoLinearGroup extends EmoStepGroup {
    @Override // com.tencent.mobileqq.emosm.control.EmoAsyncStep
    protected int e() {
        EmoAsyncStep n3;
        while (this.f204258e != 8 && (n3 = n()) != null) {
            n3.run();
        }
        return 7;
    }
}
