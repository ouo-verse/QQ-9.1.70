package com.tencent.weiyun.transmission.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class JobDbWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: db, reason: collision with root package name */
    private SQLiteDatabase f384461db;

    JobDbWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void beginTransaction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f384461db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase database() {
        return this.f384461db;
    }

    public int delete(String str, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, str2, strArr)).intValue();
        }
        SQLiteDatabase sQLiteDatabase = this.f384461db;
        if (sQLiteDatabase == null) {
            return 0;
        }
        return sQLiteDatabase.delete(str, str2, strArr);
    }

    public void endTransaction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f384461db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.endTransaction();
        }
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, str, str2, contentValues)).longValue();
        }
        SQLiteDatabase sQLiteDatabase = this.f384461db;
        if (sQLiteDatabase == null) {
            return -1L;
        }
        return sQLiteDatabase.insert(str, str2, contentValues);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cursor) iPatchRedirector.redirect((short) 3, this, str, strArr, str2, strArr2, str3, str4, str5);
        }
        SQLiteDatabase sQLiteDatabase = this.f384461db;
        if (sQLiteDatabase == null) {
            return null;
        }
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public void setTransactionSuccessful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f384461db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, contentValues, str2, strArr)).intValue();
        }
        SQLiteDatabase sQLiteDatabase = this.f384461db;
        if (sQLiteDatabase == null) {
            return 0;
        }
        return sQLiteDatabase.update(str, contentValues, str2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JobDbWrapper(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f384461db = sQLiteDatabase;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
        }
    }
}
