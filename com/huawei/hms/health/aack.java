package com.huawei.hms.health;

import android.os.IInterface;
import com.huawei.hms.hihealth.HiHealthKitClient;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aack implements aaco {
    private static final Object aabi = new Object();
    private static volatile aack aabj;
    private com.huawei.hms.hihealth.aabc aab;
    private com.huawei.hms.hihealth.aabo aaba;
    private com.huawei.hms.hihealth.aabe aabb;
    private com.huawei.hms.hihealth.aabg aabc;
    private com.huawei.hms.hihealth.aabj aabd;
    private com.huawei.hms.hihealth.aabl aabe;
    private com.huawei.hms.hihealth.aabr aabf;
    private com.huawei.hms.hihealth.aabn aabg;
    private com.huawei.hms.hihealth.aabi aabh;

    aack() {
        HiHealthKitClient.getInstance().addServiceDisconnectedListener(new aacn(new WeakReference(this)));
    }

    public static aack aabf() {
        if (aabj == null) {
            synchronized (aabi) {
                if (aabj == null) {
                    aabj = new aack();
                }
            }
        }
        return aabj;
    }

    public IInterface aab(int i3) {
        if (i3 == 1) {
            return this.aabe;
        }
        if (i3 == 2) {
            return this.aab;
        }
        if (i3 == 4) {
            return this.aabc;
        }
        if (i3 == 5) {
            return this.aabf;
        }
        if (i3 == 100) {
            return this.aabh;
        }
        switch (i3) {
            case 7:
                return this.aabb;
            case 8:
                return this.aabd;
            case 9:
                return this.aabg;
            case 10:
                return this.aaba;
            default:
                aabz.aab("ControllerImpl", "unknown apiType");
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.huawei.hms.hihealth.aabg aaba() {
        return this.aabc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.huawei.hms.hihealth.aabi aabb() {
        return this.aabh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.huawei.hms.hihealth.aabj aabc() {
        return this.aabd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.huawei.hms.hihealth.aabo aabd() {
        return this.aaba;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.huawei.hms.hihealth.aabr aabe() {
        return this.aabf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.huawei.hms.hihealth.aabc aab() {
        return this.aab;
    }

    public void aab(com.huawei.hms.hihealth.aabc aabcVar) {
        this.aab = aabcVar;
    }

    public void aab(com.huawei.hms.hihealth.aabe aabeVar) {
        this.aabb = aabeVar;
    }

    public void aab(com.huawei.hms.hihealth.aabg aabgVar) {
        this.aabc = aabgVar;
    }

    public void aab(com.huawei.hms.hihealth.aabi aabiVar) {
        this.aabh = aabiVar;
    }

    public void aab(com.huawei.hms.hihealth.aabj aabjVar) {
        this.aabd = aabjVar;
    }

    public void aab(com.huawei.hms.hihealth.aabl aablVar) {
        this.aabe = aablVar;
    }

    public void aab(com.huawei.hms.hihealth.aabn aabnVar) {
        this.aabg = aabnVar;
    }

    public void aab(com.huawei.hms.hihealth.aabo aaboVar) {
        this.aaba = aaboVar;
    }

    public void aab(com.huawei.hms.hihealth.aabr aabrVar) {
        this.aabf = aabrVar;
    }
}
