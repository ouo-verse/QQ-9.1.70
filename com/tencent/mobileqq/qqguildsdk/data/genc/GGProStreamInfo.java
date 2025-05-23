package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStreamInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStreamURL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProStreamInfo implements IGProStreamInfo {
    public final GProStreamInfo mInfo;

    public GGProStreamInfo(GProStreamInfo gProStreamInfo) {
        this.mInfo = gProStreamInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStreamInfo
    public int getStreamType() {
        return this.mInfo.getStreamType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStreamInfo
    public ArrayList<IGProStreamURL> getStreamUrlList() {
        ArrayList<GProStreamURL> streamUrlList = this.mInfo.getStreamUrlList();
        ArrayList<IGProStreamURL> arrayList = new ArrayList<>();
        Iterator<GProStreamURL> it = streamUrlList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProStreamURL(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStreamInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
