package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRiskMemberGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRiskMemberListRsp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProRiskMemberListRsp implements IGProRiskMemberListRsp {
    public final GProRiskMemberListRsp mInfo;

    public GGProRiskMemberListRsp(GProRiskMemberListRsp gProRiskMemberListRsp) {
        this.mInfo = gProRiskMemberListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public byte[] getBuf() {
        return this.mInfo.getBuf();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public String getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public ArrayList<IGProRiskMemberGroupInfo> getGroupList() {
        ArrayList<GProRiskMemberGroupInfo> groupList = this.mInfo.getGroupList();
        ArrayList<IGProRiskMemberGroupInfo> arrayList = new ArrayList<>();
        Iterator<GProRiskMemberGroupInfo> it = groupList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRiskMemberGroupInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public String getSubTitle() {
        return this.mInfo.getSubTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public long getTotalNum() {
        return this.mInfo.getTotalNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRiskMemberListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
