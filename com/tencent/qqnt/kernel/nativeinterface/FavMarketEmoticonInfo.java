package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FavMarketEmoticonInfo {
    public String eId;
    public String faceName;
    public int height;
    public int width;

    public FavMarketEmoticonInfo() {
        this.eId = "";
        this.faceName = "";
    }

    public String getEId() {
        return this.eId;
    }

    public String getFaceName() {
        return this.faceName;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "FavMarketEmoticonInfo{eId=" + this.eId + ",width=" + this.width + ",height=" + this.height + ",faceName=" + this.faceName + ",}";
    }

    public FavMarketEmoticonInfo(String str, int i3, int i16, String str2) {
        this.eId = str;
        this.width = i3;
        this.height = i16;
        this.faceName = str2;
    }
}
