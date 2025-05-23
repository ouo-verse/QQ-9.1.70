package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetSessionListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchUserSessionCategory;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProAISearchGetSessionListRsp implements IGProAISearchGetSessionListRsp {
    public final GProAISearchGetSessionListRsp mInfo;

    public GGProAISearchGetSessionListRsp(GProAISearchGetSessionListRsp gProAISearchGetSessionListRsp) {
        this.mInfo = gProAISearchGetSessionListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionListRsp
    public long getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionListRsp
    public boolean getIsFinished() {
        return this.mInfo.getIsFinished();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionListRsp
    public long getTotalCount() {
        return this.mInfo.getTotalCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionListRsp
    public ArrayList<IGProAISearchUserSessionCategory> getUserSessionList() {
        ArrayList<GProAISearchUserSessionCategory> userSessionList = this.mInfo.getUserSessionList();
        ArrayList<IGProAISearchUserSessionCategory> arrayList = new ArrayList<>();
        Iterator<GProAISearchUserSessionCategory> it = userSessionList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAISearchUserSessionCategory(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
