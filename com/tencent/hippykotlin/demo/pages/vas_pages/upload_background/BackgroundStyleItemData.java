package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.BaseObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BackgroundStyleItemData extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundStyleItemData.class, "isSelected", "isSelected()Z", 0)};
    public boolean isFree;
    public int itemId;
    public final ReadWriteProperty isSelected$delegate = c.a(Boolean.FALSE);
    public String backgroundTitle = "";
    public String backgroundImagePath = "";

    public final boolean isSelected() {
        return ((Boolean) this.isSelected$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
