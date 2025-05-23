package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildOnlineUsersInfo {
    public int groupType;
    public ArrayList<GProGuildOnlineUsers> groupUsers = new ArrayList<>();
    public long guildId;
    public long nextReadInterval;

    public int getGroupType() {
        return this.groupType;
    }

    public ArrayList<GProGuildOnlineUsers> getGroupUsers() {
        return this.groupUsers;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getNextReadInterval() {
        return this.nextReadInterval;
    }

    public String toString() {
        return "GProGuildOnlineUsersInfo{guildId=" + this.guildId + ",groupType=" + this.groupType + ",nextReadInterval=" + this.nextReadInterval + ",groupUsers=" + this.groupUsers + ",}";
    }
}
