package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProKVPair;

/* loaded from: classes17.dex */
public class GGProKVPair implements IGProKVPair {
    public final GProKVPair mInfo;

    public GGProKVPair(GProKVPair gProKVPair) {
        this.mInfo = gProKVPair;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProKVPair
    public String getKey() {
        return this.mInfo.getKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProKVPair
    public byte[] getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProKVPair
    public String toString() {
        return this.mInfo.toString();
    }
}
