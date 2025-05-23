package com.tencent.ams.dsdk.core.hippy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.utils.DLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKEngineInstanceManager {
    private static final String TAG = "DKEngineInstanceManager";
    private static Map<Integer, DKEngine> mEngines = new ConcurrentHashMap();

    public static void addEngine(@NonNull DKEngine dKEngine) {
        mEngines.put(Integer.valueOf(dKEngine.getEngineId()), dKEngine);
        DLog.d(TAG, "addEngine " + mEngines.size());
    }

    @Nullable
    public static DKEngine getEngine(int i3) {
        return mEngines.get(Integer.valueOf(i3));
    }

    @NonNull
    public static Map<Integer, DKEngine> getEngines() {
        return mEngines;
    }

    public static void removeEngine(@NonNull DKEngine dKEngine) {
        boolean z16;
        if (mEngines.remove(Integer.valueOf(dKEngine.getEngineId())) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        DLog.d(TAG, "removeEngine " + z16 + mEngines.size());
    }
}
