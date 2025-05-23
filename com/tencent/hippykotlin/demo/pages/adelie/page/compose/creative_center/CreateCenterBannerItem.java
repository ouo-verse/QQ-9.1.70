package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CreateCenterBannerItem {
    public final String title;
    public final String url;

    public CreateCenterBannerItem() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final int hashCode() {
        return this.title.hashCode() + (this.url.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CreateCenterBannerItem(url=");
        m3.append(this.url);
        m3.append(", title=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.title, ')');
    }

    public CreateCenterBannerItem(String str, String str2) {
        this.url = str;
        this.title = str2;
    }

    public /* synthetic */ CreateCenterBannerItem(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateCenterBannerItem)) {
            return false;
        }
        CreateCenterBannerItem createCenterBannerItem = (CreateCenterBannerItem) obj;
        return Intrinsics.areEqual(this.url, createCenterBannerItem.url) && Intrinsics.areEqual(this.title, createCenterBannerItem.title);
    }
}
