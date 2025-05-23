package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import android.content.Context;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.c;
import com.qq.e.comm.plugin.base.ad.e.a;
import com.qq.e.comm.plugin.k.d;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.b;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AppInstallationStateReport extends AbsJumpNode {
    public AppInstallationStateReport(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return d.a(this.f38545c);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected int b(AbsJumpNode.a aVar) {
        int i3;
        String b16 = d.c(this.f38545c).b();
        Context b17 = this.f38544b.b().b();
        boolean a16 = c.a(this.f38544b);
        JSONObject jSONObject = new JSONObject();
        if (a16) {
            i3 = 2;
        } else {
            i3 = 4;
        }
        try {
            jSONObject.putOpt(LinkReportConstant$BizKey.DOWNLOAD_SCENE, Integer.valueOf(i3));
        } catch (JSONException e16) {
            GDTLogger.e(e16.getMessage());
        }
        b a17 = z.a(this.f38544b, jSONObject);
        if (com.qq.e.comm.plugin.k.c.a(b17, b16)) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_APP_INSTALLED, 0, a17);
            a.f(this.f38544b.e(), this.f38544b.d(), this.f38545c);
        } else {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_APP_NOT_INSTALLED, 0, a17);
            a.g(this.f38544b.e(), this.f38544b.d(), this.f38545c);
        }
        return 2;
    }
}
