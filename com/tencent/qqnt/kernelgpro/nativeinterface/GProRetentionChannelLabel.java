package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRetentionChannelLabel implements Serializable {
    public String labelName;
    public int labelType;
    public int labelValue;
    long serialVersionUID;

    public GProRetentionChannelLabel() {
        this.serialVersionUID = 1L;
        this.labelName = "";
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

    public String toString() {
        return "GProRetentionChannelLabel{labelName=" + this.labelName + ",labelType=" + this.labelType + ",labelValue=" + this.labelValue + ",}";
    }

    public GProRetentionChannelLabel(String str, int i3, int i16) {
        this.serialVersionUID = 1L;
        this.labelName = str;
        this.labelType = i3;
        this.labelValue = i16;
    }
}
