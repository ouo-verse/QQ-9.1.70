package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.r;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d implements com.tencent.tmassistant.common.a.b {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(String str, String str2, String str3) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getWritableDatabase();
            if (writableDatabase == null || a(str, str2, str3, writableDatabase) > 0) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("settingField", str);
            contentValues.put("value", str2);
            contentValues.put("type", str3);
            writableDatabase.insert("settingInfo", null, contentValues);
        } catch (Exception e16) {
            r.a("DownloadSettingTable", "exception: ", e16);
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tmassistant.common.a.b
    public String createTableSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
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
        return "settingInfo";
    }

    private static int a(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("settingField", str);
            contentValues.put("value", str2);
            contentValues.put("type", str3);
            int update = sQLiteDatabase.update("settingInfo", contentValues, "settingField = ?", new String[]{str});
            if (update > 0) {
                return update;
            }
            return 0;
        } catch (Exception e16) {
            r.a("DownloadSettingTable", "exception: ", e16);
            e16.printStackTrace();
            return -2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (r1 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r1 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase readableDatabase = com.tencent.tmdownloader.f.b.d.a.c().getReadableDatabase();
                if (readableDatabase == null || (cursor = readableDatabase.rawQuery("select * from settingInfo", null)) == null || !cursor.moveToFirst()) {
                }
                do {
                    hashMap.put(cursor.getString(cursor.getColumnIndex("settingField")), cursor.getString(cursor.getColumnIndex("value")));
                } while (cursor.moveToNext());
                cursor.close();
                return hashMap;
            } catch (Exception e16) {
                r.a("DownloadSettingTable", "exception: ", e16);
                e16.printStackTrace();
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }
}
