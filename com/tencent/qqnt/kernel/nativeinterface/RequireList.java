package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RequireList {
    public String buttonName = "";
    public String type = "";
    public ArrayList<RequireData> requireData = new ArrayList<>();

    public String getButtonName() {
        return this.buttonName;
    }

    public ArrayList<RequireData> getRequireData() {
        return this.requireData;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "RequireList{buttonName=" + this.buttonName + ",type=" + this.type + ",requireData=" + this.requireData + ",}";
    }
}
