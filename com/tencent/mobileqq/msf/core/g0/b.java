package com.tencent.mobileqq.msf.core.g0;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f248353a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f248354b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f248355c;

    /* renamed from: d, reason: collision with root package name */
    MsfCore f248356d;

    public b(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f248353a = "StanbyModeStat";
        this.f248354b = new ConcurrentHashMap<>();
        this.f248355c = new ConcurrentHashMap<>();
        this.f248356d = msfCore;
    }

    private String a(ConcurrentHashMap<String, Integer> concurrentHashMap) {
        StringBuilder sb5 = new StringBuilder();
        try {
            Iterator<Map.Entry<String, Integer>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                if (it.hasNext()) {
                    sb5.append(next.getKey());
                    sb5.append(":");
                    sb5.append(next.getValue());
                    sb5.append("|");
                } else {
                    sb5.append(next.getKey());
                    sb5.append(":");
                    sb5.append(next.getValue());
                }
            }
        } catch (Exception unused) {
            QLog.d("StanbyModeStat", 1, "constructReport error");
        }
        return sb5.toString();
    }

    private void b() {
        if (this.f248356d.statReporter != null) {
            String a16 = a(this.f248354b);
            String a17 = a(this.f248355c);
            HashMap hashMap = new HashMap();
            hashMap.put("refusedCmd", a16);
            hashMap.put("permitCmd", a17);
            hashMap.put("account", this.f248356d.getStandByModeManager().b());
            this.f248356d.statReporter.a(g.H0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f248354b.put(toServiceMsg.getServiceCmd(), Integer.valueOf(this.f248354b.containsKey(toServiceMsg.getServiceCmd()) ? 1 + this.f248354b.get(toServiceMsg.getServiceCmd()).intValue() : 1));
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
        }
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f248355c.put(toServiceMsg.getServiceCmd(), Integer.valueOf(this.f248355c.containsKey(toServiceMsg.getServiceCmd()) ? 1 + this.f248355c.get(toServiceMsg.getServiceCmd()).intValue() : 1));
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        b();
        this.f248354b.clear();
        this.f248355c.clear();
    }
}
