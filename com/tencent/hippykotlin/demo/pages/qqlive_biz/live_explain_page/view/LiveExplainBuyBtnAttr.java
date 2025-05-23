package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainBuyBtnAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBuyBtnAttr.class, "explainState", "getExplainState()Lcom/tencent/hippykotlin/demo/pages/qqlive_biz/live_explain_page/view/ExplainState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBuyBtnAttr.class, "goodsPriceStr", "getGoodsPriceStr()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBuyBtnAttr.class, "pricesSuffix", "getPricesSuffix()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBuyBtnAttr.class, "buyBtnActivityTxt", "getBuyBtnActivityTxt()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBuyBtnAttr.class, "appearAnimated", "getAppearAnimated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBuyBtnAttr.class, "lightSweep", "getLightSweep()Z", 0)};
    public final ReadWriteProperty appearAnimated$delegate;
    public final ReadWriteProperty lightSweep$delegate;
    public final ReadWriteProperty explainState$delegate = c.a(ExplainState.EXPLAINING);
    public final ReadWriteProperty goodsPriceStr$delegate = c.a("");
    public final ReadWriteProperty pricesSuffix$delegate = c.a("");
    public final ReadWriteProperty buyBtnActivityTxt$delegate = c.a("");

    public LiveExplainBuyBtnAttr() {
        Boolean bool = Boolean.FALSE;
        this.appearAnimated$delegate = c.a(bool);
        this.lightSweep$delegate = c.a(bool);
    }

    public final void setGoodsPriceStr(String str) {
        this.goodsPriceStr$delegate.setValue(this, $$delegatedProperties[1], str);
    }
}
