package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedMemberListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleMemberList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProFeedMemberListRsp implements IGProFeedMemberListRsp {
    public final GProFeedMemberListRsp mInfo;

    public GGProFeedMemberListRsp(GProFeedMemberListRsp gProFeedMemberListRsp) {
        this.mInfo = gProFeedMemberListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public boolean getIsFinished() {
        return this.mInfo.getIsFinished();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public boolean getIsSmallGuild() {
        return this.mInfo.getIsSmallGuild();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public long getNextIndex() {
        return this.mInfo.getNextIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public long getNextRoleIdIndex() {
        return this.mInfo.getNextRoleIdIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public ArrayList<IGProUserInfo> getRobotMembers() {
        ArrayList<GProUser> robotMembers = this.mInfo.getRobotMembers();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = robotMembers.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public ArrayList<IGProRoleMemberList> getRoleList() {
        ArrayList<GProRoleMemberList> roleList = this.mInfo.getRoleList();
        ArrayList<IGProRoleMemberList> arrayList = new ArrayList<>();
        Iterator<GProRoleMemberList> it = roleList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRoleMemberList(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public int getTotalMemberNum() {
        return this.mInfo.getTotalMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedMemberListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
