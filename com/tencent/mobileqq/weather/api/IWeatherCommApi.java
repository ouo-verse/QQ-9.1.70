package com.tencent.mobileqq.weather.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.weather.util.a;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeatherCommApi extends QRouteApi {
    void enterWeatherModule();

    void exitWeatherModule();

    String getGdtDeviceInfoBase64();

    Class getParserClass();

    boolean hasCoarseLocationPermission(Context context, String str);

    boolean hasLocationPermission(Context context, String str);

    boolean isWeatherArkPageUrl(String str);

    boolean isWeatherPA(String str);

    void openWeatherByScheme(Context context, String str);

    void openWeatherMainPage(Context context, HashMap<String, String> hashMap);

    void openWeatherWebForHippy(Context context, String str);

    void openWeatherWebPage(Context context, String str, String str2);

    void preloadWebProcessAsync(int i3);

    boolean startNewWeatherWebPageActivity(Context context, AppInterface appInterface);

    boolean startNewWeatherWebPageActivity(Context context, AppInterface appInterface, a aVar);

    void startNewWeatherWebPageActivityByFollowState(Context context, AppInterface appInterface, int i3, String str);

    boolean startNewWeatherWebPageActivityBySearch(Context context, AppInterface appInterface);

    void startWeatherDebugFragment(Activity activity);

    void startWeatherWebPageActivity(Context context, AppInterface appInterface, int i3, String str);

    String transformUrlToScheme(String str);

    void translate(AppInterface appInterface, int i3, int i16, int i17);
}
