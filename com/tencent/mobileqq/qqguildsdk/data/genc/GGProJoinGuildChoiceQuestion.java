package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildChoiceQuestion;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildChoiceQuestionItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProJoinGuildChoiceQuestion implements IGProJoinGuildChoiceQuestion {
    public final GProJoinGuildChoiceQuestion mInfo;

    public GGProJoinGuildChoiceQuestion(GProJoinGuildChoiceQuestion gProJoinGuildChoiceQuestion) {
        this.mInfo = gProJoinGuildChoiceQuestion;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestion
    public ArrayList<IGProJoinGuildChoiceQuestionItem> getItems() {
        ArrayList<GProJoinGuildChoiceQuestionItem> items = this.mInfo.getItems();
        ArrayList<IGProJoinGuildChoiceQuestionItem> arrayList = new ArrayList<>();
        Iterator<GProJoinGuildChoiceQuestionItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProJoinGuildChoiceQuestionItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestion
    public int getNeedAnswerNum() {
        return this.mInfo.getNeedAnswerNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestion
    public int getPassCorrectNum() {
        return this.mInfo.getPassCorrectNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestion
    public String toString() {
        return this.mInfo.toString();
    }
}
