package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data;

import androidx.compose.runtime.MutableState;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbSender {
    public final int busiType;
    public final int channel;
    public final String hbStatusDesc;
    public final String invalidTime;
    public final int isOwner;
    public final String luckyUin;
    public final long recvAmount;
    public final int recvNum;
    public final String sendListId;
    public MutableState<String> sendName;
    public final String sendTinyId;
    public final String sendUin;
    public final int state;
    public final long totalAmount;
    public final int totalNum;
    public final int type;
    public final String wishing;

    public final int hashCode() {
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.channel, this.busiType * 31, 31);
        String str = this.invalidTime;
        int m16 = QQAudioParams$$ExternalSyntheticOutline0.m(this.isOwner, (m3 + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.luckyUin;
        int hashCode = (this.sendName.hashCode() + QQAudioParams$$ExternalSyntheticOutline0.m(this.recvNum, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.recvAmount, (m16 + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31)) * 31;
        String str3 = this.sendTinyId;
        int m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.sendUin, (hashCode + (str3 == null ? 0 : str3.hashCode())) * 31, 31);
        String str4 = this.sendListId;
        int m18 = QQAudioParams$$ExternalSyntheticOutline0.m(this.type, QQAudioParams$$ExternalSyntheticOutline0.m(this.totalNum, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.totalAmount, QQAudioParams$$ExternalSyntheticOutline0.m(this.state, (m17 + (str4 == null ? 0 : str4.hashCode())) * 31, 31), 31), 31), 31);
        String str5 = this.wishing;
        int hashCode2 = (m18 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.hbStatusDesc;
        return hashCode2 + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        return "HbSender(busiType=" + this.busiType + ", channel=" + this.channel + ", invalidTime=" + this.invalidTime + ", isOwner=" + this.isOwner + ", luckyUin=" + this.luckyUin + ", recvAmount=" + this.recvAmount + ", recvNum=" + this.recvNum + ", sendName=" + this.sendName + ", sendTinyId=" + this.sendTinyId + ", sendUin=" + this.sendUin + ", sendListId=" + this.sendListId + ", state=" + this.state + ", totalAmount=" + this.totalAmount + ", totalNum=" + this.totalNum + ", type=" + this.type + ", wishing=" + this.wishing + ", hbStatusDesc=" + this.hbStatusDesc + ')';
    }

    public HbSender(int i3, int i16, String str, int i17, String str2, long j3, int i18, MutableState<String> mutableState, String str3, String str4, String str5, int i19, long j16, int i26, int i27, String str6, String str7) {
        this.busiType = i3;
        this.channel = i16;
        this.invalidTime = str;
        this.isOwner = i17;
        this.luckyUin = str2;
        this.recvAmount = j3;
        this.recvNum = i18;
        this.sendName = mutableState;
        this.sendTinyId = str3;
        this.sendUin = str4;
        this.sendListId = str5;
        this.state = i19;
        this.totalAmount = j16;
        this.totalNum = i26;
        this.type = i27;
        this.wishing = str6;
        this.hbStatusDesc = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HbSender)) {
            return false;
        }
        HbSender hbSender = (HbSender) obj;
        return this.busiType == hbSender.busiType && this.channel == hbSender.channel && Intrinsics.areEqual(this.invalidTime, hbSender.invalidTime) && this.isOwner == hbSender.isOwner && Intrinsics.areEqual(this.luckyUin, hbSender.luckyUin) && this.recvAmount == hbSender.recvAmount && this.recvNum == hbSender.recvNum && Intrinsics.areEqual(this.sendName, hbSender.sendName) && Intrinsics.areEqual(this.sendTinyId, hbSender.sendTinyId) && Intrinsics.areEqual(this.sendUin, hbSender.sendUin) && Intrinsics.areEqual(this.sendListId, hbSender.sendListId) && this.state == hbSender.state && this.totalAmount == hbSender.totalAmount && this.totalNum == hbSender.totalNum && this.type == hbSender.type && Intrinsics.areEqual(this.wishing, hbSender.wishing) && Intrinsics.areEqual(this.hbStatusDesc, hbSender.hbStatusDesc);
    }
}
