package com.qzone.proxy.feedcomponent;

import ADV_REPORT.s_anti_cheat;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import NS_MOBILE_FEEDS.s_join_list;
import NS_UNDEAL_COUNT.stSoftInfo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import com.qq.e.comm.constants.Constants;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.IResult;
import com.qzone.adapter.feedcomponent.IServiceCallback;
import com.qzone.adapter.feedcomponent.QZoneFakeFeedStatus;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.adapter.feedcomponent.n;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.app.ImageEnvImpl;
import com.qzone.business.vip.QZoneVIPUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFeedFragmentFeedImp;
import com.qzone.common.activities.base.QZoneBaseFeedFragment;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.IObserver;
import com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor;
import com.qzone.common.protocol.request.GdtDcReportRequest;
import com.qzone.commoncode.module.gdt.GdtImageHandler;
import com.qzone.commoncode.module.gdt.GdtPreLoadOfflineHelper;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.feed.business.model.ViewFeedPhotoData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.misc.network.ttt.TTTReportManager;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.personalize.business.QzoneZipDownloadService;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.feedcomponent.handler.DressBirthdayGiftHandler;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellActiveAdv;
import com.qzone.proxy.feedcomponent.model.CellFunnyTreadSpace;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommHeader;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.TencentVideoModule;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.l;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.util.SystemTools;
import com.qzone.util.am;
import com.qzone.util.ap;
import com.qzone.widget.QZonePullToRefreshListView;
import com.qzone.widget.x;
import com.tencent.ads.data.AdParam;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.VideoOptions;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.strategy.StrategyProvider;
import com.tencent.ditto.area.DittoHost;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Prototype;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.webview.webso.c;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.util.Pair;
import com.tencent.xweb.FileReaderHelper;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneTopGestureLayout;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.ProcessUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SafeUtil;
import cooperation.qzone.util.TimeCostTrace;
import cooperation.qzone.widget.QzoneEmotionUtils;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import e8.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Prototype
/* loaded from: classes39.dex */
public class FeedEnvImpl extends com.qzone.adapter.feedcomponent.i {
    public static Drawable O = null;
    private static boolean P = true;

    /* renamed from: l, reason: collision with root package name */
    private int f50111l = 0;

    /* renamed from: m, reason: collision with root package name */
    int f50112m = -1;

    /* renamed from: n, reason: collision with root package name */
    int f50113n = -1;

    /* renamed from: o, reason: collision with root package name */
    int f50114o = -1;

    /* renamed from: p, reason: collision with root package name */
    int f50115p = -1;

    /* renamed from: q, reason: collision with root package name */
    boolean f50116q = true;

    /* renamed from: r, reason: collision with root package name */
    int f50117r = -1;

    /* renamed from: s, reason: collision with root package name */
    int f50118s = -1;

    /* renamed from: t, reason: collision with root package name */
    int f50119t = -1;

    /* renamed from: u, reason: collision with root package name */
    int f50120u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f50121v = -1;

    /* renamed from: w, reason: collision with root package name */
    private int f50122w = -1;

    /* renamed from: x, reason: collision with root package name */
    private float f50123x = 0.0f;

    /* renamed from: y, reason: collision with root package name */
    private float f50124y = 0.0f;

    /* renamed from: z, reason: collision with root package name */
    private float f50125z = -1.0f;
    private float A = -1.0f;
    private float B = -1.0f;
    private int C = -1;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private Runnable L = new Runnable() { // from class: com.qzone.proxy.feedcomponent.FeedEnvImpl.1
        @Override // java.lang.Runnable
        public void run() {
            w5.b.a("[PhotoAlbum]downloadPhotoAndVideo", 1, "Runnable pauseAllVideoTask");
            DownloadQueue.j().B();
        }
    };
    private Runnable M = new Runnable() { // from class: com.qzone.proxy.feedcomponent.FeedEnvImpl.2
        @Override // java.lang.Runnable
        public void run() {
            w5.b.a("[PhotoAlbum]downloadPhotoAndVideo", 1, "Runnable startDownloadVideo");
            DownloadQueue.j().f();
        }
    };
    private Handler N = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements MiniAppCmdInterface {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo;
            Throwable th5;
            byte[] bArr;
            if (com.qzone.proxy.feedcomponent.util.j.g()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onFeedElementExposure] mini app info response. isSuc : ");
                sb5.append(z16);
                sb5.append(", ret : ");
                sb5.append(jSONObject != null);
                com.qzone.proxy.feedcomponent.util.j.a("FeedEnv", 1, sb5.toString());
            }
            if (!z16 || jSONObject == null) {
                return;
            }
            try {
                bArr = (byte[]) jSONObject.opt("appInfo_pb");
                iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            } catch (Throwable th6) {
                iNTERFACE$StApiAppInfo = null;
                th5 = th6;
            }
            try {
                iNTERFACE$StApiAppInfo.mergeFrom(bArr);
            } catch (Throwable th7) {
                th5 = th7;
                QLog.e("FeedEnv", 1, "", th5);
                if (iNTERFACE$StApiAppInfo == null) {
                }
            }
            if (iNTERFACE$StApiAppInfo == null) {
                SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(iNTERFACE$StApiAppInfo));
                simpleMiniAppConfig.launchParam.scene = 2009;
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, "page_view", "expo", null, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Function0<Drawable> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements Function1<IFactoryStub, Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f50135d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VideoOptions f50136e;

