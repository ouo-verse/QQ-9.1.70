package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static boolean a() {
        return Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
    }

    public static boolean b(Context context) {
        return Settings.canDrawOverlays(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0099, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0096, code lost:
    
        if (0 == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context) {
        boolean b16;
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), new String[]{"currentmode"}, "pkgname='" + context.getPackageName() + "'", null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int i3 = cursor.getInt(0);
                if (i3 == 0) {
                    b16 = true;
                } else {
                    b16 = false;
                }
                QLog.d("ColorNoteSmallScreenPermissionUtil", 1, "checkOpForVivo success, mode:", Integer.valueOf(i3), ", result:", Boolean.valueOf(b16));
            } else {
                b16 = b(context);
                QLog.d("ColorNoteSmallScreenPermissionUtil", 1, "checkOpForCommon query failed, result:", Boolean.valueOf(b16), " ,cursor:", cursor);
            }
        } catch (Throwable th5) {
            try {
                QLog.w("ColorNoteSmallScreenPermissionUtil", 1, "checkOpForVivo, Exception", th5);
                b16 = b(context);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    public static boolean d(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenPermissionUtil", 1, "checkPermission");
        }
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenPermissionUtil", 1, "checkPermission context == null");
            }
            return false;
        }
        if (a() && Build.VERSION.SDK_INT == 24) {
            boolean c16 = c(context);
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenPermissionUtil", 1, "checkPermission checkOpForVivo result = " + c16);
                return c16;
            }
            return c16;
        }
        boolean b16 = b(context);
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenPermissionUtil", 1, "checkPermission checkOpForCommon result = " + b16);
            return b16;
        }
        return b16;
    }

    private static boolean e(Context context, Intent intent) {
        ActivityInfo resolveActivityInfo;
        if (context == null || intent == null || (resolveActivityInfo = intent.resolveActivityInfo(context.getPackageManager(), 65536)) == null || !resolveActivityInfo.exported) {
            return false;
        }
        return true;
    }

    public static boolean f(Context context) {
        boolean z16;
        if (a()) {
            z16 = o(context);
            if (!z16) {
                z16 = n(context);
            }
        } else {
            z16 = false;
        }
        if (!z16) {
            z16 = g(context);
        }
        if (!z16) {
            z16 = k(context);
        }
        if (!z16) {
            z16 = l(context);
        }
        if (!z16) {
            z16 = m(context);
        }
        if (!z16) {
            z16 = j(context);
        }
        if (!z16) {
            z16 = h(context);
        }
        if (!z16) {
            return i(context);
        }
        return z16;
    }

    private static boolean g(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(268435456);
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean h(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        intent.putExtra("packageName", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean i(Context context) {
        Intent intent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean j(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean k(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        intent.addFlags(268435456);
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean l(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.RealAppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean m(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean n(Context context) {
        Intent intent = new Intent("com.iqoo.secure");
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean o(Context context) {
        Intent intent = new Intent("permission.intent.action.softPermissionDetail");
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        intent.putExtra("packagename", context.getPackageName());
        if (e(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }
}
