package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStDataReportReq {
    public ArrayList<GProSingleTableData> dataList = new ArrayList<>();

    public ArrayList<GProSingleTableData> getDataList() {
        return this.dataList;
    }

    public String toString() {
        return "GProStDataReportReq{dataList=" + this.dataList + ",}";
    }
}
