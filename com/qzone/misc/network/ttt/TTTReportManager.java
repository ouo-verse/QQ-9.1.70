package com.qzone.misc.network.ttt;

import ELABORATE_FEED_REPORT.SingleExposeInfo;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TTTReportManager {

    /* renamed from: a, reason: collision with root package name */
    private static TTTReportManager f48517a;

    public static TTTReportManager s() {
        if (f48517a == null) {
            synchronized (TTTReportManager.class) {
                if (f48517a == null) {
                    f48517a = new TTTReportManager();
                }
            }
        }
        return f48517a;
    }

    public void i(int i3, int i16, int i17, long j3, Map<Integer, String> map, int i18, int i19, Map<Integer, String> map2, int i26, int i27, Map<Integer, String> map3, long j16, String str, e eVar, ArrayList<SingleExposeInfo> arrayList) {
        d(i3, i16, i17, j3, map, i18, i19, map2, i26, i27, map3, j16, str, eVar, arrayList);
    }

    public void q(int i3, int i16, int i17, long j3, Map<Integer, String> map, Map<Integer, String> map2, int i18, int i19, boolean z16) {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        CellOperationInfo cellOperationInfo = new CellOperationInfo();
        businessFeedData.cellOperationInfo = cellOperationInfo;
        cellOperationInfo.feedReportCookie = map2;
        m(i3, i16, i17, j3, map, businessFeedData, i18, i19, null, z16);
    }

    public void f(int i3, int i16, int i17, long j3) {
        m(i3, i16, i17, j3, null, null, -1000, 0, null, false);
    }

    public void r(int i3, int i16, int i17, long j3, boolean z16) {
        m(i3, i16, i17, j3, null, null, -1000, 0, null, z16);
    }

    public void h(int i3, int i16, int i17, long j3, BusinessFeedData businessFeedData, int i18, boolean z16) {
        m(i3, i16, i17, j3, null, businessFeedData, i18, 0, null, z16);
    }

    public void k(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19) {
        m(i3, i16, i17, j3, map, businessFeedData, i18, i19, null, false);
    }

    public void p(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, boolean z16) {
        m(i3, i16, i17, j3, map, businessFeedData, i18, i19, null, z16);
    }

    public void g(int i3, int i16, int i17, long j3, BusinessFeedData businessFeedData, int i18, int i19, Map<Integer, String> map) {
        o(i3, i16, i17, j3, null, businessFeedData, i18, i19, map, null, false);
    }

    public void m(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, e eVar, boolean z16) {
        o(i3, i16, i17, j3, map, businessFeedData, i18, i19, null, eVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, Map<Integer, String> map2, int i26, int i27, Map<Integer, String> map3, long j16, String str) {
        TTTBigDataReport.t().p(i3, i16, i17, j3, map, businessFeedData, i18, i19, map2, j16, map3, i27, i26, str);
    }

    public void j(int i3, int i16, int i17, long j3, Map<Integer, String> map, int i18, int i19, Map<Integer, String> map2, e eVar, ArrayList<SingleExposeInfo> arrayList) {
        i(i3, i16, i17, j3, map, i18, i19, map2, -1, 0, null, 0L, "", eVar, arrayList);
    }

    private void d(int i3, int i16, int i17, long j3, Map<Integer, String> map, int i18, int i19, Map<Integer, String> map2, int i26, int i27, Map<Integer, String> map3, long j16, String str, e eVar, ArrayList<SingleExposeInfo> arrayList) {
        h.g().c(i3, i16, i17, j3, map, i18, i19, map2, j16, map3, i27, i26, str, eVar, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, Map<Integer, String> map2, int i26, int i27, Map<Integer, String> map3, long j16, String str, e eVar) {
        h.g().d(i3, i16, i17, j3, map, businessFeedData, i18, i19, map2, j16, map3, i27, i26, str, eVar);
    }

    public void o(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, Map<Integer, String> map2, e eVar, boolean z16) {
        n(i3, i16, i17, j3, map, businessFeedData, i18, i19, map2, -1, 0, null, 0L, "", eVar, z16);
    }

    public void l(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, int i26, int i27, Map<Integer, String> map2, long j16, String str, e eVar, boolean z16) {
        n(i3, i16, i17, j3, map, businessFeedData, i18, i19, null, i26, i27, map2, j16, str, eVar, z16);
    }

    public void n(final int i3, final int i16, final int i17, final long j3, final Map<Integer, String> map, final BusinessFeedData businessFeedData, final int i18, final int i19, final Map<Integer, String> map2, final int i26, final int i27, final Map<Integer, String> map3, final long j16, final String str, final e eVar, final boolean z16) {
        FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.misc.network.ttt.TTTReportManager.1
            @Override // java.lang.Runnable
            public void run() {
                BusinessFeedData businessFeedData2;
                if (!z16 && !f.b(i16, i17, i3) && ((businessFeedData2 = businessFeedData) == null || businessFeedData2.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isRealTimeTTTReport())) {
                    TTTReportManager.this.c(i3, i16, i17, j3, map, businessFeedData, i18, i19, map2, i26, i27, map3, j16, str);
                    return;
                }
                if (j.g()) {
                    QLog.w("TTTReport", 2, String.format("(recommend_report) realtime report: action(%d,%d,%d), duration:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16)));
                }
                TTTReportManager.this.e(i3, i16, i17, j3, map, businessFeedData, i18, i19, map2, i26, i27, map3, j16, str, eVar);
            }
        });
    }
}
