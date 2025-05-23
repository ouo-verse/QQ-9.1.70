package com.tencent.ark;

import android.content.Context;
import com.tencent.ark.mmkv.IMMKV;
import com.tencent.ark.mmkv.MMKVManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Utils {
    private static final String SP_SCALE_GESTURE_LEY = "sp_scale_gesture";

    public static <T> boolean isEmpty(List<T> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isScaleGestureLogEnable(Context context) {
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return false;
        }
        return arkMMKV.getBoolean(SP_SCALE_GESTURE_LEY, false);
    }

    public static void setScaleGestureLogEnable(Context context, boolean z16) {
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return;
        }
        arkMMKV.putBoolean(SP_SCALE_GESTURE_LEY, z16);
    }
}
