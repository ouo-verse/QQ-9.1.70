package com.tencent.hippy.qq.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyAccessHelper extends QRouteApi {
    @Deprecated
    boolean checkAndPreloadHippyPage(OpenHippyInfo openHippyInfo);

    void checkAndPreloadRes(String str);

    boolean checkDomainPermission(String str);

    boolean checkUrlPermission(String str);

    void destroyPreloadHippy(OpenHippyInfo openHippyInfo);

    void executeTaskInToolProcess(Intent intent);

    int generateOpenId();

    long getDynamicTabShowTime();

    JSONObject getJSInitData(AppRuntime appRuntime, String str, String str2, String str3, String str4);

    String getOfflineResPath(String str);

    HippyQQPreloadEngine getPreloadedHippyQQEngine(String str, String str2, int i3);

    String getPreloadingStep(String str);

    boolean interceptHttpUrl(Activity activity, String str);

    boolean isAdNeedsPreload(String str, TabPreloadItem.AdType adType);

    void onAppDestroy();

    void onHippyDestroy(OpenHippyInfo openHippyInfo);

    void onOpenHippyStart(OpenHippyInfo openHippyInfo);

    boolean openHippyPage(Context context, OpenHippyInfo openHippyInfo);

    boolean preNodeSnapShot(OpenHippyInfo openHippyInfo);

    void preloadAdHippy(String str, TabPreloadItem.AdType adType);

    boolean preloadHippyPage(OpenHippyInfo openHippyInfo);

    void preloadPSKey(OpenHippyInfo openHippyInfo);

    void startFPSMonitor(Activity activity);

    void stopFPSMonitor(Activity activity);

    JSONObject wrapHashMap(JSONObject jSONObject, HashMap hashMap);
}
