package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskCardLineText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskCardText;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildTaskCardLineText implements IGProGuildTaskCardLineText {
    public final GProGuildTaskCardLineText mInfo;

    public GGProGuildTaskCardLineText(GProGuildTaskCardLineText gProGuildTaskCardLineText) {
        this.mInfo = gProGuildTaskCardLineText;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardLineText
    public ArrayList<IGProGuildTaskCardText> getLineTexts() {
        ArrayList<GProGuildTaskCardText> lineTexts = this.mInfo.getLineTexts();
        ArrayList<IGProGuildTaskCardText> arrayList = new ArrayList<>();
        Iterator<GProGuildTaskCardText> it = lineTexts.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildTaskCardText(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardLineText
    public String toString() {
        return this.mInfo.toString();
    }
}
