package com.gcloudsdk.apollo;

import android.content.Context;
import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloVoiceUDID {
    private static Context mainContext;
    private static String sAppVersion;
    private static String sBrand;
    private static String sBundleId;
    private static String sModel;
    private static String sOsVersion;

    public static String AppVersion() {
        String str = sAppVersion;
        if (str != null) {
            return str;
        }
        Context context = mainContext;
        if (context != null) {
            try {
                sAppVersion = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), mainContext.getPackageName(), 1).versionName;
            } catch (Exception e16) {
                ApolloVoiceLog.LogE("GetAppVersion Exception: " + e16);
            }
        }
        if (sAppVersion == null) {
            sAppVersion = "Unknown";
        }
        return sAppVersion;
    }

    public static String Brand() {
        String str = sBrand;
        if (str != null) {
            return str;
        }
        sBrand = ApolloVoiceEngine.GetDeviceBrand();
        ApolloVoiceLog.LogI("Get brand : " + sBrand);
        if (sBrand == null) {
            sBrand = "Unknown";
        }
        return sBrand;
    }

    public static String BundleID() {
        String str = sBundleId;
        if (str != null) {
            return str;
        }
        Context context = mainContext;
        if (context != null) {
            try {
                sBundleId = context.getPackageName();
            } catch (Exception e16) {
                ApolloVoiceLog.LogE("GetBundleId Exception: " + e16);
            }
        }
        if (sBundleId == null) {
            sBundleId = "Unknown";
        }
        return sBundleId;
    }

    public static String Model() {
        String str = sModel;
        if (str != null) {
            return str;
        }
        sModel = ApolloVoiceEngine.GetDeviceModel();
        ApolloVoiceLog.LogI("Get model : " + sModel);
        if (sModel == null) {
            sModel = "Unknown";
        }
        return sModel;
    }

    public static String OSVersion() {
        String str = sOsVersion;
        if (str != null) {
            return str;
        }
        String str2 = Build.VERSION.RELEASE;
        sOsVersion = str2;
        if (str2 == null) {
            sOsVersion = "Unknown";
        }
        return sOsVersion;
    }

    public static void SetContext(Context context) {
        mainContext = context;
    }
}
