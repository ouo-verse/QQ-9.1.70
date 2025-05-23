package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OptButton {
    public int defaultCheck;
    public boolean isSelected;
    public OptID optID = OptID.values()[0];
    public String name = "";
    public String icon = "";
    public String schema = "";
    public OptType type = OptType.values()[0];
    public String callbackData = "";
    public ArrayList<String> filterModelIds = new ArrayList<>();
    public String optDesc = "";
    public String promptTemplate = "";
    public String inputPlaceholder = "";
    public String buttonId = "";
    public ArrayList<OptButton> subButtons = new ArrayList<>();

    public String getButtonId() {
        return this.buttonId;
    }

    public String getCallbackData() {
        return this.callbackData;
    }

    public int getDefaultCheck() {
        return this.defaultCheck;
    }

    public ArrayList<String> getFilterModelIds() {
        return this.filterModelIds;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getInputPlaceholder() {
        return this.inputPlaceholder;
    }

    public boolean getIsSelected() {
        return this.isSelected;
    }

    public String getName() {
        return this.name;
    }

    public String getOptDesc() {
        return this.optDesc;
    }

    public OptID getOptID() {
        return this.optID;
    }

    public String getPromptTemplate() {
        return this.promptTemplate;
    }

    public String getSchema() {
        return this.schema;
    }

    public ArrayList<OptButton> getSubButtons() {
        return this.subButtons;
    }

    public OptType getType() {
        return this.type;
    }

    public String toString() {
        return "OptButton{optID=" + this.optID + ",name=" + this.name + ",icon=" + this.icon + ",schema=" + this.schema + ",type=" + this.type + ",callbackData=" + this.callbackData + ",defaultCheck=" + this.defaultCheck + ",filterModelIds=" + this.filterModelIds + ",optDesc=" + this.optDesc + ",promptTemplate=" + this.promptTemplate + ",inputPlaceholder=" + this.inputPlaceholder + ",buttonId=" + this.buttonId + ",subButtons=" + this.subButtons + ",isSelected=" + this.isSelected + ",}";
    }
}
