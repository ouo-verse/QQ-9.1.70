package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes34.dex */
public class s {
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
                b16 = i3 == 0;
                QLog.d("ColorNotePluginUtils", 1, "checkOpForVivo success, mode:", Integer.valueOf(i3), ", result:", Boolean.valueOf(b16));
            } else {
                b16 = b(context);
                QLog.d("ColorNotePluginUtils", 1, "checkOpForCommon query failed, result:", Boolean.valueOf(b16), " ,cursor:", cursor);
            }
        } catch (Throwable th5) {
            try {
                QLog.w("ColorNotePluginUtils", 1, "checkOpForVivo, Exception", th5);
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
            QLog.d("ColorNotePluginUtils", 1, "checkPermission");
        }
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNotePluginUtils", 1, "checkPermission context == null");
            }
            return false;
        }
        if (a()) {
            boolean c16 = c(context);
            if (!QLog.isColorLevel()) {
                return c16;
            }
            QLog.d("ColorNotePluginUtils", 1, "checkPermission checkOpForVivo result = " + c16);
            return c16;
        }
        boolean b16 = b(context);
        if (!QLog.isColorLevel()) {
            return b16;
        }
        QLog.d("ColorNotePluginUtils", 1, "checkPermission checkOpForCommon result = " + b16);
        return b16;
    }
}
