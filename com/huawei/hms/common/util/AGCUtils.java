package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AGCUtils {
    /* JADX WARN: Removed duplicated region for block: B:6:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, String str) {
        String str2;
        InputStream inputStream = null;
        try {
            try {
                AGConnectOptionsBuilder aGConnectOptionsBuilder = new AGConnectOptionsBuilder();
                inputStream = context.getResources().getAssets().open("agconnect-services.json");
                aGConnectOptionsBuilder.setInputStream(inputStream);
                str2 = aGConnectOptionsBuilder.build(context).getString(str);
            } catch (IOException e16) {
                HMSLog.e("AGCUtils", "Get " + str + " failed: " + e16);
                str2 = "";
                IOUtils.closeQuietly(inputStream);
                if (!TextUtils.isEmpty(str2)) {
                }
            } catch (NullPointerException e17) {
                HMSLog.e("AGCUtils", "Get " + str + " with AGConnectServicesConfig failed: " + e17);
                str2 = "";
                IOUtils.closeQuietly(inputStream);
                if (!TextUtils.isEmpty(str2)) {
                }
            }
            IOUtils.closeQuietly(inputStream);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            HMSLog.e("AGCUtils", "The " + str + " is null.");
            return "";
        } catch (Throwable th5) {
            IOUtils.closeQuietly(inputStream);
            throw th5;
        }
    }

    private static String b(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("com.huawei.hms.client.cpid")) != null) {
                String valueOf = String.valueOf(obj);
                if (valueOf.startsWith("cpid=")) {
                    return valueOf.substring(5);
                }
                return valueOf;
            }
            HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (AndroidException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (RuntimeException e16) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e16);
            return "";
        }
    }

    private static boolean c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context context) {
        String str;
        if (c(context)) {
            str = a(context, "client/app_id");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } else {
            str = null;
        }
        try {
            AGConnectInstance aGConnectInstance = AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String a16 = a(context);
        if (!TextUtils.isEmpty(a16)) {
            return a16;
        }
        return a(context, "client/app_id");
    }

    public static String getCpId(Context context) {
        String str;
        if (c(context)) {
            return a(context, "client/cp_id");
        }
        try {
            AGConnectInstance aGConnectInstance = AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String b16 = b(context);
        if (!TextUtils.isEmpty(b16)) {
            return b16;
        }
        return a(context, "client/cp_id");
    }

    private static String a(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("com.huawei.hms.client.appid")) != null) {
                String valueOf = String.valueOf(obj);
                return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
            }
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (AndroidException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (RuntimeException e16) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e16);
            return "";
        }
    }
}
