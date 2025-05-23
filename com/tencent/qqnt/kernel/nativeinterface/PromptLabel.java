package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PromptLabel {
    public int labelId;
    public String labelName = "";

    public int getLabelId() {
        return this.labelId;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public String toString() {
        return "PromptLabel{labelId=" + this.labelId + ",labelName=" + this.labelName + ",}";
    }
}
