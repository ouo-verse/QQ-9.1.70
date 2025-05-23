package com.tencent.qqlive.module.videoreport.staging;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StashKeyExtractor {
    static final Set<String> AUDIO_KEY_SET;
    static final Set<String> VIDEO_KEY_SET;

    static {
        HashSet hashSet = new HashSet();
        VIDEO_KEY_SET = hashSet;
        HashSet hashSet2 = new HashSet();
        AUDIO_KEY_SET = hashSet2;
        hashSet.add("dt_video_start");
        hashSet.add("dt_video_end");
        hashSet2.add(DTEventKey.AUDIO_END);
    }

    StashKeyExtractor() {
    }

    public static String getStashKey(String str, Map<String, Object> map) {
        if (VIDEO_KEY_SET.contains(str)) {
            return str + "_" + ((String) map.get(DTParamKey.REPORT_KEY_VIDEO_CONTENT_TYPE)) + "_" + ((String) map.get(DTParamKey.REPORT_KEY_VIDEO_CONTENTID));
        }
        if (AUDIO_KEY_SET.contains(str)) {
            return str + "_" + ((String) map.get(DTParamKey.REPORT_KEY_AUDIO_CONTENTID));
        }
        return null;
    }
}
