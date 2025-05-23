package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

@Deprecated
/* loaded from: classes6.dex */
public class GdtOpenMvPageHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtOpenMvPageHandler";

    @Nullable
    private WeakReference<GdtAdWebPlugin> mWebPlugin;

    @NonNull
    private Map<Long, String> map = new ConcurrentHashMap();

    public long getUUid(long j3, @NonNull String str, @NonNull String str2) {
        return ((((j3 ^ (j3 >>> 32)) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        int i3;
        String str2;
        int i16;
        GdtMotiveVideoPageData createMVPageData;
        JSONObject jSONObject;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            int i17 = 0;
            try {
                GdtLog.d(TAG, "args = " + strArr[0]);
                jSONObject = new JSONObject(strArr[0]);
                i16 = jSONObject.optInt("orientation");
                try {
                    String optString = jSONObject.optString("adInfo");
                    i17 = jSONObject.optInt(RewardDialogContentViewHolder.Key.REWARD_TIME, 0);
                    adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(optString)));
                } catch (Throwable th5) {
                    th = th5;
                    adInfo = null;
                }
            } catch (Throwable th6) {
                th = th6;
                adInfo = null;
                i3 = 0;
            }
            try {
                str2 = jSONObject.optString("rewardText");
            } catch (Throwable th7) {
                th = th7;
                int i18 = i17;
                i17 = i16;
                i3 = i18;
                QLog.e(TAG, 1, "GdtOpenMvPageHandler e2", th);
                str2 = "";
                int i19 = i17;
                i17 = i3;
                i16 = i19;
                createMVPageData = GdtUtil.createMVPageData(adInfo, GdtUtil.adapterToAndroidScreenOrientation(i16));
                if (createMVPageData != null) {
                }
                AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) gdtAdWebPlugin.getActivity(), true, "openMotiveVideoAd", gdtAdWebPlugin.getCurrentUrl(), (Ad) new GdtAd(adInfo));
                return true;
            }
            createMVPageData = GdtUtil.createMVPageData(adInfo, GdtUtil.adapterToAndroidScreenOrientation(i16));
            if (createMVPageData != null) {
                this.map.put(Long.valueOf(getUUid(createMVPageData.adId, createMVPageData.url, createMVPageData.adsContent)), str);
                this.mWebPlugin = new WeakReference<>(gdtAdWebPlugin);
                String stringExtra = activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID);
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = activity.getIntent().getStringExtra("big_brother_source_key");
                }
                TextUtils.isEmpty(stringExtra);
                createMVPageData.refId = stringExtra;
                if (i17 > 0) {
                    createMVPageData.setVideoCountDown(i17);
                }
                if (!TextUtils.isEmpty(str2)) {
                    createMVPageData.setRewardText(str2);
                }
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.buildForJsBridge(gdtAdWebPlugin.getActivity(), createMVPageData, null));
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) gdtAdWebPlugin.getActivity(), true, "openMotiveVideoAd", gdtAdWebPlugin.getCurrentUrl(), (Ad) new GdtAd(adInfo));
            return true;
        }
        GdtLog.e(TAG, "GdtOpenMvPageHandler error");
        return true;
    }

    public void sendResult2Web(@Nullable GdtMotiveVideoPageData gdtMotiveVideoPageData, String str, String str2, String str3) {
        String str4;
        GdtAdWebPlugin gdtAdWebPlugin;
        if (gdtMotiveVideoPageData != null && (str4 = this.map.get(Long.valueOf(getUUid(gdtMotiveVideoPageData.adId, gdtMotiveVideoPageData.url, gdtMotiveVideoPageData.adsContent)))) != null) {
            this.map.remove(gdtMotiveVideoPageData);
            WeakReference<GdtAdWebPlugin> weakReference = this.mWebPlugin;
            if (weakReference != null && (gdtAdWebPlugin = weakReference.get()) != null) {
                QLog.w(TAG, 1, "callResultFunc2Web elapsedtime " + str + " totaltime " + str2 + " isEnd " + str3);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("elapsedTime", str);
                    jSONObject.put("totalTime", str2);
                    jSONObject.put("isEnd", str3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gdtAdWebPlugin.callJs(str4, jSONObject.toString());
            }
        }
    }
}
