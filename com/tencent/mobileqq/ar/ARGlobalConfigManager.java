package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARGlobalConfigManager implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f196801d;

    /* renamed from: e, reason: collision with root package name */
    SharedPreferences f196802e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile ARCommonConfigInfo f196803f;

    /* renamed from: h, reason: collision with root package name */
    private final Vector<WeakReference<s>> f196804h = new Vector<>();

    public ARGlobalConfigManager(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARGlobalConfigManager", 2, "ARGlobalConfigManager constructor");
        }
        this.f196801d = qQAppInterface;
        this.f196802e = qQAppInterface.getApp().getSharedPreferences("ar_global_config" + qQAppInterface.getAccount(), 0);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARGlobalConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                ARGlobalConfigManager.this.e();
            }
        }, 8, null, true);
    }

    public boolean a() {
        int i3;
        int d16;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        try {
            i3 = InstalledAppListMonitor.getPackageInfo(application.getPackageManager(), application.getPackageName(), 0).versionCode;
            d16 = d();
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            QLog.d("AREngine_ARGlobalConfigManager", 1, "AppVersionEqualsLocalVersion error happen");
        }
        if (d16 != 0 && i3 == d16) {
            QLog.d("AREngine_ARGlobalConfigManager", 1, "AppVersionEqualsLocalVersion version code is  " + i3 + "local version type is " + d16);
            return true;
        }
        return false;
    }

    public void b(s sVar) {
        if (sVar != null) {
            this.f196804h.add(new WeakReference<>(sVar));
        }
    }

    public synchronized void c() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARGlobalConfigManager", 2, "clearArConfigInfo");
        }
        this.f196803f = null;
        k(0);
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARGlobalConfigManager", 2, "after delete ARConfig, we should remove serverVersionCode");
        }
        QQAppInterface qQAppInterface = this.f196801d;
        if (qQAppInterface == null) {
            return;
        }
        ARCommonConfigInfo.deleteConfigFile(qQAppInterface.getCurrentAccountUin());
    }

    public int d() {
        return this.f196802e.getInt("ar_global_app_version", 0);
    }

    public synchronized ARCommonConfigInfo e() {
        if (this.f196803f == null) {
            synchronized (this) {
                QQAppInterface qQAppInterface = this.f196801d;
                if (qQAppInterface != null) {
                    QLog.d("AREngine_ARGlobalConfigManager", 2, "getArCommonConfigInfo load config from file.");
                    this.f196803f = ARCommonConfigInfo.loadConfigFromFile(qQAppInterface.getAccount());
                }
            }
            return null;
        }
        QLog.d("AREngine_ARGlobalConfigManager", 2, String.format("getArCommonConfigInfo mConfigInfo=%s", this.f196803f));
        return this.f196803f;
    }

    public ARCommonConfigInfo f(boolean z16) {
        if (this.f196803f != null) {
            return this.f196803f;
        }
        if (z16) {
            e();
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.ar.ARGlobalConfigManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ARGlobalConfigManager.this.e();
                }
            }, null, false);
        }
        return this.f196803f;
    }

    public int g() {
        return this.f196802e.getInt("ar_global_key_config_version", 0);
    }

    public ARScanAR h() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARGlobalConfigManager", 2, "getQQArEntryTypeInfo");
        }
        e();
        if (this.f196803f == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARGlobalConfigManager", 2, "config is null");
            }
            return null;
        }
        Iterator<ARScanAR> it = this.f196803f.arControllers.iterator();
        while (it.hasNext()) {
            ARScanAR next = it.next();
            if (next.f197345d == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARGlobalConfigManager", 2, "config is found");
                }
                return next;
            }
        }
        return null;
    }

    public boolean i() {
        ARScanAR h16 = h();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (h16 == null) {
            return false;
        }
        if (h16.f197346e <= serverTimeMillis && serverTimeMillis <= h16.f197347f) {
            return true;
        }
        QLog.d("AREngine_ARGlobalConfigManager", 1, "isShowArPort | getQQArEntryTypeInfo out of date !");
        return false;
    }

    public void j() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        int i3 = 0;
        try {
            i3 = InstalledAppListMonitor.getPackageInfo(application.getPackageManager(), application.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        this.f196802e.edit().putInt("ar_global_app_version", i3).commit();
    }

    public void k(int i3) {
        this.f196802e.edit().putInt("ar_global_key_config_version", i3).commit();
    }

    public synchronized boolean l(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARGlobalConfigManager", 2, "updateArConfigInfo | config = " + str);
        }
        QQAppInterface qQAppInterface = this.f196801d;
        int i3 = 0;
        if (qQAppInterface == null || !ARCommonConfigInfo.saveArConfigToFile(str, qQAppInterface.getCurrentAccountUin())) {
            return false;
        }
        new ArrayList();
        new ArrayList();
        if (this.f196803f != null && this.f196803f.nativeSoResList != null) {
            ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList = this.f196803f.nativeSoResList;
        }
        this.f196803f = ARCommonConfigInfo.parseArConfig(str);
        QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, "qrcode", 0).edit().putInt("ar_guide_b_showed_c" + qQAppInterface.getCurrentAccountUin(), 0).commit();
        if (this.f196803f == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARGlobalConfigManager", 2, "parseArconfigxml fail");
            }
            c();
            return false;
        }
        if (this.f196803f != null && this.f196803f.nativeSoResList != null) {
            ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList2 = this.f196803f.nativeSoResList;
        }
        synchronized (this.f196804h) {
            while (i3 < this.f196804h.size()) {
                WeakReference<s> weakReference = this.f196804h.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().m(this.f196803f);
                    i3++;
                }
                this.f196804h.remove(i3);
                i3--;
                i3++;
            }
        }
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f196801d = null;
    }
}
