package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf55CategoryInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf55CategoryInfoBytesCategoryCommonEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProCmd0xf55CategoryInfo implements IGProCmd0xf55CategoryInfo {
    public final GProCmd0xf55CategoryInfo mInfo;

    public GGProCmd0xf55CategoryInfo(GProCmd0xf55CategoryInfo gProCmd0xf55CategoryInfo) {
        this.mInfo = gProCmd0xf55CategoryInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public ArrayList<IGProCmd0xf55CategoryInfoBytesCategoryCommonEntry> getBytesCategoryCommonList() {
        ArrayList<GProCmd0xf55CategoryInfoBytesCategoryCommonEntry> bytesCategoryCommonList = this.mInfo.getBytesCategoryCommonList();
        ArrayList<IGProCmd0xf55CategoryInfoBytesCategoryCommonEntry> arrayList = new ArrayList<>();
        Iterator<GProCmd0xf55CategoryInfoBytesCategoryCommonEntry> it = bytesCategoryCommonList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProCmd0xf55CategoryInfoBytesCategoryCommonEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public String getCategoryAlias() {
        return this.mInfo.getCategoryAlias();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public long getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public int getCategoryIndex() {
        return this.mInfo.getCategoryIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public String getCategoryName() {
        return this.mInfo.getCategoryName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public int getCategoryType() {
        return this.mInfo.getCategoryType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public IGProChannelCategoryInfo getChannelCategoryInfo() {
        return new GGProChannelCategoryInfo(this.mInfo.getChannelCategoryInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public int getCloseSwitch() {
        return this.mInfo.getCloseSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf55CategoryInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
