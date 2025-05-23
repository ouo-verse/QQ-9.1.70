package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSingleTableData {
    public int tableID;
    public ArrayList<GProFeedEntry> reportDataList = new ArrayList<>();
    public ArrayList<GProFeedEntry> extInfoList = new ArrayList<>();
    public ArrayList<GProBytesEntry> byteExtInfoList = new ArrayList<>();

    public ArrayList<GProBytesEntry> getByteExtInfoList() {
        return this.byteExtInfoList;
    }

    public ArrayList<GProFeedEntry> getExtInfoList() {
        return this.extInfoList;
    }

    public ArrayList<GProFeedEntry> getReportDataList() {
        return this.reportDataList;
    }

    public int getTableID() {
        return this.tableID;
    }

    public String toString() {
        return "GProSingleTableData{tableID=" + this.tableID + ",reportDataList=" + this.reportDataList + ",extInfoList=" + this.extInfoList + ",byteExtInfoList=" + this.byteExtInfoList + ",}";
    }
}
