package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelPresenceInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelPresenceItemInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProChannelPresenceInfo implements IGProChannelPresenceInfo {
    public final GProChannelPresenceInfo mInfo;

    public GGProChannelPresenceInfo(GProChannelPresenceInfo gProChannelPresenceInfo) {
        this.mInfo = gProChannelPresenceInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceInfo
    public ArrayList<IGProChannelPresenceItemInfo> getItemList() {
        ArrayList<GProChannelPresenceItemInfo> itemList = this.mInfo.getItemList();
        ArrayList<IGProChannelPresenceItemInfo> arrayList = new ArrayList<>();
        Iterator<GProChannelPresenceItemInfo> it = itemList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannelPresenceItemInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceInfo
    public long getPlaySpeed() {
        return this.mInfo.getPlaySpeed();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceInfo
    public int getTemplateId() {
        return this.mInfo.getTemplateId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
