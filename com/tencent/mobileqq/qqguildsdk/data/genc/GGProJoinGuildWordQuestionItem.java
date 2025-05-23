package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildWordQuestionItem;

/* loaded from: classes17.dex */
public class GGProJoinGuildWordQuestionItem implements IGProJoinGuildWordQuestionItem {
    public final GProJoinGuildWordQuestionItem mInfo;

    public GGProJoinGuildWordQuestionItem(GProJoinGuildWordQuestionItem gProJoinGuildWordQuestionItem) {
        this.mInfo = gProJoinGuildWordQuestionItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildWordQuestionItem
    public String getCorrectAnswer() {
        return this.mInfo.getCorrectAnswer();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildWordQuestionItem
    public String getQuestion() {
        return this.mInfo.getQuestion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildWordQuestionItem
    public String toString() {
        return this.mInfo.toString();
    }
}
