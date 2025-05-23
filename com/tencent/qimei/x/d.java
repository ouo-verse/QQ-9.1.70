package com.tencent.qimei.x;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(com.tencent.qimei.w.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is", cVar.f343413a ? 1 : 0);
            jSONObject.put("bd", cVar.f343414b);
            jSONObject.put("ic", cVar.f343416d);
            jSONObject.put("rc", cVar.f343417e);
            jSONObject.put("em", cVar.f343418f);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r6.isEmpty() == false) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @com.tencent.qimei.p.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(int i3, String str) {
        String str2;
        String str3;
        String str4;
        com.tencent.qimei.w.c cVar;
        String str5 = com.tencent.qimei.u.a.f343382a;
        if (!str5.isEmpty()) {
            str2 = com.tencent.qimei.ar.a.a(str5).f343094b.f343140l;
        }
        if (com.tencent.qimei.ab.b.f342922a) {
            str2 = "https://test.snowflake.qq.com/ola/v2";
        } else {
            str2 = "https://snowflake.qq.com/ola/v2";
        }
        int i16 = 0;
        i16 = 0;
        i16 = 0;
        i16 = 0;
        int i17 = -1;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            httpURLConnection.connect();
            i17 = httpURLConnection.getResponseCode();
            if (i17 == 200) {
                str3 = com.tencent.qimei.f.a.a(httpURLConnection);
                str4 = "0";
                i16 = 1;
            } else {
                str3 = "response status code != 2XX. msg: " + httpURLConnection.getResponseMessage();
                str4 = "452";
            }
        } catch (SecurityException e16) {
            e16.printStackTrace();
            com.tencent.qimei.ad.c.a("NET", "no network permission,please add in AndroidManifest: <uses-permission android:name=\"android.permission.INTERNET\" /> ", new Object[i16]);
            str3 = "security error: " + e16.getMessage();
            str4 = "199";
        } catch (ConnectException e17) {
            str3 = "https connect timeout: " + e17.getMessage();
            str4 = "451";
        } catch (Throwable th5) {
            str3 = "https connect error: " + th5.getMessage();
            str4 = "499";
        }
        if (i16 != 0) {
            cVar = new com.tencent.qimei.w.c(i16, str3);
        } else {
            cVar = new com.tencent.qimei.w.c(i16, str4, i17, str3);
        }
        return a(cVar);
    }
}
