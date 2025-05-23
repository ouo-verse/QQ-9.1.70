package com.gcore.abase;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.gcore.abase.log.XLog;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudCoreSystem {
    private static final String AES_KEY = "";
    private static boolean m_bEnableFlag = true;
    private static boolean m_bHasGetFlag = false;
    private int m_szTargetVersion;
    private String m_szModel = null;
    private String m_szSysVersion = null;
    private String m_szBundleId = null;

    public static String getDeviceBrand() {
        if (!getEnableFlag()) {
            return "ForbiddenGetBrand";
        }
        return Build.BRAND;
    }

    private static boolean getEnableFlag() {
        if (m_bHasGetFlag) {
            return m_bEnableFlag;
        }
        boolean solidConfigBool = GCloudCore.Instance.getSolidConfigBool("GCloud.GCloudCore", "EnableUDID", false);
        m_bEnableFlag = solidConfigBool;
        m_bHasGetFlag = true;
        return solidConfigBool;
    }

    public String GetAppVersion(Context context) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 1)) == null) {
                return "";
            }
            return packageInfo.versionName;
        } catch (Exception e16) {
            XLog.e("GCloudCoreSystem", "GetGameVersion Exception:" + e16);
            return "";
        }
    }

    public String GetBundleId(Context context) {
        try {
            String packageName = context.getPackageName();
            this.m_szBundleId = packageName;
            return packageName;
        } catch (Exception e16) {
            XLog.e("GCloudCoreSystem", "GetBundleId Exception:" + e16);
            return null;
        }
    }

    public String GetModel() {
        if (!getEnableFlag()) {
            return "ForbiddenGetModel";
        }
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
        } catch (Exception e16) {
            XLog.e("GCloudCoreSystem", "GetTargetVersion Exception:" + e16);
            return 0;
        }
    }

    public String GetUdid(Context context) {
        if (!getEnableFlag()) {
            return "ForbiddenGetUDID";
        }
        String string = DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("%");
        sb5.append("");
        sb5.append("%");
        sb5.append("");
        if (string != null) {
            sb5.append("%");
            sb5.append(string);
        }
        String sb6 = sb5.toString();
        if (sb6.length() == 0) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            if (messageDigest == null) {
                return "";
            }
            messageDigest.update(sb6.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb7 = new StringBuilder();
            for (byte b16 : digest) {
                sb7.append(Integer.toHexString(b16 & 255));
            }
            return sb7.toString().toUpperCase(Locale.ENGLISH);
        } catch (NoSuchAlgorithmException unused) {
            XLog.w("Exception", "NoSuchAlgorithmException:MD5");
            return "";
        }
    }
}
