package com.qq.e.comm.plugin.k;

import com.qq.e.comm.plugin.i.b;
import com.qq.e.comm.plugin.i.c;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {
    public static com.qq.e.comm.plugin.i.c a(com.qq.e.comm.plugin.i.b bVar) {
        return new c.a().a(15).b(com.qq.e.comm.plugin.j.c.a("splash_preload_material_shard_download_count", 3)).a(bVar).a();
    }

    public static com.qq.e.comm.plugin.i.b a() {
        if (!com.qq.e.comm.plugin.j.c.a("videoCacheCleanSwitch", 0, 1)) {
            GDTLogger.d("\u7f13\u5b58\u6e05\u9664\uff1a\u89c6\u9891\u6e05\u9664\u5f00\u5173\u5173\u95ed");
            return null;
        }
        return new b.a().a(ai.g()).c(1).a(com.qq.e.comm.plugin.j.c.a("videoCacheExpireTimeHour", 72)).b(com.qq.e.comm.plugin.j.c.a("videoCacheMaxSaveMemMByte", 100)).d(com.qq.e.comm.plugin.j.c.a("videoCacheCleanThreshPercentage", 80)).a();
    }
}
