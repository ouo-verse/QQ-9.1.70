package com.tencent.hippykotlin.demo.pages.goods_center.event;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterEventDataSearchText {
    public final int searchType;
    public final String text;

    public GoodsCenterEventDataSearchText(String str, int i3) {
        this.text = str;
        this.searchType = i3;
    }

    public final int hashCode() {
        return BoxType$EnumUnboxingSharedUtility.ordinal(this.searchType) + (this.text.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterEventDataSearchText(text=");
        m3.append(this.text);
        m3.append(", searchType=");
        m3.append(GoodsCenterSearchType$EnumUnboxingLocalUtility.stringValueOf(this.searchType));
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterEventDataSearchText)) {
            return false;
        }
        GoodsCenterEventDataSearchText goodsCenterEventDataSearchText = (GoodsCenterEventDataSearchText) obj;
        return Intrinsics.areEqual(this.text, goodsCenterEventDataSearchText.text) && this.searchType == goodsCenterEventDataSearchText.searchType;
    }
}
