package com.tencent.mobileqq.qqlivehall.iv.api.hippy.module;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;
import com.tencent.timi.game.api.cookie.CookieDataCallback;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategyApi;
import com.tencent.timi.game.api.cookie.QQLiveCookieStrategyType;
import com.tencent.timi.game.api.strategy.IPlayerStrategy;
import com.tencent.timi.game.jump.api.IQQLiveDefinitionApi;
import ft3.c;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@HippyNativeModule(name = VasLiveHippyDataModule.TAG)
/* loaded from: classes17.dex */
public class VasLiveHippyDataModule extends QQBaseModule {
    private static final int CODE_APP_INTERFACE_IS_NULL = 1;
    private static final int CODE_EXCEPTION = 3;
    private static final int CODE_INIT_APP_INTERFACE_IS_NULL = 2;
    private static final int CODE_INIT_CONTEXT_IS_NULL = 5;
    private static final int CODE_INIT_EXCEPTION = 4;
    private static final int CODE_NOT_LOGIN = 6;
    private static final String EVENT_GET_DEFINITION_INFO = "ev_qq_live_hall_get_definition_info";
    private static final String EVENT_GET_NETWORK_INFO = "ev_qq_live_hall_get_network_info";
    private static final String EVENT_GET_USER_INFO = "ev_qq_live_hall_get_user_info";
    private static final String EVENT_UPDATE_LOGIN_INFO = "ev_qq_live_hall_update_login_info";
    private static final int RET_CODE_GET_COOKIE_FAILED = 1;
    private static final int RET_CODE_GET_COOKIE_SUCCESS = 0;
    private static final String TAG = "VasLiveHippyDataModule";
    public static final String VALUE_NULL = "null";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements CookieDataCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyMap f274101a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f274102b;

        a(HippyMap hippyMap, Promise promise) {
            this.f274101a = hippyMap;
            this.f274102b = promise;
        }

