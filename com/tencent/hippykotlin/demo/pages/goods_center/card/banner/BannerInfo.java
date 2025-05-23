package com.tencent.hippykotlin.demo.pages.goods_center.card.banner;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BannerInfo {
    public final String bannerId;
    public final String bannerName;
    public final String imageUrl;
    public final String jumpUrl;

    public BannerInfo(String str, String str2, String str3, String str4) {
        this.imageUrl = str;
        this.jumpUrl = str2;
        this.bannerId = str3;
        this.bannerName = str4;
    }

    public final int hashCode() {
        return this.bannerName.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.bannerId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.jumpUrl, this.imageUrl.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BannerInfo(imageUrl=");
        m3.append(this.imageUrl);
        m3.append(", jumpUrl=");
        m3.append(this.jumpUrl);
        m3.append(", bannerId=");
        m3.append(this.bannerId);
        m3.append(", bannerName=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.bannerName, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerInfo)) {
            return false;
        }
        BannerInfo bannerInfo = (BannerInfo) obj;
        return Intrinsics.areEqual(this.imageUrl, bannerInfo.imageUrl) && Intrinsics.areEqual(this.jumpUrl, bannerInfo.jumpUrl) && Intrinsics.areEqual(this.bannerId, bannerInfo.bannerId) && Intrinsics.areEqual(this.bannerName, bannerInfo.bannerName);
    }
}
