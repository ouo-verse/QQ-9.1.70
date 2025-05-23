package com.tencent.autotemplate.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import com.tencent.autotemplate.parse.RhythmDataBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MusicConfigUtils {
    static IPatchRedirector $redirector_;

    public MusicConfigUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long getMusicStartTime(String str) {
        String str2;
        List<TAVEffectPoint> list;
        try {
            for (RhythmDataBean.PackedEffectPoints packedEffectPoints : JsonUtils.parseRhythmTemplate(null, str).allData) {
                if (packedEffectPoints != null && (str2 = packedEffectPoints.name) != null && packedEffectPoints.effectPoints != null && TextUtils.equals(str2, TAVRhythmAutomaticTemplate.StartValueTrail) && (list = packedEffectPoints.effectPoints) != null && !list.isEmpty()) {
                    return packedEffectPoints.effectPoints.get(0).getTime();
                }
            }
            return -1L;
        } catch (Exception e16) {
            Log.e("MusicConfigUtils", "getMusicStartTime err:" + e16);
            return -1L;
        }
    }
}
