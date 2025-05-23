package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStMaterialDataNew {
    public String materialType = "";
    public ArrayList<GProStSingleMaterial> materialListList = new ArrayList<>();

    public ArrayList<GProStSingleMaterial> getMaterialListList() {
        return this.materialListList;
    }

    public String getMaterialType() {
        return this.materialType;
    }

    public String toString() {
        return "GProStMaterialDataNew{materialType=" + this.materialType + ",materialListList=" + this.materialListList + ",}";
    }
}
