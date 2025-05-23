package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetTopFeedConfigReq {
    public long guildId;
    public int sceneType;

    public long getGuildId() {
        return this.guildId;
    }

    public int getSceneType() {
        return this.sceneType;
    }

    public String toString() {
        return "GProGetTopFeedConfigReq{guildId=" + this.guildId + ",sceneType=" + this.sceneType + ",}";
    }
}
