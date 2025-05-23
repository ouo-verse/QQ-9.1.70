package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProFeedGuildInfo implements IGProFeedGuildInfo {
    public final GProFeedGuildInfo mInfo;

    public GGProFeedGuildInfo(GProFeedGuildInfo gProFeedGuildInfo) {
        this.mInfo = gProFeedGuildInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo
    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo
    public ArrayList<IGProMedalInfo> getMedals() {
        ArrayList<GProMedalInfo> medals = this.mInfo.getMedals();
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = medals.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
