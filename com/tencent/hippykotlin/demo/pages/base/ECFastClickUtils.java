package com.tencent.hippykotlin.demo.pages.base;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECFastClickUtils {
    public static final ECFastClickUtils INSTANCE = new ECFastClickUtils();
    public static final HashMap<String, Long> clickTimeMap = new HashMap<>();

    public static boolean isFastDoubleClick$default(String str) {
        long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        HashMap<String, Long> hashMap = clickTimeMap;
        Long l3 = hashMap.get(str);
        if (l3 != null) {
            if (hashMap.size() > 10) {
                hashMap.clear();
            }
            hashMap.put(str, Long.valueOf(currentTimeStamp));
            return currentTimeStamp - l3.longValue() < 500;
        }
        hashMap.put(str, Long.valueOf(currentTimeStamp));
        return false;
    }
}
