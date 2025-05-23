package com.tencent.biz.pubaccount.weishi.report;

import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.qzone.widget.u;
import com.tencent.biz.pubaccount.weishi.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi.push.WSPushGloryKingModel;
import com.tencent.biz.pubaccount.weishi.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes32.dex */
public class WSPublicAccReport {
    private static final String KEY_ENTER_PUBLIC_FROM = "key_enter_public_from";
    private static final String KEY_PLAY_SCENE = "play_scene";
    private static final String KEY_SCENES_CHANNEL_FROM = "key_scenes_channel_from";
    private static final String KEY_SESSION_ID = "key_session_id";
    private static final String KEY_SESSION_STAMP = "key_session_stamp";
    public static final String SOP_NAME_FEEDS = "feeds";
    public static final String SOP_NAME_FOCUS = "focus";
    public static final String SOP_NAME_FOCUS_FALLBACK = "focus_fallback";
    public static final String SOP_NAME_VIDEO_PLAY = "fullscreen_videoplay";
    private static volatile WSPublicAccReport instance;
    private String mEnterPublicAccFrom;
    private boolean mIsReportedEnter;
    private String mLocalTestId;
    private String mPushId;
    private b mRecommendFullScreenInfo;
    private String mScenesChannelFrom;
    private String mSessionId;
    private String mSessionStamp;
    private Map<String, Long> pageVisitTimeMap = new HashMap();
    private long publicAccEnterTime;
    private long toBackgroundTime;
    private long toForegroundTime;
    private long toTrendsWSBackgroundTime;
    private long toTrendsWSForegroundTime;
    private long trendsWSEnterTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements ty.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81470a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f81471b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f81472c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f81473d;

        a(String str, String str2, int i3, HashMap hashMap) {
            this.f81470a = str;
            this.f81471b = str2;
            this.f81472c = i3;
            this.f81473d = hashMap;
        }

