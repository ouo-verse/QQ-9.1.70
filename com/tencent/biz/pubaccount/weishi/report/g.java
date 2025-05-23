package com.tencent.biz.pubaccount.weishi.report;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.net.common.k;
import com.tencent.biz.pubaccount.weishi.net.j;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static volatile g f81536b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Long> f81537a = new HashMap<>();

    g() {
    }

    private WSStatisticsReporter.Builder b() {
        return new WSStatisticsReporter.Builder().setSendWeSeeServer(false).setFlush(true);
    }

    private void c(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    public static synchronized g d() {
        g gVar;
        synchronized (g.class) {
            if (f81536b == null) {
                synchronized (g.class) {
                    if (f81536b == null) {
                        f81536b = new g();
                    }
                }
            }
            gVar = f81536b;
        }
        return gVar;
    }

    private void k(boolean z16, long j3, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("actWsAllDuration", String.valueOf(j3));
        hashMap.put("sopName", String.valueOf(str));
        if (WSPublicAccReport.SOP_NAME_VIDEO_PLAY.equals(str)) {
            hashMap.put("actWsPageFrom", "" + str2);
            x.l("WsBeaconReportPresenter", "\u53ea\u5728\u64ad\u653e\u9875\u4e0a\u62a5actWsPageFrom");
        }
        hashMap.put("type", "4");
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.f("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    public void e(long j3, long j16, int i3, boolean z16, boolean z17, int i16) {
        HashMap hashMap = new HashMap();
        hashMap.put("actWsFeedUserUsageDuration", String.valueOf(j3));
        hashMap.put("actWsFeedListFirstReqDuration", String.valueOf(j16));
        hashMap.put("actWsFeedCoverExposureNum", String.valueOf(i3));
        if (z16) {
            hashMap.put("actWsFeedIsJumpToPlayPage", "true");
        } else {
            hashMap.put("actWsFeedIsJumpToPlayPage", "false");
        }
        if (z17) {
            hashMap.put("actWsFeedIsJumpToWeiShi", "true");
        } else {
            hashMap.put("actWsFeedIsJumpToWeiShi", "false");
        }
        if (i16 == 2) {
            hashMap.put("actWsRecommendPageType", "1");
        }
        c(b().addParams(hashMap), "actWsGzhFeedUserConsumption");
        x.l("WsBeaconReportPresenter", "reportFallListExit{ stayTime:" + j3 + ",loadTime:" + j16 + ",exposeCount:" + i3 + ",hasClickFuceng:" + z16 + ",hasClickWeishi:" + z17);
        ao.f81709b = false;
    }

    public void g(f10.a aVar, int i3, String str, boolean z16) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("type", "10");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(MiniChatConstants.MINI_APP_SCREEN_RECORD_LAUNCH_FROM, aVar.g());
        hashMap2.put("click2ReqSendTime", String.valueOf(aVar.a()));
        hashMap2.put("reqSend2RspReceiveTime", String.valueOf(aVar.h()));
        hashMap2.put("handleRspDataTime", String.valueOf(aVar.f()));
        hashMap2.put("handleFinish2CoverLoadStartTime", String.valueOf(aVar.e()));
        hashMap2.put("firstPageCoverLoadTime", String.valueOf(aVar.b()));
        hashMap2.put("fragmentCreateViewDuration", String.valueOf(aVar.c()));
        hashMap2.put("fragmentViewCreatedDuration", String.valueOf(aVar.d()));
        hashMap2.put("launchTotalTime", String.valueOf(aVar.i()));
        hashMap2.put("userAction", String.valueOf(i3));
        hashMap2.put("switchReason", str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap2.put("pauseWhenFetching", str2);
        c(b().addParams(hashMap).addExtParams(hashMap2), "actWsGzhPerformance");
        x.l("WsBeaconReportPresenter", "reportLaunchTime event report: actWsGzhPerformance,params:" + hashMap2.toString());
    }

    public void h(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            x.f("WsBeaconReportPresenter", "reportLoadMore() failed. sopName is empty.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "6");
        hashMap.put("sopName", str);
        hashMap.put("actWsPageFrom", str2 == null ? "" : str2);
        hashMap.put("loadMoreTriggerCnt", Integer.toString(i3));
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.b("WsBeaconReportPresenter", "reportLoadMore() sopName = " + str + ", playScene = " + str2 + ", loadMoreTriggerCnt = " + i3);
    }

    public void i(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            x.f("WsBeaconReportPresenter", "reportLoadMoreViewExposed() failed. sopName is empty.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "7");
        hashMap.put("sopName", str);
        hashMap.put("actWsPageFrom", str2 == null ? "" : str2);
        hashMap.put("actWsLoadMoreIndex", Integer.toString(i3));
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.b("WsBeaconReportPresenter", "reportLoadMoreViewExposed() sopName = " + str + ", playScene = " + str2 + ", lastFeedIndex = " + i3);
    }

    public void m(int i3, int i16, int i17) {
        HashMap hashMap = new HashMap();
        hashMap.put("actWSReqDuration", String.valueOf(i3));
        hashMap.put("actWsReqName", "loginSilent");
        hashMap.put("actWsReqScene", String.valueOf(i16));
        hashMap.put("actWsRetryCount", String.valueOf(i17));
        hashMap.put("type", "2");
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.l("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    public void n(int i3, int i16, int i17, int i18, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("actWSReqDuration", String.valueOf(i3));
        hashMap.put("actWsReqName", "loginSilent");
        hashMap.put("actWsReqScene", String.valueOf(i16));
        hashMap.put("actWsReqErrorCode", String.valueOf(i18));
        hashMap.put("actWsReqErrorMsg", str);
        hashMap.put("actWsRetryCount", String.valueOf(i17));
        hashMap.put("type", "5");
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.l("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    public void o(HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("recommend_report_fail", new JSONObject(hashMap).toString());
        c(b().addParams(hashMap2), "actWsGzhFeedPerformance");
        x.i("WsBeaconReportPresenter", "reportRecommendReportFail\uff1a" + hashMap.toString());
    }

    public void r(long j3, j jVar, int i3, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put("actWSReqDuration", String.valueOf(j3));
        String str6 = "";
        if (jVar == null) {
            str2 = "";
        } else {
            str2 = jVar.m();
        }
        hashMap.put("actWsReqName", str2);
        if (jVar == null) {
            str3 = "";
        } else {
            str3 = String.valueOf(jVar.n());
        }
        hashMap.put("actWsReqScene", str3);
        if (jVar == null) {
            str4 = "";
        } else {
            str4 = String.valueOf(jVar.I);
        }
        hashMap.put("actWsReqRspSize", str4);
        if (jVar == null) {
            str5 = "";
        } else {
            str5 = String.valueOf(jVar.J);
        }
        hashMap.put("actWsReqSize", str5);
        if (jVar != null) {
            str6 = String.valueOf(jVar.H);
        }
        hashMap.put("actWsReqNetDuration", str6);
        hashMap.put("actWsReqErrorCode", String.valueOf(i3));
        hashMap.put("actWsReqErrorMsg", str);
        String str7 = "0";
        hashMap.put("actWSAndNetFrameWorkType", "0");
        hashMap.put("type", "5");
        if (jVar.r()) {
            str7 = "1";
        }
        hashMap.put("actWSReqRemoveWns", str7);
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.l("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    public void f(boolean z16, long j3) {
        long a16 = a(j3, 5000L);
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("actWsFeedPageLoadDuration", "" + a16);
        c(b().addParams(hashMap), "actWsGzhFeedPerformance");
        Log.w("WsBeaconReportPresenter", " actWsFeedPageLoadDuration=" + a16);
    }

    public void l(boolean z16, long j3, String str, String str2) {
        long a16 = a(j3, 5000L);
        this.f81537a.put(str, Long.valueOf(a16));
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("actWsPageLoadDuration", String.valueOf(a16));
        hashMap.put("sopName", String.valueOf(str));
        hashMap.put("actWsPageFrom", String.valueOf(str2));
        hashMap.put("type", "1");
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.f("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    public void q(com.tencent.biz.pubaccount.weishi.net.common.g gVar) {
        Object obj;
        Object obj2;
        Object obj3;
        if (gVar == null) {
            return;
        }
        k timeRecord = gVar.getTimeRecord();
        long a16 = a(timeRecord.b(), 20000L);
        HashMap hashMap = new HashMap();
        hashMap.put("actWSReqDuration", String.valueOf(a16));
        hashMap.put("actWSReqDurationIncludeCodec", String.valueOf(timeRecord.i()));
        hashMap.put("actReqEncodeDuration", String.valueOf(timeRecord.j()));
        hashMap.put("actDecodeWupDuration", String.valueOf(timeRecord.f()));
        hashMap.put("actDecodeExpDuration", String.valueOf(timeRecord.c()));
        hashMap.put("actDecodeHeaderDuration", String.valueOf(timeRecord.d()));
        hashMap.put("actDecodeRspDuration", String.valueOf(timeRecord.e()));
        hashMap.put("actDecompressDataDuration", String.valueOf(timeRecord.g()));
        hashMap.put("actDecompressRspDuration", String.valueOf(timeRecord.h()));
        hashMap.put("actWorkThreadDuration", String.valueOf(timeRecord.l()));
        hashMap.put("actSwitchUIThreadDuration", String.valueOf(timeRecord.k()));
        hashMap.put("actWsReqNetDuration", String.valueOf(timeRecord.a()));
        String str = "1";
        hashMap.put("actWSAndNetFrameWorkType", "1");
        if (gVar.isGzipCompress()) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("actWSRspIsCompress", obj);
        if (gVar.isRemoveWns()) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("actWSReqRemoveWns", obj2);
        if (gVar.isFirst()) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        hashMap.put("actWSIsFirstRequest", obj3);
        if (!gVar.isRefresh()) {
            str = "0";
        }
        hashMap.put("actWSIsRefreshRequest", str);
        com.tencent.biz.pubaccount.weishi.net.common.c compressInfo = gVar.getCompressInfo();
        hashMap.put("actWSCompressSize", String.valueOf(compressInfo.a()));
        hashMap.put("actWSDecompressSize", String.valueOf(compressInfo.b()));
        hashMap.put("actWSDecompressRadio", String.valueOf(compressInfo.c()));
        hashMap.put("actWsReqSubId", gVar.getRequestSubId());
        hashMap.put("actWsReqName", gVar.getOnlyCmd());
        hashMap.put("actWsReqScene", String.valueOf(gVar.getRequestScene()));
        hashMap.put("actWsReqRspSize", String.valueOf(gVar.respSize));
        hashMap.put("actWsReqSize", String.valueOf(gVar.reqSize));
        hashMap.put("actWsRetryCount", String.valueOf(gVar.getRequestRetryCount()));
        hashMap.put("actWsRetryCode", String.valueOf(gVar.getRetryCode()));
        hashMap.put("type", "2");
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.l("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    public void s(com.tencent.biz.pubaccount.weishi.net.common.g gVar, int i3, String str) {
        if (gVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("actWSReqDuration", String.valueOf(gVar.getTimeRecord().b()));
        hashMap.put("actWsReqName", gVar.getOnlyCmd());
        hashMap.put("actWsReqScene", String.valueOf(gVar.getRequestScene()));
        hashMap.put("actWsReqRspSize", String.valueOf(gVar.respSize));
        hashMap.put("actWsReqSize", String.valueOf(gVar.reqSize));
        hashMap.put("actWsReqNetDuration", String.valueOf(gVar.getTimeRecord().a()));
        hashMap.put("actWsReqErrorCode", String.valueOf(i3));
        hashMap.put("actWsReqErrorMsg", str);
        String str2 = "1";
        hashMap.put("actWSAndNetFrameWorkType", "1");
        if (!gVar.isRemoveWns()) {
            str2 = "0";
        }
        hashMap.put("actWSReqRemoveWns", str2);
        hashMap.put("actWsReqSubId", gVar.getRequestSubId());
        hashMap.put("actWsRetryCount", String.valueOf(gVar.getRequestRetryCount()));
        hashMap.put("type", "5");
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.l("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    private long a(long j3, long j16) {
        if (j3 <= j16) {
            return j3;
        }
        Log.w("weishi-beacon", "request is more than " + j16);
        return j16;
    }

    public void p(long j3, j jVar, String str, boolean z16) {
        Object obj;
        Object obj2;
        if (jVar == null) {
            return;
        }
        long a16 = a(j3, 20000L);
        HashMap hashMap = new HashMap();
        hashMap.put("actWSReqDuration", String.valueOf(a16));
        String str2 = "1";
        if (jVar.p()) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("actWSRspIsCompress", obj);
        if (jVar.r()) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("actWSReqRemoveWns", obj2);
        hashMap.put("actWsReqName", jVar.m());
        hashMap.put("actWsReqScene", String.valueOf(jVar.n()));
        hashMap.put("actWsReqRspSize", String.valueOf(jVar.I));
        hashMap.put("actWsReqSize", String.valueOf(jVar.J));
        hashMap.put("actWsReqNetDuration", String.valueOf(jVar.H));
        if (!z16) {
            str2 = "0";
        }
        hashMap.put("actWSIsFirstRequest", str2);
        hashMap.put("actWSAndNetFrameWorkType", "0");
        com.tencent.biz.pubaccount.weishi.net.common.c i3 = jVar.i();
        hashMap.put("actWSCompressSize", String.valueOf(i3.a()));
        hashMap.put("actWSDecompressSize", String.valueOf(i3.b()));
        hashMap.put("actWSDecompressRadio", String.valueOf(i3.c()));
        hashMap.put("type", "2");
        if (z16) {
            Long l3 = this.f81537a.get(str);
            if (l3 != null) {
                a16 += l3.longValue();
            }
            long j16 = a16;
            hashMap.put("actWsAllDuration", String.valueOf(j16));
            k(true, j16, str, jVar.m());
        }
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.l("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }

    public void j(com.tencent.mobileqq.kandian.base.image.b bVar, boolean z16, boolean z17, long j3, String str, String str2, int i3) {
        boolean z18;
        String str3;
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        String str4;
        Object obj;
        if (bVar != null) {
            long j27 = bVar.f239013j;
            j17 = j27 - bVar.f239012i;
            j18 = bVar.f239014k - j27;
            j16 = bVar.f239015l;
            j19 = bVar.f239016m;
            long j28 = bVar.f239017n;
            r2 = j28 > 0 ? bVar.f239018o - j28 : 0L;
            long j29 = bVar.f239018o - bVar.f239011h;
            str3 = bVar.f239022s;
            z18 = WSPicLoader.g().i(bVar.f239019p);
            long j36 = r2;
            r2 = j29;
            j26 = j36;
        } else {
            z18 = false;
            str3 = "";
            j16 = 0;
            j17 = 0;
            j18 = 0;
            j19 = 0;
            j26 = 0;
        }
        HashMap hashMap = new HashMap();
        long j37 = j26;
        hashMap.put("actWsPicReqDuration", String.valueOf(a(r2, 20000L)));
        hashMap.put("actWsPicBytes", String.valueOf(j3));
        hashMap.put("actWsPicDecodeDuration", String.valueOf(j19));
        hashMap.put("sopName", str2);
        hashMap.put("actWsPicUrl", str);
        hashMap.put("feeds_index", String.valueOf(i3 + 1));
        String str5 = "0";
        if (z16) {
            str4 = "0";
        } else {
            str4 = "-1";
        }
        hashMap.put("isPicLoadSuccess", str4);
        if (!z17) {
            obj = "0";
        } else {
            obj = "1";
        }
        hashMap.put("isPreload", obj);
        if (z18) {
            str5 = "1";
        }
        hashMap.put("isHitPicCache", str5);
        hashMap.put("type", "3");
        hashMap.put("subThreadWaitTime", String.valueOf(j17));
        hashMap.put("threadPoolWaitTime", String.valueOf(j18));
        hashMap.put("threadWaitTime", String.valueOf(j18 + j17));
        hashMap.put("downloadAndWriteFileTime", String.valueOf(j16));
        hashMap.put("mainThreadWaitTime", String.valueOf(j37));
        hashMap.put("contentType", str3);
        c(b().addParams(hashMap), "actWsGzhPerformance");
        x.j("WsBeaconReportPresenter", "picLoad event report: actWsGzhPerformance, position: " + ((String) hashMap.get("position")) + ",params:" + hashMap.toString());
    }
}
