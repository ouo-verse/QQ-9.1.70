package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bj {
    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.qqpimsecure", 0);
            if (packageInfo == null) {
                return false;
            }
            if (packageInfo.versionCode < 198) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean b(Context context) {
        String str;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.qqpimsecure", 0);
            if (packageInfo == null || (str = packageInfo.versionName) == null) {
                return false;
            }
            if (!str.contains("minipay")) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context) {
        String str;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.qqpimsecure", 0);
            if (packageInfo == null || (str = packageInfo.versionName) == null) {
                return false;
            }
            if (!str.contains("mini")) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean d(Context context) {
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.qqpimsecure", 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            if (signatureArr != null && signatureArr.length > 0) {
                messageDigest.update(signatureArr[0].toByteArray());
            }
            byte[] digest = messageDigest.digest();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb5 = new StringBuilder(digest.length * 2);
            for (int i3 = 0; i3 < digest.length; i3++) {
                sb5.append(cArr[(digest[i3] & 240) >>> 4]);
                sb5.append(cArr[digest[i3] & RegisterType.DOUBLE_HI]);
            }
            if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(sb5.toString())) {
                if (!"7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(sb5.toString())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean e(Context context) {
        boolean z16;
        List<ActivityManager.RunningServiceInfo> runningServices;
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if ("com.tencent.qqpimsecure".equalsIgnoreCase(it.next().processName)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), new String[]{Constants.KEYS.PLACEMENTS}).getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.indexOf("com.tencent.qqpimsecure") != -1) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        if (TextUtils.equals(stringTokenizer.nextToken().trim(), "com.tencent.qqpimsecure")) {
                            z16 = true;
                            break;
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (!z16 && Build.VERSION.SDK_INT > 23 && context != null && (runningServices = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE)) != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo != null && runningServiceInfo.service != null && (str = runningServiceInfo.process) != null && str.contains("com.tencent.qqpimsecure")) {
                    return true;
                }
            }
        }
        return z16;
    }

    public static boolean f(Context context) {
        if ((d(context) && a(context) && !c(context)) || b(context)) {
            return true;
        }
        return false;
    }

    public static void g(Context context, String str, int i3) {
        Intent launchIntentForPackage;
        if (context != null && (launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), "com.tencent.qqpimsecure")) != null) {
            Bundle bundle = new Bundle();
            if (str != null && str.length() > 0) {
                bundle.putString("platform_Id", str);
            }
            if (i3 > 0) {
                bundle.putInt("dest_view", i3);
            }
            launchIntentForPackage.putExtras(bundle);
            if (i3 == 9502721) {
                launchIntentForPackage.putExtra("big_brother_source_key", "biz_src_tmm");
            } else {
                launchIntentForPackage.putExtra("big_brother_source_key", "biz_src_safe");
            }
            launchIntentForPackage.setFlags(402653184);
            context.startActivity(launchIntentForPackage);
        }
    }
}
