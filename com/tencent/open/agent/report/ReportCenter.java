package com.tencent.open.agent.report;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.open.agent.util.g;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import kotlin.text.Typography;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportCenter {

    /* renamed from: h, reason: collision with root package name */
    protected static ReportCenter f340486h;

    /* renamed from: g, reason: collision with root package name */
    protected Handler f340493g = new a(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    protected Random f340487a = new Random();

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<Serializable> f340489c = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Serializable> f340488b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    protected Executor f340490d = ThreadManagerV2.newSerialExecutor();

    /* renamed from: e, reason: collision with root package name */
    protected Executor f340491e = ThreadManagerV2.newSerialExecutor();

    /* renamed from: f, reason: collision with root package name */
    protected Executor f340492f = ThreadManagerV2.newSerialExecutor();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            boolean z16;
            int i3 = message.what;
            if (i3 != 1000) {
                if (i3 == 1001) {
                    ReportCenter reportCenter = ReportCenter.this;
                    Object obj = message.obj;
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    reportCenter.d(z16);
                }
            } else {
                ReportCenter reportCenter2 = ReportCenter.this;
                Object obj2 = message.obj;
                if (obj2 == null) {
                    str = null;
                } else {
                    str = (String) obj2;
                }
                reportCenter2.c(str);
            }
            super.handleMessage(message);
        }
    }

    protected ReportCenter() {
    }

    public static synchronized ReportCenter f() {
        ReportCenter reportCenter;
        synchronized (ReportCenter.class) {
            if (f340486h == null) {
                f340486h = new ReportCenter();
            }
            reportCenter = f340486h;
        }
        return reportCenter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001f, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0022, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(String str, int i3) {
        int j3;
        int i16 = 5;
        if (str.equals("report_cgi")) {
            j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_CGIReportMaxcount");
        } else if (str.equals("report_via")) {
            j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Agent_ReportBatchCount");
        } else {
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->availableCount, report: " + str + " | dataSize: " + i3 + " | maxcount: " + i16);
        }
        if (i3 < i16) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean b(String str, String str2) {
        int e16;
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->availableFrequency, report: " + str + " | ext: " + str2);
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i3 = 100;
        if (str.equals("report_cgi")) {
            try {
                e16 = e(Integer.parseInt(str2));
                if (this.f340487a.nextInt(100) < e16) {
                    z16 = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                e16 = com.tencent.open.business.viareport.d.d(str2);
                if (new Random().nextInt(100) < e16) {
                    i3 = e16;
                    z16 = true;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ReportCenter", 2, "-->availableFrequency, result: " + z16 + " | frequency: " + i3);
            }
            return z16;
        }
        i3 = e16;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    protected void c(final String str) {
        this.f340492f.execute(new Runnable() { // from class: com.tencent.open.agent.report.ReportCenter.4
            /* JADX WARN: Removed duplicated region for block: B:35:0x018f A[Catch: Exception -> 0x01ca, TryCatch #6 {Exception -> 0x01ca, blocks: (B:3:0x0001, B:7:0x0009, B:10:0x0020, B:12:0x0026, B:51:0x00d2, B:35:0x018f, B:36:0x019d, B:37:0x019f, B:47:0x01ab, B:73:0x01c6, B:78:0x01bd, B:66:0x0112, B:129:0x01c9, B:5:0x0002, B:6:0x0008, B:39:0x01a0, B:40:0x01a7, B:75:0x01b0), top: B:2:0x0001, inners: #7, #8, #19 }] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:62:0x018d A[EDGE_INSN: B:62:0x018d->B:34:0x018d BREAK  A[LOOP:0: B:14:0x0040->B:63:?], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:63:? A[LOOP:0: B:14:0x0040->B:63:?, LOOP_END, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:74:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Bundle h16;
                HttpResponse httpResponse;
                HttpResponse httpResponse2;
                HttpResponse httpResponse3;
                String str2;
                String str3;
                String str4;
                String str5;
                HttpResponse execute;
                try {
                    synchronized (this) {
                        h16 = ReportCenter.this.h();
                    }
                    HttpResponse httpResponse4 = null;
                    int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_HttpRetryCount");
                    if (j3 == 0) {
                        j3 = 3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->doReportCgi, retryCount: " + j3);
                    }
                    boolean z16 = false;
                    int i3 = 0;
                    while (true) {
                        i3++;
                        try {
                            try {
                                HttpClient f16 = HttpBaseUtil.f(null, "https://wspeed.qq.com/w.cgi");
                                HttpPost httpPost = new HttpPost("https://wspeed.qq.com/w.cgi");
                                httpPost.addHeader("Accept-Encoding", "gzip");
                                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                                if (!TextUtils.isEmpty(str) && h16 != null) {
                                    h16.putString(HttpMsg.MTYPE, str);
                                }
                                httpPost.setEntity(new ByteArrayEntity(HttpBaseUtil.d(h16).getBytes()));
                                execute = f16.execute(httpPost);
                                try {
                                    int statusCode = execute.getStatusLine().getStatusCode();
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ReportCenter", 2, "-->doReportCgi, statusCode: " + statusCode);
                                    }
                                    if (statusCode == 200) {
                                        d.e().a("report_cgi");
                                        z16 = true;
                                        break;
                                    }
                                } catch (Error e16) {
                                    httpResponse3 = execute;
                                    e = e16;
                                    try {
                                        QLog.d("ReportCenter", 1, "-->doReportCgi, doupload exception", e);
                                        if (httpResponse3 != null) {
                                            try {
                                                httpResponse3.getEntity().getContent().close();
                                            } catch (Throwable th5) {
                                                th = th5;
                                                str4 = "ReportCenter";
                                                str5 = "-->doReportCgi, doupload exception";
                                                QLog.e(str4, 1, str5, th);
                                                if (i3 < j3) {
                                                }
                                            }
                                        }
                                        if (i3 < j3) {
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        httpResponse4 = httpResponse3;
                                        if (httpResponse4 != null) {
                                            try {
                                                httpResponse4.getEntity().getContent().close();
                                            } catch (Throwable th7) {
                                                QLog.e("ReportCenter", 1, "-->doReportCgi, doupload exception", th7);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e17) {
                                    httpResponse2 = execute;
                                    e = e17;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ReportCenter", 2, "-->doReportCgi, doupload exception", e);
                                    }
                                    if (httpResponse2 != null) {
                                        try {
                                            httpResponse2.getEntity().getContent().close();
                                        } catch (Throwable th8) {
                                            th = th8;
                                            str4 = "ReportCenter";
                                            str5 = "-->doReportCgi, doupload exception";
                                            QLog.e(str4, 1, str5, th);
                                            if (i3 < j3) {
                                            }
                                        }
                                    }
                                    if (i3 < j3) {
                                    }
                                } catch (ConnectTimeoutException e18) {
                                    httpResponse = execute;
                                    e = e18;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ReportCenter", 2, "-->doReportCgi, doupload exception", e);
                                    }
                                    if (httpResponse != null) {
                                        try {
                                            httpResponse.getEntity().getContent().close();
                                        } catch (Throwable th9) {
                                            th = th9;
                                            str4 = "ReportCenter";
                                            str5 = "-->doReportCgi, doupload exception";
                                            QLog.e(str4, 1, str5, th);
                                            if (i3 < j3) {
                                                if (!z16) {
                                                }
                                                synchronized (ReportCenter.this) {
                                                }
                                            }
                                        }
                                    }
                                    if (i3 < j3) {
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    httpResponse4 = execute;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("ReportCenter", 2, "-->doReportCgi, doupload exception", e);
                                    }
                                    if (httpResponse4 != null) {
                                        try {
                                            httpResponse4.getEntity().getContent().close();
                                        } catch (Throwable th10) {
                                            th = th10;
                                            str2 = "ReportCenter";
                                            str3 = "-->doReportCgi, doupload exception";
                                            QLog.e(str2, 1, str3, th);
                                            if (!z16) {
                                            }
                                            synchronized (ReportCenter.this) {
                                            }
                                        }
                                    }
                                    if (!z16) {
                                    }
                                    synchronized (ReportCenter.this) {
                                    }
                                } catch (Throwable th11) {
                                    th = th11;
                                    httpResponse4 = execute;
                                    if (httpResponse4 != null) {
                                    }
                                    throw th;
                                }
                            } catch (Error e26) {
                                e = e26;
                                httpResponse3 = null;
                            } catch (SocketTimeoutException e27) {
                                e = e27;
                                httpResponse2 = null;
                            } catch (ConnectTimeoutException e28) {
                                e = e28;
                                httpResponse = null;
                            } catch (Exception e29) {
                                e = e29;
                            }
                        } catch (Throwable th12) {
                            th = th12;
                        }
                    }
                    try {
                        execute.getEntity().getContent().close();
                        break;
                    } catch (Throwable th13) {
                        th = th13;
                        str2 = "ReportCenter";
                        str3 = "-->doReportCgi, doupload exception";
                        QLog.e(str2, 1, str3, th);
                        if (!z16) {
                        }
                        synchronized (ReportCenter.this) {
                        }
                    }
                    if (!z16) {
                        d.e().h("report_cgi", ReportCenter.this.f340488b);
                    }
                    synchronized (ReportCenter.this) {
                        ReportCenter.this.f340488b.clear();
                    }
                } catch (Exception e36) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->doReportCgi, exception in serial executor.", e36);
                    }
                }
            }
        });
    }

    protected void d(final boolean z16) {
        this.f340491e.execute(new Runnable() { // from class: com.tencent.open.agent.report.ReportCenter.5
            /* JADX WARN: Removed duplicated region for block: B:32:0x010a A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:3:0x0003, B:7:0x000c, B:9:0x0012, B:10:0x002e, B:30:0x00eb, B:32:0x010a, B:33:0x0123, B:34:0x0125, B:38:0x012e, B:40:0x0134, B:46:0x014f, B:47:0x0115, B:69:0x0084, B:71:0x00a7, B:72:0x00a9, B:76:0x00b2, B:78:0x00b8, B:84:0x00c4, B:64:0x00ce, B:67:0x00d4, B:74:0x00aa, B:75:0x00b1, B:36:0x0126, B:37:0x012d, B:14:0x0043, B:17:0x0053, B:19:0x005f, B:21:0x006a, B:23:0x006c), top: B:2:0x0003, inners: #1, #6, #7, #9, #11, #12, #13 }] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0115 A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:3:0x0003, B:7:0x000c, B:9:0x0012, B:10:0x002e, B:30:0x00eb, B:32:0x010a, B:33:0x0123, B:34:0x0125, B:38:0x012e, B:40:0x0134, B:46:0x014f, B:47:0x0115, B:69:0x0084, B:71:0x00a7, B:72:0x00a9, B:76:0x00b2, B:78:0x00b8, B:84:0x00c4, B:64:0x00ce, B:67:0x00d4, B:74:0x00aa, B:75:0x00b1, B:36:0x0126, B:37:0x012d, B:14:0x0043, B:17:0x0053, B:19:0x005f, B:21:0x006a, B:23:0x006c), top: B:2:0x0003, inners: #1, #6, #7, #9, #11, #12, #13 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                long j3;
                long j16;
                long j17;
                int i3;
                long elapsedRealtime;
                int i16;
                long j18;
                HttpBaseUtil.c m3;
                int i17;
                try {
                    Bundle i18 = ReportCenter.this.i();
                    if (i18 == null) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->doReportVia, params: " + i18.toString());
                    }
                    int e16 = com.tencent.open.business.viareport.d.e();
                    int i19 = 0;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j19 = 0;
                    long j26 = 0;
                    boolean z17 = false;
                    int i26 = 0;
                    do {
                        int i27 = i19 + 1;
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            try {
                                                m3 = HttpBaseUtil.m("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", i18);
                                                try {
                                                    i17 = HttpBaseUtil.o(m3.f340999a).getInt("ret");
                                                } catch (JSONException unused) {
                                                    i17 = -4;
                                                }
                                                if (i17 == 0 || !TextUtils.isEmpty(m3.f340999a)) {
                                                    i27 = e16;
                                                    z17 = true;
                                                }
                                                j18 = m3.f341000b;
                                            } catch (HttpBaseUtil.NetworkUnavailableException unused2) {
                                                synchronized (ReportCenter.this) {
                                                    ReportCenter.this.f340489c.clear();
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("ReportCenter", 2, "-->doReportVia, NetworkUnavailableException.");
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } catch (Exception unused3) {
                                                i19 = e16;
                                                i26 = -6;
                                                j19 = 0;
                                                j26 = 0;
                                            } catch (IncompatibleClassChangeError unused4) {
                                                j3 = elapsedRealtime2;
                                                j16 = 0;
                                                j17 = 0;
                                                i3 = -6;
                                            }
                                            try {
                                                j26 = m3.f341001c;
                                                i19 = i27;
                                                j19 = j18;
                                            } catch (HttpBaseUtil.HttpStatusException e17) {
                                                e = e17;
                                                try {
                                                    i26 = Integer.parseInt(e.getMessage().replace(HttpBaseUtil.HttpStatusException.ERROR_INFO, ""));
                                                } catch (Exception unused5) {
                                                }
                                                i3 = i26;
                                                j16 = j18;
                                                j3 = elapsedRealtime2;
                                                j17 = j26;
                                                ReportCenter.this.k("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", j3, j16, j17, i3, com.tencent.open.adapter.a.f().l(), "1000069", null, false, z16);
                                                if (!z17) {
                                                }
                                                synchronized (ReportCenter.this) {
                                                }
                                            }
                                        } catch (IOException e18) {
                                            i26 = HttpCgiAsyncTask.e(e18);
                                            i19 = i27;
                                            j19 = 0;
                                            j26 = 0;
                                        }
                                    } catch (ConnectTimeoutException unused6) {
                                        elapsedRealtime = SystemClock.elapsedRealtime();
                                        i16 = -7;
                                        elapsedRealtime2 = elapsedRealtime;
                                        j19 = 0;
                                        j26 = 0;
                                        i26 = i16;
                                        i19 = i27;
                                    }
                                } catch (SocketTimeoutException unused7) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i16 = -8;
                                    elapsedRealtime2 = elapsedRealtime;
                                    j19 = 0;
                                    j26 = 0;
                                    i26 = i16;
                                    i19 = i27;
                                }
                            } catch (HttpBaseUtil.HttpStatusException e19) {
                                e = e19;
                                j18 = j19;
                            }
                        } catch (JSONException unused8) {
                            i19 = i27;
                            i26 = -4;
                            j19 = 0;
                            j26 = 0;
                        }
                    } while (i19 < e16);
                    i3 = i26;
                    j3 = elapsedRealtime2;
                    j16 = j19;
                    j17 = j26;
                    ReportCenter.this.k("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", j3, j16, j17, i3, com.tencent.open.adapter.a.f().l(), "1000069", null, false, z16);
                    if (!z17) {
                        d.e().a("report_via");
                    } else {
                        d.e().h("report_via", ReportCenter.this.f340489c);
                    }
                    synchronized (ReportCenter.this) {
                        ReportCenter.this.f340489c.clear();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->doReportVia, uploadSuccess: " + z17);
                    }
                } catch (Exception e26) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->doReportVia, exception in serial executor.", e26);
                    }
                }
            }
        });
    }

    protected int e(int i3) {
        if (i3 == 0) {
            int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_CGIReportFrequencySuccess");
            if (j3 == 0) {
                return 10;
            }
            return j3;
        }
        int j16 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_CGIReportFrequencyFailed");
        if (j16 == 0) {
            return 100;
        }
        return j16;
    }

    public void g(final String str, String str2, final Bundle bundle, final boolean z16) {
        this.f340490d.execute(new Runnable() { // from class: com.tencent.open.agent.report.ReportCenter.6
            /* JADX WARN: Removed duplicated region for block: B:34:0x010b A[Catch: Exception -> 0x0125, TryCatch #7 {Exception -> 0x0125, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000e, B:11:0x0015, B:14:0x002c, B:16:0x0032, B:34:0x010b, B:36:0x0111, B:39:0x0118, B:41:0x011e, B:77:0x00d7, B:72:0x00df, B:74:0x00e5, B:55:0x00ed, B:57:0x00f3, B:65:0x00fb, B:67:0x0101), top: B:2:0x0004 }] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0118 A[Catch: Exception -> 0x0125, TryCatch #7 {Exception -> 0x0125, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000e, B:11:0x0015, B:14:0x002c, B:16:0x0032, B:34:0x010b, B:36:0x0111, B:39:0x0118, B:41:0x011e, B:77:0x00d7, B:72:0x00df, B:74:0x00e5, B:55:0x00ed, B:57:0x00f3, B:65:0x00fb, B:67:0x0101), top: B:2:0x0004 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                try {
                    if (bundle == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ReportCenter", 2, "-->httpRequest, params is null!");
                            return;
                        }
                        return;
                    }
                    int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_HttpRetryCount");
                    if (j3 == 0) {
                        j3 = 3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->httpRequest, retryCount: " + j3);
                    }
                    int i3 = 0;
                    boolean z17 = false;
                    do {
                        i3++;
                        try {
                            HttpClient f16 = HttpBaseUtil.f(null, str);
                            String d16 = HttpBaseUtil.d(bundle);
                            if (z16) {
                                d16 = URLEncoder.encode(d16);
                            }
                            StringBuffer stringBuffer = new StringBuffer(str);
                            stringBuffer.append(d16);
                            HttpGet httpGet = new HttpGet(stringBuffer.toString());
                            httpGet.addHeader("Accept-Encoding", "gzip");
                            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
                            int statusCode = f16.execute(httpGet).getStatusLine().getStatusCode();
                            if (QLog.isColorLevel()) {
                                QLog.d("ReportCenter", 2, "-->httpRequest, statusCode: " + statusCode);
                            }
                            if (statusCode != 200) {
                                if (!QLog.isColorLevel()) {
                                    break;
                                }
                                QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest : HttpStatuscode != 200");
                                break;
                            }
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Thread success");
                                }
                                z17 = true;
                                break;
                            } catch (SocketTimeoutException e16) {
                                e = e16;
                                z17 = true;
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest SocketTimeoutException", e);
                                }
                            } catch (ConnectTimeoutException e17) {
                                e = e17;
                                z17 = true;
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest ConnectTimeoutException", e);
                                }
                            } catch (Exception e18) {
                                e = e18;
                                z17 = true;
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Exception", e);
                                }
                                if (z17) {
                                }
                            } catch (NoClassDefFoundError e19) {
                                e = e19;
                                z17 = true;
                                QLog.e("ReportCenter", 1, "-->ReportCenter httpRequest noClassDefFoundError", e);
                                if (z17) {
                                }
                            }
                        } catch (SocketTimeoutException e26) {
                            e = e26;
                        } catch (ConnectTimeoutException e27) {
                            e = e27;
                        } catch (Exception e28) {
                            e = e28;
                        } catch (NoClassDefFoundError e29) {
                            e = e29;
                        }
                    } while (i3 < j3);
                    if (z17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Thread request success");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->ReportCenter httpRequest Thread request failed");
                    }
                } catch (Exception e36) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->httpRequest, exception in serial executor.", e36);
                    }
                }
            }
        });
    }

    protected Bundle h() {
        List<Serializable> f16 = d.e().f("report_cgi");
        if (f16 != null) {
            this.f340488b.addAll(f16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->prepareCgiData, itemList size: " + this.f340488b.size());
        }
        if (this.f340488b.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("releaseversion", com.tencent.open.adapter.a.f().i());
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", com.tencent.open.business.cgireport.a.f341075b);
            bundle.putString("key", "appid,apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i3 = 0; i3 < this.f340488b.size(); i3++) {
                BaseData baseData = (BaseData) this.f340488b.get(i3);
                bundle.putString(i3 + "_1", baseData.attrs.get("appid"));
                bundle.putString(i3 + "_2", baseData.attrs.get("apn"));
                bundle.putString(i3 + "_3", baseData.attrs.get("frequency"));
                bundle.putString(i3 + "_4", baseData.attrs.get("commandid"));
                bundle.putString(i3 + "_5", baseData.attrs.get(QzoneIPCModule.RESULT_CODE));
                bundle.putString(i3 + "_6", baseData.attrs.get("timeCost"));
                bundle.putString(i3 + "_7", baseData.attrs.get("reqSize"));
                bundle.putString(i3 + "_8", baseData.attrs.get("rspSize"));
                bundle.putString(i3 + "_9", baseData.attrs.get("detail"));
                bundle.putString(i3 + "_10", baseData.attrs.get("uin"));
                bundle.putString(i3 + "_11", MobileInfoUtil.getDeviceinfoForCgiReport(Boolean.toString(true).equals(baseData.attrs.get("from_opensdk"))) + ContainerUtils.FIELD_DELIMITER + baseData.attrs.get("deviceInfo"));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ReportCenter", 2, "-->prepareCgiData, exception.", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->prepareCgiData, end. params: " + bundle.toString());
        }
        return bundle;
    }

    protected synchronized Bundle i() {
        List<Serializable> f16 = d.e().f("report_via");
        if (f16 != null) {
            this.f340489c.addAll(f16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->prepareViaData, itemList size: " + this.f340489c.size());
        }
        if (this.f340489c.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Serializable> it = this.f340489c.iterator();
        while (it.hasNext()) {
            Serializable next = it.next();
            JSONObject jSONObject = new JSONObject();
            BaseData baseData = (BaseData) next;
            for (String str : baseData.attrs.keySet()) {
                try {
                    jSONObject.put(str, baseData.attrs.get(str));
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", e16);
                    }
                }
            }
            jSONArray.mo162put(jSONObject);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        }
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("ReportCenter", 2, "-->prepareViaData, put bundle to json array exception", e17);
            }
            return bundle;
        }
    }

    public void j(String str, long j3, long j16, long j17, int i3, long j18, String str2, String str3, boolean z16) {
        k(str, j3, j16, j17, i3, j18, str2, str3, z16, false);
    }

    public void k(final String str, long j3, final long j16, final long j17, final int i3, final long j18, final String str2, final String str3, final boolean z16, final boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->reportCgi, command: " + str + " | startTime: " + j3 + " | reqSize:" + j16 + " | rspSize: " + j17 + " | responseCode: " + i3 + " | uin: " + j18 + " | appid: " + str2 + " | detail: " + str3);
        }
        if (!b("report_cgi", "" + i3) && !z16) {
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j3;
        this.f340492f.execute(new Runnable() { // from class: com.tencent.open.agent.report.ReportCenter.3
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                try {
                    Bundle bundle = new Bundle();
                    String c16 = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
                    bundle.putString("apn", c16);
                    bundle.putString("appid", str2);
                    bundle.putString("commandid", str);
                    bundle.putString("detail", str3);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("network=");
                    sb5.append(c16);
                    sb5.append(Typography.amp);
                    sb5.append("sdcard=");
                    int i17 = 1;
                    if (Environment.getExternalStorageState().equals("mounted")) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    sb5.append(i16);
                    sb5.append(Typography.amp);
                    sb5.append("wifi=");
                    sb5.append(com.tencent.open.base.a.h(com.tencent.open.adapter.a.f().e()));
                    bundle.putString("deviceInfo", sb5.toString());
                    int e16 = 100 / ReportCenter.this.e(i3);
                    if (e16 > 0) {
                        if (e16 > 100) {
                            i17 = 100;
                        } else {
                            i17 = e16;
                        }
                    }
                    bundle.putString("frequency", i17 + "");
                    bundle.putString("reqSize", j16 + "");
                    bundle.putString(QzoneIPCModule.RESULT_CODE, i3 + "");
                    bundle.putString("rspSize", j17 + "");
                    bundle.putString("timeCost", elapsedRealtime + "");
                    bundle.putString("uin", j18 + "");
                    bundle.putString("from_opensdk", Boolean.toString(z17));
                    BaseData baseData = new BaseData(bundle);
                    synchronized (this) {
                        ReportCenter.this.f340488b.add(baseData);
                    }
                    int size = ReportCenter.this.f340488b.size() + d.e().g("report_cgi");
                    int j19 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Agent_ReportTimeInterval");
                    if (j19 == 0) {
                        j19 = 10000;
                    }
                    if (!ReportCenter.this.a("report_cgi", size) && !z16) {
                        if (!ReportCenter.this.f340493g.hasMessages(1000)) {
                            Message obtain = Message.obtain();
                            obtain.what = 1000;
                            obtain.obj = "yingyongbao";
                            ReportCenter.this.f340493g.sendMessageDelayed(obtain, j19);
                            return;
                        }
                        return;
                    }
                    ReportCenter.this.c("yingyongbao");
                    ReportCenter.this.f340493g.removeMessages(1000);
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->reportCgi, exception in sub thread.", e17);
                    }
                }
            }
        });
    }

    public void l(Bundle bundle, String str, String str2, boolean z16) {
        m(bundle, str, str2, z16, false);
    }

    public void m(final Bundle bundle, String str, final String str2, final boolean z16, final boolean z17) {
        if (bundle == null) {
            return;
        }
        try {
            com.tencent.open.adapter.a.f().s(Long.valueOf(str2).longValue());
        } catch (Exception unused) {
            com.tencent.open.adapter.a.f().s(0L);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->reportVia, bundle: " + bundle.toString());
        }
        if (!b("report_via", str) && !z16) {
            return;
        }
        this.f340491e.execute(new Runnable() { // from class: com.tencent.open.agent.report.ReportCenter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("uin", str2);
                    bundle2.putString("platform", "4");
                    bundle2.putString("os_ver", Build.VERSION.RELEASE);
                    bundle2.putString(IjkMediaMeta.IJKM_KEY_LANGUAGE, MobileInfoUtil.getLanguage());
                    bundle2.putString("resolution", MobileInfoUtil.getResolution());
                    bundle2.putString("qq_ver", com.tencent.open.adapter.a.f().d());
                    bundle2.putString("qua", com.tencent.open.adapter.a.f().i());
                    bundle2.putString("via", "2");
                    bundle2.putString("result", "0");
                    Bundle bundle3 = bundle;
                    if (bundle3 != null) {
                        bundle2.putAll(bundle3);
                    }
                    BaseData baseData = new BaseData(bundle2);
                    synchronized (ReportCenter.this) {
                        ReportCenter.this.f340489c.add(baseData);
                    }
                    int size = ReportCenter.this.f340489c.size() + d.e().g("report_via");
                    int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Agent_ReportTimeInterval");
                    if (j3 == 0) {
                        j3 = 10000;
                    }
                    if (!ReportCenter.this.a("report_via", size) && !z16) {
                        if (!ReportCenter.this.f340493g.hasMessages(1001)) {
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            obtain.obj = Boolean.valueOf(z17);
                            ReportCenter.this.f340493g.sendMessageDelayed(obtain, j3);
                            return;
                        }
                        return;
                    }
                    ReportCenter.this.d(z17);
                    ReportCenter.this.f340493g.removeMessages(1001);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->reportVia, exception in sub thread.", e16);
                    }
                }
            }
        });
    }

    public void n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z16) {
        o(str, str2, str3, str4, str5, str6, str7, str8, str9, z16, false);
    }

    public void o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z16, boolean z17) {
        try {
            m(g.i(str, str2, str4, str5, str3, str6, str7, "", "", str8, str9), str3, str, z16, z17);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReportCenter", 2, "-->reportVia 2 exception", e16);
            }
        }
    }

    public void p(String str, String str2, String str3, String str4, String str5, String str6, boolean z16) {
        q(str, str2, str3, str4, str5, str6, z16, false);
    }

    public void q(String str, String str2, String str3, String str4, String str5, String str6, boolean z16, boolean z17) {
        try {
            m(g.i(str, str2, str4, str5, str3, str6, str5, "", "", "", ""), str3, str, z16, z17);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReportCenter", 2, "-->reportVia 1 exception", e16);
            }
        }
    }

    public void r(final String str, final int i3, final int i16, final String str2, final int i17, final String str3, final boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ReportCenter", 2, "-->reportCgi, command: " + str + " | responseCode: " + i16 + " | uin: " + str2 + " | detail: " + str3);
        }
        this.f340492f.execute(new Runnable() { // from class: com.tencent.open.agent.report.ReportCenter.7
            @Override // java.lang.Runnable
            public void run() {
                int i18;
                try {
                    Bundle bundle = new Bundle();
                    String c16 = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
                    bundle.putString("apn", c16);
                    bundle.putString("appid", "" + i17);
                    bundle.putString("commandid", str);
                    bundle.putString("detail", str3);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("network=");
                    sb5.append(c16);
                    sb5.append(Typography.amp);
                    sb5.append("sdcard=");
                    int i19 = 1;
                    if (Environment.getExternalStorageState().equals("mounted")) {
                        i18 = 1;
                    } else {
                        i18 = 0;
                    }
                    sb5.append(i18);
                    sb5.append(Typography.amp);
                    sb5.append("wifi=");
                    sb5.append(com.tencent.open.base.a.h(com.tencent.open.adapter.a.f().e()));
                    bundle.putString("deviceInfo", sb5.toString());
                    int i26 = 100 / i3;
                    if (i26 > 0) {
                        if (i26 > 100) {
                            i19 = 100;
                        } else {
                            i19 = i26;
                        }
                    }
                    bundle.putString("frequency", "" + i19);
                    bundle.putString("reqSize", "0");
                    bundle.putString(QzoneIPCModule.RESULT_CODE, i16 + "");
                    bundle.putString("rspSize", "0");
                    bundle.putString("timeCost", "0");
                    bundle.putString("uin", str2 + "");
                    BaseData baseData = new BaseData(bundle);
                    synchronized (this) {
                        ReportCenter.this.f340488b.add(baseData);
                    }
                    int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Agent_ReportTimeInterval");
                    if (j3 == 0) {
                        j3 = 10000;
                    }
                    if (z16) {
                        ReportCenter.this.c(null);
                        ReportCenter.this.f340493g.removeMessages(1000);
                    } else if (!ReportCenter.this.f340493g.hasMessages(1000)) {
                        Message obtain = Message.obtain();
                        obtain.what = 1000;
                        ReportCenter.this.f340493g.sendMessageDelayed(obtain, j3);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportCenter", 2, "-->reportCgi, exception in sub thread.", e16);
                    }
                }
            }
        });
    }
}
