package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DesktopAppModuleInfo extends DesktopItemInfo {
    private static final String TAG = "DesktopAppModuleInfo";
    public MiniAppInfo appStoreInfo;
    public String moduleTitle;

    public DesktopAppModuleInfo(int i3) {
        this.mModuleType = i3;
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 1;
    }

    public String toString() {
        return this.moduleTitle + "_" + this.mModuleType;
    }

    public DesktopAppModuleInfo(int i3, String str) {
        this.mModuleType = i3;
        this.moduleTitle = str;
    }

    public DesktopAppModuleInfo(int i3, String str, INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo) {
        this.mModuleType = i3;
        this.moduleTitle = str;
        if (iNTERFACE$StUserAppInfo != null) {
            MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StUserAppInfo);
            this.appStoreInfo = from;
            if (from != null) {
                QLog.d(TAG, 1, "create DesktopAppModuleInfo. appStoreInfo: id = " + this.appStoreInfo.appId + ", name = " + this.appStoreInfo.name + ", title: " + str);
                return;
            }
            QLog.d(TAG, 1, "create DesktopAppModuleInfo. appStoreInfo is null. title: " + str);
            return;
        }
        QLog.d(TAG, 1, "create DesktopAppModuleInfo. appInfo is null. title: " + str);
    }
}
