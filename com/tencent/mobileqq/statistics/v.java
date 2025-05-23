package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f290152a;

        /* renamed from: b, reason: collision with root package name */
        public long f290153b;

        /* renamed from: c, reason: collision with root package name */
        public String f290154c;

        /* renamed from: d, reason: collision with root package name */
        public String f290155d;

        /* renamed from: e, reason: collision with root package name */
        public String f290156e;

        /* renamed from: f, reason: collision with root package name */
        public String f290157f;

        /* renamed from: g, reason: collision with root package name */
        public String f290158g;

        /* renamed from: h, reason: collision with root package name */
        public String f290159h;

        /* renamed from: i, reason: collision with root package name */
        public long f290160i;

        /* renamed from: j, reason: collision with root package name */
        public long f290161j;

        /* renamed from: k, reason: collision with root package name */
        public long f290162k;

        /* renamed from: l, reason: collision with root package name */
        public String f290163l;

        /* renamed from: m, reason: collision with root package name */
        public String f290164m;

        /* renamed from: n, reason: collision with root package name */
        public String f290165n;

        /* renamed from: o, reason: collision with root package name */
        public String f290166o;

        /* renamed from: p, reason: collision with root package name */
        public String f290167p;

        /* renamed from: q, reason: collision with root package name */
        public String f290168q;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f290152a = System.currentTimeMillis();
            this.f290153b = AppSetting.f();
            this.f290154c = ah.z();
            this.f290155d = "";
            this.f290167p = AppSetting.f99554n;
            this.f290168q = "AND";
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append(this.f290152a);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290153b);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290154c);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290155d);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290156e);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290157f);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290158g);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290159h);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290160i);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290161j);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290162k);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290163l);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290164m);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290165n);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290166o);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290167p);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f290168q);
            sb5.append(QbAddrData.DATA_SPLITER);
            return sb5.toString();
        }
    }

    public static String a(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, String str8) {
        a aVar = new a();
        aVar.f290156e = str;
        aVar.f290157f = str2;
        aVar.f290158g = str3;
        aVar.f290159h = str4;
        aVar.f290160i = i3;
        aVar.f290161j = i16;
        aVar.f290162k = i17;
        aVar.f290163l = str5;
        aVar.f290164m = str6;
        aVar.f290165n = str7;
        aVar.f290166o = str8;
        String a16 = aVar.a();
        if (QLog.isColorLevel()) {
            QLog.i("SubscribeReportController", 1, "getReportingDetail=" + a16);
        }
        return a16;
    }

    public static void b(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7) {
        QQAppInterface qQAppInterface2;
        AppRuntime peekAppRuntime;
        if (qQAppInterface == null && MobileQQ.sProcessId == 1 && (peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime()) != null && (peekAppRuntime instanceof QQAppInterface)) {
            qQAppInterface2 = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface2 = qQAppInterface;
        }
        if (qQAppInterface2 == null) {
            String a16 = a("${uin_unknown}", str, str2, str3, i3, i16, i17, str4, str5, str6, str7);
            Intent intent = new Intent();
            intent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("reporting_tag", "dc05263");
            intent.putExtra("reporting_detail", a16);
            intent.putExtra("reporting_count", i16);
            intent.putExtra("is_runtime", 0);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
            return;
        }
        ReportController.m(qQAppInterface2, "dc05263", a(qQAppInterface2.getCurrentAccountUin(), str, str2, str3, i3, i16, i17, str4, str5, str6, str7), i16);
    }

    public static void c(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7) {
        b(qQAppInterface, str, str2, str3, i3, 1, i16, str4, str5, str6, str7);
    }
}
