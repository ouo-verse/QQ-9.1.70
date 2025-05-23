package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelToolBar implements Serializable {
    long serialVersionUID;
    public String toolbarListStr;

    public GProChannelToolBar() {
        this.serialVersionUID = 1L;
        this.toolbarListStr = "";
    }

    public String getToolbarListStr() {
        return this.toolbarListStr;
    }

    public String toString() {
        return "GProChannelToolBar{toolbarListStr=" + this.toolbarListStr + ",}";
    }

    public GProChannelToolBar(String str) {
        this.serialVersionUID = 1L;
        this.toolbarListStr = str;
    }
}
