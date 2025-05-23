package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendLabel implements Serializable {
    public int bussiLabelType;
    public String labelName;
    public int labelType;
    public int labelValue;
    long serialVersionUID;
    public String value;
    public ArrayList<String> valueList;

    public GProRecommendLabel() {
        this.serialVersionUID = 1L;
        this.labelName = "";
        this.value = "";
        this.valueList = new ArrayList<>();
    }

    public int getBussiLabelType() {
        return this.bussiLabelType;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public int getLabelType() {
        return this.labelType;
    }

    public int getLabelValue() {
        return this.labelValue;
    }

    public String getValue() {
        return this.value;
    }

    public ArrayList<String> getValueList() {
        return this.valueList;
    }

    public String toString() {
        return "GProRecommendLabel{labelName=" + this.labelName + ",labelType=" + this.labelType + ",labelValue=" + this.labelValue + ",value=" + this.value + ",valueList=" + this.valueList + ",bussiLabelType=" + this.bussiLabelType + ",}";
    }

    public GProRecommendLabel(String str, int i3, int i16, String str2, ArrayList<String> arrayList, int i17) {
        this.serialVersionUID = 1L;
        this.labelName = "";
        this.value = "";
        new ArrayList();
        this.labelName = str;
        this.labelType = i3;
        this.labelValue = i16;
        this.value = str2;
        this.valueList = arrayList;
        this.bussiLabelType = i17;
    }
}
