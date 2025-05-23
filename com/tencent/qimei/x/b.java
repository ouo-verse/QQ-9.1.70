package com.tencent.qimei.x;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @com.tencent.qimei.p.b
    public static String s(String str) {
        String str2;
        String str3;
        com.tencent.qimei.w.c cVar;
        boolean z16;
        String str4;
        boolean z17 = false;
        int i3 = -1;
        try {
            HttpURLConnection a16 = com.tencent.qimei.f.a.a(str, "HEAD", new LinkedHashMap());
            i3 = a16.getResponseCode();
            if (i3 == 200) {
                str2 = a16.getHeaderField("Content-Length");
                str4 = "0";
                z16 = true;
            } else {
                str2 = "response status code != 2XX. msg: " + a16.getResponseMessage();
                z16 = false;
                str4 = "452";
            }
            boolean z18 = z16;
            str3 = str4;
            z17 = z18;
        } catch (SecurityException e16) {
            e16.printStackTrace();
            com.tencent.qimei.ad.c.a("NET", "no network permission,please add in AndroidManifest: <uses-permission android:name=\"android.permission.INTERNET\" /> ", new Object[0]);
            str2 = "security error: " + e16.getMessage();
            str3 = "199";
        } catch (ConnectException e17) {
            str2 = "https connect timeout: " + e17.getMessage();
            str3 = "451";
        } catch (Throwable th5) {
            str2 = "https connect error: " + th5.getMessage();
            str3 = "499";
        }
        if (z17) {
            cVar = new com.tencent.qimei.w.c(z17, str2);
        } else {
            cVar = new com.tencent.qimei.w.c(z17, str3, i3, str2);
        }
        return d.a(cVar);
    }
}
