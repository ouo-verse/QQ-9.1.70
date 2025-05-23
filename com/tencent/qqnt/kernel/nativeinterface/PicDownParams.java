package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PicDownParams {
    public Integer downSize;
    public int downType;

    public PicDownParams() {
    }

    public Integer getDownSize() {
        return this.downSize;
    }

    public int getDownType() {
        return this.downType;
    }

    public PicDownParams(int i3, Integer num) {
        this.downType = i3;
        this.downSize = num;
    }
}
