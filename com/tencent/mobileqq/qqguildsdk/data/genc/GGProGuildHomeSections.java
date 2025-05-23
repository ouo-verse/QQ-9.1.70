package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelInfoList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildHomeSections;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildHomeSections implements IGProGuildHomeSections {
    public final GProGuildHomeSections mInfo;

    public GGProGuildHomeSections(GProGuildHomeSections gProGuildHomeSections) {
        this.mInfo = gProGuildHomeSections;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildHomeSections
    public ArrayList<IGProCategoryChannelInfoList> getCommonCategories() {
        ArrayList<GProCategoryChannelInfoList> commonCategories = this.mInfo.getCommonCategories();
        ArrayList<IGProCategoryChannelInfoList> arrayList = new ArrayList<>();
        Iterator<GProCategoryChannelInfoList> it = commonCategories.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProCategoryChannelInfoList(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildHomeSections
    public ArrayList<IGProChannel> getFeedChannels() {
        ArrayList<GProChannel> feedChannels = this.mInfo.getFeedChannels();
        ArrayList<IGProChannel> arrayList = new ArrayList<>();
        Iterator<GProChannel> it = feedChannels.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildHomeSections
    public String toString() {
        return this.mInfo.toString();
    }
}
