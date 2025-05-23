package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckLimitHandleResultReq {
    public byte[] context;
    public FaceResult faceResult;
    public String handleResult;
    public Iframe iframe;

    public byte[] getContext() {
        return this.context;
    }

    public FaceResult getFaceResult() {
        return this.faceResult;
    }

    public String getHandleResult() {
        return this.handleResult;
    }

    public Iframe getIframe() {
        return this.iframe;
    }

    public String toString() {
        return "CheckLimitHandleResultReq{iframe=" + this.iframe + ",handleResult=" + this.handleResult + ",faceResult=" + this.faceResult + ",context=" + this.context + ",}";
    }
}
