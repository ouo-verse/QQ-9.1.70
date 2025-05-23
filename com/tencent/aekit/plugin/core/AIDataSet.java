package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AIDataSet {
    static IPatchRedirector $redirector_;
    private Map<String, AIData> aiDataMap;

    public AIDataSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.aiDataMap = new Hashtable();
        }
    }

    public void addAIData(String str, AIData aIData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aIData);
        } else {
            this.aiDataMap.put(str, aIData);
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Map<String, AIData> map = this.aiDataMap;
        if (map != null) {
            map.clear();
        }
    }

    public AIData getAIData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return this.aiDataMap.get(str);
    }
}
