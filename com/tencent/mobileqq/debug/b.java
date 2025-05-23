package com.tencent.mobileqq.debug;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f203482a;

    /* renamed from: b, reason: collision with root package name */
    private static String f203483b;

    /* renamed from: c, reason: collision with root package name */
    private static String f203484c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203482a = HardCodeUtil.qqStr(R.string.f208155by);
        }
    }

    public static synchronized String a() {
        String str;
        synchronized (b.class) {
            if (TextUtils.isEmpty(f203484c)) {
                c();
            }
            str = f203484c;
        }
        return str;
    }

    public static synchronized String b() {
        String str;
        synchronized (b.class) {
            if (TextUtils.isEmpty(f203483b)) {
                c();
            }
            str = f203483b;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c() {
        Throwable th5;
        BufferedReader bufferedReader;
        IOException e16;
        BufferedReader bufferedReader2 = null;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(BaseApplication.getContext().getAssets().open("svninfo.dat")));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int indexOf = readLine.indexOf("Revision:");
                        if (indexOf > -1) {
                            f203483b = readLine.substring(indexOf + 9).trim();
                        }
                        int indexOf2 = readLine.indexOf(f203482a);
                        if (indexOf2 > -1) {
                            f203483b = readLine.substring(indexOf2 + 9).trim();
                        }
                        int indexOf3 = readLine.indexOf("user:");
                        if (indexOf3 > -1) {
                            f203484c = readLine.substring(indexOf3 + 5).trim();
                        }
                    } catch (IOException e18) {
                        e16 = e18;
                        e16.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        QLog.d("LocalInfoUtils", 2, "init end revision: " + f203483b + " user: " + f203484c);
                    }
                }
                bufferedReader.close();
            } catch (IOException e19) {
                bufferedReader = null;
                e16 = e19;
            } catch (Throwable th6) {
                th5 = th6;
                if (0 != 0) {
                }
                throw th5;
            }
            QLog.d("LocalInfoUtils", 2, "init end revision: " + f203483b + " user: " + f203484c);
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                try {
                    bufferedReader2.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th5;
        }
    }
}
