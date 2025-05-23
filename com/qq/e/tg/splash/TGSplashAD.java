package com.qq.e.tg.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.ITangramDecoderPlayer;
import com.qq.e.comm.pi.ITangramPlayer;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.TGSPVI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TGSplashAD {
    public static final int EVENT_TYPE_LIMIT_AD_VIEW_CLICKED = 10;
    public static final String RESET_CUSTOM_VIEW = "resetCustomView";
    private volatile boolean A;
    private volatile boolean B;
    private volatile boolean C;
    private volatile int D;
    private volatile boolean E;
    private volatile int F;
    private long G;
    private volatile int H;
    private volatile int I;
    private volatile boolean J;
    private volatile int K;
    private volatile int L;
    private volatile boolean M;
    private volatile FetchAdParams N;

    /* renamed from: a, reason: collision with root package name */
    private PreCacheSplashAd f40746a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f40747b;

    /* renamed from: c, reason: collision with root package name */
    private long f40748c;

    /* renamed from: d, reason: collision with root package name */
    private volatile TGSPVI f40749d;

    /* renamed from: e, reason: collision with root package name */
    private volatile ViewGroup f40750e;

    /* renamed from: f, reason: collision with root package name */
    private volatile TGSplashAdListener f40751f;

    /* renamed from: g, reason: collision with root package name */
    private volatile LoadAdParams f40752g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f40753h;

    /* renamed from: i, reason: collision with root package name */
    private volatile View f40754i;

    /* renamed from: j, reason: collision with root package name */
    private volatile View f40755j;

    /* renamed from: k, reason: collision with root package name */
    private volatile ITangramPlayer f40756k;

    /* renamed from: l, reason: collision with root package name */
    private volatile View f40757l;

    /* renamed from: m, reason: collision with root package name */
    private volatile View f40758m;

    /* renamed from: n, reason: collision with root package name */
    private volatile View f40759n;

    /* renamed from: o, reason: collision with root package name */
    private volatile View f40760o;

    /* renamed from: p, reason: collision with root package name */
    private volatile View f40761p;

    /* renamed from: q, reason: collision with root package name */
    private volatile View f40762q;

    /* renamed from: r, reason: collision with root package name */
    private volatile View f40763r;

    /* renamed from: s, reason: collision with root package name */
    private volatile View f40764s;

    /* renamed from: t, reason: collision with root package name */
    private volatile View f40765t;

    /* renamed from: u, reason: collision with root package name */
    private volatile Rect f40766u;

    /* renamed from: v, reason: collision with root package name */
    private volatile ITangramDecoderPlayer f40767v;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f40768w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f40769x;

    /* renamed from: y, reason: collision with root package name */
    private volatile boolean f40770y;

    /* renamed from: z, reason: collision with root package name */
    private volatile boolean f40771z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ADListenerAdapter implements ADListener {
        ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (TGSplashAD.this.f40751f == null) {
                GDTLogger.e("SplashADListener == null");
                return;
            }
            Object[] paras = aDEvent.getParas();
            switch (aDEvent.getType()) {
                case 1:
                    TGSplashAD.this.f40751f.onADDismissed();
                    return;
                case 2:
                    if (paras.length > 0 && (paras[0] instanceof Integer)) {
                        TGSplashAD.this.f40751f.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                        return;
                    } else {
                        GDTLogger.e("Splash onNoAD event get params error.");
                        return;
                    }
                case 3:
                    TGSplashAD.this.f40751f.onADPresent();
                    return;
                case 4:
                    TGSplashAD.this.f40751f.onADClicked();
                    return;
                case 5:
                    if (paras.length == 1 && (paras[0] instanceof Long)) {
                        TGSplashAD.this.f40751f.onADTick(((Long) paras[0]).longValue());
                        return;
                    } else {
                        GDTLogger.e("Splash onADTick event get param error.");
                        return;
                    }
                case 6:
                    TGSplashAD.this.f40751f.onADExposure();
                    return;
                case 7:
                    TGSplashAD.this.f40751f.onADFetch();
                    return;
                case 8:
                    TGSplashAD.this.f40751f.onADSkip();
                    return;
                case 9:
                    if ((TGSplashAD.this.f40751f instanceof TGSplashAdListenerV2) && paras.length == 1 && (paras[0] instanceof SplashOrder)) {
                        ((TGSplashAdListenerV2) TGSplashAD.this.f40751f).onADFetchWithResult((SplashOrder) paras[0]);
                        return;
                    } else {
                        GDTLogger.e("Splash onADFetchWithResult event get param error.");
                        return;
                    }
                case 10:
                    if (TGSplashAD.this.f40751f instanceof TGSplashAdListenerV3) {
                        ((TGSplashAdListenerV3) TGSplashAD.this.f40751f).onLimitAdViewClicked();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        /* synthetic */ ADListenerAdapter(TGSplashAD tGSplashAD, byte b16) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Event {
        public static int SPLASH_ALPHA_FOCUS_AREA_CLICK_ENDBUTTON = 7010021;
        public static int SPLASH_ALPHA_FOCUS_AREA_CLICK_NEGATIVE_FEEDBACK = 7010020;
        public static int SPLASH_ALPHA_FOCUS_AREA_EXPOSURE = 7010018;
        public static int SPLASH_ALPHA_FOCUS_VIDEO_NOT_PLAY_END = 7010027;
        public static int SPLASH_ALPHA_FOCUS_VIDEO_PLAY_END = 7010026;
        public static int SPLASH_ALPHA_FOCUS_VIDEO_PLAY_ERROR = 7010028;
        public static int SPLASH_ALPHA_FOCUS_VIDEO_PLAY_START = 7010025;
        public static int SPLASH_ALPHA_PLAY_END_CLICK_FOCUS_AREA = 7010019;
        public static int SPLASH_ALPHA_VIDEO_CLICK_FOCUS_AREA = 7010014;
        public static int SPLASH_ALPHA_VIDEO_CLICK_NOT_ALPHA_VIDEO_AREA = 7010016;
        public static int SPLASH_ALPHA_VIDEO_CLICK_NOT_FOCUS_AREA = 7010015;
        public static int SPLASH_ALPHA_VIDEO_EXPOSURE = 7010008;
        public static int SPLASH_ALPHA_VIDEO_NOT_PLAY_END = 7010011;
        public static int SPLASH_ALPHA_VIDEO_PLAY_CLOSE = 7010013;
        public static int SPLASH_ALPHA_VIDEO_PLAY_END = 7010010;
        public static int SPLASH_ALPHA_VIDEO_PLAY_ERROR = 7010012;
        public static int SPLASH_ALPHA_VIDEO_PLAY_START = 7010009;
        public static int SPLASH_ALPHA_VIDEO_SWIPE_NOT_ALPHA_VIDEO_AREA = 7010017;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class FetchAdParams {
        public String emptyOrderApUrl;
        public boolean needIncreasePlayRound = true;
        public boolean needCallPreSelect = true;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ReportParams {
        public String adJson;
        public int eventId;
        public String posId;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class SplashDisplayParams {
        public Bitmap bitmap = null;
        public PreCacheSplashAd splashAd = null;
        public ViewGroup container = null;
        public long firstFrameTimeout = 500;

        public boolean isValid() {
            if (this.bitmap != null && this.splashAd != null && this.container != null) {
                return true;
            }
            return false;
        }
    }

    public TGSplashAD(Context context, View view, String str, String str2, TGSplashAdListener tGSplashAdListener, int i3) {
        this(context, view, str, str2, tGSplashAdListener, i3, null);
    }

    public void doRecycleBeforeSplashDismiss() {
        GDTLogger.i("[doRecycleBeforeSplashDismiss] :" + this.f40749d);
        if (this.f40749d != null) {
            this.f40749d.doRecycleBeforeSplashDismiss();
        }
    }

    public void doRecycleSplashCustomView() {
        SM sm5 = GDTADManager.getInstance().getSM();
        if (sm5 != null && sm5.getInteger(RESET_CUSTOM_VIEW, 0) == 1) {
            GDTLogger.i("[doRecycleBeforeSplashDismiss] is open recycle custom view");
            this.f40754i = null;
            this.f40755j = null;
            this.f40757l = null;
            this.f40758m = null;
            this.f40759n = null;
            this.f40760o = null;
            this.f40761p = null;
            this.f40762q = null;
            this.f40763r = null;
            this.f40764s = null;
            this.f40765t = null;
        }
    }

    public void fetchAdOnly() {
        GDTLogger.d("SplashAD fetchAdOnly fetchAdStartTime 1: " + this.G);
        if (this.G == 0) {
            this.G = System.currentTimeMillis();
        }
        GDTLogger.d("SplashAD fetchAdOnly fetchAdStartTime 2: " + this.G);
        if (this.f40749d != null) {
            if (GDTADManager.getInstance().getSM() != null) {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.FETCH_AD_START_TIME, Long.valueOf(this.G));
            }
            this.f40749d.selectOrderByLocalRealtimeParallelism();
            return;
        }
        this.f40769x = true;
    }

    @Deprecated
    public void fetchAndShowIn(ViewGroup viewGroup) {
        if (this.G == 0) {
            this.G = System.currentTimeMillis();
        }
        GDTLogger.d("SplashAD fetchAndShowIn fetchAdStartTime: " + this.G);
        if (viewGroup == null) {
            GDTLogger.e("SplashAD fetchAndShowIn params null ");
            a(this.f40751f, 2001);
        } else {
            if (this.f40749d != null) {
                if (GDTADManager.getInstance().getSM() != null) {
                    GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.FETCH_AD_START_TIME, Long.valueOf(this.G));
                }
                this.f40749d.fetchAndShowIn(viewGroup);
                return;
            }
            this.f40750e = viewGroup;
        }
    }

    public String getAdNetWorkName() {
        if (this.f40749d != null) {
            return this.f40749d.getAdNetWorkName();
        }
        GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    public Map getExt() {
        try {
            return TGSPVI.ext;
        } catch (Exception e16) {
            GDTLogger.e("splash ad can not get extra");
            e16.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public SplashOrder getSelectResultImmediately(String str) {
        if (this.f40749d != null) {
            return this.f40749d.getSelectResultImmediately(str);
        }
        return null;
    }

    public void preLoad() {
        if (this.f40749d != null) {
            this.f40749d.preload();
        } else {
            this.f40753h = true;
        }
    }

    @Deprecated
    public void reportCost(int i3, int i16, Map map) {
        if (this.f40749d != null) {
            this.f40749d.reportCost(i3, i16, map);
        }
    }

    public void reportEmptyOrderIfNecessaryAndPreFetchAd(FetchAdParams fetchAdParams) {
        if (this.f40749d != null) {
            this.f40749d.reportEmptyOrderIfNecessaryAndPreFetchAd(fetchAdParams);
        } else {
            this.N = fetchAdParams;
            this.f40770y = true;
        }
    }

    @Deprecated
    public void reportLinkEvent(ReportParams reportParams) {
        if (this.f40749d != null) {
            this.f40749d.reportLinkEvent(reportParams);
        }
    }

    @Deprecated
    public void reportNoUseSplashReason(int i3) {
        if (this.f40749d != null && this.F != Integer.MAX_VALUE) {
            this.f40749d.reportNoUseSplashReason(i3);
            this.F = Integer.MAX_VALUE;
        } else {
            this.F = i3;
        }
    }

    public void setAdLogoView(View view) {
        if (this.f40749d != null) {
            this.f40749d.setAdLogoView(view);
            this.A = true;
        } else {
            this.f40754i = view;
        }
    }

    public void setBrokenWindowCloseView(View view) {
        if (this.f40749d != null) {
            this.f40749d.setBrokenWindowCloseView(view);
        } else {
            this.f40765t = view;
        }
    }

    public void setCustomDecoderPlayer(ITangramDecoderPlayer iTangramDecoderPlayer) {
        if (this.f40749d != null) {
            this.f40749d.setCustomDecoderPlayer(iTangramDecoderPlayer);
        } else {
            this.f40767v = iTangramDecoderPlayer;
        }
    }

    public void setEasterEggVolumeIcon(View view, View view2) {
        if (this.f40749d != null) {
            this.f40749d.setEasterEggVolumeIcon(view, view2);
        } else {
            this.f40763r = view;
            this.f40764s = view2;
        }
    }

    public void setFloatView(View view) {
        if (this.f40749d != null) {
            this.f40749d.setFloatView(view);
        } else {
            this.f40760o = view;
        }
    }

    public void setLimitAdView(View view) {
        if (this.f40749d != null) {
            this.f40749d.setLimitAdView(view);
        } else {
            this.f40758m = view;
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        if (this.f40749d != null) {
            this.f40749d.setLoadAdParams(loadAdParams);
        } else {
            this.f40752g = loadAdParams;
        }
    }

    public void setNeedSplashButtonGuideView(boolean z16) {
        if (this.f40749d != null) {
            this.f40749d.needUseSplashButtonGuideView(z16);
        } else {
            this.E = z16;
        }
    }

    public void setNeedUseCustomDynamicFloatView(boolean z16) {
        if (this.f40749d != null) {
            this.f40749d.needUseCustomDynamicFloatView(z16);
        } else {
            this.B = z16;
        }
    }

    public void setNeedUseCustomFloatViewPosition(boolean z16) {
        if (a()) {
            GDTLogger.i("setNeedUseCustomFloatViewPosition" + z16);
            this.C = z16;
        }
        if (this.f40749d != null) {
            this.f40749d.needUseCustomFloatViewPosition(z16);
        } else {
            this.C = z16;
        }
    }

    public void setOneShotFocusViewRect(Rect rect) {
        if (this.f40749d != null) {
            this.f40749d.setOneShotFocusViewRect(rect);
        } else {
            this.f40766u = rect;
        }
    }

    public void setPreloadView(View view) {
        if (this.f40749d != null) {
            this.f40749d.setPreloadView(view);
        } else {
            this.f40755j = view;
        }
    }

    public void setPureSkipView(View view) {
        if (this.f40749d != null) {
            this.f40749d.setPureSkipView(view);
        } else {
            this.f40757l = view;
        }
    }

    public void setSkipView(View view) {
        if (this.f40749d != null) {
            this.f40749d.setSkipView(view);
        } else {
            this.f40759n = view;
        }
    }

    public void setSplashButtonGuideViewHeight(int i3) {
        if (this.f40749d != null) {
            this.f40749d.setSplashButtonGuideViewHeight(i3);
        } else {
            this.D = i3;
        }
    }

    public void setVideoView(ITangramPlayer iTangramPlayer, boolean z16) {
        if (iTangramPlayer == null) {
            GDTLogger.e("SplashAD setVideoView videoView null ");
        } else if (this.f40749d != null) {
            this.f40749d.setVideoView(iTangramPlayer, z16);
        } else {
            this.f40756k = iTangramPlayer;
            this.f40768w = z16;
        }
    }

    public void setVolumeIcon(View view, View view2) {
        if (this.f40749d != null) {
            this.f40749d.setVolumeIcon(view, view2);
        } else {
            this.f40761p = view;
            this.f40762q = view2;
        }
    }

    public void setVolumeIconEasterEggMargin(int i3, int i16) {
        if (this.f40749d != null) {
            this.f40749d.setVolumeIconEasterEggMargin(i3, i16);
            this.M = true;
        } else {
            this.K = i3;
            this.L = i16;
        }
    }

    public void setVolumeIconMargin(int i3, int i16) {
        if (this.f40749d != null) {
            this.f40749d.setVolumeIconMargin(i3, i16);
            this.J = true;
        } else {
            this.H = i3;
            this.I = i16;
        }
    }

    public void showAd(SplashDisplayParams splashDisplayParams) {
        if (this.f40749d != null) {
            this.f40749d.showAd(splashDisplayParams);
            return;
        }
        this.f40750e = splashDisplayParams.container;
        this.f40746a = splashDisplayParams.splashAd;
        this.f40747b = splashDisplayParams.bitmap;
        this.f40748c = splashDisplayParams.firstFrameTimeout;
        this.f40771z = true;
    }

    public void tryCompensateFetchAd() {
        GDTLogger.i("tryCompensateFetchAd mPreSelectAdFlag:" + this.f40770y + ", mRealtimeSelectAdFlag:" + this.f40769x);
        if (this.f40749d == null) {
            return;
        }
        if (this.f40769x) {
            this.f40749d.selectOrderByLocalRealtimeParallelism();
        } else if (this.f40770y) {
            this.f40749d.reportEmptyOrderIfNecessaryAndPreFetchAd(this.N);
        }
    }

    public TGSplashAD(Context context, View view, String str, String str2, TGSplashAdListener tGSplashAdListener, int i3, View view2) {
        this(context, view, str, str2, tGSplashAdListener, i3, null, view2);
    }

    public TGSplashAD(final Context context, final View view, final String str, final String str2, final TGSplashAdListener tGSplashAdListener, final int i3, final Map map, final View view2) {
        this.f40753h = false;
        this.f40768w = true;
        this.f40769x = false;
        this.f40770y = false;
        this.f40771z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = false;
        this.F = Integer.MAX_VALUE;
        this.G = 0L;
        this.J = false;
        this.M = false;
        this.G = 0L;
        this.f40751f = tGSplashAdListener;
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2) && context != null) {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (GDTADManager.getInstance().initWith(context, str)) {
                            try {
                                POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.SPLASH_AD);
                                try {
                                    if (pOFactory != null) {
                                        TGSplashAD.this.f40749d = pOFactory.getTangramSplashAdView(context, str, str2);
                                        if (TGSplashAD.this.f40749d != null) {
                                            TGSplashAD.a(TGSplashAD.this, map, str2, i3);
                                            TGSplashAD.this.tryCompensateFetchAd();
                                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashAD.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                    TGSplashAD.a(TGSplashAD.this, view, view2);
                                                }
                                            });
                                            if (TGSplashAD.this.f40753h) {
                                                TGSplashAD.this.f40749d.preload();
                                                TGSplashAD.a(TGSplashAD.this, false);
                                                return;
                                            }
                                            return;
                                        }
                                        GDTLogger.e("SplashAdView created by factory return null");
                                        TGSplashAD tGSplashAD = TGSplashAD.this;
                                        TGSplashAD.a(tGSplashAdListener, AdErrorConvertor.ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        return;
                                    }
                                    GDTLogger.e("factory return null");
                                    TGSplashAD tGSplashAD2 = TGSplashAD.this;
                                    TGSplashAD.a(tGSplashAdListener, AdErrorConvertor.ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                } catch (Throwable th5) {
                                    GDTLogger.e("Unknown Exception", th5);
                                    TGSplashAD tGSplashAD3 = TGSplashAD.this;
                                    TGSplashAD.a(tGSplashAdListener, 605);
                                }
                            } catch (a e16) {
                                GDTLogger.e("Fail to init splash plugin", e16);
                                TGSplashAD tGSplashAD4 = TGSplashAD.this;
                                TGSplashAD.a(tGSplashAdListener, AdErrorConvertor.ErrorCode.PLUGIN_INIT_ERROR);
                            } catch (Throwable th6) {
                                GDTLogger.e("Unknown Exception", th6);
                                TGSplashAD tGSplashAD5 = TGSplashAD.this;
                                TGSplashAD.a(tGSplashAdListener, 605);
                            }
                        }
                    } catch (Throwable th7) {
                        GDTLogger.e("Unknown Exception", th7);
                        TGSplashAD tGSplashAD6 = TGSplashAD.this;
                        TGSplashAD.a(tGSplashAdListener, 605);
                    }
                }
            });
        } else {
            GDTLogger.e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", str, str2, context));
            a(tGSplashAdListener, 2001);
        }
    }

    static /* synthetic */ void a(TGSplashAD tGSplashAD, View view, View view2) {
        if (view != null) {
            tGSplashAD.f40749d.setSkipView(view);
        }
        if (view2 != null) {
            tGSplashAD.f40749d.setFloatView(view2);
        }
        if (!tGSplashAD.A) {
            tGSplashAD.f40749d.setAdLogoView(tGSplashAD.f40754i);
        }
        if (tGSplashAD.f40755j != null) {
            tGSplashAD.f40749d.setPreloadView(tGSplashAD.f40755j);
        }
        if (tGSplashAD.f40756k != null) {
            tGSplashAD.f40749d.setVideoView(tGSplashAD.f40756k, tGSplashAD.f40768w);
        }
        if (tGSplashAD.f40757l != null) {
            tGSplashAD.f40749d.setPureSkipView(tGSplashAD.f40757l);
        }
        if (tGSplashAD.f40758m != null) {
            tGSplashAD.f40749d.setLimitAdView(tGSplashAD.f40758m);
        }
        if (!tGSplashAD.J) {
            tGSplashAD.f40749d.setVolumeIconMargin(tGSplashAD.H, tGSplashAD.I);
        }
        if (!tGSplashAD.M) {
            tGSplashAD.f40749d.setVolumeIconEasterEggMargin(tGSplashAD.K, tGSplashAD.L);
        }
        if (tGSplashAD.f40760o != null) {
            tGSplashAD.f40749d.setFloatView(tGSplashAD.f40760o);
        }
        if (tGSplashAD.f40759n != null) {
            tGSplashAD.f40749d.setSkipView(tGSplashAD.f40759n);
        }
        if (tGSplashAD.f40761p != null && tGSplashAD.f40762q != null) {
            tGSplashAD.f40749d.setVolumeIcon(tGSplashAD.f40761p, tGSplashAD.f40762q);
        }
        if (tGSplashAD.f40763r != null && tGSplashAD.f40764s != null) {
            tGSplashAD.f40749d.setEasterEggVolumeIcon(tGSplashAD.f40763r, tGSplashAD.f40764s);
        }
        if (tGSplashAD.f40765t != null) {
            tGSplashAD.f40749d.setBrokenWindowCloseView(tGSplashAD.f40765t);
        }
        if (tGSplashAD.f40766u != null) {
            tGSplashAD.f40749d.setOneShotFocusViewRect(tGSplashAD.f40766u);
        }
        if (tGSplashAD.f40767v != null) {
            tGSplashAD.f40749d.setCustomDecoderPlayer(tGSplashAD.f40767v);
        }
        if (tGSplashAD.f40750e == null || !tGSplashAD.f40771z) {
            return;
        }
        SplashDisplayParams splashDisplayParams = new SplashDisplayParams();
        splashDisplayParams.bitmap = tGSplashAD.f40747b;
        splashDisplayParams.splashAd = tGSplashAD.f40746a;
        splashDisplayParams.container = tGSplashAD.f40750e;
        splashDisplayParams.firstFrameTimeout = tGSplashAD.f40748c;
        tGSplashAD.showAd(splashDisplayParams);
    }

    public TGSplashAD(Context context, String str, String str2, TGSplashAdListener tGSplashAdListener) {
        this(context, str, str2, tGSplashAdListener, 0);
    }

    public TGSplashAD(Context context, String str, String str2, TGSplashAdListener tGSplashAdListener, int i3) {
        this(context, null, str, str2, tGSplashAdListener, i3);
    }

    static /* synthetic */ void a(TGSplashAD tGSplashAD, Map map, String str, int i3) {
        if (tGSplashAD.f40752g != null) {
            tGSplashAD.f40749d.setLoadAdParams(tGSplashAD.f40752g);
        }
        if (map != null && map.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(map);
                if (GDTADManager.getInstance().getSM() != null) {
                    GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, jSONObject, str);
                }
            } catch (Exception e16) {
                GDTLogger.e("SplashAD#setTag Exception");
                e16.printStackTrace();
            }
        }
        tGSplashAD.f40749d.setFetchDelay(i3);
        tGSplashAD.f40749d.setAdListener(new ADListenerAdapter(tGSplashAD, (byte) 0));
        tGSplashAD.f40749d.needUseCustomDynamicFloatView(tGSplashAD.B);
        tGSplashAD.f40749d.needUseCustomFloatViewPosition(tGSplashAD.C);
        tGSplashAD.f40749d.needUseSplashButtonGuideView(tGSplashAD.E);
        tGSplashAD.f40749d.setSplashButtonGuideViewHeight(tGSplashAD.D);
        if (tGSplashAD.F != Integer.MAX_VALUE) {
            tGSplashAD.f40749d.reportNoUseSplashReason(tGSplashAD.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(TGSplashAdListener tGSplashAdListener, int i3) {
        if (tGSplashAdListener != null) {
            tGSplashAdListener.onNoAD(AdErrorConvertor.formatErrorCode(i3));
        }
    }

    private static boolean a() {
        try {
            if (GDTADManager.getInstance().getSM() != null) {
                return GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.KEY_REPAIR_QQ_BOTTOM_LOGO, 1) == 1;
            }
            return false;
        } catch (Throwable th5) {
            GDTLogger.e("splashAdView is null", th5);
            return false;
        }
    }

    static /* synthetic */ boolean a(TGSplashAD tGSplashAD, boolean z16) {
        tGSplashAD.f40753h = false;
        return false;
    }
}
