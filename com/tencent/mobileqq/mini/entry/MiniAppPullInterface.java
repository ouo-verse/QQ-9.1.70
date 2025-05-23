package com.tencent.mobileqq.mini.entry;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import eipc.EIPCModule;
import java.util.List;

/* loaded from: classes15.dex */
public interface MiniAppPullInterface {
    List<DesktopChangeListener> getDesktopChangeListeners();

    DesktopItemInfo getMiniAppInfoByDesktopInfoMap(int i3, String str);

    IRefreshStatusListener getMiniRefreshStatusListener();

    void hideMiniAppEntry(int i3);

    void initLater(ViewGroup viewGroup);

    void onAccountChanged();

    boolean onBackPressed();

    void onDestroy();

    void onHeaderShowProgress(float f16);

    void onPostThemeChanged();

    void onResume();

    void onStop();

    void sendStartUpMiniAppDesktopInfo();

    void setMiniAppTransferModuleEvent(String str, Bundle bundle, EIPCModule eIPCModule);
}
