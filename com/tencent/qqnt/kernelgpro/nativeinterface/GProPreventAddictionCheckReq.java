package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPreventAddictionCheckReq implements Serializable {
    public String context;
    long serialVersionUID;

    public GProPreventAddictionCheckReq() {
        this.serialVersionUID = 1L;
        this.context = "";
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public String toString() {
        return "GProPreventAddictionCheckReq{context=" + this.context + ",}";
    }

    public GProPreventAddictionCheckReq(String str) {
        this.serialVersionUID = 1L;
        this.context = str;
    }
}
