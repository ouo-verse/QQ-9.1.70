package com.huawei.hms.health;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.hihealth.data.CommonRequest;
import com.huawei.hms.hihealth.data.HealthKitApiInvoker;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacg {
    private static volatile aacg aab;
    private static volatile HealthKitApiInvoker aaba;

    public Task<List<String>> aab(final String str) {
        aabz.aabb("AuthManagerImpl", "enter queryAuthInfoByAppId");
        final HealthKitApiInvoker healthKitApiInvoker = new HealthKitApiInvoker(aaba);
        return aacs.aab(new Callable() { // from class: com.huawei.hms.health.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List aab2;
                aab2 = aacg.aab(HealthKitApiInvoker.this, str);
                return aab2;
            }
        });
    }

    public Task<List<String>> aaba(final String str) {
        aabz.aabb("AuthManagerImpl", "enter queryAuthInfoByPkgName");
        final HealthKitApiInvoker healthKitApiInvoker = new HealthKitApiInvoker(aaba);
        return aacs.aab(new Callable() { // from class: com.huawei.hms.health.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List aaba2;
                aaba2 = aacg.aaba(HealthKitApiInvoker.this, str);
                return aaba2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List aaba(HealthKitApiInvoker healthKitApiInvoker, String str) throws Exception {
        healthKitApiInvoker.setInterfaceProvider("AuthController");
        healthKitApiInvoker.setInterfaceInvoked("queryAuthInfoByPkgName");
        healthKitApiInvoker.setRequestBody(str);
        return aacu.aab(aaci.aabc().aab(healthKitApiInvoker), String.class);
    }

    public Task<String> aab(final String str, final String str2) {
        aabz.aabb("AuthManagerImpl", "enter checkFingerprint");
        final HealthKitApiInvoker healthKitApiInvoker = new HealthKitApiInvoker(aaba);
        return aacs.aab(new Callable() { // from class: com.huawei.hms.health.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String aab2;
                aab2 = aacg.aab(HealthKitApiInvoker.this, str, str2);
                return aab2;
            }
        });
    }

    public static aacg aab() {
        if (aab == null) {
            synchronized (aacg.class) {
                if (aab == null) {
                    aab = new aacg();
                    aaba = aaci.aabc().aaba();
                }
            }
        }
        return aab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String aab(HealthKitApiInvoker healthKitApiInvoker, String str, String str2) throws Exception {
        healthKitApiInvoker.setInterfaceProvider("AuthController");
        healthKitApiInvoker.setInterfaceInvoked("checkFingerprint");
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setAppId(str);
        commonRequest.setPkgName(str2);
        healthKitApiInvoker.setRequestBody(aacu.aab(commonRequest));
        return aaci.aabc().aab(healthKitApiInvoker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List aab(HealthKitApiInvoker healthKitApiInvoker, String str) throws Exception {
        healthKitApiInvoker.setInterfaceProvider("AuthController");
        healthKitApiInvoker.setInterfaceInvoked("queryAuthInfoByAppId");
        healthKitApiInvoker.setRequestBody(str);
        return aacu.aab(aaci.aabc().aab(healthKitApiInvoker), String.class);
    }
}
