package com.tencent.hippykotlin.demo.pages.retain;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.retain.model.ActiveLabelInfo;
import com.tencent.hippykotlin.demo.pages.retain.model.GetPromotePopupRsp;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class RetainPopWindowInfo {
    public final GetPromotePopupRsp rsp;

    public RetainPopWindowInfo(GetPromotePopupRsp getPromotePopupRsp) {
        this.rsp = getPromotePopupRsp;
    }

    public final ArrayList<ActiveLabelInfo> activeList() {
        ArrayList<ActiveLabelInfo> arrayList = this.rsp.activeLables;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public final int hashCode() {
        return this.rsp.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RetainPopWindowInfo(rsp=");
        m3.append(this.rsp);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RetainPopWindowInfo) && Intrinsics.areEqual(this.rsp, ((RetainPopWindowInfo) obj).rsp);
    }
}
