package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildLabel;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProGuildLabel implements IGProGuildLabel {
    public final GProGuildLabel mInfo;

    public GGProGuildLabel(GProGuildLabel gProGuildLabel) {
        this.mInfo = gProGuildLabel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public int getBussiLabelType() {
        return this.mInfo.getBussiLabelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public String getColorToken() {
        return this.mInfo.getColorToken();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public byte[] getLabelName() {
        return this.mInfo.getLabelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public int getLabelType() {
        return this.mInfo.getLabelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public int getLabelValue() {
        return this.mInfo.getLabelValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public String getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public ArrayList<String> getValueList() {
        return this.mInfo.getValueList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public String toString() {
        return this.mInfo.toString();
    }
}
