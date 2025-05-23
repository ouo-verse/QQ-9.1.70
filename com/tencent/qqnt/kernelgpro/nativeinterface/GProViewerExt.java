package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProViewerExt implements Serializable {
    public int fakeNum;
    public int realNum;
    public int rebotNum;
    long serialVersionUID = 1;

    public int getFakeNum() {
        return this.fakeNum;
    }

    public int getRealNum() {
        return this.realNum;
    }

    public int getRebotNum() {
        return this.rebotNum;
    }

    public String toString() {
        return "GProViewerExt{fakeNum=" + this.fakeNum + ",realNum=" + this.realNum + ",rebotNum=" + this.rebotNum + ",}";
    }
}
