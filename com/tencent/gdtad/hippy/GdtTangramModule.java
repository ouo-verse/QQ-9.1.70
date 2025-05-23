package com.tencent.gdtad.hippy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.wechat.AdWXCanvas;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.gdtad.util.p;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.util.AppSetting;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@HippyNativeModule(name = GdtTangramModule.TAG)
/* loaded from: classes6.dex */
public final class GdtTangramModule extends HippyNativeModuleBase {
    private static final String KEY_CODE = "code";
    private static final String TAG = "GdtTangramModule";

    @NonNull
    private static ConcurrentHashMap<String, GdtTangramModuleAdLoaderListener> sLoadAdRequestMap = new ConcurrentHashMap<>();

    @NonNull
    public static ConcurrentHashMap<String, Promise> sHippyAsyncCallbackHashMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class GdtMotiveHippyReceiver extends ResultReceiver {
        public GdtMotiveHippyReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i(GdtTangramModule.TAG, 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            if (bundle != null && i3 == -1) {
                String string = bundle.getString("arg_callback", "");
                if (TextUtils.isEmpty(string)) {
                    AdLog.e(GdtTangramModule.TAG, "[onReceiveResult] callbackId is empty");
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("isRewarded", Boolean.valueOf(bundle.getBoolean("profitable_flag", false)));
                hashMap.put("code", 0);
                GdtTangramModule.onHippyAsyncCallback(string, hashMap);
                return;
            }
            AdLog.e(GdtTangramModule.TAG, "[onReceiveResult] handle result error, promise resultData = " + bundle + ",resultCode" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class GdtTangramModuleAdLoaderListener implements GdtAdLoader.Listener {
        Promise promise;

        GdtTangramModuleAdLoaderListener(Promise promise) {
            this.promise = promise;
        }

        @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
        public void onResponse(@Nullable GdtAdLoader gdtAdLoader) {
            if (this.promise == null) {
                return;
            }
            HippyMap hippyMap = new HippyMap();
            if (gdtAdLoader != null && gdtAdLoader.getSession() != null) {
                Object pbToJson = GdtJsonPbUtil.pbToJson(gdtAdLoader.getSession().request);
                Object pbToJson2 = GdtJsonPbUtil.pbToJson(gdtAdLoader.getSession().response);
                AdLog.i(GdtTangramModule.TAG, "loadAd onResponse");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Const.BUNDLE_KEY_REQUEST, pbToJson);
                    jSONObject.put("response", pbToJson2);
                } catch (JSONException e16) {
                    GdtLog.e(GdtTangramModule.TAG, "onResponse", e16);
                }
                try {
                    if (pbToJson2 == null) {
                        hippyMap.pushInt("code", 999);
                    } else {
                        hippyMap.pushInt("code", jSONObject.getJSONObject("response").getInt("ret"));
                        hippyMap.pushString("gdt_cookie", jSONObject.getJSONObject("response").getString("gdt_cookie"));
                        JSONArray jSONArray = jSONObject.getJSONObject("response").getJSONArray("pos_ads_info");
                        HippyArray hippyArray = new HippyArray();
                        hippyArray.pushJSONArray(jSONArray);
                        hippyMap.pushArray("pos_ads_info", hippyArray);
                    }
                    this.promise.resolve(hippyMap);
                    GdtTangramModule.removeRequest(this.promise.getCallId());
                    return;
                } catch (Throwable th5) {
                    AdLog.e(GdtTangramModule.TAG, "onResponse:", th5);
                    this.promise.resolve(null);
                    GdtTangramModule.removeRequest(this.promise.getCallId());
                    return;
                }
            }
            this.promise.resolve(null);
            GdtTangramModule.removeRequest(this.promise.getCallId());
        }
    }

    public GdtTangramModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private Activity getActivity() {
        boolean z16;
        Activity activityV2;
        try {
            z16 = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).isHippyModuleV2Enabled();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getActivity]", th5);
            z16 = true;
        }
        if (z16) {
            activityV2 = getActivityV1();
        } else {
            activityV2 = getActivityV2();
        }
        QLog.i(TAG, 1, "[getActivity] isHippyModuleV2Enabled:" + z16 + " activity:" + activityV2);
        return activityV2;
    }

    private Activity getActivityV1() {
        return QBaseActivity.sTopActivity;
    }

