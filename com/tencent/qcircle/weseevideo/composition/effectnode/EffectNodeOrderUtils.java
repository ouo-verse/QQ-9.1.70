package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EffectNodeOrderUtils {
    private static HashMap<String, Integer> mDefaultOrderConfig;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        mDefaultOrderConfig = hashMap;
        hashMap.put(LightVideoRenderNote.class.getSimpleName(), 0);
    }

    public static HashMap<String, Integer> getDefaultOrderConfig() {
        return mDefaultOrderConfig;
    }

    @NotNull
    public static HashMap<String, Integer> getOrderConfigByScene(int i3) {
        return getDefaultOrderConfig();
    }

    public static boolean shouldSeek(CMTime cMTime, long j3) {
        long abs = Math.abs(cMTime.getTimeUs() - j3);
        if (abs > 0 && abs < 1000000) {
            return false;
        }
        return true;
    }
}
