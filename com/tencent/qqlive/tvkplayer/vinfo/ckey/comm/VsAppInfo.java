package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsAppInfo {
    public static int PID;
    public static int SPMODE;
    private static Boolean isReadLog;
    private static Boolean isReadPhoneState;
    private static Boolean isWriteSdcard;
    private static String mAPPVersion;
    private static String mAppProcessName;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class VsStringUtil {
        public static boolean isEmpty(String str) {
            if (str != null && !str.equals("")) {
                return false;
            }
            return true;
        }
    }

    public static String getAPPVersion(Context context) {
        if (mAPPVersion == null) {
            mAPPVersion = getVersionName(context);
        }
        return mAPPVersion;
    }

    public static String getCurrentProcess(Context context) {
        String str = mAppProcessName;
        if (str != null) {
            return str;
        }
        try {
            if (PID == 0) {
                PID = Process.myPid();
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == PID) {
                    String str2 = runningAppProcessInfo.processName;
                    mAppProcessName = str2;
                    return str2;
                }
            }
            return "";
        } catch (Throwable th5) {
            VsLog.printStackTrace(th5);
            return "";
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            return null;
        }
        String packageName = context.getPackageName();
        if (VsStringUtil.isEmpty(packageName)) {
            return "";
        }
        return packageName;
    }

    protected static synchronized String getVersionName(Context context) {
        synchronized (VsAppInfo.class) {
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), getPackageName(context), 0);
                String str = packageInfo.versionName;
                int i3 = packageInfo.versionCode;
                if (str != null && str.trim().length() > 0) {
                    String replace = str.trim().replace('\n', TokenParser.SP).replace('\r', TokenParser.SP).replace("|", "%7C");
                    int i16 = 0;
                    for (char c16 : replace.toCharArray()) {
                        if (c16 == '.') {
                            i16++;
                        }
                    }
                    if (i16 < 3) {
                        VsLog.debug("[core] add versionCode: %s", Integer.valueOf(i3));
                        replace = replace + "." + i3;
                    }
                    VsLog.debug("[core] final Version: %s", replace);
                    return replace;
                }
                return "" + i3;
            } catch (Exception e16) {
                VsLog.printStackTrace(e16);
                VsLog.error(e16.toString(), new Object[0]);
                return "";
            }
        }
    }

    public static boolean isContainPermission(Context context, String str) {
        boolean z16;
        if (context != null && str != null) {
            boolean z17 = true;
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    String[] strArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 4096).requestedPermissions;
                    if (strArr != null) {
                        for (String str2 : strArr) {
                            if (str.equals(str2)) {
                                break;
                            }
                        }
                    }
                    z17 = z16;
                    VsLog.debug("[core] end", new Object[0]);
                    return z17;
                } catch (Throwable th5) {
                    try {
                        VsLog.printStackTrace(th5);
                        VsLog.debug("[core] end", new Object[0]);
                        return z16;
                    } catch (Throwable th6) {
                        VsLog.debug("[core] end", new Object[0]);
                        throw th6;
                    }
                }
            }
            return z16;
        }
        VsLog.error("[core] context or permission is null.", new Object[0]);
        return false;
    }

    public static synchronized boolean isContainReadPhoneStatePermission(Context context) {
        boolean booleanValue;
        synchronized (VsAppInfo.class) {
            if (isReadPhoneState == null) {
                isReadPhoneState = Boolean.valueOf(isContainPermission(context, com.tencent.bugly.common.utils.DeviceInfoUtil.PERMISSION_READ_PHONE));
            }
            VsLog.debug("[core] Read phone state permission: " + isReadPhoneState, new Object[0]);
            booleanValue = isReadPhoneState.booleanValue();
        }
        return booleanValue;
    }
}
