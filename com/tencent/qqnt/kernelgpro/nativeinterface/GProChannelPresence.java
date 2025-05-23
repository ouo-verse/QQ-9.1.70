package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelPresence implements Serializable {
    public long channelId;
    public int channelType;
    public String currentMemberNum;
    public GProGuildLiveInfo guildLiveInfo;
    public ArrayList<GProChannelPresenceMemberInfo> memberInfos;
    long serialVersionUID;
    public GProVoicePresence0x11bc voicePresence;

    public GProChannelPresence() {
        this.serialVersionUID = 1L;
        this.currentMemberNum = "";
        this.memberInfos = new ArrayList<>();
        this.guildLiveInfo = new GProGuildLiveInfo();
        this.voicePresence = new GProVoicePresence0x11bc();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getCurrentMemberNum() {
        return this.currentMemberNum;
    }

    public GProGuildLiveInfo getGuildLiveInfo() {
        return this.guildLiveInfo;
    }

    public ArrayList<GProChannelPresenceMemberInfo> getMemberInfos() {
        return this.memberInfos;
    }

    public GProVoicePresence0x11bc getVoicePresence() {
        return this.voicePresence;
    }

    public String toString() {
        return "GProChannelPresence{channelId=" + this.channelId + ",currentMemberNum=" + this.currentMemberNum + ",channelType=" + this.channelType + ",memberInfos=" + this.memberInfos + ",guildLiveInfo=" + this.guildLiveInfo + ",voicePresence=" + this.voicePresence + ",}";
    }

    public GProChannelPresence(long j3, String str, int i3, ArrayList<GProChannelPresenceMemberInfo> arrayList, GProGuildLiveInfo gProGuildLiveInfo, GProVoicePresence0x11bc gProVoicePresence0x11bc) {
        this.serialVersionUID = 1L;
        this.currentMemberNum = "";
        this.memberInfos = new ArrayList<>();
        this.guildLiveInfo = new GProGuildLiveInfo();
        new GProVoicePresence0x11bc();
        this.channelId = j3;
        this.currentMemberNum = str;
        this.channelType = i3;
        this.memberInfos = arrayList;
        this.guildLiveInfo = gProGuildLiveInfo;
        this.voicePresence = gProVoicePresence0x11bc;
    }
}
