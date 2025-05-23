package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ModelConfig {
    public boolean isDefaultModel;
    public boolean isSelected;
    public String modelIcon = "";
    public String title = "";
    public String aioTitle = "";
    public String desc = "";
    public String modelId = "";
    public String callbackData = "";
    public ModelDisableStyle disableStyle = ModelDisableStyle.values()[0];

    public String getAioTitle() {
        return this.aioTitle;
    }

    public String getCallbackData() {
        return this.callbackData;
    }

    public String getDesc() {
        return this.desc;
    }

    public ModelDisableStyle getDisableStyle() {
        return this.disableStyle;
    }

    public boolean getIsDefaultModel() {
        return this.isDefaultModel;
    }

    public boolean getIsSelected() {
        return this.isSelected;
    }

    public String getModelIcon() {
        return this.modelIcon;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "ModelConfig{modelIcon=" + this.modelIcon + ",title=" + this.title + ",aioTitle=" + this.aioTitle + ",desc=" + this.desc + ",modelId=" + this.modelId + ",callbackData=" + this.callbackData + ",isDefaultModel=" + this.isDefaultModel + ",isSelected=" + this.isSelected + ",disableStyle=" + this.disableStyle + ",}";
    }
}
