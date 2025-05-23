package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildOnlineReportReq {
    public int activeTab;
    public ArrayList<GProGuildBrowseInfo> browseInfo;
    public ArrayList<GProGuildOnlineReportExtInfo> exts;
    public int fromPageId;
    public boolean isVisiting;
    public int scene;
    public int sourceType;
    public long tinyId;

    public GProGuildOnlineReportReq() {
        this.browseInfo = new ArrayList<>();
        this.exts = new ArrayList<>();
    }

    public int getActiveTab() {
        return this.activeTab;
    }

    public ArrayList<GProGuildBrowseInfo> getBrowseInfo() {
        return this.browseInfo;
    }

    public ArrayList<GProGuildOnlineReportExtInfo> getExts() {
        return this.exts;
    }

    public int getFromPageId() {
        return this.fromPageId;
    }

    public boolean getIsVisiting() {
        return this.isVisiting;
    }

    public int getScene() {
        return this.scene;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public void setActiveTab(int i3) {
        this.activeTab = i3;
    }

    public void setBrowseInfo(ArrayList<GProGuildBrowseInfo> arrayList) {
        this.browseInfo = arrayList;
    }

    public void setExts(ArrayList<GProGuildOnlineReportExtInfo> arrayList) {
        this.exts = arrayList;
    }

    public void setFromPageId(int i3) {
        this.fromPageId = i3;
    }

    public void setIsVisiting(boolean z16) {
        this.isVisiting = z16;
    }

    public void setScene(int i3) {
        this.scene = i3;
    }

    public void setSourceType(int i3) {
        this.sourceType = i3;
    }

    public void setTinyId(long j3) {
        this.tinyId = j3;
    }

    public String toString() {
        return "GProGuildOnlineReportReq{tinyId=" + this.tinyId + ",activeTab=" + this.activeTab + ",browseInfo=" + this.browseInfo + ",isVisiting=" + this.isVisiting + ",scene=" + this.scene + ",sourceType=" + this.sourceType + ",exts=" + this.exts + ",fromPageId=" + this.fromPageId + ",}";
    }

    public GProGuildOnlineReportReq(long j3, int i3, ArrayList<GProGuildBrowseInfo> arrayList, boolean z16, int i16, int i17, ArrayList<GProGuildOnlineReportExtInfo> arrayList2, int i18) {
        this.browseInfo = new ArrayList<>();
        new ArrayList();
        this.tinyId = j3;
        this.activeTab = i3;
        this.browseInfo = arrayList;
        this.isVisiting = z16;
        this.scene = i16;
        this.sourceType = i17;
        this.exts = arrayList2;
        this.fromPageId = i18;
    }
}
