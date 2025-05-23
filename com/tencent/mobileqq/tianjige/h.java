package com.tencent.mobileqq.tianjige;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianjige.b;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f292954a;

    /* renamed from: b, reason: collision with root package name */
    private final c f292955b;

    public h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f292954a = new ConcurrentHashMap<>();
            this.f292955b = new c(i3);
        }
    }

    private void h(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            b.a a16 = b.a();
            if (map == null) {
                map = new HashMap<>();
            }
            a16.b(str);
            a16.c(map);
            this.f292955b.n(a16.a());
            return;
        }
        throw new RuntimeException("report a event with a empty key!");
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "endReportTask taskKey is empty!");
            return;
        }
        a aVar = this.f292954a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "endReportTask is not exist tasKey = " + str);
            return;
        }
        aVar.a();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.f292955b.b();
    }

    public a e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return this.f292954a.get(str);
    }

    public String f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "getTraceInfo taskKey is empty!");
            return "";
        }
        a aVar = this.f292954a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "getTraceInfo is not exist tasKey = " + str);
            return "";
        }
        return aVar.d();
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.f292955b.j();
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f292955b.m();
        }
    }

    public void j(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) map);
        } else {
            h(str, map);
        }
    }

    public void k(com.tencent.mobileqq.tianjige.external.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar);
        } else {
            this.f292955b.p(aVar);
        }
    }

    public void l(String str, String str2, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, map);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "reportTask taskKey is empty!");
            return;
        }
        a aVar = this.f292954a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "reportTask is not exist tasKey = " + str);
            return;
        }
        aVar.e(str2, map);
    }

    public void m(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) map);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "setAttributes taskKey is empty!");
            return;
        }
        a aVar = this.f292954a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "setAttributes is not exist tasKey = " + str);
            return;
        }
        aVar.f(map);
    }

    public void n(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "setStatusCode taskKey is empty!");
            return;
        }
        a aVar = this.f292954a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "setStatusCode is not exist tasKey = " + str);
            return;
        }
        aVar.g(i3);
    }

    public void o(com.tencent.mobileqq.tianjige.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f292955b.c(aVar);
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f292955b.t();
        }
    }

    public String q(String str, Span span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) span);
        }
        return r(str, "", span);
    }

    public String r(String str, String str2, Span span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, str, str2, span);
        }
        a aVar = new a(str, str2, span);
        String c16 = aVar.c();
        if (TextUtils.isEmpty(c16)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "startReportTask taskKey is empty!");
            return "";
        }
        this.f292954a.put(c16, aVar);
        return c16;
    }

    public String s(String str, String str2, Span span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, str, str2, span);
        }
        a aVar = new a(str, "", str2, span);
        String c16 = aVar.c();
        if (TextUtils.isEmpty(c16)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "startReportTask taskKey is empty!");
            return "";
        }
        this.f292954a.put(c16, aVar);
        return c16;
    }

    public void t(String str, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) attributes);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "updateTracerAttribute taskKey is empty!");
            return;
        }
        a aVar = this.f292954a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetry.QQOpenTelemetryReport", 1, "updateTracerAttribute is not exist tasKey = " + str);
            return;
        }
        aVar.h(attributes);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final Span f292956a;

        /* renamed from: b, reason: collision with root package name */
        private final String f292957b;

        a(String str, String str2, Span span) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, h.this, str, str2, span);
                return;
            }
            Span u16 = h.this.f292955b.u(str, span);
            this.f292956a = u16;
            if (!TextUtils.isEmpty(str2)) {
                this.f292957b = str2;
            } else {
                this.f292957b = j.a(u16);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                h.this.f292955b.a(this.f292956a);
                h.this.f292954a.remove(this.f292957b);
            }
        }

        public Span b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Span) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f292956a;
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.f292957b;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return j.a(this.f292956a);
        }

        public void e(String str, Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) map);
                return;
            }
            b.a a16 = b.a();
            if (map == null) {
                map = new HashMap<>();
            }
            a16.b(str);
            a16.c(map);
            h.this.f292955b.o(this.f292956a, a16.a());
        }

        public void f(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) map);
            } else {
                h.this.f292955b.q(this.f292956a, map);
            }
        }

        public void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
                return;
            }
            StatusCode statusCode = StatusCode.OK;
            if (i3 != 0) {
                statusCode = StatusCode.ERROR;
            }
            h.this.f292955b.s(this.f292956a, statusCode);
        }

        public void h(Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) attributes);
            } else {
                h.this.f292955b.w(attributes);
            }
        }

        a(String str, String str2, String str3, Span span) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, h.this, str, str2, str3, span);
                return;
            }
            Span v3 = h.this.f292955b.v(str, str3, span);
            this.f292956a = v3;
            if (!TextUtils.isEmpty(str2)) {
                this.f292957b = str2;
            } else {
                this.f292957b = j.a(v3);
            }
        }
    }
}
