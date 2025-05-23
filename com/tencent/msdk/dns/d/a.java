package com.tencent.msdk.dns.d;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    class RunnableC9222a implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ String E;
        final /* synthetic */ String F;
        final /* synthetic */ String G;
        final /* synthetic */ long H;
        final /* synthetic */ String I;
        final /* synthetic */ String J;
        final /* synthetic */ long K;
        final /* synthetic */ int L;
        final /* synthetic */ long M;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f336399d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f336400e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f336401f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f336402h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f336403i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f336404m;

        RunnableC9222a(String str, String str2, String str3, String str4, String str5, long j3, String str6, String str7, String str8, String str9, String str10, long j16, String str11, String str12, long j17, int i3, long j18) {
            this.f336399d = str;
            this.f336400e = str2;
            this.f336401f = str3;
            this.f336402h = str4;
            this.f336403i = str5;
            this.f336404m = j3;
            this.C = str6;
            this.D = str7;
            this.E = str8;
            this.F = str9;
            this.G = str10;
            this.H = j16;
            this.I = str11;
            this.J = str12;
            this.K = j17;
            this.L = i3;
            this.M = j18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, Long.valueOf(j3), str6, str7, str8, str9, str10, Long.valueOf(j16), str11, str12, Long.valueOf(j17), Integer.valueOf(i3), Long.valueOf(j18));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0133  */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r3v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v8 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ?? r36;
            Throwable th5;
            HttpURLConnection httpURLConnection;
            IOException e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && (r36 = iPatchRedirector.hasPatch((short) 2)) != 0) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i3 = 0;
            i3 = 0;
            i3 = 0;
            try {
                try {
                    URL url = new URL("https://h.trace.qq.com/kv?attaid=0f500064192&token=4725229671&carrier=" + this.f336399d + "&networkType=" + this.f336400e + "&dnsId=" + this.f336401f + "&encryptType=" + this.f336402h + "&eventName=" + this.f336403i + "&eventTime=" + this.f336404m + "&dnsIp=" + this.C + "&sdkVersion=" + this.D + "&deviceName=" + this.E + "&systemName=" + this.F + "&systemVersion=" + this.G + "&spend=" + this.H + "&req_dn=" + this.I + "&req_type=" + this.J + "&req_timeout=" + this.K + "&req_ttl=" + this.L + "&errorCode=" + this.M);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u5f00\u59cbAtta\u4e0a\u62a5\uff1a");
                    sb5.append(url);
                    com.tencent.msdk.dns.base.log.c.c(sb5.toString(), new Object[0]);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } catch (IOException e17) {
                    httpURLConnection = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    r36 = 0;
                    th5 = th6;
                    if (r36 != 0) {
                    }
                    throw th5;
                }
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(2000);
                    httpURLConnection.setReadTimeout(2000);
                    httpURLConnection.connect();
                    httpURLConnection.getResponseCode();
                    httpURLConnection.disconnect();
                    ?? r16 = new Object[0];
                    com.tencent.msdk.dns.base.log.c.c("Atta\u4e0a\u62a5\u5173\u95ed", r16);
                    i3 = r16;
                    r36 = httpURLConnection;
                } catch (IOException e18) {
                    e16 = e18;
                    e16.printStackTrace();
                    r36 = httpURLConnection;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        ?? r17 = new Object[0];
                        com.tencent.msdk.dns.base.log.c.c("Atta\u4e0a\u62a5\u5173\u95ed", r17);
                        i3 = r17;
                        r36 = httpURLConnection;
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (r36 != 0) {
                    r36.disconnect();
                    com.tencent.msdk.dns.base.log.c.c("Atta\u4e0a\u62a5\u5173\u95ed", new Object[i3]);
                }
                throw th5;
            }
        }
    }

    public static Runnable a(String str, String str2, String str3, String str4, String str5, long j3, String str6, String str7, String str8, String str9, String str10, long j16, String str11, String str12, long j17, int i3, long j18) {
        return new RunnableC9222a(str, str2, str3, str4, str5, j3, str6, str7, str8, str9, str10, j16, str11, str12, j17, i3, j18);
    }

    public static String b() {
        return DeviceInfoMonitor.getModel();
    }

    public static String c(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
            return DeviceInfoMonitor.getSimOperator(telephonyManager);
        }
        return "-1";
    }

    public static String d() {
        return Build.VERSION.RELEASE;
    }
}
