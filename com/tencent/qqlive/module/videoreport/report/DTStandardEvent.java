package com.tencent.qqlive.module.videoreport.report;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTStandardEvent {
    private static List<String> sEventNames = Arrays.asList(DTEventKey.ORIGIN_VST, DTEventKey.APP_HEARTBEAT, DTEventKey.MONITOR_VIEW_DETECT, DTEventKey.SUBMIT, DTEventKey.SCREEN_DOM, DTEventKey.USER_PRIVACY, DTEventKey.VST, DTEventKey.ACT, DTEventKey.APP_IN, DTEventKey.APP_OUT, "dt_pgin", "dt_pgout", "dt_imp", "dt_imp_end", "dt_clck", DTEventKey.AUDIO_START, DTEventKey.AUDIO_END, DTEventKey.AUDIO_HEARTBEAT, "dt_video_start", "dt_video_end");

    public static boolean isDtStandardEvent(String str) {
        return sEventNames.contains(str);
    }

    public static String removeDTPrefix(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (isDtStandardEvent(str)) {
            return str.substring(3);
        }
        return str;
    }
}
