package com.tencent.mobileqq.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class ca {
    public static int a(Context context) {
        return ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass();
    }

    public static boolean b(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception unused) {
            return false;
        }
    }
}
