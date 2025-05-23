package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupFileListResult {
    public int allFileCount;
    public String clientWording;
    public boolean isEnd;
    public ArrayList<GroupItem> item;
    public int nextIndex;
    public int reqId;
    public int retCode;
    public String retMsg;

    public GroupFileListResult() {
        this.retMsg = "";
        this.clientWording = "";
        this.item = new ArrayList<>();
    }

    public int getAllFileCount() {
        return this.allFileCount;
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GroupItem> getItem() {
        return this.item;
    }

    public int getNextIndex() {
        return this.nextIndex;
    }

    public int getReqId() {
        return this.reqId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public GroupFileListResult(int i3, String str, String str2, boolean z16, ArrayList<GroupItem> arrayList, int i16, int i17, int i18) {
        this.retMsg = "";
        this.clientWording = "";
        new ArrayList();
        this.retCode = i3;
        this.retMsg = str;
        this.clientWording = str2;
        this.isEnd = z16;
        this.item = arrayList;
        this.allFileCount = i16;
        this.nextIndex = i17;
        this.reqId = i18;
    }
}
