package com.tencent.xweb;

import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebCrashMonitor {
    public static final String TAG = "XWebCrashMonitor";

    public static boolean a(File file) {
        Throwable th5;
        BufferedReader bufferedReader;
        String readLine;
        if (!file.getName().contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_GPU)) {
            return false;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (Throwable th6) {
            th5 = th6;
            bufferedReader = null;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (Throwable th7) {
                th5 = th7;
                try {
                    x0.a(TAG, "checkGpuUnusableCrash, filePath:" + file.getAbsolutePath() + ", error", th5);
                    return false;
                } finally {
                    w.a(bufferedReader);
                }
            }
            if (readLine == null) {
                return false;
            }
            if (readLine.contains("com.godinsec.godinsec_private_space")) {
                break;
            }
        } while (!readLine.contains("com.kuihua.wxsk"));
        x0.d(TAG, "checkGpuUnusableCrash, command:" + CommandCfg.getInstance().getWxdkDowngrade());
        XWebChildProcessMonitor.setMaybeWxdk(true);
        XWebChildProcessMonitor.recordChildProcessCrash("GpuUnusable");
        return true;
    }

    public static boolean b(File file) {
        Throwable th5;
        BufferedReader bufferedReader;
        String readLine;
        if (!file.getName().contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX) && !file.getName().contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_RENDER_UNSANDBOX)) {
            return false;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (Throwable th6) {
            th5 = th6;
            bufferedReader = null;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (Throwable th7) {
                th5 = th7;
                try {
                    x0.a(TAG, "checkRenderOffset4000Crash, filePath:" + file.getAbsolutePath() + ", error", th5);
                    return false;
                } finally {
                    w.a(bufferedReader);
                }
            }
            if (readLine == null) {
                return false;
            }
        } while (!readLine.endsWith("libxwebcore.so (offset 0x4000)"));
        x0.d(TAG, "checkRenderOffset4000Crash, command:" + CommandCfg.getInstance().getWxdkDowngrade());
        XWebChildProcessMonitor.setMaybeWxdk(true);
        XWebChildProcessMonitor.recordChildProcessCrash("RenderOffset");
        return true;
    }

    public static boolean isXWebChildProcessCrashDumpFiles(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (!file.getName().contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX) && !file.getName().contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_GPU) && !file.getName().contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_RENDER_UNSANDBOX)) {
            return false;
        }
        return true;
    }

    public static void onReportXWebCrash(File file) {
        if (isXWebChildProcessCrashDumpFiles(file)) {
            if (b(file)) {
                x0.d(TAG, "onReportXWebCrash, is RenderOffset4000Crash");
            } else if (a(file)) {
                x0.d(TAG, "onReportXWebCrash, is GpuUnusableCrash");
            } else {
                x0.d(TAG, "onReportXWebCrash, increase crash count");
                XWebChildProcessMonitor.increaseCrashCount();
            }
        }
    }
}
