package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProEncryptTextRsp;

/* loaded from: classes17.dex */
public class GGProEncryptTextRsp implements IGProEncryptTextRsp {
    public final GProEncryptTextRsp mInfo;

    public GGProEncryptTextRsp(GProEncryptTextRsp gProEncryptTextRsp) {
        this.mInfo = gProEncryptTextRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEncryptTextRsp
    public String getEncryptedText() {
        return this.mInfo.getEncryptedText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEncryptTextRsp
    public boolean getIsPassed() {
        return this.mInfo.getIsPassed();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEncryptTextRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
