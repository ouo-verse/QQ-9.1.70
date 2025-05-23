package com.gcore.abase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.gcore.abase.log.XLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SolidConfigReader {
    private Context m_context;

    public void GetAllKeys(String str, List<String> list) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return;
        }
        if (str != null && list != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                    for (String str2 : bundle.keySet()) {
                        int length = str.length();
                        if (str2.length() > length && str2.substring(0, length).equals(str)) {
                            list.add(str2.substring(length + 1));
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public boolean GetBool(String str, String str2, boolean z16) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return z16;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getBoolean(str + "." + str2, z16);
            }
            return z16;
        } catch (Exception e16) {
            e16.printStackTrace();
            return z16;
        }
    }

    public int GetInt(String str, String str2, int i3) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return i3;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getInt(str + "." + str2, i3);
            }
            return i3;
        } catch (Exception e16) {
            e16.printStackTrace();
            return i3;
        }
    }

    public String GetMetaString(Context context, String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "";
        }
        if (str != null && str.equals("Application")) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getApplicationInfo(context.getPackageName(), 128).metaData.getString(str2);
                }
                return str3;
            } catch (Exception e16) {
                e16.printStackTrace();
                return str3;
            }
        }
        return str3;
    }

    public String GetString(String str, String str2, String str3) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return str3;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getString(str + "." + str2, str3);
            }
            return str3;
        } catch (Exception e16) {
            e16.printStackTrace();
            return str3;
        }
    }

    public void Init(Context context) {
        this.m_context = context;
    }

    public boolean IsContainKey(String str, String str2) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.m_context;
        if (context == null) {
            XLog.e("SolidConfigReader", "SolidConfigReader not init!");
            return false;
        }
        if (str != null && str2 != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.m_context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                    for (String str3 : bundle.keySet()) {
                        int length = str.length();
                        if (str3.length() > length && str3.substring(0, length).equals(str) && str2.equals(str3.substring(length + 1))) {
                            return true;
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public void Dump() {
    }

    public void UnInit() {
    }
}
