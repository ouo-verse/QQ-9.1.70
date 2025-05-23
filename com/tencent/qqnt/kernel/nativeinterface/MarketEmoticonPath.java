package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class MarketEmoticonPath {
    public boolean isExist;
    public String path;

    public MarketEmoticonPath() {
        this.path = "";
    }

    public boolean getIsExist() {
        return this.isExist;
    }

    public String getPath() {
        return this.path;
    }

    public String toString() {
        return "MarketEmoticonPath{isExist=" + this.isExist + ",path=" + this.path + ",}";
    }

    public MarketEmoticonPath(boolean z16, String str) {
        this.isExist = z16;
        this.path = str;
    }
}
