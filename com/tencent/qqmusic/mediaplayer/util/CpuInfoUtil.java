package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.luggage.wxa.ia.a;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CpuInfoUtil {
    private static final String CUR_CPU_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    private static final String TAG = "CpuInfoUtil";
    private static OutputCpuThread mCurrThread;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class OutputCpuThread extends BaseThread {
        public boolean isStop;

        public OutputCpuThread(String str) {
            super(str);
            this.isStop = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:39:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Process process;
            BufferedReader bufferedReader;
            super.run();
            StringBuilder sb5 = new StringBuilder();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    process = (Process) a.a(Runtime.getRuntime(), new com.tencent.luggage.wxa.ja.a().a("top -m 10 -s cpu -t").a(), "com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil$OutputCpuThread", TencentLocation.RUN_MODE, "()V", "java/lang/Runtime", "exec", "(Ljava/lang/String;)Ljava/lang/Process;");
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        loop0: while (true) {
                            bufferedReader2 = null;
                            int i3 = 0;
                            while (true) {
                                try {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine != null && !this.isStop) {
                                            i3++;
                                            sb5.append(readLine);
                                            sb5.append("\n");
                                            if (i3 > 15) {
                                                try {
                                                    Logger.d(CpuInfoUtil.TAG, sb5.toString());
                                                    sb5.delete(0, sb5.length() - 1);
                                                    LockMethodProxy.sleep(5000L);
                                                    break;
                                                } catch (Exception e16) {
                                                    Logger.e(CpuInfoUtil.TAG, e16);
                                                }
                                            }
                                        } else {
                                            try {
                                                bufferedReader.close();
                                                break loop0;
                                            } catch (IOException e17) {
                                                Logger.e(CpuInfoUtil.TAG, e17);
                                            }
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        bufferedReader2 = bufferedReader;
                                        Logger.e(CpuInfoUtil.TAG, e);
                                        if (bufferedReader2 != null) {
                                            try {
                                                bufferedReader2.close();
                                            } catch (IOException e19) {
                                                Logger.e(CpuInfoUtil.TAG, e19);
                                            }
                                        }
                                        if (process == null) {
                                            return;
                                        }
                                        process.destroy();
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (bufferedReader != null) {
                                    }
                                    if (process != null) {
                                    }
                                }
                            }
                        }
                    } catch (Exception e26) {
                        e = e26;
                    }
                } catch (Exception e27) {
                    e = e27;
                    process = null;
                } catch (Throwable th6) {
                    th = th6;
                    process = null;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    if (process != null) {
                    }
                }
                process.destroy();
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e28) {
                        Logger.e(CpuInfoUtil.TAG, e28);
                    }
                }
                if (process != null) {
                    process.destroy();
                    throw th;
                }
                throw th;
            }
        }
    }

    public static synchronized void startProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
        }
    }

    public static synchronized void stopProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
            mCurrThread = null;
        }
    }

    public static void outputCpuHZToLog() {
    }

    public static void outputThreadInfoToLog() {
    }
}
