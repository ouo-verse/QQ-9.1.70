package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MiscData {
    public MiscKeyInfo keyInfo = new MiscKeyInfo();
    public PopUpInfo popUpInfo;

    public MiscKeyInfo getKeyInfo() {
        return this.keyInfo;
    }

    public PopUpInfo getPopUpInfo() {
        return this.popUpInfo;
    }

    public String toString() {
        return "MiscData{keyInfo=" + this.keyInfo + ",popUpInfo=" + this.popUpInfo + ",}";
    }
}
