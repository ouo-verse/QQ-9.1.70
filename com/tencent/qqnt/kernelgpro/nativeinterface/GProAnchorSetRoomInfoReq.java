package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAnchorSetRoomInfoReq {
    public ArrayList<GProAnchorTlv> attrs = new ArrayList<>();
    public String machine;
    public String programId;
    public Long roomId;
    public String source;
    public GProLiveRoomRichTitle tags;

    public ArrayList<GProAnchorTlv> getAttrs() {
        return this.attrs;
    }

    public String getMachine() {
        return this.machine;
    }

    public String getProgramId() {
        return this.programId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String getSource() {
        return this.source;
    }

    public GProLiveRoomRichTitle getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProAnchorSetRoomInfoReq{roomId=" + this.roomId + ",attrs=" + this.attrs + ",programId=" + this.programId + ",tags=" + this.tags + ",source=" + this.source + ",machine=" + this.machine + ",}";
    }
}
