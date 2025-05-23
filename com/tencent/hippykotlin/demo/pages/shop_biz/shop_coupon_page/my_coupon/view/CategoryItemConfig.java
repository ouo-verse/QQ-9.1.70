package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.base.h;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CategoryItemConfig extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CategoryItemConfig.class, QZoneJsConstants.KEY_HIGH_FIVE_TEXT, "getItemText$qecommerce_biz_release()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CategoryItemConfig.class, "isChoose", "isChoose$qecommerce_biz_release()Z", 0)};
    public final ReadWriteProperty isChoose$delegate;
    public final ReadWriteProperty itemText$delegate = c.a("");
    public h itemTextColor;

    public CategoryItemConfig() {
        h hVar;
        SkinColor skinColor = SkinColor.INSTANCE;
        Utils.INSTANCE.currentBridgeModule().getPagerId();
        hVar = SkinColor.INSTANCE.tokenColor("qecommerce_skin_color_text_primary", false);
        this.itemTextColor = hVar;
        this.isChoose$delegate = c.a(Boolean.FALSE);
    }

    public final void text(String str) {
        this.itemText$delegate.setValue(this, $$delegatedProperties[0], str);
    }
}
