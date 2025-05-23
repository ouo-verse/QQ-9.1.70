package com.qq.e.tg.interstitial2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.cfg.VideoOption;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class UnifiedInterstitialAD {

    /* renamed from: a, reason: collision with root package name */
    private UIADI f40511a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40512b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40513c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40514d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f40515e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f40516f;

    /* renamed from: g, reason: collision with root package name */
    private volatile UnifiedInterstitialMediaListener f40517g;

    /* renamed from: h, reason: collision with root package name */
    private volatile VideoOption f40518h;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f40519i;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f40520j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f40521k;

    /* renamed from: l, reason: collision with root package name */
    private LoadAdParams f40522l;

    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, null);
    }

    public void close() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.close();
        }
    }

    public void destroy() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.destory();
        }
    }

    public String getAdNetWorkName() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            return uiadi.getAdNetWorkName();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            return uiadi.getAdPatternType();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdPatternType");
        return 0;
    }

    public int getECPM() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            return uiadi.getECPM();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPM");
        return -1;
    }

    public String getECPMLevel() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            return uiadi.getECPMLevel();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPMLevel");
        return null;
    }

    public Map getExt() {
        try {
            if (this.f40511a != null) {
                return UIADI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("interstitial2 can not get ext");
            return null;
        }
    }

    public void loadAD() {
        if (this.f40512b && this.f40513c) {
            if (!this.f40514d) {
                this.f40515e.incrementAndGet();
                return;
            }
            UIADI uiadi = this.f40511a;
            if (uiadi != null) {
                uiadi.loadAd();
                return;
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
                return;
            }
        }
        GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
    }

    public void loadFullScreenAD() {
        if (this.f40512b && this.f40513c) {
            if (!this.f40514d) {
                this.f40516f.incrementAndGet();
                return;
            }
            UIADI uiadi = this.f40511a;
            if (uiadi != null) {
                uiadi.loadFullScreenAD();
                return;
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
                return;
            }
        }
        GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
    }

    public void setLoadADParams(LoadAdParams loadAdParams) {
        this.f40522l = loadAdParams;
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.setLodADParams(loadAdParams);
        }
    }

    public void setMaxVideoDuration(int i3) {
        this.f40521k = i3;
        if (this.f40521k > 0 && this.f40520j > this.f40521k) {
            GDTLogger.e("maxVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5c0f\u4e8eminVideoDuration");
        }
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.setMaxVideoDuration(i3);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f40517g = unifiedInterstitialMediaListener;
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    public void setMinVideoDuration(int i3) {
        this.f40520j = i3;
        if (this.f40521k > 0 && this.f40520j > this.f40521k) {
            GDTLogger.e("minVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5927\u4e8emaxVideoDuration");
        }
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.setMinVideoDuration(i3);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f40518h = videoOption;
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.setVideoOption(videoOption);
        }
    }

    public void setVideoPlayPolicy(int i3) {
        this.f40519i = i3;
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.setVideoPlayPolicy(i3);
        }
    }

    public void show() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.show();
        }
    }

    public void showAsPopupWindow() {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow();
        }
    }

    public void showFullScreenAD(Activity activity) {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.showFullScreenAD(activity);
        }
    }

    public UnifiedInterstitialAD(final Activity activity, final String str, final String str2, final UnifiedInterstitialADListener unifiedInterstitialADListener, final Map map) {
        this.f40512b = false;
        this.f40513c = false;
        this.f40514d = false;
        this.f40515e = new AtomicInteger(0);
        this.f40516f = new AtomicInteger(0);
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedInterstitialADListener == null) {
            GDTLogger.e(String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedInterstitialADListener));
            return;
        }
        this.f40512b = true;
        this.f40513c = true;
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.interstitial2.UnifiedInterstitialAD.1
            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.INTERSITIAL_AD);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.interstitial2.UnifiedInterstitialAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        UnifiedInterstitialAD.this.f40511a = pOFactory2.getUnifiedInterstitialADDelegate(activity, str, str2, unifiedInterstitialADListener);
                                        UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, true);
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, map, str2);
                                        UnifiedInterstitialAD unifiedInterstitialAD = UnifiedInterstitialAD.this;
                                        unifiedInterstitialAD.setVideoOption(unifiedInterstitialAD.f40518h);
                                        UnifiedInterstitialAD unifiedInterstitialAD2 = UnifiedInterstitialAD.this;
                                        unifiedInterstitialAD2.setMediaListener(unifiedInterstitialAD2.f40517g);
                                        UnifiedInterstitialAD unifiedInterstitialAD3 = UnifiedInterstitialAD.this;
                                        unifiedInterstitialAD3.setMinVideoDuration(unifiedInterstitialAD3.f40520j);
                                        UnifiedInterstitialAD unifiedInterstitialAD4 = UnifiedInterstitialAD.this;
                                        unifiedInterstitialAD4.setMaxVideoDuration(unifiedInterstitialAD4.f40521k);
                                        UnifiedInterstitialAD unifiedInterstitialAD5 = UnifiedInterstitialAD.this;
                                        unifiedInterstitialAD5.setVideoPlayPolicy(unifiedInterstitialAD5.f40519i);
                                        UnifiedInterstitialAD unifiedInterstitialAD6 = UnifiedInterstitialAD.this;
                                        unifiedInterstitialAD6.setLoadADParams(unifiedInterstitialAD6.f40522l);
                                        while (UnifiedInterstitialAD.this.f40515e.getAndDecrement() > 0) {
                                            UnifiedInterstitialAD.this.loadAD();
                                        }
                                        while (UnifiedInterstitialAD.this.f40516f.getAndDecrement() > 0) {
                                            UnifiedInterstitialAD.this.loadFullScreenAD();
                                        }
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        });
                        return;
                    } catch (Throwable th5) {
                        GDTLogger.e("Exception while init UnifiedInterstitialAD plugin", th5);
                        return;
                    }
                }
                GDTLogger.e("Fail to init ADManager");
            }
        });
    }

    public void show(Activity activity) {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.show(activity);
        }
    }

    public void showAsPopupWindow(Activity activity) {
        UIADI uiadi = this.f40511a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow(activity);
        }
    }

    static /* synthetic */ void a(UnifiedInterstitialAD unifiedInterstitialAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e16) {
            GDTLogger.e("UnifiedInterstitialAD#setTag Exception");
            e16.printStackTrace();
        }
    }

    static /* synthetic */ boolean a(UnifiedInterstitialAD unifiedInterstitialAD, boolean z16) {
        unifiedInterstitialAD.f40514d = true;
        return true;
    }
}
