package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFDLEntry {
    public String key;
    public String value;

    public GProFDLEntry() {
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
        return "GProFDLEntry{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProFDLEntry(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
