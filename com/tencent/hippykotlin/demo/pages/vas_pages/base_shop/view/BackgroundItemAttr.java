package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BackgroundItemAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundItemAttr.class, "itemWidth", "getItemWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundItemAttr.class, "isDressUp", "isDressUp()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundItemAttr.class, "isFromCache", "isFromCache()Z", 0)};
    public final ReadWriteProperty isDressUp$delegate;
    public final ReadWriteProperty isFromCache$delegate;
    public boolean isSvip;
    public float price;
    public String title = "";
    public String type = "";
    public String url = "";
    public String scene = "";
    public String itemId = "";
    public String strRuleId = "";
    public String moduleId = "";
    public final ReadWriteProperty itemWidth$delegate = c.a(Float.valueOf(0.0f));

    public BackgroundItemAttr() {
        Boolean bool = Boolean.FALSE;
        this.isDressUp$delegate = c.a(bool);
        this.isFromCache$delegate = c.a(bool);
    }

    public final float getItemWidth() {
        return ((Number) this.itemWidth$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }
}