        @Override // ty.b
        public void a(int i3) {
            WSPublicAccReport.this.publicAccActionReport("1", i3, this.f81470a, this.f81471b, this.f81472c, 0L, 0, this.f81473d);
        }
    }

    /* loaded from: classes32.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f81475a;

        /* renamed from: b, reason: collision with root package name */
        int f81476b;

        /* renamed from: c, reason: collision with root package name */
        boolean f81477c = true;

        public b() {
        }

        public boolean b() {
            return this.f81477c;
        }

        public long a() {
            this.f81477c = false;
            return System.currentTimeMillis() - WSPublicAccReport.this.publicAccEnterTime;
        }

        public int c() {
            this.f81477c = false;
            return this.f81476b;
        }

        public int d() {
            this.f81477c = false;
            return this.f81475a;
        }

        public void e(String str) {
            this.f81475a = 1;
            this.f81476b = new WSVideoPreDownloadManager(BaseApplicationImpl.sApplication).n(str) ? 1 : 0;
        }
    }

    WSPublicAccReport() {
    }

    private void baseActionReport(String str, String str2, Map<String, String> map, Map<String, String> map2, String str3, int i3) {
        new WSStatisticsReporter.Builder().addParams(map).addExtParams(map2).setSopName(str2).setTestId(bb.x(i3)).setPushId(this.mPushId).setOperationId(str3).setFlush(true).build(str).report();
    }

    public static WSPublicAccReport getInstance() {
        if (instance == null) {
            synchronized (WSPublicAccReport.class) {
                if (instance == null) {
                    instance = new WSPublicAccReport();
                }
            }
        }
        return instance;
    }

    private void handleAddActionScene(HashMap<String, String> hashMap) {
        String b16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().b();
        if (TextUtils.isEmpty(b16)) {
            b16 = "-1";
        }
        hashMap.put("action_scene", b16);
    }

    private void handleIsNightMode(HashMap<String, String> hashMap) {
        String str;
        if (e00.b.b()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_night", str);
    }

    private void publicAccAction4RedDotReport(int i3, String str, String str2, HashMap<String, String> hashMap) {
        ty.g.f437886a.j(new a(str, str2, i3, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publicAccActionReport(String str, int i3, String str2, String str3, int i16, long j3, int i17, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, str);
        hashMap.put("push_count", String.valueOf(i3));
        hashMap.put("row_key", bb.v());
        hashMap.put("push_extra", str2);
        hashMap.put("app_extra", "");
        hashMap.put("push_entry", str3);
        hashMap.put("click_to", String.valueOf(i16));
        hashMap.put("app_live_time", String.valueOf(j3));
        hashMap.put("operation_or_not", String.valueOf(i17));
        baseActionReport("gzh_action", "", hashMap, map, "", 1);
    }

    private void reportPageVisited(String str, int i3, long j3, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, String.valueOf(i3));
        hashMap.put("page_live_time", String.valueOf(j3));
        if (map == null) {
            map = new HashMap<>();
        }
        baseActionReport("gzh_pageview", str, hashMap, map, "", 1);
    }

    private void resetLocalTestId() {
        this.mLocalTestId = LocalMultiProcConfig.getString4Uin("key_default_test_id", "", bb.o());
    }

    private void setSessionId(String str) {
        this.mSessionId = str;
        ai.p(KEY_SESSION_ID, str);
    }

    private void setSessionStamp(String str) {
        this.mSessionStamp = str;
        ai.p(KEY_SESSION_STAMP, str);
    }

    private void trendsTabActionReport(String str, int i3, String str2, String str3, int i16, long j3, int i17) {
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, str);
        hashMap.put("push_count", String.valueOf(i3));
        hashMap.put("row_key", bb.v());
        hashMap.put("push_extra", str2);
        hashMap.put("app_extra", "");
        hashMap.put("push_entry", str3);
        hashMap.put("click_to", String.valueOf(i16));
        hashMap.put("app_live_time", String.valueOf(j3));
        hashMap.put("operation_or_not", String.valueOf(i17));
        new WSStatisticsReporter.Builder().addParams(hashMap).setSopName("").setTestId(bb.x(6)).setPushId(this.mPushId).setOperationId("").setFlush(true).build("gzh_action").report();
    }

    public void backgroundPublicAccReport() {
        this.toBackgroundTime = System.currentTimeMillis();
        if (this.toForegroundTime == 0) {
            this.toForegroundTime = this.publicAccEnterTime;
        }
        publicAccActionReport("3", 0, "", "", 0, this.toForegroundTime > 0 ? System.currentTimeMillis() - this.toForegroundTime : 0L, 0, null);
    }

    public void closePublicAccReport(int i3) {
        long currentTimeMillis;
        long j3;
        long j16 = this.toForegroundTime;
        long j17 = 0;
        if (j16 > 0) {
            if (this.toBackgroundTime < j16) {
                currentTimeMillis = System.currentTimeMillis();
                j3 = this.toForegroundTime;
                j17 = currentTimeMillis - j3;
            }
        } else if (this.publicAccEnterTime > 0) {
            currentTimeMillis = System.currentTimeMillis();
            j3 = this.publicAccEnterTime;
            j17 = currentTimeMillis - j3;
        }
        publicAccActionReport("2", 0, "", "", 0, j17, i3, null);
        reset();
    }

    public void enterPublicAccReport(WSRedDotPushMsg wSRedDotPushMsg, int i3, String str, Bundle bundle) {
        String str2;
        String str3;
        String valueOf;
        if (this.mIsReportedEnter) {
            return;
        }
        resetLocalTestId();
        long currentTimeMillis = System.currentTimeMillis();
        this.publicAccEnterTime = currentTimeMillis;
        this.toForegroundTime = currentTimeMillis;
        this.mIsReportedEnter = true;
        setSessionId(String.valueOf(currentTimeMillis));
        setSessionStamp(String.valueOf(this.publicAccEnterTime));
        setEnterPublicAccFrom(str);
        HashMap<String, String> hashMap = new HashMap<>();
        String str4 = "";
        this.mPushId = "";
        if (wSRedDotPushMsg == null) {
            str2 = "2";
        } else {
            this.mPushId = wSRedDotPushMsg.mPushId;
            str4 = wSRedDotPushMsg.mMsgData;
            IWSPushBaseStrategy iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo;
            if (iWSPushBaseStrategy instanceof WSPushStrategyInfo) {
                WSPushPreloadModel wSPushPreloadModel = ((WSPushStrategyInfo) iWSPushBaseStrategy).mWSPushPreloadModel;
                WSPushGloryKingModel wSPushGloryKingModel = ((WSPushStrategyInfo) iWSPushBaseStrategy).mWSPushGloryKingModel;
                if (wSPushPreloadModel != null) {
                    if (wSPushPreloadModel.f81335d) {
                        valueOf = String.valueOf(1);
                    } else {
                        valueOf = String.valueOf(0);
                    }
                    hashMap.put("preload_status", valueOf);
                }
                if (wSPushGloryKingModel != null) {
                    hashMap.put("material_type", String.valueOf(wSPushGloryKingModel.f81331d));
                }
            }
            str2 = "1";
        }
        if (TextUtils.equals(str2, "2")) {
            if (bb.C() != null) {
                str3 = bb.w();
            } else {
                str3 = "0";
            }
            hashMap.put("is_yunying_content", str3);
        }
        hashMap.put("aio_index", Integer.toString(ry.a.e() + 1));
        if (i3 == 3) {
            i3 = 1;
        }
        handleIntentBundle(bundle, hashMap);
        handleAddActionScene(hashMap);
        handleIsNightMode(hashMap);
        publicAccAction4RedDotReport(i3, str4, str2, hashMap);
    }

    public void enterTrendsTabReport(WSRedDotPushMsg wSRedDotPushMsg, boolean z16) {
        int i3;
        String str;
        IWSPushBaseStrategy iWSPushBaseStrategy;
        long currentTimeMillis = System.currentTimeMillis();
        this.trendsWSEnterTime = currentTimeMillis;
        this.toTrendsWSForegroundTime = currentTimeMillis;
        setSessionId(String.valueOf(currentTimeMillis));
        setSessionStamp(String.valueOf(this.trendsWSEnterTime));
        String str2 = "";
        this.mPushId = "";
        if (wSRedDotPushMsg == null || (iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo) == null) {
            i3 = 2;
        } else {
            this.mPushId = wSRedDotPushMsg.mPushId;
            str2 = wSRedDotPushMsg.mMsgData;
            i3 = iWSPushBaseStrategy.getType();
        }
        int i16 = i3;
        String str3 = str2;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        trendsTabActionReport("1", 0, str3, str, i16, 0L, 0);
    }

    public void feedsItemForPushReport(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", "");
        hashMap.put("feed_id", "");
        hashMap.put("owner_id", "");
        if (i3 != 0) {
            hashMap.put("action_id", String.valueOf(i3));
        }
        baseActionReport(str, "feeds", hashMap, new HashMap<>(), "", 1);
    }

    public void foregroundPublicAccReport() {
        long currentTimeMillis = System.currentTimeMillis();
        this.toForegroundTime = currentTimeMillis;
        setSessionStamp(String.valueOf(currentTimeMillis));
        publicAccActionReport("4", 0, "", "", 0, 0L, 0, null);
    }

    public String getEnterPublicAccFrom() {
        if (TextUtils.isEmpty(this.mEnterPublicAccFrom)) {
            this.mEnterPublicAccFrom = ai.i(KEY_ENTER_PUBLIC_FROM, "");
        }
        return this.mEnterPublicAccFrom;
    }

    public Map<String, String> getFeedsBaseParams(String str, int i3, stSimpleMetaFeed stsimplemetafeed) {
        String str2;
        String str3;
        if (stsimplemetafeed != null) {
            str3 = stsimplemetafeed.map_ext != null ? new Gson().toJson(stsimplemetafeed.map_ext) : "";
            str2 = stsimplemetafeed.traceId;
        } else {
            str2 = "";
            str3 = str2;
        }
        return getFeedsBaseParams(str, i3, stsimplemetafeed, str2, str3);
    }

    public String getLocalTestId() {
        return this.mLocalTestId;
    }

    public String getPushId() {
        return this.mPushId;
    }

    public b getRecommendFullScreenInfo() {
        if (this.mRecommendFullScreenInfo == null) {
            this.mRecommendFullScreenInfo = new b();
        }
        return this.mRecommendFullScreenInfo;
    }

    public String getScenesChannelFrom() {
        if (TextUtils.isEmpty(this.mScenesChannelFrom)) {
            this.mScenesChannelFrom = ai.i(KEY_SCENES_CHANNEL_FROM, "");
        }
        return this.mScenesChannelFrom;
    }

    public String getSessionId() {
        if (TextUtils.isEmpty(this.mSessionId)) {
            return ai.i(KEY_SESSION_ID, "");
        }
        return this.mSessionId;
    }

    public String getSessionStamp() {
        if (TextUtils.isEmpty(this.mSessionStamp)) {
            return ai.i(KEY_SESSION_STAMP, "");
        }
        return this.mSessionStamp;
    }

    public boolean isInWSPublicAccount() {
        return this.mIsReportedEnter;
    }

    public void reportAttentionClick(int i3, String str, boolean z16) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("red_dot_quantity", String.valueOf(i3));
        if (z16) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        hashMap.put("is_click", str2);
        baseActionReport("gzh_click", str, getFeedsBaseParamsWithoutFeed("follow_tab", 1000001), hashMap, "", 10001);
    }

    public void reportAvatarViewClick(String str) {
        baseActionReport("gzh_click", str, getFeedsBaseParamsWithoutFeed("profile_tab", 1000001), null, "", 10001);
    }

    public void reportCallDialog(String str, String str2, String str3, int i3) {
        baseActionReport(str, str2, getFeedsBaseParamsWithoutFeed(str3, i3), null, "", 1);
    }

    public void reportClickRichBlockPop(int i3, int i16, String str, String str2, int i17) {
        Map<String, String> feedsBaseParamsWithoutFeed = getFeedsBaseParamsWithoutFeed("popup", i3);
        feedsBaseParamsWithoutFeed.put("global_key", c.b().c(str));
        baseActionReport("gzh_click", str2, feedsBaseParamsWithoutFeed, null, String.valueOf(i16), i17);
    }

    public void reportDownload(int i3, int i16, int i17, int i18, int i19, int i26) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", String.valueOf(i3));
        hashMap.put(CGNonAgeReport.EVENT_TYPE, String.valueOf(i16));
        hashMap.put("dl_status", String.valueOf(i17));
        hashMap.put("dl_method", String.valueOf(i18));
        hashMap.put("install_status", String.valueOf(i19));
        x.l("beacon-download", i3 + " - " + i16 + " - " + i17 + " - " + i18 + " - " + i19);
        baseActionReport("gzh_download", "", hashMap, null, "", i26);
    }

    public void reportExposeRichBlockPop(int i3, String str, String str2, int i16) {
        Map<String, String> feedsBaseParamsWithoutFeed = getFeedsBaseParamsWithoutFeed("popup", 0);
        feedsBaseParamsWithoutFeed.put("global_key", c.b().c(str));
        baseActionReport("gzh_exposure", str2, feedsBaseParamsWithoutFeed, null, String.valueOf(i3), i16);
    }

    public void reportHomeBackTipsExposure() {
        baseActionReport("gzh_exposure", "monofeed", getFeedsBaseParamsWithoutFeed("quit_remind", 0), null, "", 10001);
    }

    public void reportImmersionClick(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("is_click", str);
        baseActionReport("gzh_click", SOP_NAME_FOCUS, getFeedsBaseParamsWithoutFeed("monofeed_tab", 1000001), hashMap, "", 10001);
    }

    public void reportMenuItemClick(String str, String str2) {
        baseActionReport("gzh_click", str2, getFeedsBaseParamsWithoutFeed(str, 1000001), null, "", 10001);
    }

    public void reportMessageBubblePopupClick(String str) {
        baseActionReport("gzh_click", str, getFeedsBaseParamsWithoutFeed("news_popup", 1000001), null, "", 10001);
    }

    public void reportMessageBubblePopupExposure(String str) {
        baseActionReport("gzh_exposure", str, getFeedsBaseParamsWithoutFeed("news_popup", 0), null, "", 10001);
    }

    public void reportMonoTabGuideClick(String str) {
        baseActionReport("gzh_click", str, getFeedsBaseParamsWithoutFeed("monofeed_tab_guide", 1000001), null, "", 10001);
    }

    public void reportMonoTabGuideExposure(String str) {
        baseActionReport("gzh_exposure", str, getFeedsBaseParamsWithoutFeed("monofeed_tab_guide", 0), null, "", 10001);
    }

    public void reportMonoTabRedDotExposure(String str) {
        baseActionReport("gzh_exposure", str, getFeedsBaseParamsWithoutFeed("monofeed_tab_redpoint", 0), null, "", 10001);
    }

    public void reportMsgEntry(String str, int i3, int i16, int i17, String str2) {
        Map<String, String> feedsBaseParamsWithoutFeed = getFeedsBaseParamsWithoutFeed("msg_extry", i16);
        feedsBaseParamsWithoutFeed.put("global_key", c.b().c(str2));
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i3));
        baseActionReport(str, "feeds", feedsBaseParamsWithoutFeed, hashMap, String.valueOf(i17), 4);
    }

    public void reportPageVisitEnter(String str) {
        reportPageVisitEnter(str, null);
    }

    public void reportPageVisitExit(String str) {
        reportPageVisitExit(str, null);
    }

    public void reportPublicAccDetailClick() {
        baseActionReport("gzh_click", "feeds", getFeedsBaseParamsWithoutFeed("wesee_info", 1000001), null, "", 1);
    }

    public void reportPublisher(String str, String str2, String str3, int i3) {
        baseActionReport(str, str2, getFeedsBaseParamsWithoutFeed(str3, i3), null, "", 10004);
    }

    public void reportRecommendClick(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("is_click", str);
        baseActionReport("gzh_click", SOP_NAME_FOCUS, getFeedsBaseParamsWithoutFeed("recommend_tab", 1000001), hashMap, "", 10001);
    }

    public void reportSpeedExposure(String str, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        baseActionReport("gzh_exposure", str, getFeedsBaseParams("speed_btn", 0, stsimplemetafeed), map, "", 1);
    }

    public void reportSpeedItemClick(String str, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        baseActionReport("gzh_click", str, getFeedsBaseParams("speed_btn", 1000001, stsimplemetafeed), map, "", 1);
    }

    public void reportTabLiveBtnClick(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("btn_status", "1");
        hashMap.put("source", "31");
        baseActionReport("gzh_click", str, getFeedsBaseParamsWithoutFeed("live_jump", i3), hashMap, "", 10010);
    }

    public void reportTabLiveBtnExposure(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("btn_status", "1");
        baseActionReport("gzh_exposure", str, getFeedsBaseParamsWithoutFeed("live_jump", 0), hashMap, "", 10010);
    }

    public void reportVideoPlayUpdateExp(int i3) {
        new WSStatisticsReporter.Builder().addParams(getFeedsBaseParamsWithoutFeed("videoplay_update", 0)).setSopName(SOP_NAME_VIDEO_PLAY).setTestId(bb.x(1)).setPushId(this.mPushId).setFlush(true).build("gzh_exposure").report();
    }

    public void setEnterPublicAccFrom(String str) {
        this.mEnterPublicAccFrom = str;
        ai.p(KEY_ENTER_PUBLIC_FROM, str);
    }

    public void setScenesChannelFrom(String str) {
        this.mScenesChannelFrom = str;
        ai.p(KEY_SCENES_CHANNEL_FROM, str);
    }

    public void trendsCloseReport(int i3) {
        long currentTimeMillis;
        long j3;
        long j16 = this.toTrendsWSForegroundTime;
        long j17 = 0;
        if (j16 > 0) {
            if (this.toTrendsWSBackgroundTime < j16) {
                currentTimeMillis = System.currentTimeMillis();
                j3 = this.toTrendsWSForegroundTime;
                j17 = currentTimeMillis - j3;
            }
        } else if (this.trendsWSEnterTime > 0) {
            currentTimeMillis = System.currentTimeMillis();
            j3 = this.trendsWSEnterTime;
            j17 = currentTimeMillis - j3;
        }
        publicAccActionReport("2", 0, "", "", 0, j17, i3, null);
        reset();
    }

    public void trendsWSBackgroundReport() {
        this.toTrendsWSBackgroundTime = System.currentTimeMillis();
        if (this.toTrendsWSForegroundTime == 0) {
            this.toTrendsWSForegroundTime = this.trendsWSEnterTime;
        }
        publicAccActionReport("3", 0, "", "", 0, this.toTrendsWSForegroundTime > 0 ? System.currentTimeMillis() - this.toTrendsWSForegroundTime : 0L, 0, null);
    }

    public void trendsWSForegroundReport() {
        long currentTimeMillis = System.currentTimeMillis();
        this.toTrendsWSForegroundTime = currentTimeMillis;
        setSessionStamp(String.valueOf(currentTimeMillis));
        publicAccActionReport("4", 0, "", "", 0, 0L, 0, null);
    }

    private void reset() {
        this.mIsReportedEnter = false;
        this.mRecommendFullScreenInfo = null;
        this.mPushId = "";
        this.pageVisitTimeMap.clear();
        bb.W("");
        e.f81528c = false;
        WSRedDotPreloadManager.d().j();
        ba.z();
        ty.g.f437886a.r(null);
    }

    public Map<String, String> getFeedsBaseParamsWithoutFeed(String str, int i3) {
        return getFeedsBaseParams(str, i3, null);
    }

    public void reportCallDialog(String str, String str2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("location", str2);
        baseActionReport(str, SOP_NAME_FOCUS, getFeedsBaseParamsWithoutFeed("jump_window", i3), hashMap, "", 1);
    }

    public void reportPageVisitEnter(String str, Map<String, String> map) {
        this.pageVisitTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        reportPageVisited(str, 1, 0L, map);
    }

    public void reportPageVisitExit(String str, Map<String, String> map) {
        long j3 = 0;
        Long l3 = 0L;
        Map<String, Long> map2 = this.pageVisitTimeMap;
        if (map2 != null) {
            l3 = map2.get(str);
        }
        if (l3 != null && l3.longValue() > 0) {
            j3 = System.currentTimeMillis() - l3.longValue();
        }
        reportPageVisited(str, 2, j3, map);
    }

    private String getFeedOpVideoType(stSimpleMetaFeed stsimplemetafeed) {
        stOpVideo stopvideo;
        return String.valueOf((stsimplemetafeed == null || (stopvideo = stsimplemetafeed.opVideo) == null) ? 0 : stopvideo.videoType);
    }

    public void reportShareClick(String str, int i3, String str2, String str3, stSimpleMetaFeed stsimplemetafeed, Map<String, String> map) {
        String str4;
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        map2.put("material_type", getFeedOpVideoType(stsimplemetafeed));
        if (!TextUtils.isEmpty(str3)) {
            map2.put("play_scene", str3);
        }
        if (i3 == 1003012) {
            map2.put("jubao_from", "1");
        }
        if (f.b(str2)) {
            str4 = com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.m();
        } else {
            str4 = "";
        }
        map2.put(u.COLUMN_TAB_ID, str4);
        baseActionReport("gzh_click", str2, getFeedsBaseParams(str, i3, stsimplemetafeed), map2, "", 1);
    }

    private void handleIntentBundle(Bundle bundle, HashMap<String, String> hashMap) {
        if (bundle == null) {
            return;
        }
        if (!TextUtils.isEmpty(bundle.getString("spid"))) {
            hashMap.put("spid", bundle.getString("spid"));
        }
        if (!TextUtils.isEmpty(bundle.getString("share_feed_id"))) {
            hashMap.put("share_feedid", bundle.getString("share_feed_id"));
        }
        if (!TextUtils.isEmpty(bundle.getString("share_collection_id"))) {
            hashMap.put("share_collection_id", bundle.getString("share_collection_id"));
        }
        if (!TextUtils.isEmpty(bundle.getString("share_active_id"))) {
            hashMap.put("share_active_id", bundle.getString("share_active_id"));
        }
        if (!TextUtils.isEmpty(bundle.getString(TuxDialogBundleKey.WEB_URL))) {
            hashMap.put(TuxDialogBundleKey.WEB_URL, bundle.getString(TuxDialogBundleKey.WEB_URL));
        }
        String string = bundle.getString("scenes_channel_from");
        if (!TextUtils.isEmpty(string)) {
            setScenesChannelFrom(string);
            hashMap.put("share_scenes_from", string);
        }
        if (TextUtils.isEmpty(bundle.getString("web_test_id"))) {
            return;
        }
        hashMap.put("web_test_id", bundle.getString("web_test_id"));
    }

    public Map<String, String> getFeedsBaseParams(String str, int i3, stSimpleMetaFeed stsimplemetafeed, String str2, String str3) {
        String str4;
        String str5;
        HashMap hashMap = new HashMap();
        if (i3 != 0) {
            hashMap.put("action_id", String.valueOf(i3));
        }
        if (stsimplemetafeed != null) {
            str4 = stsimplemetafeed.f25129id;
            str5 = stsimplemetafeed.poster_id;
        } else {
            str4 = "";
            str5 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("global_key", c.b().c(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("feed_pass_key", str3);
        }
        hashMap.put("position", str);
        hashMap.put("feed_id", str4);
        hashMap.put("owner_id", str5);
        return hashMap;
    }

    public void reportAttentionRedDotExposure(int i3, String str) {
        if (i3 <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("red_dot_quantity", String.valueOf(i3));
        baseActionReport("gzh_exposure", str, getFeedsBaseParamsWithoutFeed("follow_tab", 1000001), hashMap, "", 10001);
    }

    public void reportDownload(int i3, int i16, int i17, int i18, int i19) {
        reportDownload(i3, i16, i17, i18, i19, 1);
    }
}
