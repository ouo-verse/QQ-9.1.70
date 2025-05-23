package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendHotLive;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProHotLiveCard;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProContentRecommendHotLive implements IGProContentRecommendHotLive {
    public final GProContentRecommendHotLive mInfo;

    public GGProContentRecommendHotLive(GProContentRecommendHotLive gProContentRecommendHotLive) {
        this.mInfo = gProContentRecommendHotLive;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendHotLive
    public ArrayList<IGProHotLiveCard> getHotLives() {
        ArrayList<GProHotLiveCard> hotLives = this.mInfo.getHotLives();
        ArrayList<IGProHotLiveCard> arrayList = new ArrayList<>();
        Iterator<GProHotLiveCard> it = hotLives.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProHotLiveCard(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendHotLive
    public String toString() {
        return this.mInfo.toString();
    }
}
