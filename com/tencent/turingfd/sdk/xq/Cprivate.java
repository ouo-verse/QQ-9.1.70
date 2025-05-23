package com.tencent.turingfd.sdk.xq;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.private, reason: invalid class name */
/* loaded from: classes27.dex */
public final class Cprivate {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference<String> f383415a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f383415a = new AtomicReference<>();
        }
    }

    public static String a() {
        AtomicReference<String> atomicReference = f383415a;
        String str = atomicReference.get();
        if (str == null) {
            synchronized (atomicReference) {
                str = atomicReference.get();
                if (str == null) {
                    str = DeviceInfoMonitor.getModel();
                    atomicReference.set(str);
                }
            }
        }
        return str;
    }

    public static int b() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(boolean z16) {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            StringBuilder sb5 = new StringBuilder("");
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb5.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable unused2) {
                            bufferedReader.close();
                            fileInputStream.close();
                            String sb6 = sb5.toString();
                            if (!z16) {
                            }
                        }
                    } catch (Throwable unused3) {
                        String sb62 = sb5.toString();
                        if (!z16) {
                        }
                    }
                } catch (Throwable unused4) {
                    fileInputStream.close();
                    String sb622 = sb5.toString();
                    if (!z16) {
                        return sb622;
                    }
                    if (sb622 == null || sb622.equals("")) {
                        return "";
                    }
                    String substring = sb622.substring(sb622.indexOf("version ") + 8);
                    return substring.substring(0, substring.indexOf(" "));
                }
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (Throwable unused5) {
            return "";
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
