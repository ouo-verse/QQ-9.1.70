package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotInfoRsp {
    public ArrayList<GProGuildRobotFeatureInfo> commands;
    public ArrayList<GProGuildRobotPanelList> panelDataList;
    public String panelTitle;
    public String platformSupportUrl;
    public String previewImagesTitle;
    public GProGuildRobotData robotData;
    public int robotMaxNum;
    public int robotTestStatus;
    public int role;
    public String serviceNote;

    public GProGuildRobotInfoRsp() {
        this.robotData = new GProGuildRobotData();
        this.panelDataList = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.platformSupportUrl = "";
        this.serviceNote = "";
        this.panelTitle = "";
        this.previewImagesTitle = "";
    }

    public ArrayList<GProGuildRobotFeatureInfo> getCommands() {
        return this.commands;
    }

    public ArrayList<GProGuildRobotPanelList> getPanelDataList() {
        return this.panelDataList;
    }

    public String getPanelTitle() {
        return this.panelTitle;
    }

    public String getPlatformSupportUrl() {
        return this.platformSupportUrl;
    }

    public String getPreviewImagesTitle() {
        return this.previewImagesTitle;
    }

    public GProGuildRobotData getRobotData() {
        return this.robotData;
    }

    public int getRobotMaxNum() {
        return this.robotMaxNum;
    }

    public int getRobotTestStatus() {
        return this.robotTestStatus;
    }

    public int getRole() {
        return this.role;
    }

    public String getServiceNote() {
        return this.serviceNote;
    }

    public String toString() {
        return "GProGuildRobotInfoRsp{robotData=" + this.robotData + ",panelDataList=" + this.panelDataList + ",role=" + this.role + ",robotMaxNum=" + this.robotMaxNum + ",commands=" + this.commands + ",robotTestStatus=" + this.robotTestStatus + ",platformSupportUrl=" + this.platformSupportUrl + ",serviceNote=" + this.serviceNote + ",panelTitle=" + this.panelTitle + ",previewImagesTitle=" + this.previewImagesTitle + ",}";
    }

    public GProGuildRobotInfoRsp(GProGuildRobotData gProGuildRobotData, ArrayList<GProGuildRobotPanelList> arrayList, int i3, int i16, ArrayList<GProGuildRobotFeatureInfo> arrayList2, int i17, String str, String str2, String str3, String str4) {
        this.robotData = new GProGuildRobotData();
        this.panelDataList = new ArrayList<>();
        new ArrayList();
        this.robotData = gProGuildRobotData;
        this.panelDataList = arrayList;
        this.role = i3;
        this.robotMaxNum = i16;
        this.commands = arrayList2;
        this.robotTestStatus = i17;
        this.platformSupportUrl = str;
        this.serviceNote = str2;
        this.panelTitle = str3;
        this.previewImagesTitle = str4;
    }
}
