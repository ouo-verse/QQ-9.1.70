package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProQuickJoinBlock;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQuickJoinCycleStatusTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQuickJoinItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProQuickJoinBlock implements IGProQuickJoinBlock {
    public final GProQuickJoinBlock mInfo;

    public GGProQuickJoinBlock(GProQuickJoinBlock gProQuickJoinBlock) {
        this.mInfo = gProQuickJoinBlock;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinBlock
    public ArrayList<String> getMembersAvatar() {
        return this.mInfo.getMembersAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinBlock
    public ArrayList<IGProQuickJoinItem> getQuickJoinItems() {
        ArrayList<GProQuickJoinItem> quickJoinItems = this.mInfo.getQuickJoinItems();
        ArrayList<IGProQuickJoinItem> arrayList = new ArrayList<>();
        Iterator<GProQuickJoinItem> it = quickJoinItems.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProQuickJoinItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinBlock
    public ArrayList<IGProQuickJoinCycleStatusTag> getStatusTag() {
        ArrayList<GProQuickJoinCycleStatusTag> statusTag = this.mInfo.getStatusTag();
        ArrayList<IGProQuickJoinCycleStatusTag> arrayList = new ArrayList<>();
        Iterator<GProQuickJoinCycleStatusTag> it = statusTag.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProQuickJoinCycleStatusTag(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQuickJoinBlock
    public String toString() {
        return this.mInfo.toString();
    }
}
