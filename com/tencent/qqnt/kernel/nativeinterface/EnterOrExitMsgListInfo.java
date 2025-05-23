package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EnterOrExitMsgListInfo {
    public int msgListType;
    public int option;

    public EnterOrExitMsgListInfo() {
    }

    public int getMsgListType() {
        return this.msgListType;
    }

    public int getOption() {
        return this.option;
    }

    public String toString() {
        return "EnterOrExitMsgListInfo{msgListType=" + this.msgListType + ",option=" + this.option + ",}";
    }

    public EnterOrExitMsgListInfo(int i3, int i16) {
        this.msgListType = i3;
        this.option = i16;
    }
}
