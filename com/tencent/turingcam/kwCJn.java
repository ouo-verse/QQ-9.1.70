package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class kwCJn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Map<Integer, Long> f382302a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, Long> f382303b;

    public kwCJn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382302a = new HashMap();
            this.f382303b = new HashMap();
        }
    }

    public void a(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f382302a.put(Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<Integer> it = this.f382302a.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (sb5.length() > 0) {
                sb5.append(",");
            }
            sb5.append(intValue);
            sb5.append("_");
            sb5.append(this.f382302a.get(Integer.valueOf(intValue)));
        }
        Iterator<Integer> it5 = this.f382303b.keySet().iterator();
        while (it5.hasNext()) {
            int intValue2 = it5.next().intValue();
            if (sb5.length() > 0) {
                sb5.append(",");
            }
            sb5.append('s');
            sb5.append(intValue2);
            sb5.append("_");
            sb5.append(this.f382303b.get(Integer.valueOf(intValue2)));
        }
        return sb5.toString();
    }
}
