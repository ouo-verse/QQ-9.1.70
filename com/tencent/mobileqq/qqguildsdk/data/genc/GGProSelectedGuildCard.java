package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildLabel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSelectedGuildCard;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProSelectedGuildCard implements IGProSelectedGuildCard {
    public final GProSelectedGuildCard mInfo;

    public GGProSelectedGuildCard(GProSelectedGuildCard gProSelectedGuildCard) {
        this.mInfo = gProSelectedGuildCard;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public String getGuildAvatar() {
        return this.mInfo.getGuildAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public ArrayList<IGProMedalInfo> getMedals() {
        ArrayList<GProMedalInfo> medals = this.mInfo.getMedals();
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = medals.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public ArrayList<IGProGuildLabel> getTagList() {
        ArrayList<GProGuildLabel> tagList = this.mInfo.getTagList();
        ArrayList<IGProGuildLabel> arrayList = new ArrayList<>();
        Iterator<GProGuildLabel> it = tagList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public String toString() {
        return this.mInfo.toString();
    }
}
