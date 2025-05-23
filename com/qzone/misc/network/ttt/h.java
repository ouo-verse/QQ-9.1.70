package com.qzone.misc.network.ttt;

import ELABORATE_FEED_REPORT.SingleExposeInfo;
import ELABORATE_FEED_REPORT.StFeedsReportQuicklyReq;
import ELABORATE_FEED_REPORT.comm_qzone_report_req;
import ELABORATE_FEED_REPORT.elaborate_feed_report_req;
import ELABORATE_FEED_REPORT.feed_report_info;
import ELABORATE_FEED_REPORT.session_report;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h {

    /* renamed from: g, reason: collision with root package name */
    private static h f48559g;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, SingleExposeInfo> f48560a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final int f48561b;

    /* renamed from: c, reason: collision with root package name */
    private final int f48562c;

    /* renamed from: d, reason: collision with root package name */
    private final int f48563d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f48564e;

    /* renamed from: f, reason: collision with root package name */
    private long f48565f;

    public h() {
        com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
        this.f48561b = gVar.b().u1();
        this.f48562c = gVar.b().t1();
        this.f48563d = gVar.b().s1() * 1000;
        this.f48564e = gVar.b().s0();
        this.f48565f = 0L;
    }

    private comm_qzone_report_req f(ArrayList<SingleExposeInfo> arrayList) {
        byte[] encodeJceStrcut = FeedGlobalEnv.g().encodeJceStrcut(new StFeedsReportQuicklyReq(arrayList));
        HashMap hashMap = new HashMap();
        hashMap.put(9, encodeJceStrcut);
        return new comm_qzone_report_req(hashMap);
    }

    public static h g() {
        if (f48559g == null) {
            synchronized (h.class) {
                f48559g = new h();
            }
        }
        return f48559g;
    }

    private d h(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, long j16, Map<Integer, String> map2, long j17, int i26, String str) {
        long s16 = TTTBigDataReport.t().s();
        int u16 = TTTBigDataReport.t().u();
        Map<Integer, String> map3 = (businessFeedData == null || businessFeedData.getOperationInfoV2() == null) ? null : businessFeedData.getOperationInfoV2().feedReportCookie;
        d dVar = new d();
        dVar.a(i3, i16, i17, j3, map, s16, i19, i18, businessFeedData != null ? businessFeedData.getFeedCommInfo().feedskey : null, u16, map3, j16, map2, j17, i26, str);
        return dVar;
    }

    private comm_qzone_report_req i(d dVar) {
        feed_report_info feed_report_infoVar = new feed_report_info(dVar.f48547e, dVar.f48545c, new ArrayList(), dVar.f48549g, dVar.f48550h, dVar.f48551i);
        feed_report_infoVar.vecActionFlow.add(dVar.f48553k);
        session_report session_reportVar = new session_report((int) dVar.f48544b, new ArrayList(), dVar.f48552j);
        session_reportVar.vecFeedReportInfo.add(feed_report_infoVar);
        elaborate_feed_report_req elaborate_feed_report_reqVar = new elaborate_feed_report_req(new ArrayList());
        elaborate_feed_report_reqVar.vecSessionReport.add(session_reportVar);
        byte[] encodeJceStrcut = FeedGlobalEnv.g().encodeJceStrcut(elaborate_feed_report_reqVar);
        HashMap hashMap = new HashMap();
        hashMap.put(1, encodeJceStrcut);
        return new comm_qzone_report_req(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ArrayList arrayList) {
        try {
            TTTWNSRequestHelper.b().a("elaborateFeedReport", f(arrayList), null);
        } catch (Throwable th5) {
            QLog.e("TTTRealtimeReport", 1, "doFeedExposeReport error: ", th5);
        }
    }

    public void e() {
        if (this.f48560a.isEmpty()) {
            return;
        }
        this.f48565f = System.currentTimeMillis();
        b(new ArrayList<>(this.f48560a.values()));
        this.f48560a.clear();
    }

    public void k(BusinessFeedData businessFeedData, int i3, int i16) {
        if (this.f48564e && businessFeedData != null) {
            String str = businessFeedData.getIdInfo().cellId;
            if (TextUtils.isEmpty(str)) {
                QLog.e("TTTRealtimeReport", 1, "recordFeedExpose direct return,cellId is null!");
            } else if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().feedReportCookie != null) {
                l(str, businessFeedData.getOperationInfoV2().feedReportCookie, i3, i16);
            } else {
                QLog.e("TTTRealtimeReport", 1, "recordFeedExpose direct return, feedReportCookie is null");
            }
        }
    }

    public void l(String str, Map<Integer, String> map, int i3, int i16) {
        if (this.f48564e) {
            if (map != null && !map.isEmpty()) {
                if (TextUtils.isEmpty(str)) {
                    QLog.e("TTTRealtimeReport", 1, "recordFeedExpose direct return,unionKey is null!");
                    return;
                }
                QLog.i("TTTRealtimeReport", 4, "recordFeedExpose scrollDirection= " + i3 + " | feedPos=" + i16);
                this.f48560a.put(i3 + "_" + str, new SingleExposeInfo(map, System.currentTimeMillis() / 1000, i16));
                if (this.f48560a.size() >= this.f48561b) {
                    if (System.currentTimeMillis() - this.f48565f < this.f48563d && this.f48560a.size() < this.f48562c) {
                        QLog.e("TTTRealtimeReport", 4, "the time interval is less than " + this.f48563d + " ms\uff0cwait next time");
                        return;
                    }
                    e();
                    return;
                }
                return;
            }
            QLog.e("TTTRealtimeReport", 1, "recordFeedExpose direct return,reportMap is null!");
        }
    }

    public void b(final ArrayList<SingleExposeInfo> arrayList) {
        QLog.d("TTTRealtimeReport", 4, "doFeedExposeReport list: ", Integer.valueOf(arrayList.size()));
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.misc.network.ttt.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.j(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i3, int i16, int i17, long j3, Map<Integer, String> map, int i18, int i19, Map<Integer, String> map2, long j16, Map<Integer, String> map3, long j17, int i26, String str, e eVar, ArrayList<SingleExposeInfo> arrayList) {
        try {
            comm_qzone_report_req f16 = f(arrayList);
            QLog.isColorLevel();
            TTTWNSRequestHelper.b().a("elaborateFeedReport", f16, eVar);
        } catch (Throwable th5) {
            QLog.e("TTTBigDataReport", 1, "error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, Map<Integer, String> map2, long j16, Map<Integer, String> map3, long j17, int i26, String str, e eVar) {
        d h16;
        try {
            h16 = h(i3, i16, i17, j3, map, businessFeedData, i18, i19, j16, map3, j17, i26, str);
            if (map2 != null) {
                h16.f48547e = map2;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            comm_qzone_report_req i27 = i(h16);
            QLog.isColorLevel();
            TTTWNSRequestHelper.b().a("elaborateFeedReport", i27, eVar);
        } catch (Throwable th6) {
            th = th6;
            QLog.e("TTTBigDataReport", 1, "error: ", th);
        }
    }
}
