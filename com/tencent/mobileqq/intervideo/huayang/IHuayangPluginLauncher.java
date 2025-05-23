package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IHuayangPluginLauncher extends QRouteApi {
    public static final String TAG = "IHuayangPluginLauncher";

    /* loaded from: classes15.dex */
    public interface a {
        void a(boolean z16, Throwable th5);

        void onProgressUpdate(int i3);
    }

    void addLauncherListener(a aVar);

    IHuayangPluginLauncher getInstance(Context context, Object obj);

    boolean isStartPluginCalled();

    void launchPlugin(String str, boolean z16, boolean z17, IVPluginInfo iVPluginInfo, String str2, String str3);

    void removeLauncherListener(a aVar);
}
