package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QueryArkInfoReq {
    public ArrayList<String> bizsrc;
    public int pageNum;
    public int pageSize;

    public QueryArkInfoReq() {
        this.bizsrc = new ArrayList<>();
    }

    public ArrayList<String> getBizsrc() {
        return this.bizsrc;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String toString() {
        return "QueryArkInfoReq{bizsrc=" + this.bizsrc + ",pageNum=" + this.pageNum + ",pageSize=" + this.pageSize + ",}";
    }

    public QueryArkInfoReq(ArrayList<String> arrayList, int i3, int i16) {
        new ArrayList();
        this.bizsrc = arrayList;
        this.pageNum = i3;
        this.pageSize = i16;
    }
}
