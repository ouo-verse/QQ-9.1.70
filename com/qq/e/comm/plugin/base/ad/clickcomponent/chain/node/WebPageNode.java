package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.plugin.base.a.a;
import com.qq.e.comm.plugin.base.ad.b;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.c;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class WebPageNode extends AbsJumpNode {
    public WebPageNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        return c.e(this.f38544b) == 1;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        Context context;
        boolean z16;
        String str;
        ClickInfo clickInfo = this.f38544b;
        boolean z17 = true;
        if (clickInfo == null) {
            GDTLogger.e("WebPageNode clickInfo is null");
            return 1;
        }
        if (clickInfo.b() != null) {
            context = this.f38544b.b().b();
        } else {
            context = null;
        }
        String h16 = this.f38544b.h();
        if (this.f38544b.q() && this.f38544b.g() == 3 && this.f38544b.c().f38510b == b.SPLASH) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h16 = y.e(this.f38544b.d().v(), "mqq_landing_page");
        }
        CustomLandingPageListener.Params params = new CustomLandingPageListener.Params();
        params.setWeakContext(new WeakReference<>(context));
        params.setLandingPageUrl(h16);
        if (y.a(this.f38544b.j())) {
            str = this.f38544b.j().toString();
        } else {
            str = "";
        }
        params.setAdData(str);
        params.setBundle(GlobalSetting.getCustomBundle());
        if (this.f38544b.f() == null || !this.f38544b.f().e()) {
            z17 = false;
        }
        params.setNeedNewTask(z17);
        if (a.a().a(params)) {
            GDTLogger.d("jump to custom webView");
            StatTracer.trackEvent(4003036, 0, z.a(this.f38544b, (JSONObject) null));
        }
        if (this.f38544b.r()) {
            return 2;
        }
        return 4;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public void a(AbsJumpNode.a aVar) {
        super.a(aVar);
    }
}
