package com.tencent.timi.game.initer.impl;

import ag4.h;
import ag4.i;
import android.text.TextUtils;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static void a() {
        l.h("DataBaseTableIniter", 1, "init");
        b();
        String B = ((ll4.a) mm4.b.b(ll4.a.class)).B();
        if (!TextUtils.isEmpty(B)) {
            YesDataBaseHelper.f().g(B);
            return;
        }
        l.f("DataBaseTableIniter", "uin is empty!!! " + B, new Exception());
    }

    private static void b() {
        l.i("DataBaseTableIniter", "registerTables");
        ((bo4.d) mm4.b.b(bo4.d.class)).initRegisterDatabaseModelClass();
        ((i) mm4.b.b(i.class)).initRegisterDatabaseModelClass();
        ((h) mm4.b.b(h.class)).initRegisterDatabaseModelClass();
        ((ni4.a) mm4.b.b(ni4.a.class)).initRegisterDatabaseModelClass();
    }
}
