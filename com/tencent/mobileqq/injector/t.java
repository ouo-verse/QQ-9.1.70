package com.tencent.mobileqq.injector;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class t implements com.tencent.mobileqq.inject.l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f238082a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f238083b;

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238082a = new AtomicBoolean(false);
            this.f238083b = new AtomicBoolean(false);
        }
    }

    @Override // com.tencent.mobileqq.inject.l
    public String a(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) hashMap);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_upload_sync_trace_start", "\u635e\u65e5\u5fd7upload\u5f00\u59cb");
        if (hashMap != null && hashMap.size() > 0) {
            hashMap2.putAll(hashMap);
        }
        String u16 = com.tencent.mobileqq.tianjige.f.d(11).u("Log_push_upload_sync_trace", hashMap2, "Log_push_upload_prepare_trace");
        QLog.i("LogOpenTelemetryInjector", 1, "reportLogUploadStart\uff0ctraceId=" + u16);
        return u16;
    }

    @Override // com.tencent.mobileqq.inject.l
    public void b(int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_upload_sync_trace_end", "\u635e\u65e5\u5fd7upload\u7ed3\u675f");
        if (hashMap != null && hashMap.size() > 0) {
            hashMap2.putAll(hashMap);
        }
        com.tencent.mobileqq.tianjige.f.d(11).b("Log_push_upload_sync_trace", i3, hashMap2);
        QLog.i("LogOpenTelemetryInjector", 1, "reportLogUploadEnd");
    }

    @Override // com.tencent.mobileqq.inject.l
    public String c(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) hashMap);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_zip_trace_start", "\u635e\u65e5\u5fd7zip\u5f00\u59cb");
        if (hashMap != null && hashMap.size() > 0) {
            hashMap2.putAll(hashMap);
        }
        String u16 = com.tencent.mobileqq.tianjige.f.d(11).u("Log_push_upload_zip_trace", hashMap2, "Log_push_upload_prepare_trace");
        QLog.i("LogOpenTelemetryInjector", 1, "reportLogZipStart\uff0ctraceId=" + u16);
        return u16;
    }

    @Override // com.tencent.mobileqq.inject.l
    public void d(int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_zip_trace_end", "\u635e\u65e5\u5fd7zip\u7ed3\u675f");
        if (hashMap != null && hashMap.size() > 0) {
            hashMap2.putAll(hashMap);
        }
        com.tencent.mobileqq.tianjige.f.d(11).b("Log_push_upload_zip_trace", i3, hashMap2);
        QLog.i("LogOpenTelemetryInjector", 1, "reportLogZipEnd");
    }

    @Override // com.tencent.mobileqq.inject.l
    public String e(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hashMap);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_trace_start", "\u635e\u65e5\u5fd7\u94fe\u8def\u5f00\u59cb");
        if (hashMap != null && hashMap.size() > 0) {
            hashMap2.putAll(hashMap);
        }
        String t16 = com.tencent.mobileqq.tianjige.f.d(11).t("Log_push_upload_prepare_trace", hashMap2);
        QLog.i("LogOpenTelemetryInjector", 1, "reportAllStart\uff0ctraceId=" + t16);
        return t16;
    }

    @Override // com.tencent.mobileqq.inject.l
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f238082a.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.tencent.mobileqq.tianjige.f.e(11, new a.C8649a().o("qq").m(1.0d).p(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).l(AppSetting.n()).n(true).k());
            } catch (Exception e16) {
                QLog.e("LogOpenTelemetryInjector", 1, "initTelemetryConfig error", e16);
            }
            QLog.d("LogOpenTelemetryInjector", 2, "initTelemetryConfig cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.tencent.mobileqq.inject.l
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f238083b.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.tencent.mobileqq.tianjige.metric.f.d(11, new a.C8649a().o("qq").m(1.0d).p(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).l(AppSetting.n()).n(true).k());
            } catch (Exception e16) {
                QLog.e("LogOpenTelemetryInjector", 1, "initMetricConfig error", e16);
            }
            QLog.i("LogOpenTelemetryInjector", 2, "initMetricConfig cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.tencent.mobileqq.inject.l
    public void h(int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_trace_end", "\u635e\u65e5\u5fd7\u94fe\u8def\u7ed3\u675f");
        if (hashMap != null && hashMap.size() > 0) {
            hashMap2.putAll(hashMap);
        }
        com.tencent.mobileqq.tianjige.f.d(11).b("Log_push_upload_prepare_trace", i3, hashMap2);
        QLog.i("LogOpenTelemetryInjector", 1, "reportAllEnd");
    }

    @Override // com.tencent.mobileqq.inject.l
    public void i(String str, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) hashMap);
            return;
        }
        QLog.i("LogOpenTelemetryInjector", 1, "metricName=" + str);
        HashMap hashMap2 = new HashMap();
        if (hashMap != null && hashMap.size() > 0) {
            hashMap2.putAll(hashMap);
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            QLog.i("LogOpenTelemetryInjector", 1, "params, key: " + ((String) entry.getKey()) + ", value: " + ((String) entry.getValue()));
        }
        com.tencent.mobileqq.tianjige.metric.f.b(11).b(str).c(1L, hashMap2);
    }
}
