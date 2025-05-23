package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelInfoList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProCategoryChannelInfoList implements IGProCategoryChannelInfoList {
    public final GProCategoryChannelInfoList mInfo;

    public GGProCategoryChannelInfoList(GProCategoryChannelInfoList gProCategoryChannelInfoList) {
        this.mInfo = gProCategoryChannelInfoList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public String getCategoryAlias() {
        return this.mInfo.getCategoryAlias();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public long getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public int getCategoryType() {
        return this.mInfo.getCategoryType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public ArrayList<IGProChannel> getChannelInfoList() {
        ArrayList<GProChannel> channelInfoList = this.mInfo.getChannelInfoList();
        ArrayList<IGProChannel> arrayList = new ArrayList<>();
        Iterator<GProChannel> it = channelInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public boolean getCloseSwitch() {
        return this.mInfo.getCloseSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public boolean getFolded() {
        return this.mInfo.getFolded();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    /* renamed from: getName */
    public String getCategoryName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public IGProNavigationV2Info getNavigation() {
        return new GGProNavigationV2Info(this.mInfo.getNavigation());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public int getUrlType() {
        return this.mInfo.getUrlType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList
    public String toString() {
        return this.mInfo.toString();
    }
}
