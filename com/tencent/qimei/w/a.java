package com.tencent.qimei.w;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.aa.f;
import com.tencent.qimei.aw.a;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f343410a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f343411b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f343412c;

    public a(String str, String str2, b bVar) {
        this.f343410a = str;
        this.f343411b = str2;
        this.f343412c = bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, bVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ea  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        String str2;
        boolean z16;
        c cVar;
        HttpURLConnection httpURLConnection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str3 = this.f343410a;
        String str4 = this.f343411b;
        String str5 = "";
        int i3 = -1;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("If-Modified-Since", str4);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            i3 = httpURLConnection.getResponseCode();
        } catch (SecurityException e16) {
            e16.printStackTrace();
            com.tencent.qimei.ad.c.a("NET", "no network permission,please add in AndroidManifest: <uses-permission android:name=\"android.permission.INTERNET\" /> ", new Object[0]);
            str = "security error: " + e16.getMessage();
            str2 = "199";
        } catch (ConnectException e17) {
            str = "https connect timeout: " + e17.getMessage();
            str2 = "451";
        } catch (Throwable th5) {
            str = "https connect error: " + th5.getMessage();
            str2 = "499";
        }
        if (i3 == 200) {
            str = com.tencent.qimei.f.a.a(httpURLConnection);
            str5 = httpURLConnection.getHeaderField("Last-Modified");
            str2 = "0";
            z16 = true;
            if (!z16) {
                cVar = new c(z16, str);
                cVar.f343415c = str5;
            } else {
                cVar = new c(z16, str2, i3, str);
            }
            if (!cVar.f343413a) {
                b bVar = this.f343412c;
                String str6 = cVar.f343414b;
                String[] strArr = {cVar.f343415c};
                a.c cVar2 = (a.c) bVar;
                cVar2.getClass();
                f.b(com.tencent.qimei.aw.a.this.f343192c).a(cVar2.f343197a, strArr[0]);
                com.tencent.qimei.aw.a.a(com.tencent.qimei.aw.a.this, cVar2.f343198b, cVar2.a(str6));
                return;
            }
            b bVar2 = this.f343412c;
            int i16 = cVar.f343417e;
            a.c cVar3 = (a.c) bVar2;
            com.tencent.qimei.aw.a.a(com.tencent.qimei.aw.a.this, cVar3.f343198b, null);
            com.tencent.qimei.ad.c.a("HidTask", "pull content from server,code = %d", Integer.valueOf(i16));
            return;
        }
        str = "response status code != 2XX. msg: " + httpURLConnection.getResponseMessage();
        str2 = "452";
        z16 = false;
        if (!z16) {
        }
        if (!cVar.f343413a) {
        }
    }
}
