package com.tencent.ttpic.openapi.plugin;

import com.tencent.aekit.plugin.core.AEDetectorType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AICtrl {
    private Map<String, Boolean> aiModuleSwitch = new HashMap();
    private Map<String, Integer> aiModuleFreq = new HashMap();

    public void clearModule() {
        this.aiModuleSwitch.clear();
    }

    public int getModuleFreq(String str) {
        if (this.aiModuleFreq.get(str) != null) {
            return this.aiModuleFreq.get(str).intValue();
        }
        return 1;
    }

    public boolean hasModuleOn() {
        Iterator<Map.Entry<String, Boolean>> it = this.aiModuleSwitch.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean isModuleOn(String str) {
        if (this.aiModuleSwitch.get(str) != null) {
            return this.aiModuleSwitch.get(str).booleanValue();
        }
        return false;
    }

    public void setModuleFreq(String str, int i3) {
        this.aiModuleFreq.put(str, Integer.valueOf(i3));
    }

    public void switchModule(AEDetectorType aEDetectorType, boolean z16) {
        this.aiModuleSwitch.put(aEDetectorType.value, Boolean.valueOf(z16));
    }

    public void switchModule(String str, boolean z16) {
        this.aiModuleSwitch.put(str, Boolean.valueOf(z16));
    }
}
