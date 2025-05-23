package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.k.b;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class InterPageNode extends AbsJumpNode {
    public InterPageNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected int b(AbsJumpNode.a aVar) {
        if (!b.e(this.f38545c) && !b.g(this.f38545c) && !this.f38544b.d().isWeChatCanvasAd()) {
            GDTLogger.i("InterPageNode[handle] next");
            return 2;
        }
        GDTLogger.i("InterPageNode[handle] enter olympicInterPage");
        try {
            ((PublicApi.SplashApi) PublicApiHelper.getModuleApi(PublicApi.SplashApi.class)).startInterPage(this.f38544b.d(), 1);
            return 3;
        } catch (Throwable th5) {
            GDTLogger.e("InterPageNode,[handle] error", th5);
            return 3;
        }
    }
}
