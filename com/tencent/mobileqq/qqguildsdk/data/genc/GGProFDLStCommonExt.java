package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFDLEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFDLStCommonExt;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProFDLStCommonExt implements IGProFDLStCommonExt {
    public final GProFDLStCommonExt mInfo;

    public GGProFDLStCommonExt(GProFDLStCommonExt gProFDLStCommonExt) {
        this.mInfo = gProFDLStCommonExt;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLStCommonExt
    public ArrayList<IGProFDLEntry> getMapInfo() {
        ArrayList<GProFDLEntry> mapInfo = this.mInfo.getMapInfo();
        ArrayList<IGProFDLEntry> arrayList = new ArrayList<>();
        Iterator<GProFDLEntry> it = mapInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProFDLEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLStCommonExt
    public String toString() {
        return this.mInfo.toString();
    }
}
