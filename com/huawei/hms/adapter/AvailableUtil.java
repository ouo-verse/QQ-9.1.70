package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AvailableUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f36641a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f36642b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f36643c = false;

    public static boolean isInstallerLibExist(Context context) {
        Bundle bundle;
        Object obj;
        boolean z16;
        if (f36642b) {
            HMSLog.i("AvailableUtil", "installerInit exist: " + f36643c);
            return f36643c;
        }
        synchronized (f36641a) {
            if (!f36642b) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                        z16 = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                    }
                } else {
                    try {
                        ApplicationInfo applicationInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 128).applicationInfo;
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("availableHMSCoreInstaller")) != null && String.valueOf(obj).equalsIgnoreCase("yes")) {
                            HMSLog.i("AvailableUtil", "available exist: true");
                            z16 = true;
                        }
                    } catch (AndroidException unused2) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                    } catch (RuntimeException e16) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e16);
                    }
                    z16 = false;
                }
                f36643c = z16;
                f36642b = true;
            }
        }
        HMSLog.i("AvailableUtil", "available exist: " + f36643c);
        return f36643c;
    }
}