    private Activity getActivityV2() {
        HippyEngineContext hippyEngineContext = this.mContext;
        if (hippyEngineContext == null) {
            QLog.e(TAG, 1, "[getActivityV2] error, mContext is null");
            return null;
        }
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(hippyEngineContext.getEngineId());
        if (engineInstance == null) {
            QLog.e(TAG, 1, "[getActivityV2] error, engine is null");
            return null;
        }
        Activity activity = engineInstance.getActivity();
        if (activity == null) {
            QLog.e(TAG, 1, "[getActivityV2] error, activity is null");
            return null;
        }
        return activity;
    }

    public static void onHippyAsyncCallback(@NonNull String str, @Nullable HashMap<String, Object> hashMap) {
        Promise remove = sHippyAsyncCallbackHashMap.remove(str);
        if (remove == null) {
            QLog.i(TAG, 1, "onHippyAsyncCallback callback is null");
            return;
        }
        HippyMap hippyMap = new HippyMap();
        if (hashMap != null) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                if (entry != null) {
                    hippyMap.pushObject(entry.getKey(), entry.getValue());
                }
            }
        }
        remove.resolve(hippyMap);
    }

    public static void removeRequest(@NonNull String str) {
        ConcurrentHashMap<String, GdtTangramModuleAdLoaderListener> concurrentHashMap = sLoadAdRequestMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str);
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        ConcurrentHashMap<String, GdtTangramModuleAdLoaderListener> concurrentHashMap = sLoadAdRequestMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, Promise> concurrentHashMap2 = sHippyAsyncCallbackHashMap;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    @HippyMethod(name = "getDeviceInfo")
    public void getDeviceInfo(@NonNull HippyMap hippyMap, @Nullable Promise promise) {
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
        AdLog.i(TAG, "getDeviceInfo");
        HippyMap hippyMap2 = new HippyMap();
        try {
            JSONObject jSONObject = hippyMap.toJSONObject();
            GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
            params.supportOpenMotiveAd = AdJSONUtil.optBoolean(jSONObject, "supportOpenMotiveAd", false);
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), params);
            if (create != null) {
                deviceInfo = create.deviceInfo;
            } else {
                deviceInfo = null;
            }
            Object pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo);
            if (pbToJson == null) {
                hippyMap2.pushInt("code", 999);
            } else {
                hippyMap2.pushInt("code", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("deviceInfo", pbToJson);
                hippyMap2.pushJSONObject(jSONObject2);
            }
        } catch (Throwable th5) {
            AdLog.e(TAG, "getDeviceInfo error ", th5);
            hippyMap2.pushInt("code", 999);
        }
        if (promise != null) {
            promise.resolve(hippyMap2);
        } else {
            AdLog.e(TAG, "getDeviceInfo promise is null");
        }
        AdAnalysisHelperForUtil.reportForHippyAPIInvoked(getActivity(), true, "getDeviceInfo", "UNKNOWN");
    }

    @HippyMethod(name = "handleClick")
    public void handleClick(@Nullable HippyMap hippyMap, @Nullable Promise promise) {
        String str;
        AdLog.i(TAG, "handleClick");
        String str2 = "UNKNOWN";
        if (hippyMap == null) {
            AdLog.e(TAG, "handleClick params invalid");
        } else {
            GdtHandler.Params params = new GdtHandler.Params();
            JSONObject jSONObject = hippyMap.toJSONObject();
            if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
                if (!GdtHandler.fillOptions(params, jSONObject.toString())) {
                    AdLog.e(TAG, "handleClick fillOptions failed");
                } else {
                    params.processId = MobileQQ.sProcessId;
                    params.activity = new WeakReference<>(getActivity());
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("options");
                        if (!TextUtils.isEmpty(jSONObject2.getString("refSid"))) {
                            str = jSONObject2.getString("refSid");
                        } else {
                            str = null;
                        }
                        Bundle bundle = new Bundle();
                        params.extra = bundle;
                        bundle.putString(LaunchParam.KEY_REF_ID, str);
                        GdtAd gdtAd = params.f108486ad;
                        if (gdtAd != null) {
                            str2 = gdtAd.getPosId();
                        }
                    } catch (Throwable th5) {
                        AdLog.e(TAG, "handleClick", th5);
                    }
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                }
            } else {
                AdLog.e(TAG, "handleClick paramJSON invalid");
            }
        }
        if (promise != null) {
            promise.resolve(null);
        } else {
            AdLog.e(TAG, "handleClick promise is null");
        }
        AdAnalysisHelperForUtil.reportForHippyAPIInvoked(getActivity(), false, "handleClick", str2);
    }

    @HippyMethod(name = "loadAd")
    public void loadAd(@Nullable HippyMap hippyMap, @NonNull Promise promise) {
        String str;
        AdLog.i(TAG, "loadAd");
        HippyMap hippyMap2 = new HippyMap();
        if (promise == null) {
            return;
        }
        if (hippyMap != null && hippyMap.toJSONObject() != null && !JSONObject.NULL.equals(hippyMap.toJSONObject())) {
            JSONObject jSONObject = hippyMap.toJSONObject();
            if (jSONObject != null) {
                AdLog.i(TAG, jSONObject.toString());
            }
            GdtTangramModuleAdLoaderListener gdtTangramModuleAdLoaderListener = new GdtTangramModuleAdLoaderListener(promise);
            sLoadAdRequestMap.put(promise.getCallId(), gdtTangramModuleAdLoaderListener);
            GdtAdLoader.Session session = new GdtAdLoader.Session();
            session.request = (qq_ad_get.QQAdGet) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGet(), jSONObject);
            session.supportOpenMotiveAd = AdJSONUtil.optBoolean(jSONObject, "supportOpenMotiveAd", false);
            new GdtAdLoader(session, new WeakReference(gdtTangramModuleAdLoaderListener)).load(new WeakReference<>(BaseApplication.getContext()));
            qq_ad_get.QQAdGet qQAdGet = session.request;
            if (qQAdGet != null && !qQAdGet.position_info.isEmpty() && session.request.position_info.get(0) != null) {
                str = session.request.position_info.get(0).pos_id.get();
            } else {
                str = "UNKNOWN";
            }
            AdAnalysisHelperForUtil.reportForHippyAPIInvoked(getActivity(), true, "loadAd", str);
            return;
        }
        hippyMap2.pushInt("code", 997);
        promise.resolve(hippyMap2);
    }

    @HippyMethod(name = "openMotiveAd")
    public void openMotiveAd(@NonNull HippyMap hippyMap, @Nullable Promise promise) {
        String str;
        JSONObject jSONObject;
        Intent intent;
        AdLog.i(TAG, "openMotiveAd");
        if (promise == null) {
            AdLog.e(TAG, "openMotiveAd promise is null");
        }
        HippyMap hippyMap2 = new HippyMap();
        int i3 = -1;
        try {
            int i16 = hippyMap.getInt("orientation");
            HippyMap map = hippyMap.getMap("adInfo");
            String str2 = null;
            if (map != null) {
                str = map.toJSONObject().toString();
            } else {
                str = null;
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
            if (str != null) {
                jSONObject = new JSONObject(str);
            } else {
                jSONObject = new JSONObject();
            }
            GdtMotiveVideoPageData createMVPageData = GdtUtil.createMVPageData((qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(adInfo, jSONObject), GdtUtil.adapterToAndroidScreenOrientation(i16));
            if (createMVPageData != null) {
                createMVPageData.supportOpenMotiveAd = true;
                Activity activity = getActivity();
                if (activity != null) {
                    intent = activity.getIntent();
                } else {
                    intent = null;
                }
                if (intent != null) {
                    str2 = intent.getStringExtra(LaunchParam.KEY_REF_ID);
                }
                if (TextUtils.isEmpty(str2) && intent != null) {
                    str2 = intent.getStringExtra("big_brother_source_key");
                }
                createMVPageData.refId = str2;
                if (TextUtils.isEmpty(str2) && AppSetting.isDebugVersion()) {
                    createMVPageData.refId = "biz_src_jc_version";
                }
                if (promise != null) {
                    createMVPageData.setAsyncCallbackId(promise.getCallId());
                    sHippyAsyncCallbackHashMap.put(promise.getCallId(), promise);
                }
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, createMVPageData, new GdtMotiveHippyReceiver(new Handler(Looper.getMainLooper()))));
                i3 = 0;
            }
        } catch (Throwable th5) {
            AdLog.e(TAG, "openMotiveAd error ", th5);
        }
        if (i3 != 0) {
            hippyMap2.pushInt("code", i3);
            if (promise != null) {
                promise.reject(hippyMap2);
            }
        }
        AdAnalysisHelperForUtil.reportForHippyAPIInvoked(getActivity(), false, "openMotiveAd", "UNKNOWN");
    }

    @HippyMethod(name = "openMotiveVideoAd")
    @Deprecated
    public void openMotiveVideoAd(@NonNull HippyMap hippyMap, @Nullable Promise promise) {
        String str;
        JSONObject jSONObject;
        Intent intent;
        AdLog.i(TAG, "openMotiveVideoAd");
        if (promise == null) {
            AdLog.e(TAG, "openMotiveVideoAd promise is null");
        }
        HippyMap hippyMap2 = new HippyMap();
        try {
            int i3 = hippyMap.getInt("orientation");
            int i16 = hippyMap.getInt(RewardDialogContentViewHolder.Key.REWARD_TIME);
            HippyMap map = hippyMap.getMap("adInfo");
            if (map != null) {
                str = map.toJSONObject().toString();
            } else {
                str = null;
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
            if (str != null) {
                jSONObject = new JSONObject(str);
            } else {
                jSONObject = new JSONObject();
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(adInfo, jSONObject);
            String string = hippyMap.getString("rewardText");
            GdtMotiveVideoPageData createMVPageData = GdtUtil.createMVPageData(adInfo2, GdtUtil.adapterToAndroidScreenOrientation(i3));
            if (createMVPageData != null) {
                Activity activity = getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    String stringExtra = intent.getStringExtra(LaunchParam.KEY_REF_ID);
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = intent.getStringExtra("big_brother_source_key");
                    }
                    createMVPageData.refId = stringExtra;
                }
                if (TextUtils.isEmpty(createMVPageData.refId) && AppSetting.isDebugVersion()) {
                    createMVPageData.refId = "biz_src_jc_version";
                }
                if (i16 > 0) {
                    createMVPageData.setVideoCountDown(i16);
                }
                if (!TextUtils.isEmpty(string)) {
                    createMVPageData.setRewardText(string);
                }
                if (promise != null) {
                    createMVPageData.setAsyncCallbackId(promise.getCallId());
                    sHippyAsyncCallbackHashMap.put(promise.getCallId(), promise);
                }
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, createMVPageData));
            }
            AdAnalysisHelperForUtil.reportForHippyAPIInvoked(getActivity(), false, "openMotiveVideoAd", "UNKNOWN");
        } catch (Throwable th5) {
            AdLog.e(TAG, "openMotiveVideoAd error ", th5);
            hippyMap2.pushInt("code", 998);
            if (promise != null) {
                promise.reject(hippyMap2);
            }
        }
    }

    @HippyMethod(name = "openVideoCelling")
    public void openVideoCelling(@NonNull HippyMap hippyMap, @Nullable Promise promise) {
        JSONObject jSONObject;
        AdError adError;
        HippyMap hippyMap2 = new HippyMap();
        Activity activity = getActivity();
        try {
            jSONObject = hippyMap.toJSONObject().getJSONObject("options");
        } catch (Throwable th5) {
            AdLog.e(TAG, "[openVideoCelling] error ", th5);
            jSONObject = null;
        }
        AdVideoCeiling.Params b16 = p.b(jSONObject, activity);
        String optString = AdJSONUtil.optString(jSONObject, "posId", "");
        if (!TextUtils.isEmpty(optString) && b16.isValid()) {
            adError = AdVideoCeiling.getInstance().show(b16);
        } else {
            adError = new AdError(4);
        }
        if (adError == null) {
            adError = new AdError(0);
        }
        AdLog.i(TAG, "[openVideoCelling] error code:" + adError.getErrorCode());
        if (promise != null) {
            if (adError.isSuccess()) {
                hippyMap2.pushInt("code", 0);
                promise.resolve(hippyMap2);
            } else {
                hippyMap2.pushInt("code", -1);
                promise.reject(hippyMap2);
            }
        } else {
            AdLog.e(TAG, "[openVideoCelling] promise is null");
        }
        AdAnalysisHelperForUtil.reportForHippyAPIInvoked(activity, false, "openVideoCelling", optString);
    }

    @HippyMethod(name = "openWeChatCanvas")
    public void openWeChatCanvas(@NonNull HippyMap hippyMap, @Nullable Promise promise) {
        AdError adError;
        AdLog.i(TAG, "[openWeChatCanvas]");
        HippyMap hippyMap2 = new HippyMap();
        Activity activity = getActivity();
        String str = "UNKNOWN";
        try {
            JSONObject jSONObject = hippyMap.toJSONObject().getJSONObject("options");
            AdWXCanvas.Params params = new AdWXCanvas.Params();
            params.channelAppID = jSONObject.getString("wechatAppId");
            params.extInfo = jSONObject.getString("wechatExtInfo");
            params.context = new WeakReference<>(activity);
            str = jSONObject.getString("posId");
            if (!TextUtils.isEmpty(str)) {
                adError = AdWXCanvas.getInstance().show(params);
            } else {
                adError = new AdError(4);
            }
        } catch (Throwable th5) {
            AdLog.e(TAG, "getDeviceInfo error ", th5);
            adError = new AdError(4);
        }
        if (adError == null) {
            adError = new AdError(1);
        }
        hippyMap2.pushInt("error_code", adError.getErrorCode());
        if (promise != null) {
            promise.resolve(hippyMap2);
        } else {
            AdLog.e(TAG, "[openWeChatCanvas] promise is null");
        }
        AdAnalysisHelperForUtil.reportForHippyAPIInvoked(activity, false, "openWeChatCanvas", str);
    }

    @HippyMethod(name = "openWeChatMiniApp")
    public void openWeChatMiniApp(@NonNull HippyMap hippyMap, @Nullable Promise promise) {
        AdError adError;
        AdLog.i(TAG, "[openWeChatMiniApp]");
        HippyMap hippyMap2 = new HippyMap();
        String str = "UNKNOWN";
        try {
            JSONObject jSONObject = hippyMap.toJSONObject().getJSONObject("options");
            AdWXMINIProgram.Params params = new AdWXMINIProgram.Params();
            params.channelAppID = jSONObject.getString("wechatAppId");
            params.token = jSONObject.optString("wechatToken");
            params.userName = jSONObject.getString("wechatUserName");
            params.path = jSONObject.optString("wechatPath");
            params.traceData = jSONObject.optString("wechatAdTraceData");
            params.weakActivity = new WeakReference<>(getActivity());
            str = jSONObject.getString("posId");
            if (!TextUtils.isEmpty(str)) {
                adError = AdWXMINIProgram.getInstance().show(params);
            } else {
                adError = new AdError(4);
            }
        } catch (Throwable th5) {
            AdLog.e(TAG, "getDeviceInfo error ", th5);
            adError = new AdError(4);
        }
        if (adError == null) {
            adError = new AdError(1);
        }
        hippyMap2.pushInt("error_code", adError.getErrorCode());
        if (promise != null) {
            promise.resolve(hippyMap2);
        } else {
            AdLog.e(TAG, "[openWeChatMiniApp] promise is null");
        }
        AdAnalysisHelperForUtil.reportForHippyAPIInvoked(getActivity(), false, "openWeChatMiniApp", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    @HippyMethod(name = "preLoadAfterAdLoaded")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preLoadAfterAdLoaded(@Nullable HippyMap hippyMap, @Nullable Promise promise) {
        GdtAd gdtAd;
        String str;
        AdLog.i(TAG, "preLoadAfterAdLoaded");
        if (hippyMap != null) {
            try {
                gdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), hippyMap.toJSONObject().getJSONObject("adInfo")));
                if (gdtAd.isValid()) {
                    GdtPreLoader.c().h(gdtAd);
                }
            } catch (Throwable th5) {
                AdLog.e(TAG, "preLoadAfterAdLoaded error,", th5);
            }
            if (promise == null) {
                promise.resolve(null);
            } else {
                AdLog.e(TAG, "preLoadAfterAdLoaded promise is null");
            }
            Activity activity = getActivity();
            if (gdtAd == null) {
                str = gdtAd.getPosId();
            } else {
                str = "UNKNOWN";
            }
            AdAnalysisHelperForUtil.reportForHippyAPIInvoked(activity, true, "preLoadAfterAdLoaded", str);
        }
        gdtAd = null;
        if (promise == null) {
        }
        Activity activity2 = getActivity();
        if (gdtAd == null) {
        }
        AdAnalysisHelperForUtil.reportForHippyAPIInvoked(activity2, true, "preLoadAfterAdLoaded", str);
    }
}
