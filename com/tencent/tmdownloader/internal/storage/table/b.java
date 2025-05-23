package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.r;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements com.tencent.tmassistant.common.a.b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(ContentValues contentValues, com.tencent.tmdownloader.f.b.e.a aVar) {
        if (aVar != null) {
            contentValues.put("clientId", aVar.f380657a);
            contentValues.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, Integer.valueOf(aVar.f380658b));
            contentValues.put("taskUrl", aVar.f380659c);
        }
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String createTableSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String[] getAlterSQL(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return null;
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String tableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "clientinfo";
    }

    public static void a(com.tencent.tmdownloader.f.b.e.a aVar) {
        if (aVar != null) {
            try {
                SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
                if (writableDatabase == null || a(aVar, writableDatabase) > 0) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                a(contentValues, aVar);
                writableDatabase.insert("clientinfo", null, contentValues);
            } catch (Exception e16) {
                r.a("ClientInfoTable", "exception: ", e16);
                e16.printStackTrace();
            }
        }
    }

    public static void a(String str, String str2) {
        com.tencent.tmdownloader.f.b.e.a aVar = new com.tencent.tmdownloader.f.b.e.a();
        aVar.f380657a = str;
        aVar.f380659c = str2;
        a(aVar);
    }

    private static int a(com.tencent.tmdownloader.f.b.e.a aVar, SQLiteDatabase sQLiteDatabase) {
        if (aVar == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            a(contentValues, aVar);
            int update = sQLiteDatabase.update("clientinfo", contentValues, "clientId = ? and taskUrl = ?", new String[]{aVar.f380657a, aVar.f380659c});
            if (update > 0) {
                return update;
            }
            return 0;
        } catch (Exception e16) {
            r.a("ClientInfoTable", "exception: ", e16);
            e16.printStackTrace();
            return -2;
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("clientinfo", "taskUrl = ?", new String[]{str});
            }
        } catch (Exception e16) {
            r.a("ClientInfoTable", "exception: ", e16);
            e16.printStackTrace();
        }
    }
}
