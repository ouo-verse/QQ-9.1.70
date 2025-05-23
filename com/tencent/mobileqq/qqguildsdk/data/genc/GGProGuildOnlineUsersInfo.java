package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildOnlineUsers;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildOnlineUsersInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildOnlineUsersInfo implements IGProGuildOnlineUsersInfo {
    public final GProGuildOnlineUsersInfo mInfo;

    public GGProGuildOnlineUsersInfo(GProGuildOnlineUsersInfo gProGuildOnlineUsersInfo) {
        this.mInfo = gProGuildOnlineUsersInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsersInfo
    public int getGroupType() {
        return this.mInfo.getGroupType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsersInfo
    public ArrayList<IGProGuildOnlineUsers> getGroupUsers() {
        ArrayList<GProGuildOnlineUsers> groupUsers = this.mInfo.getGroupUsers();
        ArrayList<IGProGuildOnlineUsers> arrayList = new ArrayList<>();
        Iterator<GProGuildOnlineUsers> it = groupUsers.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildOnlineUsers(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsersInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsersInfo
    public long getNextReadInterval() {
        return this.mInfo.getNextReadInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsersInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
