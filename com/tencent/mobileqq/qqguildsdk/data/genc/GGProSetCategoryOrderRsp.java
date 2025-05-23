package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelIdList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetCategoryOrderRsp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProSetCategoryOrderRsp implements IGProSetCategoryOrderRsp {
    public final GProSetCategoryOrderRsp mInfo;

    public GGProSetCategoryOrderRsp(GProSetCategoryOrderRsp gProSetCategoryOrderRsp) {
        this.mInfo = gProSetCategoryOrderRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSetCategoryOrderRsp
    public ArrayList<IGProCategoryChannelIdList> getCategoryList() {
        ArrayList<GProCategoryChannelIdList> categoryList = this.mInfo.getCategoryList();
        ArrayList<IGProCategoryChannelIdList> arrayList = new ArrayList<>();
        Iterator<GProCategoryChannelIdList> it = categoryList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProCategoryChannelIdList(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSetCategoryOrderRsp
    public IGProCategoryChannelIdList getUncategorizedChannels() {
        return new GGProCategoryChannelIdList(this.mInfo.getUncategorizedChannels());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSetCategoryOrderRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
