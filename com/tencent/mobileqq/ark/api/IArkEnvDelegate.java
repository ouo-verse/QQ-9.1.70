package com.tencent.mobileqq.ark.api;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkEnvDelegate extends QRouteApi {
    String getAppConfigForCurrentTheme();

    float getDisplayDensity();

    DisplayMetrics getDisplayMetrics();

    String getLibJSCPath();

    void notifyJscLoaded();

    boolean shouldCheckURLDomain();

    void stopArkSilkAudio();
}
