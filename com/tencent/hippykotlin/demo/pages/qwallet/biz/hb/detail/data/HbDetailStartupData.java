package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbDetailStartupData {
    public final String authKey;
    public final String groupId;
    public final String groupType;
    public final String listId;

    public HbDetailStartupData(String str, String str2, String str3, String str4) {
        this.listId = str;
        this.authKey = str2;
        this.groupType = str3;
        this.groupId = str4;
    }

    public final int hashCode() {
        String str = this.listId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.authKey;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.groupId;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("HbDetailStartupData(listId=");
        m3.append(this.listId);
        m3.append(", authKey=");
        m3.append(this.authKey);
        m3.append(", groupType=");
        m3.append(this.groupType);
        m3.append(", groupId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.groupId, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HbDetailStartupData)) {
            return false;
        }
        HbDetailStartupData hbDetailStartupData = (HbDetailStartupData) obj;
        return Intrinsics.areEqual(this.listId, hbDetailStartupData.listId) && Intrinsics.areEqual(this.authKey, hbDetailStartupData.authKey) && Intrinsics.areEqual(this.groupType, hbDetailStartupData.groupType) && Intrinsics.areEqual(this.groupId, hbDetailStartupData.groupId);
    }
}
