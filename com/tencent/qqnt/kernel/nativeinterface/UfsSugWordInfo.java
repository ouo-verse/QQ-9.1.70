package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSugWordInfo {
    public int sugWordType;
    public UfsIcon icon = new UfsIcon();
    public String tag = "";

    public UfsIcon getIcon() {
        return this.icon;
    }

    public int getSugWordType() {
        return this.sugWordType;
    }

    public String getTag() {
        return this.tag;
    }

    public String toString() {
        return "UfsSugWordInfo{sugWordType=" + this.sugWordType + ",icon=" + this.icon + ",tag=" + this.tag + ",}";
    }
}
