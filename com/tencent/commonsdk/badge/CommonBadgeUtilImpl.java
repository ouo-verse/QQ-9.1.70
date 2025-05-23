package com.tencent.commonsdk.badge;

import android.app.Notification;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.vivo.push.PushClientConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommonBadgeUtilImpl {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_APPLICATION_MESSAGE_QUERY = "android.intent.action.APPLICATION_MESSAGE_QUERY";
    public static final String ACTION_APPLICATION_MESSAGE_UPDATE = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
    public static final String ACTION_QQLAUNCHER_BADGE_UPDATE = "com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT";
    public static final String EXTRA_UPDATE_APPLICATION_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
    public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT = "android.intent.extra.update_application_message_text";
    private static final int IS_MiUI12 = 1;
    public static final String LENOVO_PACKAGE_NAME = "com.lenovo.launcher";
    public static final String MANUFACTURER_OF_HARDWARE_ASUS = "asus";
    public static final String MANUFACTURER_OF_HARDWARE_CMDC = "CMDC";
    public static final String MANUFACTURER_OF_HARDWARE_HONOR = "HONOR";
    public static final String MANUFACTURER_OF_HARDWARE_HUAWEI = "huawei";
    public static final String MANUFACTURER_OF_HARDWARE_LENOVO = "lenovo";
    public static final String MANUFACTURER_OF_HARDWARE_MEIZU = "Meizu";
    public static final String MANUFACTURER_OF_HARDWARE_NUBIA = "nubia";
    public static final String MANUFACTURER_OF_HARDWARE_ONEPLUS = "OnePlus";
    public static final String MANUFACTURER_OF_HARDWARE_OPPO = "OPPO";
    public static final String MANUFACTURER_OF_HARDWARE_OPPO_REALME = "Realme";
    public static final String MANUFACTURER_OF_HARDWARE_PTAC = "PTAC";
    public static final String MANUFACTURER_OF_HARDWARE_SANXING = "samsung";
    public static final String MANUFACTURER_OF_HARDWARE_SONY = "Sony Ericsson";
    public static final String MANUFACTURER_OF_HARDWARE_TD_TECH = "TDTech";
    public static final String MANUFACTURER_OF_HARDWARE_TIANYI = "Tianyi";
    public static final String MANUFACTURER_OF_HARDWARE_VIVO = "vivo";
    public static final String MANUFACTURER_OF_HARDWARE_WIKO = "WIKO";
    public static final String MANUFACTURER_OF_HARDWARE_XIAOMI = "Xiaomi";
    public static final String MANUFACTURER_OF_HARDWARE_ZUK = "ZUK";
    public static final String MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE = "content://com.lenovo.launcher.badge/lenovo_badges";
    public static int NOTIFICATION_ID_NOTIFYID = 0;
    private static final int NO_MiUI12 = 2;
    private static final String OPPO_QQ_BADGE_NUMBER = "com.tencent.mobileqq.badge";
    public static final String TAG = "CommonBadgeUtilImpl";
    private static final int UNKNOWN_MiUI12 = 0;
    public static int haslenovoLanucher;
    private static Boolean haveprovider;
    private static boolean mIsSupportMiui12;
    public static String mLauncherClassName;
    public static int mLimitCount;
    private static int miui12Flag;
    private static int miui6Flag;
    public static PackageManager packmag;
    private static int sBadgeAbility;
    private static Context sContext;
    public static String[] sQQLuancherPackageNames;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        haveprovider = null;
        NOTIFICATION_ID_NOTIFYID = 110234;
        sQQLuancherPackageNames = new String[]{"com.tencent.qlauncher.lite", "com.tencent.qlauncher", "com.tencent.qqlauncher", "com.tencent.launcher"};
        mLauncherClassName = "";
        haslenovoLanucher = -1;
        mLimitCount = -1;
        mIsSupportMiui12 = true;
        sBadgeAbility = 0;
        miui6Flag = 0;
        miui12Flag = 0;
    }

    public CommonBadgeUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void changeAsusBadge(Context context, int i3) {
        int min = Math.min(i3, mLimitCount);
        try {
            if (context.getPackageManager().getApplicationInfo("com.asus.twinapps", 128).metaData.getInt("support_badge_provider") == 1) {
                Bundle bundle = new Bundle();
                bundle.putInt("app_badge_count", min);
                context.getContentResolver().call(Uri.parse("content://com.android.badge"), "setAppBadgeCount", (String) null, bundle);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "changeAsusBadge error", e16);
        }
    }

    public static void changeLenovoBadge(Context context, int i3) {
        boolean z16;
        int i16 = mLimitCount;
        if (i3 > i16) {
            i3 = i16;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("app_shortcut_custom_id", null);
            bundle.putInt("app_badge_count", i3);
            if (context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i(TAG, 1, "changeLenovoBadge count=" + i3 + "result=" + z16);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public static void changeMI6Badge(Context context, int i3, Notification notification) {
        int i16 = mLimitCount;
        if (i3 > i16) {
            i3 = i16;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i3));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (IllegalArgumentException e18) {
            e18.printStackTrace();
        } catch (InstantiationException e19) {
            e19.printStackTrace();
        } catch (NoSuchFieldException e26) {
            e26.printStackTrace();
        }
    }

    public static void changeMIBadge(Context context, int i3) {
        String str;
        if (isMIUI6()) {
            return;
        }
        Intent intent = new Intent(ACTION_APPLICATION_MESSAGE_UPDATE);
        intent.putExtra(EXTRA_UPDATE_APPLICATION_COMPONENT_NAME, "com.tencent.mobileqq/.activity.SplashActivity");
        String str2 = "";
        if (i3 > 0) {
            if (i3 > mLimitCount) {
                str = "" + mLimitCount;
            } else {
                str = i3 + "";
            }
            str2 = str;
        }
        intent.putExtra(EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT, str2);
        context.sendBroadcast(intent);
    }

    public static void changeMeiZuBadge(Context context, int i3) {
        int min = Math.min(i3, mLimitCount);
        QLog.i(TAG, 1, "changeMeiZuBadge " + min);
        try {
            String launcherClassName = getLauncherClassName(context);
            if (launcherClassName == null) {
                return;
            }
            Uri parse = Uri.parse("content://com.meizu.flyme.launcher.app_extras/badge_extras");
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString(Constants.Service.CLASS, launcherClassName);
            bundle.putInt("badge_number", min);
            context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "changeMeiZuBadge error", e16);
        }
    }

    public static void changeNubiaBadge(Context context, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i3);
        try {
            context.getContentResolver().call(Uri.parse("content://cn.nubia.launcher.unreadMark"), "setAppBadgeCount", (String) null, bundle);
        } catch (Exception unused) {
        }
    }

    public static void changeOPPOBadge(Context context, int i3) {
        int i16 = mLimitCount;
        if (i3 > i16) {
            i3 = i16;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i3);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
        } catch (Throwable unused) {
        }
    }

    public static void changeOnePlusBadge(Context context, int i3) {
        int min = Math.min(i3, mLimitCount);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", min);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
            QLog.i(TAG, 1, "changeOnePlusBadge count=" + min);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Write unread number FAILED!!! e = ", e16);
        }
    }

    public static void changeVivoBadge(Context context, int i3) {
        int i16 = mLimitCount;
        if (i3 > i16) {
            i3 = i16;
        }
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }
        Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra(PushClientConstants.TAG_CLASS_NAME, launcherClassName);
        intent.putExtra("notificationNum", i3);
        context.sendBroadcast(intent);
    }

    public static void changeZUKBadge(Context context, int i3) {
        boolean z16;
        int i16 = mLimitCount;
        if (i3 > i16) {
            i3 = i16;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("app_shortcut_custom_id", null);
            bundle.putInt("app_badge_count", i3);
            if (context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Log.d(TAG, "changeZUKBadge mcount=" + i3 + "result=" + z16);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static String getLauncherClassName(Context context) {
        if (!TextUtils.isEmpty(mLauncherClassName)) {
            return mLauncherClassName;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        intent.addCategory("android.intent.category.LAUNCHER");
        try {
            for (ResolveInfo resolveInfo : InstalledAppListMonitor.queryIntentActivities(packageManager, intent, 0)) {
                if (resolveInfo.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                    String str = resolveInfo.activityInfo.name;
                    mLauncherClassName = str;
                    return str;
                }
            }
            QLog.w(TAG, 1, "[getLauncherClassName] no class name found, package=" + context.getPackageName());
            return null;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[getLauncherClassName] exc=" + e16);
            return null;
        }
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "getSystemProperty", th5);
            return str2;
        }
    }

    public static boolean isMIUI12() {
        if (miui12Flag == 0) {
            try {
                String systemProperty = getSystemProperty("ro.miui.ui.version.name", "");
                int i3 = 2;
                if (!TextUtils.isEmpty(systemProperty)) {
                    if (Integer.parseInt(systemProperty.replace("V", "")) >= 12) {
                        i3 = 1;
                    }
                    miui12Flag = i3;
                } else {
                    miui12Flag = 2;
                }
                QLog.i(TAG, 1, "isMIUI12 versionCode" + systemProperty + ",miui12Flag=" + miui12Flag);
            } catch (Exception e16) {
                QLog.i(TAG, 1, "isMIUI12", e16);
            }
        }
        if (miui12Flag == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isMIUI6() {
        BufferedReader bufferedReader;
        Throwable th5;
        int i3;
        StringBuilder sb5;
        int i16 = 0;
        if (miui6Flag == 0) {
            miui6Flag = -1;
            String str = "";
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder("getprop", "ro.miui.ui.version.code").start().getInputStream()), 1024);
            } catch (IOException unused) {
            } catch (Exception unused2) {
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
            }
            try {
                str = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused5) {
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i3 = Integer.parseInt(str);
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                        i3 = 0;
                    }
                    if (i3 > 3) {
                        sb5 = new StringBuilder();
                        sb5.append("setMiui6Badge MICode = ");
                        sb5.append(i3);
                        Log.d("miui", sb5.toString());
                        miui6Flag = 1;
                    }
                }
                if (miui6Flag != 1) {
                }
            } catch (Exception unused6) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused7) {
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i3 = Integer.parseInt(str);
                    } catch (NumberFormatException e17) {
                        e17.printStackTrace();
                        i3 = 0;
                    }
                    if (i3 > 3) {
                        sb5 = new StringBuilder();
                        sb5.append("setMiui6Badge MICode = ");
                        sb5.append(i3);
                        Log.d("miui", sb5.toString());
                        miui6Flag = 1;
                    }
                }
                if (miui6Flag != 1) {
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused8) {
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i16 = Integer.parseInt(str);
                    } catch (NumberFormatException e18) {
                        e18.printStackTrace();
                    }
                    if (i16 > 3) {
                        Log.d("miui", "setMiui6Badge MICode = " + i16);
                        miui6Flag = 1;
                        throw th5;
                    }
                    throw th5;
                }
                throw th5;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    i3 = Integer.parseInt(str);
                } catch (NumberFormatException e19) {
                    e19.printStackTrace();
                    i3 = 0;
                }
                if (i3 > 3) {
                    sb5 = new StringBuilder();
                    sb5.append("setMiui6Badge MICode = ");
                    sb5.append(i3);
                    Log.d("miui", sb5.toString());
                    miui6Flag = 1;
                }
            }
        }
        if (miui6Flag != 1) {
            return false;
        }
        return true;
    }

    public static boolean isQQLanucher() {
        if (packmag == null) {
            packmag = sContext.getPackageManager();
        }
        int i3 = 0;
        while (true) {
            String[] strArr = sQQLuancherPackageNames;
            if (i3 >= strArr.length) {
                return false;
            }
            if (InstalledAppListMonitor.getPackageInfo(packmag, strArr[i3], 0) != null) {
                return true;
            }
            i3++;
        }
    }

    public static boolean isSupportBadge(Context context) {
        if (sContext == null) {
            sContext = context;
        }
        int i3 = sBadgeAbility;
        boolean z16 = false;
        int i16 = 1;
        if (i3 != 0) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_ZUK) || islenovoLanucher(LENOVO_PACKAGE_NAME) || isQQLanucher() || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_XIAOMI) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_SANXING) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_HUAWEI) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_HONOR) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_TD_TECH) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_CMDC) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_PTAC) || str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_OPPO_REALME) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_VIVO) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_NUBIA) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_LENOVO) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_ONEPLUS) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_ASUS) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_TIANYI) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_WIKO) || str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_MEIZU)) {
            z16 = true;
        }
        BadgeController.init(sContext);
        if (BadgeController.isSupport(sContext)) {
            z16 = true;
        }
        if (!z16) {
            i16 = 2;
        }
        sBadgeAbility = i16;
        return z16;
    }

    public static boolean islenovoLanucher(String str) {
        Context context;
        int i3 = haslenovoLanucher;
        if (i3 != -1) {
            if (i3 == 1) {
                return true;
            }
            return false;
        }
        try {
            if (packmag == null && (context = sContext) != null) {
                packmag = context.getPackageManager();
            }
            PackageManager packageManager = packmag;
            if (packageManager == null) {
                return false;
            }
            if (Float.valueOf(Float.parseFloat(InstalledAppListMonitor.getPackageInfo(packageManager, str, 0).versionName.substring(0, 3))).floatValue() >= 6.7f) {
                haslenovoLanucher = 1;
                return true;
            }
            haslenovoLanucher = 0;
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            haslenovoLanucher = 0;
            return false;
        } catch (Exception unused2) {
            haslenovoLanucher = 0;
            return false;
        }
    }

    public static void setBadge(Context context, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setBadge count=" + i3 + "|forceSet=" + z16);
        }
        if (isQQLanucher()) {
            setQQLauncherBadges(context, i3);
        }
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_ZUK)) {
            changeZUKBadge(context, i3);
        }
        if (islenovoLanucher(LENOVO_PACKAGE_NAME)) {
            setLenovoBadge(context, i3);
        }
        if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_LENOVO)) {
            changeLenovoBadge(context, i3);
        }
        if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_XIAOMI)) {
            changeMIBadge(context, i3);
        } else if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_SANXING)) {
            setSamsungBadge(context, i3);
        } else if (!str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_HUAWEI) && !str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_TD_TECH) && !str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_CMDC) && !str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_PTAC) && !str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_TIANYI) && !str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_WIKO)) {
            if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_HONOR)) {
                setHonorBadge(context, i3);
            } else if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_OPPO_REALME)) {
                if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_VIVO)) {
                    changeVivoBadge(context, i3);
                } else if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_NUBIA)) {
                    changeNubiaBadge(context, i3);
                } else if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_ONEPLUS)) {
                    changeOnePlusBadge(context, i3);
                } else if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_ASUS)) {
                    changeAsusBadge(context, i3);
                } else if (str.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_MEIZU)) {
                    changeMeiZuBadge(context, i3);
                }
            } else {
                changeOPPOBadge(context, i3);
            }
        } else {
            setHuaweiBadge(context, i3, str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setBadge count=" + i3 + "|forceSet=" + z16 + " finish");
        }
    }

    public static void setHonorBadge(Context context, int i3) {
        try {
            String launcherClassName = getLauncherClassName(context);
            if (launcherClassName == null) {
                return;
            }
            QLog.i(TAG, 1, "setHonorBadge count=" + i3);
            int i16 = mLimitCount;
            if (i3 > i16) {
                i3 = i16;
            }
            Uri parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
            if (TextUtils.isEmpty(context.getContentResolver().getType(parse))) {
                parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(context.getContentResolver().getType(parse))) {
                    QLog.i(TAG, 1, "setHonorBadge failed uri = null");
                    parse = null;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString(Constants.Service.CLASS, launcherClassName);
            bundle.putInt("badgenumber", i3);
            if (parse != null) {
                context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
            }
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "setHonorBadge failed ", th5);
        }
    }

    public static void setHuaweiBadge(Context context, int i3, String str) {
        try {
            QLog.i(TAG, 1, "setHuaweiBadge count=" + i3 + ",manufacturer=" + str);
            String launcherClassName = getLauncherClassName(context);
            if (launcherClassName == null) {
                return;
            }
            int i16 = mLimitCount;
            if (i3 > i16) {
                i3 = i16;
            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            bundle.putString(Constants.Service.CLASS, launcherClassName);
            bundle.putInt("badgenumber", i3);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "setHuaweiBadge failed ", th5);
        }
    }

    public static void setIsSupportMiui12(boolean z16) {
        mIsSupportMiui12 = z16;
    }

    public static void setLenovoBadge(Context context, int i3) {
        ContentValues contentValues = new ContentValues();
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }
        Cursor cursor = null;
        try {
            contentValues.put("package", context.getPackageName());
            contentValues.put(Constants.Service.CLASS, launcherClassName);
            contentValues.put("badgecount", Integer.valueOf(i3));
            contentValues.put(WadlProxyConsts.EXTRA_DATA, "");
            cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse(MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE), new String[]{"package", Constants.Service.CLASS, "badgecount", WadlProxyConsts.EXTRA_DATA}, "package=?", new String[]{context.getPackageName()}, null);
        } catch (Throwable unused) {
            if (0 == 0) {
                return;
            }
        }
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                context.getContentResolver().update(Uri.parse(MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE), contentValues, "package=?", new String[]{context.getPackageName()});
            }
            cursor.close();
        } else {
            Log.d(MANUFACTURER_OF_HARDWARE_LENOVO, "setLenovoBadge cur=null");
            context.getContentResolver().insert(Uri.parse(MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE), contentValues);
            if (cursor == null) {
                return;
            }
            cursor.close();
        }
    }

    public static void setLimitCount(int i3) {
        mLimitCount = i3;
    }

    private static void setMIUI12Badge(Context context, int i3, Notification notification) {
        notification.number = Math.min(i3, mLimitCount);
    }

    public static void setMIUI6Badge(Context context, int i3, Notification notification) {
        if (Build.MANUFACTURER.equalsIgnoreCase(MANUFACTURER_OF_HARDWARE_XIAOMI) && isMIUI6()) {
            if (mIsSupportMiui12 && isMIUI12()) {
                setMIUI12Badge(context, i3, notification);
            } else {
                changeMI6Badge(context, i3, notification);
            }
        }
    }

    public static void setQQLauncherBadges(Context context, int i3) {
        int i16 = mLimitCount;
        if (i3 > i16) {
            i3 = i16;
        } else if (i3 < 1) {
            i3 = 0;
        }
        Intent intent = new Intent(ACTION_QQLAUNCHER_BADGE_UPDATE);
        intent.putExtra("webappId", "20634");
        intent.putExtra("info_tips", String.valueOf(i3));
        context.sendBroadcast(intent);
    }

    public static void setSamsungBadge(Context context, int i3) {
        Cursor cursor = null;
        try {
            if (haveprovider == null) {
                cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.sec.badge/apps"), null, null, null, null);
                if (cursor == null) {
                    QLog.w(TAG, 1, "[setSamsungBadge] failed to query provider, count=" + i3);
                    haveprovider = Boolean.FALSE;
                    if (cursor != null) {
                        return;
                    } else {
                        return;
                    }
                }
                haveprovider = Boolean.TRUE;
            }
            if (haveprovider.booleanValue()) {
                String launcherClassName = getLauncherClassName(context);
                if (launcherClassName == null) {
                    QLog.w(TAG, 1, "[setSamsungBadge] launcher class name is null, count=" + i3);
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                int i16 = mLimitCount;
                if (i3 <= i16) {
                    i16 = i3;
                }
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", i16);
                intent.putExtra("badge_count_package_name", context.getPackageName());
                intent.putExtra("badge_count_class_name", launcherClassName);
                context.sendBroadcast(intent);
            } else {
                QLog.w(TAG, 1, "[setSamsungBadge] provider not found, count=" + i3);
            }
            if (cursor == null) {
                return;
            }
        } catch (Throwable th5) {
            try {
                QLog.w(TAG, 1, "[setSamsungBadge] exc=" + th5 + ", count=" + i3);
                if (0 == 0) {
                    return;
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        cursor.close();
    }

    public static void setSonyBadge(Context context, int i3) {
        String str;
        Intent intent = new Intent();
        String launcherClassName = getLauncherClassName(context);
        if (launcherClassName == null) {
            return;
        }
        String str2 = "";
        if (i3 < 1) {
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
        } else {
            if (i3 > mLimitCount) {
                str = "" + mLimitCount;
            } else {
                str = i3 + "";
            }
            str2 = str;
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
        }
        intent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", launcherClassName);
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str2);
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void setBadge(Context context, int i3) {
        setBadge(context, i3, false);
    }
}
