package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAnchorRoomNoticeItem {
    public Long anchorUid;
    public String ext;
    public String programId;
    public ArrayList<GProAnchorRoomTag> romTags = new ArrayList<>();
    public String roomLogo11;
    public Long roomLogo11Time;
    public String roomLogo169;
    public Long roomLogo169Time;
    public String roomLogo34;
    public Long roomLogo34Time;
    public Long roomPlayEndTime;
    public Long roomPlayStartTime3;
    public String roomPrompt;
    public String roomTitle;

    public Long getAnchorUid() {
        return this.anchorUid;
    }

    public String getExt() {
        return this.ext;
    }

    public String getProgramId() {
        return this.programId;
    }

    public ArrayList<GProAnchorRoomTag> getRomTags() {
        return this.romTags;
    }

    public String getRoomLogo11() {
        return this.roomLogo11;
    }

    public Long getRoomLogo11Time() {
        return this.roomLogo11Time;
    }

    public String getRoomLogo169() {
        return this.roomLogo169;
    }

    public Long getRoomLogo169Time() {
        return this.roomLogo169Time;
    }

    public String getRoomLogo34() {
        return this.roomLogo34;
    }

    public Long getRoomLogo34Time() {
        return this.roomLogo34Time;
    }

    public Long getRoomPlayEndTime() {
        return this.roomPlayEndTime;
    }

    public Long getRoomPlayStartTime3() {
        return this.roomPlayStartTime3;
    }

    public String getRoomPrompt() {
        return this.roomPrompt;
    }

    public String getRoomTitle() {
        return this.roomTitle;
    }

    public String toString() {
        return "GProAnchorRoomNoticeItem{programId=" + this.programId + ",anchorUid=" + this.anchorUid + ",roomPlayStartTime3=" + this.roomPlayStartTime3 + ",roomPlayEndTime=" + this.roomPlayEndTime + ",roomTitle=" + this.roomTitle + ",roomLogo11=" + this.roomLogo11 + ",roomLogo169=" + this.roomLogo169 + ",roomLogo34=" + this.roomLogo34 + ",roomLogo11Time=" + this.roomLogo11Time + ",roomLogo169Time=" + this.roomLogo169Time + ",roomLogo34Time=" + this.roomLogo34Time + ",romTags=" + this.romTags + ",roomPrompt=" + this.roomPrompt + ",ext=" + this.ext + ",}";
    }
}
