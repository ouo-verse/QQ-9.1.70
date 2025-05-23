package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class LuckyBagPendantPage$updateData$1 extends Lambda implements Function3<LBPPageModel, Boolean, String, Unit> {
    public final /* synthetic */ boolean $fromPush;
    public final /* synthetic */ e $pushData;
    public final /* synthetic */ LuckyBagPendantPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyBagPendantPage$updateData$1(LuckyBagPendantPage luckyBagPendantPage, boolean z16, e eVar) {
        super(3);
        this.this$0 = luckyBagPendantPage;
        this.$fromPush = z16;
        this.$pushData = eVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(LBPPageModel lBPPageModel, Boolean bool, String str) {
        String str2 = str;
        if (!bool.booleanValue()) {
            Utils utils = Utils.INSTANCE;
            String pagerId = this.this$0.getPagerId();
            utils.bridgeModule(pagerId).log(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("LuckyBagPendantPage request error:", str2));
            final LuckyBagPendantPage luckyBagPendantPage = this.this$0;
            boolean z16 = this.$fromPush;
            e eVar = this.$pushData;
            luckyBagPendantPage.getClass();
            utils.bridgeModule(luckyBagPendantPage.getPagerId()).log("LuckyBagPendantPage retryRequestData");
            luckyBagPendantPage.getPageModel().requestData(z16, eVar, new Function3<LBPPageModel, Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage$retryRequestData$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(LBPPageModel lBPPageModel2, Boolean bool2, String str3) {
                    String str4 = str3;
                    if (!bool2.booleanValue()) {
                        Utils utils2 = Utils.INSTANCE;
                        String pagerId2 = LuckyBagPendantPage.this.getPagerId();
                        utils2.bridgeModule(pagerId2).log(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("LuckyBagPendantPage retry request error:", str4));
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}
