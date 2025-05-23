package com.tencent.icgame.game.initer.impl;

import android.text.TextUtils;
import com.tencent.icgame.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.icgame.game.utils.g;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static void a() {
        g.g("ICGameDataBaseTableIniter", 1, "init");
        b();
        String B = ((mx0.a) qx0.a.b(mx0.a.class)).B();
        if (!TextUtils.isEmpty(B)) {
            YesDataBaseHelper.f().g(B);
            return;
        }
        g.e("ICGameDataBaseTableIniter", "uin is empty!!! " + B, new Exception());
    }

    private static void b() {
        g.h("ICGameDataBaseTableIniter", "registerTables");
        ((ey0.d) qx0.a.b(ey0.d.class)).initRegisterDatabaseModelClass();
    }
}
