package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.interceptor;

import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.c;

/* loaded from: classes3.dex */
public class InvalidParamsInterceptor extends AbsJumpNode {
    public InvalidParamsInterceptor(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        if (c.d(this.f38544b)) {
            ClickInfo clickInfo = this.f38544b;
            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(clickInfo, -2, this.f38543a, com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.b(clickInfo));
            return 1;
        }
        return 2;
    }
}
