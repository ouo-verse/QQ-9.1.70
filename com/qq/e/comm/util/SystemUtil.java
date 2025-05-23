package com.qq.e.comm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class SystemUtil {
    private static final String KEY_ENABLE_GET_PROCESS_NAME = "enable_get_process_name";
    private static String sProcessName = "";

    public static String buildNewPathByProcessName(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        String processName = GDTADManager.getInstance().getProcessName();
        if (!StringUtil.isEmpty(processName)) {
            String str2 = "_";
            boolean endsWith = processName.endsWith("_");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            if (endsWith) {
                str2 = "";
            }
            sb5.append(str2);
            sb5.append(Md5Util.encode(processName));
            return sb5.toString();
        }
        return str;
    }

    public static String getCPUABI() {
        int readElfArch = readElfArch("/proc/" + Process.myTid() + "/exe");
        if (readElfArch == 3 || readElfArch == 40) {
            return "armeabi";
        }
        if (readElfArch == 62 || readElfArch == 183) {
            return "arm64-v8a";
        }
        return "unknown";
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        com.qq.e.comm.util.SystemUtil.sProcessName = r2.processName;
        com.qq.e.comm.util.GDTLogger.e("use system interface: get process name = " + com.qq.e.comm.util.SystemUtil.sProcessName);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String getProcessName(Context context) {
        int myPid;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        synchronized (SystemUtil.class) {
            if (!TextUtils.isEmpty(sProcessName)) {
                GDTLogger.e("use cache: get process name = " + sProcessName);
                return sProcessName;
            }
            SM sm5 = GDTADManager.getInstance().getSM();
            if (sm5 != null && sm5.getInteger(KEY_ENABLE_GET_PROCESS_NAME, 1) != 1) {
                GDTLogger.e("switch off: get process name = " + sProcessName);
                return sProcessName;
            }
            try {
                myPid = Process.myPid();
                runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (it == null || !it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        break;
                    }
                }
                return sProcessName;
            }
            return null;
        }
    }

    private static int readElfArch(String str) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                    try {
                        randomAccessFile2.seek(18L);
                        int read = randomAccessFile2.read();
                        try {
                            randomAccessFile2.close();
                            return read;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            return read;
                        }
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return 0;
                    } catch (IOException e18) {
                        e = e18;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return 0;
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                } catch (IOException e27) {
                    e = e27;
                }
            } catch (IOException e28) {
                e28.printStackTrace();
                return 0;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static synchronized void setProcessName(String str) {
        synchronized (SystemUtil.class) {
            sProcessName = str;
        }
    }
}
