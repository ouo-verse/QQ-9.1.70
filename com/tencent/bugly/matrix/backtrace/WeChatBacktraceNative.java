package com.tencent.bugly.matrix.backtrace;

import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes5.dex */
public class WeChatBacktraceNative {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native String[] consumeRequestedQut();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native void enableLogger(boolean z16);

    @Keep
    static native void immediateGeneration(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native void notifyWarmedUp(String str, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native void setBacktraceMode(int i3);

    @Keep
    static native void setPackageName(String str);

    @Keep
    static native void setQuickenAlwaysOn(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native void setSavingPath(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native void setWarmedUp(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native int[] statistic(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native boolean testLoadQut(String str, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public static native boolean warmUp(String str, int i3, boolean z16);

    @Keep
    static void requestQutGenerate() {
    }
}
