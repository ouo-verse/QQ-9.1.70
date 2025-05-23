package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMetricsItem {
    public String name = "";
    public long num;
    public int type;

    public String getName() {
        return this.name;
    }

    public long getNum() {
        return this.num;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProMetricsItem{type=" + this.type + ",name=" + this.name + ",num=" + this.num + ",}";
    }
}
