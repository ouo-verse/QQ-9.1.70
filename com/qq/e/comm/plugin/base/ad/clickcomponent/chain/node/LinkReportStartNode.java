package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.c;
import com.tencent.ad.tangram.protocol.sdk_event_log;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LinkReportStartNode extends AbsJumpNode {
    public LinkReportStartNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        if (c.a()) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_CLICK, this.f38544b, -1, -1);
            return 2;
        }
        return 2;
    }
}
