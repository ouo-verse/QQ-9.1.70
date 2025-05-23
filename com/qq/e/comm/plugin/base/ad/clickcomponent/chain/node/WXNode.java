package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.CustomWXLuggageListener;
import com.qq.e.comm.plugin.base.a.a;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.g;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.h;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.k.b;
import com.qq.e.comm.plugin.k.bb;
import com.qq.e.comm.plugin.k.i;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WXNode extends AbsJumpNode {
    public WXNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return b.e(this.f38545c) || b.g(this.f38545c) || this.f38544b.d().isWeChatCanvasAd();
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        boolean a16;
        if (this.f38544b.d().isWeChatCanvasAd()) {
            g.a(GDTADManager.getInstance().getAppContext(), this.f38544b);
            return 3;
        }
        if (b.g(this.f38545c)) {
            if (a.a().e() != null) {
                h.a(54029);
                final Exchanger exchanger = new Exchanger();
                a.a().e().jumpToWXLuggage(this.f38544b.d().M(), i.b(this.f38545c, this.f38544b.f()), this.f38544b.d().f(), this.f38544b.c().f38511c, null, new CustomWXLuggageListener.CallBack() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.WXNode.1
                    @Override // com.qq.e.comm.pi.CustomWXLuggageListener.CallBack
                    public void onFailed() {
                        h.a(54031);
                        try {
                            exchanger.exchange(Boolean.FALSE);
                        } catch (Exception e16) {
                            GDTLogger.e(e16.getMessage());
                        }
                    }

                    @Override // com.qq.e.comm.pi.CustomWXLuggageListener.CallBack
                    public void onSuccess() {
                        h.a(54030);
                        try {
                            exchanger.exchange(Boolean.TRUE);
                        } catch (Exception e16) {
                            GDTLogger.e(e16.getMessage());
                        }
                    }
                });
                a16 = false;
                try {
                    a16 = ((Boolean) exchanger.exchange(null, c.a(this.f38544b.c().f38511c, "wxLuggageTimeOut", 30000), TimeUnit.MILLISECONDS)).booleanValue();
                    h.a(54032);
                } catch (TimeoutException unused) {
                    h.a(54033);
                    return 3;
                } catch (Exception e16) {
                    GDTLogger.e(e16.getMessage());
                }
            } else {
                a16 = h.a(this.f38545c, this.f38546d, this.f38544b.f());
            }
            com.qq.e.comm.plugin.base.ad.e.a.a(a16, this.f38544b.e(), this.f38545c);
            if (a16) {
                return 3;
            }
        }
        return b();
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public void a(AbsJumpNode.a aVar) {
        super.a(aVar);
    }

    private int b() {
        JSONObject jSONObject = this.f38545c;
        boolean z16 = bb.a(jSONObject != null ? bb.a(jSONObject, this.f38544b.f()) : null, this.f38544b.j(), this.f38544b.c().f38511c, 3, true) == 0;
        com.qq.e.comm.plugin.base.ad.e.a.a(b.c(this.f38545c), z16, this.f38544b.e(), this.f38544b.d(), this.f38545c);
        if (this.f38544b.r()) {
            return 4;
        }
        return (z16 || !b.b(this.f38544b.d())) ? 3 : 2;
    }
}
