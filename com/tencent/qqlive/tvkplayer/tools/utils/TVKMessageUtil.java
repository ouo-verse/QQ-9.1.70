package com.tencent.qqlive.tvkplayer.tools.utils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKMessageUtil {
    private static final String TAG = "TVKMessageUtil";
    private static final String UNKNOWN_MESSAGE_NAME = "UNKNOWN";
    private static final Map<String, String> sMessageNameCache = new ConcurrentHashMap();

    private static String generateMessageKey(Class<?> cls, int i3) {
        return cls.getName() + "-" + i3;
    }

    public static String getMessageName(Class<?> cls, int i3) {
        String generateMessageKey = generateMessageKey(cls, i3);
        String str = sMessageNameCache.get(generateMessageKey);
        if (str != null) {
            return str;
        }
        Field[] fieldArr = new Field[0];
        try {
            fieldArr = cls.getDeclaredFields();
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16, "[getMessageName] failed to get declared fields:");
        }
        for (Field field : fieldArr) {
            try {
                if (Integer.TYPE.equals(field.getType())) {
                    field.setAccessible(true);
                    sMessageNameCache.put(generateMessageKey(cls, field.getInt(cls)), field.getName());
                }
            } catch (Throwable th5) {
                TVKLogUtil.e(TAG, th5, "[getMessageName] failed to get message name:");
            }
        }
        String str2 = sMessageNameCache.get(generateMessageKey);
        if (str2 == null) {
            return "UNKNOWN-" + i3;
        }
        return str2;
    }
}
