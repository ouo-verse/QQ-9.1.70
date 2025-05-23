package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import android.content.Context;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.e;
import com.qq.e.comm.plugin.k.b;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQMiniGameNode extends AbsJumpNode {
    public QQMiniGameNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return b.f(this.f38545c);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected int b(AbsJumpNode.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        a(this.f38544b, 0);
        String optString = this.f38545c.optString("mqq_landing_page");
        if (StringUtil.isEmpty(optString)) {
            a(this.f38544b, 5);
        }
        Context b16 = this.f38544b.b().b();
        if (this.f38544b.b().a() != null) {
            i3 = e.a(optString, b16, this.f38544b.b().a());
        }
        GDTLogger.d("start qq mini game time is, " + (System.currentTimeMillis() - currentTimeMillis));
        a(this.f38544b, i3);
        if (i3 == 1) {
            return 3;
        }
        return 2;
    }

    private static void a(ClickInfo clickInfo, int i3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        c cVar = new c();
        String s16 = clickInfo.d().s();
        cVar.a("posId", s16);
        bVar.a(s16);
        String optString = clickInfo.j().optString("cl");
        cVar.a("cl", optString);
        bVar.b(optString);
        bVar.c(clickInfo.j().optString("traceid"));
        StatTracer.trackEvent(i3 + 1320020, 0, bVar, cVar);
    }
}
