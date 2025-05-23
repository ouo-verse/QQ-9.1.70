package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReqInfo implements IKernelModel {
    public int count;
    public boolean isNeedPhysicalInfoReady;
    public int reqDepth;
    public String parentId = "";
    public String reqIndexPath = "";
    public byte[] paginationInfo = new byte[0];
    public FilterCondition filterCondition = new FilterCondition();
    public ArrayList<SortCondition> sortConditions = new ArrayList<>();

    public int getCount() {
        return this.count;
    }

    public FilterCondition getFilterCondition() {
        return this.filterCondition;
    }

    public boolean getIsNeedPhysicalInfoReady() {
        return this.isNeedPhysicalInfoReady;
    }

    public byte[] getPaginationInfo() {
        return this.paginationInfo;
    }

    public String getParentId() {
        return this.parentId;
    }

    public int getReqDepth() {
        return this.reqDepth;
    }

    public String getReqIndexPath() {
        return this.reqIndexPath;
    }

    public ArrayList<SortCondition> getSortConditions() {
        return this.sortConditions;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setFilterCondition(FilterCondition filterCondition) {
        this.filterCondition = filterCondition;
    }

    public void setIsNeedPhysicalInfoReady(boolean z16) {
        this.isNeedPhysicalInfoReady = z16;
    }

    public void setPaginationInfo(byte[] bArr) {
        this.paginationInfo = bArr;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setReqDepth(int i3) {
        this.reqDepth = i3;
    }

    public void setReqIndexPath(String str) {
        this.reqIndexPath = str;
    }

    public void setSortConditions(ArrayList<SortCondition> arrayList) {
        this.sortConditions = arrayList;
    }
}
