package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProEntry;

/* loaded from: classes17.dex */
public class GGProEntry implements IGProEntry {
    public final GProEntry mInfo;

    public GGProEntry(GProEntry gProEntry) {
        this.mInfo = gProEntry;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEntry
    public String getKey() {
        return this.mInfo.getKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEntry
    public byte[] getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEntry
    public String toString() {
        return this.mInfo.toString();
    }
}
