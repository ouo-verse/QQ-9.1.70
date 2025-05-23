package com.tencent.gamematrix.gmcg.webrtc.sdp;

import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SdpHelper {
    public static final String MEDIA_TYPE_APP = "m=application";
    public static final String MEDIA_TYPE_AUDIO = "m=audio";
    public static final String MEDIA_TYPE_VIDEO = "m=video";

    @Nullable
    public static String findIceUfrag(String str, String str2, @Nullable String str3) {
        String[] split = str2.split("\r\n");
        if (split.length == 0) {
            return str3;
        }
        int i3 = -1;
        for (int i16 = 0; i16 < split.length; i16++) {
            if (split[i16].startsWith(str)) {
                i3 = i16;
            }
        }
        if (i3 == -1) {
            return str3;
        }
        Pattern compile = Pattern.compile("^a=ice-ufrag:(\\S+)");
        for (int i17 = i3 + 1; i17 < split.length; i17++) {
            String str4 = split[i17];
            if (str4.startsWith("m=")) {
                break;
            }
            Matcher matcher = compile.matcher(str4);
            if (matcher.matches()) {
                return matcher.group(1);
            }
        }
        return str3;
    }
}
