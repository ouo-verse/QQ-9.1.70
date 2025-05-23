package com.tencent.thumbplayer.common;

import com.tencent.raft.codegenmeta.utils.RLog;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPPlayerStateToString {
    private static final HashMap<Integer, String> STATE_NAME_MAP = new HashMap<Integer, String>() { // from class: com.tencent.thumbplayer.common.TPPlayerStateToString.1
        {
            put(0, "IDLE");
            put(1, "INITIALIZED");
            put(2, "PREPARING");
            put(3, "PREPARED");
            put(4, "STARTED");
            put(5, "PAUSED");
            put(6, "COMPLETE");
            put(7, "STOPPING");
            put(8, "STOPPED");
            put(9, RLog.ERROR);
            put(10, "RELEASED");
        }
    };

    public static String getStateName(int i3) {
        HashMap<Integer, String> hashMap = STATE_NAME_MAP;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return hashMap.get(Integer.valueOf(i3));
        }
        return "Unknown";
    }
}
