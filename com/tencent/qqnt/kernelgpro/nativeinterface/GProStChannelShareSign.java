package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStChannelShareSign implements Serializable {
    public long createAt;
    long serialVersionUID = 1;
    public String token = "";

    public long getCreateAt() {
        return this.createAt;
    }

    public String getToken() {
        return this.token;
    }

    public String toString() {
        return "GProStChannelShareSign{createAt=" + this.createAt + ",token=" + this.token + ",}";
    }
}
