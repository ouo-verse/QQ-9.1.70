package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HMSPackageManager {

    /* renamed from: n, reason: collision with root package name */
    private static HMSPackageManager f37679n;

    /* renamed from: o, reason: collision with root package name */
    private static final Object f37680o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private static final Object f37681p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static final Object f37682q = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f37683a;

    /* renamed from: b, reason: collision with root package name */
    private final PackageManagerHelper f37684b;

    /* renamed from: c, reason: collision with root package name */
    private String f37685c;

    /* renamed from: d, reason: collision with root package name */
    private String f37686d;

    /* renamed from: e, reason: collision with root package name */
    private int f37687e;

    /* renamed from: f, reason: collision with root package name */
    private String f37688f;

    /* renamed from: g, reason: collision with root package name */
    private String f37689g;

    /* renamed from: h, reason: collision with root package name */
    private String f37690h;

    /* renamed from: i, reason: collision with root package name */
    private String f37691i;

    /* renamed from: j, reason: collision with root package name */
    private int f37692j;

    /* renamed from: k, reason: collision with root package name */
    private int f37693k;

    /* renamed from: l, reason: collision with root package name */
    private long f37694l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f37695m;

    /* loaded from: classes2.dex */
    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* renamed from: a, reason: collision with root package name */
        private String f37696a;

        /* renamed from: b, reason: collision with root package name */
        private String f37697b;

        /* renamed from: c, reason: collision with root package name */
        private String f37698c;

        /* renamed from: d, reason: collision with root package name */
        private String f37699d;

        /* renamed from: e, reason: collision with root package name */
        private String f37700e;

        /* renamed from: f, reason: collision with root package name */
        private Long f37701f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j3) {
            this.f37696a = str;
            this.f37697b = str2;
            this.f37698c = str3;
            this.f37699d = str4;
            this.f37700e = str5;
            this.f37701f = Long.valueOf(j3);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            if (TextUtils.equals(this.f37700e, packagePriorityInfo.f37700e)) {
                return this.f37701f.compareTo(packagePriorityInfo.f37701f);
            }
            return this.f37700e.compareTo(packagePriorityInfo.f37700e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(HMSPackageManager.this.f37683a.getPackageManager(), new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (queryIntentServices != null && queryIntentServices.size() != 0) {
                    Iterator<ResolveInfo> it = queryIntentServices.iterator();
                    while (it.hasNext()) {
                        if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                            HMSPackageManager.this.c();
                        }
                    }
                    HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
                }
            } catch (Exception e16) {
                HMSLog.e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e16.getMessage());
            }
        }
    }

    HMSPackageManager(Context context) {
        this.f37683a = context;
        this.f37684b = new PackageManagerHelper(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[Catch: all -> 0x007f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x001b, B:11:0x0027, B:12:0x0047, B:15:0x0049, B:18:0x0050, B:19:0x007b), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: all -> 0x007f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x001b, B:11:0x0027, B:12:0x0047, B:15:0x0049, B:18:0x0050, B:19:0x007b), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c() {
        boolean z16;
        synchronized (f37682q) {
            HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
            long packageFirstInstallTime = this.f37684b.getPackageFirstInstallTime("com.huawei.hwid");
            int i3 = 1;
            if (this.f37693k != 3 && this.f37694l == packageFirstInstallTime) {
                z16 = false;
                if (z16) {
                    HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.f37693k));
                    return this.f37693k;
                }
                if (b()) {
                    i3 = 2;
                }
                this.f37693k = i3;
                this.f37694l = this.f37684b.getPackageFirstInstallTime("com.huawei.hwid");
                HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.f37693k));
                return this.f37693k;
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    private void d() {
        synchronized (f37681p) {
            this.f37688f = null;
            this.f37689g = null;
            this.f37690h = null;
            this.f37691i = null;
            this.f37692j = 0;
        }
    }

    private void e() {
        synchronized (f37681p) {
            this.f37685c = null;
            this.f37686d = null;
            this.f37687e = 0;
        }
    }

    private Pair<String, String> f() {
        try {
            List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(this.f37683a.getPackageManager(), new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                    String packageSignature = this.f37684b.getPackageSignature(str);
                    if ("com.huawei.hwid".equals(str) && this.f37684b.getPackageVersionCode(str) < 30000000) {
                        return new Pair<>(str, packageSignature);
                    }
                    Bundle bundle = resolveInfo.serviceInfo.metaData;
                    if (bundle == null) {
                        HMSLog.e("HMSPackageManager", "skip package " + str + " for metadata is null");
                    } else if (!bundle.containsKey("hms_app_signer")) {
                        HMSLog.e("HMSPackageManager", "skip package " + str + " for no signer");
                    } else if (!bundle.containsKey("hms_app_cert_chain")) {
                        HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
                    } else {
                        if (!a(str + ContainerUtils.FIELD_DELIMITER + packageSignature, bundle.getString("hms_app_signer"), bundle.getString("hms_app_cert_chain"))) {
                            HMSLog.e("HMSPackageManager", "checkSigner failed");
                        } else {
                            return new Pair<>(str, packageSignature);
                        }
                    }
                }
                return null;
            }
            HMSLog.e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
            return null;
        } catch (Exception e16) {
            HMSLog.e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e16.getMessage());
            return null;
        }
    }

    private Pair<String, String> g() {
        Pair<String, String> f16 = f();
        if (f16 != null) {
            HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) f16.first));
            this.f37690h = "com.huawei.hms.core.aidlservice";
            this.f37691i = null;
            return f16;
        }
        ArrayList<PackagePriorityInfo> h16 = h();
        if (h16 == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<PackagePriorityInfo> it = h16.iterator();
        while (it.hasNext()) {
            PackagePriorityInfo next = it.next();
            String str = next.f37696a;
            String str2 = next.f37697b;
            String str3 = next.f37698c;
            String str4 = next.f37699d;
            String packageSignature = this.f37684b.getPackageSignature(str);
            if (a(str + ContainerUtils.FIELD_DELIMITER + packageSignature + ContainerUtils.FIELD_DELIMITER + str2, str3, str4)) {
                HMSLog.i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + next.f37701f);
                this.f37690h = PackageConstants.GENERAL_SERVICES_ACTION;
                b(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f37680o) {
            if (f37679n == null) {
                if (context.getApplicationContext() != null) {
                    f37679n = new HMSPackageManager(context.getApplicationContext());
                } else {
                    f37679n = new HMSPackageManager(context);
                }
                f37679n.j();
                f37679n.a();
            }
        }
        return f37679n;
    }

    private ArrayList<PackagePriorityInfo> h() {
        try {
            List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(this.f37683a.getPackageManager(), new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                    long packageFirstInstallTime = this.f37684b.getPackageFirstInstallTime(str);
                    Bundle bundle = resolveInfo.serviceInfo.metaData;
                    if (bundle == null) {
                        HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                    } else {
                        String a16 = a(bundle, "hms_app_checker_config");
                        String a17 = a(a16);
                        if (TextUtils.isEmpty(a17)) {
                            HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + a16);
                        } else {
                            String a18 = a(bundle, "hms_app_signer_v2");
                            if (TextUtils.isEmpty(a18)) {
                                HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                            } else {
                                String a19 = a(bundle, "hms_app_cert_chain");
                                if (TextUtils.isEmpty(a19)) {
                                    HMSLog.i("HMSPackageManager", "get certChain fail.");
                                } else {
                                    HMSLog.i("HMSPackageManager", "add: " + str + ", " + a16 + ", " + packageFirstInstallTime);
                                    arrayList.add(new PackagePriorityInfo(str, a16, a18, a19, a17, packageFirstInstallTime));
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList);
                return arrayList;
            }
            HMSLog.e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
            return null;
        } catch (Exception e16) {
            HMSLog.e("HMSPackageManager", "query aglite action failed. " + e16.getMessage());
            return null;
        }
    }

    private void i() {
        synchronized (f37681p) {
            Pair<String, String> f16 = f();
            if (f16 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                e();
                return;
            }
            this.f37685c = (String) f16.first;
            this.f37686d = (String) f16.second;
            this.f37687e = this.f37684b.getPackageVersionCode(getHMSPackageName());
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f37685c + " version: " + this.f37687e);
        }
    }

    private void j() {
        synchronized (f37681p) {
            Pair<String, String> g16 = g();
            if (g16 == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                d();
                return;
            }
            this.f37688f = (String) g16.first;
            this.f37689g = (String) g16.second;
            this.f37692j = this.f37684b.getPackageVersionCode(getHMSPackageNameForMultiService());
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f37688f + " version: " + this.f37692j);
        }
    }

    private boolean k() {
        Bundle bundle;
        PackageManager packageManager = this.f37683a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (AndroidException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e16) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e16);
        }
        if (!TextUtils.isEmpty(this.f37690h) && (this.f37690h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.f37690h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            HMSLog.i("HMSPackageManager", "action = " + this.f37690h + " exist");
            return false;
        }
        ApplicationInfo applicationInfo = InstalledAppListMonitor.getPackageInfo(packageManager, getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public String getHMSFingerprint() {
        String str = this.f37686d;
        if (str == null) {
            return "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
        }
        return str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f37685c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f37684b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                i();
            }
            String str2 = this.f37685c;
            if (str2 != null) {
                return str2;
            }
        }
        if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f37684b.getPackageStates("com.huawei.hwid"))) {
            "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(this.f37684b.getPackageSignature("com.huawei.hwid"));
        }
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f37688f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f37684b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                j();
            }
            String str2 = this.f37688f;
            if (str2 != null) {
                return str2;
            }
            return "com.huawei.hwid";
        }
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        boolean z16;
        synchronized (f37680o) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.f37684b.getPackageStates(this.f37685c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                e();
                return packageStates2;
            }
            boolean z17 = false;
            if ("com.huawei.hwid".equals(this.f37685c) && c() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !this.f37686d.equals(this.f37684b.getPackageSignature(this.f37685c))) {
                z17 = true;
            }
            if (z17) {
                return packageStates2;
            }
            return packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        boolean z16;
        synchronized (f37680o) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.f37684b.getPackageStates(this.f37688f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                d();
                return packageStates2;
            }
            boolean z17 = false;
            if ("com.huawei.hwid".equals(this.f37688f) && c() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !this.f37689g.equals(this.f37684b.getPackageSignature(this.f37688f))) {
                z17 = true;
            }
            if (z17) {
                return packageStates2;
            }
            return packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f37684b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f37684b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        if (!TextUtils.isEmpty(this.f37690h)) {
            return this.f37690h;
        }
        return "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i3) {
        if (this.f37687e >= i3 || !k()) {
            return true;
        }
        int packageVersionCode = this.f37684b.getPackageVersionCode(getHMSPackageName());
        this.f37687e = packageVersionCode;
        if (packageVersionCode >= i3) {
            return true;
        }
        return false;
    }

    public boolean isApkNeedUpdate(int i3) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i3);
        if (hmsVersionCode < i3) {
            return true;
        }
        return false;
    }

    public boolean isApkUpdateNecessary(int i3) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i3);
        if (k() && hmsVersionCode < i3) {
            return true;
        }
        return false;
    }

    public boolean isUseOldCertificate() {
        return this.f37695m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f37685c) || TextUtils.isEmpty(this.f37686d)) {
            i();
        }
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f37688f) || TextUtils.isEmpty(this.f37689g)) {
            j();
        }
    }

    public void resetMultiServiceState() {
        d();
    }

    public void setUseOldCertificate(boolean z16) {
        this.f37695m = z16;
    }

    private String a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    private void b(String str) {
        String a16 = a(str);
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        this.f37691i = a16.substring(9);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    private boolean b() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f37683a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    private boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> b16 = com.huawei.hms.device.a.b(str3);
            if (b16.size() == 0) {
                HMSLog.e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f37683a), b16)) {
                HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            X509Certificate x509Certificate = b16.get(b16.size() - 1);
            if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.e("HMSPackageManager", "CN is invalid");
                return false;
            }
            if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.e("HMSPackageManager", "OU is invalid");
                return false;
            }
            if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
                return true;
            }
            HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    }

    private void a() {
        new BaseThread(new a(), "Thread-asyncOnceCheckMDMState").start();
    }

    private static String a(int i3) {
        if (i3 == 1) {
            return "SPOOFED";
        }
        if (i3 == 2) {
            return "SUCCESS";
        }
        if (i3 == 3) {
            return "UNCHECKED";
        }
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i3);
        return "";
    }
}
