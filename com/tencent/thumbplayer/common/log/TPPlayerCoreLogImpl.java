package com.tencent.thumbplayer.common.log;

import com.tencent.thumbplayer.core.utils.ITPNativeLogCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPPlayerCoreLogImpl implements ITPNativeLogCallback {
    public static final int LEVEL_DEBUG = 3;
    public static final int LEVEL_ENFORCE = -1;
    public static final int LEVEL_ERROR = 0;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 4;
    public static final int LEVEL_WARN = 1;
    private static final HashMap<Integer, Integer> sPlayerCoreLevelToTPLogLevelMap;
    private static final HashMap<Integer, Integer> sTPLogLevelToPlayerCoreLevelMap;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPPlayerCoreLogLevel {
    }

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        sTPLogLevelToPlayerCoreLevelMap = hashMap;
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        sPlayerCoreLevelToTPLogLevelMap = hashMap2;
        hashMap.put(0, 4);
        hashMap.put(1, 3);
        hashMap.put(2, 2);
        hashMap.put(3, 1);
        hashMap.put(4, 0);
        hashMap2.put(4, 0);
        hashMap2.put(3, 1);
        hashMap2.put(2, 2);
        hashMap2.put(1, 3);
        hashMap2.put(0, 4);
        hashMap2.put(-1, 4);
    }

    public static int playerCoreLogLevelToTPLogLevel(int i3) {
        Integer num = sPlayerCoreLevelToTPLogLevelMap.get(Integer.valueOf(i3));
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    public static int tpLogLevelToPlayerCoreLogLevel(int i3) {
        Integer num = sTPLogLevelToPlayerCoreLevelMap.get(Integer.valueOf(i3));
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    @Override // com.tencent.thumbplayer.core.utils.ITPNativeLogCallback
    public void onPrintLog(int i3, String str, String str2) {
        TPLogUtil.print(playerCoreLogLevelToTPLogLevel(i3), str, str2);
    }
}
