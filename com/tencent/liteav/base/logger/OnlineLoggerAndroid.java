package com.tencent.liteav.base.logger;

import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class OnlineLoggerAndroid {
    private static final int INVALID_INSTANCE = -1;
    private long mNativeOnlineLoggerAndroid;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        kTRTC(0),
        kLive(1),
        kVod(2);

        int value;

        a(int i3) {
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum b {
        kApi(1),
        kInfo(2),
        kWarning(3),
        kError(4);

        int level;

        b(int i3) {
            this.level = i3;
        }
    }

    public OnlineLoggerAndroid(a aVar, int i3, String str, String str2) {
        this.mNativeOnlineLoggerAndroid = -1L;
        this.mNativeOnlineLoggerAndroid = nativeCreate(aVar.value, i3, str, str2);
    }

    private static native long nativeCreate(int i3, int i16, String str, String str2);

    private static native void nativeDestroy(long j3);

    private static native void nativeLog(long j3, int i3, String str);

    public synchronized void destroy() {
        long j3 = this.mNativeOnlineLoggerAndroid;
        if (j3 == -1) {
            return;
        }
        nativeDestroy(j3);
        this.mNativeOnlineLoggerAndroid = -1L;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public synchronized void log(b bVar, String str) {
        long j3 = this.mNativeOnlineLoggerAndroid;
        if (j3 == -1) {
            return;
        }
        nativeLog(j3, bVar.level, str);
    }
}
