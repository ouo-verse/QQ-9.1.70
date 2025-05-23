package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildSetting;

/* loaded from: classes17.dex */
public class GGProJoinGuildSetting implements IGProJoinGuildSetting {
    public final GProJoinGuildSetting mInfo;

    public GGProJoinGuildSetting(GProJoinGuildSetting gProJoinGuildSetting) {
        this.mInfo = gProJoinGuildSetting;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting
    public IGProJoinGuildChoiceQuestion getChoiceQuestion() {
        return new GGProJoinGuildChoiceQuestion(this.mInfo.getChoiceQuestion());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting
    public int getOptionType() {
        return this.mInfo.getOptionType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting
    public IGProJoinGuildWordQuestion getWordQuestion() {
        return new GGProJoinGuildWordQuestion(this.mInfo.getWordQuestion());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting
    public String toString() {
        return this.mInfo.toString();
    }
}
