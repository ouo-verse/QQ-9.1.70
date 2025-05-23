package iy0;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.persistence.TableBuilder;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements ou0.a {
    @Override // ou0.a
    public boolean a(SQLiteDatabase sQLiteDatabase, String str, int i3, int i16) {
        g.h("ICGameBaseTimiDatabaseTableHandler", "RoleInfoTableHandler#onDatabaseUpgrade oldVersion=" + i3 + ", newVersion=" + i16);
        if (i16 == 2) {
            sQLiteDatabase.execSQL(TableBuilder.addColumn(str, "qqUin", TableBuilder.TYPES.get(Long.TYPE), false, 0));
        }
        return false;
    }
}
