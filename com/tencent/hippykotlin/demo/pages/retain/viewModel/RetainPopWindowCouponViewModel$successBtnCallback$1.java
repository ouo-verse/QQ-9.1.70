package com.tencent.hippykotlin.demo.pages.retain.viewModel;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.retain.model.Button;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes33.dex */
public final class RetainPopWindowCouponViewModel$successBtnCallback$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RetainPopWindowCouponViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetainPopWindowCouponViewModel$successBtnCallback$1(RetainPopWindowCouponViewModel retainPopWindowCouponViewModel) {
        super(0);
        this.this$0 = retainPopWindowCouponViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("btn", "2");
        linkedHashMap.put("pop_type", "1");
        e eVar = this.this$0.reportJson;
        String str2 = (String) linkedHashMap.get("pop_type");
        if (str2 == null) {
            str2 = "";
        }
        eVar.v("pop_type", str2);
        String str3 = (String) linkedHashMap.get("btn");
        if (str3 == null) {
            str3 = "";
        }
        eVar.v("btn", str3);
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().reportDT("qstore_prd_quit_pop_ck", eVar);
        utils.logToNative("[ProductDetailReporter] reportRecommendClk, event cod = qstore_prd_detail_pg_recommend_ck, data = " + eVar);
        b k3 = c.f117352a.k(BridgeManager.f117344a.u());
        e eVar2 = new e();
        eVar2.t("option", 1);
        IPagerIdKtxKt.callbackResult(k3, eVar2);
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        Button button = this.this$0.info.rsp.button;
        BridgeModule.openPage$default(currentBridgeModule, (button == null || (str = button.rightJumpurl) == null) ? "" : str, true, null, null, 28);
        return Unit.INSTANCE;
    }
}
