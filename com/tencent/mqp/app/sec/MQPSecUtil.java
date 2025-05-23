package com.tencent.mqp.app.sec;

import android.content.Context;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes21.dex */
public class MQPSecUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static MQPSecUtil f336103a;

    /* renamed from: b, reason: collision with root package name */
    public static int f336104b;

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    static {
        String str = ResourceAttributes.HostArchValues.X86;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f336103a = null;
        boolean z16 = true;
        f336104b = 1;
        BaseApplication context = BaseApplication.getContext();
        File file = new File(context.getFilesDir().getParent() + "/txlib/libmqpintchk.so");
        if (!file.exists()) {
            try {
                String str2 = Build.CPU_ABI;
                if (!str2.contains(ResourceAttributes.HostArchValues.X86)) {
                    if (!str2.contains("mip")) {
                        str = "armeabi";
                    } else {
                        str = "mips";
                    }
                }
                if (str != "mips") {
                    a(context, str);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (!file.exists()) {
            file = new File(context.getFilesDir().getParent() + "/lib/libmqpintchk.so");
        }
        if (file.exists()) {
            try {
                System.load(file.getAbsolutePath());
            } catch (UnsatisfiedLinkError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("MQPSecUtil", 2, "cannot load library " + file.getAbsolutePath());
                }
            }
            if (z16) {
                try {
                    System.loadLibrary("mqpintchk");
                    return;
                } catch (UnsatisfiedLinkError unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MQPSecUtil", 2, "cannot load library mqpintchk");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        z16 = false;
        if (z16) {
        }
    }

    public MQPSecUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(Context context, String str) {
        FileOutputStream fileOutputStream;
        InputStream open;
        String str2 = "lib/" + str + "/libmqpintchk.so";
        String str3 = context.getFilesDir().getParent() + "/txlib";
        String str4 = str3 + "/libmqpintchk.so";
        new File(str3).mkdirs();
        InputStream inputStream = null;
        try {
            try {
                open = context.getAssets().open(str2);
                try {
                    fileOutputStream = new FileOutputStream(str4);
                } catch (Exception unused) {
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (Exception unused2) {
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        open.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception unused3) {
                inputStream = open;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = open;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    public static void do_report(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MQPSecUtil", 2, "report_tracer:" + str);
        }
        ReportController.r((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Safe_MQPSecUtil", "", "AntiTrace", str, 0, 0, "", "", "", "");
    }

    public static native boolean memchk(String str, int i3, int i16, byte[] bArr);

    public static native byte[] memreport(String str, int i3, int i16);

    public native void antitrace(String str);
}
