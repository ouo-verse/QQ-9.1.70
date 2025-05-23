package eo4;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.timi.game.utils.l;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements rg4.a {
    @Override // rg4.a
    public boolean a(SQLiteDatabase sQLiteDatabase, String str, int i3, int i16) {
        l.i("BaseTimiDatabaseTableHandler", "UserInfoTableHandler#onDatabaseUpgrade oldVersion=" + i3 + ", newVersion=" + i16);
        if (i16 == 2) {
            Map<Class<?>, String> map = TableBuilder.TYPES;
            sQLiteDatabase.execSQL(TableBuilder.addColumn(str, "nearbyUserInfo", map.get(byte[].class), false, 0));
            sQLiteDatabase.execSQL(TableBuilder.addColumn(str, "qqUin", map.get(Long.TYPE), false, 0));
        }
        return false;
    }
}
