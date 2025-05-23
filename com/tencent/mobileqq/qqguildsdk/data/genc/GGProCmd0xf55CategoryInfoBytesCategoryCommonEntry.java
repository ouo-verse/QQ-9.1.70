package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf55CategoryInfoBytesCategoryCommonEntry;

/* loaded from: classes17.dex */
public class GGProCmd0xf55CategoryInfoBytesCategoryCommonEntry implements IGProCmd0xf55CategoryInfoBytesCategoryCommonEntry {
    public final GProCmd0xf55CategoryInfoBytesCategoryCommonEntry mInfo;

    public GGProCmd0xf55CategoryInfoBytesCategoryCommonEntry(GProCmd0xf55CategoryInfoBytesCategoryCommonEntry gProCmd0xf55CategoryInfoBytesCategoryCommonEntry) {
        this.mInfo = gProCmd0xf55CategoryInfoBytesCategoryCommonEntry;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfoBytesCategoryCommonEntry
    public int getKey() {
        return this.mInfo.getKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfoBytesCategoryCommonEntry
    public byte[] getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfoBytesCategoryCommonEntry
    public String toString() {
        return this.mInfo.toString();
    }
}
