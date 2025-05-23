package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildNavigationInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationV2Info;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildNavigationInfo implements IGProGuildNavigationInfo {
    public final GProGuildNavigationInfo mInfo;

    public GGProGuildNavigationInfo(GProGuildNavigationInfo gProGuildNavigationInfo) {
        this.mInfo = gProGuildNavigationInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public int getAuditStatus() {
        return this.mInfo.getAuditStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public int getCompatibleFlag() {
        return this.mInfo.getCompatibleFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public String getIconSelectorColor() {
        return this.mInfo.getIconSelectorColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public String getIconSelectorUrl() {
        return this.mInfo.getIconSelectorUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public ArrayList<IGProNavigationV2Info> getNavigationList() {
        ArrayList<GProNavigationV2Info> navigationList = this.mInfo.getNavigationList();
        ArrayList<IGProNavigationV2Info> arrayList = new ArrayList<>();
        Iterator<GProNavigationV2Info> it = navigationList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProNavigationV2Info(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public long getVersion() {
        return this.mInfo.getVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
