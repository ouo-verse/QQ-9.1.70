package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAnchorEnterRoomRsp {
    public ArrayList<GProAnchorTlv> exts = new ArrayList<>();
    public GProAnchorMediaInfo media;
    public GProAnchorRoomInfo room;
    public GProAnchorTrtcInfo trtc;
    public GProAnchorUserInfo user;

    public ArrayList<GProAnchorTlv> getExts() {
        return this.exts;
    }

    public GProAnchorMediaInfo getMedia() {
        return this.media;
    }

    public GProAnchorRoomInfo getRoom() {
        return this.room;
    }

    public GProAnchorTrtcInfo getTrtc() {
        return this.trtc;
    }

    public GProAnchorUserInfo getUser() {
        return this.user;
    }

    public String toString() {
        return "GProAnchorEnterRoomRsp{room=" + this.room + ",user=" + this.user + ",media=" + this.media + ",trtc=" + this.trtc + ",exts=" + this.exts + ",}";
    }
}
