package fo4;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements rg4.a {
    @Override // rg4.a
    public boolean a(SQLiteDatabase sQLiteDatabase, String str, int i3, int i16) {
        l.i("BaseTimiDatabaseTableHandler", "RoleInfoTableHandler#onDatabaseUpgrade oldVersion=" + i3 + ", newVersion=" + i16);
        if (i16 == 2) {
            sQLiteDatabase.execSQL(TableBuilder.addColumn(str, "qqUin", TableBuilder.TYPES.get(Long.TYPE), false, 0));
        }
        return false;
    }
}
