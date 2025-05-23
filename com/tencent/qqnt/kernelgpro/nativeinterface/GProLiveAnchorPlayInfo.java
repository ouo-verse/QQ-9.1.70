package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLiveAnchorPlayInfo {
    public String errMsg;
    public Integer result;
    public ArrayList<GProLiveAnchorPlayStream> streams = new ArrayList<>();

    public String getErrMsg() {
        return this.errMsg;
    }

    public Integer getResult() {
        return this.result;
    }

    public ArrayList<GProLiveAnchorPlayStream> getStreams() {
        return this.streams;
    }

    public String toString() {
        return "GProLiveAnchorPlayInfo{result=" + this.result + ",errMsg=" + this.errMsg + ",streams=" + this.streams + ",}";
    }
}
