package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStickyTextChannel implements Serializable {
    long serialVersionUID = 1;
    public String activeMemberCount = "";
    public ArrayList<GProMsgSummary> msgList = new ArrayList<>();
    public ArrayList<MsgAbstract> msgAbstracts = new ArrayList<>();
    public ArrayList<GProUser> activeMemberList = new ArrayList<>();

    public String getActiveMemberCount() {
        return this.activeMemberCount;
    }

    public ArrayList<GProUser> getActiveMemberList() {
        return this.activeMemberList;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public ArrayList<GProMsgSummary> getMsgList() {
        return this.msgList;
    }

    public String toString() {
        return "GProStickyTextChannel{activeMemberCount=" + this.activeMemberCount + ",msgList=" + this.msgList + ",msgAbstracts=" + this.msgAbstracts + ",activeMemberList=" + this.activeMemberList + ",}";
    }
}
