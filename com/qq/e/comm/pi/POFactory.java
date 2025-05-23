package com.qq.e.comm.pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.os.IBinder;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.tg.banner2.UnifiedBannerADListener;
import com.qq.e.tg.banner2.UnifiedBannerView;
import com.qq.e.tg.download.interfaces.ITGDC;
import com.qq.e.tg.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.tg.nativ.ADSize;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface POFactory {
    void checkPreloadSplashMaterial();

    void checkUpdate();

    void config(int i3, String str);

    void config(int i3, String str, ADListener aDListener);

    SVSD getAPKDownloadServiceDelegate(Service service);

    ACTD getActivityDelegate(String str, Activity activity);

    ADPLI getAdPreloader();

    LOG getLogger();

    NADI getNativeADDelegate(Context context, String str, String str2, ADListener aDListener);

    NUADI getNativeAdManagerDelegate(Context context, String str, String str2, ADListener aDListener);

    NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, ADListener aDListener);

    NEADVI getNativeExpressADView(NEADI neadi, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap);

    IBinder getServerBinder();

    SOI getSplashOrderDelegate();

    TADLDI getTangramAdLoaderDelegate(Context context, String str);

    UTI getTangramAdTriggerDelegate();

    ITGDC getTangramDownloaderConfigure();

    TGEPI getTangramExposureChecker(JSONObject jSONObject, WeakReference<TangramExposureCallback> weakReference);

    TGRVOI getTangramRewardAdOrderImp(String str, String str2);

    TGSPVI getTangramSplashAdView(Context context, String str, String str2);

    TGSPPIV2 getTangramSplashPreloader();

    TangramWidget getTangramWidget(Context context, String str);

    UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener);

    UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener);

    WRI getWebReporterDelegate(String str, long j3);

    IEGRVADI gettangramrewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener);

    void onGdtConfigUpdateDone();

    void onGdtConfigUpdateFailed();

    void proceedToDownloadAPKTask();

    void reportCost(int i3, int i16, Map map, Map map2);

    void reportLog(String str);
}
