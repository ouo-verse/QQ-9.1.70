package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainBannerAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBannerAttr.class, "state", "getState()Lcom/tencent/hippykotlin/demo/pages/qqlive_biz/live_explain_page/view/ExplainState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBannerAttr.class, "leftTimeInfo", "getLeftTimeInfo()Ljava/lang/String;", 0)};
    public final ReadWriteProperty state$delegate = c.a(ExplainState.EXPLAINING);
    public final ReadWriteProperty leftTimeInfo$delegate = c.a("");

    public final ExplainState getState() {
        return (ExplainState) this.state$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
