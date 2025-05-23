package com.qq.e.comm.plugin.base.ad.clickcomponent;

import com.qq.e.comm.plugin.base.ad.clickcomponent.b;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static void a(ClickInfo clickInfo) {
        if (clickInfo == null) {
            return;
        }
        b a16 = new b.a().a(clickInfo).a();
        final long currentTimeMillis = System.currentTimeMillis();
        a16.a().a(new com.qq.e.comm.plugin.base.ad.clickcomponent.b.b() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.c.1
            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.b.b
            public void a(com.qq.e.comm.plugin.base.ad.clickcomponent.b.a aVar, ClickResult clickResult) {
                GDTLogger.d("click total cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }

            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.b.b
            public void a(com.qq.e.comm.plugin.base.ad.clickcomponent.b.a aVar, Exception exc) {
                exc.printStackTrace();
            }
        });
    }
}
