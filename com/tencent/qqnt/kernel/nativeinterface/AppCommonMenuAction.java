package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppCommonMenuAction implements Serializable {
    public int type;
    long serialVersionUID = 1;
    public AppCommonJump jump = new AppCommonJump();
    public ArrayList<AppCommonMessage> msgList = new ArrayList<>();

    public AppCommonJump getJump() {
        return this.jump;
    }

    public ArrayList<AppCommonMessage> getMsgList() {
        return this.msgList;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "AppCommonMenuAction{type=" + this.type + ",jump=" + this.jump + ",msgList=" + this.msgList + ",}";
    }
}
