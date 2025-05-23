package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFDLEntry;

/* loaded from: classes17.dex */
public class GGProFDLEntry implements IGProFDLEntry {
    public final GProFDLEntry mInfo;

    public GGProFDLEntry(GProFDLEntry gProFDLEntry) {
        this.mInfo = gProFDLEntry;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLEntry
    public String getKey() {
        return this.mInfo.getKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLEntry
    public String getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLEntry
    public String toString() {
        return this.mInfo.toString();
    }
}
