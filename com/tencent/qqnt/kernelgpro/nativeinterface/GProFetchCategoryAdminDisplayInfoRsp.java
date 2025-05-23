package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFetchCategoryAdminDisplayInfoRsp {
    public ArrayList<GProCategoryAdminDisplayInfo> categoryAdminDisplayList;
    public int categoryAdminMaxNum;

    public GProFetchCategoryAdminDisplayInfoRsp() {
        this.categoryAdminDisplayList = new ArrayList<>();
    }

    public ArrayList<GProCategoryAdminDisplayInfo> getCategoryAdminDisplayList() {
        return this.categoryAdminDisplayList;
    }

    public int getCategoryAdminMaxNum() {
        return this.categoryAdminMaxNum;
    }

    public String toString() {
        return "GProFetchCategoryAdminDisplayInfoRsp{categoryAdminDisplayList=" + this.categoryAdminDisplayList + ",categoryAdminMaxNum=" + this.categoryAdminMaxNum + ",}";
    }

    public GProFetchCategoryAdminDisplayInfoRsp(ArrayList<GProCategoryAdminDisplayInfo> arrayList, int i3) {
        new ArrayList();
        this.categoryAdminDisplayList = arrayList;
        this.categoryAdminMaxNum = i3;
    }
}
