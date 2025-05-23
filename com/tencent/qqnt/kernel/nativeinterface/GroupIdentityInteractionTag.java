package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupIdentityInteractionTag implements Serializable {
    public boolean isObtained;
    public boolean isSet;
    long serialVersionUID = 1;
    public String interactionTagId = "";
    public String name = "";
    public String icon = "";
    public String rule = "";

    public String getIcon() {
        return this.icon;
    }

    public String getInteractionTagId() {
        return this.interactionTagId;
    }

    public boolean getIsObtained() {
        return this.isObtained;
    }

    public boolean getIsSet() {
        return this.isSet;
    }

    public String getName() {
        return this.name;
    }

    public String getRule() {
        return this.rule;
    }

    public String toString() {
        return "GroupIdentityInteractionTag{interactionTagId=" + this.interactionTagId + ",name=" + this.name + ",icon=" + this.icon + ",rule=" + this.rule + ",isObtained=" + this.isObtained + ",isSet=" + this.isSet + ",}";
    }
}
