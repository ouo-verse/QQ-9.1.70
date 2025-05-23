package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProConfirmOption {
    public String confirmMsg = "";
    public ArrayList<GProConfirmNode> confirmNodes = new ArrayList<>();

    public String getConfirmMsg() {
        return this.confirmMsg;
    }

    public ArrayList<GProConfirmNode> getConfirmNodes() {
        return this.confirmNodes;
    }

    public String toString() {
        return "GProConfirmOption{confirmMsg=" + this.confirmMsg + ",confirmNodes=" + this.confirmNodes + ",}";
    }
}
