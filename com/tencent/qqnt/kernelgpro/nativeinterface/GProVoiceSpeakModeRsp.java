package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceSpeakModeRsp {
    public int modCode;
    public String confirmMsg = "";
    public String confirmExt = "";

    public String getConfirmExt() {
        return this.confirmExt;
    }

    public String getConfirmMsg() {
        return this.confirmMsg;
    }

    public int getModCode() {
        return this.modCode;
    }

    public String toString() {
        return "GProVoiceSpeakModeRsp{modCode=" + this.modCode + ",confirmMsg=" + this.confirmMsg + ",confirmExt=" + this.confirmExt + ",}";
    }
}
