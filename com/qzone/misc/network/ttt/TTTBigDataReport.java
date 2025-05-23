package com.qzone.misc.network.ttt;

import ELABORATE_FEED_REPORT.comm_qzone_report_req;
import ELABORATE_FEED_REPORT.elaborate_feed_report_req;
import ELABORATE_FEED_REPORT.feed_report_info;
import ELABORATE_FEED_REPORT.session_report;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TTTBigDataReport {

    /* renamed from: h, reason: collision with root package name */
    private static volatile long f48498h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile int f48499i;

    /* renamed from: j, reason: collision with root package name */
    private static String f48500j;

    /* renamed from: b, reason: collision with root package name */
    private int f48502b;

    /* renamed from: c, reason: collision with root package name */
    private c f48503c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<d> f48504d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f48505e;

    /* renamed from: a, reason: collision with root package name */
    private final String f48501a = "TTTBigDataReport";

    /* renamed from: f, reason: collision with root package name */
    private String f48506f = "far";

    /* renamed from: g, reason: collision with root package name */
    private final String f48507g = VFSAssistantUtils.getSDKPrivatePath("far");

    /* compiled from: P */
    /* renamed from: com.qzone.misc.network.ttt.TTTBigDataReport$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ TTTBigDataReport this$0;

        @Override // java.lang.Runnable
        public void run() {
            com.qzone.proxy.feedcomponent.b.i("TTTBigDataReport", "boolean outputReportData post to NormalThread");
            TTTBigDataReport tTTBigDataReport = this.this$0;
            tTTBigDataReport.y(tTTBigDataReport.f48504d, this.this$0.f48505e);
            this.this$0.f48505e = 0;
            TTTBigDataReport tTTBigDataReport2 = this.this$0;
            tTTBigDataReport2.f48504d = tTTBigDataReport2.f48503c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final TTTBigDataReport f48516a = new TTTBigDataReport();
    }

    TTTBigDataReport() {
        this.f48502b = 800;
        int c16 = t8.a.d().c();
        this.f48502b = c16;
        c cVar = new c(c16);
        this.f48503c = cVar;
        this.f48504d = cVar.b();
        this.f48505e = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String q(String str) {
        String str2 = File.separator;
        if (str.endsWith(str2)) {
            return str + this.f48506f + str2;
        }
        return str + str2 + this.f48506f + str2;
    }

    public static final TTTBigDataReport t() {
        return a.f48516a;
    }

    private session_report w(ArrayList<session_report> arrayList, long j3, String str, d dVar) {
        int r16 = r(j3, str);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).uReqId == r16) {
                return arrayList.get(i3);
            }
        }
        session_report session_reportVar = new session_report(r16, new ArrayList(), dVar.f48552j);
        arrayList.add(session_reportVar);
        return session_reportVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final ArrayList<d> arrayList, final int i3) {
        com.qzone.proxy.feedcomponent.b.i("TTTBigDataReport", "outputReportData, size: " + i3);
        if (i3 <= 0) {
            return;
        }
        FeedGlobalEnv.g().postTaskToHeavyThreadPool(new Runnable() { // from class: com.qzone.misc.network.ttt.TTTBigDataReport.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i16 = 0;
                    byte[] bArr = new byte[0];
                    try {
                        bArr = FeedGlobalEnv.g().encodeJceStrcut(new elaborate_feed_report_req(TTTBigDataReport.this.A(arrayList, i3)));
                    } catch (Throwable th5) {
                        QLog.e("TTTBigDataReport", 1, "[outputReportData] report decode error: ", th5);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(1, bArr);
                    byte[] encodeJceStrcut = FeedGlobalEnv.g().encodeJceStrcut(new comm_qzone_report_req(hashMap));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(TTTBigDataReport.f48500j)) {
                        TTTBigDataReport tTTBigDataReport = TTTBigDataReport.this;
                        FeedGlobalEnv.g();
                        TTTBigDataReport.f48500j = tTTBigDataReport.q(FeedGlobalEnv.getApplication().getFilesDir().getPath());
                    }
                    String str = TTTBigDataReport.f48500j + currentTimeMillis;
                    if (!TTTBigDataReport.this.B(TTTBigDataReport.f48500j, str, encodeJceStrcut)) {
                        str = TTTBigDataReport.this.f48507g + System.currentTimeMillis();
                        TTTBigDataReport tTTBigDataReport2 = TTTBigDataReport.this;
                        if (!tTTBigDataReport2.B(tTTBigDataReport2.f48507g, str, encodeJceStrcut)) {
                            str = null;
                        }
                    }
                    if (str != null) {
                        FeedGlobalEnv.g().sendFeedActionReportDataToOutbox(str, currentTimeMillis);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("TTTBigDataReport outputReportData success, size =");
                        ArrayList arrayList2 = arrayList;
                        if (arrayList2 != null) {
                            i16 = arrayList2.size();
                        }
                        sb5.append(i16);
                        sb5.append(" filePath = ");
                        sb5.append(str);
                        sb5.append(", timeTag = ");
                        sb5.append(currentTimeMillis);
                        com.qzone.proxy.feedcomponent.b.e("TTTBigDataReport", sb5.toString());
                        return;
                    }
                    com.qzone.proxy.feedcomponent.b.c("TTTBigDataReport", "outputReportData filePath null means exception");
                } catch (Throwable th6) {
                    RFWLog.fatal("TTTBigDataReport", RFWLog.USR, th6);
                }
            }
        });
    }

    public long s() {
        return f48498h;
    }

    public int u() {
        return f48499i;
    }

    public void z(int i3) {
        f48499i = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        QZLog.w(e16);
                    }
                    return true;
                } catch (Exception e17) {
                    fileOutputStream = fileOutputStream2;
                    e = e17;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e18) {
                            QZLog.w(e18);
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    fileOutputStream = fileOutputStream2;
                    th = th5;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e19) {
                            QZLog.w(e19);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    public void x(long j3, byte b16, int i3, String str) {
        QZLog.i("TTTBigDataReport", 1, "init");
        f48498h = j3;
        f48499i = b16;
        if (i3 != this.f48502b) {
            this.f48502b = i3;
            c cVar = new c(i3);
            this.f48503c = cVar;
            this.f48504d = cVar.b();
            this.f48505e = 0;
        }
        f48500j = q(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<session_report> A(ArrayList<d> arrayList, int i3) {
        ArrayList<session_report> arrayList2 = new ArrayList<>();
        for (int i16 = 0; i16 < i3; i16++) {
            d dVar = arrayList.get(i16);
            v(w(arrayList2, dVar.f48544b, dVar.f48546d, dVar), arrayList.get(i16).f48545c, arrayList.get(i16).f48547e, dVar.f48549g, dVar.f48550h, dVar.f48551i).vecActionFlow.add(arrayList.get(i16).f48553k);
        }
        this.f48503c.c(arrayList);
        return arrayList2;
    }

    private int r(long j3, String str) {
        int hashCode = str != null ? str.hashCode() : 0;
        return hashCode + (hashCode * 17) + ((int) j3);
    }

    private feed_report_info v(session_report session_reportVar, int i3, Map<Integer, String> map, Map<Integer, String> map2, long j3, int i16) {
        for (int i17 = 0; i17 < session_reportVar.vecFeedReportInfo.size(); i17++) {
            if (session_reportVar.vecFeedReportInfo.get(i17).uFeedIndex == i3) {
                return session_reportVar.vecFeedReportInfo.get(i17);
            }
        }
        feed_report_info feed_report_infoVar = new feed_report_info(map, i3, new ArrayList(), map2, j3, i16);
        session_reportVar.vecFeedReportInfo.add(feed_report_infoVar);
        return feed_report_infoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(final int i3, final int i16, final int i17, final long j3, final Map<Integer, String> map, final BusinessFeedData businessFeedData, final int i18, final int i19, final Map<Integer, String> map2, final long j16, final Map<Integer, String> map3, final long j17, final int i26, final String str) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.misc.network.ttt.TTTBigDataReport.1
            /* JADX WARN: Removed duplicated region for block: B:11:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
            /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Map<Integer, String> map4;
                if (TTTBigDataReport.this.f48504d != null) {
                    if (TTTBigDataReport.this.f48504d.get(TTTBigDataReport.this.f48505e) == null) {
                        TTTBigDataReport.this.f48504d.set(TTTBigDataReport.this.f48505e, new d());
                    }
                    Map<Integer, String> map5 = map2;
                    if (map5 == null) {
                        BusinessFeedData businessFeedData2 = businessFeedData;
                        if (businessFeedData2 != null && businessFeedData2.getOperationInfoV2() != null) {
                            map5 = businessFeedData.getOperationInfoV2().feedReportCookie;
                        } else {
                            com.qzone.proxy.feedcomponent.b.c("TTTBigDataReport", "addAction OperationInfo null");
                            map4 = null;
                            BusinessFeedData businessFeedData3 = businessFeedData;
                            ((d) TTTBigDataReport.this.f48504d.get(TTTBigDataReport.this.f48505e)).a(i3, i16, i17, j3, map, TTTBigDataReport.f48498h, i19, i18, businessFeedData3 != null ? businessFeedData3.getFeedCommInfo().feedskey : null, TTTBigDataReport.f48499i, map4, j16, map3, j17, i26, str);
                            TTTBigDataReport.this.f48505e++;
                            QLog.isColorLevel();
                            if (TTTBigDataReport.this.f48505e != TTTBigDataReport.this.f48502b) {
                                TTTBigDataReport.this.f48505e = 0;
                                TTTBigDataReport tTTBigDataReport = TTTBigDataReport.this;
                                tTTBigDataReport.y(tTTBigDataReport.f48504d, TTTBigDataReport.this.f48502b);
                                TTTBigDataReport tTTBigDataReport2 = TTTBigDataReport.this;
                                tTTBigDataReport2.f48504d = tTTBigDataReport2.f48503c.b();
                                return;
                            }
                            return;
                        }
                    }
                    map4 = map5;
                    BusinessFeedData businessFeedData32 = businessFeedData;
                    if (businessFeedData32 != null) {
                    }
                    ((d) TTTBigDataReport.this.f48504d.get(TTTBigDataReport.this.f48505e)).a(i3, i16, i17, j3, map, TTTBigDataReport.f48498h, i19, i18, businessFeedData32 != null ? businessFeedData32.getFeedCommInfo().feedskey : null, TTTBigDataReport.f48499i, map4, j16, map3, j17, i26, str);
                    TTTBigDataReport.this.f48505e++;
                    QLog.isColorLevel();
                    if (TTTBigDataReport.this.f48505e != TTTBigDataReport.this.f48502b) {
                    }
                } else {
                    com.qzone.proxy.feedcomponent.b.c("TTTBigDataReport", "addAction wrong");
                }
            }
        });
    }
}
