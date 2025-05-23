package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyInterpolatorConfig {
    private static HashMap<String, HippyInterpolator> sPreloadInterpolatorMap;

    static {
        HashMap<String, HippyInterpolator> hashMap = new HashMap<>();
        sPreloadInterpolatorMap = hashMap;
        hashMap.put(HippyQQConstants.ModuleName.QQ_NEARBY, new NearbyInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_GAME_CENTER, new GameCenterInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_MINI_GAME_PUBLICACCOUNT, new MiniGameInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_WEATHER, new WeatherInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNTV2, new QQGameInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNTV3, new QQGameV3Interpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_SPORT, new HealthInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_LIVE_HALL, new QQIvLiveHallInterceptor());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_MINI_GAME_CENTER, new MiniGameCenterInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_ZPLAN_VAS_SMALL_HOME, new ZplanVasSmallHomeInterpolator());
        sPreloadInterpolatorMap.put(HippyQQConstants.ModuleName.QQ_NEWS_PUBLICACCOUNT, new QQNewsInterpolator());
        sPreloadInterpolatorMap.put(((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamBundleName(), new MetaDreamInterpolator());
    }

    public static HippyInterpolator getInterpolator(String str) {
        HippyInterpolator hippyInterpolator = sPreloadInterpolatorMap.get(str);
        if (hippyInterpolator == null) {
            HippyInterpolator hippyInterpolator2 = new HippyInterpolator();
            sPreloadInterpolatorMap.put(str, hippyInterpolator2);
            return hippyInterpolator2;
        }
        return hippyInterpolator;
    }
}
