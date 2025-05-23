package com.tencent.mobileqq.openpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQVersionUtils implements Comparator<String> {
    static IPatchRedirector $redirector_;

    public QQVersionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getMobileQQVersion(Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.mobileqq", 0);
            if (packageInfo != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                return packageInfo.versionName;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e16) {
            Log.d(OpenConstants.QQApp.SDK_TAG, "getMobileQQVersion error:", e16);
            return null;
        } catch (Exception e17) {
            Log.d(OpenConstants.QQApp.SDK_TAG, "getMobileQQVersion error:", e17);
            return null;
        }
    }

    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i3 = 0;
        while (i3 < split.length && i3 < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i3]);
                int parseInt2 = Integer.parseInt(split2[i3]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i3++;
            } catch (NumberFormatException e16) {
                Log.d(OpenConstants.QQApp.SDK_TAG, "compare error:", e16);
                return str.compareTo(str2);
            }
        }
        if (split.length > i3) {
            return 1;
        }
        return split2.length > i3 ? -1 : 0;
    }
}
