package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProConfirmNode {
    public boolean cancelOpt;
    public String buttonMsg = "";
    public String confirmExt = "";

    public String getButtonMsg() {
        return this.buttonMsg;
    }

    public boolean getCancelOpt() {
        return this.cancelOpt;
    }

    public String getConfirmExt() {
        return this.confirmExt;
    }

    public String toString() {
        return "GProConfirmNode{buttonMsg=" + this.buttonMsg + ",confirmExt=" + this.confirmExt + ",cancelOpt=" + this.cancelOpt + ",}";
    }
}
