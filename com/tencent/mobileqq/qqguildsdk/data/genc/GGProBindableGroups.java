package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindableGroups;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindingGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProBindableGroups implements IGProBindableGroups {
    public final GProBindableGroups mInfo;

    public GGProBindableGroups(GProBindableGroups gProBindableGroups) {
        this.mInfo = gProBindableGroups;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindableGroups
    public int getActiveGroups() {
        return this.mInfo.getActiveGroups();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindableGroups
    public ArrayList<IGProBindingGroup> getGroups() {
        ArrayList<GProBindingGroup> groups = this.mInfo.getGroups();
        ArrayList<IGProBindingGroup> arrayList = new ArrayList<>();
        Iterator<GProBindingGroup> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBindingGroup(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindableGroups
    public String toString() {
        return this.mInfo.toString();
    }
}
