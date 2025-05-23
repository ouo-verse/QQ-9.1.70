package com.tencent.mtt.hippy.modules.nativemodules;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyNativeModuleBase {
    protected final HippyEngineContext mContext;
    private HashMap<String, Integer> mEventMaps;

    public HippyNativeModuleBase(HippyEngineContext hippyEngineContext) {
        this.mContext = hippyEngineContext;
    }

    @HippyMethod(name = "addListener")
    public void addListener(String str) {
        int i3;
        if (this.mEventMaps == null) {
            this.mEventMaps = new HashMap<>();
        }
        if (this.mEventMaps.containsKey(str)) {
            i3 = this.mEventMaps.get(str).intValue();
        } else {
            i3 = 0;
        }
        int i16 = i3 + 1;
        if (i16 == 1) {
            handleAddListener(str);
        }
        this.mEventMaps.remove(str);
        this.mEventMaps.put(str, Integer.valueOf(i16));
    }

    @HippyMethod(name = "removeListener")
    public void removeListener(String str) {
        HashMap<String, Integer> hashMap = this.mEventMaps;
        if (hashMap != null && hashMap.containsKey(str)) {
            int intValue = this.mEventMaps.get(str).intValue();
            if (intValue == 1) {
                handleRemoveListener(str);
                this.mEventMaps.remove(str);
            } else {
                this.mEventMaps.remove(str);
                this.mEventMaps.put(str, Integer.valueOf(intValue - 1));
            }
        }
    }

    public void destroy() {
    }

    public void initialize() {
    }

    public void handleAddListener(String str) {
    }

    public void handleRemoveListener(String str) {
    }
}
