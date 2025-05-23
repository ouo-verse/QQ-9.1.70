package com.qq.e.comm.managers.status;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.qq.e.comm.util.StringUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* loaded from: classes3.dex */
public class APPStatus {

    /* renamed from: a, reason: collision with root package name */
    private String f38235a;

    /* renamed from: b, reason: collision with root package name */
    private Context f38236b;

    public APPStatus(String str, Context context) {
        this.f38235a = str;
        this.f38236b = context;
    }

    public String getAPPID() {
        return this.f38235a;
    }

    public String getAPPName() {
        Context context = this.f38236b;
        if (context != null) {
            return context.getPackageName();
        }
        return null;
    }

    public String getAPPRealName() {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                Context context = this.f38236b;
                if (context != null && context.getPackageManager() != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(this.f38236b.getPackageManager(), aPPName, 0)) != null && (applicationInfo = packageInfo.applicationInfo) != null && !TextUtils.isEmpty(applicationInfo.loadLabel(this.f38236b.getPackageManager()))) {
                    return packageInfo.applicationInfo.loadLabel(this.f38236b.getPackageManager()).toString();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String getAPPVersion() {
        PackageInfo packageInfo;
        String aPPName = getAPPName();
        if (!StringUtil.isEmpty(aPPName)) {
            try {
                Context context = this.f38236b;
                if (context != null && context.getPackageManager() != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(this.f38236b.getPackageManager(), aPPName, 0)) != null) {
                    return packageInfo.versionName;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
