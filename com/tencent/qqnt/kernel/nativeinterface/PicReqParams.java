package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PicReqParams {
    public int chatType;
    public boolean isGif;
    public String peerUid;
    public int picSize;

    public PicReqParams() {
        this.peerUid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public boolean getIsGif() {
        return this.isGif;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getPicSize() {
        return this.picSize;
    }

    public PicReqParams(int i3, String str, int i16, boolean z16) {
        this.chatType = i3;
        this.peerUid = str;
        this.picSize = i16;
        this.isGif = z16;
    }
}
