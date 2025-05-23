package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAVShowMsgInfo implements Serializable {
    public ArrayList<String> buttonMsgs;
    long serialVersionUID;
    public String showMsg;
    public int showSeconds;
    public int showType;

    public GProAVShowMsgInfo() {
        this.serialVersionUID = 1L;
        this.showMsg = "";
        this.buttonMsgs = new ArrayList<>();
    }

    public ArrayList<String> getButtonMsgs() {
        return this.buttonMsgs;
    }

    public String getShowMsg() {
        return this.showMsg;
    }

    public int getShowSeconds() {
        return this.showSeconds;
    }

    public int getShowType() {
        return this.showType;
    }

    public String toString() {
        return "GProAVShowMsgInfo{showType=" + this.showType + ",showMsg=" + this.showMsg + ",showSeconds=" + this.showSeconds + ",buttonMsgs=" + this.buttonMsgs + ",}";
    }

    public GProAVShowMsgInfo(int i3, String str, int i16, ArrayList<String> arrayList) {
        this.serialVersionUID = 1L;
        this.showMsg = "";
        new ArrayList();
        this.showType = i3;
        this.showMsg = str;
        this.showSeconds = i16;
        this.buttonMsgs = arrayList;
    }
}
