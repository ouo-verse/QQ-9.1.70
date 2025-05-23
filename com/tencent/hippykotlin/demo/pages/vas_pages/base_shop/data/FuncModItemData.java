package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class FuncModItemData extends ItemData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FuncModItemData.class, "title", "getTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FuncModItemData.class, "desc", "getDesc()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FuncModItemData.class, "icon", "getIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FuncModItemData.class, "url", "getUrl()Ljava/lang/String;", 0)};
    public final ReadWriteProperty title$delegate = c.a("");
    public final ReadWriteProperty desc$delegate = c.a("");
    public final ReadWriteProperty icon$delegate = c.a("");
    public final ReadWriteProperty url$delegate = c.a("");

    public final String getDesc() {
        return (String) this.desc$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final String getIcon() {
        return (String) this.icon$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final String getTitle() {
        return (String) this.title$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final String getUrl() {
        return (String) this.url$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setDesc(String str) {
        this.desc$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setIcon(String str) {
        this.icon$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setTitle(String str) {
        this.title$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setUrl(String str) {
        this.url$delegate.setValue(this, $$delegatedProperties[3], str);
    }
}
