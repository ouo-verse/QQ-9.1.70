package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProConditionalTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProItemHeadInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProItemHeadInfo implements IGProItemHeadInfo {
    public final GProItemHeadInfo mInfo;

    public GGProItemHeadInfo(GProItemHeadInfo gProItemHeadInfo) {
        this.mInfo = gProItemHeadInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemHeadInfo
    public String getOnlineNums() {
        return this.mInfo.getOnlineNums();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemHeadInfo
    public ArrayList<IGProConditionalTag> getTags() {
        ArrayList<GProConditionalTag> tags = this.mInfo.getTags();
        ArrayList<IGProConditionalTag> arrayList = new ArrayList<>();
        Iterator<GProConditionalTag> it = tags.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProConditionalTag(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemHeadInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
