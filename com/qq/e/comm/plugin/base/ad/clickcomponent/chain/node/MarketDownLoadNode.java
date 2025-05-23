package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.c;
import com.qq.e.comm.plugin.base.ad.model.f;
import com.qq.e.comm.plugin.base.ad.model.n;
import com.qq.e.comm.plugin.k.ao;
import com.qq.e.comm.plugin.k.az;
import com.qq.e.comm.plugin.k.d;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.b;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MarketDownLoadNode extends AbsJumpNode {

    /* renamed from: e, reason: collision with root package name */
    private int f38559e;

    public MarketDownLoadNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        n U;
        this.f38559e = 0;
        f d16 = this.f38544b.d();
        if (d16 != null && (U = d16.U()) != null) {
            this.f38559e = U.c();
        }
        if (!c.a(this.f38545c)) {
            return false;
        }
        int i3 = this.f38559e;
        return i3 == 1 || i3 == 2;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        String b16 = d.c(this.f38545c).b();
        if (TextUtils.isEmpty(b16)) {
            return 2;
        }
        Context context = null;
        b a16 = z.a(this.f38544b, (JSONObject) null);
        boolean z16 = false;
        if (ao.f(((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getStatus(b16)) && this.f38559e == 1) {
            a16.a(LinkReportConstant$BizKey.DOWNLOAD_SCENE, 1);
            StatTracer.trackEvent(4001033, 0, a16, (com.qq.e.comm.plugin.stat.c) null);
            if (this.f38544b.b() != null) {
                context = this.f38544b.b().b();
            }
            if (!az.b(context)) {
                context = GDTADManager.getInstance().getAppContext();
            }
            if (this.f38544b.f() != null && this.f38544b.f().c()) {
                z16 = true;
            }
            JSONObject a17 = com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.a(context, this.f38544b.j(), z16, 1);
            a(a17, a16);
            if (y.a(a17) && a17.optBoolean("result")) {
                return 3;
            }
        } else {
            a16.a(LinkReportConstant$BizKey.DOWNLOAD_SCENE, 3);
            StatTracer.trackEvent(4001034, 0, a16, (com.qq.e.comm.plugin.stat.c) null);
        }
        return 2;
    }

    private static void a(JSONObject jSONObject, b bVar) {
        int c16 = y.c(jSONObject, VirtualAppProxy.KEY_AUTO_DOWNLOAD);
        if (bVar != null) {
            bVar.a(LinkReportConstant$BizKey.AUTO_DOWNLOAD, c16);
        }
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_MARKET_START, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
        boolean a16 = y.a(jSONObject);
        int i3 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_MARKET_FAILED;
        if (!a16) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_MARKET_FAILED, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("result");
        JSONArray optJSONArray = jSONObject.optJSONArray("errorMessage");
        if (y.a(optJSONArray)) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_SINGLE_APP_MARKET_JUMP_START, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
            if (optBoolean) {
                i3 = 4001016;
            }
            StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
            return;
        }
        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_SINGLE_APP_MARKET_JUMP_START, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
            JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
            if (y.a(optJSONObject)) {
                b bVar2 = new b();
                bVar2.a(bVar != null ? bVar.a() : null);
                int optInt = optJSONObject.optInt("errorCode", -1);
                if (optInt != -1) {
                    bVar2.a("act_code", optInt);
                    StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_SINGLE_APP_MARKET_JUMP_FAILED, 0, bVar2, (com.qq.e.comm.plugin.stat.c) null);
                }
            }
        }
        if (optBoolean) {
            i3 = 4001016;
        }
        StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
    }
}
