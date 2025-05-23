package com.qzone.feed.business.service;

import MOBILE_QZMALL_PROTOCOL.WidgetInfo;
import NS_CLIENT_SHOW_ALL_INFO.AllInfo;
import NS_COMM_VIP_GROWTH.IconInfo;
import NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp;
import NS_COMM_VIP_GROWTH.UserClientShowInfo;
import NS_MOBILE_AD_BANNER.QueryADBannerRsp;
import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import NS_MOBILE_COVER_DATE.MoodEntryContent;
import NS_MOBILE_COVER_DATE.feeds_cover;
import NS_MOBILE_CUSTOM.AvatarItem;
import NS_MOBILE_CUSTOM.FeedSkinInfo;
import NS_MOBILE_CUSTOM.FloatItem;
import NS_MOBILE_FEEDS.FunnySpace;
import NS_MOBILE_FEEDS.FunnySpaceAction;
import NS_MOBILE_FEEDS.UnifyRecomStruct;
import NS_MOBILE_FEEDS.cnst.KUOLIE_CAMPUS_TAG;
import NS_MOBILE_FEEDS.login_uin_info;
import NS_MOBILE_FEEDS.mobile_feeds_rsp;
import NS_MOBILE_FEEDS.s_campus_info;
import NS_MOBILE_FEEDS.s_gps;
import NS_MOBILE_FEEDS.s_memory_seal_off;
import NS_MOBILE_FEEDS.s_profile_timeline;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_FEEDS.stKuolieProfile;
import NS_QMALL_COVER.ActYellowDiamond;
import NS_QMALL_COVER.CustomTrackDeco;
import NS_QMALL_COVER.FacadeDIY;
import NS_QMALL_COVER.FeedNavi;
import NS_QMALL_COVER.PassiveProfileQzmallDeco;
import NS_QMALL_COVER.ProfileQzmallDeco;
import NS_QMALL_COVER.QzmallAvatar;
import NS_QMALL_COVER.QzmallCustomBanner;
import NS_QMALL_COVER.QzmallCustomNavi;
import NS_QMALL_COVER.QzmallCustomPlayer;
import NS_QMALL_COVER.QzmallCustomPraise;
import NS_QMALL_COVER.QzmallCustomVip;
import NS_QMALL_COVER.QzmallFacade;
import NS_QMALL_COVER.QzmallFeedSkin;
import NS_QMALL_COVER.QzmallFloat;
import NS_QMALL_COVER.QzmallProfileDecoGetRsp;
import NS_QMALL_COVER.ReturnToPraise;
import NS_QMALL_COVER.UserCmShowQzoneTrack;
import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.single_count;
import QZMALL_COMM_PROTOCOL.qzmall_data_rsp;
import SWEET_NEW_PRIVILEGE.sweet_style_info_item;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.adapter.feedcomponent.k;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.adapter.feedcomponent.t;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.OutSiteShareService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.business.model.BusinessMyRelationData;
import com.qzone.feed.business.protocol.QZoneGetFriendFeedsRequest;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.homepage.business.model.CmActionData;
import com.qzone.homepage.business.model.CmActionListData;
import com.qzone.homepage.business.model.FunnySpaceModel;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.homepage.diy.util.QzoneDIYService;
import com.qzone.homepage.ui.Facade.h;
import com.qzone.homepage.ui.woo.wizard.StepOnZoneWizard;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerView;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.qzone.personalize.model.CustomBannerFeeData;
import com.qzone.personalize.model.CustomFriendNaviData;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.personalize.model.CustomPlayerData;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.feedcomponent.manager.f;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.ProfileTimeLine;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.service.QzoneExendFeedCustomPraiseService;
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.qzone.proxy.vipcomponent.IVipComponentService;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.reborn.configx.g;
import com.qzone.util.ToastUtil;
import com.qzone.util.x;
import com.qzone.widget.eventwidget.QZoneEventWidgetData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import com.tencent.thumbplayer.api.common.TPChannelLayout;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.TimeCostTrace;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.vipcomponent.util.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s8.m;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFeedService extends a implements f.b, f.a {

    /* renamed from: g0, reason: collision with root package name */
    private static volatile QZoneFeedService f47175g0;

    /* renamed from: l0, reason: collision with root package name */
    public static int f47180l0;

    /* renamed from: n0, reason: collision with root package name */
    public static int f47182n0;
    private boolean D;
    protected final boolean G;
    private HashMap<Integer, String> H;
    private List<String> I;
    protected Map<Integer, String> K;
    private d P;
    private Map<String, byte[]> Q;
    private String R;
    private HashMap<String, String> S;
    private HashMap<Integer, String> T;
    private String V;
    private s_gps W;
    private long X;
    private String Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f47183a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f47184b0;

    /* renamed from: d0, reason: collision with root package name */
    private String f47186d0;

    /* renamed from: h, reason: collision with root package name */
    protected int f47188h;

    /* renamed from: i, reason: collision with root package name */
    private f f47189i;

    /* renamed from: m, reason: collision with root package name */
    private f.c f47190m;

    /* renamed from: e0, reason: collision with root package name */
    public static final int f47173e0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FEED_UNREAD_FOLLOW_EXPOSURE_COUNT, 10);

    /* renamed from: f0, reason: collision with root package name */
    private static Object f47174f0 = new Object();

    /* renamed from: h0, reason: collision with root package name */
    public static Long f47176h0 = 0L;

    /* renamed from: i0, reason: collision with root package name */
    public static String f47177i0 = "";

    /* renamed from: j0, reason: collision with root package name */
    public static String f47178j0 = "";

    /* renamed from: k0, reason: collision with root package name */
    public static String f47179k0 = "";

    /* renamed from: m0, reason: collision with root package name */
    public static boolean f47181m0 = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f47187f = false;
    private boolean C = true;
    private boolean E = true;
    private ArrayList<String> F = new ArrayList<>();
    private int J = 1;
    private long L = 0;
    private List<String> M = new ArrayList();
    private int N = -1;
    private volatile boolean U = false;

    /* renamed from: c0, reason: collision with root package name */
    public int f47185c0 = 1;

    /* compiled from: P */
    /* renamed from: com.qzone.feed.business.service.QZoneFeedService$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass2 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_FEED_PRELOAD, 1);
            throw null;
        }
    }

    QZoneFeedService(int i3, int i16, boolean z16) {
        this.f47216d = i3;
        if (i16 == 8) {
            this.f47188h = 3;
            this.G = true;
        } else {
            this.f47188h = i16;
            this.G = false;
        }
        FeedManager feedManager = new FeedManager(i3, i16, z16);
        this.f47189i = feedManager;
        feedManager.init(e.a.a(getEventSource()), this, this);
        boolean z17 = !g.f53821a.b().n();
        this.f47189i.setSupportIncrementUpdate(z17);
        QLog.i("QZoneFeedService", 1, "hash" + this.f47189i.hashCode() + " feedManager.getFeedCount()" + this.f47189i.getFeedCount() + ", supportIncrementalUpdate: " + z17);
        this.f47189i.setSupportPiece(false);
    }

    private void B0(FeedNavi feedNavi) {
        if (this.f47216d != 0 || feedNavi == null || feedNavi.iItemId == 0) {
            return;
        }
        try {
            com.qzone.personalize.business.b.n().s(CustomFriendNaviData.createFromJce(a0(), feedNavi));
        } catch (Exception e16) {
            QZLog.e("QZoneFeedService", e16.getMessage());
        }
    }

    private void D0(QzmallCustomPraise qzmallCustomPraise) {
        int i3 = this.f47216d;
        if (i3 == 0 || i3 == 2 || i3 == 24) {
            if (qzmallCustomPraise != null && qzmallCustomPraise.iItemId != 0) {
                CustomPraiseData createFromResponse = CustomPraiseData.createFromResponse(qzmallCustomPraise);
                if (this.f47216d == 24) {
                    QzoneExendFeedCustomPraiseService.i().m(createFromResponse);
                    return;
                } else {
                    QzoneCustomPraiseService.i().p(createFromResponse);
                    return;
                }
            }
            QzoneCustomPraiseService.i().p(null);
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "read: CustomPraise is null");
        }
    }

    private void E0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        byte[] bArr;
        if (qZoneTask.mUniAttr.containsKey("hostQzmallDeco")) {
            QzmallProfileDecoGetRsp qzmallProfileDecoGetRsp = (QzmallProfileDecoGetRsp) qZoneTask.mUniAttr.get("hostQzmallDeco");
            if (qzmallProfileDecoGetRsp != null && (bArr = qzmallProfileDecoGetRsp.vecBuff) != null) {
                if (this.f47216d != 1) {
                    ProfileQzmallDeco profileQzmallDeco = (ProfileQzmallDeco) t5.b.b(ProfileQzmallDeco.class, bArr);
                    if (profileQzmallDeco != null) {
                        A0(profileQzmallDeco.stCustomNavi, qZoneResult);
                        C0(profileQzmallDeco.stCustomPlayer);
                        t0(profileQzmallDeco.stCustomBanner);
                        s0(profileQzmallDeco.stAvatar, qZoneResult);
                        y0(profileQzmallDeco.stFloat, qZoneResult);
                        v0(profileQzmallDeco.stFacade);
                        G0(profileQzmallDeco.stCustomVip, profileQzmallDeco.stYellowDiamond);
                        x0(profileQzmallDeco.stFeedSkin);
                        D0(profileQzmallDeco.stCustomPraise);
                        B0(profileQzmallDeco.stFeedNavi);
                        w0(profileQzmallDeco.stFacadeDIY);
                        F0(profileQzmallDeco.stCustomTrack);
                        u0(profileQzmallDeco.stCmShowQzoneTrack);
                        return;
                    }
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "readCustomQzmall: ProfileQzmallDeco is null");
                    return;
                }
                PassiveProfileQzmallDeco passiveProfileQzmallDeco = (PassiveProfileQzmallDeco) t5.b.b(PassiveProfileQzmallDeco.class, bArr);
                if (passiveProfileQzmallDeco != null) {
                    z0(passiveProfileQzmallDeco.stReturnToPraise);
                    return;
                } else {
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "readCustomQzmall: PassiveProfileQzmallDeco is null");
                    return;
                }
            }
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "readCustomQzmall: QzmallProfileDecoGetRsp is null");
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "readCustomQzmall: KEY_HOST_QZMALL is null");
    }

    private void F0(CustomTrackDeco customTrackDeco) {
        if (this.f47216d != 0 || customTrackDeco == null || customTrackDeco.iItemId == 0) {
            return;
        }
        QzoneCustomTrackData customtrackreadFromJce = QzoneCustomTrackData.customtrackreadFromJce(a0(), customTrackDeco);
        try {
            com.qzone.personalize.business.b.n().w(customtrackreadFromJce);
        } catch (Exception e16) {
            QZLog.e("QZoneFeedService", e16.getMessage());
        }
        if (customtrackreadFromJce == null || customtrackreadFromJce.iItemId == -1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        QzoneCustomTrackData.mergeToatalModels(customtrackreadFromJce, arrayList);
        StepOnZoneWizard.h().j("QzoneCustomTrackLoadKey" + customtrackreadFromJce.iItemId, arrayList, null, 1);
    }

    private void G0(QzmallCustomVip qzmallCustomVip, ActYellowDiamond actYellowDiamond) {
        boolean z16;
        z5.a f16 = z5.a.f();
        x6.a g16 = f16.g(a0());
        boolean z17 = true;
        if (qzmallCustomVip == null || qzmallCustomVip.iItemId == 0) {
            z16 = false;
        } else {
            LoginData.getInstance().updateVipInfos(String.valueOf(a0()), qzmallCustomVip.strSrcUrl);
            if (g16 != null) {
                g16.personalizedYellowVipUrl = qzmallCustomVip.strSrcUrl;
                g16.customType = qzmallCustomVip.eCustomVipType;
                g16.hostCustomIconUrl = qzmallCustomVip.strMasterJumpUrl;
                g16.guestCustomIconUrl = qzmallCustomVip.strGuestJumpUrl;
            }
            z16 = true;
        }
        if (actYellowDiamond != null) {
            LoginData.getInstance().updateVipInfos(String.valueOf(a0()), actYellowDiamond.iTenYearUser != 0, actYellowDiamond.strPicZip);
            if (g16 != null) {
                g16.isCustomDiamondUser = actYellowDiamond.iTenYearUser != 0;
                g16.customDiamondUrl = actYellowDiamond.strPicZip;
            }
        } else {
            z17 = z16;
        }
        if (z17) {
            f16.t(g16);
            EventCenter.getInstance().post(a.C10129a.f391398a, 11);
        }
    }

    private void I0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        if (qZoneTask.mUniAttr.containsKey("getKuolieProfile")) {
            EventCenter.getInstance().post("Feed", 33, (stKuolieProfile) qZoneTask.mUniAttr.get("getKuolieProfile"));
        }
    }

    private void J0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        MoodEntryContent moodEntryContent;
        if (qZoneTask.mUniAttr.containsKey("MoodEntryContent") && (moodEntryContent = (MoodEntryContent) qZoneTask.mUniAttr.get("MoodEntryContent")) != null) {
            str = moodEntryContent.content;
        } else {
            str = "";
        }
        u5.b.x0("MoodEntryContent", str, LoginData.getInstance().getUin());
        qZoneResult.getBundle().putString("MoodEntryContent", str);
        if (QZLog.isDevelopLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 4, "get MoodEntryContent: " + str);
        }
    }

    private void L0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        single_count single_countVar;
        ArrayList<feed_host_info> arrayList;
        if (qZoneTask.mUniAttr.containsKey("relationFeedsCount")) {
            count_info count_infoVar = (count_info) qZoneTask.mUniAttr.get("relationFeedsCount");
            if (count_infoVar != null && (single_countVar = count_infoVar.stCount) != null && single_countVar.uCount > 0 && (arrayList = count_infoVar.vecUinList) != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < count_infoVar.vecUinList.size(); i3++) {
                    BusinessMyRelationData businessMyRelationData = new BusinessMyRelationData();
                    feed_host_info feed_host_infoVar = count_infoVar.vecUinList.get(i3);
                    if (feed_host_infoVar != null) {
                        businessMyRelationData.actiondesc = feed_host_infoVar.actiondesc;
                        businessMyRelationData.nickname = feed_host_infoVar.nickname;
                        businessMyRelationData.uUin = feed_host_infoVar.uUin;
                    }
                    arrayList2.add(businessMyRelationData);
                }
                ParcelableWrapper.putArrayListToBundle(qZoneResult.getBundle(), BusinessMyRelationData.STORE_KEY, arrayList2);
                return;
            }
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "GETBANNER: mobile_count_rsp is null");
        }
    }

    public static void N() {
        if (f47175g0 != null) {
            f47175g0.P();
        }
    }

    private void O0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        String str;
        String str2;
        if (qZoneResult.getBundle().getInt("key_bubble_banner_type", 0) == 0 && qZoneTask.mUniAttr.containsKey("hostQzmall")) {
            qzmall_data_rsp qzmall_data_rspVar = (qzmall_data_rsp) qZoneTask.mUniAttr.get("hostQzmall");
            if (qzmall_data_rspVar == null || qzmall_data_rspVar.rspMap == null) {
                return;
            }
            if (vo.d.b().d(a0())) {
                QZLog.d("QZoneFeedService", 2, "this uin is a famous space.");
                return;
            }
            WidgetInfo widgetInfo = (WidgetInfo) t5.b.b(WidgetInfo.class, qzmall_data_rspVar.rspMap.get("commwidget"));
            if (widgetInfo != null) {
                boolean z16 = widgetInfo.category == 1;
                if (z16) {
                    str = widgetInfo.stEventWidgetInfo.strDownloadAppPackageName;
                } else {
                    str = widgetInfo.stCommWidgetInfo.strDownloadAppPackageName;
                }
                if (!TextUtils.isEmpty(str) && g15.a.m(str).booleanValue()) {
                    IQbossReportManager iQbossReportManager = (IQbossReportManager) QRoute.api(IQbossReportManager.class);
                    if (z16) {
                        str2 = widgetInfo.stEventWidgetInfo.strTraceInfo;
                    } else {
                        str2 = widgetInfo.stCommWidgetInfo.strTraceInfo;
                    }
                    iQbossReportManager.reportIntercept(str2, null);
                    com.qzone.widget.eventwidget.a.G().K(a0(), null);
                    QZLog.d("QZoneFeedService", 2, "GETEVENTWIDGET: intercept AD and clear cache");
                    return;
                }
            }
            if (widgetInfo != null && widgetInfo.category == 1) {
                H0(widgetInfo);
                widgetInfo.stCommWidgetInfo = null;
                return;
            } else {
                H0(null);
                return;
            }
        }
        com.qzone.widget.eventwidget.a.G().K(a0(), null);
        QZLog.d("QZoneFeedService", 2, "GETEVENTWIDGET: eventwidget is null");
    }

    private boolean S() {
        return true;
    }

    public static QZoneFeedService U() {
        if (f47175g0 == null) {
            synchronized (QZoneFeedService.class) {
                if (f47175g0 == null) {
                    long uin = LoginData.getInstance().getUin();
                    f47175g0 = new QZoneFeedService(0, 3, true);
                    f47175g0.o(uin, uin);
                }
            }
        }
        return f47175g0;
    }

    public static QZoneFeedService V(long j3) {
        QZoneFeedService qZoneFeedService = new QZoneFeedService(2, 8, LoginData.getInstance().getUin() == j3);
        qZoneFeedService.o(LoginData.getInstance().getUin(), j3);
        return qZoneFeedService;
    }

    public static QZoneFeedService W() {
        QZoneFeedService qZoneFeedService = new QZoneFeedService(19, 3, true);
        qZoneFeedService.o(LoginData.getInstance().getUin(), LoginData.getInstance().getUin());
        return qZoneFeedService;
    }

    public static int X() {
        if (f47175g0 == null || f47175g0.f47189i == null) {
            return 0;
        }
        return f47175g0.f47189i.getFeedCount();
    }

    private void X0(String str, boolean z16) {
        if (S()) {
            if (z16) {
                TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).stopStep(str);
            } else {
                TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).stopStep(str);
            }
        }
    }

    private String Y() {
        StringBuilder sb5 = new StringBuilder();
        EventSource eventSource = getEventSource();
        sb5.append("[" + (eventSource == null ? null : eventSource.getName()) + "$" + this.f47216d + "]");
        return sb5.toString();
    }

    private void Y0(String str, boolean z16) {
        if (S()) {
            if (z16) {
                TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).startStep(str);
            } else {
                TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).startStep(str);
            }
        }
    }

    public static QZoneFeedService b0(boolean z16) {
        QZoneFeedService qZoneFeedService = new QZoneFeedService(1, 3, false);
        qZoneFeedService.f47187f = z16;
        qZoneFeedService.o(LoginData.getInstance().getUin(), LoginData.getInstance().getUin());
        return qZoneFeedService;
    }

    public static QZoneFeedService c0(long j3) {
        QZoneFeedService qZoneFeedService = new QZoneFeedService(2, 3, LoginData.getInstance().getUin() == j3);
        qZoneFeedService.o(LoginData.getInstance().getUin(), j3);
        return qZoneFeedService;
    }

    private int d0() {
        ArrayList<String> arrayList = this.F;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public static QZoneFeedService e0(long j3) {
        QZoneFeedService qZoneFeedService = new QZoneFeedService(18, 3, LoginData.getInstance().getUin() == j3);
        qZoneFeedService.o(LoginData.getInstance().getUin(), j3);
        return qZoneFeedService;
    }

    private void q0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        UniAttribute uniAttribute;
        ArrayList<QueryADBannerUnit> arrayList;
        Map<String, String> map;
        Map<String, String> map2;
        JceStruct jceStruct;
        if (qZoneTask.mResultCode == 0 && (uniAttribute = qZoneTask.mUniAttr) != null && uniAttribute.containsKey("hostBanner")) {
            QueryADBannerRsp queryADBannerRsp = (QueryADBannerRsp) qZoneTask.mUniAttr.get("hostBanner");
            if (queryADBannerRsp != null && (arrayList = queryADBannerRsp.vecAdBanner) != null && arrayList.size() > 0) {
                ArrayList<QueryADBannerUnit> arrayList2 = queryADBannerRsp.vecAdBanner;
                ArrayList arrayList3 = new ArrayList();
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    QZoneRequest qZoneRequest = qZoneTask.mRequest;
                    Map<Integer, UnifyRecomStruct> map3 = (qZoneRequest == null || (jceStruct = qZoneRequest.rsp) == null || !(jceStruct instanceof mobile_feeds_rsp)) ? null : ((mobile_feeds_rsp) jceStruct).mapRecomUnifyList;
                    int size = arrayList2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        QueryADBannerUnit queryADBannerUnit = arrayList2.get(i3);
                        QLog.d("QZoneFeedService", 1, "banner adType is " + queryADBannerUnit.eAdType);
                        String str = queryADBannerUnit.DynBannerJsonData;
                        if (str != null || queryADBannerUnit.extendinfo != null) {
                            String n3 = str != null ? g15.a.n(str) : null;
                            if (TextUtils.isEmpty(n3) && (map = queryADBannerUnit.extendinfo) != null) {
                                n3 = map.get("download_app_package_name");
                            }
                            if (!TextUtils.isEmpty(n3) && g15.a.m(n3).booleanValue()) {
                                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportIntercept(queryADBannerUnit.strTraceInfo, null);
                            }
                        }
                        BusinessADBannerData businessADBannerData = new BusinessADBannerData(queryADBannerUnit);
                        if (map3 != null && (map2 = businessADBannerData.extendinfo) != null) {
                            String str2 = map2.get(BusinessADBannerData.KEY_BANNER_APPID);
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    Integer valueOf = Integer.valueOf(str2);
                                    if (map3.get(valueOf) != null) {
                                        businessADBannerData.newRepoertInfoList = map3.get(valueOf).newReportInfoList;
                                    }
                                } catch (NumberFormatException e16) {
                                    QZLog.w("QZoneFeedService", "get newReportInfoList error:", e16);
                                    MonitorManager.f().h(3, 9, " \u7c7b\u578b\u8f6c\u6362\u5931\u8d25\uff1a" + e16, false);
                                }
                            }
                        }
                        if (businessADBannerData.eAdType == 2) {
                            Map<String, String> map4 = businessADBannerData.extendinfo;
                            if (map4 != null && !TextUtils.isEmpty(map4.get("res_zip_url"))) {
                                qZoneResult.getBundle().putInt("key_bubble_banner_type", 2);
                            } else {
                                qZoneResult.getBundle().putInt("key_bubble_banner_type", 1);
                            }
                        }
                        arrayList3.add(businessADBannerData);
                    }
                }
                ParcelableWrapper.putArrayListToBundle(qZoneResult.getBundle(), BusinessADBannerData.STORE_KEY, arrayList3);
                return;
            }
            QZLog.i("QZoneFeedService", 1, "GETBANNER: banner is null");
            return;
        }
        QZLog.i("QZoneFeedService", 1, "GETBANNER: banner data is not distributed.");
    }

    private void r0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        feeds_cover feeds_coverVar;
        String str;
        if (qZoneTask.mUniAttr.containsKey("hostCover")) {
            try {
                feeds_coverVar = (feeds_cover) qZoneTask.mUniAttr.get("hostCover");
            } catch (Exception e16) {
                MonitorManager.f().h(2, 2, "\u547d\u4ee4\u5b57\u89e3\u5305\u5931\u8d25" + e16, false);
                QZLog.e("QZoneFeedService", "mUniAttr get hostCover fail.", e16);
                feeds_coverVar = null;
            }
            if (feeds_coverVar != null) {
                CoverCacheData createFromResponse = CoverCacheData.createFromResponse(a0(), feeds_coverVar);
                CoverComponentProxy coverComponentProxy = CoverComponentProxy.f50099g;
                CoverCacheData handleLocalVideoCover = coverComponentProxy.getServiceInterface().handleLocalVideoCover(createFromResponse);
                coverComponentProxy.getServiceInterface().saveCoverIntoCache(handleLocalVideoCover);
                qZoneResult.getBundle().putParcelable(QzoneCoverConst.PARAM_CACHE_DATA, handleLocalVideoCover);
                if (QZLog.isDevelopLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("GETCOVER: cover type: ");
                    sb5.append(feeds_coverVar.type);
                    sb5.append(", coverStyle: ");
                    CoverPackageInfo coverPackageInfo = feeds_coverVar.packageInfo;
                    sb5.append(coverPackageInfo != null ? coverPackageInfo.coverStyle : -1);
                    sb5.append(", url[H]: ");
                    Map<String, String> map = feeds_coverVar.MulRelsotionUrl;
                    String str2 = "";
                    if (map == null) {
                        str = "";
                    } else {
                        str = map.get("HigeResolutionCover");
                    }
                    sb5.append(str);
                    sb5.append(", url[L]: ");
                    Map<String, String> map2 = feeds_coverVar.MulRelsotionUrl;
                    if (map2 != null) {
                        str2 = map2.get("LowResolutionCover");
                    }
                    sb5.append(str2);
                    QZLog.i(QZLog.TO_DEVICE_TAG, 4, sb5.toString());
                    return;
                }
                return;
            }
            MonitorManager.f().h(2, 2, "\u8bfb\u53d6\u5230\u7684cover \u6570\u636e\u4e3a\u7a7a", false);
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "GETCOVER: cover is null");
            return;
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, "not have hostCover");
    }

    private void w0(FacadeDIY facadeDIY) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QzoneDIY data == null : ");
        sb5.append(facadeDIY == null);
        QZLog.i("QZoneFeedService", 1, sb5.toString());
        if (facadeDIY != null) {
            if (facadeDIY.iEnable != -1) {
                QzoneDIYService.L().P(a0());
            } else {
                QzoneDIYService.L().H(a0());
            }
        }
        if (facadeDIY == null) {
            MonitorManager.f().h(24, 2, "parse feed FacadeDIY data = null", false);
        }
    }

    private void x0(QzmallFeedSkin qzmallFeedSkin) {
        FeedSkinInfo feedSkinInfo;
        if (this.f47216d != 0 || qzmallFeedSkin == null || (feedSkinInfo = qzmallFeedSkin.stFeedSkinInfo) == null || TextUtils.isEmpty(feedSkinInfo.sSkinId)) {
            return;
        }
        a1(a0(), feedSkinInfo);
    }

    @Override // com.qzone.feed.business.service.a
    public List<BusinessFeedData> D() {
        return this.f47189i.getCurrentDatas();
    }

    @Override // com.qzone.feed.business.service.a
    public com.qzone.proxy.feedcomponent.manager.d E() {
        return this.P;
    }

    @Override // com.qzone.feed.business.service.a
    public k F() {
        return this.f47189i.getFeedTimeInfo();
    }

    @Override // com.qzone.feed.business.service.a
    public void G(BusinessFeedData businessFeedData) {
        QZoneGetFriendFeedsRequest qZoneGetFriendFeedsRequest = new QZoneGetFriendFeedsRequest(22, a0(), businessFeedData);
        qZoneGetFriendFeedsRequest.setRefer(this.V);
        qZoneGetFriendFeedsRequest.setDeviceInfo(u5.a.f438267e);
        QZoneTask qZoneTask = new QZoneTask(qZoneGetFriendFeedsRequest, null, this, 6);
        qZoneTask.addParameter("Feed", businessFeedData);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    @Override // com.qzone.feed.business.service.a
    public boolean H() {
        return this.f47189i.hasMore();
    }

    @Override // com.qzone.feed.business.service.a
    public void I(Handler handler) {
        this.f47189i.requestFeedDatas(3, t.c(handler), false);
    }

    @Override // com.qzone.feed.business.service.a
    public void J(Handler handler) {
        Y0("moreFeed", false);
        this.f47189i.requestFeedDatas(1, t.c(handler), false);
    }

    @Override // com.qzone.feed.business.service.a
    public void K() {
        f fVar = this.f47189i;
        if (fVar != null) {
            fVar.onDataChange();
        }
    }

    @Override // com.qzone.feed.business.service.a
    public void L(Handler handler, String str) {
        RFWLog.i("request_feedx", RFWLog.USR, "start request feeds, refer: " + str);
        Y0(QZoneJsConstants.METHOD_REFRESH_FEED, true);
        this.V = str;
        this.f47189i.requestFeedDatas(0, t.c(handler), false);
    }

    public void O() {
        this.f47189i.clearAllCache();
    }

    public void P() {
        RFWLog.d("QZoneFeedService", RFWLog.USR, "clearMemoryCache");
        this.f47189i.clearMemoryCache();
    }

    public void P0(Handler handler, String str, boolean z16, ArrayList<String> arrayList) {
        this.V = str;
        U0(z16);
        V0(arrayList);
        this.f47189i.requestFeedDatas(0, t.c(handler), false);
    }

    public void Q0() {
        if (!f0() && !this.U) {
            this.f47189i.sendInitDataMessage();
            QzoneCustomPraiseService.i().o(LoginData.getInstance().getUin());
            QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 4, "refreshLocalCache handleQueryInitData feedcount:" + this.f47189i.getFeedCount());
            return;
        }
        if (this.f47189i.getFeedCount() != 0) {
            v(D(), false, false, false, 0);
        }
        QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 4, "refreshLocalCache onFeedDataChange feedcount:" + this.f47189i.getFeedCount());
    }

    public void R(String str, String str2, boolean z16) {
        f fVar = this.f47189i;
        if (fVar != null) {
            fVar.deleteFeedOnTime(str, str2, z16);
        }
    }

    public void S0(Map<String, byte[]> map) {
        this.Q = map;
    }

    public void T(Handler handler, boolean z16) {
        T0(z16);
        this.f47189i.requestFeedDatas(4, t.c(handler), false);
    }

    public void T0(boolean z16) {
        this.E = z16;
    }

    public void U0(boolean z16) {
        this.D = z16;
    }

    public void V0(ArrayList<String> arrayList) {
        this.F = arrayList;
    }

    public void W0(String str) {
        if (this.H == null) {
            this.H = new HashMap<>();
        }
        this.H.put(4, str);
    }

    public void Z0(BusinessFeedData businessFeedData, boolean z16) {
        this.f47189i.updateData(businessFeedData, z16);
    }

    protected long a0() {
        return this.f47189i.getOwnerUin();
    }

    public void close() {
        this.f47189i.close();
    }

    public boolean f0() {
        return this.f47189i.getFeedCount() > 0;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    public SharedPreferences getSharedPreferences() {
        if (QZLog.isColorLevel()) {
            QZLog.d("FeedTime", 2, "getAttachInfoPreferences--preferences:" + LoginData.getInstance().getUin());
        }
        return u5.b.M("QZ_Feed_Setting_" + LoginData.getInstance().getUin());
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    public void h(boolean z16) {
        this.C = z16;
    }

    public void k0(int i3, int i16) {
        if (x.b() > 1) {
            this.f47189i.preDownloadFeedsPassiveCustomTrack(i3, i16);
        }
    }

    public void l0(int i3, int i16) {
        if (x.b() > 1) {
            this.f47189i.preDownloadFeedsPernalizeDiamondImage(i3, i16);
        }
    }

    public void m0(int i3, int i16) {
        if (x.b() > 1) {
            this.f47189i.preDownloadFeedsPernalizePassivePraise(i3, i16);
        }
    }

    public void n0() {
        this.f47189i.requestFeedDatas(2, t.b(), false);
    }

    public void o(long j3, long j16) {
        this.f47189i.setUin(j3, j16, false, this.f47216d == 0);
    }

    public void o0() {
        if (f0() || this.U) {
            return;
        }
        this.U = true;
        this.f47189i.sendInitDataMessage();
        QzoneCustomPraiseService.i().o(LoginData.getInstance().getUin());
        QZLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 4, "QZoneFeedService preloadLocalCache feedcount:" + this.f47189i.getFeedCount());
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QZoneFeedService onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        int i3 = qZoneTask.mType;
        if (i3 == 1 || i3 == 2) {
            X0("sendRequest", i3 == 1);
        }
        int i16 = qZoneTask.mType;
        if (i16 == 1) {
            h0(qZoneTask, 0);
            return;
        }
        if (i16 == 2) {
            h0(qZoneTask, 1);
            return;
        }
        if (i16 == 3) {
            h0(qZoneTask, 3);
            return;
        }
        if (i16 == 4) {
            h0(qZoneTask, 2);
        } else if (i16 == 6) {
            j0(qZoneTask);
        } else {
            if (i16 != 7) {
                return;
            }
            h0(qZoneTask, 4);
        }
    }

    public void p0(Handler handler) {
        this.f47189i.requestFeedDatas(2, t.c(handler), false);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    public com.qzone.proxy.feedcomponent.manager.d r(com.qzone.proxy.feedcomponent.manager.e eVar, e.a aVar, int i3, int i16) {
        d dVar = new d(eVar, aVar, i3, i16);
        this.P = dVar;
        return dVar;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.a
    public void t(List<BusinessFeedData> list, List<BusinessFeedData> list2) {
        HashMap hashMap = new HashMap();
        for (BusinessFeedData businessFeedData : list2) {
            if (!TextUtils.isEmpty(businessFeedData.getFeedCommInfo().ugckey)) {
                hashMap.put(businessFeedData.getFeedCommInfo().ugckey, businessFeedData);
            }
        }
        notify(4, list, hashMap);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.a
    public void v(List<BusinessFeedData> list, boolean z16, boolean z17, boolean z18, int i3) {
        for (BusinessFeedData businessFeedData : list) {
            if (!businessFeedData.hasCalculate) {
                businessFeedData.preCalculate();
            }
        }
        notify(1, list, Integer.valueOf(i3));
        if (i3 == 1) {
            X0(QZoneJsConstants.METHOD_REFRESH_FEED, true);
            Y0("updateFeeds", true);
        } else if (i3 == 2) {
            X0("moreFeed", false);
            Y0("updateFeeds", false);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    public HandlerThread x() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).getHandlerThread();
    }

    private void H0(WidgetInfo widgetInfo) {
        if (widgetInfo != null) {
            QZoneEventWidgetData createFromResponse = QZoneEventWidgetData.createFromResponse(a0(), widgetInfo);
            com.qzone.widget.eventwidget.a.G().K(a0(), createFromResponse);
            if (QZLog.isColorLevel()) {
                QZLog.d("QZoneFeedService", 2, "GETEVENTWIDGET: show: " + createFromResponse.bShow + ", strMaterialUrl: " + createFromResponse.strMaterialUrl + ", jumpUrl: " + createFromResponse.strJumpUrl);
                return;
            }
            return;
        }
        com.qzone.widget.eventwidget.a.G().K(a0(), null);
        QZLog.d("QZoneFeedService", 2, "GETEVENTWIDGET: eventwidget is null");
    }

    private void K0(mobile_feeds_rsp mobile_feeds_rspVar, int i3) {
        Map<Integer, UnifyRecomStruct> map;
        if (mobile_feeds_rspVar != null && (map = mobile_feeds_rspVar.mapRecomUnifyList) != null) {
            UnifyRecomStruct unifyRecomStruct = map.get(10010);
            if (unifyRecomStruct == null || unifyRecomStruct.vctBusiData == null) {
                QZLog.d("QZoneFeedService", 2, "readQQStoryFeed: \u6ca1\u6709\u8bfb\u5230\u540e\u53f0\u7684\u6709\u6548\u6570\u636e: rowData = " + unifyRecomStruct);
            }
            if (i3 == 0) {
                if (unifyRecomStruct != null) {
                    try {
                        byte[] bArr = unifyRecomStruct.vctBusiData;
                        if (bArr != null) {
                            single_feed single_feedVar = (single_feed) t5.b.b(single_feed.class, bArr);
                            if (single_feedVar != null) {
                                BusinessFeedData createFrom = BusinessFeedData.createFrom(single_feedVar, 4097);
                                QZLog.d("QZoneFeedService", 2, "readQQStoryFeed: \u540e\u53f0\u8fd4\u56de\u7684story feed\u4e3a\u6570\u91cf\uff1a" + createFrom.getRecBusinessFeedDatas().size());
                                com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
                                aVar.f47117a = 25;
                                aVar.f47136t = createFrom;
                                aVar.f47132p = unifyRecomStruct.newReportInfoList;
                                EventCenter.getInstance().post("QQStory", 1, aVar, Boolean.TRUE);
                            }
                            return;
                        }
                    } catch (Exception e16) {
                        QZLog.e("QZoneFeedService", "readQQStoryFeed: ", e16);
                        return;
                    }
                }
                com.qzone.feed.business.model.a aVar2 = new com.qzone.feed.business.model.a();
                aVar2.f47117a = 25;
                EventCenter.getInstance().post("QQStory", 1, aVar2, Boolean.TRUE);
                return;
            }
            return;
        }
        QZLog.w("QZoneFeedService", 2, "readQQStoryFeed: rsp == null or rsp.mapRecomUnifyList == null, rsp = " + mobile_feeds_rspVar);
    }

    private void A0(QzmallCustomNavi qzmallCustomNavi, QZoneResult qZoneResult) {
        if (qzmallCustomNavi == null || qzmallCustomNavi.iItemId == 0) {
            return;
        }
        CustomNaviCacheData naviCacheData = CustomNaviCacheData.toNaviCacheData(a0(), qzmallCustomNavi);
        try {
            com.qzone.personalize.business.b.n().A(naviCacheData);
            qZoneResult.getBundle().putParcelable(CustomNaviCacheData.PARAM_CACHE_DATA, naviCacheData);
        } catch (Exception e16) {
            MonitorManager.f().h(5, 9, "\u4fdd\u5b58\u5bfc\u822a\u88c5\u626e\u4fe1\u606f\u5931\u8d25 " + e16, false);
            QZLog.e("QZoneFeedService", e16.getMessage());
        }
    }

    private void C0(QzmallCustomPlayer qzmallCustomPlayer) {
        if (qzmallCustomPlayer == null || qzmallCustomPlayer.iItemId == 0) {
            return;
        }
        try {
            com.qzone.personalize.business.b.n().v(CustomPlayerData.createFromJce(a0(), qzmallCustomPlayer));
        } catch (Exception e16) {
            MonitorManager.f().h(6, 9, " \u4fdd\u5b58\u97f3\u4e50\u64ad\u653e\u5668\u88c5\u626e\u4fe1\u606f\u5931\u8d25 " + e16, false);
            QZLog.e("QZoneFeedService", e16.getMessage());
        }
    }

    private void M0(mobile_feeds_rsp mobile_feeds_rspVar) {
        s_profile_timeline s_profile_timelineVar;
        if (mobile_feeds_rspVar == null || (s_profile_timelineVar = mobile_feeds_rspVar.stProfileTimeLine) == null) {
            return;
        }
        EventCenter.getInstance().post("Feed", 23, ProfileTimeLine.createFromResponse(s_profile_timelineVar));
    }

    private void N0(mobile_feeds_rsp mobile_feeds_rspVar) {
        byte[] bArr;
        sweet_style_info_item sweet_style_info_itemVar;
        UserClientShowInfo userClientShowInfo;
        UserClientShowInfo userClientShowInfo2;
        if (mobile_feeds_rspVar == null || (bArr = mobile_feeds_rspVar.stShangchengInfo) == null) {
            return;
        }
        AllInfo allInfo = (AllInfo) t5.b.b(AllInfo.class, bArr);
        if (allInfo != null) {
            WidgetCacheQzoneVipData widgetVipDataFromCache = QzoneWidgetService.getInstance().getWidgetVipDataFromCache(a0());
            if (widgetVipDataFromCache == null) {
                widgetVipDataFromCache = new WidgetCacheQzoneVipData();
            }
            byte[] bArr2 = allInfo.vecQQBigVipInfo;
            if (bArr2 != null && (userClientShowInfo2 = (UserClientShowInfo) t5.b.b(UserClientShowInfo.class, bArr2)) != null) {
                VipComponentProxy.f50997g.getServiceInterface().updateQQUnionVip(String.valueOf(a0()), (userClientShowInfo2.iVip == 0 || userClientShowInfo2.iIsUseVipIcon == 0) ? false : true, userClientShowInfo2.iLevel, userClientShowInfo2.mapIconInfo);
                WidgetCacheQzoneVipData.updateQQUnionVip(widgetVipDataFromCache, userClientShowInfo2);
            }
            SearchClientShowInfoRsp searchClientShowInfoRsp = allInfo.stYellowVipInfo;
            if (searchClientShowInfoRsp != null && searchClientShowInfoRsp.iCode == 0 && (userClientShowInfo = searchClientShowInfoRsp.stUserClientShowInfo) != null) {
                Map<String, IconInfo> map = userClientShowInfo.mapIconInfo;
                if (map != null && map.size() != 0) {
                    searchClientShowInfoRsp.stUserClientShowInfo.iIsUseVipIcon = 1;
                } else {
                    searchClientShowInfoRsp.stUserClientShowInfo.iIsUseVipIcon = 0;
                }
                IVipComponentService serviceInterface = VipComponentProxy.f50997g.getServiceInterface();
                String valueOf = String.valueOf(a0());
                UserClientShowInfo userClientShowInfo3 = searchClientShowInfoRsp.stUserClientShowInfo;
                serviceInterface.updateQQNewVip(valueOf, userClientShowInfo3.iIsUseVipIcon != 0, userClientShowInfo3.mapIconInfo);
                WidgetCacheQzoneVipData.updateNewVip(widgetVipDataFromCache, searchClientShowInfoRsp.stUserClientShowInfo);
            }
            byte[] bArr3 = allInfo.vecSweetStyleInfo;
            if (bArr3 != null && (sweet_style_info_itemVar = (sweet_style_info_item) t5.b.b(sweet_style_info_item.class, bArr3)) != null) {
                VipComponentProxy.f50997g.getServiceInterface().updateLoveVipInfo(a0() + "", sweet_style_info_itemVar);
            }
            QzoneWidgetService.getInstance().saveQzoneVipCacheData(widgetVipDataFromCache);
            return;
        }
        MonitorManager.f().h(23, 2, "parse feed vecQQBigVipInfo data fail", false);
    }

    private void s0(QzmallAvatar qzmallAvatar, QZoneResult qZoneResult) {
        if (qzmallAvatar != null) {
            AvatarItem avatarItem = qzmallAvatar.stAvatarItem;
            if (avatarItem != null && !TextUtils.isEmpty(avatarItem.strId)) {
                AvatarCacheData createFromResponse = AvatarCacheData.createFromResponse(a0(), avatarItem);
                com.qzone.personalize.business.b.n().t(createFromResponse);
                qZoneResult.getBundle().putParcelable("AvatarCacheData", createFromResponse);
                return;
            }
            QZLog.i("QZoneFeedService", 1, "readAvatar: avatar is null");
        }
    }

    private void t0(QzmallCustomBanner qzmallCustomBanner) {
        CustomBannerFeeData createFromJce;
        if (qzmallCustomBanner == null || (createFromJce = CustomBannerFeeData.createFromJce(qzmallCustomBanner)) == null) {
            return;
        }
        try {
            if (createFromJce.iBannerType > 0) {
                EventCenter.getInstance().post("CustomBanner", 1, createFromJce);
            }
        } catch (Exception e16) {
            MonitorManager.f().h(4, 9, "\u50ac\u8d39banner\u4fe1\u606f\u5f02\u5e38 " + e16, false);
            QZLog.e("QZoneFeedService", e16.getMessage());
        }
    }

    private void u0(UserCmShowQzoneTrack userCmShowQzoneTrack) {
        CmActionListData createActionListFromJce;
        ArrayList<CmActionData> arrayList;
        ArrayList<CmActionData> arrayList2;
        if (userCmShowQzoneTrack == null || (createActionListFromJce = CmActionListData.createActionListFromJce(a0(), userCmShowQzoneTrack)) == null || (arrayList = createActionListFromJce.m2DActionList) == null || arrayList.size() == 0 || (arrayList2 = createActionListFromJce.m3DActionList) == null || arrayList2.size() == 0) {
            return;
        }
        com.qzone.personalize.business.b.n().u(createActionListFromJce);
        d7.a.C(a0(), createActionListFromJce);
    }

    private void v0(QzmallFacade qzmallFacade) {
        if (qzmallFacade != null) {
            h.l().v(qzmallFacade, a0());
        }
    }

    private void y0(QzmallFloat qzmallFloat, QZoneResult qZoneResult) {
        if (qzmallFloat != null) {
            FloatItem floatItem = qzmallFloat.stFloatItem;
            if (floatItem != null && !TextUtils.isEmpty(floatItem.strId)) {
                FloatCacheData createFromResponse = FloatCacheData.createFromResponse(a0(), floatItem);
                com.qzone.personalize.business.b.n().y(createFromResponse);
                qZoneResult.getBundle().putParcelable(FloatCacheData.PARAM_CACHE_DATA, createFromResponse);
                return;
            }
            QZLog.i("QZoneFeedService", 1, "readFloatItem: float item is null");
        }
    }

    private void z0(ReturnToPraise returnToPraise) {
        if (returnToPraise == null || returnToPraise.iItemId == 0) {
            return;
        }
        CustomHighFiveData customHighFiveData = new CustomHighFiveData();
        customHighFiveData.uin = LoginData.getInstance().getUin();
        customHighFiveData.itemId = returnToPraise.iItemId;
        customHighFiveData.strHighFiveResUrl = returnToPraise.strRightHandUrl;
        customHighFiveData.strHighFiveText = returnToPraise.strText;
        com.qzone.personalize.business.b.n().z(customHighFiveData);
    }

    public void Q(BusinessFeedData businessFeedData) {
        f fVar;
        if (businessFeedData == null || (fVar = this.f47189i) == null) {
            return;
        }
        fVar.deleteFeedMemOnly(businessFeedData);
    }

    protected void g0(String str, boolean z16) {
        if (z16 && QZLog.isColorLevel()) {
            QZLog.i("QZoneFeedService", 2, Y() + str);
        }
    }

    private void a1(long j3, FeedSkinInfo feedSkinInfo) {
        if (feedSkinInfo == null) {
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneCardLogic.QZoneFeedService", 4, "feedSkinInfo coverid: " + feedSkinInfo.sSkinId + ",feedSkinInfo timestamp:" + feedSkinInfo.lTime + ",feedSkinInfo cover_type: " + feedSkinInfo.sSkinType);
        }
        FeedSkinData.fromFeedSkinInfo(feedSkinInfo);
    }

    private void b1(mobile_feeds_rsp mobile_feeds_rspVar) {
        if (mobile_feeds_rspVar == null) {
            return;
        }
        LoginData.getInstance().updateVipInfos(mobile_feeds_rspVar.host_imbitmap);
    }

    private void j0(QZoneTask qZoneTask) {
        ArrayList<single_feed> arrayList;
        CellFollowGuide cellFollowGuide;
        if (qZoneTask == null) {
            return;
        }
        try {
            BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("Feed");
            if (qZoneTask.succeeded()) {
                mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) qZoneTask.mRequest.rsp;
                if (mobile_feeds_rspVar != null && (arrayList = mobile_feeds_rspVar.all_feeds_data) != null && arrayList.size() > 0 && (cellFollowGuide = businessFeedData.cellFollowGuide) != null) {
                    cellFollowGuide.setStatus(2);
                    businessFeedData.cellFollowGuide.setUnreadFollowFeeds(mobile_feeds_rspVar.all_feeds_data, businessFeedData);
                }
            } else {
                CellFollowGuide cellFollowGuide2 = businessFeedData.cellFollowGuide;
                if (cellFollowGuide2 != null) {
                    cellFollowGuide2.setStatus(0);
                }
                ToastUtil.s(qZoneTask.f45835msg, 4);
            }
            K();
        } catch (Exception e16) {
            QZLog.e("QZoneFeedService", "onUnreadFollowFeedComplete error!", e16);
        }
    }

    public void Z(BusinessFeedData businessFeedData, Handler handler) {
        if (businessFeedData == null) {
            return;
        }
        QZoneDetailService U = QZoneDetailService.U();
        U.B0(businessFeedData);
        if (TextUtils.isEmpty(businessFeedData.getCommentInfo().attachInfo)) {
            U.a0(businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().appid, businessFeedData.getIdInfo().cellId, businessFeedData.getIdInfo().subId, businessFeedData.getCommentInfo().attachInfo, 50, businessFeedData.getOperationInfo().busiParam, 1048577, false, false, handler);
        } else {
            U.a0(businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().appid, businessFeedData.getIdInfo().cellId, businessFeedData.getIdInfo().subId, businessFeedData.getCommentInfo().attachInfo, 50, businessFeedData.getOperationInfo().busiParam, 1048578, false, false, handler);
        }
        if (businessFeedData.getCommentEssence() != null) {
            if (TextUtils.isEmpty(businessFeedData.getCommentEssence().attachInfo)) {
                U.b0(businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().appid, businessFeedData.getIdInfo().cellId, businessFeedData.getIdInfo().subId, businessFeedData.getCommentEssence().attachInfo, 50, businessFeedData.getOperationInfo().busiParam, 1048577, false, false, handler);
            } else {
                U.b0(businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().appid, businessFeedData.getIdInfo().cellId, businessFeedData.getIdInfo().subId, businessFeedData.getCommentEssence().attachInfo, 50, businessFeedData.getOperationInfo().busiParam, 1048578, false, false, handler);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Long i0(QZoneTask qZoneTask, int i3) {
        g0("onResponseSuccess start requestType:" + i3, true);
        boolean z16 = i3 != 1;
        QZoneResult result = qZoneTask.getResult(z16 ? 999910 : 999912);
        long j3 = -1L;
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) qZoneTask.mRequest.rsp;
        if (mobile_feeds_rspVar != null) {
            FunnySpace funnySpace = mobile_feeds_rspVar.stFunnySpace;
            if (funnySpace != null && funnySpace.Actions != null) {
                ArrayList arrayList = new ArrayList(mobile_feeds_rspVar.stFunnySpace.Actions.size());
                Iterator<FunnySpaceAction> it = mobile_feeds_rspVar.stFunnySpace.Actions.iterator();
                while (it.hasNext()) {
                    FunnySpaceAction next = it.next();
                    if (next != null) {
                        arrayList.add(FunnySpaceModel.create(next));
                    }
                }
            }
            Map<String, String> map = mobile_feeds_rspVar.stMapExtendinfo;
            if (map != null) {
                String str = map.get("HasGetSecretFeeds");
                if (str != null && str.equals("1")) {
                    com.qzone.app.k.f44493a = true;
                } else {
                    com.qzone.app.k.f44493a = false;
                }
                String str2 = mobile_feeds_rspVar.stMapExtendinfo.get(KUOLIE_CAMPUS_TAG.value);
                if (!TextUtils.isEmpty(str2)) {
                    this.I = Arrays.asList(str2.split(";"));
                }
            }
            s_campus_info s_campus_infoVar = mobile_feeds_rspVar.stCampusInfo;
            if (s_campus_infoVar != null && !TextUtils.isEmpty(s_campus_infoVar.strSchoolName)) {
                LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOLNAME, mobile_feeds_rspVar.stCampusInfo.strSchoolName, LoginData.getInstance().getUin());
                LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOL_ID, mobile_feeds_rspVar.stCampusInfo.strSchoolID, LoginData.getInstance().getUin());
                LocalMultiProcConfig.putInt4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_VERFYSTATUS, mobile_feeds_rspVar.stCampusInfo.eVerfyStatus, LoginData.getInstance().getUin());
                LocalMultiProcConfig.putLong4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOL_IDX, mobile_feeds_rspVar.stCampusInfo.iSchoolIdx, LoginData.getInstance().getUin());
            }
            login_uin_info login_uin_infoVar = mobile_feeds_rspVar.loginuin_info;
            if (login_uin_infoVar != null) {
                u5.b.q0("highFiveNotifyStatus", login_uin_infoVar.highFiveNotifyStatus);
            }
            if (this.f47216d != 18 && z16) {
                if (mobile_feeds_rspVar.stMemoryInfo != null) {
                    try {
                        f47176h0 = Long.valueOf(Long.valueOf(r0.memory_time).longValue() * 1000);
                        s_memory_seal_off s_memory_seal_offVar = mobile_feeds_rspVar.stMemoryInfo;
                        f47177i0 = s_memory_seal_offVar.action_url;
                        f47180l0 = s_memory_seal_offVar.action_type;
                        f47182n0 = s_memory_seal_offVar.type;
                        f47178j0 = s_memory_seal_offVar.summary;
                        f47179k0 = s_memory_seal_offVar.button_text;
                        f47181m0 = true;
                        QLog.d("MemoryStore", 1, "get memory info from server:memory_time:" + f47176h0 + "memory_acturl" + f47177i0 + "memory_summary" + mobile_feeds_rspVar.stMemoryInfo.summary);
                    } catch (Exception e16) {
                        QZLog.e("MemoryStore", "parse data excepttion " + e16.toString());
                        f47181m0 = false;
                    }
                } else {
                    f47181m0 = false;
                }
            }
            if (this.f47216d == 0) {
                vo.d.b().f(LoginData.getInstance().getUin(), mobile_feeds_rspVar);
            }
            if (this.f47216d == 2) {
                QZoneRequest qZoneRequest = qZoneTask.mRequest;
                vo.d.b().e(qZoneRequest instanceof QZoneGetFriendFeedsRequest ? (QZoneGetFriendFeedsRequest) qZoneRequest : null, mobile_feeds_rspVar);
                EventCenter.getInstance().post("Feed", 29);
            }
            if (z16 && this.f47216d == 0) {
                b1((mobile_feeds_rsp) qZoneTask.mRequest.rsp);
                CanvasPublicAccountContainerView.clearCircleCache();
            }
            if (this.f47216d == 1 && i3 == 2) {
                if (!TextUtils.isEmpty(mobile_feeds_rspVar.undealFeedTime)) {
                    LocalMultiProcConfig.putString4Uin("qzone_passive_undealtime", mobile_feeds_rspVar.undealFeedTime, LoginData.getInstance().getUin());
                }
                int i16 = mobile_feeds_rspVar.undealFeedCount;
                if (i16 != -1) {
                    j3 = Long.valueOf(i16);
                }
                QZLog.i("QZoneFeedService", "onResponseSuccess undealCount:" + mobile_feeds_rspVar.undealFeedCount);
            }
            if (this.f47216d == 23) {
                this.K = mobile_feeds_rspVar.rank_param;
            }
            OutSiteShareService.a().k((mobile_feeds_rspVar.host_imbitmap & TPChannelLayout.TP_CH_BOTTOM_FRONT_LEFT) == 0 ? 0 : 241);
            QZoneHelper.saveQzonePermission((mobile_feeds_rspVar.host_imbitmap & 1792) == 0, LoginData.getInstance().getUin());
            s8.f.f433427g = mobile_feeds_rspVar.is_realname_succ;
            if (z16) {
                int i17 = mobile_feeds_rspVar.is_detail_report;
                u5.b.D0(i17 != 0 && i17 == 1, mobile_feeds_rspVar.network_report, System.currentTimeMillis() / 1000, LoginData.getInstance().getUin());
            }
            if (mobile_feeds_rspVar.dailyShuoShuoCount != -1) {
                int int4Uin = LocalMultiProcConfig.getInt4Uin("qzone_daily_shuoshuo_count", -1, LoginData.getInstance().getUin());
                int i18 = mobile_feeds_rspVar.dailyShuoShuoCount;
                if (int4Uin != i18) {
                    LocalMultiProcConfig.putInt4Uin("qzone_daily_shuoshuo_count", i18, LoginData.getInstance().getUin());
                    EventCenter.getInstance().post("Feed", 36, Integer.valueOf(mobile_feeds_rspVar.dailyShuoShuoCount));
                }
            }
        }
        if (z16) {
            try {
            } catch (Throwable th5) {
                MonitorManager.f().h(21, 9, "\u89e3\u6790\u6570\u636e\u5f02\u5e38 " + th5, false);
                QZLog.e(QZLog.TO_DEVICE_TAG, "decode error ", th5);
            }
            if (qZoneTask.mResultCode == 0 && qZoneTask.mUniAttr != null && this.f47189i.getUin() != 0) {
                r0(qZoneTask, result);
                E0(qZoneTask, result);
                try {
                    q0(qZoneTask, result);
                } catch (Throwable th6) {
                    MonitorManager.f().h(3, 9, " \u8bfb\u53d6banner \u5f02\u5e38 " + th6, false);
                    QZLog.e("QZoneFeedService", 1, th6, new Object[0]);
                    ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(th6, "readBanner crash uin:" + LoginData.getInstance().getUinString());
                }
                L0(qZoneTask, result);
                J0(qZoneTask, result);
                I0(qZoneTask, result);
                M0(mobile_feeds_rspVar);
                int i19 = this.f47216d;
                if (i19 == 0 || i19 == 2) {
                    O0(qZoneTask, result);
                }
                K0(mobile_feeds_rspVar, this.f47216d);
                N0(mobile_feeds_rspVar);
                g0("onResponseSuccess end requestType:" + i3, true);
                qZoneTask.sendResultMsg(result);
                return j3;
            }
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, "refresh: " + z16 + ", code: " + qZoneTask.mResultCode + ", uniAttr" + qZoneTask.mUniAttr, (Throwable) null);
        g0("onResponseSuccess end requestType:" + i3, true);
        qZoneTask.sendResultMsg(result);
        return j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02de  */
    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m g(int i3, f.d dVar, t tVar, f.c cVar) {
        int i16;
        String str;
        int i17;
        String str2;
        String str3;
        boolean bool;
        boolean z16;
        int i18;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        RFWLog.i("request_feedx", RFWLog.USR, "sendRequest, requestType: " + i3 + ", opt: " + dVar);
        if (i3 == 1 || i3 == 0) {
            Y0("sendRequest", i3 == 0);
        }
        this.f47190m = cVar;
        int i19 = this.f47216d;
        if (i3 == 2) {
            if (i19 != 0) {
                i16 = 14;
                if (this.T == null) {
                    this.T = new HashMap<>();
                }
                HashMap<Integer, String> hashMap = this.T;
                str = this.Y;
                if (str == null) {
                    str = "";
                }
                hashMap.put(99, str);
                this.T.put(19, String.valueOf(this.f47183a0));
                if (i16 != 18) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(this.f47184b0 * 1000);
                    int i26 = calendar.get(2) + 1;
                    QZLog.d("ttt", 0, "sendRequest  " + calendar.get(1) + "\u5e74" + i26 + "\u6708 ");
                    this.T.put(42, String.valueOf(this.f47184b0));
                    this.T.put(118, String.valueOf(this.f47185c0));
                } else {
                    this.T.put(42, String.valueOf(this.Z));
                }
                String str4 = "1";
                if (n6.d.v()) {
                    this.T.put(128, "1");
                    QZLog.d("QZoneFeedService", 1, "---------------HasResidentBanner:1");
                }
                this.T.put(133, String.valueOf(this.J));
                i17 = this.f47216d;
                if (i17 == 1 && i17 != 14) {
                    str2 = QZoneJsConstants.TAG_QZONE_FORCE_REFREASH;
                    str3 = QZoneJsConstants.TAG_QZONE_FIRST_IN;
                } else {
                    str2 = QZoneJsConstants.TAG_QZONE_FORCE_REFREASH_PASSIVE;
                    str3 = QZoneJsConstants.TAG_QZONE_FIRST_IN_PASSIVE;
                }
                bool = LocalMultiProcConfig.getBool(str2, true);
                QZLog.d("QZoneFeedService", 1, "isForceRefrsh = ", Boolean.valueOf(bool), " ,feedType:", Integer.valueOf(this.f47216d));
                if (!bool) {
                    this.T.put(145, "1");
                    if (LocalMultiProcConfig.getBool(str3, true)) {
                        LocalMultiProcConfig.putBool(str2, true);
                        LocalMultiProcConfig.putBool(str3, false);
                    } else {
                        LocalMultiProcConfig.putBool(str2, false);
                    }
                } else {
                    this.T.remove(145);
                }
                if (this.f47216d == 0 || !(i3 == 0 || i3 == 2)) {
                    z16 = false;
                } else {
                    Set<String> d16 = AlbumRecReporter.D.d();
                    if (d16.size() > 0) {
                        this.T.put(186, com.qzone.util.f.c(d16));
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i3 == 0 && this.D && (arrayList2 = this.F) != null && arrayList2.size() > 0) {
                        this.T.put(209, this.F.get(0));
                        this.D = false;
                        QLog.d("QZoneFeedService", 1, "jump attach1");
                    }
                }
                if (i3 == 1 && this.D && (arrayList = this.F) != null && arrayList.size() > 0) {
                    this.T.put(211, "1");
                    this.D = false;
                    QLog.d("QZoneFeedService", 1, "jump attach2");
                }
                if (!z16) {
                    this.T.remove(186);
                }
                if (!QZoneApiProxy.isInQZoneEnvironment()) {
                    HashMap<Integer, String> hashMap2 = this.T;
                    if (!this.G) {
                        str4 = "0";
                    }
                    hashMap2.put(193, str4);
                }
                if (this.E && i3 == 4 && d0() == 2) {
                    if (this.F != null) {
                        this.T.put(210, this.F.get(1));
                    }
                    this.T.remove(209);
                    QLog.d("QZoneFeedService", 1, "jump back attach");
                }
                if (i3 == 4 || !this.E) {
                    this.T.remove(210);
                }
                QZoneGetFriendFeedsRequest qZoneGetFriendFeedsRequest = new QZoneGetFriendFeedsRequest(i16, (i3 != 1 || i3 == 3 || (i3 == 4 && !this.E)) ? 2 : 1, this.f47188h, dVar.f50211a, "", this.W, a0(), this.f47187f, "", this.X, this.f47186d0, this.T, this.K, this.Q, this.H);
                this.Q = null;
                this.T.remove(211);
                this.T.remove(209);
                if (i3 == 4) {
                    this.E = false;
                }
                qZoneGetFriendFeedsRequest.setRefer(this.V);
                qZoneGetFriendFeedsRequest.setAttachInfo(dVar.f50215e);
                qZoneGetFriendFeedsRequest.setTlvAttachInfo(dVar.f50216f);
                qZoneGetFriendFeedsRequest.setDeviceInfo(u5.a.f438267e);
                qZoneGetFriendFeedsRequest.setFeedInfos(dVar.f50217g);
                qZoneGetFriendFeedsRequest.setLayoutFileInfo(dVar.f50218h);
                if (!this.G) {
                    qZoneGetFriendFeedsRequest.setScene(1);
                } else if (!QZoneApiProxy.isInQZoneEnvironment() && ((i18 = this.f47216d) == 0 || i18 == 24)) {
                    qZoneGetFriendFeedsRequest.setScene(2);
                }
                if (this.f47216d == 28) {
                    qZoneGetFriendFeedsRequest.setConfigurableCommand(this.R);
                    qZoneGetFriendFeedsRequest.setConfigurableExtendInfo(this.S);
                    QZLog.i("QZoneFeedService", "SendFeedRequest, type: common push feeds, command: " + this.R);
                }
                QZoneTask qZoneTask = new QZoneTask(qZoneGetFriendFeedsRequest, tVar != null ? tVar.a() : null, this, a.C(i3));
                m b16 = m.b(qZoneTask);
                QZoneBusinessLooper.getInstance().runTask(qZoneTask);
                return b16;
            }
            i19 = 11;
        }
        i16 = i19;
        if (this.T == null) {
        }
        HashMap<Integer, String> hashMap3 = this.T;
        str = this.Y;
        if (str == null) {
        }
        hashMap3.put(99, str);
        this.T.put(19, String.valueOf(this.f47183a0));
        if (i16 != 18) {
        }
        String str42 = "1";
        if (n6.d.v()) {
        }
        this.T.put(133, String.valueOf(this.J));
        i17 = this.f47216d;
        if (i17 == 1) {
        }
        str2 = QZoneJsConstants.TAG_QZONE_FORCE_REFREASH_PASSIVE;
        str3 = QZoneJsConstants.TAG_QZONE_FIRST_IN_PASSIVE;
        bool = LocalMultiProcConfig.getBool(str2, true);
        QZLog.d("QZoneFeedService", 1, "isForceRefrsh = ", Boolean.valueOf(bool), " ,feedType:", Integer.valueOf(this.f47216d));
        if (!bool) {
        }
        if (this.f47216d == 0) {
        }
        z16 = false;
        if (i3 == 1) {
            this.T.put(211, "1");
            this.D = false;
            QLog.d("QZoneFeedService", 1, "jump attach2");
        }
        if (!z16) {
        }
        if (!QZoneApiProxy.isInQZoneEnvironment()) {
        }
        if (this.E) {
            if (this.F != null) {
            }
            this.T.remove(209);
            QLog.d("QZoneFeedService", 1, "jump back attach");
        }
        if (i3 == 4) {
        }
        this.T.remove(210);
        QZoneGetFriendFeedsRequest qZoneGetFriendFeedsRequest2 = new QZoneGetFriendFeedsRequest(i16, (i3 != 1 || i3 == 3 || (i3 == 4 && !this.E)) ? 2 : 1, this.f47188h, dVar.f50211a, "", this.W, a0(), this.f47187f, "", this.X, this.f47186d0, this.T, this.K, this.Q, this.H);
        this.Q = null;
        this.T.remove(211);
        this.T.remove(209);
        if (i3 == 4) {
        }
        qZoneGetFriendFeedsRequest2.setRefer(this.V);
        qZoneGetFriendFeedsRequest2.setAttachInfo(dVar.f50215e);
        qZoneGetFriendFeedsRequest2.setTlvAttachInfo(dVar.f50216f);
        qZoneGetFriendFeedsRequest2.setDeviceInfo(u5.a.f438267e);
        qZoneGetFriendFeedsRequest2.setFeedInfos(dVar.f50217g);
        qZoneGetFriendFeedsRequest2.setLayoutFileInfo(dVar.f50218h);
        if (!this.G) {
        }
        if (this.f47216d == 28) {
        }
        QZoneTask qZoneTask2 = new QZoneTask(qZoneGetFriendFeedsRequest2, tVar != null ? tVar.a() : null, this, a.C(i3));
        m b162 = m.b(qZoneTask2);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask2);
        return b162;
    }

    private void h0(final QZoneTask qZoneTask, final int i3) {
        int i16 = i3 == 1 ? 999903 : 999902;
        if (i3 == 3 || i3 == 4) {
            i16 = 1000152;
        }
        QZoneResult result = qZoneTask.getResult(i16);
        if (qZoneTask.mResultCode != 0) {
            g0("request failed (resultCode:" + qZoneTask.mResultCode + ",requestType:" + i3 + ")", true);
            f.c cVar = this.f47190m;
            if (cVar != null) {
                cVar.onFailed(m.b(qZoneTask), s.c(result));
            }
            if (this.f47216d == 1 && i3 == 2) {
                LocalMultiProcConfig.putInt4Uin("qzone_passive_need_refresh", 1, LoginData.getInstance().getUin());
                Handler handler = qZoneTask.getHandler();
                if (handler != null) {
                    Message obtain = Message.obtain(handler);
                    obtain.what = 999911;
                    obtain.arg1 = 1;
                    obtain.sendToTarget();
                    return;
                }
                return;
            }
            return;
        }
        f.c cVar2 = this.f47190m;
        if (cVar2 != null) {
            cVar2.onSucceed(m.b(qZoneTask), s.c(result), s8.g.q(qZoneTask), i3);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.qzone.feed.business.service.QZoneFeedService.1
            @Override // java.lang.Runnable
            public void run() {
                Long i06 = QZoneFeedService.this.i0(qZoneTask, i3);
                if (QZoneFeedService.this.f47216d == 1 && i3 == 2) {
                    LocalMultiProcConfig.putInt4Uin("qzone_passive_need_refresh", 0, LoginData.getInstance().getUin());
                    Handler handler2 = qZoneTask.getHandler();
                    if (handler2 != null) {
                        Message obtain2 = Message.obtain(handler2);
                        obtain2.arg1 = 0;
                        obtain2.obj = i06;
                        obtain2.what = 999911;
                        obtain2.sendToTarget();
                    }
                }
            }
        }, 5, null, true);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    public void d(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    public void e(com.qzone.adapter.feedcomponent.c cVar, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.b
    public void j(com.qzone.adapter.feedcomponent.c cVar, boolean z16, int i3) {
    }
}
