package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FetchGroupEssenceListRsp {
    public int groupRole;
    public boolean isEnd;
    public boolean showTips;
    public ArrayList<FetchEssenceMsgInfo> msgList = new ArrayList<>();
    public String configPageUrl = "";

    public String getConfigPageUrl() {
        return this.configPageUrl;
    }

    public int getGroupRole() {
        return this.groupRole;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<FetchEssenceMsgInfo> getMsgList() {
        return this.msgList;
    }

    public boolean getShowTips() {
        return this.showTips;
    }

    public String toString() {
        return "FetchGroupEssenceListRsp{msgList=" + this.msgList + ",isEnd=" + this.isEnd + ",showTips=" + this.showTips + ",groupRole=" + this.groupRole + ",configPageUrl=" + this.configPageUrl + ",}";
    }
}
