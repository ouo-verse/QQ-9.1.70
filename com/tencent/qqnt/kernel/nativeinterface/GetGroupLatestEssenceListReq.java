package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetGroupLatestEssenceListReq {
    public int excludeMsgType;
    public long groupCode;
    public int msgType;
    public long signTs;
    public int source;
    public String sign = "";
    public String pageCookie = "";

    public int getExcludeMsgType() {
        return this.excludeMsgType;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getPageCookie() {
        return this.pageCookie;
    }

    public String getSign() {
        return this.sign;
    }

    public long getSignTs() {
        return this.signTs;
    }

    public int getSource() {
        return this.source;
    }

    public String toString() {
        return "GetGroupLatestEssenceListReq{groupCode=" + this.groupCode + ",source=" + this.source + ",sign=" + this.sign + ",signTs=" + this.signTs + ",msgType=" + this.msgType + ",pageCookie=" + this.pageCookie + ",excludeMsgType=" + this.excludeMsgType + ",}";
    }
}
