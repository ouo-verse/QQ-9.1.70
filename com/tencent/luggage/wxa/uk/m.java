package com.tencent.luggage.wxa.uk;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f142758a = new m();

    public static final int a(com.tencent.luggage.wxa.xd.d component) {
        Object obj;
        Intrinsics.checkNotNullParameter(component, "component");
        Context context = component.getContext();
        if (context != null) {
            obj = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } else {
            obj = null;
        }
        ActivityManager activityManager = (ActivityManager) obj;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        long j3 = 1024;
        return (int) ((memoryInfo.totalMem / j3) / j3);
    }
}
