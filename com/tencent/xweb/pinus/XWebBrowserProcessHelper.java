package com.tencent.xweb.pinus;

/* loaded from: classes27.dex */
public class XWebBrowserProcessHelper {
    private static BrowserProcessCrashDumpFileCallback sBrowserProcessDumpFileCallback;

    /* loaded from: classes27.dex */
    public interface BrowserProcessCrashDumpFileCallback {
        String getCrashDumpFolderPath();

        String getJavaCrashDumpFilePath(String str);

        String getNativeCrashDumpFilePath(String str);
    }

    public static BrowserProcessCrashDumpFileCallback getCrashDumpFileCallback() {
        return sBrowserProcessDumpFileCallback;
    }

    public static void setCrashDumpFileCallback(BrowserProcessCrashDumpFileCallback browserProcessCrashDumpFileCallback) {
        sBrowserProcessDumpFileCallback = browserProcessCrashDumpFileCallback;
    }
}
