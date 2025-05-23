package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoSelectData {
    public final String appId;
    public final String description;
    public final boolean isFirstChoice;
    public final boolean isSingleCheck;
    public final String subDescription;

    public JubaoSelectData(String str, String str2, String str3, boolean z16, boolean z17) {
        this.appId = str;
        this.description = str2;
        this.subDescription = str3;
        this.isSingleCheck = z16;
        this.isFirstChoice = z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.subDescription, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.description, this.appId.hashCode() * 31, 31), 31);
        boolean z16 = this.isSingleCheck;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (m3 + i3) * 31;
        boolean z17 = this.isFirstChoice;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("JubaoSelectData(appId=");
        m3.append(this.appId);
        m3.append(", description=");
        m3.append(this.description);
        m3.append(", subDescription=");
        m3.append(this.subDescription);
        m3.append(", isSingleCheck=");
        m3.append(this.isSingleCheck);
        m3.append(", isFirstChoice=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isFirstChoice, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JubaoSelectData)) {
            return false;
        }
        JubaoSelectData jubaoSelectData = (JubaoSelectData) obj;
        return Intrinsics.areEqual(this.appId, jubaoSelectData.appId) && Intrinsics.areEqual(this.description, jubaoSelectData.description) && Intrinsics.areEqual(this.subDescription, jubaoSelectData.subDescription) && this.isSingleCheck == jubaoSelectData.isSingleCheck && this.isFirstChoice == jubaoSelectData.isFirstChoice;
    }
}
