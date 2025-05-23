package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAllGuildTaskCardRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskCard;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProAllGuildTaskCardRsp implements IGProAllGuildTaskCardRsp {
    public final GProAllGuildTaskCardRsp mInfo;

    public GGProAllGuildTaskCardRsp(GProAllGuildTaskCardRsp gProAllGuildTaskCardRsp) {
        this.mInfo = gProAllGuildTaskCardRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAllGuildTaskCardRsp
    public ArrayList<IGProGuildTaskCard> getTaskCards() {
        ArrayList<GProGuildTaskCard> taskCards = this.mInfo.getTaskCards();
        ArrayList<IGProGuildTaskCard> arrayList = new ArrayList<>();
        Iterator<GProGuildTaskCard> it = taskCards.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildTaskCard(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAllGuildTaskCardRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
