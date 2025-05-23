package g05;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes28.dex */
abstract class a extends SQLiteOpenHelper {
    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
    }

    protected abstract void a(SQLiteDatabase sQLiteDatabase, int i3, int i16);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Exception e16) {
            l.e("BaseSQLHelper_", "getReadableDatabase: " + e16.getMessage());
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Exception e16) {
            l.e("BaseSQLHelper_", "getWritableDatabase: " + e16.getMessage());
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        try {
            l.b("BaseSQLHelper_", ">onUpgrade " + i3 + "|" + i16);
            while (i3 < i16) {
                int i17 = i3 + 1;
                a(sQLiteDatabase, i3, i17);
                i3 = i17;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
