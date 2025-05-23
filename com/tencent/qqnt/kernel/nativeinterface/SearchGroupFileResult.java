package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroupFileResult {
    public boolean isEnd;
    public ArrayList<SearchGroupFileItem> item;
    public int ownerMatchCount;
    public int reqId;
    public GroupFileCommonResult result;
    public String syncCookie;
    public int totalMatchCount;

    public SearchGroupFileResult() {
        this.result = new GroupFileCommonResult();
        this.syncCookie = "";
        this.item = new ArrayList<>();
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<SearchGroupFileItem> getItem() {
        return this.item;
    }

    public int getOwnerMatchCount() {
        return this.ownerMatchCount;
    }

    public int getReqId() {
        return this.reqId;
    }

    public GroupFileCommonResult getResult() {
        return this.result;
    }

    public String getSyncCookie() {
        return this.syncCookie;
    }

    public int getTotalMatchCount() {
        return this.totalMatchCount;
    }

    public SearchGroupFileResult(GroupFileCommonResult groupFileCommonResult, String str, int i3, int i16, boolean z16, int i17, ArrayList<SearchGroupFileItem> arrayList) {
        this.result = new GroupFileCommonResult();
        this.syncCookie = "";
        new ArrayList();
        this.result = groupFileCommonResult;
        this.syncCookie = str;
        this.totalMatchCount = i3;
        this.ownerMatchCount = i16;
        this.isEnd = z16;
        this.reqId = i17;
        this.item = arrayList;
    }
}
