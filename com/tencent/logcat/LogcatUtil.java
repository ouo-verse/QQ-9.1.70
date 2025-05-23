package com.tencent.logcat;

import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.thread.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LogcatUtil implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String f119956f;

    /* renamed from: h, reason: collision with root package name */
    private static final String f119957h;

    /* renamed from: i, reason: collision with root package name */
    private static LogcatUtil f119958i;

    /* renamed from: d, reason: collision with root package name */
    LogcatThread f119959d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f119960e;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class LogcatThread extends BaseThread {
        static IPatchRedirector $redirector_;
        Process C;
        Process D;

        public LogcatThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                String format = new SimpleDateFormat("MM-dd-HH").format(new Date());
                File file = new File(LogcatUtil.f119956f);
                if (!file.exists()) {
                    file.mkdirs();
                } else {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            file2.delete();
                        }
                    }
                }
                File file3 = new File(file, format + ".log");
                QLog.d("LogcatUtil", 1, "logcat path :" + file3.getAbsolutePath());
                ArrayList arrayList = new ArrayList();
                arrayList.add("logcat");
                arrayList.add("-f");
                arrayList.add(file3.getAbsolutePath());
                arrayList.add("-v");
                arrayList.add(PerfTracer.THREADTIME_TAG);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("logcat");
                arrayList2.add(LogCmdOptions.CLEAR);
                Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                this.D = exec;
                exec.waitFor();
                Process exec2 = RuntimeMonitor.exec(Runtime.getRuntime(), (String[]) arrayList.toArray(new String[arrayList.size()]));
                this.C = exec2;
                exec2.waitFor();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66513);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f119956f = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/log/logcat";
        f119957h = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/private";
        f119958i = new LogcatUtil();
    }

    LogcatUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f119960e = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        }
    }

    public static void b(String str) {
        LogcatUtil logcatUtil;
        if (QLog.isColorLevel() && (logcatUtil = f119958i) != null && logcatUtil.f(str)) {
            f119958i.c(str);
        }
    }

    private void c(String str) {
        if (str.equals("$logcat start")) {
            this.f119960e.sendEmptyMessage(1);
            return;
        }
        if (str.equals("$logcat stop")) {
            this.f119960e.sendEmptyMessage(2);
            return;
        }
        if (str.equals("$list private files")) {
            this.f119960e.sendEmptyMessage(3);
            return;
        }
        if (str.startsWith("$get private file ")) {
            String substring = str.substring(18);
            QLog.d("LogcatUtil", 1, "private fileName :" + substring);
            Message obtain = Message.obtain();
            obtain.obj = substring;
            obtain.what = 4;
            this.f119960e.sendMessage(obtain);
            return;
        }
        if (str.equals("$get trace file")) {
            this.f119960e.sendEmptyMessage(5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0137 -> B:28:0x013a). Please report as a decompilation issue!!! */
    private void d(String str) {
        FileOutputStream fileOutputStream;
        String str2;
        File file;
        FileInputStream fileInputStream = null;
        fileInputStream = null;
        fileInputStream = null;
        fileInputStream = null;
        fileInputStream = null;
        try {
            try {
                try {
                    String str3 = File.separator;
                    if (str.contains(str3)) {
                        str.substring(0, str.lastIndexOf(str3));
                        str2 = str.substring(str.lastIndexOf(str3) + 1);
                    } else {
                        str2 = str;
                    }
                    File parentFile = BaseApplication.getContext().getFilesDir().getParentFile();
                    QLog.d("LogcatUtil", 1, "private tatgetRoot :" + parentFile.getAbsolutePath());
                    file = new File(parentFile, str);
                    QLog.d("LogcatUtil", 1, "private targetFile path :" + file.getAbsolutePath());
                } catch (FileNotFoundException e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
                fileInputStream = fileInputStream;
            }
            if (file.length() > SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
                QLog.d("LogcatUtil", 1, "private targetFile length > 100M");
                return;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                QLog.d("LogcatUtil", 1, "private targetFile available :" + fileInputStream2.available());
                File file2 = new File(f119957h);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            file3.delete();
                        }
                    }
                }
                fileOutputStream = new FileOutputStream(new File(file2, str2));
            } catch (FileNotFoundException e19) {
                fileInputStream = fileInputStream2;
                e = e19;
                fileOutputStream = null;
            } catch (IOException e26) {
                fileInputStream = fileInputStream2;
                e = e26;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                fileInputStream2.close();
                fileOutputStream.close();
                ?? r36 = "copy normal end";
                QLog.d("LogcatUtil", 1, "copy normal end");
                try {
                    fileInputStream2.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
                fileOutputStream.close();
                fileInputStream = r36;
            } catch (FileNotFoundException e28) {
                fileInputStream = fileInputStream2;
                e = e28;
                QLog.e("LogcatUtil", 1, "copy unnormal end\n", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    fileInputStream = fileInputStream;
                }
            } catch (IOException e36) {
                fileInputStream = fileInputStream2;
                e = e36;
                QLog.e("LogcatUtil", 1, "copy unnormal end\n", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e37) {
                        e37.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    fileInputStream = fileInputStream;
                }
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = fileInputStream2;
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e38) {
                        e38.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException e39) {
                        e39.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private static void e() {
        String str;
        boolean z16;
        boolean z17;
        QLog.e("LogcatUtil", 1, "get trace file begin");
        String j3 = b.j(String.valueOf(100));
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("AdditionInfo:0|");
        try {
            BaseApplicationImpl.getApplication().getPackageManager();
            str = ((QQAppInterface) BaseApplicationImpl.getApplication().waitAppRuntime(null)).getAccount();
        } catch (Exception e16) {
            QLog.e("LogcatUtil", 1, "Exeption ", e16);
            str = "";
        }
        sb5.append(str);
        sb5.append("|");
        sb5.append("");
        sb5.append("|");
        sb5.append("|");
        sb5.append("pub");
        sb5.append("|");
        sb5.append(System.currentTimeMillis());
        sb5.append("|");
        sb5.append(100);
        sb5.append("|");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("|");
        sb5.append(Build.VERSION.RELEASE);
        int i3 = b.i(BaseApplication.getContext(), j3, sb5.toString());
        Object[] objArr = new Object[4];
        objArr[0] = "get trace file fileName = ";
        objArr[1] = j3;
        objArr[2] = ",get system trace status=";
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[3] = Boolean.valueOf(z16);
        QLog.e("LogcatUtil", 1, objArr);
        if (i3 != 1) {
            z17 = b.f(j3, sb5.toString());
        } else {
            z17 = false;
        }
        QLog.e("LogcatUtil", 1, "get trace file fileName = ", j3, ",get java trace status=", Boolean.valueOf(z17));
    }

    private boolean f(String str) {
        if (!str.equals("$logcat start") && !str.equals("$logcat stop") && !str.equals("$list private files") && !str.startsWith("$get private file ") && !str.startsWith("$get trace file")) {
            return false;
        }
        return true;
    }

    private static void g(File file) throws IOException {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                g(file2);
            } else {
                QLog.d("LogcatUtil", 1, "private file path :" + file2.getAbsolutePath());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            e();
                        }
                    } else {
                        String str = (String) message.obj;
                        if (!TextUtils.isEmpty(str)) {
                            d(str);
                        } else {
                            QLog.e("LogcatUtil", 1, "private fileName is null");
                        }
                    }
                } else {
                    File filesDir = BaseApplication.getContext().getFilesDir();
                    QLog.d("LogcatUtil", 1, "private root file path :" + filesDir.getAbsolutePath());
                    try {
                        g(filesDir.getParentFile());
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
            } else {
                LogcatThread logcatThread = this.f119959d;
                if (logcatThread != null) {
                    Process process = logcatThread.C;
                    if (process != null) {
                        process.destroy();
                    }
                    Process process2 = this.f119959d.D;
                    if (process2 != null) {
                        process2.destroy();
                    }
                    this.f119959d = null;
                }
            }
        } else if (this.f119959d == null) {
            LogcatThread logcatThread2 = new LogcatThread();
            this.f119959d = logcatThread2;
            logcatThread2.start();
        }
        return true;
    }
}
