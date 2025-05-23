package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.views.FooterRefreshState;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRefreshFooterAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshFooterAttr.class, "footerRefreshText", "getFooterRefreshText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshFooterAttr.class, "footerRefreshState", "getFooterRefreshState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshFooterAttr.class, "preloadDistance", "getPreloadDistance()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshFooterAttr.class, "showIphoneXSafeBottom", "getShowIphoneXSafeBottom()Z", 0)};
    public final ReadWriteProperty footerRefreshText$delegate = c.a("\u52a0\u8f7d\u66f4\u591a");
    public final ReadWriteProperty footerRefreshState$delegate = c.a(FooterRefreshState.IDLE);
    public final ReadWriteProperty preloadDistance$delegate = c.a(Float.valueOf(0.0f));
    public String footerNoMoreText = "\u6ca1\u6709\u66f4\u591a\u5546\u54c1\u4e86";
    public float footerHeight = 30.0f;
    public h footerTextColor = new h(4291611852L);
    public final ReadWriteProperty showIphoneXSafeBottom$delegate = c.a(Boolean.TRUE);

    public final void setFooterRefreshState(FooterRefreshState footerRefreshState) {
        this.footerRefreshState$delegate.setValue(this, $$delegatedProperties[1], footerRefreshState);
    }

    public final void setFooterRefreshText(String str) {
        this.footerRefreshText$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setPreloadDistance(float f16) {
        this.preloadDistance$delegate.setValue(this, $$delegatedProperties[2], Float.valueOf(f16));
    }
}
