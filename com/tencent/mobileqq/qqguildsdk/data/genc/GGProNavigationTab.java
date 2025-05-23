package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationTab;

/* loaded from: classes17.dex */
public class GGProNavigationTab implements IGProNavigationTab {
    public final GProNavigationTab mInfo;

    public GGProNavigationTab(GProNavigationTab gProNavigationTab) {
        this.mInfo = gProNavigationTab;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public int getSubType() {
        return this.mInfo.getSubType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public int getTabId() {
        return this.mInfo.getTabId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public int getTabType() {
        return this.mInfo.getTabType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab
    public String toString() {
        return this.mInfo.toString();
    }
}
