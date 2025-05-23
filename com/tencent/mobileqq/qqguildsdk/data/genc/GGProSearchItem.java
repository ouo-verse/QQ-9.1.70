package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchItem;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProSearchItem implements IGProSearchItem {
    public final GProSearchItem mInfo;

    public GGProSearchItem(GProSearchItem gProSearchItem) {
        this.mInfo = gProSearchItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchItem
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchItem
    public ArrayList<String> getGuildLogos() {
        return this.mInfo.getGuildLogos();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchItem
    public String toString() {
        return this.mInfo.toString();
    }
}
