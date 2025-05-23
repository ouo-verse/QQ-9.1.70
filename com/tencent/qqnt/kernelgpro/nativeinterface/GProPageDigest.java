package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPageDigest {
    public ArrayList<Integer> businessTypeFilterList = new ArrayList<>();
    public String cookie = "";
    public long count;

    public ArrayList<Integer> getBusinessTypeFilterList() {
        return this.businessTypeFilterList;
    }

    public String getCookie() {
        return this.cookie;
    }

    public long getCount() {
        return this.count;
    }

    public String toString() {
        return "GProPageDigest{businessTypeFilterList=" + this.businessTypeFilterList + ",count=" + this.count + ",cookie=" + this.cookie + ",}";
    }
}
