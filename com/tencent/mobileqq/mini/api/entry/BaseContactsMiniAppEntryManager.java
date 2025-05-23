package com.tencent.mobileqq.mini.api.entry;

import android.view.ViewGroup;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface BaseContactsMiniAppEntryManager {
    void onAccountChanged(AppRuntime appRuntime);

    void onPostThemeChanged();

    void setDrawerFrameEvent(int i3);

    void showMicroAppPanel(int i3);

    void shutdownMiniAppPullDownEntry(ViewGroup viewGroup, int i3);
}
