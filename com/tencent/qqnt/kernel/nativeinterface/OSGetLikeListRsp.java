package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSGetLikeListRsp {
    public int errCode;
    public String errMsg;
    public int interval;
    public ArrayList<OSLikeNotifyItem> notifyItems;
    public int timeout;
    public int unreadNum;

    public OSGetLikeListRsp() {
        this.notifyItems = new ArrayList<>();
        this.errMsg = "";
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getInterval() {
        return this.interval;
    }

    public ArrayList<OSLikeNotifyItem> getNotifyItems() {
        return this.notifyItems;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getUnreadNum() {
        return this.unreadNum;
    }

    public String toString() {
        return "OSGetLikeListRsp{unreadNum=" + this.unreadNum + ",notifyItems=" + this.notifyItems + ",interval=" + this.interval + ",timeout=" + this.timeout + ",errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",}";
    }

    public OSGetLikeListRsp(int i3, ArrayList<OSLikeNotifyItem> arrayList, int i16, int i17, int i18, String str) {
        new ArrayList();
        this.unreadNum = i3;
        this.notifyItems = arrayList;
        this.interval = i16;
        this.timeout = i17;
        this.errCode = i18;
        this.errMsg = str;
    }
}
