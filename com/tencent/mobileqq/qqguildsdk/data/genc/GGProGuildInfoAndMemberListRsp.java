package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfoAndMemberListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildInfoAndMemberListRsp implements IGProGuildInfoAndMemberListRsp {
    public final GProGuildInfoAndMemberListRsp mInfo;

    public GGProGuildInfoAndMemberListRsp(GProGuildInfoAndMemberListRsp gProGuildInfoAndMemberListRsp) {
        this.mInfo = gProGuildInfoAndMemberListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp
    public ArrayList<String> getAvatarMetas() {
        return this.mInfo.getAvatarMetas();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp
    public IGProGuildInfo getGuildInfo() {
        return new GProGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp
    public ArrayList<IGProUserInfo> getMemberList() {
        ArrayList<GProUser> memberList = this.mInfo.getMemberList();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = memberList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp
    public int getTotalMemberCnt() {
        return this.mInfo.getTotalMemberCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
