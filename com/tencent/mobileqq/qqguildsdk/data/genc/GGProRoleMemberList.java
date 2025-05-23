package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleMemberList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProRoleMemberList implements IGProRoleMemberList {
    public final GProRoleMemberList mInfo;

    public GGProRoleMemberList(GProRoleMemberList gProRoleMemberList) {
        this.mInfo = gProRoleMemberList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleMemberList
    public ArrayList<IGProUserInfo> getMembers() {
        ArrayList<GProUser> members = this.mInfo.getMembers();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = members.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleMemberList
    public IGProGuildRoleInfo getRole() {
        return new GProGuildRoleInfo(this.mInfo.getRole());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleMemberList
    public String toString() {
        return this.mInfo.toString();
    }
}
