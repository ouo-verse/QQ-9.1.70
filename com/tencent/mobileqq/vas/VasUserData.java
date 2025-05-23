package com.tencent.mobileqq.vas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class VasUserData {
    private static final String TAG = "VasUserData";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface Key {
        public static final String QQ_VER = "qqVer";
        public static final String THEME_ID = "themeId";
        public static final String THEME_VER = "themeVer";
        public static final String TICKET_REQ_INTERVAL = "ticketInterval";
    }

    public static String get(AppRuntime appRuntime, String str) {
        int columnIndex;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "get, key=" + str);
        }
        String str2 = null;
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            Context applicationContext = appRuntime.getApplication().getApplicationContext();
            if (applicationContext == null) {
                return null;
            }
            Cursor query = ContactsMonitor.query(applicationContext.getContentResolver(), Uri.parse(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getUserDataString() + "/" + appRuntime.getAccount()), null, "key=?", new String[]{str}, null);
            if (query != null && query.moveToFirst() && (columnIndex = query.getColumnIndex("value")) >= 0) {
                str2 = query.getString(columnIndex);
            }
            if (query != null) {
                query.close();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[Performance] get, duration=" + (SystemClock.uptimeMillis() - uptimeMillis));
            }
            return str2;
        }
        QLog.d(TAG, 1, "get, app and key MUST NOT be null, context=" + appRuntime + ", key=" + str);
        return null;
    }

    public static boolean set(AppRuntime appRuntime, String str, String str2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "set, key=" + str + ", value=" + str2);
        }
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            Context applicationContext = appRuntime.getApplication().getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            Uri parse = Uri.parse(((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getUserDataString() + "/" + appRuntime.getAccount());
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            contentValues.put("value", str2);
            int update = applicationContext.getContentResolver().update(parse, contentValues, null, null);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[Performance] set, duration=" + (SystemClock.uptimeMillis() - uptimeMillis) + ", result=" + update);
            }
            if (update < 1) {
                return false;
            }
            return true;
        }
        QLog.d(TAG, 1, "get, app and key MUST NOT be null, context=" + appRuntime + ", key=" + str);
        return false;
    }
}
