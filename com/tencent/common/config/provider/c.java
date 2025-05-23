package com.tencent.common.config.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private e f99592d;

    /* renamed from: e, reason: collision with root package name */
    private SQLiteDatabase f99593e;

    /* renamed from: f, reason: collision with root package name */
    private SQLiteDatabase f99594f;

    /* renamed from: h, reason: collision with root package name */
    public String f99595h;

    public c(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f99595h = str;
        }
        this.f99592d = new e(context, "config_db" + str, null, 20);
    }

    public int a(Uri uri, String str, ContentValues[] contentValuesArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, uri, str, contentValuesArr)).intValue();
        }
        if (!z()) {
            return 0;
        }
        int length = contentValuesArr.length;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.f99593e.beginTransaction();
                for (ContentValues contentValues : contentValuesArr) {
                    if (this.f99593e.replace(str, "", contentValues) > 0) {
                        length++;
                    } else {
                        throw new SQLException("failed to insert row into " + uri);
                    }
                }
                this.f99593e.setTransactionSuccessful();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (QLog.isColorLevel()) {
                    QLog.i("QZConfigSqliteManager", 2, "bulkInsert finish. uri=" + uri + " cost=" + currentTimeMillis2 + "ms numValues=" + length);
                }
            } catch (SQLException e16) {
                QLog.e("QZConfigSqliteManager", 1, "There was a problem with the bulk insert: " + e16.getMessage());
            }
            this.f99593e.endTransaction();
            int i3 = length;
            b();
            return i3;
        } catch (Throwable th5) {
            this.f99593e.endTransaction();
            throw th5;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return e() + 0 + d(null, null) + j() + f() + g(null, null) + h(null, null);
    }

    public int d(String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) strArr)).intValue();
        }
        if (z()) {
            int delete = this.f99593e.delete("qz_configs", str, strArr);
            b();
            return delete;
        }
        return 0;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (z()) {
            int delete = this.f99593e.delete("qz_cookie", null, null);
            b();
            return delete;
        }
        return 0;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (z()) {
            int delete = this.f99593e.delete("qz_check_time", null, null);
            b();
            return delete;
        }
        return 0;
    }

    public int g(String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) strArr)).intValue();
        }
        if (z()) {
            int delete = this.f99593e.delete("qz_isp_config", str, strArr);
            b();
            return delete;
        }
        return 0;
    }

    public int h(String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) strArr)).intValue();
        }
        if (z()) {
            int delete = this.f99593e.delete("qz_navigator_bar", str, strArr);
            b();
            return delete;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(String str, String[] strArr) {
        if (z()) {
            return this.f99593e.delete("table_qz_unread", str, strArr);
        }
        if (QLog.isColorLevel()) {
            QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite,failed deleteQzoneUnread"));
            return 0;
        }
        return 0;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (z()) {
            return this.f99593e.delete("qz_update", null, null);
        }
        return 0;
    }

    public Cursor k(String[] strArr, String str, String[] strArr2, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Cursor) iPatchRedirector.redirect((short) 14, this, strArr, str, strArr2, str2);
        }
        if (y()) {
            Cursor query = this.f99594f.query("qz_configs", strArr, str, strArr2, null, null, str2);
            b();
            return query;
        }
        return null;
    }

    public Cursor l(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Cursor) iPatchRedirector.redirect((short) 16, (Object) this, (Object) strArr);
        }
        if (y()) {
            Cursor query = this.f99594f.query("qz_cookie", strArr, null, null, null, null, null);
            b();
            return query;
        }
        return null;
    }

    public Cursor m(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Cursor) iPatchRedirector.redirect((short) 17, (Object) this, (Object) strArr);
        }
        if (y()) {
            Cursor query = this.f99594f.query("qz_check_time", strArr, null, null, null, null, null);
            b();
            return query;
        }
        return null;
    }

    public Cursor n(String[] strArr, String str, String[] strArr2, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Cursor) iPatchRedirector.redirect((short) 15, this, strArr, str, strArr2, str2);
        }
        if (y()) {
            Cursor query = this.f99594f.query("qz_isp_config", strArr, str, strArr2, null, null, str2);
            b();
            return query;
        }
        return null;
    }

    public Cursor o(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Cursor) iPatchRedirector.redirect((short) 18, (Object) this, (Object) strArr);
        }
        if (y()) {
            Cursor query = this.f99594f.query("qz_update", strArr, null, null, null, null, null);
            b();
            return query;
        }
        return null;
    }

    public Cursor p(String[] strArr, String str, String[] strArr2, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Cursor) iPatchRedirector.redirect((short) 13, this, strArr, str, strArr2, str2);
        }
        if (y()) {
            Cursor query = this.f99594f.query("qz_navigator_bar", strArr, str, strArr2, null, null, str2);
            b();
            return query;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cursor q(String[] strArr, String str, String[] strArr2, String str2) {
        if (y()) {
            Cursor query = this.f99594f.query("table_qz_unread", strArr, str, strArr2, null, null, str2);
            b();
            return query;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite"));
            return null;
        }
        return null;
    }

    public Uri r(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Uri) iPatchRedirector.redirect((short) 19, (Object) this, (Object) uri, (Object) contentValues);
        }
        if (z()) {
            long replace = this.f99593e.replace("qz_configs", "", contentValues);
            if (replace > 0) {
                Uri withAppendedId = ContentUris.withAppendedId(d.v3, replace);
                b();
                return withAppendedId;
            }
            throw new SQLException("failed to insert row into " + uri);
        }
        return null;
    }

    public Uri s(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Uri) iPatchRedirector.redirect((short) 22, (Object) this, (Object) uri, (Object) contentValues);
        }
        if (z()) {
            long replace = this.f99593e.replace("qz_cookie", "", contentValues);
            if (replace > 0) {
                Uri withAppendedId = ContentUris.withAppendedId(d.w3, replace);
                b();
                return withAppendedId;
            }
            throw new SQLException("failed to insert row into " + uri);
        }
        return null;
    }

    public Uri t(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Uri) iPatchRedirector.redirect((short) 23, (Object) this, (Object) uri, (Object) contentValues);
        }
        if (z()) {
            long replace = this.f99593e.replace("qz_check_time", "", contentValues);
            if (replace > 0) {
                Uri withAppendedId = ContentUris.withAppendedId(d.C3, replace);
                b();
                return withAppendedId;
            }
            throw new SQLException("failed to insert row into " + uri);
        }
        return null;
    }

    public Uri u(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Uri) iPatchRedirector.redirect((short) 21, (Object) this, (Object) uri, (Object) contentValues);
        }
        if (z()) {
            long replace = this.f99593e.replace("qz_isp_config", "", contentValues);
            if (replace > 0) {
                Uri withAppendedId = ContentUris.withAppendedId(d.B3, replace);
                b();
                return withAppendedId;
            }
            throw new SQLException("failed to insert row into " + uri);
        }
        return null;
    }

    public Uri v(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Uri) iPatchRedirector.redirect((short) 20, (Object) this, (Object) uri, (Object) contentValues);
        }
        if (z()) {
            long replace = this.f99593e.replace("qz_navigator_bar", "", contentValues);
            if (replace > 0) {
                Uri withAppendedId = ContentUris.withAppendedId(d.D3, replace);
                b();
                return withAppendedId;
            }
            throw new SQLException("failed to insert row into " + uri);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri w(Uri uri, ContentValues contentValues) {
        if (z()) {
            long replace = this.f99593e.replace("table_qz_unread", "", contentValues);
            b();
            if (replace > 0) {
                return ContentUris.withAppendedId(uri, replace);
            }
            if (QLog.isColorLevel()) {
                QLog.e("QZConfigSqliteManager", 2, "", new SQLException("failed to insert row into " + uri));
                return null;
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QZConfigSqliteManager", 2, "", new SQLException("cannot openWriteSqlite,failed to insert row into " + uri));
            return null;
        }
        return null;
    }

    public Uri x(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Uri) iPatchRedirector.redirect((short) 24, (Object) this, (Object) uri, (Object) contentValues);
        }
        if (z()) {
            long replace = this.f99593e.replace("qz_update", "", contentValues);
            if (replace > 0) {
                Uri withAppendedId = ContentUris.withAppendedId(d.f99596z3, replace);
                b();
                return withAppendedId;
            }
            throw new SQLException("failed to insert row into " + uri);
        }
        return null;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        SQLiteDatabase sQLiteDatabase = this.f99594f;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return true;
        }
        try {
            this.f99594f = this.f99592d.getReadableDatabase();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QZConfigSqliteManager", 2, "provider\u83b7\u53d6\u6570\u636e\u5e93\u51fa\u9519", e16);
            }
        }
        SQLiteDatabase sQLiteDatabase2 = this.f99594f;
        if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
            return true;
        }
        return false;
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        SQLiteDatabase sQLiteDatabase = this.f99593e;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return true;
        }
        try {
            this.f99593e = this.f99592d.getWritableDatabase();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QZConfigSqliteManager", 2, "provider\u83b7\u53d6\u6570\u636e\u5e93\u51fa\u9519", e16);
            }
        }
        SQLiteDatabase sQLiteDatabase2 = this.f99593e;
        if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
            return true;
        }
        return false;
    }
}
