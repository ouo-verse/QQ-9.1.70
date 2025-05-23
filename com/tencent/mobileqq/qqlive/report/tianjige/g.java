package com.tencent.mobileqq.qqlive.report.tianjige;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f271469b;

    /* renamed from: a, reason: collision with root package name */
    private final e f271470a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final Span f271471a;

        /* renamed from: b, reason: collision with root package name */
        private final e f271472b;

        /* renamed from: c, reason: collision with root package name */
        private final String f271473c;

        /* renamed from: d, reason: collision with root package name */
        private StatusCode f271474d;

        a(e eVar, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, eVar, str, str2);
                return;
            }
            this.f271474d = StatusCode.OK;
            Span r16 = eVar.r(str);
            this.f271471a = r16;
            this.f271472b = eVar;
            if (!TextUtils.isEmpty(str2)) {
                this.f271473c = str2;
            } else {
                this.f271473c = h.a(eVar, r16);
            }
        }

        public static a a(e eVar, String str, String str2) {
            return new a(eVar, str, str2);
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f271472b.a(this.f271471a, this.f271474d);
                g.f271469b.remove(this.f271473c);
            }
        }

        public String c(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str, str2);
            }
            boolean f16 = this.f271472b.f();
            boolean h16 = this.f271472b.h();
            if (!f16 && h16 && z16) {
                return str2;
            }
            return str;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f271473c;
        }

        public String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return h.a(this.f271472b, this.f271471a);
        }

        public void f(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) map);
            } else {
                this.f271472b.n(this.f271471a, map);
            }
        }

        public void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            if (i3 != 0) {
                this.f271474d = StatusCode.ERROR;
            }
            this.f271472b.q(this.f271471a, this.f271474d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f271469b = new ConcurrentHashMap<>();
        }
    }

    public g(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        } else {
            this.f271470a = eVar;
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "endReportTask taskKey is empty!");
            return;
        }
        a aVar = f271469b.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "endReportTask is not exist tasKey = " + str);
            return;
        }
        aVar.b();
    }

    public String c(String str, boolean z16, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, str, Boolean.valueOf(z16), str2, str3);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "getSourceTag taskKey is empty!");
            return "";
        }
        a aVar = f271469b.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "getSourceTag is not exist tasKey = " + str);
            return "";
        }
        return aVar.c(z16, str2, str3);
    }

    public String d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "getTraceInfo taskKey is empty!");
            return "";
        }
        a aVar = f271469b.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "getTraceInfo is not exist tasKey = " + str);
            return "";
        }
        return aVar.e();
    }

    public void e(String str, Map<String, String> map) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) map);
        } else {
            if (TextUtils.isEmpty(str) || (aVar = f271469b.get(str)) == null) {
                return;
            }
            aVar.f(map);
        }
    }

    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "setStatusCode taskKey is empty!");
            return;
        }
        a aVar = f271469b.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "setStatusCode is not exist tasKey = " + str);
            return;
        }
        aVar.g(i3);
    }

    public String g(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        a a16 = a.a(this.f271470a, str, str2);
        String d16 = a16.d();
        if (TextUtils.isEmpty(d16)) {
            QLog.e("QQOpenTelemetryReport", 1, "startReportTask taskKey is empty!");
            return "";
        }
        f271469b.put(d16, a16);
        return d16;
    }
}
