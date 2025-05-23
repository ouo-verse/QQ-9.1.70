package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBlackUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRiskMemberGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProRiskMemberGroupInfo implements IGProRiskMemberGroupInfo {
    public final GProRiskMemberGroupInfo mInfo;

    public GGProRiskMemberGroupInfo(GProRiskMemberGroupInfo gProRiskMemberGroupInfo) {
        this.mInfo = gProRiskMemberGroupInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberGroupInfo
    public long getGroupId() {
        return this.mInfo.getGroupId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberGroupInfo
    public String getGroupName() {
        return this.mInfo.getGroupName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberGroupInfo
    public ArrayList<IGProBlackUserInfo> getRptMemberList() {
        ArrayList<GProBlackUserInfo> rptMemberList = this.mInfo.getRptMemberList();
        ArrayList<IGProBlackUserInfo> arrayList = new ArrayList<>();
        Iterator<GProBlackUserInfo> it = rptMemberList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBlackUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberGroupInfo
    public int getTotalNum() {
        return this.mInfo.getTotalNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberGroupInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
