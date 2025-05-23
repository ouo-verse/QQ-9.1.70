package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStGuildLabel implements Serializable {
    public int bussiLabelType;
    public int labelType;
    public int labelValue;
    long serialVersionUID = 1;
    public byte[] labelName = new byte[0];
    public String value = "";
    public ArrayList<String> valueList = new ArrayList<>();
    public byte[] bussiData = new byte[0];

    public byte[] getBussiData() {
        return this.bussiData;
    }

    public int getBussiLabelType() {
        return this.bussiLabelType;
    }

    public byte[] getLabelName() {
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
        return "GProStGuildLabel{labelName=" + this.labelName + ",labelType=" + this.labelType + ",labelValue=" + this.labelValue + ",value=" + this.value + ",valueList=" + this.valueList + ",bussiLabelType=" + this.bussiLabelType + ",bussiData=" + this.bussiData + ",}";
    }
}
