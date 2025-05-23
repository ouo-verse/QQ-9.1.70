package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPollingData {
    public long channelId;
    public byte[] cookie;
    public byte[] data;
    public ArrayList<MsgAbstract> feedMsgAbstracts;
    public boolean forcePolling;
    public long guildId;
    public GProLiveResultItem liveResultItem;
    public ArrayList<MsgAbstract> msgAbstracts;
    public int type;
    public long updateTime;
    public long version;
    public GProChannelMemberInfos voiceChannel;

    public GProPollingData() {
        this.cookie = new byte[0];
        this.data = new byte[0];
        this.voiceChannel = new GProChannelMemberInfos();
        this.liveResultItem = new GProLiveResultItem();
        this.msgAbstracts = new ArrayList<>();
        this.feedMsgAbstracts = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public byte[] getData() {
        return this.data;
    }

    public ArrayList<MsgAbstract> getFeedMsgAbstracts() {
        return this.feedMsgAbstracts;
    }

    public boolean getForcePolling() {
        return this.forcePolling;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProLiveResultItem getLiveResultItem() {
        return this.liveResultItem;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public int getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public long getVersion() {
        return this.version;
    }

    public GProChannelMemberInfos getVoiceChannel() {
        return this.voiceChannel;
    }

    public String toString() {
        return "GProPollingData{type=" + this.type + ",guildId=" + this.guildId + ",channelId=" + this.channelId + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",cookie=" + this.cookie + ",data=" + this.data + ",voiceChannel=" + this.voiceChannel + ",liveResultItem=" + this.liveResultItem + ",msgAbstracts=" + this.msgAbstracts + ",feedMsgAbstracts=" + this.feedMsgAbstracts + ",forcePolling=" + this.forcePolling + ",updateTime=" + this.updateTime + ",}";
    }

    public GProPollingData(int i3, long j3, long j16, long j17, byte[] bArr, byte[] bArr2, GProChannelMemberInfos gProChannelMemberInfos, GProLiveResultItem gProLiveResultItem, boolean z16, long j18) {
        this.cookie = new byte[0];
        this.data = new byte[0];
        this.voiceChannel = new GProChannelMemberInfos();
        this.liveResultItem = new GProLiveResultItem();
        this.msgAbstracts = new ArrayList<>();
        this.feedMsgAbstracts = new ArrayList<>();
        this.type = i3;
        this.guildId = j3;
        this.channelId = j16;
        this.version = j17;
        this.cookie = bArr;
        this.data = bArr2;
        this.voiceChannel = gProChannelMemberInfos;
        this.liveResultItem = gProLiveResultItem;
        this.forcePolling = z16;
        this.updateTime = j18;
    }
}
