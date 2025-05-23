package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisSubBusinessItem {
    public int bzid;
    public int hasRedDot;
    public int isHotWordsList;
    public int redSeq;
    public byte[] title = new byte[0];
    public byte[] iconUrl = new byte[0];
    public ArrayList<Long> groupMasks = new ArrayList<>();
    public byte[] jumpUrl = new byte[0];

    public int getBzid() {
        return this.bzid;
    }

    public ArrayList<Long> getGroupMasks() {
        return this.groupMasks;
    }

    public int getHasRedDot() {
        return this.hasRedDot;
    }

    public byte[] getIconUrl() {
        return this.iconUrl;
    }

    public int getIsHotWordsList() {
        return this.isHotWordsList;
    }

    public byte[] getJumpUrl() {
        return this.jumpUrl;
    }

    public int getRedSeq() {
        return this.redSeq;
    }

    public byte[] getTitle() {
        return this.title;
    }

    public String toString() {
        return "UfsDisSubBusinessItem{title=" + this.title + ",iconUrl=" + this.iconUrl + ",groupMasks=" + this.groupMasks + ",isHotWordsList=" + this.isHotWordsList + ",jumpUrl=" + this.jumpUrl + ",hasRedDot=" + this.hasRedDot + ",redSeq=" + this.redSeq + ",bzid=" + this.bzid + ",}";
    }
}
