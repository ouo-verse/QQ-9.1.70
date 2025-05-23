package com.tencent.mobileqq.vas.pendant;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes20.dex */
public class AvatarPendantRecordHelper {
    public static ConcurrentHashMap<Long, Integer> sPendantType = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Long, Integer> sPendantDiyType = new ConcurrentHashMap<>();
    private static long sLastRequestTime = -1;
    public static final ArrayList<String> BULK_PULL_LIST = new ArrayList<>();
    public static volatile boolean sHasSendDelayMsg = false;

    public static long getLastRequestTime() {
        return sLastRequestTime;
    }

    public static void setLastRequestTime(long j3) {
        sLastRequestTime = j3;
    }
}
