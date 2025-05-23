package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes17.dex */
public class GProRoleMemberListInfo implements IGProRoleMemberListInfo {
    public static final String TAG = "GProRoleMemberListInfo";
    private final GProGuildRoleInfo mRole;
    private final List<IGProUserInfo> mUserList = new ArrayList();

    public GProRoleMemberListInfo(GProGuildRole gProGuildRole, List<GProUser> list) {
        this.mRole = new GProGuildRoleInfo(gProGuildRole);
        Iterator<GProUser> it = list.iterator();
        while (it.hasNext()) {
            this.mUserList.add(new GProUserInfo(it.next()));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo
    public List<IGProUserInfo> getMemberList() {
        return this.mUserList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo
    public IGProGuildRoleInfo getRoleInfo() {
        return this.mRole;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo
    public String toString() {
        return "GProRoleMemberListInfo{mRole=" + this.mRole + ", mUserListSize=" + this.mUserList.size() + '}';
    }
}
