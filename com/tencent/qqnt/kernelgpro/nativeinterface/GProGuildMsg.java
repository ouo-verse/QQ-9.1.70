package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildMsg {
    public long channelId;
    public long guildId;
    public ArrayList<GProMsgHighlight> highlights = new ArrayList<>();
    public long msgSeq;

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProMsgHighlight> getHighlights() {
        return this.highlights;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setHighlights(ArrayList<GProMsgHighlight> arrayList) {
        this.highlights = arrayList;
    }

    public void setMsgSeq(long j3) {
        this.msgSeq = j3;
    }

    public String toString() {
        return "GProGuildMsg{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgSeq=" + this.msgSeq + ",highlights=" + this.highlights + ",}";
    }
}
