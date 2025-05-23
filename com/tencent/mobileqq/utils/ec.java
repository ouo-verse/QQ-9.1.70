package com.tencent.mobileqq.utils;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ec {

    /* renamed from: a, reason: collision with root package name */
    private static String f307692a = "QQUtils";

    /* renamed from: b, reason: collision with root package name */
    private static int f307693b;

    /* renamed from: c, reason: collision with root package name */
    static String f307694c;

    public static int d(Context context) {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
            return e(context);
        }
        if (lowerCase.contains("xiaomi")) {
            return f(context);
        }
        if (lowerCase.contains("oppo")) {
            return g(context);
        }
        if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            return h(context);
        }
        if (!lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && !lowerCase.contains("meizu")) {
            return 3;
        }
        return 0;
    }

    public static int e(@NonNull Context context) {
        QLog.i(f307692a, 1, "checkOnEMUI");
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        try {
            Class<?> cls = Class.forName("com.huawei.hsm.permission.PermissionManager");
            boolean booleanValue = ((Boolean) cls.getDeclaredMethod("canSendBroadcast", Context.class, Intent.class).invoke(cls, context, intent)).booleanValue();
            QLog.i(f307692a, 1, "EMUI check permission canSendBroadcast invoke result = " + booleanValue);
            if (!booleanValue) {
                return 1;
            }
            return 0;
        } catch (Throwable th5) {
            QLog.i(f307692a, 1, th5.getMessage(), th5);
            return 3;
        }
    }

    public static int f(@NonNull Context context) {
        QLog.i(f307692a, 1, "checkOnMIUI");
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = context.getApplicationInfo().uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Object invoke = cls.getDeclaredMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class).invoke(appOpsManager, 10017, Integer.valueOf(i3), packageName);
            if (invoke == null) {
                QLog.i(f307692a, 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result is null");
                return 3;
            }
            String obj = invoke.toString();
            int intValue = Integer.valueOf(obj).intValue();
            QLog.i(f307692a, 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result = " + obj);
            if (intValue == 0) {
                return 0;
            }
            if (intValue == 1) {
                return 1;
            }
            if (intValue != 5) {
                return 3;
            }
            return 2;
        } catch (Throwable th5) {
            QLog.i(f307692a, 1, th5.getMessage(), th5);
            return 3;
        }
    }

    public static int g(@NonNull Context context) {
        QLog.i(f307692a, 1, "checkOnOPPO");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            QLog.i(f307692a, 1, "contentResolver is null");
            return 3;
        }
        Cursor query = ContactsMonitor.query(contentResolver, Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), null, null, null, null);
        try {
            if (query == null) {
                QLog.i(f307692a, 1, "cursor is null (Uri : content://settings/secure/launcher_shortcut_permission_settings)");
                return 3;
            }
            String packageName = context.getApplicationContext().getPackageName();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("value"));
                QLog.i(f307692a, 1, "permission value is " + string);
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains(packageName + ", 1")) {
                        query.close();
                        return 0;
                    }
                    if (string.contains(packageName + ", 0")) {
                        return 1;
                    }
                }
            }
            return 3;
        } catch (Exception e16) {
            QLog.i(f307692a, 1, e16.getMessage(), e16);
            return 3;
        } finally {
            query.close();
        }
    }

    public static int h(@NonNull Context context) {
        boolean z16;
        Cursor cursor;
        QLog.i(f307692a, 1, "checkOnVIVO");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            QLog.i(f307692a, 1, "contentResolver is null");
            return 3;
        }
        Uri parse = Uri.parse("content://com.bbk.launcher2.settings/favorites");
        if (context.checkSelfPermission("com.bbk.launcher2.permission.READ_SETTINGS") == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i(f307692a, 1, "cannot get com.bbk.launcher2.permission.READ_SETTINGS permission");
            return l();
        }
        try {
            cursor = ContactsMonitor.query(contentResolver, parse, null, null, null, null);
        } catch (Exception e16) {
            QLog.e(f307692a, 1, "shortcutUtils query error", e16);
            cursor = null;
        }
        if (cursor == null) {
            QLog.i(f307692a, 1, "cursor is null (Uri : content://com.bbk.launcher2.settings/favorites)");
            return 3;
        }
        while (cursor.moveToNext()) {
            try {
                try {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                    QLog.i(f307692a, 1, "title by query is " + string);
                    if (!TextUtils.isEmpty(string) && string.equals(i(context))) {
                        int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("shortcutPermission"));
                        QLog.i(f307692a, 1, "permission value is " + i3);
                        if (i3 == 1 || i3 == 17) {
                            return 1;
                        }
                        if (i3 == 16) {
                            return 0;
                        }
                        if (i3 == 18) {
                            cursor.close();
                            return 2;
                        }
                    }
                } catch (Exception e17) {
                    QLog.i(f307692a, 1, e17.getMessage(), e17);
                }
            } finally {
                cursor.close();
            }
        }
        return 3;
    }

    private static String i(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getApplicationContext().getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    static boolean j(Context context) {
        if (f307694c == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("from", "hasLuncherAuthority");
                QQBeaconReport.report("", "getAuthorityFromPermission", hashMap);
            } catch (Throwable th5) {
                QLog.e(f307692a, 1, "hasLuncherAuthority getAuthorityFromPermission report err:", th5);
            }
            f307694c = dn.a(context);
        }
        if (!GlobalUtil.DEF_STRING.equals(f307694c)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f307692a, 2, "cannot find authority");
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        if (r8 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
    
        if (r8 != null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean k(Context context, String[] strArr) {
        if (!j(context)) {
            return false;
        }
        String str = f307694c;
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            try {
                if (QLog.isColorLevel()) {
                    String str2 = "";
                    if (strArr != null && strArr.length >= 1) {
                        str2 = "" + strArr[0];
                    }
                    QLog.d(f307692a, 2, "hasshortcut.url=" + str + ",title=" + str2);
                }
                cursor = ContactsMonitor.query(contentResolver, Uri.parse(str), null, "title=?", strArr, null);
                if (cursor != null) {
                    boolean moveToFirst = cursor.moveToFirst();
                    cursor.close();
                    return moveToFirst;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f307692a, 2, "hasShortCut.exception=" + e16.toString());
                }
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public static int l() {
        QQToast.makeText(BaseApplication.getContext(), "\u5df2\u6dfb\u52a0\u684c\u9762\u5feb\u6377\u65b9\u5f0f\uff0c\u5982\u672a\u6210\u529f\uff0c\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00\u3010\u684c\u9762\u5feb\u6377\u65b9\u5f0f\u3011\u6743\u9650\u5e76\u91cd\u65b0\u6dfb\u52a0", 0);
        return 0;
    }
}
