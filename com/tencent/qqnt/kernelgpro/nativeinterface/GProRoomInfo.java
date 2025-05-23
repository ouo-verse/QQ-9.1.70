package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes24.dex */
public final class GProRoomInfo implements Serializable {
    public long roomId;
    public int roomState;
    public long viewer;
    long serialVersionUID = 1;
    public String roomName = "";
    public GProViewerExt ViewerExt = new GProViewerExt();
    public String programId = "";
    public HashMap<String, String> roomIcons = new HashMap<>();
    public String roomPv = "";
    public ArrayList<GProAudienceInfo> audienceInfos = new ArrayList<>();
    public String screenShot = "";

    public ArrayList<GProAudienceInfo> getAudienceInfos() {
        return this.audienceInfos;
    }

    public String getProgramId() {
        return this.programId;
    }

    public HashMap<String, String> getRoomIcons() {
        return this.roomIcons;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getRoomPv() {
        return this.roomPv;
    }

    public int getRoomState() {
        return this.roomState;
    }

    public String getScreenShot() {
        return this.screenShot;
    }

    public long getViewer() {
        return this.viewer;
    }

    public GProViewerExt getViewerExt() {
        return this.ViewerExt;
    }

    public String toString() {
        return "GProRoomInfo{roomId=" + this.roomId + ",roomName=" + this.roomName + ",viewer=" + this.viewer + ",roomState=" + this.roomState + ",ViewerExt=" + this.ViewerExt + ",programId=" + this.programId + ",roomIcons=" + this.roomIcons + ",roomPv=" + this.roomPv + ",audienceInfos=" + this.audienceInfos + ",screenShot=" + this.screenShot + ",}";
    }
}
