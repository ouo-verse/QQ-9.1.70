package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFriendsRecommendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetFriendsRecommendRsp implements IGProGetFriendsRecommendRsp {
    public final GProGetFriendsRecommendRsp mInfo;

    public GGProGetFriendsRecommendRsp(GProGetFriendsRecommendRsp gProGetFriendsRecommendRsp) {
        this.mInfo = gProGetFriendsRecommendRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetFriendsRecommendRsp
    public IGProMVPExtInfo getExtInfo() {
        return new GGProMVPExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetFriendsRecommendRsp
    public int getFriendType() {
        return this.mInfo.getFriendType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetFriendsRecommendRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetFriendsRecommendRsp
    public ArrayList<IGProRecommendContentItem> getRecommendList() {
        ArrayList<GProRecommendContentItem> recommendList = this.mInfo.getRecommendList();
        ArrayList<IGProRecommendContentItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendContentItem> it = recommendList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendContentItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetFriendsRecommendRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
