package com.gcloudsdk.gcloud.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCoreSystem {
    private static final String AES_KEY = "";
    private int m_szTargetVersion;
    private String m_szModel = null;
    private String m_szSysVersion = null;
    private String m_szBundleId = null;

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public String GetAppVersion(Context context) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 1)) == null) {
                return "";
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e16) {
            Log.e("TXSystem", "GetGameVersion Exception:" + e16);
            return "";
        }
    }

    public String GetBundleId(Context context) {
        try {
            String packageName = context.getPackageName();
            this.m_szBundleId = packageName;
            return packageName;
        } catch (Exception e16) {
            Log.e("TXSystem", "GetBundleId Exception:" + e16);
            return null;
        }
    }

    public String GetModel() {
        String model = DeviceInfoMonitor.getModel();
        this.m_szModel = model;
        if (model != null) {
            return model;
        }
        return "Model unknown";
    }

    public String GetSysVersion() {
        String str = Build.VERSION.RELEASE;
        this.m_szSysVersion = str;
        if (str != null) {
            return str;
        }
        return "SysVersion unknown";
    }

    public int GetTargetVersion(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            int i3 = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 1).applicationInfo.targetSdkVersion;
            this.m_szTargetVersion = i3;
            return i3;
        } catch (PackageManager.NameNotFoundException e16) {
            Log.e("TXSystem", "GetTargetVersion Exception:" + e16);
            return 0;
        }
    }

    public String GetUdid(Context context) {
        return "";
    }
}
