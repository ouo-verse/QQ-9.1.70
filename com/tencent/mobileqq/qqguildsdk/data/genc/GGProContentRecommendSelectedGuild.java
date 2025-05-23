package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendSelectedGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSelectedGuildCard;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProContentRecommendSelectedGuild implements IGProContentRecommendSelectedGuild {
    public final GProContentRecommendSelectedGuild mInfo;

    public GGProContentRecommendSelectedGuild(GProContentRecommendSelectedGuild gProContentRecommendSelectedGuild) {
        this.mInfo = gProContentRecommendSelectedGuild;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendSelectedGuild
    public ArrayList<IGProSelectedGuildCard> getSelectedGuilds() {
        ArrayList<GProSelectedGuildCard> selectedGuilds = this.mInfo.getSelectedGuilds();
        ArrayList<IGProSelectedGuildCard> arrayList = new ArrayList<>();
        Iterator<GProSelectedGuildCard> it = selectedGuilds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProSelectedGuildCard(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendSelectedGuild
    public String toString() {
        return this.mInfo.toString();
    }
}
