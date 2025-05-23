package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAuthControlStatus;

/* loaded from: classes17.dex */
public class GGProAuthControlStatus implements IGProAuthControlStatus {
    public final GProAuthControlStatus mInfo;

    public GGProAuthControlStatus(GProAuthControlStatus gProAuthControlStatus) {
        this.mInfo = gProAuthControlStatus;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAuthControlStatus
    public int getAuthControlKey() {
        return this.mInfo.getAuthControlKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAuthControlStatus
    public int getAuthControlValue() {
        return this.mInfo.getAuthControlValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAuthControlStatus
    public String toString() {
        return this.mInfo.toString();
    }
}
