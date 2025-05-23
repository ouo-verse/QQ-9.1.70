package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StModuleInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DesktopBannerModuleInfo extends DesktopItemInfo {
    public COMM.StCommonExt extInfo;
    public String title;

    public DesktopBannerModuleInfo(INTERFACE$StModuleInfo iNTERFACE$StModuleInfo) {
        if (iNTERFACE$StModuleInfo == null) {
            return;
        }
        this.extInfo = iNTERFACE$StModuleInfo.extInfo.get();
        this.mModuleType = iNTERFACE$StModuleInfo.moduleType.get();
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 19;
    }
}
