package com.tencent.halley.common.utils;

import android.os.Environment;
import android.util.Log;
import com.tencent.halley.common.utils.log.IDownloadLogProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f113539a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f113540b;

    /* renamed from: c, reason: collision with root package name */
    private static FileWriter f113541c;

    /* renamed from: d, reason: collision with root package name */
    private static IDownloadLogProxy f113542d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113539a = false;
        f113540b = false;
        f113541c = null;
        f113542d = null;
    }

    private static void a() {
        FileWriter fileWriter = f113541c;
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            f113541c = null;
        }
    }

    public static void b(String str, String str2) {
        if (f113539a) {
            Log.d(str, str2);
        }
        if (f113540b) {
            b("D", str, str2, null);
        }
    }

    public static void c(String str, String str2) {
        a(str, str2, (Throwable) null, false);
    }

    public static void d(String str, String str2) {
        if (f113539a) {
            Log.w(str, str2);
        }
        if (f113540b) {
            b("W", str, str2, null);
        }
    }

    public static void e(String str, String str2) {
        c(str, str2, null);
    }

    public static void a(IDownloadLogProxy iDownloadLogProxy) {
        f113542d = iDownloadLogProxy;
        if (iDownloadLogProxy != null) {
            iDownloadLogProxy.initLogger();
        }
    }

    private static void b(String str, String str2, String str3, Throwable th5) {
        if (com.tencent.halley.common.a.h() != null) {
            com.tencent.halley.common.a.h().post(new Runnable(str, str2, str3, th5) { // from class: com.tencent.halley.common.utils.d.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f113543a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f113544b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f113545c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Throwable f113546d;

                {
                    this.f113543a = str;
                    this.f113544b = str2;
                    this.f113545c = str3;
                    this.f113546d = th5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, str2, str3, th5);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        d.c(this.f113543a, this.f113544b, this.f113545c, this.f113546d);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            c(str, str2, str3, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2, String str3, Throwable th5) {
        String str4;
        synchronized (d.class) {
            if (com.tencent.halley.common.a.a() == null) {
                return;
            }
            StringBuilder sb5 = new StringBuilder(str + "\t");
            sb5.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US).format(new Date(System.currentTimeMillis())) + "\t");
            sb5.append(com.tencent.halley.common.a.f113177f + "|" + com.tencent.halley.common.a.g() + "\t");
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str2);
            sb6.append("\t");
            sb5.append(sb6.toString());
            if (str3 != null) {
                sb5.append("[MSG]" + str3 + "\t");
            }
            if (th5 != null) {
                sb5.append("[Throwable]" + Log.getStackTraceString(th5));
            }
            sb5.append("\r\n");
            FileWriter fileWriter = f113541c;
            if (fileWriter != null) {
                try {
                    fileWriter.write(sb5.toString());
                    f113541c.flush();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    try {
                        f113541c.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    f113541c = null;
                }
            }
            if (f113541c == null) {
                String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.US).format(new Date(System.currentTimeMillis()));
                String str5 = "hl_" + (j.a(com.tencent.halley.common.a.g()) ? "main" : com.tencent.halley.common.a.g()) + "_" + format + ".txt";
                if (!j.b()) {
                    Log.w("DOWNLOADER_WARN", "sdcard is not ready, logs will not be saved.");
                    return;
                }
                if (j.b()) {
                    str4 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Log/" + j.g();
                } else {
                    str4 = "";
                }
                File file = new File(str4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str4, str5);
                if (file2.isDirectory()) {
                    file2.delete();
                }
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        a();
                        return;
                    }
                }
                try {
                    FileWriter fileWriter2 = new FileWriter(file2, true);
                    f113541c = fileWriter2;
                    fileWriter2.write(sb5.toString());
                    f113541c.flush();
                } catch (IOException e19) {
                    e19.printStackTrace();
                    a();
                }
            }
        }
    }

    public static void a(String str, String str2) {
        if (f113539a) {
            Log.v(str, str2);
        }
        if (f113540b) {
            b("V", str, str2, null);
        }
    }

    public static void b(String str, String str2, Throwable th5) {
        if (f113539a) {
            Log.w(str, str2, th5);
        }
        if (f113540b) {
            b("W", str, str2, th5);
        }
    }

    public static void c(String str, String str2, Throwable th5) {
        if (f113539a) {
            if (th5 != null) {
                Log.e(str, str2, th5);
            } else {
                Log.e(str, str2);
            }
        }
        if (f113540b) {
            b("E", str, str2, th5);
        }
        IDownloadLogProxy iDownloadLogProxy = f113542d;
        if (iDownloadLogProxy != null) {
            iDownloadLogProxy.e(str, str2, th5);
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        if (f113539a) {
            Log.d(str, str2, th5);
        }
        if (f113540b) {
            b("D", str, str2, th5);
        }
    }

    public static void a(String str, String str2, Throwable th5, boolean z16) {
        IDownloadLogProxy iDownloadLogProxy;
        if (f113539a) {
            if (th5 != null) {
                Log.i(str, str2, th5);
            } else {
                Log.i(str, str2);
            }
        }
        if (f113540b) {
            b("I", str, str2, th5);
        }
        if ((z16 || f113540b) && (iDownloadLogProxy = f113542d) != null) {
            iDownloadLogProxy.i(str, str2, th5);
        }
    }

    public static void a(String str, String str2, boolean z16) {
        a(str, str2, (Throwable) null, z16);
    }

    public static void a(String str, Throwable th5) {
        if (f113539a) {
            Log.w(str, th5);
        }
        if (f113540b) {
            b("W", str, null, th5);
        }
    }

    public static void a(boolean z16, boolean z17) {
        f113539a = z16;
        f113540b = z17;
    }
}
