package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProFeedEntry implements Serializable {
    long serialVersionUID = 1;
    public String key = "";
    public String value = "";

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "GProFeedEntry{key=" + this.key + ",value=" + this.value + ",}";
    }
}
