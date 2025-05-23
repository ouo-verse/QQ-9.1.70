package com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class EntranceItem {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(EntranceItem.class, "iconSrc", "getIconSrc()Ljava/lang/String;", 0)};
    public final String darkIcon;
    public final String defaultIcon;
    public final String icon;
    public final ReadWriteProperty iconSrc$delegate;
    public final String scheme;
    public final String title;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EntranceItem() {
        this(r0, r0, r0, 31);
        String str = null;
    }

    public final int hashCode() {
        return this.darkIcon.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.defaultIcon, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.scheme, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.title, this.icon.hashCode() * 31, 31), 31), 31);
    }

    public final void setIconSrc(String str) {
        this.iconSrc$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("EntranceItem(icon=");
        m3.append(this.icon);
        m3.append(", title=");
        m3.append(this.title);
        m3.append(", scheme=");
        m3.append(this.scheme);
        m3.append(", defaultIcon=");
        m3.append(this.defaultIcon);
        m3.append(", darkIcon=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.darkIcon, ')');
    }

    public /* synthetic */ EntranceItem(String str, String str2, String str3, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : null, (i3 & 16) != 0 ? "" : null);
    }

    public EntranceItem(String str, String str2, String str3, String str4, String str5) {
        this.icon = str;
        this.title = str2;
        this.scheme = str3;
        this.defaultIcon = str4;
        this.darkIcon = str5;
        this.iconSrc$delegate = c.a("");
        setIconSrc(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntranceItem)) {
            return false;
        }
        EntranceItem entranceItem = (EntranceItem) obj;
        return Intrinsics.areEqual(this.icon, entranceItem.icon) && Intrinsics.areEqual(this.title, entranceItem.title) && Intrinsics.areEqual(this.scheme, entranceItem.scheme) && Intrinsics.areEqual(this.defaultIcon, entranceItem.defaultIcon) && Intrinsics.areEqual(this.darkIcon, entranceItem.darkIcon);
    }
}
