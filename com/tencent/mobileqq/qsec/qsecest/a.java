package com.tencent.mobileqq.qsec.qsecest;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.FileReader;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f276824a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276824a = "FileUtil";
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader = null;
        try {
            StringBuilder sb5 = new StringBuilder();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                String str2 = "";
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb5.append(str2);
                    sb5.append(readLine);
                    str2 = "  ";
                }
                String sb6 = sb5.toString();
                try {
                    bufferedReader2.close();
                } catch (Throwable unused) {
                }
                return sb6;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = bufferedReader2;
                try {
                    Log.d(f276824a, "readFile IOException: " + th.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return "E_TH";
                } catch (Throwable th6) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
