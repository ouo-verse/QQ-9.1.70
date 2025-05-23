package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import com.qq.e.comm.plugin.base.ad.b;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.a.a;
import com.qq.e.comm.plugin.base.ad.clickcomponent.c.c;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CGINode extends AbsJumpNode {
    public CGINode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        if (this.f38544b.q() || this.f38544b.j().optInt("price_mode") == 2 || this.f38544b.c().f38510b != b.SPLASH) {
            c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, this.f38544b, 4, 0);
            this.f38544b.i().a(new a.InterfaceC0279a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.CGINode.1
                @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
                public void a(int i3, JSONObject jSONObject) {
                    if (i3 != 200 && i3 != 302) {
                        c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, ((AbsJumpNode) CGINode.this).f38544b, 4, i3);
                    } else {
                        c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_SUCCESS, ((AbsJumpNode) CGINode.this).f38544b, 4, i3);
                    }
                    StatTracer.instantReport(((AbsJumpNode) CGINode.this).f38544b == null ? null : ((AbsJumpNode) CGINode.this).f38544b.n());
                }

                @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
                public void a(Exception exc) {
                    c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, ((AbsJumpNode) CGINode.this).f38544b, 4, 0);
                    StatTracer.instantReport(((AbsJumpNode) CGINode.this).f38544b == null ? null : ((AbsJumpNode) CGINode.this).f38544b.n());
                }
            });
            this.f38544b.i().a();
        }
        return 4;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public void a(AbsJumpNode.a aVar) {
        super.a(aVar);
    }
}
