package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppCommonAction implements Serializable {
    public boolean needJumpAio;
    public int type;
    long serialVersionUID = 1;
    public AppCommonJump jump = new AppCommonJump();
    public ArrayList<AppCommonMessage> msgList = new ArrayList<>();
    public ArrayList<AppCommonMenu> menuList = new ArrayList<>();
    public String associatedId = "";

    public String getAssociatedId() {
        return this.associatedId;
    }

    public AppCommonJump getJump() {
        return this.jump;
    }

    public ArrayList<AppCommonMenu> getMenuList() {
        return this.menuList;
    }

    public ArrayList<AppCommonMessage> getMsgList() {
        return this.msgList;
    }

    public boolean getNeedJumpAio() {
        return this.needJumpAio;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "AppCommonAction{type=" + this.type + ",jump=" + this.jump + ",msgList=" + this.msgList + ",menuList=" + this.menuList + ",associatedId=" + this.associatedId + ",needJumpAio=" + this.needJumpAio + ",}";
    }
}
