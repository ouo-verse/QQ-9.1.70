package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public final class AIPictureCardInfo {
    public final String actionText;
    public final String actionUrl;
    public final String icon;
    public final boolean isShow;
    public final String loadingText;
    public final String prompt;
    public final String topic;

    public AIPictureCardInfo(String str, String str2, String str3, String str4, String str5, boolean z16, String str6) {
        this.icon = str;
        this.topic = str2;
        this.prompt = str3;
        this.actionText = str4;
        this.actionUrl = str5;
        this.isShow = z16;
        this.loadingText = str6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.actionUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.actionText, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.prompt, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.topic, this.icon.hashCode() * 31, 31), 31), 31), 31);
        boolean z16 = this.isShow;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return this.loadingText.hashCode() + ((m3 + i3) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("AIPictureCardInfo(icon=");
        m3.append(this.icon);
        m3.append(", topic=");
        m3.append(this.topic);
        m3.append(", prompt=");
        m3.append(this.prompt);
        m3.append(", actionText=");
        m3.append(this.actionText);
        m3.append(", actionUrl=");
        m3.append(this.actionUrl);
        m3.append(", isShow=");
        m3.append(this.isShow);
        m3.append(", loadingText=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.loadingText, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIPictureCardInfo)) {
            return false;
        }
        AIPictureCardInfo aIPictureCardInfo = (AIPictureCardInfo) obj;
        return Intrinsics.areEqual(this.icon, aIPictureCardInfo.icon) && Intrinsics.areEqual(this.topic, aIPictureCardInfo.topic) && Intrinsics.areEqual(this.prompt, aIPictureCardInfo.prompt) && Intrinsics.areEqual(this.actionText, aIPictureCardInfo.actionText) && Intrinsics.areEqual(this.actionUrl, aIPictureCardInfo.actionUrl) && this.isShow == aIPictureCardInfo.isShow && Intrinsics.areEqual(this.loadingText, aIPictureCardInfo.loadingText);
    }
}
