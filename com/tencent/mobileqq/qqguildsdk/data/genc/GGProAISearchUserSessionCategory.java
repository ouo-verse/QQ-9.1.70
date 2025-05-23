package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchSession;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchUserSessionCategory;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProAISearchUserSessionCategory implements IGProAISearchUserSessionCategory {
    public final GProAISearchUserSessionCategory mInfo;

    public GGProAISearchUserSessionCategory(GProAISearchUserSessionCategory gProAISearchUserSessionCategory) {
        this.mInfo = gProAISearchUserSessionCategory;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchUserSessionCategory
    public String getCategoryName() {
        return this.mInfo.getCategoryName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchUserSessionCategory
    public ArrayList<IGProAISearchSession> getSessionList() {
        ArrayList<GProAISearchSession> sessionList = this.mInfo.getSessionList();
        ArrayList<IGProAISearchSession> arrayList = new ArrayList<>();
        Iterator<GProAISearchSession> it = sessionList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAISearchSession(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchUserSessionCategory
    public String toString() {
        return this.mInfo.toString();
    }
}
