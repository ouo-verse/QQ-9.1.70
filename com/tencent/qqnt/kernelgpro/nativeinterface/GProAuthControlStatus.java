package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAuthControlStatus implements Serializable {
    public int authControlKey;
    public int authControlValue;
    long serialVersionUID = 1;

    public int getAuthControlKey() {
        return this.authControlKey;
    }

    public int getAuthControlValue() {
        return this.authControlValue;
    }

    public String toString() {
        return "GProAuthControlStatus{authControlKey=" + this.authControlKey + ",authControlValue=" + this.authControlValue + ",}";
    }
}
