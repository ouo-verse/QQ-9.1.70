package com.tencent.ark;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkDebugger {
    public static final int ERROR_CODE_LISTENNING_TIMEOUT = 1;
    public static final int ERROR_CODE_OK = 0;
    public static final int ERROR_CODE_STOP_ESTABLISHED = 3;
    public static final int ERROR_CODE_STOP_LISTENNING = 2;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DebuggerCallback {
        void Accepted();

        boolean ReadyToRun(String str, String str2, String str3, String str4);

        void ReceivedPackage(String str, String str2);

        void Stopped(int i3);
    }

    public static final native boolean Create();

    public static final native boolean Destroy();

    public static final native boolean Listen(String str, long j3, long j16, String str2);

    public static final native boolean SetCallback(DebuggerCallback debuggerCallback);

    public static final native boolean SetJSLibraryPath(String str, String str2);

    public static final native boolean Stop();
}
