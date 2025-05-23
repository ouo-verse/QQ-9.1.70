package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildOnlineReportExtInfo {
    public String key;
    public String value;

    public GProGuildOnlineReportExtInfo() {
        this.key = "";
        this.value = "";
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "GProGuildOnlineReportExtInfo{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProGuildOnlineReportExtInfo(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
