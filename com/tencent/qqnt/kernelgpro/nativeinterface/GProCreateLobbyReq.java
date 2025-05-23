package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCreateLobbyReq {
    public String appId;
    public int capacity;
    public long channelId;
    public ArrayList<GProKVPair> extendDic;
    public long guildId;
    public int lobbyType;

    public GProCreateLobbyReq() {
        this.appId = "";
        this.extendDic = new ArrayList<>();
    }

    public String getAppId() {
        return this.appId;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProKVPair> getExtendDic() {
        return this.extendDic;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getLobbyType() {
        return this.lobbyType;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCapacity(int i3) {
        this.capacity = i3;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setExtendDic(ArrayList<GProKVPair> arrayList) {
        this.extendDic = arrayList;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setLobbyType(int i3) {
        this.lobbyType = i3;
    }

    public String toString() {
        return "GProCreateLobbyReq{appId=" + this.appId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",lobbyType=" + this.lobbyType + ",capacity=" + this.capacity + ",extendDic=" + this.extendDic + ",}";
    }

    public GProCreateLobbyReq(String str, long j3, long j16, int i3, int i16, ArrayList<GProKVPair> arrayList) {
        this.appId = "";
        new ArrayList();
        this.appId = str;
        this.guildId = j3;
        this.channelId = j16;
        this.lobbyType = i3;
        this.capacity = i16;
        this.extendDic = arrayList;
    }
}
