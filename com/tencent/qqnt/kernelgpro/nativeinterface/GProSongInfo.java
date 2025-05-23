package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSongInfo implements Serializable {
    public boolean isEnable;
    public String lyrics;
    public ArrayList<String> playUrlList;
    long serialVersionUID;

    public GProSongInfo() {
        this.serialVersionUID = 1L;
        this.playUrlList = new ArrayList<>();
        this.lyrics = "";
    }

    public boolean getIsEnable() {
        return this.isEnable;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public ArrayList<String> getPlayUrlList() {
        return this.playUrlList;
    }

    public String toString() {
        return "GProSongInfo{playUrlList=" + this.playUrlList + ",lyrics=" + this.lyrics + ",isEnable=" + this.isEnable + ",}";
    }

    public GProSongInfo(ArrayList<String> arrayList, String str, boolean z16) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.playUrlList = arrayList;
        this.lyrics = str;
        this.isEnable = z16;
    }
}
