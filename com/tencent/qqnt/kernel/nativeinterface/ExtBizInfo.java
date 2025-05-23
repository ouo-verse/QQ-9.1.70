package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ExtBizInfo {
    public int busiType;
    public PicExtBizInfo picExtBizInfo = new PicExtBizInfo();
    public VideoExtBizInfo videoExtBizInfo = new VideoExtBizInfo();
    public byte[] bizTransInfo = new byte[0];

    public byte[] getBizTransInfo() {
        return this.bizTransInfo;
    }

    public int getBusiType() {
        return this.busiType;
    }

    public PicExtBizInfo getPicExtBizInfo() {
        return this.picExtBizInfo;
    }

    public VideoExtBizInfo getVideoExtBizInfo() {
        return this.videoExtBizInfo;
    }
}
