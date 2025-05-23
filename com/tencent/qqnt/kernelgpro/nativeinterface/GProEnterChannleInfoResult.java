package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProEnterChannleInfoResult {
    public int appId;
    public boolean defaultMute;
    public boolean globalMute;
    public byte[] pKey;
    public int screenShareBtnVisibleType;
    public byte[] trtcSig;

    public GProEnterChannleInfoResult() {
        this.trtcSig = new byte[0];
        this.pKey = new byte[0];
    }

    public int getAppId() {
        return this.appId;
    }

    public boolean getDefaultMute() {
        return this.defaultMute;
    }

    public boolean getGlobalMute() {
        return this.globalMute;
    }

    public byte[] getPKey() {
        return this.pKey;
    }

    public int getScreenShareBtnVisibleType() {
        return this.screenShareBtnVisibleType;
    }

    public byte[] getTrtcSig() {
        return this.trtcSig;
    }

    public String toString() {
        return "GProEnterChannleInfoResult{trtcSig=" + this.trtcSig + ",pKey=" + this.pKey + ",appId=" + this.appId + ",defaultMute=" + this.defaultMute + ",globalMute=" + this.globalMute + ",screenShareBtnVisibleType=" + this.screenShareBtnVisibleType + ",}";
    }

    public GProEnterChannleInfoResult(byte[] bArr, byte[] bArr2, int i3, boolean z16, boolean z17, int i16) {
        this.trtcSig = bArr;
        this.pKey = bArr2;
        this.appId = i3;
        this.defaultMute = z16;
        this.globalMute = z17;
        this.screenShareBtnVisibleType = i16;
    }
}
