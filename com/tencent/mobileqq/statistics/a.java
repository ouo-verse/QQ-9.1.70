package com.tencent.mobileqq.statistics;

import NearbyGroup.LBSInfo;
import android.content.Intent;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Pair<LBSInfo, Long> f289933a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f289934b;

    /* renamed from: c, reason: collision with root package name */
    public static String f289935c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.statistics.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C8615a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f289936a;

        /* renamed from: b, reason: collision with root package name */
        public String f289937b;

        /* renamed from: c, reason: collision with root package name */
        public String f289938c;

        /* renamed from: d, reason: collision with root package name */
        public String f289939d;

        /* renamed from: e, reason: collision with root package name */
        public String f289940e;

        /* renamed from: f, reason: collision with root package name */
        public String f289941f;

        /* renamed from: g, reason: collision with root package name */
        public String f289942g;

        /* renamed from: h, reason: collision with root package name */
        public String f289943h;

        /* renamed from: i, reason: collision with root package name */
        public String f289944i;

        /* renamed from: j, reason: collision with root package name */
        public String f289945j;

        /* renamed from: k, reason: collision with root package name */
        public String f289946k;

        /* renamed from: l, reason: collision with root package name */
        public String f289947l;

        /* renamed from: m, reason: collision with root package name */
        public String f289948m;

        /* renamed from: n, reason: collision with root package name */
        public String f289949n;

        /* renamed from: o, reason: collision with root package name */
        public String f289950o;

        /* renamed from: p, reason: collision with root package name */
        public String f289951p;

        /* renamed from: q, reason: collision with root package name */
        public String f289952q;

        /* renamed from: r, reason: collision with root package name */
        public String f289953r;

        /* renamed from: s, reason: collision with root package name */
        public String f289954s;

        /* renamed from: t, reason: collision with root package name */
        public String f289955t;

        /* renamed from: u, reason: collision with root package name */
        public String f289956u;

        /* renamed from: v, reason: collision with root package name */
        public String f289957v;

        public C8615a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f289936a = "";
            this.f289937b = "";
            this.f289938c = "";
            this.f289939d = "";
            this.f289940e = "";
            this.f289941f = "";
            this.f289942g = "";
            this.f289943h = "";
            this.f289944i = "";
            this.f289945j = "";
            this.f289946k = "";
            this.f289947l = "";
            this.f289948m = "";
            this.f289949n = "";
            this.f289950o = "";
            this.f289951p = "";
            this.f289952q = "";
            this.f289953r = "";
            this.f289954s = "";
            this.f289955t = "";
            this.f289956u = "";
            this.f289957v = "";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75410);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f289933a = null;
        f289934b = false;
        f289935c = "";
    }

    private static String a(String str, String str2, String str3, C8615a c8615a, int i3) {
        QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append(str2);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append("${count_unknown}");
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289936a);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289937b);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289938c);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289939d);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289940e);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289941f);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289942g);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289943h);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289944i);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289945j);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289946k);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289947l);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289948m);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289949n);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289950o);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289951p);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289952q);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289953r);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289954s);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289955t);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289956u);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(c8615a.f289957v);
        sb5.append(QbAddrData.DATA_SPLITER);
        return sb5.toString();
    }

    public static void b(String str, String str2, String str3, C8615a c8615a) {
        String a16 = a(str2, str, str3, c8615a, 1);
        if (QLog.isColorLevel()) {
            QLog.i("AVShortVideoReportController", 2, "POST getReportingDetail=" + a16);
        }
        Intent intent = new Intent();
        intent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
        intent.putExtra("reporting_tag", str2);
        intent.putExtra("reporting_detail", a16);
        intent.putExtra("reporting_count", 1);
        intent.putExtra("is_runtime", 0);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
    }
}
