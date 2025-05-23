package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class MiddlePageShareConfig {
    public final String descFallbackText;
    public final String posterText;
    public final String titleFallbackText;
    public final String wxShareDesc;
    public final String wxShareTitle;

    public MiddlePageShareConfig() {
        this((String) null, (String) null, (String) null, (String) null, 31);
    }

    public final int hashCode() {
        return this.wxShareDesc.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.wxShareTitle, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.descFallbackText, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.titleFallbackText, this.posterText.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("MiddlePageShareConfig(posterText=");
        m3.append(this.posterText);
        m3.append(", titleFallbackText=");
        m3.append(this.titleFallbackText);
        m3.append(", descFallbackText=");
        m3.append(this.descFallbackText);
        m3.append(", wxShareTitle=");
        m3.append(this.wxShareTitle);
        m3.append(", wxShareDesc=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.wxShareDesc, ')');
    }

    public MiddlePageShareConfig(String str, String str2, String str3, String str4, String str5) {
        this.posterText = str;
        this.titleFallbackText = str2;
        this.descFallbackText = str3;
        this.wxShareTitle = str4;
        this.wxShareDesc = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiddlePageShareConfig)) {
            return false;
        }
        MiddlePageShareConfig middlePageShareConfig = (MiddlePageShareConfig) obj;
        return Intrinsics.areEqual(this.posterText, middlePageShareConfig.posterText) && Intrinsics.areEqual(this.titleFallbackText, middlePageShareConfig.titleFallbackText) && Intrinsics.areEqual(this.descFallbackText, middlePageShareConfig.descFallbackText) && Intrinsics.areEqual(this.wxShareTitle, middlePageShareConfig.wxShareTitle) && Intrinsics.areEqual(this.wxShareDesc, middlePageShareConfig.wxShareDesc);
    }

    public /* synthetic */ MiddlePageShareConfig(String str, String str2, String str3, String str4, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) == 0 ? null : "");
    }
}
