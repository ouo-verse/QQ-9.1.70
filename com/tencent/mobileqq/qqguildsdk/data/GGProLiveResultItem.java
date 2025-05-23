package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProLiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveResultItem;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProLiveResultItem implements IGProLiveResultItem {
    public final GProLiveResultItem mInfo;

    public GGProLiveResultItem(GProLiveResultItem gProLiveResultItem) {
        this.mInfo = gProLiveResultItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProLiveResultItem
    public IGProLiveRoomInfo getLiveChannel() {
        return new GGProLiveRoomInfo(this.mInfo.getLiveChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProLiveResultItem
    public ArrayList<fe> getMsgAbstracts() {
        ArrayList<MsgAbstract> msgAbstracts = this.mInfo.getMsgAbstracts();
        ArrayList<fe> arrayList = new ArrayList<>();
        Iterator<MsgAbstract> it = msgAbstracts.iterator();
        while (it.hasNext()) {
            arrayList.add(new s(it.next()));
        }
        return arrayList;
    }
}
