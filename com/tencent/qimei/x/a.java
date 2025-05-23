package com.tencent.qimei.x;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea  */
    @com.tencent.qimei.p.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(String str, String str2, int i3, int i16) {
        boolean z16;
        String str3;
        String str4;
        com.tencent.qimei.w.c cVar;
        HttpURLConnection a16;
        String headerField;
        String str5;
        boolean z17 = false;
        int i17 = -1;
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("Content-Type", "application/octet-stream");
            z16 = true;
            if (i16 > 0) {
                linkedHashMap.put("Range", String.format("bytes=%d-%d", Integer.valueOf(i3), Integer.valueOf(i16)));
            }
            a16 = com.tencent.qimei.f.a.a(str, "GET", linkedHashMap);
            i17 = a16.getResponseCode();
        } catch (SecurityException e16) {
            e = e16;
            z16 = false;
        } catch (ConnectException e17) {
            e = e17;
        } catch (Throwable th5) {
            th = th5;
        }
        if (i17 != 200 && i17 != 206) {
            headerField = "response status code != 2XX. msg: " + a16.getResponseMessage();
            str5 = "452";
            String str6 = str5;
            str3 = headerField;
            str4 = str6;
            if (!z17) {
                cVar = new com.tencent.qimei.w.c(z17, str3);
            } else {
                cVar = new com.tencent.qimei.w.c(z17, str4, i17, str3);
            }
            return d.a(cVar);
        }
        if (!com.tencent.qimei.f.a.a(a16, str2)) {
            str4 = "454";
            str3 = "write file failed!";
            if (!z17) {
            }
            return d.a(cVar);
        }
        try {
            headerField = a16.getHeaderField("Content-Range");
            str5 = "0";
            z17 = true;
            String str62 = str5;
            str3 = headerField;
            str4 = str62;
        } catch (SecurityException e18) {
            e = e18;
            e.printStackTrace();
            com.tencent.qimei.ad.c.a("NET", "no network permission,please add in AndroidManifest: <uses-permission android:name=\"android.permission.INTERNET\" /> ", new Object[0]);
            str3 = "security error: " + e.getMessage();
            str4 = "199";
            z17 = z16;
            if (!z17) {
            }
            return d.a(cVar);
        } catch (ConnectException e19) {
            e = e19;
            z17 = true;
            str3 = "https connect timeout: " + e.getMessage();
            str4 = "451";
            if (!z17) {
            }
            return d.a(cVar);
        } catch (Throwable th6) {
            th = th6;
            z17 = true;
            str3 = "https connect error: " + th.getMessage();
            str4 = "499";
            if (!z17) {
            }
            return d.a(cVar);
        }
        if (!z17) {
        }
        return d.a(cVar);
    }
}
