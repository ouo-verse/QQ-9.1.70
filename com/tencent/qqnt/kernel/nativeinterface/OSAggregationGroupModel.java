package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSAggregationGroupModel {
    public int extStatus;
    public ArrayList<OSAggregationCellModel> listCells;
    public int status;

    public OSAggregationGroupModel() {
        this.listCells = new ArrayList<>();
    }

    public int getExtStatus() {
        return this.extStatus;
    }

    public ArrayList<OSAggregationCellModel> getListCells() {
        return this.listCells;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "OSAggregationGroupModel{status=" + this.status + ",extStatus=" + this.extStatus + ",listCells=" + this.listCells + ",}";
    }

    public OSAggregationGroupModel(int i3, int i16, ArrayList<OSAggregationCellModel> arrayList) {
        new ArrayList();
        this.status = i3;
        this.extStatus = i16;
        this.listCells = arrayList;
    }
}
