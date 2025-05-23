package hy0;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.persistence.TableBuilder;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements ou0.a {
    @Override // ou0.a
    public boolean a(SQLiteDatabase sQLiteDatabase, String str, int i3, int i16) {
        g.h("ICGameBaseTimiDatabaseTableHandler", "UserInfoTableHandler#onDatabaseUpgrade oldVersion=" + i3 + ", newVersion=" + i16);
        if (i16 == 2) {
            Map<Class<?>, String> map = TableBuilder.TYPES;
            sQLiteDatabase.execSQL(TableBuilder.addColumn(str, "nearbyUserInfo", map.get(byte[].class), false, 0));
            sQLiteDatabase.execSQL(TableBuilder.addColumn(str, "qqUin", map.get(Long.TYPE), false, 0));
        }
        return false;
    }
}
