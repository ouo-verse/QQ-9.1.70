package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetChannelActivityRsp {
    public ArrayList<GProChannelActivity> channelActivities;
    public int closeOption;
    public long guildId;
    public boolean isShow;

    public GProGetChannelActivityRsp() {
        this.channelActivities = new ArrayList<>();
    }

    public ArrayList<GProChannelActivity> getChannelActivities() {
        return this.channelActivities;
    }

    public int getCloseOption() {
        return this.closeOption;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsShow() {
        return this.isShow;
    }

    public String toString() {
        return "GProGetChannelActivityRsp{guildId=" + this.guildId + ",channelActivities=" + this.channelActivities + ",isShow=" + this.isShow + ",closeOption=" + this.closeOption + ",}";
    }

    public GProGetChannelActivityRsp(long j3, ArrayList<GProChannelActivity> arrayList, boolean z16, int i3) {
        new ArrayList();
        this.guildId = j3;
        this.channelActivities = arrayList;
        this.isShow = z16;
        this.closeOption = i3;
    }
}