        c(boolean z16, VideoOptions videoOptions) {
            this.f50135d = z16;
            this.f50136e = videoOptions;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke(IFactoryStub iFactoryStub) {
            iFactoryStub.useCache(this.f50135d);
            return iFactoryStub.fromBundle(this.f50136e.toBundle());
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f50138a;

        static {
            int[] iArr = new int[FeedElement.values().length];
            f50138a = iArr;
            try {
                iArr[FeedElement.FRIEND_PLAYING_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f50140d;

        f(Object obj) {
            this.f50140d = obj;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            u5.b.o0("qzone_video_flow_notify", false);
            dialogInterface.dismiss();
            ((l) this.f50140d).start();
        }
    }

    @Inject
    public FeedEnvImpl() {
    }

    private JSONObject U2(int i3, int i16, boolean z16, int i17, String str, boolean z17, boolean z18, int i18) {
        int i19;
        int i26 = 1;
        int i27 = this.f50111l + 1;
        this.f50111l = i27;
        int i28 = z17 ? 0 : 1;
        if (i27 <= 1 || z18) {
            try {
                i19 = com.qzone.adapter.feedcomponent.i.H().m() ? 11 : 12;
            } catch (Throwable th5) {
                com.qzone.proxy.feedcomponent.util.j.d("reportVideo", "reportVideoPlay", th5);
                return null;
            }
        } else {
            i19 = 13;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bt", i3 + "");
        jSONObject.put(FileReaderHelper.ET_EXT, i16 + "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3 > 0 ? 0 : 1);
        sb5.append("");
        jSONObject.put("bf", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        if (!z16) {
            i26 = 0;
        }
        sb6.append(i26);
        sb6.append("");
        jSONObject.put("ef", sb6.toString());
        jSONObject.put("pp", String.valueOf(i17));
        jSONObject.put("pa", i19 + "");
        jSONObject.put("ft", i18 + "");
        jSONObject.put(Constants.KEYS.PLACEMENTS, i28 + "");
        if (str != null) {
            jSONObject.put("module_id", str);
        }
        return jSONObject;
    }

    private static float W2(float f16, int i3) {
        String str;
        QzoneConfig qzoneConfig = QzoneConfig.getInstance();
        if (i3 == 2) {
            str = QzoneConfig.SECONDARY_VIDEO_MAX_SIZE_CM;
        } else {
            str = QzoneConfig.SECONDARY_PIC_MAX_SIZE_CM;
        }
        try {
            String[] split = qzoneConfig.getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, str, "12:4;10:3;0:2.5").split(";");
            for (int i16 = 0; i16 < split.length; i16++) {
                int indexOf = split[i16].indexOf(":");
                String substring = split[i16].substring(0, indexOf);
                String substring2 = split[i16].substring(indexOf + 1);
                if (f16 >= Float.parseFloat(substring)) {
                    return Float.parseFloat(substring2);
                }
            }
            return 3.0f;
        } catch (Exception unused) {
            com.qzone.proxy.feedcomponent.util.j.c("FeedEnv", "FeedEnvImpl getPicSizeCMConfig Exception");
            return 3.0f;
        }
    }

    private void X2(BusinessFeedData businessFeedData, Context context) {
        String j3 = yo.f.j(yo.f.i(yo.f.i(yo.f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FEED_YELLOW_DIAMOND, QzoneConfig.DEFAULT_FEED_YELLOW_DIAMOND_URL), "{openUin}", LoginData.getInstance().getUin()), "{openMonth}", 3L), "{openVipType}", LoginData.getInstance().getUserType()), "{aid}", "jhan_icon");
        long j16 = (businessFeedData == null || businessFeedData.getUser() == null) ? 0L : businessFeedData.getUser().uin;
        yo.d.d(V2(j16, yo.f.j(yo.f.i(j3, "{friendUin}", j16), "{qua}", QZoneHelper.getQUA())), context, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void A(int i3, int i16, int i17, long j3, BusinessFeedData businessFeedData, int i18, int i19, Map<Integer, String> map) {
        TTTReportManager.s().g(i3, i16, i17, j3, businessFeedData, i18, i19, map);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Bitmap A0(Drawable drawable, int i3, int i16) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof ImageDrawable) {
            bitmap = ((ImageDrawable) drawable).getBitmapRef().getBitmap();
        } else {
            bitmap = drawable instanceof SpecifiedBitmapDrawable ? ((SpecifiedBitmapDrawable) drawable).getBitmap() : null;
        }
        if (bitmap != null) {
            return Bitmap.createScaledBitmap(bitmap, i3, i16, true);
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public IResult A1(int i3) {
        return new QZoneResult(i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void B(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19) {
        TTTReportManager.s().k(i3, i16, i17, j3, map, businessFeedData, i18, i19);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public long B0() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public s B1(int i3) {
        return s.b(i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void C(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, Object obj, boolean z16) {
        TTTReportManager.s().m(i3, i16, i17, j3, map, businessFeedData, i18, i19, (com.qzone.misc.network.ttt.e) obj, z16);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String C0(String str) {
        com.qzone.personalize.business.a.b();
        return com.qzone.personalize.business.a.a(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void D(int i3, int i16, int i17, long j3, boolean z16) {
        TTTReportManager.s().r(i3, i16, i17, j3, z16);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Drawable D0(User user, s8.j jVar) {
        return VipComponentProxy.f50997g.getUiInterface().getStarVipIcon(user.starLevel, user.starStatus, user.isStarAnnualVip != 0, user.isHighStarVip != 0, 8, 80, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean D2(BusinessFeedData businessFeedData) {
        return com.qzone.proxy.feedcomponent.util.d.r(businessFeedData);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String E(String str) {
        return QzoneEmotionUtils.EmoCode2Text(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int E0() {
        return CoverComponentProxy.f50099g.getServiceInterface().getSuperCoverTrans(LoginData.getInstance().getUin());
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void E2(Context context, Object obj) {
        try {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficTips", "\u6d41\u91cf\u63d0\u793a");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficMessage", "\u4f60\u6b63\u5904\u4e8e\u975eWiFi\u73af\u5883\uff0c\u7ee7\u7eed\u64ad\u653e\u5c06\u4f1a\u6d88\u8017\u6d41\u91cf\uff0c\u8fd0\u8425\u5546\u53ef\u80fd\u4f1a\u6536\u53d6\u8d39\u7528\uff0c\u662f\u5426\u7ee7\u7eed");
            DialogUtil.createCustomDialog(context, 230, config, config2 + "\n", QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficContinue", "\u7ee7\u7eed"), com.qzone.util.l.a(R.string.j6l), new e(), new f(obj)).show();
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.util.j.k(th5);
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean F() {
        return true;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String F0(Paint paint, String str, int i3, int i16) {
        return x5.b.c(paint, str, i3, i16);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void F1(String str, String str2, boolean z16, String str3, IServiceCallback iServiceCallback) {
        DressBirthdayGiftHandler.b(str, str2, z16, str3, iServiceCallback);
        LpReportInfo_pf00064.allReport(619, 17, 2);
        new com.qzone.proxy.feedcomponent.handler.a().a("1", "dressing", "4", 102);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void F2() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.L);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.M);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.M, 2000L);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void G(final BusinessFeedData businessFeedData, final User user) {
        FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.proxy.feedcomponent.FeedEnvImpl.8
            @Override // java.lang.Runnable
            public void run() {
                BaseFeedClickProcessor.C(businessFeedData, user, false);
            }
        });
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public List<String> G0(String str) {
        List<IPInfo> provideVideoIPList = StrategyProvider.provideVideoIPList(str);
        if (provideVideoIPList == null || provideVideoIPList.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<IPInfo> it = provideVideoIPList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f99897ip);
        }
        return arrayList;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void G1(String str) {
        Activity topActivity = ProcessUtils.getTopActivity();
        if (topActivity == null) {
            return;
        }
        yo.d.d(str, topActivity, null);
        LpReportInfo_pf00064.allReport(619, 17, 3);
        new com.qzone.proxy.feedcomponent.handler.a().a("2", "more", "4", 102);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void G2() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.M);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.L);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.L, 1000L);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public com.qzone.proxy.feedcomponent.model.s H0() {
        int int4Uin = LocalMultiProcConfig.getInt4Uin("qzone_vertical_video_display_type", -1, LoginData.getInstance().getUin());
        int int4Uin2 = LocalMultiProcConfig.getInt4Uin("qzone_vertical_video_display_ratio", -1, LoginData.getInstance().getUin());
        int int4Uin3 = LocalMultiProcConfig.getInt4Uin("qzone_vertical_video_display_width", -1, LoginData.getInstance().getUin());
        int int4Uin4 = LocalMultiProcConfig.getInt4Uin("qzone_vertical_video_display_height", -1, LoginData.getInstance().getUin());
        w5.b.a("VerticalVideoData", 1, "getVerticalVideoinfo, type = " + int4Uin + ", ratio = " + int4Uin2 + ", width = " + int4Uin3 + ", height = " + int4Uin4);
        return new com.qzone.proxy.feedcomponent.model.s(int4Uin, int4Uin2, int4Uin3, int4Uin4);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Object I(CellPictureInfo cellPictureInfo, int i3) {
        ViewFeedPhotoData viewFeedPhotoData = new ViewFeedPhotoData();
        viewFeedPhotoData.pictureInfo = cellPictureInfo;
        viewFeedPhotoData.curIndex = i3;
        viewFeedPhotoData.photoSource = ViewFeedPhotoData.FROM_COMMENT;
        return viewFeedPhotoData;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public VideoInfo I0(String str) {
        return com.qzone.util.j.b().a(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void I1(FeedElement feedElement, int i3, Object obj) {
        int i16;
        if (d.f50138a[feedElement.ordinal()] == 1 && (obj instanceof String)) {
            String str = (String) obj;
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppFakeUrl(str)) {
                i16 = 0;
            } else {
                i16 = ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppScheme(str) ? 2 : -1;
            }
            if (i16 >= 0) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).getAppInfoByLink(str, i16, new a());
            }
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void I2(String str) {
        PerfTracer.traceEnd(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public float J0() {
        float f16 = this.f50124y;
        if (f16 > 0.0f) {
            return f16;
        }
        float W2 = W2((float) FeedGlobalEnv.g().getScreenSizeCM(), 2);
        this.f50124y = W2;
        return W2;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void J1(int i3) {
        wo.a.b(i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void J2(String str) {
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).stopStep(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Drawable K(String str, boolean z16) {
        VideoOptions videoOptions = new VideoOptions();
        videoOptions.setFilePath(str);
        videoOptions.setNeedThumbnail(true);
        videoOptions.setVideoType(1);
        videoOptions.setLoop(z16);
        return GLDrawableApi.asyncFactory(new b(), new c(z16, videoOptions));
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public float K0(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.feedType == 2) {
            if (this.A < 0.0f) {
                this.A = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MEDIAFRAME, QzoneConfig.SECONDARY_VIDEO_HEIGHT_RATE_DETAIL, 1.35f);
            }
            return this.A;
        }
        if (this.B < 0.0f) {
            this.B = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MEDIAFRAME, QzoneConfig.SECONDARY_VIDEO_HEIGHT_RATE, 0.75f);
        }
        return this.B;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void K1(Context context, BusinessFeedData businessFeedData, boolean z16) {
        cooperation.vip.vipcomponent.util.c.h(context, businessFeedData.getUser().personalizedYellowVipUrl);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void K2(String str) {
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).startStep(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public AppRuntime L() {
        try {
            return BaseApplicationImpl.getApplication().getRuntime();
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.util.j.d("FeedEnv", "getAppRuntime error!", th5);
            return null;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public float L0() {
        if (this.f50125z < 0.0f) {
            this.f50125z = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MEDIAFRAME, QzoneConfig.SECONDARY_VIDEO_WIDTH_RATE, 1.0f);
        }
        return this.f50125z;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void L1(Context context, BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData.getUser().personalizedPassivePraiseId != -1) {
            QzoneZipDownloadService.k().h(businessFeedData.getUser().personalizedPassivePraiseUrl, 0, null);
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void L2(String str) {
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).stopStep(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String M(long j3, String str) {
        File file = CacheManager.getAudioFileCacheService().getFile(j3 + "_" + str, true);
        if (file == null) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Drawable M0(User user, s8.j jVar) {
        return VipComponentProxy.f50997g.getUiInterface().getYellowVipIcon(user.vipLevel, user.vip, user.isAnnualVip != 0, user.isCustomDiamond, user.customDiamondUrl, 8, 80, user.personalizedYellowVipUrl, null, user.customType);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void M1(BusinessFeedData businessFeedData) {
        GdtPreLoadOfflineHelper.d(businessFeedData);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void M2(String str) {
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).startStep(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String N() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_BIZ, QzoneConfig.SECONDARY_FEED_AVATAR_ICON, "https://qzonestyle.gtimg.cn/aoi/sola/20160927200549_Hvym3559Ls.png");
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String N0(String str) {
        return WeishiHelper.getWeiIconText(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void N1(Context context, BusinessFeedData businessFeedData, boolean z16) {
        QzoneCustomTrackData qzoneCustomTrackData;
        CellFunnyTreadSpace cellFunnyTreadSpace = businessFeedData.getCellFunnyTreadSpace();
        if (cellFunnyTreadSpace == null || (qzoneCustomTrackData = cellFunnyTreadSpace.ugcCustomTrack) == null) {
            return;
        }
        d7.b.a(qzoneCustomTrackData);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void N2(String str) {
        PerfTracer.traceStart(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void O1(String str, VideoInfo videoInfo) {
        com.qzone.util.j.b().d(str, videoInfo);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void O2(User user) {
        s8.d.a(user);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String P(Long l3) {
        if (l3.longValue() <= 0) {
            return null;
        }
        return "avatar://" + l3;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean P2() {
        return QZoneFeedUtil.T();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int Q() {
        return AreaConst.commentWidth_Rec;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public IObserver Q0(com.qzone.proxy.feedcomponent.manager.e eVar) {
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void Q1(String str) {
        com.qzone.util.j.b().e(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void Q2(int i3, int i16, int i17, BusinessFeedData businessFeedData) {
        WeishiHelper.reportWeiShiPicMediaView(i3, i16, i17, businessFeedData);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public float R(String str, String str2, float f16) {
        return QzoneConfig.getInstance().getConfig(str, str2, f16);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean R1(BusinessFeedData businessFeedData, int i3) {
        return true;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void R2(String str) {
        c.a aVar = new c.a();
        aVar.f315003a = str;
        aVar.f315004b = "GET";
        aVar.f315007e = "application/x-www-form-urlencoded";
        com.tencent.mobileqq.webview.webso.c.c().h(aVar, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int S(String str, String str2, int i3) {
        return QzoneConfig.getInstance().getConfig(str, str2, i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean S0() {
        return false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void S1(BusinessFeedData businessFeedData, boolean z16) {
        QZoneWriteOperationService.v0().d2(businessFeedData.getOperationInfoV2().cookie, z16, businessFeedData);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void S2(String str, String str2, byte[] bArr, DittoHost.SilentRequestCallback silentRequestCallback) {
        QZoneWriteOperationService.v0().q2(this.N, str, str2, bArr, silentRequestCallback);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String T(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void T1(final int i3, final BusinessFeedData businessFeedData) {
        FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.proxy.feedcomponent.FeedEnvImpl.3
            @Override // java.lang.Runnable
            public void run() {
                BusinessFeedData businessFeedData2 = businessFeedData;
                if (businessFeedData2 == null || businessFeedData2.getFeedCommInfo() == null || businessFeedData.getOperationInfo() == null || businessFeedData.getOperationInfo().hasReportExposure != 0) {
                    return;
                }
                businessFeedData.getOperationInfo().hasReportExposure = 1;
                long j3 = businessFeedData.getFeedCommInfo().recomreportid;
                if (j3 <= 0) {
                    return;
                }
                ClickReport.r("", "", "", true, String.valueOf(j3), String.valueOf(i3 + 1), String.valueOf(8), "0", "");
            }
        });
    }

    public boolean T2(boolean z16, boolean z17, boolean z18, boolean z19) {
        int s16 = BaseFeedFragmentFeedImp.s();
        if (s16 == 2) {
            return false;
        }
        if (s16 != 0 || NetworkState.isWifiConn()) {
            return true;
        }
        if (z16) {
            return false;
        }
        if (z17) {
            com.qzone.proxy.feedcomponent.util.j.f("FeedEnv", "network change to mobile!");
            return false;
        }
        if (this.f50121v == -1) {
            this.f50121v = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_VIDEO_AUTO_PLAY_KEY, 2);
        }
        if (this.f50121v != 2) {
            return false;
        }
        if (z18 && !z19) {
            com.qzone.proxy.feedcomponent.util.j.f("FeedEnv", String.format("isWeishiTabEntranceType=%b,hasCustomerClickPlayIcon=%b", Boolean.valueOf(z18), Boolean.valueOf(z19)));
            return false;
        }
        return true;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean U(String str, String str2, boolean z16) {
        return QzoneConfig.getInstance().getConfig(str, str2, z16);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean U0(PicText picText) {
        SongInfo songInfo;
        String str;
        String str2;
        e.a currentState = e8.f.a().b().getCurrentState();
        return (picText == null || currentState == null || (songInfo = currentState.f395852b) == null || (str = picText.title) == null || !str.equals(songInfo.f251871i) || (str2 = picText.playurl) == null || !str2.equals(currentState.f395852b.f251870h) || currentState.f395854d != 2) ? false : true;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void U1(int i3, String str) {
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = "456";
        if (i3 == 0) {
            reportInfo.subactionType = "1";
        } else if (i3 == 1) {
            reportInfo.subactionType = "2";
        } else if (i3 == 2) {
            reportInfo.subactionType = "3";
        } else if (i3 == 3) {
            reportInfo.subactionType = "4";
        } else if (i3 != 4) {
            reportInfo.subactionType = "-1";
        } else {
            reportInfo.subactionType = "5";
        }
        reportInfo.reserves = str;
        ClickReport.u(reportInfo);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean V() {
        return ImageManagerEnv.g().getCurrentLoadingImgStatus();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean V0() {
        return true;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int W() {
        return BaseFeedFragmentFeedImp.q();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean W0() {
        return QZoneBaseFeedFragment.f45229i1;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String X() {
        return f8.a.b();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean X0() {
        return false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void X1(String str, String str2, String str3, int i3, String str4) {
        ClickReport.o(str, str2, str3, str4);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int Y() {
        return QZoneHelper.getDevicePerformanceLevel();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean Y0(String str) {
        return com.qzone.publish.business.publishqueue.f.d().h(str) != null;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void Y1(String str, String str2, String str3, boolean z16) {
        ClickReport.q(str, str2, str3, z16);
    }

    public void Y2(boolean z16) {
        this.J = z16;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public long Z() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FAKE_FEED_INVALID_TIME, 30) * 60 * 1000;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean Z0(long j3) {
        String string = LocalMultiProcConfig.getString("qzone_soft_infos", "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        JceInputStream jceInputStream = new JceInputStream(PluginBaseInfoHelper.Base64Helper.decode(string, 0));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new stSoftInfo());
        ArrayList arrayList2 = (ArrayList) jceInputStream.readArray((List) arrayList, 1, false);
        if (arrayList2 == null || arrayList2.size() == 0) {
            return false;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            stSoftInfo stsoftinfo = (stSoftInfo) it.next();
            if (stsoftinfo.soft_type == 1) {
                return j3 >= stsoftinfo.start_time && j3 <= stsoftinfo.end_time;
            }
        }
        return false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void Z1(String str, String str2) {
        try {
            LpReportInfo_dc00321.report(SafeUtil.toInt("18"), SafeUtil.toInt(str), SafeUtil.toInt(str2), com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.util.j.d("FeedEnv", e16.getMessage(), e16);
        }
    }

    public void Z2() {
        if (com.qzone.proxy.feedcomponent.b.g()) {
            com.qzone.proxy.feedcomponent.b.e("FeedEnv", "[updateQZoneTheme] update qzone theme....");
        }
        this.D = com.qzone.reborn.util.k.f59549a.b();
        this.E = QQTheme.isNowSimpleUI();
        this.F = com.tencent.mobileqq.simpleui.b.c();
        this.G = StudyModeManager.t();
        this.H = false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Drawable a0() {
        if (O == null) {
            O = com.qzone.adapter.feedcomponent.j.g(711);
        }
        return O;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void a2(int i3) {
        com.qzone.adapter.feedcomponent.i.H().W1("30", "6", com.qzone.misc.network.report.d.b(i3));
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String b(String str) {
        return QzoneEmotionUtils.EmoCode2Text(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String b0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FEED_PIC_TEXT_CARD_VIEW, QzoneConfig.SECONDARY_KEY_FEED_PIC_TEXT_CARD_VIEW_PHOTO_ARROW, "https://qzonestyle.gtimg.cn/aoi/sola/20170111110924_IJUrPfre4v.png");
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void b2(ArrayList<Map<String, String>> arrayList, Handler handler) {
        REPORT_INFO report_info = new REPORT_INFO(19, arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(report_info);
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GdtDcReportRequest(arrayList2, 33), handler, null, 19));
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean c0() {
        return P;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void c2(final long j3, final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.FeedEnvImpl.9
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("time", String.valueOf(j3));
                hashMap.put("show_type", str);
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "qzone_image_loading_cost", true, j3, 0L, hashMap, null);
            }
        });
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int d0() {
        if (this.f50122w == -1) {
            this.f50122w = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SETTING_FEEDS_SINGLE_PICTURE_BIG_PICTURE_MODE_COEFFICIENT, 2);
        }
        return this.f50122w;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean d1() {
        return com.qzone.personalize.business.a.b().d();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Rect e0() {
        return QzoneConfig.getInstance().getGifDisplayConfig();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean e1() {
        return false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void e2(String str, Properties properties, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (properties != null && properties.size() > 0) {
            for (Map.Entry entry : properties.entrySet()) {
                hashMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), str, true, i3, 0L, hashMap, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void f(int i3, int i16, int i17) {
        LpReportInfo_pf00064.allReport(i3, i16, i17);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int f0(int i3) {
        return com.qzone.feed.utils.h.c(i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean f1() {
        return QZoneFeedUtil.f47424d > -1;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void f2(int i3, int i16, int i17, String str) {
        LpReportInfo_pf00064.allReport(i3, i16, i17, str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void g(int i3, int i16, int i17, String str, String str2, String str3) {
        LpReportInfo_pf00064.allReport(i3, i16, i17, str, str2, str3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Object[] g0(s_join_list s_join_listVar) {
        return x5.b.a(s_join_listVar);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean g1() {
        return ImageEnvImpl.isListViewScrollIdle();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void h(int i3, int i16, int i17, String str, String str2, String str3, long j3) {
        LpReportInfo_pf00064.allReport(i3, i16, i17, str, str2, str3, j3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int h0(int i3) {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_FEED_AUTO_PLAY_DELAY_TIMES, i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean h1() {
        if (this.f50117r == -1) {
            this.f50116q = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_IS_LIVEVIDEO_NEW_MODE, 1) == 1;
        }
        return this.f50116q;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void h2() {
        ClickReport.m(PersonalityConfig.ACTION_TYPE_STAR_VIP, "3", "1");
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public com.qzone.proxy.feedcomponent.widget.c i0(String str, String str2, Context context) {
        return new to.d(str, str2, context);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean i1() {
        return QZoneFeedUtil.P();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void i2(Context context, boolean z16, String str, int i3, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", str);
        hashMap.put("retCode", String.valueOf(i3));
        hashMap.put("subRetCode", String.valueOf(i16));
        StatisticCollector.getInstance(context).collectPerformance(LoginData.getInstance().getUinString(), "video_cgi_access_ret", z16, 0L, 0L, hashMap, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String j(CellPictureInfo cellPictureInfo) {
        return com.qzone.proxy.feedcomponent.util.d.c(cellPictureInfo);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public long j0() {
        return LoginData.getInstance().getUin();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean j1() {
        return QZoneFeedUtil.Q();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void j2(int i3, int i16, int i17) {
        try {
            LpReportInfo_dc00321.report(i3, i16, i17, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.util.j.d("FeedEnv", e16.getMessage(), e16);
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean k() {
        return BaseFeedFragmentFeedImp.w() && Y() >= 2;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String k0() {
        return LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.mgh));
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean k1() {
        return QZoneFeedUtil.S();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void k2(BusinessFeedData businessFeedData, int i3, int i16, int i17) {
        ap.f59791b.e(i16, i17, i3, businessFeedData);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean l() {
        return false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean l1() {
        return NetworkState.isNetSupport();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String m0(String str) {
        return VipComponentProxy.f50997g.getServiceInterface().getLoveVipIconPicUrl(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean m1() {
        try {
            return PhotoUtils.isNewPicRule();
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.util.j.d("FeedEnv", "[isNewPicRule] error: ", th5);
            return false;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public StringBuilder n(StringBuilder sb5) {
        return x.b(sb5);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String n0(User user) {
        return QZoneConfigHelper.T();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean n1(AppRuntime appRuntime) {
        if (this.H) {
            return this.I;
        }
        this.H = true;
        boolean c16 = com.tencent.mobileqq.activity.leba.utils.a.c(appRuntime);
        this.I = c16;
        return c16;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void o(Context context, BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getUser() != null) {
            VipComponentProxy vipComponentProxy = VipComponentProxy.f50997g;
            if (vipComponentProxy.getServiceInterface().isShowEventLoveVipIcon(businessFeedData.getUser().uin + "")) {
                yo.d.d(vipComponentProxy.getServiceInterface().getLoveVipIconJumpUrl(businessFeedData.getUser().uin + ""), context, null);
            } else {
                yo.d.p(context, yo.f.j(com.qzone.adapter.feedcomponent.i.H().n0(businessFeedData.getUser()), "{entranceId}", "6"), -1, null, null, null);
            }
        }
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        if (1 == businessFeedData.getFeedCommInfo().feedsType) {
            ClickReport.q("303", "7", "2", true);
            return;
        }
        int i3 = businessFeedData.feedType;
        if (3 == i3) {
            ClickReport.q("308", "62", "", true);
            return;
        }
        if (4097 == i3) {
            ClickReport.q("302", "63", "", true);
        } else if (4099 == i3) {
            ClickReport.q("6", "1", "1", true);
        } else if (2 == i3) {
            ClickReport.q("304", "9", "", true);
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean o0() {
        if (this.C == -1) {
            this.C = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NEED_DRAWABLE_RECYCLED, 1);
        }
        return this.C == 1;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean o1() {
        return this.J;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void o2(Context context, boolean z16, String str, String str2, int i3, int i16, int i17, int i18) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", str);
        hashMap.put("what", String.valueOf(i3));
        hashMap.put("extra", String.valueOf(i16));
        hashMap.put("videoType", String.valueOf(i17));
        hashMap.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, String.valueOf(i18));
        StatisticCollector.getInstance(context).collectPerformance(LoginData.getInstance().getUinString(), "qzone_video_success_rate", z16, 0L, 0L, hashMap, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void p(Context context) {
        ClickReport.m(PersonalityConfig.ACTION_TYPE_STAR_VIP, "3", "2");
        QZoneVIPUtils.a(context, "jhan_xzfeed");
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String p0() {
        return "";
    }

    @Override // com.qzone.adapter.feedcomponent.i
    @Deprecated
    public boolean p1() {
        if (!this.K) {
            Z2();
            this.K = true;
        }
        return this.D;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void p2(BusinessFeedData businessFeedData) {
        QzoneFeedVisitorReportService.f().e(businessFeedData, 0);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public HashSet<String> q0() {
        return ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).getReportIdSet();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void q2(int i3, int i16, int i17, String str) {
        WeishiHelper.reportWeishiVideoExposure(i3, i16, i17, str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public float r0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MEDIAFRAME, QzoneConfig.SECONDARY_PIC_HEIGHT_RATE, 0.75f);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean r1() {
        return BaseFeedFragmentFeedImp.q() == 0;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void r2(final BusinessFeedData businessFeedData) {
        FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.proxy.feedcomponent.FeedEnvImpl.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                boolean z16 = businessFeedData != null && LoginData.getInstance().getUin() == businessFeedData.getUser().uin;
                BusinessFeedData businessFeedData2 = businessFeedData;
                String str2 = "6";
                if (businessFeedData2 != null && businessFeedData2.getFeedCommInfo() != null && businessFeedData.isQQUnionVip()) {
                    int i3 = businessFeedData.getFeedCommInfo().feedsType;
                    if (i3 == 2) {
                        str = "8";
                    } else if (i3 == 3) {
                        if (z16) {
                            str2 = "5";
                        }
                        str = str2;
                    } else if (i3 != 4099) {
                        str = "4";
                    } else {
                        str = "7";
                    }
                    ClickReport.j(LoginData.getInstance().getUin(), "", "", "", true, "124", "1", str);
                    return;
                }
                BusinessFeedData businessFeedData3 = businessFeedData;
                if (businessFeedData3 != null) {
                    int i16 = businessFeedData3.getFeedCommInfo().feedsType;
                    boolean isEmpty = TextUtils.isEmpty(businessFeedData.getCellUserInfo().getUser().personalizedYellowVipUrl);
                    if (1 == i16) {
                        if (isEmpty) {
                            ClickReport.o("303", "6", "1", "gx");
                            return;
                        } else {
                            ClickReport.o("303", "6", "1", "pt");
                            return;
                        }
                    }
                    if (isEmpty) {
                        ClickReport.o("328", "14", "1", "gx");
                    } else {
                        ClickReport.o("328", "14", "1", "pt");
                    }
                }
            }
        });
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void s(String str) {
        am.a(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public float s0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MEDIAFRAME, QzoneConfig.SECONDARY_PIC_WIDTH_RATE, 1.0f);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean s1() {
        return BaseFeedFragmentFeedImp.q() == 1;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void s2(String str) {
        com.qzone.commoncode.module.gdt.a.b(str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public <T extends JceStruct> T t(T t16, byte[] bArr) {
        return (T) t5.b.a(t16, bArr);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public long t0() {
        return e8.f.f395866f;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean t1(Context context) {
        return false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void t2(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            com.tencent.gdt.tangram.ad.qzone.a.b().f108410a = new yl0.i((int) motionEvent.getX(), (int) motionEvent.getY(), System.currentTimeMillis());
        } else {
            if (action != 1) {
                return;
            }
            com.tencent.gdt.tangram.ad.qzone.a.b().f108411b = new yl0.i((int) motionEvent.getX(), (int) motionEvent.getY(), System.currentTimeMillis());
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public <T extends JceStruct> T u(Class<T> cls, byte[] bArr) {
        return (T) t5.b.b(cls, bArr);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String u0() {
        return e8.f.f395867g;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void u2(Context context, boolean z16) {
        QZoneTopGestureLayout.setBackEnabled(z16);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void v(String str, long j3, HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, true, j3, 0L, hashMap, "");
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public List<String> v0() {
        CopyOnWriteArrayList<IQueueTask> a16 = QZonePublishQueue.w().a();
        if (a16 == null || a16.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (int i3 = 0; i3 < a16.size(); i3++) {
            IQueueTask iQueueTask = a16.get(i3);
            if (iQueueTask != null && !TextUtils.isEmpty(iQueueTask.getClientKey())) {
                arrayList.add(iQueueTask.getClientKey());
            }
        }
        return arrayList;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean v1() {
        if (!this.K) {
            Z2();
            this.K = true;
        }
        return this.F;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void w(String str, int i3, int i16, int i17, BusinessFeedData businessFeedData, int i18) {
        com.qzone.misc.network.ttt.a.c().a(str, i3, i16, i17, businessFeedData, i18);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean w1() {
        if (!this.K) {
            Z2();
            this.K = true;
        }
        return this.G;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void w2(boolean z16) {
        P = z16;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void x(String str, int i3, int i16, int i17, BusinessFeedData businessFeedData, int i18, long j3) {
        com.qzone.misc.network.ttt.a.c().b(str, i3, i16, i17, businessFeedData, i18, j3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int x0(int i3) {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MEDIAFRAME, QzoneConfig.SECONDARY_REDPOCKET_HEIGHT, i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void x1(String str, boolean z16, long j3) {
        GdtImageHandler.c().d(LoginData.getInstance().getUinString(), str, z16, j3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void x2(boolean z16) {
        QZoneTopGestureLayout.shouldInterceptEvent(z16);
        QZonePullToRefreshListView.setGlobalGestureEnable(z16);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void y(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19) {
        TTTReportManager.s().p(i3, i16, i17, j3, map, businessFeedData, i18, i19, true);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public int y0(int i3) {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MEDIAFRAME, QzoneConfig.SECONDARY_REDPOCKET_WIDTH, i3);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public m y1(Class cls, long j3, String str) {
        return s8.a.q(cls, j3, str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public n z1() {
        return t8.a.d();
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void C1() {
        this.K = false;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void H2(String str, BusinessFeedData businessFeedData, Context context) {
        yo.d.d(str, context, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void W1(String str, String str2, String str3) {
        Y1(str, str2, str3, false);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public Drawable i(Drawable drawable) {
        try {
            Bitmap bitmap = com.qzone.reborn.util.h.a(new uo.a(30).process(drawable)).getBitmap();
            if (bitmap == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.copy(Bitmap.Config.ARGB_8888, true));
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColor(-1476395008);
            paint.setAlpha(172);
            canvas.drawRect(0.0f, 0.0f, r10.getWidth(), r10.getHeight(), paint);
            canvas.save();
            canvas.restore();
            return new BitmapDrawable(createBitmap);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void g2(int i3, List<PicText> list, BusinessFeedData businessFeedData) {
        PicText picText;
        String num;
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        if ((businessFeedData.getFeedCommInfo().feedsAttr & 8388608) <= 0) {
            if (list == null || (picText = list.get(i3)) == null) {
                return;
            }
            ClickReport.s("", "", Uri.parse(picText.actionUrl).getQueryParameter("refer") + "_" + i3, 302, 28, 2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("report_posi_way", "1");
        if (i3 == 0) {
            num = Integer.toString(2);
        } else {
            num = Integer.toString(3);
        }
        hashMap.put("report_posi", num);
        if (businessFeedData.getOperationInfo() != null && businessFeedData.getOperationInfo().busiParam != null) {
            String str = businessFeedData.getOperationInfo().busiParam.get(77);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("extend_report_info", str);
            }
        }
        ClickReport.g(0, hashMap, true);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean m() {
        return T2(true, false, false, false);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public QQUnionIconInfo w0(int i3, Map<String, QQUnionIconInfo> map) {
        return cooperation.vip.vipcomponent.util.c.g(8, i3, map);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void a(BusinessFeedData businessFeedData) {
        String str;
        String str2;
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo().needAdvReport()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gdtfeed_title==");
            String str3 = "";
            if (TextUtils.isEmpty(businessFeedData.getUser().nickName)) {
                str = "";
            } else {
                str = businessFeedData.getUser().nickName;
            }
            stringBuffer.append(str);
            stringBuffer.append("\n");
            CellActiveAdv activeAdv = businessFeedData.getActiveAdv();
            stringBuffer.append("gdtfeed_content==");
            if (TextUtils.isEmpty(businessFeedData.getCellSummary().summary)) {
                str2 = "";
            } else {
                str2 = businessFeedData.getCellSummary().summary;
            }
            if (activeAdv != null && !TextUtils.isEmpty(activeAdv.copy)) {
                str2 = activeAdv.copy;
            }
            stringBuffer.append(str2);
            stringBuffer.append("\n");
            stringBuffer.append("gdtfeed_picurl==");
            if (businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() > 0 && !TextUtils.isEmpty(businessFeedData.getPictureInfo().pics.get(0).currentUrl.url)) {
                str3 = businessFeedData.getPictureInfo().pics.get(0).currentUrl.url;
            }
            if (activeAdv != null && (pictureItem = activeAdv.picData) != null && (pictureUrl = pictureItem.currentUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
                str3 = activeAdv.picData.currentUrl.url;
            }
            stringBuffer.append(str3);
            stringBuffer.append("\n");
            stringBuffer.append("gdtfeed_jump_url==");
            if (!TextUtils.isEmpty(businessFeedData.getOperationInfo().downloadUrl)) {
                stringBuffer.append(businessFeedData.getOperationInfo().downloadUrl + "\n");
            }
            if (!TextUtils.isEmpty(businessFeedData.getOperationInfo().actionUrl)) {
                stringBuffer.append(businessFeedData.getOperationInfo().actionUrl + "\n");
            }
            stringBuffer.append("gdtfeed_report_url==");
            if (businessFeedData.getOperationInfo().cookie != null && !TextUtils.isEmpty(businessFeedData.getOperationInfo().cookie.get(1))) {
                stringBuffer.append(businessFeedData.getOperationInfo().cookie.get(1) + "\n");
            } else {
                stringBuffer.append("\n");
            }
            stringBuffer.append("gdtfeed_feedskey==");
            stringBuffer.append(businessFeedData.getFeedCommInfo().feedskey + "\n");
            stringBuffer.append("gdtfeed_reqTime==");
            stringBuffer.append(businessFeedData.getFeedCommInfo().time + "\n");
            stringBuffer.append("gdtfeed_remark==");
            if (businessFeedData.getRecommAction() != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().remark)) {
                stringBuffer.append(businessFeedData.getRecommAction().remark + "\n");
            } else {
                stringBuffer.append("\n");
            }
            stringBuffer.append("gdtfeed_buttontype==");
            if (businessFeedData.getRecommAction() != null) {
                stringBuffer.append(businessFeedData.getRecommAction().btnType);
            }
            stringBuffer.append("\n");
            CellRecommHeader recommHeader = businessFeedData.getRecommHeader();
            stringBuffer.append("gdtfeed_head_icon==");
            if (recommHeader != null && !TextUtils.isEmpty(recommHeader.customIconUrl)) {
                stringBuffer.append(recommHeader.customIconUrl);
            }
            stringBuffer.append("\n");
            stringBuffer.append("gdtfeed_head_text==");
            if (recommHeader != null && !TextUtils.isEmpty(recommHeader.leftTitle)) {
                stringBuffer.append(recommHeader.leftTitle);
            }
            stringBuffer.append("\n");
            stringBuffer.append("gdtfeed_logo==");
            if (businessFeedData.getUser() != null) {
                stringBuffer.append(businessFeedData.getUser().logo);
            }
            stringBuffer.append("\n");
            stringBuffer.append("gdtfeed_ztyw_uptext==");
            if (businessFeedData.getActiveAdv() != null && !TextUtils.isEmpty(businessFeedData.getActiveAdv().upCopy)) {
                stringBuffer.append(businessFeedData.getActiveAdv().upCopy);
            }
            stringBuffer.append("\n");
            if (businessFeedData.getFeedCommInfo().isNeedInstalledFilter()) {
                boolean a16 = SystemTools.a(BaseApplication.getContext(), businessFeedData.getOperationInfo().appid);
                businessFeedData.getFeedCommInfo().isInstalled = a16;
                if (a16) {
                    QZoneWriteOperationService.v0().L(businessFeedData.getOperationInfo().cookie, 0, 0, 0, 0, 0, false, true, null, null, 0L, false, false, null, false, businessFeedData);
                }
            }
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void c(BusinessFeedData businessFeedData, int i3) {
        if (i3 != 3 || businessFeedData.getAudioInfo() == null) {
            return;
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(QZoneClickReport.ClickReportConfig.ACTION_TYPE_TEMPLATE_SHUOSHUO_FEED, "2", businessFeedData.feedType == 2 ? 2 : 1, null, null), false, false);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void d2(int i3) {
        if (1 == i3) {
            ClickReport.m("303", "6", "2");
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void H1(String str, QZoneFakeFeedStatus qZoneFakeFeedStatus) {
        if (qZoneFakeFeedStatus == null || str == null) {
            return;
        }
        QLog.d("FeedEnv", 1, "onDeleteFakeFeed fakeFeedStatus:" + qZoneFakeFeedStatus);
        eo.d.b(new WinkPublishQualityReportData.Builder().eventId(eo.d.f396887g).ext1(str).ext2(qZoneFakeFeedStatus.name()).ext4(eo.d.f396889i).getReportData());
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public boolean u1(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.getFeedCommInfo().appid == 422;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void D1() {
        LpReportInfo_pf00064.allReport(619, 17, 1);
        new com.qzone.proxy.feedcomponent.handler.a().a("", "", "", 101);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void E1() {
        LpReportInfo_pf00064.allReport(619, 17, 4);
        new com.qzone.proxy.feedcomponent.handler.a().a("3", "close", "4", 102);
    }

    private String V2(long j3, String str) {
        return (j3 != 0 && j3 == LoginData.getInstance().getUin() && VasNormalToggle.VAS_QZONE_NAMEPLATE_HOME_URL_SWITCH.isEnable(true)) ? QzoneConfig.DEFAULT_MY_VIP_NALEPLATE_HOME_URL : str;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String O(long j3, short s16, String str) {
        if (j3 <= 0) {
            return null;
        }
        return "avatar://" + j3;
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public String l0(long j3) {
        z5.a f16;
        x6.a g16;
        if (j3 > 0 && (f16 = z5.a.f()) != null && (g16 = f16.g(j3)) != null) {
            if (g16.isLoverZoneUser) {
                return "1";
            }
            return "2";
        }
        return "";
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void q(Context context, BusinessFeedData businessFeedData) {
        String str;
        String str2;
        boolean z16 = businessFeedData != null && LoginData.getInstance().getUin() == businessFeedData.getUser().uin;
        String str3 = "7";
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.isQQUnionVip()) {
            int i3 = businessFeedData.getFeedCommInfo().feedsType;
            if (i3 == 2) {
                str3 = "8";
            } else if (i3 == 3) {
                if (z16) {
                    str2 = "5";
                } else {
                    str2 = "6";
                }
                str3 = str2;
            } else if (i3 != 4099) {
                str3 = "4";
            }
            ClickReport.j(LoginData.getInstance().getUin(), "", "", "", true, "124", "2", str3);
        } else if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null && 1 == businessFeedData.getFeedCommInfo().feedsType) {
            if (businessFeedData.getUser() != null && businessFeedData.getUser().personalizedYellowVipUrl != null && !businessFeedData.getUser().isCustomDiamond) {
                ClickReport.j(LoginData.getInstance().getUin(), "", "", "", true, "303", "7", "1", "gx");
            } else {
                ClickReport.j(LoginData.getInstance().getUin(), "", "", "", true, "303", "7", "1", "pt");
            }
        } else if (businessFeedData != null && businessFeedData.getUser() != null && businessFeedData.getUser().personalizedYellowVipUrl != null) {
            ClickReport.o("328", "14", "2", "gx");
        } else {
            ClickReport.o("328", "14", "2", "pt");
        }
        if (businessFeedData != null && businessFeedData.isQQNewVip()) {
            X2(businessFeedData, context);
            return;
        }
        if (businessFeedData != null && businessFeedData.isQQUnionVip()) {
            yo.d.d(V2(businessFeedData.getUser() != null ? businessFeedData.getUser().uin : 0L, yo.f.j(yo.f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_HOME_URL, QzoneConfig.DEFAULT_UNION_VIP_HOME_URL), "{aid}", 0L), "{qua}", QZoneHelper.getQUA())), context, null);
            return;
        }
        if (businessFeedData != null && businessFeedData.getUser() != null && !TextUtils.isEmpty(businessFeedData.getUser().personalizedYellowVipUrl) && !businessFeedData.getUser().isCustomDiamond) {
            if (LoginData.getInstance().getUin() == businessFeedData.getUser().uin) {
                str = businessFeedData.getUser().hostCustomIconUrl;
            } else {
                str = businessFeedData.getUser().guestCustomIconUrl;
            }
            com.qzone.proxy.feedcomponent.b.e("FeedEnv", "@vipIcon url =" + str);
            vo.c.P(context, str, businessFeedData.getUser().uin);
            return;
        }
        X2(businessFeedData, context);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void z0(String str, String str2, String str3, String str4, com.tencent.mobileqq.qzoneplayer.video.i iVar) {
        PlayerUtils.log(4, "FeedEnv", "request safe vid = " + str2 + ", url = " + str);
        if (TextUtils.isEmpty(str2) || str2.length() <= 0) {
            return;
        }
        if (TencentVideoModule.f50269m.containsKey(str2)) {
            Pair<Long, SegmentVideoInfo.StreamInfo> pair = TencentVideoModule.f50269m.get(str2);
            String[] strArr = TencentVideoModule.f50270n.containsKey(str2) ? TencentVideoModule.f50270n.get(str2) : null;
            boolean booleanValue = TencentVideoModule.f50271o.containsKey(str2) ? TencentVideoModule.f50271o.get(str2).booleanValue() : false;
            int intValue = TencentVideoModule.f50272p.containsKey(str2) ? TencentVideoModule.f50272p.get(str2).intValue() : 0;
            boolean booleanValue2 = TencentVideoModule.f50273q.containsKey(str2) ? TencentVideoModule.f50273q.get(str2).booleanValue() : false;
            if (Long.valueOf(System.currentTimeMillis()).longValue() - pair.first.longValue() < 900000) {
                if (iVar != null) {
                    iVar.b(str, true, pair.second, strArr, booleanValue, intValue, booleanValue2);
                    return;
                }
                return;
            } else {
                TencentVideoModule.f50269m.remove(str2);
                TencentVideoModule.f50270n.remove(str2);
                TencentVideoModule.f50271o.remove(str2);
                TencentVideoModule.f50272p.remove(str2);
                TencentVideoModule.f50273q.remove(str2);
            }
        }
        if (str != null && !TextUtils.isEmpty(str) && URLUtil.isValidUrl(str)) {
            Uri parse = Uri.parse(str);
            try {
                String queryParameter = parse.getQueryParameter("cKey");
                String queryParameter2 = parse.getQueryParameter(AdParam.APPVER);
                String queryParameter3 = parse.getQueryParameter("platform");
                String queryParameter4 = parse.getQueryParameter("sdtfrom");
                String queryParameter5 = parse.getQueryParameter("hevclv");
                String queryParameter6 = parse.getQueryParameter("playerformat");
                if (TextUtils.isEmpty(queryParameter6)) {
                    queryParameter6 = "auto";
                }
                int intValue2 = Integer.valueOf(parse.getQueryParameter(TVKLiveRequestBuilder.RequestParamKey.HTTPS)).intValue();
                BaseApplicationImpl.getApplication();
                TencentVideoModule m3 = TencentVideoModule.m(BaseApplication.getContext());
                m3.s(iVar, null);
                m3.i(str2, str);
                if (str4 != null) {
                    m3.g(str2, str4);
                }
                if (str3 != null) {
                    m3.h(str2, str3);
                }
                m3.u(queryParameter, queryParameter2, queryParameter3, queryParameter4, str2, queryParameter5 != null ? Integer.valueOf(queryParameter5).intValue() : 0, queryParameter6, intValue2);
                return;
            } catch (Exception e16) {
                PlayerUtils.log(4, "FeedEnv", "request safe vid = " + str2 + ", getSafeUrl fail!parse url error:" + e16.getMessage() + " url:" + str);
                if (iVar != null) {
                    iVar.a(str, false, str, -779, 0);
                    return;
                }
                return;
            }
        }
        iVar.a(str, false, str, -778, 0);
        PlayerUtils.log(4, "FeedEnv", "request safe vid = " + str2 + ", getSafeUrl fail! url format error! url = " + str);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void z(int i3, int i16, int i17, long j3, BusinessFeedData businessFeedData, int i18, int i19) {
        A(i3, i16, i17, j3, businessFeedData, i18, i19, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void n2(int i3, boolean z16, boolean z17, boolean z18, int i16, Map<Integer, String> map, int i17, int i18) {
        m2(0, i3, z16, z17, z18, i16, map, i17, i18);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void e(Map<Integer, String> map, int i3, int i16, int i17, s_anti_cheat s_anti_cheatVar, int i18, int i19, boolean z16, boolean z17) {
        QZoneWriteOperationService.v0().L(map, i3, i16, i17, i18, i19, z16, z17, null, null, 0L, false, false, null, false, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void V1(String str, int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18) {
        try {
            JSONObject U2 = U2(i3, i16, z16, i17, str, z18, z17, 0);
            if (com.qzone.proxy.feedcomponent.util.j.h()) {
                com.qzone.proxy.feedcomponent.util.j.e(QZLog.TO_DEVICE_TAG, 4, "reportCanvasVideoPlay:    " + U2.toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put(1, U2.toString());
            BusinessFeedData businessFeedData = new BusinessFeedData();
            businessFeedData.getOperationInfo().feedReportCookie = map;
            TTTReportManager.s().m(7, 60, 15, System.currentTimeMillis(), hashMap, businessFeedData, -1000, 0, null, false);
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.util.j.d("reportVideo", "reportCanvasVideoPlay", th5);
        }
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void m2(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18, int i19) {
        JSONObject U2 = U2(i3, i16, z16, i17, null, z18, z17, i19);
        if (com.qzone.proxy.feedcomponent.util.j.h()) {
            com.qzone.proxy.feedcomponent.util.j.e(QZLog.TO_DEVICE_TAG, 4, "reportVideoPlayInfo:    " + U2.toString());
        }
        QZoneWriteOperationService.v0().L(map, 0, 0, i18, 0, 0, true, false, null, U2.toString(), 0L, false, false, null, false, null);
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void P1(String str) {
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void R0(Context context) {
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void l2(String str) {
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void r(IObserver iObserver) {
    }

    @Override // com.qzone.adapter.feedcomponent.i
    public void d(Map<Integer, String> map, int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17, String str, String str2, long j3, boolean z18, boolean z19, String str3, boolean z26, BusinessFeedData businessFeedData) {
        QZoneWriteOperationService.v0().L(map, i3, i16, i17, i18, i19, z16, z17, str, str2, j3, z18, z19, str3, z26, businessFeedData);
    }
}
