package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class GoodsItemData extends ItemData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsItemData.class, "title", "getTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsItemData.class, "type", "getType()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsItemData.class, "url", "getUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsItemData.class, "itemId", "getItemId()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsItemData.class, "price", "getPrice()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsItemData.class, "isDressUp", "isDressUp()Z", 0)};
    public final ReadWriteProperty title$delegate = c.a("");
    public final ReadWriteProperty type$delegate = c.a("");
    public final ReadWriteProperty url$delegate = c.a("");
    public final ReadWriteProperty itemId$delegate = c.a("");
    public final ReadWriteProperty price$delegate = c.a(Float.valueOf(0.0f));

    public GoodsItemData() {
        c.a(Boolean.FALSE);
    }

    public final void setItemId(String str) {
        this.itemId$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setPrice(float f16) {
        this.price$delegate.setValue(this, $$delegatedProperties[4], Float.valueOf(f16));
    }

    public final void setTitle(String str) {
        this.title$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setType(String str) {
        this.type$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setUrl(String str) {
        this.url$delegate.setValue(this, $$delegatedProperties[2], str);
    }
}
