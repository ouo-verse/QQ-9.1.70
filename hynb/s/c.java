package hynb.s;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c extends SQLiteOpenHelper {
    public c(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS task_data(id integer primary key ,uuid blob, content blob, createTime integer, lastSendTime integer, sendCount integer, isSuccess integer)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(16)
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        try {
            sQLiteDatabase.enableWriteAheadLogging();
        } catch (Exception unused) {
        }
    }
}
