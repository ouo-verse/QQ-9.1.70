package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildWordQuestion;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildWordQuestionItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProJoinGuildWordQuestion implements IGProJoinGuildWordQuestion {
    public final GProJoinGuildWordQuestion mInfo;

    public GGProJoinGuildWordQuestion(GProJoinGuildWordQuestion gProJoinGuildWordQuestion) {
        this.mInfo = gProJoinGuildWordQuestion;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildWordQuestion
    public ArrayList<IGProJoinGuildWordQuestionItem> getItems() {
        ArrayList<GProJoinGuildWordQuestionItem> items = this.mInfo.getItems();
        ArrayList<IGProJoinGuildWordQuestionItem> arrayList = new ArrayList<>();
        Iterator<GProJoinGuildWordQuestionItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProJoinGuildWordQuestionItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildWordQuestion
    public String toString() {
        return this.mInfo.toString();
    }
}
