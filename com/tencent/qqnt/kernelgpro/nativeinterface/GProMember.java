package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMember implements Serializable {
    public long tinyId;
    long serialVersionUID = 1;
    public String name = "";

    public String getName() {
        return this.name;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMember{tinyId=" + this.tinyId + ",name=" + this.name + ",}";
    }
}
