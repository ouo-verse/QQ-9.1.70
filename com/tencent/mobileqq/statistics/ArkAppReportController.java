package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ArkAppReportController {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f289881a;

        /* renamed from: b, reason: collision with root package name */
        public String f289882b;

        /* renamed from: c, reason: collision with root package name */
        public String f289883c;

        /* renamed from: d, reason: collision with root package name */
        public long f289884d;

        /* renamed from: e, reason: collision with root package name */
        public long f289885e;

        /* renamed from: f, reason: collision with root package name */
        public long f289886f;

        /* renamed from: g, reason: collision with root package name */
        public long f289887g;

        /* renamed from: h, reason: collision with root package name */
        public final long f289888h;

        /* renamed from: i, reason: collision with root package name */
        public long f289889i;

        /* renamed from: j, reason: collision with root package name */
        public long f289890j;

        /* renamed from: k, reason: collision with root package name */
        public String f289891k;

        /* renamed from: l, reason: collision with root package name */
        public String f289892l;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f289888h = 2L;
            this.f289881a = "";
            this.f289882b = "";
            this.f289883c = "";
            this.f289884d = 0L;
            this.f289885e = 0L;
            this.f289886f = 1L;
            this.f289887g = 0L;
            this.f289889i = 0L;
            this.f289890j = 0L;
            this.f289891k = "";
            this.f289892l = "";
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append(this.f289881a);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289882b);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289883c);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289884d);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289885e);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append("${count_unknown}");
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289887g);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(2L);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289889i);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289890j);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289891k);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f289892l);
            sb5.append(QbAddrData.DATA_SPLITER);
            return sb5.toString();
        }
    }

    private static String a(a aVar) {
        return aVar.a();
    }

    public static void b(AppRuntime appRuntime, String str, String str2, String str3, long j3, long j16, long j17, long j18, long j19, String str4, String str5) {
        a aVar = new a();
        aVar.f289881a = str;
        aVar.f289882b = str2;
        aVar.f289883c = str3;
        aVar.f289884d = j3;
        aVar.f289885e = j16;
        aVar.f289887g = j17;
        aVar.f289889i = j18;
        aVar.f289890j = j19;
        aVar.f289891k = str4;
        aVar.f289892l = str5;
        aVar.f289886f = 1L;
        if (appRuntime == null) {
            String a16 = a(aVar);
            if (QLog.isColorLevel()) {
                QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + a16);
            }
            ThreadManagerV2.executeOnSubThread(new Runnable(a16) { // from class: com.tencent.mobileqq.statistics.ArkAppReportController.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f289880d;

                {
                    this.f289880d = a16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
                    intent.putExtra("reporting_tag", "dc01616");
                    intent.putExtra("reporting_detail", this.f289880d);
                    intent.putExtra("reporting_count", 1);
                    intent.putExtra("is_runtime", 0);
                    BaseApplication.getContext().sendBroadcast(intent);
                }
            });
            return;
        }
        String a17 = a(aVar);
        if (QLog.isColorLevel()) {
            QLog.i("ArkAppReportController", 1, "getReportingDetail=" + a17);
        }
        ReportController.m(appRuntime, "dc01616", a17, 1);
    }
}
