package com.tencent.mobileqq.localizeddb;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.Factory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends a implements ISQLiteOpenHelper {
    static IPatchRedirector $redirector_;
    private final SQLiteOpenHelperFacade E;

    @TargetApi(11)
    public b(EntityManagerFactory entityManagerFactory, String str, String str2, int i3, DatabaseErrorHandler databaseErrorHandler) {
        super(BaseApplication.getContext(), str, new Factory(entityManagerFactory), i3, databaseErrorHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, entityManagerFactory, str, str2, Integer.valueOf(i3), databaseErrorHandler);
        } else {
            this.E = new SQLiteOpenHelperFacade(this, str, entityManagerFactory, str2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.E.close();
        }
    }

    @Override // com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void dropAllTable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.E.dropAllTable();
        }
    }

    @Override // com.tencent.mobileqq.localizeddb.a, android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.E.getReadableDatabase();
    }

    @Override // com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabaseInner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return super.getReadableDatabase();
    }

    @Override // com.tencent.mobileqq.localizeddb.a, android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.E.getWritableDatabase();
    }

    @Override // com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabaseInner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return super.getWritableDatabase();
    }

    @Override // com.tencent.mobileqq.localizeddb.a, android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sQLiteDatabase);
        } else {
            this.E.onCreate(sQLiteDatabase);
        }
    }

    @Override // com.tencent.mobileqq.localizeddb.a, android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.E.onDowngrade(sQLiteDatabase, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.localizeddb.a, android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sQLiteDatabase);
        } else {
            super.onOpen(sQLiteDatabase);
            this.E.onOpen(sQLiteDatabase);
        }
    }

    @Override // com.tencent.mobileqq.localizeddb.a, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.E.onUpgrade(sQLiteDatabase, i3, i16);
        }
    }
}
