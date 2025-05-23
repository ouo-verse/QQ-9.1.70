package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CategoryItemConfig {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CategoryItemConfig.class, "isSelected", "isSelected()Z", 0)};
    public final ReadWriteProperty isSelected$delegate = c.a(Boolean.FALSE);
    public final ItemStyle itemStyle;
    public final String title;

    public CategoryItemConfig(String str, ItemStyle itemStyle) {
        this.title = str;
        this.itemStyle = itemStyle;
    }

    public final int hashCode() {
        return this.itemStyle.hashCode() + (this.title.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CategoryItemConfig(title=");
        m3.append(this.title);
        m3.append(", itemStyle=");
        m3.append(this.itemStyle);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryItemConfig)) {
            return false;
        }
        CategoryItemConfig categoryItemConfig = (CategoryItemConfig) obj;
        return Intrinsics.areEqual(this.title, categoryItemConfig.title) && Intrinsics.areEqual(this.itemStyle, categoryItemConfig.itemStyle);
    }
}
