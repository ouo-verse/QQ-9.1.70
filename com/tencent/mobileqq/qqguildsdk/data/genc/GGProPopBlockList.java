package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBlockBaseInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPopBlockList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProPopBlockList implements IGProPopBlockList {
    public final GProPopBlockList mInfo;

    public GGProPopBlockList(GProPopBlockList gProPopBlockList) {
        this.mInfo = gProPopBlockList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPopBlockList
    public String getBlockName() {
        return this.mInfo.getBlockName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPopBlockList
    public ArrayList<IGProBlockBaseInfo> getList() {
        ArrayList<GProBlockBaseInfo> list = this.mInfo.getList();
        ArrayList<IGProBlockBaseInfo> arrayList = new ArrayList<>();
        Iterator<GProBlockBaseInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBlockBaseInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPopBlockList
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPopBlockList
    public String toString() {
        return this.mInfo.toString();
    }
}
