package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCmd0xf5dGuildInfo implements Serializable {
    public int followAdminMsgNotify;
    public long guildId;
    public long personalChannelChangeSeq;
    public int result;
    long serialVersionUID = 1;
    public ArrayList<GProChannel> msgChannelList = new ArrayList<>();
    public GProMsgSeq channelChangeSeq = new GProMsgSeq();
    public ArrayList<GProCategoryInfo> msgCategoryInfoList = new ArrayList<>();
    public GProCategoryInfo noClassifyCategoryInfo = new GProCategoryInfo();
    public GProGuildInfo guildInfo = new GProGuildInfo();
    public GProCmdUinInfo cmdUinInfo = new GProCmdUinInfo();

    public GProMsgSeq getChannelChangeSeq() {
        return this.channelChangeSeq;
    }

    public GProCmdUinInfo getCmdUinInfo() {
        return this.cmdUinInfo;
    }

    public int getFollowAdminMsgNotify() {
        return this.followAdminMsgNotify;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public ArrayList<GProCategoryInfo> getMsgCategoryInfoList() {
        return this.msgCategoryInfoList;
    }

    public ArrayList<GProChannel> getMsgChannelList() {
        return this.msgChannelList;
    }

    public GProCategoryInfo getNoClassifyCategoryInfo() {
        return this.noClassifyCategoryInfo;
    }

    public long getPersonalChannelChangeSeq() {
        return this.personalChannelChangeSeq;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "GProCmd0xf5dGuildInfo{guildId=" + this.guildId + ",msgChannelList=" + this.msgChannelList + ",channelChangeSeq=" + this.channelChangeSeq + ",result=" + this.result + ",msgCategoryInfoList=" + this.msgCategoryInfoList + ",noClassifyCategoryInfo=" + this.noClassifyCategoryInfo + ",personalChannelChangeSeq=" + this.personalChannelChangeSeq + ",followAdminMsgNotify=" + this.followAdminMsgNotify + ",guildInfo=" + this.guildInfo + ",cmdUinInfo=" + this.cmdUinInfo + ",}";
    }
}
