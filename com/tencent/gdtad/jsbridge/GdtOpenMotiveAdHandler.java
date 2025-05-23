package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtMotiveAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtOpenMotiveAdHandler implements GdtJsCallHandler {

    /* renamed from: a, reason: collision with root package name */
    JSONObject f109248a;

    /* renamed from: b, reason: collision with root package name */
    JSONObject f109249b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private WeakReference<GdtAdWebPlugin> f109250c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Map<String, String> f109251d = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class GdtJSReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GdtOpenMotiveAdHandler> f109254d;

        public GdtJSReceiver(WeakReference<GdtOpenMotiveAdHandler> weakReference, Handler handler) {
            super(handler);
            this.f109254d = weakReference;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            GdtOpenMotiveAdHandler gdtOpenMotiveAdHandler;
            super.onReceiveResult(i3, bundle);
            WeakReference<GdtOpenMotiveAdHandler> weakReference = this.f109254d;
            if (weakReference != null) {
                gdtOpenMotiveAdHandler = weakReference.get();
            } else {
                gdtOpenMotiveAdHandler = null;
            }
            if (gdtOpenMotiveAdHandler == null) {
                GdtLog.i("GdtOpenMotiveAdHandler", "[onReceiveResult] handler is null");
                return;
            }
            GdtLog.i("GdtOpenMotiveAdHandler", "[onReceiveResult] resultCode = " + i3 + " resultData = " + bundle);
            if (bundle != null && i3 == -1) {
                String string = bundle.getString("arg_callback", "");
                if (TextUtils.isEmpty(string)) {
                    GdtLog.e("GdtOpenMotiveAdHandler", "[onReceiveResult] callbackId is empty");
                    return;
                }
                boolean z16 = bundle.getBoolean("profitable_flag", false);
                Object obj = JSONObject.NULL;
                if (obj.equals(gdtOpenMotiveAdHandler.f109248a) || obj.equals(gdtOpenMotiveAdHandler.f109249b)) {
                    gdtOpenMotiveAdHandler.e(string, z16);
                    return;
                }
                if (!z16) {
                    gdtOpenMotiveAdHandler.f(string, 0, false, false, "");
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("profitable", true);
                bundle2.putInt("elapsedTime", bundle.getInt("profitable_flag", 0));
                bundle2.putString("arg_callback", bundle.getString("arg_callback", ""));
                ((IGdtMotiveAPI) QRoute.api(IGdtMotiveAPI.class)).scheduleH5ReportRewardAdNew(gdtOpenMotiveAdHandler, bundle2, gdtOpenMotiveAdHandler.f109248a, gdtOpenMotiveAdHandler.f109249b);
                gdtOpenMotiveAdHandler.f109248a = null;
                gdtOpenMotiveAdHandler.f109249b = null;
                return;
            }
            GdtLog.e("GdtOpenMotiveAdHandler", "[onReceiveResult] handle result error, promise resultData = " + bundle + ",resultCode" + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements AdSafeUtil.SafeRunnable<qq_ad_get.QQAdGetRsp.AdInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f109255a;

        a(JSONObject jSONObject) {
            this.f109255a = jSONObject;
        }

        @Override // com.tencent.ad.tangram.util.AdSafeUtil.SafeRunnable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public qq_ad_get.QQAdGetRsp.AdInfo run() {
            return (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), this.f109255a));
        }
    }

    private void b(GdtAdWebPlugin gdtAdWebPlugin, String str) {
        if (gdtAdWebPlugin != null && str != null) {
            JSONObject newJSONObject = AdJSONUtil.newJSONObject();
            AdJSONUtil.put(newJSONObject, "code", -1);
            gdtAdWebPlugin.callJs(str, AdJSONUtil.toString(newJSONObject));
            return;
        }
        GdtLog.e("GdtOpenMotiveAdHandler", "[callError2Web] error");
    }

    private Boolean d(GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        boolean z16 = true;
        if (GdtUtil.parseDataType(gdtMotiveVideoPageData) != 1) {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z16) {
        GdtAdWebPlugin gdtAdWebPlugin;
        String remove = this.f109251d.remove(str);
        if (remove == null) {
            GdtLog.e("GdtOpenMotiveAdHandler", "[sendResult2Web] resultFunc is invalid");
            return;
        }
        WeakReference<GdtAdWebPlugin> weakReference = this.f109250c;
        if (weakReference != null) {
            gdtAdWebPlugin = weakReference.get();
        } else {
            gdtAdWebPlugin = null;
        }
        if (gdtAdWebPlugin == null) {
            GdtLog.e("GdtOpenMotiveAdHandler", "[sendResult2Web] webPlugin is invalid");
            return;
        }
        GdtLog.i("GdtOpenMotiveAdHandler", "[sendResult2Web] isRewarded " + z16);
        JSONObject newJSONObject = AdJSONUtil.newJSONObject();
        AdJSONUtil.put(newJSONObject, "code", 0);
        AdJSONUtil.put(newJSONObject, "isRewarded", Boolean.valueOf(z16));
        gdtAdWebPlugin.callJs(remove, AdJSONUtil.toString(newJSONObject));
    }

    public String c(long j3, @NonNull String str) {
        return String.valueOf(((j3 ^ (j3 >>> 32)) * 31) + str.hashCode());
    }

    public void f(String str, int i3, boolean z16, boolean z17, String str2) {
        GdtAdWebPlugin gdtAdWebPlugin;
        String remove = this.f109251d.remove(str);
        if (remove == null) {
            GdtLog.e("GdtOpenMotiveAdHandler", "[sendRewardReportResult2Web] resultFunc is invalid");
            return;
        }
        WeakReference<GdtAdWebPlugin> weakReference = this.f109250c;
        if (weakReference != null) {
            gdtAdWebPlugin = weakReference.get();
        } else {
            gdtAdWebPlugin = null;
        }
        if (gdtAdWebPlugin == null) {
            GdtLog.e("GdtOpenMotiveAdHandler", "[sendRewardReportResult2Web] webPlugin is invalid");
            return;
        }
        GdtLog.i("GdtOpenMotiveAdHandler", "[sendRewardReportResult2Web] rewardReportSuccess " + z16);
        JSONObject newJSONObject = AdJSONUtil.newJSONObject();
        AdJSONUtil.put(newJSONObject, "ret", Integer.valueOf(i3));
        AdJSONUtil.put(newJSONObject, "isRewarded", Boolean.valueOf(z17));
        AdJSONUtil.put(newJSONObject, "isRewardedSuccess", Boolean.valueOf(z16));
        AdJSONUtil.put(newJSONObject, "busi_buffer", str2);
        gdtAdWebPlugin.callJs(remove, AdJSONUtil.toString(newJSONObject));
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable final GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        String str2 = null;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null && str != null) {
            if (strArr != null && strArr.length != 0) {
                GdtLog.d("GdtOpenMotiveAdHandler", "args = " + strArr[0]);
                JSONObject newJSONObject = AdJSONUtil.newJSONObject(strArr[0]);
                int optInt = AdJSONUtil.optInt(newJSONObject, "orientation", 0);
                JSONObject newJSONObject2 = AdJSONUtil.newJSONObject(AdJSONUtil.optString(newJSONObject, "adInfo", ""));
                if (newJSONObject != null) {
                    this.f109248a = (JSONObject) newJSONObject2.remove("reward_report_info");
                    this.f109249b = (JSONObject) newJSONObject2.remove("reward_rsp_info");
                }
                qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) AdSafeUtil.safeRun(new a(newJSONObject2), "GdtOpenMotiveAdHandler", "adInfo error");
                final GdtMotiveVideoPageData createMVPageData = GdtUtil.createMVPageData(adInfo, GdtUtil.adapterToAndroidScreenOrientation(optInt));
                if (createMVPageData == null) {
                    GdtLog.e("GdtOpenMotiveAdHandler", "[handleJsCallRequest] data is invalid");
                    b(gdtAdWebPlugin, str);
                    return false;
                }
                if (d(createMVPageData).booleanValue()) {
                    createMVPageData.motiveBrowsingKey = "gdt_open_motive_browsing_ad";
                }
                String c16 = c(createMVPageData.adId, createMVPageData.adsContent);
                this.f109251d.put(c16, str);
                createMVPageData.setAsyncCallbackId(c16);
                this.f109250c = new WeakReference<>(gdtAdWebPlugin);
                if (activity.getIntent() != null) {
                    str2 = activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = activity.getIntent().getStringExtra("big_brother_source_key");
                }
                TextUtils.isEmpty(str2);
                createMVPageData.refId = str2;
                createMVPageData.supportOpenMotiveAd = true;
                AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.jsbridge.GdtOpenMotiveAdHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.buildForJsBridge(gdtAdWebPlugin.getActivity(), createMVPageData, new GdtJSReceiver(new WeakReference(GdtOpenMotiveAdHandler.this), new Handler(Looper.getMainLooper()))));
                    }
                }, "GdtOpenMotiveAdHandler", "[startGdtMotiveVideo]");
                AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) gdtAdWebPlugin.getActivity(), true, "openMotiveAd", gdtAdWebPlugin.getCurrentUrl(), (Ad) new GdtAd(adInfo));
                return true;
            }
            GdtLog.e("GdtOpenMotiveAdHandler", "[handleJsCallRequest] params error");
            b(gdtAdWebPlugin, str);
            return false;
        }
        GdtLog.e("GdtOpenMotiveAdHandler", "[handleJsCallRequest] error");
        return false;
    }
}
