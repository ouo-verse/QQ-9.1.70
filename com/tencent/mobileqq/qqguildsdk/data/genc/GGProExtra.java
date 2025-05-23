package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProExtra;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTag;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProExtra implements IGProExtra {
    public final GProExtra mInfo;

    public GGProExtra(GProExtra gProExtra) {
        this.mInfo = gProExtra;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra
    public ArrayList<IGProEntry> getBizDataList() {
        ArrayList<GProEntry> bizDataList = this.mInfo.getBizDataList();
        ArrayList<IGProEntry> arrayList = new ArrayList<>();
        Iterator<GProEntry> it = bizDataList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra
    public IGProMVPItemCbData getCallback() {
        return new GGProMVPItemCbData(this.mInfo.getCallback());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra
    public boolean getIsRead() {
        return this.mInfo.getIsRead();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra
    public ArrayList<IGProEntry> getReports() {
        ArrayList<GProEntry> reports = this.mInfo.getReports();
        ArrayList<IGProEntry> arrayList = new ArrayList<>();
        Iterator<GProEntry> it = reports.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra
    public ArrayList<IGProTag> getTags() {
        ArrayList<GProTag> tags = this.mInfo.getTags();
        ArrayList<IGProTag> arrayList = new ArrayList<>();
        Iterator<GProTag> it = tags.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProTag(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra
    public String toString() {
        return this.mInfo.toString();
    }
}
