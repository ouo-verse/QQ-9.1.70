package com.tencent.qqperf.monitor.crash;

import KQQ.HttpUploadReq;
import KQQ.UploadInfo;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qqperf.monitor.crash.tools.j;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.CancellationException;
import mqq.app.AppRuntime;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ReportLog extends CrashHandler {
    static ProgressDialog C = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f363173d = false;

    /* renamed from: m, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f363178m;

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f363174e = "9u23fh$jkf^%43hj".getBytes();

    /* renamed from: f, reason: collision with root package name */
    public static boolean f363175f = false;

    /* renamed from: h, reason: collision with root package name */
    private static byte[] f363176h = null;

    /* renamed from: i, reason: collision with root package name */
    private static String f363177i = "0";
    private static final Handler D = new a(Looper.getMainLooper());
    private static final IHttpCommunicatorListener E = new b();
    public static String F = "https://bugtrace.3g.qq.com/upload/1/0";

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 10000001) {
                ProgressBar progressBar = (ProgressBar) ReportLog.C.findViewById(R.id.cib);
                Drawable drawable = ReportLog.C.getContext().getResources().getDrawable(R.drawable.f160604l9);
                progressBar.setIndeterminateDrawable(drawable);
                progressBar.setBackgroundDrawable(drawable);
                ((TextView) ReportLog.C.findViewById(R.id.dialogText)).setText(R.string.hem);
                ReportLog.D.sendEmptyMessageDelayed(10000002, 2000L);
                return;
            }
            if (i3 == 10000002 && ReportLog.C != null) {
                try {
                    try {
                        ReportLog.f363175f = false;
                        ReportLog.C.dismiss();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } finally {
                    ReportLog.C = null;
                }
            }
        }
    }

    public ReportLog() {
        if (f363178m == null) {
            f363178m = Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    public static void appendLog(String str, String str2, boolean z16) {
        j.a(str, str2, z16);
    }

    public static void b(String str, String str2) {
        if (!f363173d || f363175f) {
            return;
        }
        appendLog(str, str2, true);
    }

    private boolean c(Throwable th5) {
        int i3;
        boolean z16;
        boolean z17;
        char c16;
        if (th5 != null && (1 == (i3 = MobileQQ.sProcessId) || 7 == i3)) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4);
            if (!sharedPreferences.getBoolean(MsfCmdConfig.KEY_NOT_EXIT_ENABLE, false)) {
                return false;
            }
            String th6 = th5.toString();
            try {
                String string = sharedPreferences.getString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_TYPE, null);
                String string2 = sharedPreferences.getString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_STACK, null);
                char c17 = 3;
                if (string != null && !TextUtils.isEmpty(th6)) {
                    z16 = false;
                    for (String str : string.split("\\|")) {
                        if (th6.contains(str)) {
                            QLog.d("ReportLog", 1, "exMsg = ", th6, ",crash = ", str);
                            z16 = true;
                        }
                    }
                } else {
                    z16 = false;
                }
                if (string2 != null) {
                    String[] split = string2.split("\\|");
                    StackTraceElement[] stackTrace = th5.getStackTrace();
                    int length = stackTrace.length;
                    int i16 = 0;
                    z17 = false;
                    while (i16 < length) {
                        StackTraceElement stackTraceElement = stackTrace[i16];
                        if (z17) {
                            break;
                        }
                        String stackTraceElement2 = stackTraceElement.toString();
                        int length2 = split.length;
                        int i17 = 0;
                        while (true) {
                            if (i17 < length2) {
                                String str2 = split[i17];
                                if (!TextUtils.isEmpty(stackTraceElement2) && !TextUtils.isEmpty(str2) && stackTraceElement2.contains(str2)) {
                                    c16 = 3;
                                    QLog.d("ReportLog", 1, "stackElemStr = ", stackTraceElement2, ",crash = ", str2);
                                    z17 = true;
                                    break;
                                }
                                i17++;
                                c17 = 3;
                            } else {
                                c16 = c17;
                                break;
                            }
                        }
                        i16++;
                        c17 = c16;
                    }
                } else {
                    z17 = false;
                }
                if (!z17 || !z16) {
                    return false;
                }
                return true;
            } catch (Throwable th7) {
                QLog.e("ReportLog", 1, "isNotExitSafeMode has some error", th7);
            }
        }
        return false;
    }

    public static void d(Context context, boolean z16) {
        if (f363173d == z16) {
            return;
        }
        f363173d = z16;
        if (z16) {
            try {
                j.f363237a = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
                j.f363238b = DeviceInfoMonitor.getModel();
                j.f363239c = Build.VERSION.RELEASE;
            } catch (PackageManager.NameNotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ReportLog", 2, "setLogOn failed", e16);
                }
            }
        }
    }

    public static void e(String str) {
        f363177i = str;
    }

    public static void f(ProgressDialog progressDialog, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ReportLog", 2, Integer.valueOf(AppSetting.f()), "CrashReport", "", str);
        } else {
            QLog.d("ReportLog", 1, Integer.valueOf(AppSetting.f()), "CrashReport", "", LogUtil.wrapLogUin(str));
        }
        C = progressDialog;
        File file = new File(AppConstants.LOG_PATH_SDCARD + "log.txt");
        if (!file.exists()) {
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        appendLog(null, "End Log.Start Upload Log..", true);
        try {
            try {
                f363175f = true;
                long length = file.length();
                byte[] bArr = new byte[(int) length];
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    if (bufferedInputStream2.read(bArr, 0, r0) == length) {
                        bufferedInputStream2.close();
                        file.delete();
                        if (f363176h == null) {
                            f363176h = "00".getBytes();
                        }
                        if (str == null) {
                            str = "0";
                        }
                        UploadInfo uploadInfo = new UploadInfo();
                        uploadInfo.lAppID = AppSetting.f();
                        uploadInfo.lFromMID = Long.parseLong(str);
                        uploadInfo.lToMID = 0L;
                        uploadInfo.shType = (short) 1;
                        uploadInfo.vSignature = f363176h;
                        byte[] encrypt = new Cryptor().encrypt(uploadInfo.toByteArray(), f363174e);
                        HttpUploadReq httpUploadReq = new HttpUploadReq();
                        httpUploadReq.vEncryptUploadInfo = encrypt;
                        httpUploadReq.vFileData = bArr;
                        HttpMsg httpMsg = new HttpMsg(F, httpUploadReq.toByteArray(), E);
                        httpMsg.setRequestMethod("POST");
                        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(httpMsg);
                        f363175f = false;
                        return;
                    }
                    throw new Exception("read log file error");
                } catch (Exception e16) {
                    e = e16;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // mqq.app.CrashHandler, java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        if (th5 == null) {
            QLog.e("ReportLog", 1, "uncaughtException Throwable is null!!!");
            super.uncaughtException(thread, th5);
            return;
        }
        QLog.d("ReportLog", 1, "uncaughtException java crash\uff1a", th5);
        if (th5 instanceof CancellationException) {
            Throwable cause = ((CancellationException) th5).getCause();
            if (cause != null) {
                QLog.d("ReportLog", 1, "uncaughtException CancellationException causeEx\uff1a" + cause, cause);
            } else {
                QLog.d("ReportLog", 1, "uncaughtException CancellationException causeEx is null");
            }
        }
        String th6 = th5.toString();
        if (!TextUtils.isEmpty(th6) && th6.contains("java.util.concurrent.TimeoutException") && th6.contains(".finalize() timed out after")) {
            return;
        }
        if (c(th5)) {
            SafeModeUtil.f(HardCodeUtil.qqStr(R.string.t0x));
            QQCrashReportManager.f363164h = true;
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(new Throwable(th5), "notExitOnSafeMode");
            if (Looper.myLooper() == null) {
                try {
                    thread.run();
                    return;
                } catch (Throwable th7) {
                    QLog.d("ReportLog", 1, "uncaughtException run throwable=", th7);
                    com.tencent.qqperf.monitor.crash.catchedexception.a.c(new Throwable(th7), "CrashInThreadRun");
                    try {
                        thread.interrupt();
                        return;
                    } catch (Throwable th8) {
                        QLog.d("ReportLog", 1, "uncaughtException interrupt throwable=", th8);
                        return;
                    }
                }
            }
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th9) {
                    QLog.d("ReportLog", 1, "uncaughtException loop throwable=", th9);
                    if (c(th9)) {
                        continue;
                    } else {
                        com.tencent.qqperf.monitor.crash.catchedexception.a.c(new Throwable(th9), "CrashInLooper");
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            System.exit(0);
                        } else {
                            return;
                        }
                    }
                }
            }
        } else {
            super.uncaughtException(thread, th5);
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d("ReportLog", 1, "uncaughtException trySave cost=" + (System.currentTimeMillis() - currentTimeMillis));
            HeavyTaskExecutor.e();
            QLog.d("ReportLog", 1, "uncaughtException HeavyTask cost=" + (System.currentTimeMillis() - currentTimeMillis));
            final MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            try {
                j.f363237a = InstalledAppListMonitor.getPackageInfo(mobileQQ.getPackageManager(), mobileQQ.getPackageName(), 0).versionName;
                j.f363238b = DeviceInfoMonitor.getModel();
                j.f363239c = Build.VERSION.RELEASE;
            } catch (Exception unused) {
            }
            mobileQQ.crashed();
            mobileQQ.sendBroadcast(new Intent("qqplayer_exit_action"));
            QQMusicPlayService.L("ReportLog");
            Runnable runnable = new Runnable() { // from class: com.tencent.qqperf.monitor.crash.ReportLog.3
                @Override // java.lang.Runnable
                public void run() {
                    if (mobileQQ instanceof BaseApplicationImpl) {
                        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                        if (runtime instanceof QQAppInterface) {
                            QLog.d("ReportLog", 1, "uncaughtException QQAppInterface exit.");
                            ((QQAppInterface) runtime).exit(false);
                        }
                    }
                }
            };
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                new Handler(Looper.getMainLooper()).postAtFrontOfQueue(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class b implements IHttpCommunicatorListener {
        b() {
        }

        @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
        public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
            ReportLog.D.sendEmptyMessage(10000001);
        }

        @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
        public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
            ReportLog.f363175f = false;
            ReportLog.D.sendEmptyMessage(10000001);
        }

        @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
        public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
            return true;
        }

        @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
        public void handleRedirect(String str) {
        }
    }
}
