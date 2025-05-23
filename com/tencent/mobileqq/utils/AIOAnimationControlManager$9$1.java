package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;

/* compiled from: P */
/* loaded from: classes20.dex */
class AIOAnimationControlManager$9$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AIOAnimationControlManager.e f306829d;

    @Override // java.lang.Runnable
    public void run() {
        try {
            TroopGiftAnimationController troopGiftAnimationController = AIOAnimationControlManager.this.D;
            if (troopGiftAnimationController != null) {
                troopGiftAnimationController.l();
            }
        } catch (Throwable unused) {
        }
        AIOAnimationControlManager.e eVar = this.f306829d;
        AIOAnimationControlManager aIOAnimationControlManager = AIOAnimationControlManager.this;
        aIOAnimationControlManager.f306804d = 1;
        aIOAnimationControlManager.B(eVar.f306836a);
    }
}
