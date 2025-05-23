package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class AdProxy {
    public static String KEY_ACCOUNT = "key_account";
    public static String KEY_ADCOUNT = "key_ad_count";
    public static String KEY_AD_TYPE = "key_ad_type";
    public static String KEY_APPID = "key_appid";
    public static String KEY_ENTRY_PATH = "key_entry_path";
    public static String KEY_GDT_COOKIE = "key_gdt_cookie";
    public static String KEY_MODE = "key_mode";
    public static String KEY_ORIENTATION = "key_orientation";
    public static String KEY_POSID = "key_pos_id";
    public static String KEY_REFER = "key_refer";
    public static String KEY_REPORT_DATA = "key_report_data";
    public static String KEY_SHARE_RATE = "key_share_rate";
    public static String KEY_VIA = "key_via";

    /* loaded from: classes23.dex */
    public abstract class AbsBoxAdView {
        public AbsBoxAdView() {
        }

        public abstract void destroy();

        public abstract void loadAD();

        public abstract void show();
    }

    /* loaded from: classes23.dex */
    public abstract class AbsRewardVideoAdView {
        public static final String REALTIME_TAG = "RealTimeRewardedVideoAdPlugin";
        public long loadTime = 0;
        public long loadInterval = Long.MAX_VALUE;

        public AbsRewardVideoAdView() {
        }

        public abstract void loadAD(Context context);

        public boolean needToLoadNewAd() {
            boolean z16;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - this.loadTime >= this.loadInterval) {
                z16 = true;
            } else {
                z16 = false;
            }
            QMLog.d(REALTIME_TAG, "needToLoadNewAd currTime:" + currentTimeMillis + " loadTime:" + this.loadTime + " loadInterval:" + this.loadInterval + " result:" + z16);
            return z16;
        }

        public abstract void showAD(Context context, String str);
    }

    /* loaded from: classes23.dex */
    public static class ExpParam {
        public int key;
        public String value;

        public ExpParam(int i3, String str) {
            this.key = i3;
            this.value = str;
        }
    }

    /* loaded from: classes23.dex */
    public interface IBannerAdListener {
        void onADClicked();

        void onADCloseOverlay();

        void onADClosed();

        void onADExposure();

        void onADLeftApplication();

        void onADOpenOverlay();

        void onADReceive(JSONObject jSONObject);

        void onAdRefreshPause();

        void onAdRefreshResume();

        void onNoAD(int i3, String str);
    }

    /* loaded from: classes23.dex */
    public interface IBlockAdListener {
        void onADClicked();

        void onADClosed();

        void onADExposure();

        void onADReceive(int i3, int i16, int i17);

        void onNoAD(int i3, String str);
    }

    /* loaded from: classes23.dex */
    public interface IBoxADLisener {
        void onDismiss();

        void onError(int i3, String str);

        void onLoad();

        void onShow();
    }

    /* loaded from: classes23.dex */
    public interface ICmdListener {
        void onCmdListener(boolean z16, JSONObject jSONObject);
    }

    /* loaded from: classes23.dex */
    public interface ILoadingAdListener {
        void getLoadingAdLayoutReady();

        void onAdClick(int i3);

        void onAdDismiss(boolean z16);

        void onAdShow(View view);

        void onDownloadAdEnd(String str, long j3, String str2);

        void onPreloadAdReceive(int i3);

        void onSelectAdProcessDone(String str, ArrayList<Long> arrayList, HashMap<String, String> hashMap);
    }

    /* loaded from: classes23.dex */
    public interface IRewardVideoAdListener {
        void onADClick();

        void onADClose(String str);

        void onADExpose();

        void onADLoad(List<ExpParam> list);

        void onADShow();

        void onError(int i3, String str);

        void onReward();

        void onVideoCached();

        void onVideoComplete();
    }

    /* loaded from: classes23.dex */
    public interface InterstitialADLisener {
        void onDismiss();

        void onError(int i3, String str);

        void onLoad();

        void onShow();
    }

    public boolean adClick(Context context, String str, String str2) {
        return false;
    }

    public boolean adExposure(Context context, String str, String str2) {
        return false;
    }

    public abstract AbsBannerAdView createBannerAdView(Activity activity, String str, String str2, int i3, int i16, IBannerAdListener iBannerAdListener, Bundle bundle, IMiniAppContext iMiniAppContext, IGetAdPosInfo iGetAdPosInfo);

    public AbsBlockAdView createBlockAdView(Activity activity, String str, String str2, int i3, int i16, int i17, int i18, int i19, IBlockAdListener iBlockAdListener, Bundle bundle) {
        return null;
    }

    public AbsBoxAdView createBoxAdView(Activity activity, String str, String str2, IBoxADLisener iBoxADLisener, Bundle bundle) {
        return null;
    }

    public AbsInterstitialAdView createInterstitialAdView(Activity activity, String str, String str2, InterstitialADLisener interstitialADLisener, Bundle bundle, IMiniAppContext iMiniAppContext) {
        return null;
    }

    public abstract AbsRewardVideoAdView createRewardVideoAdView(Context context, String str, String str2, IRewardVideoAdListener iRewardVideoAdListener, Bundle bundle, IMiniAppContext iMiniAppContext);

    /* loaded from: classes23.dex */
    public abstract class AbsBannerAdView {
        public AbsBannerAdView() {
        }

        public abstract void destroy(Context context);

        public long getAdID() {
            return 0L;
        }

        public String getReportUrl() {
            return "";
        }

        public abstract View getView();

        public abstract void loadAD();

        public void onAdHide() {
        }

        public void onAdShow() {
        }

        public void onExposure() {
        }

        public void pause(Context context) {
        }

        public void resume(Context context) {
        }

        public void setSize(int i3, int i16) {
        }
    }

    public void getVipWithoutAdMemberState() {
    }

    public void onActivityStart() {
    }

    public void onActivityStop() {
    }

    public void onFirstFrame() {
    }

    /* loaded from: classes23.dex */
    public abstract class AbsBlockAdView {
        public AbsBlockAdView() {
        }

        public abstract void destroy(Context context);

        public ArrayList<String> getReportUrl() {
            return null;
        }

        public abstract View getView();

        public abstract void loadAD();

        public abstract View updateAdInfo(int i3, int i16);

        public void clearBlockAdAnimation(AbsBlockAdView absBlockAdView) {
        }

        public void showBlockAdAnimation(AbsBlockAdView absBlockAdView) {
        }
    }

    public void destroy(Activity activity) {
    }

    public void preloadLoadingAd(Bundle bundle, ILoadingAdListener iLoadingAdListener) {
    }

    /* loaded from: classes23.dex */
    public abstract class AbsInterstitialAdView {
        public AbsInterstitialAdView() {
        }

        public abstract void destroy();

        public abstract void loadAD();

        public abstract boolean show(Activity activity);

        public void onClose(Activity activity, int i3, Intent intent) {
        }
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }

    public void selectLoadingAd(Bundle bundle, String str, ILoadingAdListener iLoadingAdListener) {
    }

    public void requestAdInfo(Context context, String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7, String str8, int i18, ICmdListener iCmdListener) {
    }

    public void downloadRealTimeAdPic(String str, String str2, String str3, ILoadingAdListener iLoadingAdListener) {
    }

    public void updateLoadingAdLayoutAndShow(Context context, MiniAppInfo miniAppInfo, boolean z16, String str, String str2, String str3, String str4, String str5, String str6, long j3, ILoadingAdListener iLoadingAdListener) {
    }
}
