package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SpecificEventTypeInfoInMsgBox {
    public int eventTypeInMsgBox;
    public ArrayList<MsgBoxNecessaryMsgInfo> msgInfos;

    public SpecificEventTypeInfoInMsgBox() {
        this.msgInfos = new ArrayList<>();
    }

    public int getEventTypeInMsgBox() {
        return this.eventTypeInMsgBox;
    }

    public ArrayList<MsgBoxNecessaryMsgInfo> getMsgInfos() {
        return this.msgInfos;
    }

    public String toString() {
        return "SpecificEventTypeInfoInMsgBox{eventTypeInMsgBox=" + this.eventTypeInMsgBox + ",msgInfos=" + this.msgInfos + ",}";
    }

    public SpecificEventTypeInfoInMsgBox(int i3, ArrayList<MsgBoxNecessaryMsgInfo> arrayList) {
        new ArrayList();
        this.eventTypeInMsgBox = i3;
        this.msgInfos = arrayList;
    }
}
