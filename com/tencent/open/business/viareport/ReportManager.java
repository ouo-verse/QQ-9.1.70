package com.tencent.open.business.viareport;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.MobileInfoUtil;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportManager {

    /* renamed from: e, reason: collision with root package name */
    protected static ReportManager f341091e;

    /* renamed from: a, reason: collision with root package name */
    protected String f341092a = "";

    /* renamed from: d, reason: collision with root package name */
    protected volatile boolean f341095d = false;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<b> f341093b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<b> f341094c = new ArrayList<>();

    protected ReportManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x02ab A[LOOP:0: B:2:0x0033->B:15:0x02ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0220 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str, String str2, Bundle bundle, boolean z16, boolean z17) {
        long elapsedRealtime;
        int i3;
        long j3;
        long j16;
        long j17;
        HttpBaseUtil.c m3;
        int i16;
        int e16 = d.e();
        com.tencent.open.base.f.e("viareport", "<Viareport> doUploadItems requestRetryCount=" + e16);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        int i17 = 0;
        boolean z18 = false;
        int i18 = 0;
        long j18 = 0;
        long j19 = 0;
        while (true) {
            int i19 = i17 + 1;
            try {
                try {
                    try {
                        m3 = HttpBaseUtil.m(str, str2, bundle);
                        try {
                            i16 = HttpBaseUtil.o(m3.f340999a).getInt("ret");
                        } catch (JSONException unused) {
                            i16 = -4;
                        }
                        if (i16 == 0 || !TextUtils.isEmpty(m3.f340999a)) {
                            i19 = e16;
                            z18 = true;
                        }
                        j3 = m3.f341000b;
                    } catch (HttpBaseUtil.NetworkUnavailableException e17) {
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e17.toString());
                        this.f341095d = false;
                        return;
                    } catch (SocketTimeoutException e18) {
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e18.toString());
                        i3 = -8;
                        elapsedRealtime2 = elapsedRealtime;
                        j3 = 0;
                        j16 = 0;
                        i18 = i3;
                        i17 = i19;
                        if (i17 >= e16) {
                        }
                    } catch (ConnectTimeoutException e19) {
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e19.toString());
                        i3 = -7;
                        elapsedRealtime2 = elapsedRealtime;
                        j3 = 0;
                        j16 = 0;
                        i18 = i3;
                        i17 = i19;
                        if (i17 >= e16) {
                        }
                    } catch (IOException e26) {
                        i18 = HttpCgiAsyncTask.e(e26);
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e26.toString());
                        i17 = i19;
                        j3 = 0;
                        j16 = 0;
                        if (i17 >= e16) {
                        }
                    }
                } catch (HttpBaseUtil.HttpStatusException e27) {
                    e = e27;
                    j17 = j18;
                } catch (Exception e28) {
                    e = e28;
                    j3 = j18;
                }
                try {
                    j16 = m3.f341001c;
                    i17 = i19;
                } catch (HttpBaseUtil.HttpStatusException e29) {
                    e = e29;
                    j17 = j3;
                    try {
                        int parseInt = Integer.parseInt(e.getMessage().replace(HttpBaseUtil.HttpStatusException.ERROR_INFO, ""));
                        if (e(parseInt)) {
                            com.tencent.open.business.cgireport.ReportManager.h().k("mapp_apptrace", elapsedRealtime2, j17, j19, parseInt, com.tencent.open.adapter.a.f().l(), "1000002", null, z17);
                        }
                    } catch (Exception unused2) {
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e.toString());
                    }
                    com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e.toString());
                    this.f341095d = false;
                    return;
                } catch (Exception e36) {
                    e = e36;
                    if (e instanceof HttpBaseUtil.NetworkUnavailableException) {
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e.toString());
                        this.f341095d = false;
                        return;
                    }
                    if (e instanceof HttpBaseUtil.HttpStatusException) {
                        try {
                            int parseInt2 = Integer.parseInt(e.getMessage().replace(HttpBaseUtil.HttpStatusException.ERROR_INFO, ""));
                            if (e(parseInt2)) {
                                com.tencent.open.business.cgireport.ReportManager.h().k("mapp_apptrace", elapsedRealtime2, j3, j19, parseInt2, com.tencent.open.adapter.a.f().l(), "1000002", null, z17);
                            }
                        } catch (Exception unused3) {
                            com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e.toString());
                        }
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e.toString());
                        this.f341095d = false;
                        return;
                    }
                    if (e instanceof IOException) {
                        i18 = HttpCgiAsyncTask.e((IOException) e);
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e.toString());
                        i17 = i19;
                        j3 = 0;
                        j16 = 0;
                        if (i17 >= e16) {
                        }
                    } else {
                        com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e.toString());
                        i18 = -6;
                        i17 = e16;
                        j3 = 0;
                        j16 = 0;
                        if (i17 >= e16) {
                        }
                    }
                }
            } catch (JSONException e37) {
                com.tencent.open.base.f.c("viareport", "<Viareport> doUploadItems error : " + e37.toString());
                i17 = i19;
                i18 = -4;
                j3 = 0;
                j16 = 0;
                if (i17 >= e16) {
                }
            }
            if (i17 >= e16) {
                com.tencent.open.base.f.a("viareport", "mapp_apptrace | " + elapsedRealtime2 + APLogFileUtil.SEPARATOR_LOG + j3 + APLogFileUtil.SEPARATOR_LOG + j16 + APLogFileUtil.SEPARATOR_LOG + i18);
                if (e(i18)) {
                    com.tencent.open.business.cgireport.ReportManager.h().k("mapp_apptrace", elapsedRealtime2, j3, j16, i18, com.tencent.open.adapter.a.f().l(), "1000002", null, z17);
                }
                if (z18) {
                    com.tencent.open.base.f.e("business_report_debug", "ReportManager doUploadItems Thread request success");
                } else {
                    com.tencent.open.base.f.e("business_report_debug", "ReportManager doUploadItems Thread request failed");
                    if (z16) {
                        e.e().a(this.f341094c);
                        e.e().a(this.f341093b);
                    }
                }
                if (z16) {
                    com.tencent.open.base.f.e("viareport", " set isUploading = false");
                    this.f341095d = false;
                    if (z18) {
                        k(z17);
                        return;
                    }
                    return;
                }
                return;
            }
            j19 = j16;
            j18 = j3;
        }
    }

    public static synchronized ReportManager i() {
        ReportManager reportManager;
        synchronized (ReportManager.class) {
            if (f341091e == null) {
                f341091e = new ReportManager();
            }
            reportManager = f341091e;
        }
        return reportManager;
    }

    private void k(final boolean z16) {
        final String valueOf = String.valueOf(com.tencent.open.adapter.a.f().l());
        if (b(valueOf)) {
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.business.viareport.ReportManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ReportManager.this.f341095d) {
                        com.tencent.open.base.f.e("viareport", "isUploading ---return");
                    } else if (ReportManager.this.b(valueOf)) {
                        ReportManager.this.f(valueOf, null, true, z16);
                    }
                }
            });
        }
    }

    protected synchronized boolean a(String str, Bundle bundle) {
        this.f341093b = e.e().g(str);
        e.e().b("table_new_data", str);
        this.f341094c = e.e().h(str);
        e.e().b("table_old_data", str);
        String h16 = h(this.f341093b, this.f341094c);
        com.tencent.open.base.f.e("viareport", ">>>batchInfo:" + h16);
        bundle.putString("appid_via_act_net_time", h16);
        if (TextUtils.isEmpty(h16)) {
            return false;
        }
        return true;
    }

    protected synchronized boolean b(String str) {
        int f16 = d.f();
        com.tencent.open.base.f.e("viareport", "maxCount=" + f16);
        if (e.e().c(str) >= f16) {
            com.tencent.open.base.f.e("business_report_debug", "ReportManager availableForCount = ture");
            return true;
        }
        com.tencent.open.base.f.e("business_report_debug", "ReportManager availableForCount = false");
        return false;
    }

    protected synchronized boolean c(String str) {
        int d16 = d.d(str);
        com.tencent.open.base.f.e("viareport", "frequency=" + d16);
        if (new Random().nextInt(100) < d16) {
            com.tencent.open.base.f.e("report_debug", "ReportManager availableForFrequency = ture");
            return true;
        }
        com.tencent.open.base.f.e("report_debug", "ReportManager availableForFrequency = false");
        return false;
    }

    protected synchronized boolean d() {
        long a16 = d.a();
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.open.base.f.e("viareport", "lastReportTime=" + a16 + " currentTime=" + currentTimeMillis);
        long g16 = d.g();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportTimeInterval=");
        sb5.append(g16);
        com.tencent.open.base.f.e("viareport", sb5.toString());
        if (currentTimeMillis - a16 < g16 * 1000) {
            com.tencent.open.base.f.e("business_report_debug", "ReportManager availableForTime = false");
            return false;
        }
        d.i(currentTimeMillis);
        com.tencent.open.base.f.e("business_report_debug", "ReportManager availableForTime = ture");
        return true;
    }

    protected synchronized boolean e(int i3) {
        int h16 = d.h(i3);
        com.tencent.open.base.f.e("viareport", "Via success ratio sampling frequency = " + h16);
        if (new Random().nextInt(100) < h16) {
            com.tencent.open.base.f.e("report_debug", "ReportManager Via success ratio sampling frequency avaliable = ture");
            return true;
        }
        com.tencent.open.base.f.e("report_debug", "ReportManager Via success ratio sampling frequency avaliable = false");
        return false;
    }

    protected void f(String str, Bundle bundle, boolean z16, boolean z17) {
        String str2;
        Bundle bundle2 = new Bundle();
        if (z16) {
            if (!a(str, bundle2)) {
                com.tencent.open.base.f.e("viareport", "database empty");
                return;
            }
            this.f341095d = true;
        }
        bundle2.putString("uin", str);
        bundle2.putString("platform", com.tencent.open.adapter.a.f().h());
        bundle2.putString("action", "100");
        bundle2.putString("resolution", MobileInfoUtil.getResolution());
        bundle2.putString("mobile_pf", "1");
        bundle2.putString("os_ver", Build.VERSION.RELEASE);
        bundle2.putString("lang", MobileInfoUtil.getLanguage());
        bundle2.putString(HiAnalyticsConstant.BI_KEY_SDK_VER, "1.5");
        bundle2.putString("ret_code", "0");
        bundle2.putString("qua", com.tencent.open.adapter.a.f().i());
        bundle2.putString("qz_ver", com.tencent.open.adapter.a.f().d());
        bundle2.putString("ext", com.tencent.open.adapter.a.f().j());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (z16) {
            str2 = "POST";
        } else {
            str2 = "GET";
        }
        g(j(), str2, bundle2, z16, z17);
    }

    protected String h(ArrayList<b> arrayList, ArrayList<b> arrayList2) {
        StringBuilder sb5 = new StringBuilder();
        if (arrayList != null) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                sb5.append(next.f341103a + "_" + next.f341104b + "_" + next.f341105c + "_" + next.a() + "_" + next.f341109g);
                if (!TextUtils.isEmpty(next.f341110h)) {
                    sb5.append("_" + next.f341110h);
                }
                if (!TextUtils.isEmpty(next.f341111i)) {
                    sb5.append("_" + next.f341111i);
                }
                if (!TextUtils.isEmpty(next.f341112j)) {
                    sb5.append("_" + next.f341112j);
                }
                if (!TextUtils.isEmpty(next.f341113k)) {
                    sb5.append("_" + next.f341113k);
                }
                if (!TextUtils.isEmpty(next.f341114l)) {
                    sb5.append("_" + next.f341114l);
                }
                sb5.append(",");
            }
        }
        if (arrayList2 != null) {
            Iterator<b> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                b next2 = it5.next();
                sb5.append(next2.f341103a + "_" + next2.f341104b + "_" + next2.f341105c + "_" + next2.a() + "_" + next2.f341109g);
                if (!TextUtils.isEmpty(next2.f341110h)) {
                    sb5.append("_" + next2.f341110h);
                }
                if (!TextUtils.isEmpty(next2.f341111i)) {
                    sb5.append("_" + next2.f341111i);
                }
                if (!TextUtils.isEmpty(next2.f341112j)) {
                    sb5.append("_" + next2.f341112j);
                }
                if (!TextUtils.isEmpty(next2.f341113k)) {
                    sb5.append("_" + next2.f341113k);
                }
                if (!TextUtils.isEmpty(next2.f341114l)) {
                    sb5.append("_" + next2.f341114l);
                }
                sb5.append(",");
            }
        }
        String sb6 = sb5.toString();
        if (sb6.endsWith(",")) {
            return sb6.substring(0, sb6.length() - 1);
        }
        return sb6;
    }

    protected String j() {
        if (TextUtils.isEmpty(this.f341092a)) {
            this.f341092a = "https://analy.qq.com/cgi-bin/mapp_apptrace";
        }
        return this.f341092a;
    }

    public void l(final String str, final b bVar, final Bundle bundle, final boolean z16, final boolean z17) {
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.business.viareport.ReportManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z18 = false;
                if (z16 && bVar == null) {
                    Bundle bundle2 = bundle;
                    if (bundle2 != null && ReportManager.this.c(bundle2.getString("appid_for_getting_config"))) {
                        ReportManager.this.f(str, bundle, false, z17);
                        return;
                    }
                    return;
                }
                b bVar2 = bVar;
                if (bVar2 != null && bVar2.b() && ReportManager.this.c(null)) {
                    e.e().k("table_new_data", bVar);
                }
                if (ReportManager.this.f341095d) {
                    com.tencent.open.base.f.e("viareport", "isUploading ---return");
                    return;
                }
                if (!z16 && !ReportManager.this.b(str) && !ReportManager.this.d()) {
                    return;
                }
                ReportManager reportManager = ReportManager.this;
                String str2 = str;
                Bundle bundle3 = bundle;
                if (bVar != null) {
                    z18 = true;
                }
                reportManager.f(str2, bundle3, z18, z17);
            }
        });
    }
}
