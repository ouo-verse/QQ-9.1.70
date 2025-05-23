package com.qq.e.tg.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class UnifiedBannerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private UBVI f40445a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40446b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40447c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40448d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f40449e;

    /* renamed from: f, reason: collision with root package name */
    private int f40450f;

    /* renamed from: g, reason: collision with root package name */
    private LoadAdParams f40451g;

    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, null);
    }

    public void destroy() {
        UBVI ubvi = this.f40445a;
        if (ubvi != null) {
            ubvi.destroy();
        }
    }

    public Map getExt() {
        try {
            if (this.f40445a != null) {
                return UBVI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("banner2 can not get ext");
            return null;
        }
    }

    public void loadAD() {
        loadAD(null);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        UBVI ubvi = this.f40445a;
        if (ubvi != null) {
            ubvi.onWindowFocusChanged(z16);
        }
    }

    public void pause() {
        UBVI ubvi = this.f40445a;
        if (ubvi != null) {
            ubvi.pause();
        }
    }

    public void resume() {
        UBVI ubvi = this.f40445a;
        if (ubvi != null) {
            ubvi.resume();
        }
    }

    public void setRefresh(int i3) {
        this.f40450f = i3;
        UBVI ubvi = this.f40445a;
        if (ubvi != null) {
            ubvi.setRefresh(i3);
        }
    }

    public UnifiedBannerView(final Activity activity, final String str, final String str2, final UnifiedBannerADListener unifiedBannerADListener, final Map map) {
        super(activity);
        this.f40446b = false;
        this.f40447c = false;
        this.f40448d = false;
        this.f40449e = new AtomicInteger(0);
        this.f40450f = 30;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedBannerADListener == null) {
            GDTLogger.e(String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedBannerADListener));
            return;
        }
        this.f40446b = true;
        this.f40447c = true;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.banner2.UnifiedBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.BANNER_AD);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.banner2.UnifiedBannerView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        UnifiedBannerView unifiedBannerView = UnifiedBannerView.this;
                                        unifiedBannerView.f40445a = pOFactory2.getUnifiedBannerViewDelegate(unifiedBannerView, activity, str, str2, unifiedBannerADListener);
                                        UnifiedBannerView.a(UnifiedBannerView.this, true);
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        UnifiedBannerView.a(UnifiedBannerView.this, map, str2);
                                        UnifiedBannerView unifiedBannerView2 = UnifiedBannerView.this;
                                        unifiedBannerView2.setRefresh(unifiedBannerView2.f40450f);
                                        while (UnifiedBannerView.this.f40449e.getAndDecrement() > 0) {
                                            UnifiedBannerView unifiedBannerView3 = UnifiedBannerView.this;
                                            unifiedBannerView3.loadAD(unifiedBannerView3.f40451g);
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
                        GDTLogger.e("Exception while init UnifiedBannerView plugin", th5);
                        return;
                    }
                }
                GDTLogger.e("Fail to init ADManager");
            }
        });
    }

    public void loadAD(LoadAdParams loadAdParams) {
        if (!this.f40446b || !this.f40447c) {
            GDTLogger.e("UnifiedBannerView init Paras OR Context error,See More logs while new BannerView");
            return;
        }
        this.f40451g = loadAdParams;
        if (!this.f40448d) {
            this.f40449e.incrementAndGet();
            return;
        }
        UBVI ubvi = this.f40445a;
        if (ubvi != null) {
            ubvi.fetchAd(loadAdParams);
        } else {
            GDTLogger.e("UnifiedBannerView Init error,See More Logs");
        }
    }

    static /* synthetic */ void a(UnifiedBannerView unifiedBannerView, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e16) {
            GDTLogger.e("UnifiedBanner#setTag Exception");
            e16.printStackTrace();
        }
    }

    static /* synthetic */ boolean a(UnifiedBannerView unifiedBannerView, boolean z16) {
        unifiedBannerView.f40448d = true;
        return true;
    }
}
