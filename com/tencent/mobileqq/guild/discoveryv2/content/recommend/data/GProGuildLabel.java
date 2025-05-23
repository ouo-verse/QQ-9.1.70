package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class GProGuildLabel implements IGProGuildLabel {
    public int bussiLabelType;
    public int labelType;
    public int labelValue;
    public byte[] labelName = new byte[0];
    public String value = "";
    public ArrayList<String> valueList = new ArrayList<>();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public int getBussiLabelType() {
        return this.bussiLabelType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public String getColorToken() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public byte[] getLabelName() {
        return this.labelName;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public int getLabelType() {
        return this.labelType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public int getLabelValue() {
        return this.labelValue;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public String getValue() {
        return this.value;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel
    public ArrayList<String> getValueList() {
        return this.valueList;
    }
}
