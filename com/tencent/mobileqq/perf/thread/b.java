package com.tencent.mobileqq.perf.thread;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Thread;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f258085a;

    /* renamed from: b, reason: collision with root package name */
    private static a f258086b;

    /* renamed from: c, reason: collision with root package name */
    private static long f258087c;

    /* renamed from: d, reason: collision with root package name */
    private static String f258088d;

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<Long, String> f258089e;

    /* renamed from: f, reason: collision with root package name */
    private static Object f258090f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class a extends FileObserver {
        static IPatchRedirector $redirector_;

        public a(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        @Override // android.os.FileObserver
        public void onEvent(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e("[TM]ThreadTraceHelpere", 1, "dumpTraces onEvent " + str);
            synchronized (b.f258086b) {
                notifyAll();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258085a = null;
        f258086b = new a("/data/anr/traces.txt", 8);
        f258087c = -1L;
        f258088d = null;
        f258089e = new HashMap<>(30);
        f258090f = new Object();
    }

    public static void c(long j3, String str) {
        synchronized (f258090f) {
            f258089e.put(Long.valueOf(j3), str);
        }
    }

    private static void d(StringBuilder sb5, Thread thread) {
        sb5.append("Name:");
        sb5.append(thread.getName());
        sb5.append("\r\n");
        sb5.append("State:" + thread.getState());
        sb5.append("\r\n");
        sb5.append("Tid:" + thread.getId());
        sb5.append("\r\n");
        if (thread.isAlive()) {
            for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                sb5.append(stackTraceElement.toString());
                sb5.append("\r\n");
            }
            sb5.append("\r\n");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean e(File file, long j3, long j16, File file2, String str) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (file.isFile()) {
            FileOutputStream fileOutputStream2 = null;
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                }
            } catch (IOException e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
            }
            try {
                if (fileInputStream.available() > j3) {
                    fileInputStream.skip(j3);
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (str != null) {
                    fileOutputStream.write("\r\n".getBytes());
                    fileOutputStream.write(str.getBytes());
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    return true;
                }
            } catch (IOException e18) {
                e = e18;
                fileOutputStream2 = fileOutputStream;
                try {
                    e.printStackTrace();
                    try {
                        file2.delete();
                    } catch (Exception unused3) {
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    return false;
                } catch (Throwable th7) {
                    th = th7;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (fileInputStream == null) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (IOException unused7) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                if (fileInputStream == null) {
                }
            }
        } else {
            return true;
        }
    }

    public static boolean f(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("[TM]ThreadTraceHelpere", 2, "dumpAllJavaStacks, fileName = " + str);
        }
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    int activeCount = Thread.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    Thread.enumerate(threadArr);
                    for (int i3 = 0; i3 < activeCount; i3++) {
                        Thread thread = threadArr[i3];
                        if (thread != null) {
                            fileOutputStream2.write("Name:".getBytes());
                            fileOutputStream2.write(thread.getName().getBytes());
                            fileOutputStream2.write("\r\n".getBytes());
                            fileOutputStream2.write(("State:" + thread.getState()).getBytes());
                            fileOutputStream2.write("\r\n".getBytes());
                            fileOutputStream2.write(("Tid:" + thread.getId()).getBytes());
                            fileOutputStream2.write("\r\n".getBytes());
                            if (thread.isAlive()) {
                                for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                                    fileOutputStream2.write(stackTraceElement.toString().getBytes());
                                    fileOutputStream2.write("\r\n".getBytes());
                                }
                                fileOutputStream2.write("\r\n".getBytes());
                            }
                        }
                    }
                    fileOutputStream2.write("\r\n".getBytes());
                    fileOutputStream2.write(str2.getBytes());
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException unused) {
                        return true;
                    }
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.d("[TM]ThreadTraceHelpere", 2, "dumpJavaStacks failed.", e);
                    }
                    try {
                        file.delete();
                    } catch (Exception unused2) {
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static String g() {
        if (QLog.isColorLevel()) {
            QLog.d("[TM]ThreadTraceHelpere", 2, "dumpBlockOrWaitStacks");
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\r\n");
        int activeCount = Thread.activeCount();
        Thread[] threadArr = new Thread[activeCount];
        Thread.enumerate(threadArr);
        for (int i3 = 0; i3 < activeCount; i3++) {
            Thread thread = threadArr[i3];
            if (thread != null && n(thread)) {
                d(sb5, thread);
            }
        }
        sb5.append("\r\n");
        return sb5.toString();
    }

    public static synchronized int h(String str) {
        synchronized (b.class) {
            if (AppSetting.isPublicVersion()) {
                return 3;
            }
            if (Build.VERSION.SDK_INT >= 35) {
                return 3;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            p();
            File file = new File(f258085a + "msftrace/");
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean threadDumpTraceFile = NativeMemoryMonitor.getInstance().threadDumpTraceFile(new File(str).getAbsolutePath());
            int i3 = 1;
            QLog.d("[TM]ThreadTraceHelpere", 1, "dumpThreadTraceFile. cost:" + (SystemClock.uptimeMillis() - uptimeMillis) + " result:" + threadDumpTraceFile);
            if (!threadDumpTraceFile) {
                i3 = 6;
            }
            return i3;
        }
    }

    public static synchronized int i(Context context, String str, String str2) {
        int i3;
        synchronized (b.class) {
            p();
            File file = new File(f258085a + "msftrace/");
            if (!file.exists()) {
                file.mkdirs();
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("unified_monitor", 0);
            int i16 = sharedPreferences.getInt("key_crash_count", 0);
            if (sharedPreferences.contains("key_dumping")) {
                sharedPreferences.edit().remove("key_dumping");
                i16++;
                sharedPreferences.edit().putInt("key_crash_count", i16);
                sharedPreferences.edit().commit();
            }
            int i17 = 1;
            if (i16 >= 3) {
                QLog.e("[TM]ThreadTraceHelpere", 1, "dumpTraces crash protect");
                return 2;
            }
            File file2 = new File("/data/anr/traces.txt");
            long length = file2.length();
            if (file2.exists() && file2.canRead() && length != 0) {
                sharedPreferences.edit().putBoolean("key_dumping", true).commit();
                f258086b.startWatching();
                long uptimeMillis = SystemClock.uptimeMillis();
                QLog.e("[TM]ThreadTraceHelpere", 1, "dumpTraces send signal");
                Process.sendSignal(Process.myPid(), 3);
                try {
                    synchronized (f258086b) {
                        f258086b.wait(20000L);
                    }
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                f258086b.stopWatching();
                sharedPreferences.edit().remove("key_dumping").putInt("key_crash_count", 0).commit();
                QLog.d("[TM]ThreadTraceHelpere", 1, "dumpTraces wait traces for " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
                long length2 = file2.length();
                if (length2 > length) {
                    long j3 = length2 - length;
                    if (j3 <= 409600) {
                        boolean e17 = e(file2, length, j3, new File(str), str2);
                        QLog.e("[TM]ThreadTraceHelpere", 1, "dumpTraces result = " + e17);
                        if (!e17) {
                            i17 = 6;
                        }
                        return i17;
                    }
                }
                QLog.e("[TM]ThreadTraceHelpere", 1, "dumpTraces bad size " + length + ", " + length2);
                if (length2 <= length) {
                    i3 = 4;
                } else {
                    i3 = 5;
                }
                return i3;
            }
            QLog.e("[TM]ThreadTraceHelpere", 1, "dumpTraces no permission read file, exist = ", Boolean.valueOf(file2.exists()), ", len = " + length);
            return 3;
        }
    }

    public static String j(String str) {
        p();
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append(f258085a);
        if (4 == MobileQQ.sProcessId) {
            sb5.append("msftrace/");
        }
        sb5.append("traces_");
        sb5.append(System.currentTimeMillis());
        sb5.append("_");
        sb5.append(str);
        sb5.append(".txt");
        return sb5.toString();
    }

    public static String k() {
        int i3 = MobileQQ.sProcessId;
        if (1 == i3) {
            return "|process=QQ";
        }
        if (4 == i3) {
            return "|process=MSF";
        }
        if (2 == i3) {
            return "|process=qzone";
        }
        return "|process=other";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QQ_SUB state=");
        sb5.append(ThreadManagerV2.getSubThread().getState());
        sb5.append("\n");
        StackTraceElement[] stackTrace = ThreadManagerV2.getSubThread().getStackTrace();
        if (stackTrace != null && stackTrace.length != 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb5.append(MessageFormat.format("{0}.{1}() {2}", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
                sb5.append("\n");
            }
            return sb5.toString();
        }
        sb5.append("no stack catch");
        return sb5.toString();
    }

    public static String m() {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("|transTid=");
        sb5.append(f258087c);
        sb5.append("|transTname=");
        sb5.append(f258088d);
        sb5.append("|transWaiting=");
        synchronized (f258090f) {
            for (Map.Entry<Long, String> entry : f258089e.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(",");
                sb5.append(entry.getValue());
                sb5.append(";");
            }
        }
        return sb5.toString();
    }

    private static boolean n(Thread thread) {
        Thread.State state = thread.getState();
        if (!Thread.State.BLOCKED.equals(state) && !Thread.State.TIMED_WAITING.equals(state) && !Thread.State.WAITING.equals(state)) {
            return false;
        }
        return true;
    }

    public static void o(long j3) {
        synchronized (f258090f) {
            f258089e.remove(Long.valueOf(j3));
        }
    }

    private static void p() {
        if (TextUtils.isEmpty(f258085a)) {
            try {
                f258085a = VFSAssistantUtils.getSDKPrivatePath(BaseApplication.getContext().getExternalCacheDir().getPath() + "/tencent/msflogs/" + MobileQQ.PACKAGE_NAME.replace(".", "/") + "/");
            } catch (Exception unused) {
                f258085a = VFSAssistantUtils.getSDKPrivatePath(BaseApplication.getContext().getExternalCacheDir().getPath() + MobileQQ.PACKAGE_NAME.replace(".", "/") + "/");
            }
        }
    }

    public static void q(long j3, String str) {
        f258087c = j3;
        f258088d = str;
    }
}
