package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GproGetOpenShareInfoRsp;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GGproGetOpenShareInfoRsp implements IGproGetOpenShareInfoRsp {
    public final GproGetOpenShareInfoRsp mInfo;

    public GGproGetOpenShareInfoRsp(GproGetOpenShareInfoRsp gproGetOpenShareInfoRsp) {
        this.mInfo = gproGetOpenShareInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproGetOpenShareInfoRsp
    public String getFileId() {
        return this.mInfo.getFileId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproGetOpenShareInfoRsp
    public String getQueryStr() {
        return this.mInfo.getQueryStr();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproGetOpenShareInfoRsp
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproGetOpenShareInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
