package com.tencent.could.huiyansdk.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j implements Comparator<Map.Entry<String, Integer>> {
    static IPatchRedirector $redirector_;

    public j(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar);
        }
    }

    @Override // java.util.Comparator
    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entry, (Object) entry2)).intValue();
        }
        return entry2.getValue().compareTo(entry.getValue());
    }
}
