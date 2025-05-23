package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsRootSearcherRequest {
    public int business;
    public int pageSize;
    public int queryFlag;
    public int queryRewrite;
    public int useAllMask;
    public ArrayList<Long> busiMaskList = new ArrayList<>();
    public byte[] cookie = new byte[0];
    public byte[] oceanData = new byte[0];
    public ArrayList<String> queryCateList = new ArrayList<>();
    public byte[] qua = new byte[0];
    public byte[] jsonData = new byte[0];
    public ArrayList<UfsItemRequestUserData> userDataList = new ArrayList<>();
    public UfsItemRequestBusiMask requestBusiMask = new UfsItemRequestBusiMask();

    public ArrayList<Long> getBusiMaskList() {
        return this.busiMaskList;
    }

    public int getBusiness() {
        return this.business;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public byte[] getJsonData() {
        return this.jsonData;
    }

    public byte[] getOceanData() {
        return this.oceanData;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public byte[] getQua() {
        return this.qua;
    }

    public ArrayList<String> getQueryCateList() {
        return this.queryCateList;
    }

    public int getQueryFlag() {
        return this.queryFlag;
    }

    public int getQueryRewrite() {
        return this.queryRewrite;
    }

    public UfsItemRequestBusiMask getRequestBusiMask() {
        return this.requestBusiMask;
    }

    public int getUseAllMask() {
        return this.useAllMask;
    }

    public ArrayList<UfsItemRequestUserData> getUserDataList() {
        return this.userDataList;
    }

    public String toString() {
        return "UfsRootSearcherRequest{business=" + this.business + ",pageSize=" + this.pageSize + ",busiMaskList=" + this.busiMaskList + ",cookie=" + this.cookie + ",oceanData=" + this.oceanData + ",useAllMask=" + this.useAllMask + ",queryCateList=" + this.queryCateList + ",queryRewrite=" + this.queryRewrite + ",qua=" + this.qua + ",jsonData=" + this.jsonData + ",queryFlag=" + this.queryFlag + ",userDataList=" + this.userDataList + ",requestBusiMask=" + this.requestBusiMask + ",}";
    }
}
