package com.qzone.album.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0081, code lost:
    
        if (r4 != 17) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        boolean z16 = true;
        if (!DeviceInfoMonitor.getModel().toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) || Build.VERSION.SDK_INT < 27) {
            return true;
        }
        try {
            Cursor query = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.bbk.launcher2.settings/favorites"), null, "title=?", new String[]{"QQ"}, null);
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndexOrThrow("title"));
                int i3 = query.getInt(query.getColumnIndexOrThrow("shortcutPermission"));
                QZLog.d("[PhotoAlbum]DevicesUtils", 1, "hasRightsToShortCutInVIVO title:", string, " shortcutPermission:" + i3);
                query.close();
                if (i3 != 1) {
                }
            }
            z16 = false;
            return z16;
        } catch (Throwable th5) {
            QZLog.e("[PhotoAlbum]DevicesUtils", "hasRightsToShortCutInVIVO... exception:", th5);
            return false;
        }
    }

    public static boolean b() {
        int intValue;
        String flymeOSVersion = OSUtils.getFlymeOSVersion();
        try {
            if (!flymeOSVersion.isEmpty()) {
                if (flymeOSVersion.toLowerCase().contains("os")) {
                    intValue = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
                } else {
                    intValue = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
                }
                if (intValue >= 7) {
                    return true;
                }
            }
        } catch (Throwable th5) {
            QZLog.e("[PhotoAlbum]DevicesUtils", 1, "isFlymeOS7More fail", th5);
        }
        return false;
    }
}
