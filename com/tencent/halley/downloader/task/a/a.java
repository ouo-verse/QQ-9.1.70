package com.tencent.halley.downloader.task.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_;

    public a(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + b());
        } catch (SQLException e16) {
            e16.printStackTrace();
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(a());
        } catch (SQLException e16) {
            throw e16;
        }
    }

    protected abstract String a();

    protected abstract String b();

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
        } else {
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sQLiteDatabase);
            return;
        }
        super.onOpen(sQLiteDatabase);
        try {
            int version = sQLiteDatabase.getVersion();
            if (version <= 0) {
                onUpgrade(sQLiteDatabase, version, 1);
            } else if (version > 1) {
                onDowngrade(sQLiteDatabase, version, 1);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
