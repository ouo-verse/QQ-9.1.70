package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildMemberSearchResult implements IGProGuildMemberSearchResult {
    public final GProGuildMemberSearchResult mInfo;

    public GGProGuildMemberSearchResult(GProGuildMemberSearchResult gProGuildMemberSearchResult) {
        this.mInfo = gProGuildMemberSearchResult;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult
    public ArrayList<IGProUserInfo> getMembers() {
        ArrayList<GProUser> members = this.mInfo.getMembers();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = members.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult
    public long getNextPos() {
        return this.mInfo.getNextPos();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult
    public ArrayList<IGProGuildRoleInfo> getRoles() {
        ArrayList<GProGuildRole> roles = this.mInfo.getRoles();
        ArrayList<IGProGuildRoleInfo> arrayList = new ArrayList<>();
        Iterator<GProGuildRole> it = roles.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildRoleInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildMemberSearchResult
    public String toString() {
        return this.mInfo.toString();
    }
}
