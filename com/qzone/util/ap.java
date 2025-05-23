package com.qzone.util;

import ELABORATE_FEED_REPORT.SingleExposeInfo;
import com.qzone.misc.network.ttt.TTTReportManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ap {

    /* renamed from: b, reason: collision with root package name */
    public static final ap f59791b = new ap();

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f59792c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f59793d = -1;

    /* renamed from: a, reason: collision with root package name */
    private final TTTReportManager f59794a = TTTReportManager.s();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        int getReportPageId();
    }

    ap() {
    }

    public static int a() {
        return f59792c;
    }

    public static boolean b() {
        return f59792c != -1;
    }

    public static boolean c() {
        return f59792c == 1;
    }

    public static boolean d() {
        return (f59792c == -1 || f59792c == 11 || f59792c == 13 || f59792c == 14) ? false : true;
    }

    public static void g() {
        f59792c = f59793d;
    }

    public static void h(a aVar) {
        f59793d = f59792c;
        if (aVar == null) {
            f59792c = -1;
        } else {
            f59792c = aVar.getReportPageId();
        }
    }

    public void f(int i3, int i16, int i17, BusinessFeedData businessFeedData, Map<Integer, String> map, ArrayList<SingleExposeInfo> arrayList) {
        int i18;
        HashMap hashMap;
        if (!b()) {
            QZLog.d("TttReporter", 2, "report: is not report page now", new Throwable());
            return;
        }
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            i18 = businessFeedData.getFeedCommInfo().feedsType;
        } else {
            QZLog.d("TttReporter", 2, "report: null feed type");
            i18 = 0;
        }
        int i19 = f59792c;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("report: ");
        sb5.append(i19);
        sb5.append(" - ");
        sb5.append(i3);
        sb5.append(" - ");
        sb5.append(i16);
        sb5.append(" - ");
        sb5.append(i17);
        sb5.append(APLogFileUtil.SEPARATOR_LOG);
        sb5.append(i18);
        sb5.append(" ");
        sb5.append(businessFeedData != null);
        sb5.append(" | feedXEnable = ");
        sb5.append(true);
        QZLog.i("TttReporter", 1, sb5.toString());
        if ((i19 != 12 && i19 != 11) || businessFeedData == null || QZoneApiProxy.isInQZoneEnvironment()) {
            hashMap = null;
        } else {
            if (businessFeedData.getOperationInfo().feedReportCookie == null) {
                businessFeedData.getOperationInfo().feedReportCookie = new HashMap();
            }
            QZLog.d("TttReporter", 2, "report: simple mode");
            businessFeedData.getOperationInfo().feedReportCookie.put(40, "1");
            hashMap = new HashMap(businessFeedData.getOperationInfo().feedReportCookie);
        }
        if (arrayList != null) {
            this.f59794a.j(i19, i3, i16, System.currentTimeMillis(), map, i17, 0, hashMap, null, arrayList);
        } else {
            this.f59794a.o(i19, i3, i16, System.currentTimeMillis(), map, businessFeedData, i17, 0, hashMap, null, businessFeedData == null || businessFeedData.getFeedCommInfo().isRealTimeTTTReport());
        }
    }

    public void e(int i3, int i16, int i17, BusinessFeedData businessFeedData) {
        f(i3, i16, i17, businessFeedData, null, null);
    }
}
