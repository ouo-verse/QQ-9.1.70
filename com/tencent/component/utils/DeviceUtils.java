package com.tencent.component.utils;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DeviceUtils {
    public static final int getCarrier() {
        return ah.i();
    }

    @SuppressLint({"NewApi"})
    public static int getNumberOfCores() {
        return ah.J();
    }

    public static long getSystemTotalMemory() {
        return m.c();
    }
}
