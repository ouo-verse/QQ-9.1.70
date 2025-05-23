package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes24.dex */
public final class VASAIOPersonalElement {
    public HashMap<String, String> extInfo;
    public Long troopNameColorId;
    public Integer vaDataChangeRand;
    public VASPersonalNamePlate vasPersonalNamePlate;
    public ArrayList<VASPersonalVipNumberInfo> vipNumbers;

    public VASAIOPersonalElement() {
        this.vipNumbers = new ArrayList<>();
    }

    public HashMap<String, String> getExtInfo() {
        return this.extInfo;
    }

    public Long getTroopNameColorId() {
        return this.troopNameColorId;
    }

    public Integer getVaDataChangeRand() {
        return this.vaDataChangeRand;
    }

    public VASPersonalNamePlate getVasPersonalNamePlate() {
        return this.vasPersonalNamePlate;
    }

    public ArrayList<VASPersonalVipNumberInfo> getVipNumbers() {
        return this.vipNumbers;
    }

    public String toString() {
        return "VASAIOPersonalElement{troopNameColorId=" + this.troopNameColorId + ",vipNumbers=" + this.vipNumbers + ",vaDataChangeRand=" + this.vaDataChangeRand + ",vasPersonalNamePlate=" + this.vasPersonalNamePlate + ",extInfo=" + this.extInfo + ",}";
    }

    public VASAIOPersonalElement(Long l3, ArrayList<VASPersonalVipNumberInfo> arrayList, Integer num, VASPersonalNamePlate vASPersonalNamePlate, HashMap<String, String> hashMap) {
        new ArrayList();
        this.troopNameColorId = l3;
        this.vipNumbers = arrayList;
        this.vaDataChangeRand = num;
        this.vasPersonalNamePlate = vASPersonalNamePlate;
        this.extInfo = hashMap;
    }
}
