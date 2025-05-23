package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BlockGrayTipElement implements Serializable {
    public boolean block;
    public boolean isBuddy;
    public String peerUid;
    long serialVersionUID;

    public BlockGrayTipElement() {
        this.serialVersionUID = 1L;
        this.peerUid = "";
    }

    public boolean getBlock() {
        return this.block;
    }

    public boolean getIsBuddy() {
        return this.isBuddy;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "BlockGrayTipElement{peerUid=" + this.peerUid + ",block=" + this.block + ",isBuddy=" + this.isBuddy + ",}";
    }

    public BlockGrayTipElement(String str, boolean z16, boolean z17) {
        this.serialVersionUID = 1L;
        this.peerUid = str;
        this.block = z16;
        this.isBuddy = z17;
    }
}
