package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CouponBackgroundAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CouponBackgroundAttr.class, "showStyleDisable", "getShowStyleDisable()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CouponBackgroundAttr.class, "borderColorToken", "getBorderColorToken()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CouponBackgroundAttr.class, "backgroundColorToken", "getBackgroundColorToken()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CouponBackgroundAttr.class, NodeProps.BORDER_COLOR, "getBorderColor()J", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CouponBackgroundAttr.class, "backgroundColor", "getBackgroundColor()J", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CouponBackgroundAttr.class, "dashLineColorToken", "getDashLineColorToken()Ljava/lang/String;", 0)};
    public float rightAreaWidth = 84.0f;
    public float couponBgOpacity = 0.5f;
    public final ReadWriteProperty showStyleDisable$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty borderColorToken$delegate = c.a("");
    public final ReadWriteProperty backgroundColorToken$delegate = c.a("");
    public final ReadWriteProperty borderColor$delegate = c.a(0L);
    public final ReadWriteProperty backgroundColor$delegate = c.a(0L);
    public final ReadWriteProperty dashLineColorToken$delegate = c.a("");

    public final boolean getShowStyleDisable() {
        return ((Boolean) this.showStyleDisable$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setDashLineColorToken(String str) {
        this.dashLineColorToken$delegate.setValue(this, $$delegatedProperties[5], str);
    }

    public final void setShowStyleDisable(boolean z16) {
        this.showStyleDisable$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
