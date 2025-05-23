package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotGroupLabel {
    public int labelType;
    public String labelName = "";
    public RobotGroupLabelColor textColor = new RobotGroupLabelColor();
    public RobotGroupLabelColor edgingColor = new RobotGroupLabelColor();

    public RobotGroupLabelColor getEdgingColor() {
        return this.edgingColor;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public int getLabelType() {
        return this.labelType;
    }

    public RobotGroupLabelColor getTextColor() {
        return this.textColor;
    }

    public String toString() {
        return "RobotGroupLabel{labelName=" + this.labelName + ",textColor=" + this.textColor + ",edgingColor=" + this.edgingColor + ",labelType=" + this.labelType + ",}";
    }
}
