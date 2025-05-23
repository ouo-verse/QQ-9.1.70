package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProLiveDataItem {
    public boolean isShow;
    public String name = "";
    public int type;
    public long value;

    public boolean getIsShow() {
        return this.isShow;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "GProLiveDataItem{type=" + this.type + ",name=" + this.name + ",value=" + this.value + ",isShow=" + this.isShow + ",}";
    }
}
