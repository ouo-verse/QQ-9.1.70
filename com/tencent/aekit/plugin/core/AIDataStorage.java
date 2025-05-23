package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AIDataStorage {
    static IPatchRedirector $redirector_;
    Map<String, Object> aiDataMap;

    public AIDataStorage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.aiDataMap = new HashMap();
        }
    }

    public synchronized void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.aiDataMap.clear();
        }
    }

    public synchronized AIDataSet genNewAIDataSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AIDataSet) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AIDataSet aIDataSet = new AIDataSet();
        for (Map.Entry<String, Object> entry : this.aiDataMap.entrySet()) {
            aIDataSet.addAIData(entry.getKey(), new AIData(entry.getKey(), entry.getValue()));
        }
        return aIDataSet;
    }

    public synchronized void init(List<IDetect> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.aiDataMap.put(list.get(i3).getModuleType(), null);
            }
        }
    }

    public synchronized void put(IDetect iDetect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iDetect);
        } else {
            if (iDetect != null) {
                this.aiDataMap.put(iDetect.getModuleType(), null);
            }
        }
    }

    public synchronized void remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            if (str != null) {
                this.aiDataMap.remove(str);
            }
        }
    }

    public synchronized void reset(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.aiDataMap.remove(str);
        }
    }

    public synchronized void update(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, obj);
        } else {
            this.aiDataMap.put(str, obj);
        }
    }

    public synchronized AIDataSet genNewAIDataSet(Map<String, Boolean> map) {
        AIDataSet aIDataSet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AIDataSet) iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
        }
        if (map != null) {
            aIDataSet = new AIDataSet();
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    aIDataSet.addAIData(entry.getKey(), new AIData(entry.getKey(), this.aiDataMap.get(entry.getKey())));
                }
            }
        } else {
            aIDataSet = null;
        }
        return aIDataSet;
    }
}
