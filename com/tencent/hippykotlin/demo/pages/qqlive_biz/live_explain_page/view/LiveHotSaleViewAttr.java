package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveHotSaleViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveHotSaleViewAttr.class, "increaseAnimated", "getIncreaseAnimated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveHotSaleViewAttr.class, "appearAnimated", "getAppearAnimated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveHotSaleViewAttr.class, "hotSaleNum", "getHotSaleNum()I", 0)};
    public final ReadWriteProperty appearAnimated$delegate;
    public final ReadWriteProperty hotSaleNum$delegate;
    public final ReadWriteProperty increaseAnimated$delegate;

    public LiveHotSaleViewAttr() {
        Boolean bool = Boolean.FALSE;
        this.increaseAnimated$delegate = c.a(bool);
        this.appearAnimated$delegate = c.a(bool);
        this.hotSaleNum$delegate = c.a(1);
    }

    public final boolean getIncreaseAnimated() {
        return ((Boolean) this.increaseAnimated$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setIncreaseAnimated(boolean z16) {
        this.increaseAnimated$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
