package com.tencent.ark;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkDispatchQueue {
    public static native void asyncRun(Runnable runnable);

    public static native void asyncRun(String str, Runnable runnable);

    public static native void asyncRun(String str, Runnable runnable, long j3);

    public static native String getCurrentQueueKey();

    public static native void setDefaultAttribute(int i3);

    public static native void syncRun(String str, Runnable runnable);
}
