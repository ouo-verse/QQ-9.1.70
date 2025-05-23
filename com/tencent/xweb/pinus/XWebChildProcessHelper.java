package com.tencent.xweb.pinus;

import android.os.ParcelFileDescriptor;

/* loaded from: classes27.dex */
public class XWebChildProcessHelper {
    private static ChildProcessCrashDumpFileCallback sChildProcessDumpFileCallback;

    /* loaded from: classes27.dex */
    public interface ChildProcessCrashDumpFileCallback {
        void setupChildProcessCrashDumpFiles(String str, String str2);

        void setupIsolatedProcessCrashDumpFiles(ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2);
    }

    public static ChildProcessCrashDumpFileCallback getCrashDumpFileCallback() {
        return sChildProcessDumpFileCallback;
    }

    public static void setCrashDumpFileCallback(ChildProcessCrashDumpFileCallback childProcessCrashDumpFileCallback) {
        sChildProcessDumpFileCallback = childProcessCrashDumpFileCallback;
    }
}
