package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsfRspInfo {
    public String errorMsg;
    public byte[] pbBuffer;
    public int ssoRetCode;
    public HashMap<String, byte[]> transInfoMap;
    public int trpcFuncCode;
    public int trpcRetCode;

    public MsfRspInfo() {
        this.errorMsg = "";
        this.pbBuffer = new byte[0];
        this.transInfoMap = new HashMap<>();
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public byte[] getPbBuffer() {
        return this.pbBuffer;
    }

    public int getSsoRetCode() {
        return this.ssoRetCode;
    }

    public HashMap<String, byte[]> getTransInfoMap() {
        return this.transInfoMap;
    }

    public int getTrpcFuncCode() {
        return this.trpcFuncCode;
    }

    public int getTrpcRetCode() {
        return this.trpcRetCode;
    }

    public String toString() {
        return "MsfRspInfo{ssoRetCode=" + this.ssoRetCode + ",trpcRetCode=" + this.trpcRetCode + ",trpcFuncCode=" + this.trpcFuncCode + ",errorMsg=" + this.errorMsg + ",pbBuffer=" + this.pbBuffer + ",transInfoMap=" + this.transInfoMap + ",}";
    }

    public MsfRspInfo(int i3, int i16, int i17, String str, byte[] bArr, HashMap<String, byte[]> hashMap) {
        this.errorMsg = "";
        this.pbBuffer = new byte[0];
        new HashMap();
        this.ssoRetCode = i3;
        this.trpcRetCode = i16;
        this.trpcFuncCode = i17;
        this.errorMsg = str;
        this.pbBuffer = bArr;
        this.transInfoMap = hashMap;
    }
}
