package com.tencent.gamematrix.gmcg.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface GmCgKeepAliveDeviceState {
    public static final int DeviceBot = 6;
    public static final int DeviceKeepAliveAfterUse = 4;
    public static final int DeviceKeepAliveBeforeUse = 1;
    public static final int DeviceKeepAliveInfiniteAfterUse = 5;
    public static final int DeviceKeepAliveInfiniteBeforeUse = 2;
    public static final int DeviceReleased = 0;
    public static final int DeviceReleasing = 10;
    public static final int DeviceUsing = 3;
}
