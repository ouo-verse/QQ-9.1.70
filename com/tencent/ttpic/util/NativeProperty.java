package com.tencent.ttpic.util;

import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes27.dex */
public class NativeProperty {
    private static final int ARM_FEATURE_ARMv7 = 1;
    private static final int ARM_FEATURE_NEON = 4;
    private static final int FAMILY_ARM = 1;
    private static final int FAMILY_ARM64 = 4;
    private static String cpuABI = "";
    private static int cpuFamily = 1;
    private static int cpuFeature;

    public static int cpuFeature() {
        return cpuFeature;
    }

    public static String getCpuABI() {
        return cpuABI;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "getprop " + str).getInputStream()), 1024);
        } catch (IOException e16) {
            e = e16;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        try {
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e17) {
                    LogUtils.e(e17);
                }
                return readLine;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e18) {
                        LogUtils.e(e18);
                    }
                }
                throw th;
            }
        } catch (IOException e19) {
            e = e19;
            LogUtils.e(e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e26) {
                    LogUtils.e(e26);
                }
            }
            return null;
        }
    }

    public static boolean hasNeonFeature() {
        if (1 == cpuFamily && (cpuFeature & 4) != 0) {
            return true;
        }
        return false;
    }

    public static void init() {
        String systemProperty = getSystemProperty(TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI);
        cpuABI = systemProperty;
        if (systemProperty != null && !systemProperty.equals(ResourceAttributes.HostArchValues.X86)) {
            try {
                cpuFeature = nGetCpuInfo();
                return;
            } catch (UnsatisfiedLinkError e16) {
                LogUtils.e(e16);
                ReportUtil.report("NativeProperty init error! " + e16);
                return;
            }
        }
        cpuFeature = 5;
    }

    private static native int nGetCpuInfo();
}
