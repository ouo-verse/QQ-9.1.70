package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ThirdPartyBusinessInfo {
    public String info;
    public boolean isPersistence;
    public LiteBusinessType type;

    public ThirdPartyBusinessInfo() {
        this.type = LiteBusinessType.values()[0];
        this.info = "";
    }

    public String getInfo() {
        return this.info;
    }

    public boolean getIsPersistence() {
        return this.isPersistence;
    }

    public LiteBusinessType getType() {
        return this.type;
    }

    public String toString() {
        return "ThirdPartyBusinessInfo{type=" + this.type + ",info=" + this.info + ",isPersistence=" + this.isPersistence + ",}";
    }

    public ThirdPartyBusinessInfo(LiteBusinessType liteBusinessType, String str, boolean z16) {
        LiteBusinessType liteBusinessType2 = LiteBusinessType.values()[0];
        this.type = liteBusinessType;
        this.info = str;
        this.isPersistence = z16;
    }
}
