package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainBubbleInfo;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExplainBubbleViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExplainBubbleViewAttr.class, "state", "getState()Lcom/tencent/hippykotlin/demo/pages/qqlive_biz/live_explain_page/view/ExplainState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExplainBubbleViewAttr.class, "bubbleInfo", "getBubbleInfo()Lcom/tencent/hippykotlin/demo/pages/qqlive_biz/live_explain_page/model/ExplainBubbleInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExplainBubbleViewAttr.class, "activityMaskURL", "getActivityMaskURL()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExplainBubbleViewAttr.class, "buyBtnActivityTxt", "getBuyBtnActivityTxt()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExplainBubbleViewAttr.class, "isHRC", "isHRC()I", 0)};
    public final ReadWriteProperty state$delegate = c.a(ExplainState.EXPLAINING);
    public final ReadWriteProperty bubbleInfo$delegate = c.a(null);
    public final ReadWriteProperty activityMaskURL$delegate = c.a("");
    public final ReadWriteProperty buyBtnActivityTxt$delegate = c.a("");
    public final ReadWriteProperty isHRC$delegate = c.a(0);

    public final ExplainBubbleInfo getBubbleInfo() {
        return (ExplainBubbleInfo) this.bubbleInfo$delegate.getValue(this, $$delegatedProperties[1]);
    }
}
