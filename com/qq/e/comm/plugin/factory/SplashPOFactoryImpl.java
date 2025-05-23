package com.qq.e.comm.plugin.factory;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.os.IBinder;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.ADPLI;
import com.qq.e.comm.pi.IEGRVADI;
import com.qq.e.comm.pi.LOG;
import com.qq.e.comm.pi.NADI;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.SOI;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.pi.TADLDI;
import com.qq.e.comm.pi.TGEPI;
import com.qq.e.comm.pi.TGRVOI;
import com.qq.e.comm.pi.TGSPPIV2;
import com.qq.e.comm.pi.TGSPVI;
import com.qq.e.comm.pi.TangramExposureCallback;
import com.qq.e.comm.pi.TangramWidget;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.pi.UTI;
import com.qq.e.comm.pi.WRI;
import com.qq.e.comm.plugin.tangramsplash.b;
import com.qq.e.comm.plugin.tangramsplash.b.c;
import com.qq.e.comm.plugin.tangramsplash.d;
import com.qq.e.comm.plugin.tangramsplash.e;
import com.qq.e.comm.util.GDTLogger;
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
public class SplashPOFactoryImpl implements POFactory {
    BasePOFactoryImpl basePOFactory = (BasePOFactoryImpl) BasePOFactoryImpl.getInstance();

    @Override // com.qq.e.comm.pi.POFactory
    public void checkPreloadSplashMaterial() {
        try {
            c.a(2);
        } catch (Throwable th5) {
            GDTLogger.e("checkPreloadSplashMaterial error:", th5);
        }
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void checkUpdate() {
        this.basePOFactory.checkUpdate();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void config(int i3, String str, ADListener aDListener) {
        this.basePOFactory.config(i3, str, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public SVSD getAPKDownloadServiceDelegate(Service service) {
        return this.basePOFactory.getAPKDownloadServiceDelegate(service);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public ACTD getActivityDelegate(String str, Activity activity) {
        return this.basePOFactory.getActivityDelegate(str, activity);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public ADPLI getAdPreloader() {
        return this.basePOFactory.getAdPreloader();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public LOG getLogger() {
        return this.basePOFactory.getLogger();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NADI getNativeADDelegate(Context context, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NUADI getNativeAdManagerDelegate(Context context, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NEADVI getNativeExpressADView(NEADI neadi, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public IBinder getServerBinder() {
        return this.basePOFactory.getServerBinder();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public SOI getSplashOrderDelegate() {
        return new b();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TADLDI getTangramAdLoaderDelegate(Context context, String str) {
        return this.basePOFactory.getTangramAdLoaderDelegate(context, str);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UTI getTangramAdTriggerDelegate() {
        return this.basePOFactory.getTangramAdTriggerDelegate();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public ITGDC getTangramDownloaderConfigure() {
        return this.basePOFactory.getTangramDownloaderConfigure();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGEPI getTangramExposureChecker(JSONObject jSONObject, WeakReference<TangramExposureCallback> weakReference) {
        return this.basePOFactory.getTangramExposureChecker(jSONObject, weakReference);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGRVOI getTangramRewardAdOrderImp(String str, String str2) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGSPVI getTangramSplashAdView(Context context, String str, String str2) {
        return new d(context, str, str2);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGSPPIV2 getTangramSplashPreloader() {
        return e.a();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TangramWidget getTangramWidget(Context context, String str) {
        return this.basePOFactory.getTangramWidget(context, str);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public WRI getWebReporterDelegate(String str, long j3) {
        return this.basePOFactory.getWebReporterDelegate(str, j3);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public IEGRVADI gettangramrewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void onGdtConfigUpdateDone() {
        GDTLogger.i("onGdtConfigUpdateDone function call");
        this.basePOFactory.onGdtConfigUpdateDone();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void onGdtConfigUpdateFailed() {
        GDTLogger.i("onGdtConfigUpdateFailed function call");
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void proceedToDownloadAPKTask() {
        this.basePOFactory.proceedToDownloadAPKTask();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void reportCost(int i3, int i16, Map map, Map map2) {
        this.basePOFactory.reportCost(i3, i16, map, map2);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void config(int i3, String str) {
        this.basePOFactory.config(i3, str, null);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void reportLog(String str) {
    }
}
