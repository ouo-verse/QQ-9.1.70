package com.tencent.biz.qqcircle.immersive.report;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.gson.reflect.TypeToken;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSFirstRenderCostInfoListBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.qqcircle.utils.bv;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.util.VSNetworkSpeedHelper;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import gb0.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;
import org.json.JSONObject;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f implements t40.f {
    private static final AtomicBoolean L = new AtomicBoolean(true);
    private static final HashSet<String> M;
    private static boolean N;
    private long C;
    private boolean D;
    private boolean E;
    private int H;
    private int I;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f89732e;

    /* renamed from: f, reason: collision with root package name */
    private final String f89733f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<View> f89734h;

    /* renamed from: i, reason: collision with root package name */
    private long f89735i;

    /* renamed from: m, reason: collision with root package name */
    private long f89736m;
    private final Map<String, String> F = Collections.synchronizedMap(new LinkedHashMap());
    private final ConcurrentHashMap<String, String> G = new ConcurrentHashMap<>();
    private boolean J = true;
    private int K = 0;

    /* renamed from: d, reason: collision with root package name */
    private final g f89731d = new g(M);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends TypeToken<QFSFirstRenderCostInfoListBean> {
        a() {
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        M = hashSet;
        N = true;
        hashSet.add("player_hit_pre_render");
        hashSet.add("player_hit_pre_render_and_succeed");
        hashSet.add("player_hit_cache");
        hashSet.add("page_appear_cost");
        hashSet.add("page_content_expose_cost");
        hashSet.add("video_first_render_cost");
        hashSet.add("ext");
        hashSet.add("load_type");
        hashSet.add("red_point_type");
        hashSet.add("red_point_need_refresh");
    }

    public f(String str) {
        this.f89733f = str;
        if (N) {
            N = !k.a().c("sp_key_have_visitor_all_push_page", false);
        }
        this.f89732e = N;
        E();
    }

    private void A() {
        B("is_publish_version", "1");
        B("is_gray_version", "0");
    }

    private void D(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        long d16 = this.f89731d.d();
        long currentTimeMillis2 = System.currentTimeMillis() - this.f89735i;
        z(RFWLog.USR, "reportPageOut pageReShowTimes:" + d16 + ",stayTime:" + currentTimeMillis2);
        g gVar = this.f89731d;
        String str = "1";
        if (QQVideoPlaySDKManager.isSDKReady()) {
            obj = "1";
        } else {
            obj = "0";
        }
        gVar.a("ext_sdk_init_succeed", obj);
        this.f89731d.a("stay_time", Long.valueOf(currentTimeMillis2));
        if (!this.D) {
            str = "0";
        }
        B("is_tab_mode", str);
        B(PictureConst.KEY_CLASSNAME, this.f89733f);
        A();
        k(d16);
        i();
        m();
        this.f89731d.a("ext_cost_info", n(this.F));
        if (feedCloudMeta$StFeed != null) {
            this.f89731d.a("feed_index", Integer.valueOf(i3 + 1));
            String d17 = ba.d(feedCloudMeta$StFeed);
            B("feed_info_type", String.valueOf(feedCloudMeta$StFeed.feedType.get()));
            this.f89731d.a("trace_id", d17);
            this.f89731d.a(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, Integer.valueOf(feedCloudMeta$StFeed.type.get()));
            this.f89731d.a("feed_id", feedCloudMeta$StFeed.f398449id.get());
        }
        d(feedCloudMeta$StFeed);
        this.f89731d.a("exp_info", n(this.G));
        Map<String, Object> c16 = this.f89731d.c();
        if (f()) {
            for (Map.Entry<String, Object> entry : c16.entrySet()) {
                z(RFWLog.USR, "reportPageOut key:" + entry.getKey() + ",val:" + entry.getValue());
            }
        }
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.XSJ_LAYER_PGOUT, o(), c16);
        long currentTimeMillis3 = System.currentTimeMillis();
        z(RFWLog.USR, "reportPageOut cost:" + (currentTimeMillis3 - currentTimeMillis));
    }

    private void F() {
        synchronized (this) {
            z(RFWLog.USR, "resetValues");
            this.f89731d.f();
            this.C = 0L;
            this.f89736m = 0L;
            this.f89735i = 0L;
            this.E = false;
            this.F.clear();
            this.G.clear();
            this.H = 0;
            this.I = 0;
            b.f().u();
        }
    }

    private void M() {
        View o16 = o();
        if (o16 == null) {
            z(RFWLog.USR, "trySetPageInfo rootView is null");
        } else if (TextUtils.isEmpty(DataRWProxy.getElementId(o16))) {
            VideoReport.setElementId(o16, "qfs_layer_element_id");
        }
    }

    private void d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        try {
            String str = feedCloudMeta$StFeed.video.fileId.get();
            QFSFirstRenderCostInfoListBean j3 = b.f().j(str);
            if (j3 == null) {
                j3 = b.f().h();
            }
            if (j3 == null) {
                RFWLog.d("QFSPlayPageReporter", RFWLog.USR, "[addFlowPlayPreparedCost] first render cost info should not be null.");
                return;
            }
            String c16 = bv.c(j3, new a().getType());
            if (f()) {
                z(RFWLog.USR, "[addFlowPlayPreparedCost] fileId: " + str + ",key:flow_cost_info,val:" + c16);
            }
            if (c16 == null) {
                RFWLog.d("QFSPlayPageReporter", RFWLog.USR, "[addFlowPlayPreparedCost] flow json is empty, not put to map.");
            } else {
                B("flow_cost_info", c16);
            }
        } catch (Throwable th5) {
            RFWLog.d("QFSPlayPageReporter", RFWLog.USR, "[addFlowPlayPreparedCost] error: ", th5);
        }
    }

    private void e(View view, Map<String, Object> map, String str, String str2, String str3) {
        String str4;
        String str5;
        Context context;
        if (view != null && (context = view.getContext()) != null) {
            str4 = String.valueOf(context.hashCode());
        } else {
            str4 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            String str6 = str + "_" + str4;
            map.put("ext5", str6);
            z(RFWLog.USR, "appendPageSession :" + str6 + ",dtPageId:" + str2);
            return;
        }
        if (!TextUtils.isEmpty(str3)) {
            str5 = str3 + "_" + str4;
        } else {
            str5 = str2 + "_" + str4;
        }
        z(RFWLog.USR, "appendPageSession origin :" + str5 + ",dtPageId:" + str2);
        map.put("ext5", str5);
    }

    private boolean f() {
        return false;
    }

    private void g(List<e30.b> list) {
        if (list != null && !list.isEmpty() && list.get(0) != null) {
            new gb0.d(new d.a() { // from class: com.tencent.biz.qqcircle.immersive.report.e
                @Override // gb0.d.a
                public final void a(float f16) {
                    f.this.s(f16);
                }
            }).b(list.get(0).g());
        } else {
            QLog.d("QFSPlayPageReporter", 1, "[collectFirstVideoCacheStatus] data invalid");
            B("first_video_cache_time", String.valueOf(0));
        }
    }

    private void h() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "1";
        if (this.f89732e) {
            str = "1";
        } else {
            str = "0";
        }
        B("is_first_init_all_push", str);
        if (com.tencent.mobileqq.qcircle.api.global.a.f261669j) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        B("hit_click_preload", str2);
        if (com.tencent.mobileqq.qcircle.api.global.a.f261670k) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        B("hit_priority_use_succeed_feed", str3);
        B("fast_play_first_render_cost", String.valueOf(com.tencent.mobileqq.qcircle.api.global.a.f261665f));
        if (com.tencent.mobileqq.qcircle.api.global.a.f261666g) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        B("fast_play_hit_cache", str4);
        if (com.tencent.mobileqq.qcircle.api.global.a.f261660a) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        B("fast_play_hit_prerender_succeed", str5);
        B("fast_play_cache_time", String.valueOf(com.tencent.mobileqq.qcircle.api.global.a.f261661b));
        if (com.tencent.mobileqq.qcircle.api.global.a.f261667h) {
            str6 = "1";
        } else {
            str6 = "0";
        }
        B("fast_play_hit_prerender", str6);
        if (!com.tencent.mobileqq.qcircle.api.global.a.f261668i) {
            str7 = "0";
        }
        B("fast_play_time_out", str7);
    }

    private void i() {
        String str;
        this.f89731d.a("network_type", QCircleReportHelper.getNetworkType());
        g gVar = this.f89731d;
        if (QCircleNetWorkTestHelper.f92533b.get()) {
            str = "1";
        } else {
            str = "0";
        }
        gVar.a("weak_network_flag", str);
        Pair<Double, Double> speedAndSucceedRate = VSNetworkSpeedHelper.getNetworkSpeedTest().getSpeedAndSucceedRate();
        this.f89731d.a("avg_cmd_cost", speedAndSucceedRate.first);
        this.f89731d.a("cmd_succeed_rate", speedAndSucceedRate.second);
    }

    private void j(List<e30.b> list) {
        this.f89735i = System.currentTimeMillis();
        if (this.f89731d.d() == 0) {
            this.f89731d.a("page_appear_cost", Long.valueOf(this.f89735i - this.f89736m));
        } else {
            this.f89736m = this.f89735i;
            this.f89731d.a("page_appear_cost", 0);
        }
        if (this.f89731d.d() > 0 && list != null && list.size() > 0) {
            z(RFWLog.USR, "collectPageInitTime currentFeedList is not empty");
            this.f89731d.a("load_type", "6");
            i8("have_feed_time");
        }
    }

    private void k(long j3) {
        if (j3 != 0) {
            this.f89731d.a("ext2", "0");
        } else if (this.E) {
            this.f89731d.a("ext2", "2");
        } else {
            this.f89731d.a("ext2", "1");
        }
    }

    private void l() {
        B("qq_start_time", String.valueOf(System.currentTimeMillis() - com.tencent.mobileqq.qcircle.api.global.a.f261662c));
        B("qq_foreground_time", String.valueOf(System.currentTimeMillis() - com.tencent.mobileqq.qcircle.api.global.a.f261663d));
    }

    private void m() {
        int i3 = this.I;
        int i16 = this.H;
        z(RFWLog.USR, "collectVidePlayInterceptInfo videoPlayInterceptCount:" + i3 + ",videoPlayNotInterceptCount:" + i16);
        if (i3 > 0 && i16 <= 0) {
            this.f89731d.a("video_play_all_intercept", "1");
        } else {
            this.f89731d.a("video_play_all_intercept", "0");
        }
        B("auto_play_count", String.valueOf(this.K));
    }

    private View o() {
        WeakReference<View> weakReference = this.f89734h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(float f16) {
        B("first_video_cache_time", String.valueOf(f16));
        QLog.d("QFSPlayPageReporter", 1, "[collectFirstVideoCacheStatus] time:" + f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        M();
        D(i3, feedCloudMeta$StFeed);
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        M();
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.XSJ_LAYER_PGIN, o(), this.f89731d.b());
    }

    private void z(int i3, String str) {
        if (f()) {
            RFWLog.d("QFSPlayPageReporter" + hashCode(), i3, str);
        }
    }

    public void B(String str, String str2) {
        if (f()) {
            z(RFWLog.USR, "putToExtExpMap key:" + str + ",val:" + str2);
        }
        this.G.put(str, str2);
    }

    public void C() {
        if (N) {
            z(RFWLog.USR, "recordAllPushVisitorHistory");
            k.a().j("sp_key_have_visitor_all_push_page", true);
            N = false;
        }
    }

    public void G(String str) {
        if (!TextUtils.isEmpty(str)) {
            B("hit_fast_play", "1");
        } else {
            B("hit_fast_play", "0");
        }
    }

    @Override // t40.f
    public void Gd() {
        this.C = System.currentTimeMillis();
        this.K++;
    }

    public void H(a.C0885a c0885a) {
        if (c0885a == null) {
            return;
        }
        B("total_feeds", String.valueOf(c0885a.f86654a));
        B("exposed_feeds", String.valueOf(c0885a.f86656c));
        B("total_req", String.valueOf(c0885a.f86655b));
        if (f()) {
            z(RFWLog.USR, "setFeedWasteInfo :" + c0885a);
        }
    }

    @Override // t40.f
    public void H6() {
        this.f89731d.a("page_content_expose_cost", Long.valueOf(System.currentTimeMillis() - this.f89735i));
    }

    public void I(int i3, int i16, int i17, boolean z16, String str) {
        String str2;
        if (i3 == 6 && i16 == 6) {
            z(RFWLog.USR, "setFolderRedPointInfo redPointType:" + i17 + ",needRefresh:" + z16 + ",eeveeTraceId:" + str);
            this.f89731d.a("red_point_trace_id", str);
            this.f89731d.a("red_point_type", Integer.valueOf(i17));
            g gVar = this.f89731d;
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            gVar.a("red_point_need_refresh", str2);
        }
    }

    public void J(boolean z16) {
        this.D = z16;
        z(RFWLog.USR, "setFolderTabInfo isTabMode:" + z16);
    }

    public void K(String str) {
        z(RFWLog.USR, "setLoadFeedType " + str);
        if (!TextUtils.isEmpty(str)) {
            this.f89731d.a("load_type", str);
        }
    }

    public void L(Long l3) {
        if (l3 == null) {
            return;
        }
        B("preload_feed_receive_time", String.valueOf(System.currentTimeMillis() - l3.longValue()));
    }

    @Override // t40.f
    public void P7(boolean z16) {
        if (z16) {
            this.I++;
        } else {
            this.H++;
        }
    }

    @Override // t40.f
    public void Y7(RFWPlayer rFWPlayer) {
        this.f89731d.a("start_play", "1");
        this.f89731d.a("play_error", "0");
        QCircleColdBootPreloadFeedManagerV2.getInstance().onVideoPlaySucceed();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.f89736m;
        if (this.f89731d.a("ext", j3 + "")) {
            z(RFWLog.USR, "onVideoPlayFirstRendered allStepCost:" + j3);
        }
        long j16 = currentTimeMillis - this.C;
        if (this.f89731d.a("video_first_render_cost", j16 + "")) {
            z(RFWLog.USR, "onVideoPlayFirstRendered playStepCost:" + j16);
        }
    }

    @Override // t40.f
    public void i8(String str) {
        synchronized (this) {
            if (this.F.containsKey(str)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f89736m;
            z(RFWLog.USR, "recordStep key:" + str + ",val:" + currentTimeMillis);
            this.F.put(str, String.valueOf(currentTimeMillis));
        }
    }

    public String n(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            synchronized (this) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (Exception e16) {
                        z(RFWLog.USR, "getExtraStr error:" + e16);
                    }
                }
            }
            return jSONObject.toString();
        }
        return "";
    }

    @Override // t40.f
    public void onVideoPlayError(int i3) {
        this.f89731d.a("play_error", Integer.valueOf(i3));
        RFWLog.e("QFSPlayPageReporter", RFWLog.USR, "onVideoPlayError " + i3);
    }

    @Override // t40.f
    public void onVideoPrepared(RFWPlayer rFWPlayer) {
        Object obj;
        Object obj2;
        if (rFWPlayer == null) {
            return;
        }
        RFWPlayerOptions rFWPlayerOptions = rFWPlayer.getRFWPlayerOptions();
        boolean hitPreloadCache = rFWPlayerOptions.hitPreloadCache();
        boolean isPreloadPlayer = rFWPlayerOptions.isPreloadPlayer();
        boolean firstFramePreRenderSucceed = rFWPlayerOptions.getFirstFramePreRenderSucceed();
        if (isPreloadPlayer) {
            hitPreloadCache = true;
        }
        g gVar = this.f89731d;
        String str = "1";
        if (isPreloadPlayer) {
            obj = "1";
        } else {
            obj = "0";
        }
        gVar.a("player_hit_pre_render", obj);
        g gVar2 = this.f89731d;
        if (firstFramePreRenderSucceed) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        gVar2.a("player_hit_pre_render_and_succeed", obj2);
        g gVar3 = this.f89731d;
        if (!hitPreloadCache) {
            str = "0";
        }
        gVar3.a("player_hit_cache", str);
    }

    public void p(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        List<e30.b> data = uIStateData.getData();
        if (data != null && !data.isEmpty()) {
            z(RFWLog.USR, "handleFeedRsp");
            i8("have_feed_time");
            this.f89731d.a("fetch_error", 0);
            this.f89731d.a("fetch_error_msg", "");
            if (this.J) {
                this.J = false;
                g(data);
                return;
            }
            return;
        }
        if (uIStateData.getState() == 4) {
            long retCode = uIStateData.getRetCode();
            String msg2 = uIStateData.getMsg();
            this.f89731d.a("fetch_error", Long.valueOf(retCode));
            this.f89731d.a("fetch_error_msg", msg2);
            RFWLog.e("QFSPlayPageReporter", RFWLog.USR, "handleFeedRsp code:" + retCode + ",msg:" + msg2);
        }
    }

    @Override // t40.f
    public void p8(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        B("fast_play_start_play", str);
    }

    public void q(View view, QCircleReportBean qCircleReportBean, QCircleInitBean qCircleInitBean) {
        r(view, null, qCircleReportBean, qCircleInitBean);
    }

    public void r(View view, String str, QCircleReportBean qCircleReportBean, QCircleInitBean qCircleInitBean) {
        String str2;
        String str3;
        this.f89734h = new WeakReference<>(view);
        if (qCircleReportBean == null) {
            str2 = "";
        } else {
            str2 = qCircleReportBean.getDtPageId();
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null) {
            str3 = "";
        } else {
            HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
            String str4 = schemeAttrs.get("xsj_main_entrance");
            String str5 = schemeAttrs.get("xsj_sub_entrance");
            String str6 = schemeAttrs.get("xsj_custom_pgid");
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, str2);
            buildElementParams.put("ext3", str6);
            buildElementParams.put("from_main_entrance", str4);
            buildElementParams.put("from_sub_entrance", str5);
            buildElementParams.put("ext4", 6);
            buildElementParams.put("device_level", Integer.valueOf(QCircleVideoDeviceInfoUtils.getVideoDeviceLevel()));
            str3 = str6;
        }
        e(view, buildElementParams, str, str2, str3);
        this.f89731d.g(buildElementParams);
    }

    public void v(@Nullable Activity activity) {
        if (this.D) {
            this.f89736m = com.tencent.mobileqq.qcircle.api.global.a.f261664e;
        } else if (activity != null && activity.getIntent() != null) {
            this.f89736m = activity.getIntent().getLongExtra("key_bundle_open_page_time", -1L);
        }
        i8("page_on_create");
        z(RFWLog.USR, "onCreate");
    }

    public void w() {
        z(RFWLog.USR, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public void x(final int i3, final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        z(RFWLog.USR, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        RFWThreadManager.getInstance();
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.report.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.t(i3, feedCloudMeta$StFeed);
            }
        });
    }

    public void y(List<e30.b> list) {
        String str;
        z(RFWLog.USR, "onResume");
        if (L.compareAndSet(true, false)) {
            this.E = true;
        }
        g gVar = this.f89731d;
        if (QQVideoPlaySDKManager.isSDKReady()) {
            str = "1";
        } else {
            str = "0";
        }
        gVar.a("enter_sdk_init_succeed", str);
        if (this.D) {
            h();
        }
        j(list);
        l();
        RFWThreadManager.getInstance();
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.report.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.u();
            }
        });
    }

    private void E() {
    }
}