        private void a(int i3, Map<String, String> map) {
            HippyMap hippyMap = new HippyMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f274101a.pushString(entry.getKey(), entry.getValue());
            }
            hippyMap.pushInt("retCode", i3);
            hippyMap.pushObject("data", this.f274101a);
            this.f274102b.resolve(hippyMap);
            if (QLog.isColorLevel()) {
                QLog.d(VasLiveHippyDataModule.TAG, 2, "getUserInfo, rsp: " + hippyMap.toJSONObject().toString());
            }
            QLog.i(VasLiveHippyDataModule.TAG, 1, "getUserInfo success");
        }

        @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
        public void onFailed(int i3, String str) {
            a(1, new HashMap());
        }

        @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
        public void onSuccess(Map<String, String> map) {
            ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies(map);
            a(0, map);
        }
    }

    public VasLiveHippyDataModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private void addCookies(HippyMap hippyMap, Promise promise, boolean z16) {
        QQLiveCookieStrategyType qQLiveCookieStrategyType;
        if (z16) {
            qQLiveCookieStrategyType = QQLiveCookieStrategyType.FULL_NO_CACHE;
        } else {
            qQLiveCookieStrategyType = QQLiveCookieStrategyType.FULL;
        }
        ((IQQLiveCookieStrategyApi) QRoute.api(IQQLiveCookieStrategyApi.class)).getCookieStrategy(qQLiveCookieStrategyType).buildAsync(new a(hippyMap, promise));
    }

    private void report(String str, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(i3));
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime != null) {
                hashMap.put("uid", waitAppRuntime.getCurrentAccountUin());
            }
            c newReportTask = ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).newReportTask();
            if (newReportTask != null) {
                newReportTask.getData().putAll(hashMap);
                newReportTask.a(str);
                newReportTask.send();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @HippyMethod(name = "enterLivePreparePage")
    public void enterLivePreparePage(HippyMap hippyMap, Promise promise) {
        if (hippyMap == null) {
            QLog.e(TAG, 1, "enterLivePreparePage readableMap == null");
            return;
        }
        String string = hippyMap.getString("source");
        String string2 = hippyMap.getString("type");
        String string3 = hippyMap.getString("back");
        QLog.d(TAG, 1, "enterLivePreparePage... source:" + string + " roomType:" + string2 + " backTo:" + string3);
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(string) && !string.equals("null")) {
            intent.putExtra("source", Integer.parseInt(string));
        }
        if (!TextUtils.isEmpty(string2) && !string2.equals("null")) {
            intent.putExtra("room_type", Integer.parseInt(string2));
        }
        if (!TextUtils.isEmpty(string3) && !string3.equals("null")) {
            intent.putExtra("clear_top", string3);
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterAnchorPrepareFragment(getActivity(), intent);
        } else {
            QLog.d(TAG, 1, "the activity is null or is Destroyed");
        }
    }

    @HippyMethod(name = "getDefinitionInfo")
    public void getDefinitionInfo(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "getDefinitionInfo");
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                promise.reject("appInterface is null");
                report(EVENT_GET_DEFINITION_INFO, 1);
                return;
            }
            if (!waitAppRuntime.isLogin()) {
                QLog.e(TAG, 1, "not login");
                promise.reject("not login");
                report(EVENT_GET_DEFINITION_INFO, 6);
                return;
            }
            String string = hippyMap.getString("roomid");
            HippyMap hippyMap2 = new HippyMap();
            String definitionLevel = ((IQQLiveDefinitionApi) QRoute.api(IQQLiveDefinitionApi.class)).getDefinitionLevel(string);
            QLog.i(TAG, 1, "Hippy\u83b7\u53d6\u6e05\u6670\u5ea6 getDefinitionInfo value:" + definitionLevel);
            hippyMap2.pushString("level", definitionLevel);
            HippyMap hippyMap3 = new HippyMap();
            hippyMap3.pushObject("data", hippyMap2);
            promise.resolve(hippyMap3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            promise.reject("getDefinitionInfo exception:" + th5.getMessage());
            report(EVENT_GET_DEFINITION_INFO, 3);
        }
    }

    @HippyMethod(name = "getUserInfo")
    public void getUserInfo(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "getUserInfo");
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                promise.reject("appInterface is null");
                report(EVENT_GET_USER_INFO, 1);
            } else {
                if (!waitAppRuntime.isLogin()) {
                    QLog.e(TAG, 1, "not login");
                    promise.reject("not login");
                    report(EVENT_GET_USER_INFO, 6);
                    return;
                }
                String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
                HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushString("uin", currentAccountUin);
                hippyMap2.pushString("nick", (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_NICK, ""));
                hippyMap2.pushInt("gender", ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1))).intValue() - 1);
                hippyMap2.pushInt("age", ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_AGE, (Object) (-1))).intValue());
                addCookies(hippyMap2, promise, false);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            promise.reject("getUserInfo exception:" + th5.getMessage());
            report(EVENT_GET_USER_INFO, 3);
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void initialize() {
        QLog.i(TAG, 1, "initialize");
        try {
            ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).init();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            report(EVENT_GET_USER_INFO, 4);
        }
    }

    @HippyMethod(name = "isWeakNetwork")
    public void isWeakNetwork(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "isWeakNetwork");
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                promise.reject("appInterface is null");
                report(EVENT_GET_NETWORK_INFO, 1);
                return;
            }
            if (!peekAppRuntime.isLogin()) {
                QLog.e(TAG, 1, "not login");
                promise.reject("not login");
                report(EVENT_GET_NETWORK_INFO, 6);
                return;
            }
            boolean isWeakNetwork = ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).isWeakNetwork();
            boolean isPreloadEnable = ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).isPreloadEnable();
            QLog.i(TAG, 1, "Hippy\u83b7\u53d6\u7f51\u7edc\u53d8\u5316 isWeakNetwork:" + isWeakNetwork + " isPreloadEnable:" + isPreloadEnable);
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushBoolean("weak_network", isWeakNetwork);
            hippyMap2.pushBoolean("preload_enable", isPreloadEnable);
            HippyMap hippyMap3 = new HippyMap();
            hippyMap3.pushObject("data", hippyMap2);
            promise.resolve(hippyMap3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            promise.reject("isWeakNetwork exception:" + th5.getMessage());
            report(EVENT_GET_NETWORK_INFO, 3);
        }
    }

    @HippyMethod(name = "updateLoginInfo")
    public void updateLoginInfo(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "updateLoginInfo");
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                promise.reject("appInterface is null");
                report(EVENT_UPDATE_LOGIN_INFO, 1);
            } else {
                if (!waitAppRuntime.isLogin()) {
                    QLog.e(TAG, 1, "not login");
                    promise.reject("not login");
                    report(EVENT_UPDATE_LOGIN_INFO, 6);
                    return;
                }
                addCookies(new HippyMap(), promise, true);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            promise.reject("getUserInfo exception:" + th5.getMessage());
            report(EVENT_UPDATE_LOGIN_INFO, 3);
        }
    }
}
