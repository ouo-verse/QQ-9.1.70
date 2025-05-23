package com.tencent.thumbplayer.common;

import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPPlayerCoreTypeToString {
    private static final HashMap<Integer, String> PLAYER_CORE_NAME_MAP = new HashMap<Integer, String>() { // from class: com.tencent.thumbplayer.common.TPPlayerCoreTypeToString.1
        {
            put(0, "Unknown");
            put(1, "System MediaPlayer");
            put(2, "SelfDev Player");
        }
    };

    public static String getPlayerCoreName(int i3) {
        HashMap<Integer, String> hashMap = PLAYER_CORE_NAME_MAP;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return hashMap.get(Integer.valueOf(i3));
        }
        return "Unknown";
    }
}
