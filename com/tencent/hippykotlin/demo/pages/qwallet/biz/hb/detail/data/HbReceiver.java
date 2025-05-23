package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data;

import androidx.compose.runtime.MutableState;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbReceiver {
    public final int amount;
    public final String createTime;
    public final String createTs;
    public boolean isLuck;
    public final String recvListId;
    public MutableState<String> recvName;
    public final String recvTinyId;
    public final String recvUin;

    public HbReceiver(int i3, String str, String str2, String str3, MutableState<String> mutableState, String str4, String str5) {
        this.amount = i3;
        this.createTime = str;
        this.createTs = str2;
        this.recvListId = str3;
        this.recvName = mutableState;
        this.recvTinyId = str4;
        this.recvUin = str5;
    }

    public final int hashCode() {
        int i3 = this.amount * 31;
        String str = this.createTime;
        int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.createTs;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.recvListId;
        int hashCode3 = (this.recvName.hashCode() + ((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        String str4 = this.recvTinyId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.recvUin;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("HbReceiver(amount=");
        m3.append(this.amount);
        m3.append(", createTime=");
        m3.append(this.createTime);
        m3.append(", createTs=");
        m3.append(this.createTs);
        m3.append(", recvListId=");
        m3.append(this.recvListId);
        m3.append(", recvName=");
        m3.append(this.recvName);
        m3.append(", recvTinyId=");
        m3.append(this.recvTinyId);
        m3.append(", recvUin=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.recvUin, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HbReceiver)) {
            return false;
        }
        HbReceiver hbReceiver = (HbReceiver) obj;
        return this.amount == hbReceiver.amount && Intrinsics.areEqual(this.createTime, hbReceiver.createTime) && Intrinsics.areEqual(this.createTs, hbReceiver.createTs) && Intrinsics.areEqual(this.recvListId, hbReceiver.recvListId) && Intrinsics.areEqual(this.recvName, hbReceiver.recvName) && Intrinsics.areEqual(this.recvTinyId, hbReceiver.recvTinyId) && Intrinsics.areEqual(this.recvUin, hbReceiver.recvUin);
    }
}
