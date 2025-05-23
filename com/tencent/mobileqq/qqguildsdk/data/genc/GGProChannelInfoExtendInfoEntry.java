package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelInfoExtendInfoEntry;

/* loaded from: classes17.dex */
public class GGProChannelInfoExtendInfoEntry implements IGProChannelInfoExtendInfoEntry {
    public final GProChannelInfoExtendInfoEntry mInfo;

    public GGProChannelInfoExtendInfoEntry(GProChannelInfoExtendInfoEntry gProChannelInfoExtendInfoEntry) {
        this.mInfo = gProChannelInfoExtendInfoEntry;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelInfoExtendInfoEntry
    public int getKey() {
        return this.mInfo.getKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelInfoExtendInfoEntry
    public byte[] getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelInfoExtendInfoEntry
    public String toString() {
        return this.mInfo.toString();
    }
}
