package com.tencent.thumbplayer.common;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPUrlAnalyzer {
    public static final int TP_URL_PROTOCOL_TYPE_FILE = 4;
    public static final int TP_URL_PROTOCOL_TYPE_FTP = 5;
    public static final int TP_URL_PROTOCOL_TYPE_HTTP = 0;
    public static final int TP_URL_PROTOCOL_TYPE_HTTPS = 1;
    public static final int TP_URL_PROTOCOL_TYPE_MMS = 7;
    public static final int TP_URL_PROTOCOL_TYPE_RESOURCELOADER = 8;
    public static final int TP_URL_PROTOCOL_TYPE_RTMP = 2;
    public static final int TP_URL_PROTOCOL_TYPE_RTSP = 6;
    public static final int TP_URL_PROTOCOL_TYPE_UNKNOWN = -1;
    public static final int TP_URL_PROTOCOL_TYPE_WEBRTC = 3;
    private static Map<String, Integer> sPrefixToTypeMap = new HashMap();
    private static Set<Integer> sOnlineVideoPlayerUrlTypeSet = new HashSet();

    @Target({ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPUrlType {
    }

    static {
        sPrefixToTypeMap.put("http://", 0);
        sPrefixToTypeMap.put("https://", 1);
        sPrefixToTypeMap.put("rtmp://", 2);
        sPrefixToTypeMap.put("webrtc://", 3);
        sPrefixToTypeMap.put("ftp://", 5);
        sPrefixToTypeMap.put("rtsp://", 6);
        sPrefixToTypeMap.put("mms://", 7);
        sPrefixToTypeMap.put("file://", 4);
        sPrefixToTypeMap.put("/", 4);
        sPrefixToTypeMap.put("resourceloader://", 8);
        sOnlineVideoPlayerUrlTypeSet.add(0);
        sOnlineVideoPlayerUrlTypeSet.add(1);
        sOnlineVideoPlayerUrlTypeSet.add(2);
        sOnlineVideoPlayerUrlTypeSet.add(3);
        sOnlineVideoPlayerUrlTypeSet.add(5);
        sOnlineVideoPlayerUrlTypeSet.add(6);
        sOnlineVideoPlayerUrlTypeSet.add(7);
    }

    public static int getUrlProtocolType(@Nullable String str) {
        if (str == null) {
            return -1;
        }
        String lowerCase = str.toLowerCase();
        for (Map.Entry<String, Integer> entry : sPrefixToTypeMap.entrySet()) {
            if (lowerCase.startsWith(entry.getKey())) {
                return entry.getValue().intValue();
            }
        }
        return -1;
    }

    public static boolean isOnlineVideoPlayUrl(String str) {
        if (TextUtils.isEmpty(str) || !sOnlineVideoPlayerUrlTypeSet.contains(Integer.valueOf(getUrlProtocolType(str)))) {
            return false;
        }
        return true;
    }
}
