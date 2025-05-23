package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildChoiceQuestionItem;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProJoinGuildChoiceQuestionItem implements IGProJoinGuildChoiceQuestionItem {
    public final GProJoinGuildChoiceQuestionItem mInfo;

    public GGProJoinGuildChoiceQuestionItem(GProJoinGuildChoiceQuestionItem gProJoinGuildChoiceQuestionItem) {
        this.mInfo = gProJoinGuildChoiceQuestionItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestionItem
    public ArrayList<String> getAnswers() {
        return this.mInfo.getAnswers();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestionItem
    public String getCorrectAnswer() {
        return this.mInfo.getCorrectAnswer();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestionItem
    public String getQuestion() {
        return this.mInfo.getQuestion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestionItem
    public String toString() {
        return this.mInfo.toString();
    }
}
