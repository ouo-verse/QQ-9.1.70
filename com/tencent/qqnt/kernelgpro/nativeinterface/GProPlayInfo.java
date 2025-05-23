package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPlayInfo implements Serializable {
    public GProPlayNodeExtInfo playNodeExInfo;
    public GProPlayNodeInfo playNodeInfo;
    long serialVersionUID;
    public GProSongInfo songInfo;

    public GProPlayInfo() {
        this.serialVersionUID = 1L;
        this.playNodeInfo = new GProPlayNodeInfo();
        this.playNodeExInfo = new GProPlayNodeExtInfo();
        this.songInfo = new GProSongInfo();
    }

    public GProPlayNodeExtInfo getPlayNodeExInfo() {
        return this.playNodeExInfo;
    }

    public GProPlayNodeInfo getPlayNodeInfo() {
        return this.playNodeInfo;
    }

    public GProSongInfo getSongInfo() {
        return this.songInfo;
    }

    public String toString() {
        return "GProPlayInfo{playNodeInfo=" + this.playNodeInfo + ",playNodeExInfo=" + this.playNodeExInfo + ",songInfo=" + this.songInfo + ",}";
    }

    public GProPlayInfo(GProPlayNodeInfo gProPlayNodeInfo, GProPlayNodeExtInfo gProPlayNodeExtInfo, GProSongInfo gProSongInfo) {
        this.serialVersionUID = 1L;
        this.playNodeInfo = new GProPlayNodeInfo();
        this.playNodeExInfo = new GProPlayNodeExtInfo();
        new GProSongInfo();
        this.playNodeInfo = gProPlayNodeInfo;
        this.playNodeExInfo = gProPlayNodeExtInfo;
        this.songInfo = gProSongInfo;
    }
}
