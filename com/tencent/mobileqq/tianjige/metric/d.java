package com.tencent.mobileqq.tianjige.metric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.metrics.DoubleHistogram;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private DoubleHistogram f292978a;

    /* renamed from: b, reason: collision with root package name */
    private String f292979b;

    /* renamed from: c, reason: collision with root package name */
    private String f292980c;

    /* renamed from: d, reason: collision with root package name */
    private String f292981d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DoubleHistogram doubleHistogram, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, doubleHistogram, str, str2, str3);
            return;
        }
        this.f292978a = doubleHistogram;
        this.f292979b = str;
        this.f292980c = str2;
        this.f292981d = str3;
    }

    public static d a(DoubleHistogram doubleHistogram, String str, String str2, String str3) {
        return new e().c(doubleHistogram).d(str).b(str2).e(str3).a();
    }

    public void b(double d16, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Double.valueOf(d16), map);
            return;
        }
        if (this.f292978a == null) {
            QLog.e("MetricHistogram", 1, "record error: param wrong");
            return;
        }
        AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
        a16.put("platform", "android").put("network_type", h.f292989i).put("ipfamily", h.f292987g).put("network_strength", h.f292988h).put("app_env", "public_ver");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a16.put(entry.getKey(), entry.getValue());
            }
        }
        this.f292978a.record(d16, a16.build());
    }

    public void c(long j3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), map);
            return;
        }
        if (this.f292978a == null) {
            QLog.e("MetricHistogram", 1, "record error: param wrong");
            return;
        }
        AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
        a16.put("platform", "android").put("network_type", h.f292989i).put("ipfamily", h.f292987g).put("network_strength", h.f292988h).put("app_env", "public_ver");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a16.put(entry.getKey(), entry.getValue());
            }
        }
        this.f292978a.record(j3, a16.build());
    }
}
