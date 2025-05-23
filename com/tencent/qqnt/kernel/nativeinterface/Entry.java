package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Entry implements Serializable {
    public int numberKey;
    long serialVersionUID = 1;
    public String key = "";
    public String value = "";

    public String getKey() {
        return this.key;
    }

    public int getNumberKey() {
        return this.numberKey;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setNumberKey(int i3) {
        this.numberKey = i3;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
