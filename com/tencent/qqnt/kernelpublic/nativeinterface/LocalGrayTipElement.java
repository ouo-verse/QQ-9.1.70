package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LocalGrayTipElement implements Serializable {
    public LocalGrayTipDirect direct;
    public String extraJson;
    public LocalGrayTipRobot robot;
    long serialVersionUID;
    public int type;

    public LocalGrayTipElement() {
        this.serialVersionUID = 1L;
        this.extraJson = "";
    }

    public LocalGrayTipDirect getDirect() {
        return this.direct;
    }

    public String getExtraJson() {
        return this.extraJson;
    }

    public LocalGrayTipRobot getRobot() {
        return this.robot;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "LocalGrayTipElement{type=" + this.type + ",robot=" + this.robot + ",direct=" + this.direct + ",extraJson=" + this.extraJson + ",}";
    }

    public LocalGrayTipElement(int i3, LocalGrayTipRobot localGrayTipRobot, LocalGrayTipDirect localGrayTipDirect, String str) {
        this.serialVersionUID = 1L;
        this.type = i3;
        this.robot = localGrayTipRobot;
        this.direct = localGrayTipDirect;
        this.extraJson = str;
    }
}
