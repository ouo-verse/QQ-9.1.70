package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbDetailRsp {
    public final List<HbReceiver> receivers;
    public final String retCode;
    public final String retMsg;
    public final HbReceiver self;
    public final HbSender sender;

    public HbDetailRsp(String str, String str2, HbSender hbSender, HbReceiver hbReceiver, List<HbReceiver> list) {
        this.retCode = str;
        this.retMsg = str2;
        this.sender = hbSender;
        this.self = hbReceiver;
        this.receivers = list;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.retMsg, this.retCode.hashCode() * 31, 31);
        HbSender hbSender = this.sender;
        int hashCode = (m3 + (hbSender == null ? 0 : hbSender.hashCode())) * 31;
        HbReceiver hbReceiver = this.self;
        int hashCode2 = (hashCode + (hbReceiver == null ? 0 : hbReceiver.hashCode())) * 31;
        List<HbReceiver> list = this.receivers;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("HbDetailRsp(retCode=");
        m3.append(this.retCode);
        m3.append(", retMsg=");
        m3.append(this.retMsg);
        m3.append(", sender=");
        m3.append(this.sender);
        m3.append(", self=");
        m3.append(this.self);
        m3.append(", receivers=");
        m3.append(this.receivers);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HbDetailRsp)) {
            return false;
        }
        HbDetailRsp hbDetailRsp = (HbDetailRsp) obj;
        return Intrinsics.areEqual(this.retCode, hbDetailRsp.retCode) && Intrinsics.areEqual(this.retMsg, hbDetailRsp.retMsg) && Intrinsics.areEqual(this.sender, hbDetailRsp.sender) && Intrinsics.areEqual(this.self, hbDetailRsp.self) && Intrinsics.areEqual(this.receivers, hbDetailRsp.receivers);
    }
}
