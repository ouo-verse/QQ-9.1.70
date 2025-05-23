package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBannerInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPageHeadInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProPageHeadInfo implements IGProPageHeadInfo {
    public final GProPageHeadInfo mInfo;

    public GGProPageHeadInfo(GProPageHeadInfo gProPageHeadInfo) {
        this.mInfo = gProPageHeadInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public ArrayList<IGProBannerInfo> getBannerInfos() {
        ArrayList<GProBannerInfo> bannerInfos = this.mInfo.getBannerInfos();
        ArrayList<IGProBannerInfo> arrayList = new ArrayList<>();
        Iterator<GProBannerInfo> it = bannerInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBannerInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public String getDayBannerUrl() {
        return this.mInfo.getDayBannerUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public boolean getHasSearch() {
        return this.mInfo.getHasSearch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public String getHeadText() {
        return this.mInfo.getHeadText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public String getNightBannerUrl() {
        return this.mInfo.getNightBannerUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public long getPollingDuration() {
        return this.mInfo.getPollingDuration();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public String getValueAddedBannerUrl() {
        return this.mInfo.getValueAddedBannerUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPageHeadInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
