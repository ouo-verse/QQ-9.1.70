package com.tencent.gamematrix.gmcg.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface GmCgAllocateDeviceState {
    public static final int AllocateDeviceColdStart = 2;
    public static final int AllocateDeviceQueueing = 1;
    public static final int AllocateDeviceReady = 3;
}
