package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProNavigationList implements IGProNavigationList {
    public final GProNavigationList mInfo;

    public GGProNavigationList(GProNavigationList gProNavigationList) {
        this.mInfo = gProNavigationList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationList
    public ArrayList<IGProNavigationData> getDataList() {
        ArrayList<GProNavigationData> dataList = this.mInfo.getDataList();
        ArrayList<IGProNavigationData> arrayList = new ArrayList<>();
        Iterator<GProNavigationData> it = dataList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProNavigationData(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationList
    public String getNavigationVersion() {
        return this.mInfo.getNavigationVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationList
    public String toString() {
        return this.mInfo.toString();
    }
}
