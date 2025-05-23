package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry implements Serializable {
    public int key;
    long serialVersionUID = 1;
    public GProGuildGlobalAuthInfoItem value = new GProGuildGlobalAuthInfoItem();

    public int getKey() {
        return this.key;
    }

    public GProGuildGlobalAuthInfoItem getValue() {
        return this.value;
    }

    public String toString() {
        return "GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry{key=" + this.key + ",value=" + this.value + ",}";
    }
}
