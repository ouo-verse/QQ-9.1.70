package com.tencent.mobileqq.qqguildsdk.tianjige;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.tianjige.g;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f268535a = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Span f268536a;

        /* renamed from: b, reason: collision with root package name */
        private final String f268537b;

        /* renamed from: c, reason: collision with root package name */
        private StatusCode f268538c = StatusCode.OK;

        a(String str, String str2) {
            Span v3 = h.f().v(str);
            this.f268536a = v3;
            if (!TextUtils.isEmpty(str2)) {
                this.f268537b = str2;
            } else {
                this.f268537b = k.a(v3);
            }
        }

        public static a a(String str, String str2) {
            return new a(str, str2);
        }

        public void b() {
            h.f().b(this.f268536a, this.f268538c);
            j.f268535a.remove(this.f268537b);
        }

        public String c() {
            return this.f268537b;
        }

        public String d() {
            return k.a(this.f268536a);
        }

        public void e(String str, Map<String, String> map) {
            g.a a16 = g.a();
            if (map == null) {
                map = new HashMap<>();
            }
            a16.b(str);
            a16.c(map);
            h.f().q(this.f268536a, a16.a());
        }

        public void f(Map<String, String> map) {
            h.f().r(this.f268536a, map);
        }

        public void g(int i3) {
            if (i3 != 0) {
                this.f268538c = StatusCode.ERROR;
            }
            h.f().u(this.f268536a, this.f268538c);
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "endReportTask taskKey is empty!");
            return;
        }
        a aVar = f268535a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "endReportTask is not exist tasKey = " + str);
            return;
        }
        aVar.b();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "getTraceInfo taskKey is empty!");
            return "";
        }
        a aVar = f268535a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "getTraceInfo is not exist tasKey = " + str);
            return "";
        }
        return aVar.d();
    }

    private static void d(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            g.a a16 = g.a();
            if (map == null) {
                map = new HashMap<>();
            }
            a16.b(str);
            a16.c(map);
            h.f().p(a16.a());
            return;
        }
        throw new RuntimeException("report a event with a empty key!");
    }

    public static void e(String str) {
        f(str, new HashMap());
    }

    public static void f(String str, Map<String, String> map) {
        d(str, map);
    }

    public static void g(String str, String str2) {
        h(str, str2, new HashMap());
    }

    public static void h(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "reportTask taskKey is empty!");
            return;
        }
        a aVar = f268535a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "reportTask is not exist tasKey = " + str);
            return;
        }
        aVar.e(str2, map);
    }

    public static void i(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "setAttributes taskKey is empty!");
            return;
        }
        a aVar = f268535a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "setAttributes is not exist tasKey = " + str);
            return;
        }
        aVar.f(map);
    }

    public static void j(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQOpenTelemetryReport", 1, "setStatusCode taskKey is empty!");
            return;
        }
        a aVar = f268535a.get(str);
        if (aVar == null) {
            QLog.e("QQOpenTelemetryReport", 1, "setStatusCode is not exist tasKey = " + str);
            return;
        }
        aVar.g(i3);
    }

    @Deprecated
    public static void k(e eVar) {
        h.f().g(eVar);
    }

    public static String l(String str) {
        return m(str, "");
    }

    public static String m(String str, String str2) {
        a a16 = a.a(str, str2);
        String c16 = a16.c();
        if (TextUtils.isEmpty(c16)) {
            QLog.e("QQOpenTelemetryReport", 1, "startReportTask taskKey is empty!");
            return "";
        }
        f268535a.put(c16, a16);
        return c16;
    }
}
