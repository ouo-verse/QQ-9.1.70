package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetUnbindClientRsp {
    public boolean isEnd;
    public byte[] cookie = new byte[0];
    public ArrayList<GProGetUnbindClientInfo> unbindClients = new ArrayList<>();

    public byte[] getCookie() {
        return this.cookie;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProGetUnbindClientInfo> getUnbindClients() {
        return this.unbindClients;
    }

    public String toString() {
        return "GProGetUnbindClientRsp{isEnd=" + this.isEnd + ",cookie=" + this.cookie + ",unbindClients=" + this.unbindClients + ",}";
    }
}
