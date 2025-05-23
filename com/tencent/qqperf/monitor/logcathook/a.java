package com.tencent.qqperf.monitor.logcathook;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static String f363261a = "";

    /* renamed from: b, reason: collision with root package name */
    static b f363262b;

    /* renamed from: c, reason: collision with root package name */
    static SimpleDateFormat f363263c = new SimpleDateFormat("yy.MM.dd.HH");

    /* renamed from: d, reason: collision with root package name */
    static SimpleDateFormat f363264d = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f363265e = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, DeviceInfoUtil.PERMISSION_READ_PHONE};

    /* renamed from: f, reason: collision with root package name */
    private static String f363266f = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f363267g = "com.tencent.mobileqq";

    /* renamed from: h, reason: collision with root package name */
    private static BufferedWriter f363268h = null;

    /* renamed from: i, reason: collision with root package name */
    private static String f363269i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.monitor.logcathook.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C9711a implements Comparable<C9711a> {

        /* renamed from: d, reason: collision with root package name */
        long f363270d;

        /* renamed from: e, reason: collision with root package name */
        long f363271e;

        /* renamed from: f, reason: collision with root package name */
        String f363272f;

        public C9711a(long j3, long j16, String str) {
            this.f363270d = j3;
            this.f363271e = j16;
            this.f363272f = str;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(C9711a c9711a) {
            long i3 = this.f363270d - c9711a.i();
            if (0 == i3) {
                return -((int) (this.f363271e - c9711a.j()));
            }
            return (int) i3;
        }

        public String h() {
            return this.f363272f;
        }

        public long i() {
            return this.f363270d;
        }

        public long j() {
            return this.f363271e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    try {
                        if (MobileQQ.sProcessId == 1) {
                            a.a(System.currentTimeMillis());
                            a.f363262b.removeMessages(2);
                            a.f363262b.sendEmptyMessageDelayed(2, MiniBoxNoticeInfo.MIN_5);
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                a.e(System.currentTimeMillis());
                a.f363262b.removeMessages(1);
                a.f363262b.sendEmptyMessageDelayed(1, MiniBoxNoticeInfo.MIN_5);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(QLog.getLogExternalPath(BaseApplication.context));
        String str = File.separator;
        sb5.append(str);
        sb5.append("tencent");
        sb5.append(str);
        sb5.append("msflogs");
        sb5.append(str);
        sb5.append(f363267g.replace(".", str));
        sb5.append(str);
        f363269i = sb5.toString();
    }

    static void a(long j3) throws IOException {
        File file = new File(f363269i);
        ArrayList arrayList = new ArrayList();
        long j16 = 0;
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.isFile() && file2.getName().contains("syslog")) {
                    if (j3 - file2.lastModified() > 86400000) {
                        file2.delete();
                    } else {
                        arrayList.add(new C9711a(file2.lastModified(), file2.length(), file2.getPath()));
                        j16 += file2.length();
                    }
                }
            }
        }
        if (j16 > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            Collections.sort(arrayList);
            while (j16 > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                File file3 = new File(((C9711a) arrayList.remove(0)).h());
                j16 -= file3.length();
                if (file3.exists()) {
                    file3.delete();
                }
            }
        }
    }

    public static String b() {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        String str = f363269i + c(f363263c.format(calendar.getTime()));
        try {
            File file = new File(f363269i);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        Log.e(LogcatHook.TAG, "getDefaultLogFilePath logFilePath " + str);
        return str;
    }

    public static String c(String str) {
        return f363266f.replace(":", "_") + "_syslog_." + str + ".log";
    }

    public static void d(String str, String str2, String str3, long j3) {
        if (f363262b == null) {
            f363266f = str2;
            f363267g = str;
            f363261a = str3;
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("sysLogWriteThread");
            baseHandlerThread.start();
            b bVar = new b(baseHandlerThread.getLooper());
            f363262b = bVar;
            bVar.sendEmptyMessageDelayed(1, j3);
            if (MobileQQ.sProcessId == 1) {
                f363262b.sendEmptyMessageDelayed(2, j3);
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    static void e(long j3) throws IOException {
        StringBuilder sb5;
        String format = f363264d.format(Long.valueOf(j3));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        String str = f363269i + c(f363263c.format(calendar.getTime()));
        try {
            File file = new File(f363269i);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
            f363268h = bufferedWriter;
            bufferedWriter.write(format + "|" + f363266f + "|D||QQ_Version: " + f363261a + "\r\n");
            f363268h.write(format + "|" + f363266f + "|D|LogcatHookThread|" + DeviceInfoMonitor.getModel() + " " + Build.VERSION.RELEASE + " create newLogFile " + file2.getName() + " \n");
            f363268h.flush();
            BufferedWriter bufferedWriter2 = f363268h;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
                f363268h = null;
            }
            sb5 = new StringBuilder();
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                Log.e(LogcatHook.TAG, "initLogFile has exception", th5);
                BufferedWriter bufferedWriter3 = f363268h;
                if (bufferedWriter3 != null) {
                    bufferedWriter3.close();
                    f363268h = null;
                }
                sb5 = new StringBuilder();
            } catch (Throwable th6) {
                BufferedWriter bufferedWriter4 = f363268h;
                if (bufferedWriter4 != null) {
                    bufferedWriter4.close();
                    f363268h = null;
                }
                Log.e(LogcatHook.TAG, "initLogFile end logFilePath " + str);
                throw th6;
            }
        }
        sb5.append("initLogFile end logFilePath ");
        sb5.append(str);
        Log.e(LogcatHook.TAG, sb5.toString());
        if (LogcatHook.sLogcatHooked.get()) {
            LogcatHook.updateLogPath(str);
        }
    }
}
