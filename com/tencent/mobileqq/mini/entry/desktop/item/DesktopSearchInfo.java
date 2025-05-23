package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DesktopSearchInfo extends DesktopItemInfo {
    public boolean isSpringFestivalMode = false;
    public List<String> keyword;
    public MiniAppInfo mAppInfo;

    public DesktopSearchInfo(MiniAppInfo miniAppInfo, List<String> list, int i3) {
        this.mAppInfo = miniAppInfo;
        this.keyword = list;
        this.mModuleType = i3;
        this.dragEnable = false;
        this.dropEnable = false;
        this.deleteEnable = false;
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 5;
    }

    public String toString() {
        MiniAppInfo miniAppInfo = this.mAppInfo;
        if (miniAppInfo != null) {
            return miniAppInfo.name;
        }
        return "";
    }
}
