package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainBubbleInfo;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainReportModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public final class LiveExplainPageAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainPageAttr.class, "closeAnimationFlag", "getCloseAnimationFlag()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainPageAttr.class, "showAnimationFlag", "getShowAnimationFlag()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainPageAttr.class, "cutoverAnimationFlag", "getCutoverAnimationFlag()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainPageAttr.class, "hotSaleAppearAnimated", "getHotSaleAppearAnimated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainPageAttr.class, "bubbleInfo", "getBubbleInfo()Lcom/tencent/hippykotlin/demo/pages/qqlive_biz/live_explain_page/model/ExplainBubbleInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainPageAttr.class, "nextBubbleInfo", "getNextBubbleInfo()Lcom/tencent/hippykotlin/demo/pages/qqlive_biz/live_explain_page/model/ExplainBubbleInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainPageAttr.class, "hotSaleNum", "getHotSaleNum()I", 0)};
    public int enterRoomTime;
    public int explainViewExposeTime;
    public LiveExplainReportModel reportModel;
    public final ReadWriteProperty closeAnimationFlag$delegate = c.a(0);
    public final ReadWriteProperty showAnimationFlag$delegate = c.a(0);
    public final ReadWriteProperty cutoverAnimationFlag$delegate = c.a(0);
    public final ReadWriteProperty hotSaleAppearAnimated$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty bubbleInfo$delegate = c.a(null);
    public final ReadWriteProperty nextBubbleInfo$delegate = c.a(null);
    public final ReadWriteProperty hotSaleNum$delegate = c.a(0);

    public final ExplainBubbleInfo getBubbleInfo() {
        return (ExplainBubbleInfo) this.bubbleInfo$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final int getCloseAnimationFlag() {
        return ((Number) this.closeAnimationFlag$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final int getCutoverAnimationFlag() {
        return ((Number) this.cutoverAnimationFlag$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final boolean getHotSaleAppearAnimated() {
        return ((Boolean) this.hotSaleAppearAnimated$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final int getHotSaleNum() {
        return ((Number) this.hotSaleNum$delegate.getValue(this, $$delegatedProperties[6])).intValue();
    }

    public final int getShowAnimationFlag() {
        return ((Number) this.showAnimationFlag$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final void setCloseAnimationFlag(int i3) {
        this.closeAnimationFlag$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }

    public final void setHotSaleAppearAnimated(boolean z16) {
        this.hotSaleAppearAnimated$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z16));
    }

    public final void setHotSaleNum(int i3) {
        this.hotSaleNum$delegate.setValue(this, $$delegatedProperties[6], Integer.valueOf(i3));
    }

    public final void setNextBubbleInfo(ExplainBubbleInfo explainBubbleInfo) {
        this.nextBubbleInfo$delegate.setValue(this, $$delegatedProperties[5], explainBubbleInfo);
    }

    public final void setShowAnimationFlag(int i3) {
        this.showAnimationFlag$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }
}
