package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x10b4RspExtendData;

/* loaded from: classes17.dex */
public class GGProCmd0x10b4RspExtendData implements IGProCmd0x10b4RspExtendData {
    public final GProCmd0x10b4RspExtendData mInfo;

    public GGProCmd0x10b4RspExtendData(GProCmd0x10b4RspExtendData gProCmd0x10b4RspExtendData) {
        this.mInfo = gProCmd0x10b4RspExtendData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0x10b4RspExtendData
    public int getCode() {
        return this.mInfo.getCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0x10b4RspExtendData
    public String toString() {
        return this.mInfo.toString();
    }
}
