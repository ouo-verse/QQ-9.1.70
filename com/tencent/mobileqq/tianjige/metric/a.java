package com.tencent.mobileqq.tianjige.metric;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.metrics.LongCounter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private LongCounter f292966a;

    /* renamed from: b, reason: collision with root package name */
    private String f292967b;

    /* renamed from: c, reason: collision with root package name */
    private String f292968c;

    /* renamed from: d, reason: collision with root package name */
    private String f292969d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LongCounter longCounter, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, longCounter, str, str2, str3);
            return;
        }
        this.f292966a = longCounter;
        this.f292967b = str;
        this.f292968c = str2;
        this.f292969d = str3;
    }

    public static a d(LongCounter longCounter, String str, String str2, String str3) {
        return new b().c(longCounter).d(str).b(str2).e(str3).a();
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            b(j3, null, null);
        }
    }

    public void b(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, str2);
            return;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hashMap.put(str, str2);
        }
        c(j3, hashMap);
    }

    public void c(long j3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), map);
            return;
        }
        if (this.f292966a != null && j3 >= 0) {
            AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
            a16.put("platform", "android").put("network_type", h.f292989i).put("ipfamily", h.f292987g).put("network_strength", h.f292988h).put("app_env", "public_ver");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    a16.put(entry.getKey(), entry.getValue());
                }
            }
            this.f292966a.add(j3, a16.build());
            return;
        }
        QLog.e("MetricCounter", 1, "add error: param wrong");
    }
}
