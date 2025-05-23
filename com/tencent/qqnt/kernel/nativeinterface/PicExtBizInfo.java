package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PicExtBizInfo {
    public int bizType;
    public int fromScene;
    public int imageBizType;
    public int toScene;
    public int uint32OldFileId;
    public String textSummary = "";
    public byte[] bytesPbReserveC2c = new byte[0];
    public byte[] bytesPbReserveGroup = new byte[0];

    public int getBizType() {
        return this.bizType;
    }

    public byte[] getBytesPbReserveC2c() {
        return this.bytesPbReserveC2c;
    }

    public byte[] getBytesPbReserveGroup() {
        return this.bytesPbReserveGroup;
    }

    public int getFromScene() {
        return this.fromScene;
    }

    public int getImageBizType() {
        return this.imageBizType;
    }

    public String getTextSummary() {
        return this.textSummary;
    }

    public int getToScene() {
        return this.toScene;
    }

    public int getUint32OldFileId() {
        return this.uint32OldFileId;
    }
}
