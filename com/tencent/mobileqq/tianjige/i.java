package com.tencent.mobileqq.tianjige;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianjige.h;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static String f292959e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f292960a;

    /* renamed from: b, reason: collision with root package name */
    private final h f292961b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f292962c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f292963d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f292964a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, String> f292965b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f292964a = 0;
                this.f292965b = new ArrayMap();
            }
        }

        public Map<String, String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f292965b;
        }

        public a b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            }
            this.f292965b.put(str, str2);
            return this;
        }

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            return b("err_msg", str);
        }

        public a d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            return b("result_code", String.valueOf(i3));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            f292959e = "QQOpenTelemetry.QQProtocolTelemetryTracer";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
            return;
        }
        this.f292963d = new HashMap();
        this.f292961b = hVar;
        this.f292960a = hVar.g();
        this.f292962c = new ConcurrentHashMap();
        f292959e += "." + hVar.d();
    }

    public static String c(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return null;
        }
        return toServiceMsg.extraData.getString("telemetry_report_task_key");
    }

    private void n(ToServiceMsg toServiceMsg, String str) {
        if (toServiceMsg == null) {
            return;
        }
        toServiceMsg.extraData.putString("telemetry_report_task_key", str);
        String f16 = this.f292961b.f(str);
        if (!TextUtils.isEmpty(f16)) {
            toServiceMsg.setTraceInfo(f16);
        } else {
            QLog.e(f292959e, 1, "startQQMsgProtocolReport: traceInfo is empty!");
        }
    }

    public void a(String str, int i3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), map);
            return;
        }
        if (!this.f292960a) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e(f292959e, 2, "endNetRespReport taskKey is empty!");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(f292959e, 2, "endReport: ");
            }
            this.f292962c.remove(str);
            this.f292961b.m(str, map);
            this.f292961b.n(str, i3);
            this.f292961b.c(str);
        }
    }

    public void b(String str, int i3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Integer.valueOf(i3), map);
        } else {
            a(d(str), i3, map);
        }
    }

    public String d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        }
        String str2 = this.f292962c.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public String e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        }
        if (!this.f292960a) {
            return "";
        }
        return this.f292961b.f(d(str));
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f292961b.i();
        }
    }

    public void g(String str, String str2, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, map);
            return;
        }
        if (!this.f292960a) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f292959e, 2, "reportNetReqEvent taskKey is empty! event: " + str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f292959e, 2, "reportEvent: " + str2);
        }
        this.f292961b.l(str, str2, map);
    }

    public void h(String str, String str2, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, map);
            return;
        }
        Map<String, Long> map2 = this.f292963d;
        if (map2 != null) {
            map2.put(str + str2, Long.valueOf(SystemClock.uptimeMillis()));
        }
        if (!this.f292960a) {
            return;
        }
        g(d(str), str2, map);
    }

    public void i(com.tencent.mobileqq.tianjige.external.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) aVar);
        } else {
            this.f292961b.k(aVar);
        }
    }

    public void j(String str, String str2, ToServiceMsg toServiceMsg, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, toServiceMsg, map);
            return;
        }
        if (!this.f292960a) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e(f292959e, 2, "reportNetReqEvent taskKey is empty!");
            }
        } else {
            n(toServiceMsg, str);
            g(str, str2, map);
        }
    }

    public void k(String str, String str2, ToServiceMsg toServiceMsg, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, toServiceMsg, map);
        } else {
            j(d(str), str2, toServiceMsg, map);
        }
    }

    public void l(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) map);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f292959e, 2, "reportSingleEvent: " + str);
        }
        this.f292961b.j(str, map);
    }

    public void m(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) map);
        } else {
            if (!this.f292960a) {
                return;
            }
            this.f292961b.m(d(str), map);
        }
    }

    public void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.f292960a = z16;
        }
    }

    public void p(com.tencent.mobileqq.tianjige.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f292961b.o(aVar);
            o(aVar.f());
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f292961b.p();
        }
    }

    public String r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return t(str, new ArrayMap());
    }

    public String s(String str, ToServiceMsg toServiceMsg, Map<String, String> map, String str2) {
        String q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, this, str, toServiceMsg, map, str2);
        }
        if (!this.f292960a) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d(f292959e, 1, "startQQMsgProtocolReport taskName is Empty!");
            return "";
        }
        if (QLog.isColorLevel()) {
            QLog.d(f292959e, 2, "startReport: " + str);
        }
        if (!TextUtils.isEmpty(str2)) {
            h.a e16 = this.f292961b.e(d(str2));
            if (e16 != null) {
                q16 = this.f292961b.q(str, e16.b());
            } else {
                q16 = this.f292961b.q(str, null);
            }
        } else {
            q16 = this.f292961b.q(str, null);
        }
        if (TextUtils.isEmpty(q16)) {
            QLog.d(f292959e, 1, "startQQMsgProtocolReport taskName is Empty!");
            return q16;
        }
        this.f292962c.put(str, q16);
        this.f292961b.m(q16, map);
        n(toServiceMsg, q16);
        return q16;
    }

    public String t(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) map);
        }
        return s(str, null, map, null);
    }

    public String u(String str, Map<String, String> map, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, map, str2);
        }
        return s(str, null, map, str2);
    }

    public String v(String str, String str2, Map<String, String> map, String str3) {
        String s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, this, str, str2, map, str3);
        }
        if (!this.f292960a) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d(f292959e, 1, "startReport taskName is Empty!");
            return "";
        }
        if (QLog.isColorLevel()) {
            QLog.d(f292959e, 2, "startReport: " + str);
        }
        if (!TextUtils.isEmpty(str3)) {
            h.a e16 = this.f292961b.e(d(str3));
            if (e16 != null) {
                s16 = this.f292961b.s(str, str2, e16.b());
            } else {
                s16 = this.f292961b.s(str, str2, null);
            }
        } else {
            s16 = this.f292961b.s(str, str2, null);
        }
        if (TextUtils.isEmpty(s16)) {
            QLog.d(f292959e, 1, "startQQMsgProtocolReport taskName is Empty!");
            return s16;
        }
        this.f292962c.put(str, s16);
        this.f292961b.m(s16, map);
        return s16;
    }

    public void w(String str, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, (Object) attributes);
            return;
        }
        if (!this.f292960a) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e(f292959e, 2, "updateTracerAttribute taskKey is empty!");
                return;
            }
            return;
        }
        this.f292961b.t(str, attributes);
    }

    public void x(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) map);
            return;
        }
        if (!this.f292960a) {
            return;
        }
        AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
        if (map != null) {
            for (String str2 : map.keySet()) {
                a16.put(str2, map.get(str2));
            }
        }
        w(d(str), a16.build());
    }
}
