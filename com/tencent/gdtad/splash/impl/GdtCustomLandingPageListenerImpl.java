package com.tencent.gdtad.splash.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.tg.TangramReportUtil;
import com.qq.e.tg.splash.TGSplashDelayWebViewUtil;
import com.tencent.gdtad.splash.IGdtSplashQQLiteAPI;
import com.tencent.gdtad.splash.v;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class GdtCustomLandingPageListenerImpl implements CustomLandingPageListener {

    /* loaded from: classes6.dex */
    class a implements v {
        a() {
        }

        @Override // com.tencent.gdtad.splash.v
        public void a(int i3, int i16, Intent intent) {
            QLog.i("GdtCustomLandingPageListenerImpl", 1, "[jumpToActivityAndRegisterCallback] called " + i3 + " " + i3);
            if (i3 == 20240423) {
                TGSplashDelayWebViewUtil.onActivityResultCallBack();
            }
        }
    }

    private void a(JSONObject jSONObject, int i3) {
        final ConcurrentHashMap concurrentHashMap;
        if (!JSONUtilStub.notNull(jSONObject)) {
            QLog.e("GdtCustomLandingPageListenerImpl", 1, "reportLandingPageStart params error");
            return;
        }
        try {
            concurrentHashMap = new ConcurrentHashMap();
            try {
                concurrentHashMap.put("pid", "9065538021425253");
                concurrentHashMap.put("aid", JSONUtilStub.optString(jSONObject, "cl", ""));
                concurrentHashMap.put("traceid", JSONUtilStub.optString(jSONObject, "traceid", ""));
                concurrentHashMap.put("wv_progress", 2);
                concurrentHashMap.put("lp_type", 1);
                concurrentHashMap.put("act_code", Integer.valueOf(i3));
            } catch (Throwable unused) {
                QLog.e("GdtCustomLandingPageListenerImpl", 1, "reportLandingPageStart params error");
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.gdtad.splash.impl.GdtCustomLandingPageListenerImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.i("GdtCustomLandingPageListenerImpl", 1, "[reportLandingPageStart] bizMap:" + concurrentHashMap);
                        TangramReportUtil.report(BaseApplication.getContext(), "1109803375", 4003001, 0, concurrentHashMap, null);
                    }
                }, 128, null, false);
            }
        } catch (Throwable unused2) {
            concurrentHashMap = null;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.gdtad.splash.impl.GdtCustomLandingPageListenerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("GdtCustomLandingPageListenerImpl", 1, "[reportLandingPageStart] bizMap:" + concurrentHashMap);
                TangramReportUtil.report(BaseApplication.getContext(), "1109803375", 4003001, 0, concurrentHashMap, null);
            }
        }, 128, null, false);
    }

    private static void b(JSONObject jSONObject, Intent intent) {
        if (!JSONUtilStub.notNull(jSONObject)) {
            QLog.e("GdtCustomLandingPageListenerImpl", 1, "[setTGMarketInfoToIntent] adJson is null");
            return;
        }
        if (intent == null) {
            QLog.e("GdtCustomLandingPageListenerImpl", 1, "[setTGMarketInfoToIntent] intent is null");
            return;
        }
        if (!JSONUtilStub.notNull(JSONUtilStub.optJSONObject(jSONObject, "jump_android_market_info"))) {
            QLog.e("GdtCustomLandingPageListenerImpl", 1, "[setTGMarketInfoToIntent] marketInfoObject is null");
            return;
        }
        String optString = JSONUtilStub.optString(jSONObject, "market_deep_link", "");
        if (TextUtils.isEmpty(optString)) {
            QLog.e("GdtCustomLandingPageListenerImpl", 1, "[setTGMarketInfoToIntent] deepLink is empty");
            return;
        }
        JSONArray optJSONArray = JSONUtilStub.optJSONArray(jSONObject, "market_package_name");
        if (JSONUtilStub.isJSONArrayEmpty(optJSONArray)) {
            QLog.e("GdtCustomLandingPageListenerImpl", 1, "[setTGMarketInfoToIntent] packageNameArray is empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            String optString2 = JSONUtilStub.optString(optJSONArray, i3);
            if (!TextUtils.isEmpty(optString2)) {
                arrayList.add(optString2);
            }
        }
        intent.putExtra("app_market_deeplink", optString);
        intent.putExtra("app_market_package_name", (String[]) arrayList.toArray(new String[0]));
    }

    @Override // com.qq.e.comm.pi.CustomLandingPageListener
    public boolean jumpToActivityAndRegisterCallback(Context context, Intent intent) {
        QLog.i("GdtCustomLandingPageListenerImpl", 1, "[jumpToActivityAndRegisterCallback] called");
        return ((IGdtSplashQQLiteAPI) QRoute.api(IGdtSplashQQLiteAPI.class)).startActivityForResult(context, 20240423, intent, new a());
    }

    @Override // com.qq.e.comm.pi.CustomLandingPageListener
    public boolean jumpToCustomLandingPage(CustomLandingPageListener.Params params) {
        if (params == null) {
            QLog.e("GdtCustomLandingPageListenerImpl", 1, "[jumpToCustomLandingPage] params is null");
            return false;
        }
        if (params.getWeakContext() != null && params.getWeakContext().get() != null) {
            String landingPageUrl = params.getLandingPageUrl();
            String adData = params.getAdData();
            Bundle bundle = params.getBundle();
            Context context = params.getWeakContext().get();
            QLog.i("GdtCustomLandingPageListenerImpl", 1, "[jumpToCustomLandingPage] landingPageUrl: " + landingPageUrl + "\nadData:" + adData);
            if (TextUtils.isEmpty(landingPageUrl)) {
                QLog.e("GdtCustomLandingPageListenerImpl", 1, "[jumpToCustomLandingPage] landingPageUrl is empty");
                return false;
            }
            JSONObject newJSONObject = JSONUtilStub.newJSONObject(adData);
            if (!JSONUtilStub.notNull(newJSONObject)) {
                QLog.e("GdtCustomLandingPageListenerImpl", 1, "[jumpToCustomLandingPage] adJson is null");
                return false;
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", landingPageUrl);
            intent.putExtra("WebReport_TRACE_ID", JSONUtilStub.optString(newJSONObject, "traceid", ""));
            intent.putExtra("WebReport_AD_ID", JSONUtilStub.optString(newJSONObject, "cl", ""));
            intent.putExtra("WebReport_ACTION_URL", JSONUtilStub.optString(newJSONObject, "landing_page_report_url", ""));
            intent.putExtra("WebReport_CLICK_TIME", System.currentTimeMillis());
            intent.putExtra("WebReport_IS_H5", true);
            intent.putExtra("WebReport_POS_ID", "9065538021425253");
            intent.putExtra("WebReport_ACT_CODE", params.getActCode());
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            if (params.needNewTask()) {
                intent.addFlags(268435456);
            }
            if (bundle != null && !bundle.isEmpty()) {
                QLog.i("GdtCustomLandingPageListenerImpl", 1, "[jumpToCustomLandingPage] set bundle");
                intent.putExtras(bundle);
            }
            b(newJSONObject, intent);
            a(newJSONObject, params.getActCode());
            try {
                context.startActivity(intent);
            } catch (Throwable th5) {
                QLog.e("GdtCustomLandingPageListenerImpl", 1, "[jumpToCustomLandingPage] startActivity error", th5);
            }
            return true;
        }
        QLog.e("GdtCustomLandingPageListenerImpl", 1, "[jumpToCustomLandingPage] context is null");
        return false;
    }
}
