package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildOnlineUsers {
    public long channelId;
    public int channelType;
    public String totalOnline = "";
    public ArrayList<GProUser> users = new ArrayList<>();

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getTotalOnline() {
        return this.totalOnline;
    }

    public ArrayList<GProUser> getUsers() {
        return this.users;
    }

    public String toString() {
        return "GProGuildOnlineUsers{channelType=" + this.channelType + ",channelId=" + this.channelId + ",totalOnline=" + this.totalOnline + ",users=" + this.users + ",}";
    }
}
