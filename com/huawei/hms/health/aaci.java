package com.huawei.hms.health;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hihealth.HiHealthKitClient;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.data.HealthKitApiInvoker;
import com.huawei.hms.hihealth.data.HealthKitApiResult;
import com.huawei.hms.hihealth.options.aabb;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.utils.Util;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aaci {
    private static volatile aaci aabk;
    private static volatile HealthKitApiInvoker aabl;
    private long aab;
    private com.huawei.hms.hihealth.data.aab aaba;
    private com.huawei.hms.hihealth.data.aaba aabe;
    private int aabf;
    private long aabg;
    private long aabh;
    private long aabj;
    private Map<String, com.huawei.hms.hihealth.data.aabb> aabb = new HashMap();
    private Map<String, Pair<String, Long>> aabc = new HashMap();
    private Map<String, Long> aabd = new HashMap();
    private int aabi = -1;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aab extends aabb.aab {
        private CountDownLatch aab;
        private List<String> aaba;

        aab(@NonNull CountDownLatch countDownLatch, @NonNull List<String> list) {
            this.aab = countDownLatch;
            this.aaba = list;
        }

        public void aab(List list, int i3, int i16, int i17) throws RemoteException {
            String str;
            aabz.aabb("CommonMethodImpl", "onTransmissionResult enter");
            if (i3 == 3) {
                aabz.aabb("CommonMethodImpl", "transfer complete");
                this.aab.countDown();
                return;
            }
            if (list != null && !list.isEmpty()) {
                Object obj = list.get(0);
                if (i3 != 1) {
                    if (i3 != 2) {
                        str = "unknown transmissionType" + i3;
                    } else {
                        if (obj instanceof String) {
                            this.aaba.add((String) obj);
                        }
                        this.aab.countDown();
                        str = "transmission complete no need slice";
                    }
                    aabz.aabb("CommonMethodImpl", str);
                    return;
                }
                StringBuilder aab = com.huawei.hms.health.aab.aab("transmission slice get:");
                aab.append(System.currentTimeMillis());
                aabz.aabb("CommonMethodImpl", aab.toString());
                if (obj instanceof String) {
                    this.aaba.add((String) obj);
                }
            }
        }
    }

    @NonNull
    private String aabc(HealthKitApiInvoker healthKitApiInvoker) {
        return healthKitApiInvoker.getInterfaceProvider() + "." + healthKitApiInvoker.getInterfaceInvoked();
    }

    private void aabd() {
        long j3 = this.aab;
        if (j3 == 0 || aacu.aab(j3, 86400000L)) {
            StringBuilder aab2 = com.huawei.hms.health.aab.aab("init InterfacePolicy, last time ");
            aab2.append(this.aab);
            aabz.aabb("CommonMethodImpl", aab2.toString());
            aacr.aabg().aabd().addOnSuccessListener(new OnSuccessListener() { // from class: com.huawei.hms.health.h
                @Override // com.huawei.hmf.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    aaci.this.aab((com.huawei.hms.hihealth.data.aabc) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.hms.health.i
                @Override // com.huawei.hmf.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    aabz.aabc("CommonMethodImpl", "init InterfacePolicy fail");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String aab(HealthKitApiInvoker healthKitApiInvoker) throws RemoteException, ApiException {
        return aaba(healthKitApiInvoker, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HealthKitApiInvoker aaba() {
        return aabl;
    }

    public int aabb() {
        com.huawei.hms.hihealth.data.aab aabVar = this.aaba;
        if (aabVar == null || aabVar.aab() == -1 || this.aaba.aab() == 0) {
            return 30000;
        }
        return this.aaba.aab();
    }

    @NonNull
    private String aabb(HealthKitApiInvoker healthKitApiInvoker) {
        return healthKitApiInvoker.getInterfaceProvider() + healthKitApiInvoker.getInterfaceInvoked() + healthKitApiInvoker.getRequestBody().hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[Catch: all -> 0x009b, TryCatch #3 {, blocks: (B:6:0x0007, B:8:0x000b, B:28:0x002e, B:31:0x0035, B:11:0x0059, B:13:0x0068, B:16:0x006f, B:18:0x0073, B:20:0x007f, B:21:0x0096, B:24:0x0088, B:34:0x004b, B:36:0x0099), top: B:5:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[Catch: RuntimeException -> 0x0082, NameNotFoundException -> 0x008c, all -> 0x009b, TRY_LEAVE, TryCatch #3 {, blocks: (B:6:0x0007, B:8:0x000b, B:28:0x002e, B:31:0x0035, B:11:0x0059, B:13:0x0068, B:16:0x006f, B:18:0x0073, B:20:0x007f, B:21:0x0096, B:24:0x0088, B:34:0x004b, B:36:0x0099), top: B:5:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static aaci aabc() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        PackageInfo packageInfo;
        if (aabk == null) {
            synchronized (aaci.class) {
                if (aabk == null) {
                    aabk = new aaci();
                    aabl = new HealthKitApiInvoker();
                    Context context = HiHealthKitClient.getInstance().getContext();
                    aabl.setAppId(Util.getAppId(context));
                    HealthKitApiInvoker healthKitApiInvoker = aabl;
                    if (context != null) {
                        try {
                        } catch (PackageManager.NameNotFoundException unused) {
                            str = "PackageManagerUtil";
                            str2 = "can not find PackageManager";
                            aabz.aab(str, str2);
                            str3 = "";
                            healthKitApiInvoker.setPackageName(str3);
                            aabl.setSdkVersion("6.11.0.303");
                            HealthKitApiInvoker healthKitApiInvoker2 = aabl;
                            if (context != null) {
                            }
                            str4 = "";
                            healthKitApiInvoker2.setAppVersion(str4);
                            return aabk;
                        } catch (Exception unused2) {
                            str = "PackageManagerUtil";
                            str2 = "catch basic exception";
                            aabz.aab(str, str2);
                            str3 = "";
                            healthKitApiInvoker.setPackageName(str3);
                            aabl.setSdkVersion("6.11.0.303");
                            HealthKitApiInvoker healthKitApiInvoker22 = aabl;
                            if (context != null) {
                            }
                            str4 = "";
                            healthKitApiInvoker22.setAppVersion(str4);
                            return aabk;
                        }
                        if (context.getPackageManager() != null) {
                            str3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).packageName;
                            healthKitApiInvoker.setPackageName(str3);
                            aabl.setSdkVersion("6.11.0.303");
                            HealthKitApiInvoker healthKitApiInvoker222 = aabl;
                            if (context != null && context.getPackageManager() != null) {
                                try {
                                    packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384);
                                } catch (PackageManager.NameNotFoundException unused3) {
                                    str5 = "PackageManagerUtil";
                                    str6 = "getAppVersion NameNotFoundException";
                                    aabz.aab(str5, str6);
                                    str4 = "";
                                    healthKitApiInvoker222.setAppVersion(str4);
                                    return aabk;
                                } catch (RuntimeException unused4) {
                                    str5 = "PackageManagerUtil";
                                    str6 = "getPackageInfo exists exception!";
                                    aabz.aab(str5, str6);
                                    str4 = "";
                                    healthKitApiInvoker222.setAppVersion(str4);
                                    return aabk;
                                }
                                if (packageInfo != null) {
                                    str4 = packageInfo.versionName;
                                    healthKitApiInvoker222.setAppVersion(str4);
                                }
                            }
                            str4 = "";
                            healthKitApiInvoker222.setAppVersion(str4);
                        }
                    }
                    str3 = "";
                    healthKitApiInvoker.setPackageName(str3);
                    aabl.setSdkVersion("6.11.0.303");
                    HealthKitApiInvoker healthKitApiInvoker2222 = aabl;
                    if (context != null) {
                        packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384);
                        if (packageInfo != null) {
                        }
                    }
                    str4 = "";
                    healthKitApiInvoker2222.setAppVersion(str4);
                }
            }
        }
        return aabk;
    }

    public void aab() {
        this.aabc.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String aaba(HealthKitApiInvoker healthKitApiInvoker) throws RemoteException, ApiException {
        aabz.aabb("CommonMethodImpl", "invoke read interface");
        return aaba(healthKitApiInvoker, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0129 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String aaba(HealthKitApiInvoker healthKitApiInvoker, boolean z16) throws RemoteException, ApiException {
        String str;
        String str2;
        Pair<String, Long> pair;
        com.huawei.hms.hihealth.data.aab aabVar;
        if (healthKitApiInvoker == null) {
            throw new SecurityException(String.valueOf(HiHealthStatusCodes.INPUT_PARAM_MISSING));
        }
        String aabc = aabc(healthKitApiInvoker);
        aabz.aabb("CommonMethodImpl", "invoke with policy " + aabc + " " + z16);
        Context context = HiHealthKitClient.getInstance().getContext();
        if (context == null || (aabVar = this.aaba) == null || aabz.aab(aabVar.aaba()).booleanValue()) {
            aabz.aabb("CommonMethodImpl", "bgLimitPolicy empty");
        } else if (!this.aaba.aaba().contains(aabc)) {
            aabz.aabb("CommonMethodImpl", "interface not in bgLimitPolicy");
        } else {
            if (aacu.aabb(context)) {
                aabz.aab("CommonMethodImpl", "the phone is screen off or locked");
                throw new SecurityException(String.valueOf(HiHealthStatusCodes.DISABLE_DATA_OPERATION));
            }
            if (aacu.aab(context)) {
                long j3 = this.aabj;
                if (j3 != -1 && System.currentTimeMillis() - j3 <= TimeUnit.MILLISECONDS.convert((long) this.aaba.aabb(), TimeUnit.SECONDS)) {
                    StringBuilder aab2 = com.huawei.hms.health.aab.aab("background app can not invoke read apis in ");
                    aab2.append(this.aaba.aabb());
                    aabz.aab("CommonMethodImpl", aab2.toString());
                    throw new SecurityException(String.valueOf(HiHealthStatusCodes.APPLICATION_NOT_FORGROUND));
                }
                this.aabj = System.currentTimeMillis();
            }
        }
        if (this.aabb.get(aabc(healthKitApiInvoker)) != null) {
            String aabb = aabb(healthKitApiInvoker);
            if (!aab(healthKitApiInvoker, aabb) && (pair = this.aabc.get(aabb)) != null && !aacu.aab(((Long) pair.second).longValue(), TimeUnit.MILLISECONDS.convert(r0.aab(), TimeUnit.SECONDS))) {
                StringBuilder aab3 = com.huawei.hms.health.aab.aab("get cache result within ");
                aab3.append(pair.second);
                aabz.aabb("CommonMethodImpl", aab3.toString());
                str = (String) pair.first;
                if (str == null) {
                    return str;
                }
                com.huawei.hms.hihealth.data.aaba aabaVar = this.aabe;
                try {
                    if (aabaVar == null || aabaVar.aaba() == 0) {
                        str2 = "flowPolicy is empty";
                    } else {
                        com.huawei.hms.health.aab.aab("do flow policy countBeginTime ").append(this.aabg);
                        long j16 = this.aabg;
                        if (j16 != 0 && !aacu.aab(j16, TimeUnit.MILLISECONDS.convert(this.aabe.aabb(), TimeUnit.SECONDS))) {
                            this.aabf++;
                            com.huawei.hms.health.aab.aab("do flow policy countBeginTime flowCount ").append(this.aabf);
                            if (this.aabf > this.aabe.aaba()) {
                                if (this.aabi == -1) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    this.aabg = currentTimeMillis;
                                    this.aabh = currentTimeMillis;
                                    this.aabi = 0;
                                    StringBuilder aab4 = com.huawei.hms.health.aab.aab("flow policy invoke at ");
                                    aab4.append(this.aabg);
                                    aab4.append(" with ");
                                    aab4.append(this.aabf);
                                    aabz.aabb("CommonMethodImpl", aab4.toString());
                                }
                                if (aacu.aab(this.aabh, 10000L)) {
                                    this.aabh = System.currentTimeMillis();
                                    this.aabi = 0;
                                }
                                int i3 = this.aabi + 1;
                                this.aabi = i3;
                                if (i3 > this.aabe.aab()) {
                                    StringBuilder aab5 = com.huawei.hms.health.aab.aab("flow policy limit effect ");
                                    aab5.append(this.aabi);
                                    aabz.aabb("CommonMethodImpl", aab5.toString());
                                    throw new ApiException(new Status(HiHealthStatusCodes.API_FLOW_LIMIT, String.format(Locale.ENGLISH, "Interface calls are too frequent, more than %d calls in %d second, triggering flow control, and only %d calls in the next 10s", Integer.valueOf(this.aabe.aaba()), Integer.valueOf(this.aabe.aabb()), Integer.valueOf(this.aabe.aab()))));
                                }
                            }
                            String aab6 = aab(healthKitApiInvoker, z16);
                            aaba(healthKitApiInvoker, aab6);
                            return aab6;
                        }
                        this.aabf = 1;
                        this.aabi = -1;
                        this.aabg = System.currentTimeMillis();
                        StringBuilder aab7 = com.huawei.hms.health.aab.aab("init flow policy countBeginTime ");
                        aab7.append(this.aabg);
                        str2 = aab7.toString();
                    }
                    String aab62 = aab(healthKitApiInvoker, z16);
                    aaba(healthKitApiInvoker, aab62);
                    return aab62;
                } finally {
                    aabd();
                }
                aabz.aabb("CommonMethodImpl", str2);
            }
        }
        str = null;
        if (str == null) {
        }
    }

    @Nullable
    private String aab(HealthKitApiInvoker healthKitApiInvoker, boolean z16) throws RemoteException, ApiException {
        boolean z17;
        if (HiHealthKitClient.getInstance().bindService(100) == null) {
            throw new ApiException(new Status(50011, "the client is not connected"));
        }
        if (z16) {
            String aab2 = aacu.aab(healthKitApiInvoker);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ArrayList arrayList = new ArrayList();
            aack.aabf().aabb().aab(aab2, new aab(countDownLatch, arrayList));
            try {
                z17 = countDownLatch.await(1L, TimeUnit.MINUTES);
            } catch (InterruptedException unused) {
                aabz.aab("CommonMethodImpl", "invokeReadInterface interruptedException");
                z17 = false;
            }
            String str = null;
            if (!z17) {
                aabz.aab("CommonMethodImpl", "invokeReadInterface time Out");
                return null;
            }
            if (arrayList.isEmpty()) {
                aabz.aabc("CommonMethodImpl", "build result fail for return empty body");
            } else {
                StringBuilder sb5 = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb5.append((String) it.next());
                }
                aabz.aabb("CommonMethodImpl", "build result by StringBuilder appending");
                str = sb5.toString();
            }
            HealthKitApiResult healthKitApiResult = (HealthKitApiResult) aacu.aab(str, (Type) HealthKitApiResult.class);
            if (healthKitApiResult != null) {
                return healthKitApiResult.isResultGzipped() ? aacu.aabd(healthKitApiResult.getResponse()) : healthKitApiResult.getResponse();
            }
            aabz.aab("CommonMethodImpl", "result from core is null");
            return "";
        }
        HealthKitApiResult healthKitApiResult2 = (HealthKitApiResult) aacu.aab(aack.aabf().aabb().aabb(aacu.aab(healthKitApiInvoker)), (Type) HealthKitApiResult.class);
        if (healthKitApiResult2 == null) {
            aabz.aab("CommonMethodImpl", "result from core is null");
            return "";
        }
        if (!healthKitApiResult2.isResultGzipped()) {
            return healthKitApiResult2.getResponse();
        }
        StringBuilder aab3 = com.huawei.hms.health.aab.aab("the result length from core is ");
        aab3.append(healthKitApiResult2.getResponse().length());
        aabz.aab("CommonMethodImpl", aab3.toString());
        return aacu.aabd(healthKitApiResult2.getResponse());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aab(com.huawei.hms.hihealth.data.aabc aabcVar) {
        Objects.toString(aabcVar);
        if (aabcVar == null) {
            return;
        }
        this.aab = System.currentTimeMillis();
        this.aaba = aabcVar.aab();
        if (aabz.aaba(aabcVar.aaba()).booleanValue()) {
            for (com.huawei.hms.hihealth.data.aabb aabbVar : aabcVar.aaba()) {
                this.aabb.put(aabbVar.aaba(), aabbVar);
            }
        }
        this.aabe = aabcVar.aabb();
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.aaba != null);
        objArr[1] = Integer.valueOf(this.aabb.size());
        objArr[2] = Boolean.valueOf(this.aabe != null);
        Log.i("HmsHealth_kit CommonMethodImpl", aacu.aab("getInterfacePolicy success bgLimit %s, cachePolicy size %s, flow %s", objArr));
    }

    private boolean aab(HealthKitApiInvoker healthKitApiInvoker, String str) {
        int i3;
        boolean z16 = false;
        if (!"AuthController".equals(healthKitApiInvoker.getInterfaceProvider())) {
            return false;
        }
        Long l3 = this.aabd.get(str);
        if (l3 != null) {
            long longValue = l3.longValue();
            com.huawei.hms.hihealth.data.aabb aabbVar = this.aabb.get(aacu.aab("AuthController", "TIME_WINDOW"));
            if (aabbVar != null) {
                aabz.aabb("CommonMethodImpl", "getInvokeTimeWindow with timeWindowPolicy");
                i3 = aabbVar.aab();
            } else {
                aabz.aabb("CommonMethodImpl", "getInvokeTimeWindow with default TimeWindow");
                i3 = 10500;
            }
            if (aacu.aab(longValue, i3)) {
                z16 = true;
            }
        }
        aabz.aabb("CommonMethodImpl", "timeWindow lastTime " + l3 + " result " + z16);
        this.aabd.put(str, Long.valueOf(System.currentTimeMillis()));
        return z16;
    }

    private void aaba(HealthKitApiInvoker healthKitApiInvoker, String str) {
        if (this.aabb.get(aabc(healthKitApiInvoker)) != null) {
            String aabb = aabb(healthKitApiInvoker);
            if (!("AuthController".equals(healthKitApiInvoker.getInterfaceProvider()) && (TextUtils.isEmpty(str) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str)))) {
                this.aabc.put(aabb, new Pair<>(str, Long.valueOf(System.currentTimeMillis())));
            } else {
                aabz.aabb("CommonMethodImpl", "skip cache empty result, and clear cache");
                this.aabc.remove(aabb);
            }
        }
    }
}
