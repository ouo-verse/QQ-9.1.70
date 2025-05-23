package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgInfoBody {
    public boolean fileExist;
    public IndexNode indexNode = new IndexNode();
    public PictureInfo pictureInfo = new PictureInfo();
    public byte[] hashSum = new byte[0];

    public boolean getFileExist() {
        return this.fileExist;
    }

    public byte[] getHashSum() {
        return this.hashSum;
    }

    public IndexNode getIndexNode() {
        return this.indexNode;
    }

    public PictureInfo getPictureInfo() {
        return this.pictureInfo;
    }
}
