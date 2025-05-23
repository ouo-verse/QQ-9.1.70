package com.tencent.mobileqq.monitor;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface MsfMonitorCallback {
    public static final int THREAD_TYPE_LIGHT_SENDER = 3;
    public static final int THREAD_TYPE_NET = 4;
    public static final int THREAD_TYPE_RECEIVER = 2;
    public static final int THREAD_TYPE_SENDER = 1;

    boolean handleEnd(int i3);

    boolean handleStart(int i3);
}
