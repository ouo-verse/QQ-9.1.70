package com.tencent.mobileqq.msf.core.net.s;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.msf.core.net.s.a;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: o, reason: collision with root package name */
    private static final String f249042o = "HttpEchoTask";

    /* renamed from: h, reason: collision with root package name */
    private String f249043h;

    /* renamed from: i, reason: collision with root package name */
    private URL f249044i;

    /* renamed from: j, reason: collision with root package name */
    private String f249045j;

    /* renamed from: k, reason: collision with root package name */
    private int f249046k;

    /* renamed from: l, reason: collision with root package name */
    private HttpURLConnection f249047l;

    /* renamed from: m, reason: collision with root package name */
    private int f249048m;

    /* renamed from: n, reason: collision with root package name */
    private String f249049n;

    public b(int i3, String str, String str2, int i16, a.InterfaceC8088a interfaceC8088a) {
        super(i3, interfaceC8088a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), interfaceC8088a);
            return;
        }
        this.f249046k = 10000;
        String str3 = str + b(str);
        this.f249043h = str3;
        this.f249043h = MsfSdkUtils.insertMtype("netdetect", str3);
        this.f249045j = str2;
        this.f249046k = i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0092 A[Catch: all -> 0x00ff, TryCatch #0 {all -> 0x00ff, blocks: (B:10:0x0020, B:12:0x0026, B:13:0x0045, B:22:0x0092, B:24:0x00b1, B:25:0x00d6, B:27:0x00dc), top: B:9:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc A[Catch: all -> 0x00ff, TRY_LEAVE, TryCatch #0 {all -> 0x00ff, blocks: (B:10:0x0020, B:12:0x0026, B:13:0x0045, B:22:0x0092, B:24:0x00b1, B:25:0x00d6, B:27:0x00dc), top: B:9:0x0020 }] */
    @Override // com.tencent.mobileqq.msf.core.net.s.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " try connect " + this.f249043h);
            }
            URL url = new URL(this.f249043h);
            this.f249044i = url;
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            this.f249047l = httpURLConnection;
            httpURLConnection.setDoInput(true);
            this.f249047l.setUseCaches(false);
            this.f249047l.setRequestMethod("GET");
            this.f249047l.setConnectTimeout(this.f249046k);
            this.f249047l.setReadTimeout(10000);
            this.f249047l.connect();
            int responseCode = this.f249047l.getResponseCode();
            if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                z16 = false;
                if (z16) {
                    String headerField = this.f249047l.getHeaderField("Location");
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                    this.f249047l = httpURLConnection2;
                    httpURLConnection2.connect();
                    if (QLog.isColorLevel()) {
                        QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " connect " + this.f249043h + " redirect to: " + headerField);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " connect " + this.f249043h + " succ.");
                }
                return true;
            }
            z16 = true;
            if (z16) {
            }
            if (QLog.isColorLevel()) {
            }
            return true;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " connect " + this.f249043h + " failed.", th5);
            }
            HttpURLConnection httpURLConnection3 = this.f249047l;
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.a
    protected void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " disconnect " + this.f249043h);
        }
        HttpURLConnection httpURLConnection = this.f249047l;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.a
    protected String c() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            this.f249048m = this.f249047l.getResponseCode();
            this.f249049n = this.f249047l.getURL().getHost();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f249047l.getInputStream()));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str2 = str2 + readLine;
            }
            bufferedReader.close();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("WIFI detect, HttpEchoTask ");
                sb5.append(this.f249039a);
                sb5.append(" echo content: ");
                if (str2.length() > 10) {
                    str = str2.substring(0, 10);
                } else {
                    str = str2;
                }
                sb5.append(str);
                QLog.d(f249042o, 2, sb5.toString());
            }
            return str2;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " echo failed", th5);
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.a
    protected Object d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f249043h;
    }

    private String b(String str) {
        String str2 = "r=" + String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000));
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            if (str.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str + str2;
            }
            return str2 + ContainerUtils.FIELD_DELIMITER + str2;
        }
        return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
    }

    @Override // com.tencent.mobileqq.msf.core.net.s.a
    protected int a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        if (this.f249048m == 200 && this.f249044i.getHost().equals(this.f249049n) && !TextUtils.isEmpty(str) && str.equals(this.f249045j)) {
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " valid succ");
            return 0;
        }
        if (!QLog.isColorLevel()) {
            return -3;
        }
        QLog.d(f249042o, 2, "WIFI detect, HttpEchoTask " + this.f249039a + " valid failed.");
        return -3;
    }
}
