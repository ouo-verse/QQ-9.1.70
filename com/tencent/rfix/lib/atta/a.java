package com.tencent.rfix.lib.atta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.rfix.loader.log.RFixLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends SQLiteOpenHelper {
    static IPatchRedirector $redirector_;

    public a(Context context) {
        super(context, "atta.db", (SQLiteDatabase.CursorFactory) null, 3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        try {
            if (getWritableDatabase().delete(QQPermissionConstants.Permission.AUIDO_GROUP, "_id=?", new String[]{String.valueOf(i3)}) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            RFixLog.e("RFix.ATTADatabaseHelper", "deleteATTARecord fail.", e16);
            return false;
        }
    }

    public List<b> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = getReadableDatabase().query(QQPermissionConstants.Permission.AUIDO_GROUP, new String[]{"_id", "process", "params"}, "process=?", new String[]{str}, null, null, null);
            int columnIndex = query.getColumnIndex("_id");
            int columnIndex2 = query.getColumnIndex("params");
            while (query.moveToNext()) {
                arrayList.add(new b(query.getInt(columnIndex), str, query.getString(columnIndex2)));
            }
            query.close();
        } catch (Exception e16) {
            RFixLog.e("RFix.ATTADatabaseHelper", "getAllATTARecord fail.", e16);
        }
        return arrayList;
    }

    public long c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).longValue();
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("process", str);
            contentValues.put("params", str2);
            return getWritableDatabase().insert(QQPermissionConstants.Permission.AUIDO_GROUP, null, contentValues);
        } catch (Exception e16) {
            RFixLog.e("RFix.ATTADatabaseHelper", "insertATTARecord fail.", e16);
            return -1L;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteDatabase);
        } else {
            sQLiteDatabase.execSQL("create table record(_id integer primary key autoincrement, process text,params text)");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sQLiteDatabase, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        RFixLog.d("RFix.ATTADatabaseHelper", String.format("onUpgrade oldVersion=%s newVersion=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        sQLiteDatabase.execSQL("drop table if exists record");
        onCreate(sQLiteDatabase);
    }
}
