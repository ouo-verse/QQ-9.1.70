package oicq.wlogin_sdk.request;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends SQLiteOpenHelper {
    public b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
