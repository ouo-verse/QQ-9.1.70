package com.huawei.hms.health;

import com.huawei.hms.health.aaco;
import com.huawei.hms.hihealth.HiHealthKitClient;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacn<R extends aaco> implements HiHealthKitClient.aabg {
    private WeakReference<R> aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aacn(WeakReference<R> weakReference) {
        this.aab = weakReference;
    }

    public void aab() {
        WeakReference<R> weakReference = this.aab;
        if (weakReference == null) {
            aabz.aab("HealthServiceDisconnectedListener", "mWeakReference is null");
            return;
        }
        R r16 = weakReference.get();
        if (r16 != null) {
            aack aackVar = (aack) r16;
            aackVar.aab((com.huawei.hms.hihealth.aabl) null);
            aackVar.aab((com.huawei.hms.hihealth.aabc) null);
            aackVar.aab((com.huawei.hms.hihealth.aabg) null);
            aackVar.aab((com.huawei.hms.hihealth.aabr) null);
            aackVar.aab((com.huawei.hms.hihealth.aabe) null);
            aackVar.aab((com.huawei.hms.hihealth.aabj) null);
            aackVar.aab((com.huawei.hms.hihealth.aabn) null);
            aackVar.aab((com.huawei.hms.hihealth.aabi) null);
            aackVar.aab((com.huawei.hms.hihealth.aabo) null);
            aabz.aabb("ControllerImpl", "clearBinder");
        }
    }
}
