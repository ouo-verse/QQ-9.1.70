package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationTab;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTabContentCommonRsp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProTabContentCommonRsp implements IGProTabContentCommonRsp {
    public final GProTabContentCommonRsp mInfo;

    public GGProTabContentCommonRsp(GProTabContentCommonRsp gProTabContentCommonRsp) {
        this.mInfo = gProTabContentCommonRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp
    public byte[] getBackendCookies() {
        return this.mInfo.getBackendCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp
    public IGProMVPExtInfo getExtInfo() {
        return new GGProMVPExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp
    public ArrayList<IGProRecommendContentItem> getRecommendList() {
        ArrayList<GProRecommendContentItem> recommendList = this.mInfo.getRecommendList();
        ArrayList<IGProRecommendContentItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendContentItem> it = recommendList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendContentItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp
    public ArrayList<IGProNavigationTab> getTabList() {
        ArrayList<GProNavigationTab> tabList = this.mInfo.getTabList();
        ArrayList<IGProNavigationTab> arrayList = new ArrayList<>();
        Iterator<GProNavigationTab> it = tabList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProNavigationTab(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
