package com.tencent.commonsdk.badge;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class BadgeController {
    static IPatchRedirector $redirector_ = null;
    private static final String[] LAUNCHER_WHITE_LIST;
    private static final String TAG = "BadgeUtils";
    private static Context sApplication;
    private static String sCurBadgeProviderAuthorities;
    private static String sCurLauncherPackageName;
    private static boolean sDebug;
    private static volatile Integer sNextCount;
    private static volatile boolean sResumed;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46973);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sDebug = false;
        sResumed = true;
        LAUNCHER_WHITE_LIST = new String[]{"com.tct.launcher", "com.bbk.studyos.launcher", "com.android.launcher3", "com.gionee.amisystem", "com.oppo.launcher", "com.ape.launcher3"};
    }

    public BadgeController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getCurLauncherPackageName() {
        ActivityInfo activityInfo;
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = sApplication.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null && !activityInfo.packageName.equals("android")) {
                return resolveActivity.activityInfo.packageName;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void init(Context context) {
        sApplication = context.getApplicationContext();
        String curLauncherPackageName = getCurLauncherPackageName();
        String[] strArr = LAUNCHER_WHITE_LIST;
        int length = strArr.length;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (strArr[i3].equalsIgnoreCase(curLauncherPackageName)) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (!sDebug) {
            if (z16) {
                sCurLauncherPackageName = curLauncherPackageName;
            }
        } else {
            sCurLauncherPackageName = curLauncherPackageName;
        }
        if (sCurLauncherPackageName != null) {
            try {
                ApplicationInfo applicationInfo = sApplication.getPackageManager().getApplicationInfo(sCurLauncherPackageName, 128);
                if (applicationInfo != null) {
                    sCurBadgeProviderAuthorities = applicationInfo.metaData.getString("badge_provider");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean isSupport(Context context) {
        if (sCurLauncherPackageName == null) {
            init(context);
        }
        if (sCurBadgeProviderAuthorities != null) {
            return true;
        }
        return false;
    }

    public static void resumeOrPause(boolean z16) {
        sResumed = z16;
        Integer num = sNextCount;
        if (sResumed && num != null) {
            setBadge(num.intValue());
        }
    }

    public static boolean setBadge(int i3) {
        if (!sResumed) {
            sNextCount = Integer.valueOf(i3);
        } else {
            sNextCount = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setBadge curBadgeAuthorities: " + sCurBadgeProviderAuthorities + ", resumed?: " + sResumed);
        }
        boolean z16 = false;
        if (sCurBadgeProviderAuthorities == null) {
            return false;
        }
        Uri parse = Uri.parse("content://" + sCurBadgeProviderAuthorities + "/badge");
        Bundle bundle = new Bundle();
        bundle.putInt("count", i3);
        Bundle call = sApplication.getContentResolver().call(parse, "setBadge", "", bundle);
        if (call != null) {
            z16 = call.getBoolean("result");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setBadge result: " + z16);
        }
        return z16;
    }
}
