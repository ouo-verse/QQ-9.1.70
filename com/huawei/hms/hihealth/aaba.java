package com.huawei.hms.hihealth;

import com.huawei.hms.health.aabz;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class aaba extends TimerTask {
    final /* synthetic */ HiHealthKitClient aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aaba(HiHealthKitClient hiHealthKitClient) {
        this.aab = hiHealthKitClient;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        aabz.aabb("HiHealthKitClient", "disconnect delay timer task run");
        HiHealthKitClient.aabj(this.aab);
        this.aab.aabh = null;
    }
}
