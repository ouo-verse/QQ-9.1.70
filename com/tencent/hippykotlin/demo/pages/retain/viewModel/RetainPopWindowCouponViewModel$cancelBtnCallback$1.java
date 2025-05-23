package com.tencent.hippykotlin.demo.pages.retain.viewModel;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes33.dex */
public final class RetainPopWindowCouponViewModel$cancelBtnCallback$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RetainPopWindowCouponViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetainPopWindowCouponViewModel$cancelBtnCallback$1(RetainPopWindowCouponViewModel retainPopWindowCouponViewModel) {
        super(0);
        this.this$0 = retainPopWindowCouponViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("btn", "1");
        linkedHashMap.put("pop_type", "1");
        e eVar = this.this$0.reportJson;
        String str = (String) linkedHashMap.get("pop_type");
        if (str == null) {
            str = "";
        }
        eVar.v("pop_type", str);
        String str2 = (String) linkedHashMap.get("btn");
        eVar.v("btn", str2 != null ? str2 : "");
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().reportDT("qstore_prd_quit_pop_ck", eVar);
        utils.logToNative("[ProductDetailReporter] reportRecommendClk, event cod = qstore_prd_detail_pg_recommend_ck, data = " + eVar);
        b k3 = c.f117352a.k(BridgeManager.f117344a.u());
        e eVar2 = new e();
        eVar2.t("option", 0);
        IPagerIdKtxKt.callbackResult(k3, eVar2);
        BridgeModule.closePage$default(utils.currentBridgeModule(), null, null, 3);
        return Unit.INSTANCE;
    }
}
