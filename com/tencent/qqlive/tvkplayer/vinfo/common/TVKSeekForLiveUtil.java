package com.tencent.qqlive.tvkplayer.vinfo.common;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSeekForLiveUtil {
    private static final String PLAYBACK_POSITION_PARAM_KEY = "wsStreamTimeABS";
    private static final String PLAYBACK_REQUEST_TIME_PARAM_KEY = "time";
    private static final Pattern PLAYBACK_POSITION_PARAM_PATTERN = Pattern.compile("(?<=[?&]wsStreamTimeABS=)[^&]*");
    private static final Pattern PLAYBACK_REQUEST_TIME_PARAM_PATTERN = Pattern.compile("(?<=[?&]time=)[^&]*");

    public static String generateUrl(String str, long j3, long j16, long j17) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return modifyPlaybackRequestTimeParam(modifyPlaybackPositionParam(str, j16, j17), j3);
    }

    @Nullable
    public static String[] generateUrls(String[] strArr, long j3, long j16, long j17) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr2[i3] = generateUrl(strArr[i3], j3, j16, j17);
        }
        return strArr2;
    }

    private static String modifyPlaybackPositionParam(String str, long j3, long j16) {
        long calculateCurrentServerTimeSec = TVKServerTimeGetter.getInstance().calculateCurrentServerTimeSec();
        String valueOf = String.valueOf(Math.max(Math.min(j3, calculateCurrentServerTimeSec), calculateCurrentServerTimeSec - j16));
        Matcher matcher = PLAYBACK_POSITION_PARAM_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.replaceAll(valueOf);
        }
        return str.replaceFirst("&?$", "&wsStreamTimeABS=" + valueOf);
    }

    private static String modifyPlaybackRequestTimeParam(String str, long j3) {
        if (j3 == 0) {
            return str;
        }
        Matcher matcher = PLAYBACK_REQUEST_TIME_PARAM_PATTERN.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        try {
            return matcher.replaceAll(String.valueOf(Long.parseLong(str.substring(matcher.start(), matcher.end())) + j3));
        } catch (NumberFormatException unused) {
            return str;
        }
    }
}
