package com.tencent.mobileqq.msf.core.c0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f247594a = "monitor.db";

    /* renamed from: b, reason: collision with root package name */
    private static int f247595b = 6;

    /* renamed from: c, reason: collision with root package name */
    private static String f247596c = "create table dataflow(_id INTEGER PRIMARY KEY,processName CHAR(50),uin CHAR(20) NOT NULL,ip CHAR(20) NOT NULL,refer CHAR(50),port INTEGER NOT NULL,flag INTEGER NOT NULL,buffersize LONG NOT NULL,networktype INTEGER NOT NULL,mType CHAR NOT NULL,curtime LONG NOT NULL,status Byte NOT NULL)";

    /* renamed from: d, reason: collision with root package name */
    private static String f247597d = "create table dataflow_rdm(_id INTEGER PRIMARY KEY,uin CHAR(20) NOT NULL,flag INTEGER NOT NULL,buffersize LONG NOT NULL,networktype INTEGER NOT NULL,mType CHAR NOT NULL,data CHAR NOT NULL)";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final d f247598a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7869);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247598a = new d(BaseApplication.getContext());
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public d(Context context) {
        super(context, f247594a, (SQLiteDatabase.CursorFactory) null, f247595b);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public static final d a() {
        return a.f247598a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sQLiteDatabase);
        } else {
            sQLiteDatabase.execSQL(f247596c);
            sQLiteDatabase.execSQL(f247597d);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        sQLiteDatabase.execSQL("drop table dataflow");
        sQLiteDatabase.execSQL("drop table dataflow_rdm");
        sQLiteDatabase.execSQL(f247596c);
        sQLiteDatabase.execSQL(f247597d);
    }
}
