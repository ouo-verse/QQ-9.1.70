package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProHeartbeatReq implements Serializable {
    public String authMeta;
    public long channelDataVersion;
    public long channelId;
    public int channelType;
    public long guildId;
    public ArrayList<GProKVNode> kvInfoList;
    public ArrayList<String> roomIdList;
    long serialVersionUID;
    public int streamType;
    public GProUserDevState userDevState;

    public GProHeartbeatReq() {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.roomIdList = new ArrayList<>();
        this.userDevState = new GProUserDevState();
        this.kvInfoList = new ArrayList<>();
    }

    public String getAuthMeta() {
        return this.authMeta;
    }

    public long getChannelDataVersion() {
        return this.channelDataVersion;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProKVNode> getKvInfoList() {
        return this.kvInfoList;
    }

    public ArrayList<String> getRoomIdList() {
        return this.roomIdList;
    }

    public int getStreamType() {
        return this.streamType;
    }

    public GProUserDevState getUserDevState() {
        return this.userDevState;
    }

    public void setAuthMeta(String str) {
        this.authMeta = str;
    }

    public void setChannelDataVersion(long j3) {
        this.channelDataVersion = j3;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setChannelType(int i3) {
        this.channelType = i3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setKvInfoList(ArrayList<GProKVNode> arrayList) {
        this.kvInfoList = arrayList;
    }

    public void setRoomIdList(ArrayList<String> arrayList) {
        this.roomIdList = arrayList;
    }

    public void setStreamType(int i3) {
        this.streamType = i3;
    }

    public void setUserDevState(GProUserDevState gProUserDevState) {
        this.userDevState = gProUserDevState;
    }

    public String toString() {
        return "GProHeartbeatReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",authMeta=" + this.authMeta + ",roomIdList=" + this.roomIdList + ",streamType=" + this.streamType + ",userDevState=" + this.userDevState + ",kvInfoList=" + this.kvInfoList + ",channelType=" + this.channelType + ",channelDataVersion=" + this.channelDataVersion + ",}";
    }

    public GProHeartbeatReq(long j3, long j16, String str, ArrayList<String> arrayList, int i3, GProUserDevState gProUserDevState, ArrayList<GProKVNode> arrayList2, int i16, long j17) {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.roomIdList = new ArrayList<>();
        this.userDevState = new GProUserDevState();
        new ArrayList();
        this.guildId = j3;
        this.channelId = j16;
        this.authMeta = str;
        this.roomIdList = arrayList;
        this.streamType = i3;
        this.userDevState = gProUserDevState;
        this.kvInfoList = arrayList2;
        this.channelType = i16;
        this.channelDataVersion = j17;
    }
}
