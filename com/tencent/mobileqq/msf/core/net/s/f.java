package com.tencent.mobileqq.msf.core.net.s;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* compiled from: P */
@SuppressLint({"DefaultLocale"})
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f249087g = "Traceroute";

    /* renamed from: a, reason: collision with root package name */
    private boolean f249088a;

    /* renamed from: b, reason: collision with root package name */
    private String f249089b;

    /* renamed from: c, reason: collision with root package name */
    private String f249090c;

    /* renamed from: d, reason: collision with root package name */
    private int f249091d;

    /* renamed from: e, reason: collision with root package name */
    private int f249092e;

    /* renamed from: f, reason: collision with root package name */
    private a f249093f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f249094a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f249095b;

        /* renamed from: c, reason: collision with root package name */
        public String f249096c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f249094a = 0;
            this.f249095b = false;
            this.f249096c = "";
        }
    }

    public f(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            return;
        }
        this.f249088a = false;
        this.f249089b = "";
        this.f249090c = "";
        this.f249091d = 30;
        this.f249092e = 10;
        this.f249093f = new a();
        this.f249089b = str;
        this.f249088a = z16;
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f249091d = i3;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    public a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f249093f : (a) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public a c() {
        String str;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str2 = "Traceroute start host: " + this.f249089b + " maxTTL: " + this.f249091d + " timeout: " + this.f249092e + ReportConstant.COSTREPORT_PREFIX;
        if (this.f249088a) {
            QLog.d(f249087g, 1, str2);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append("\n");
        for (int i3 = 1; i3 < this.f249091d; i3++) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String a16 = a(a(), i3);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                String a17 = a(a16);
                if (!TextUtils.isEmpty(a17)) {
                    this.f249090c = a17;
                }
                b16 = b(a16);
                String str3 = String.format("%10dms     %s", Long.valueOf(elapsedRealtime2 - elapsedRealtime), b16).toString();
                sb5.append(str3);
                sb5.append("\n");
                if (this.f249088a) {
                    QLog.d(f249087g, 1, str3);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                String str4 = "Ping error: " + e16.getMessage();
                if (this.f249088a) {
                    QLog.d(f249087g, 1, str4);
                }
                sb5.append(str4);
                sb5.append("\n");
            }
            if (this.f249089b.equals(b16) || this.f249090c.equals(b16)) {
                a aVar = this.f249093f;
                aVar.f249095b = true;
                aVar.f249094a = i3;
                break;
            }
        }
        if (this.f249093f.f249095b) {
            str = "Traceroute succ host: " + this.f249089b + "(" + this.f249090c + ") TTL: " + this.f249093f.f249094a;
        } else {
            str = "Traceroute fail host: " + this.f249089b + "(" + this.f249090c + ") TTL: " + this.f249093f.f249094a;
        }
        sb5.append(str);
        sb5.append("\n");
        if (this.f249088a) {
            QLog.d(f249087g, 1, str);
        }
        this.f249093f.f249096c = sb5.toString();
        return this.f249093f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v9 */
    private String a(String str, int i3) throws Exception {
        String str2 = "";
        Runtime runtime = Runtime.getRuntime();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("/system/bin/ping -c 1 -w ");
        sb5.append(this.f249092e);
        sb5.append(" -t ");
        sb5.append(i3);
        ?? e16 = " ";
        sb5.append(" ");
        sb5.append(str);
        Process exec = RuntimeMonitor.exec(runtime, sb5.toString());
        try {
        } catch (Exception unused) {
            e16.printStackTrace();
        }
        try {
            try {
                e16 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                new String();
                while (true) {
                    String readLine = e16.readLine();
                    if (readLine != null) {
                        str2 = str2 + readLine;
                    } else {
                        try {
                            break;
                        } catch (Exception e17) {
                            exec.destroy();
                            e16 = e17;
                        }
                    }
                }
                exec.exitValue();
                e16 = e16;
            } catch (Exception e18) {
                e16 = e18;
                e16.printStackTrace();
                try {
                    exec.exitValue();
                    e16 = e16;
                } catch (Exception e19) {
                    exec.destroy();
                    e16 = e19;
                }
            }
            return str2.toLowerCase();
        } catch (Throwable th5) {
            try {
                exec.exitValue();
            } catch (Exception e26) {
                try {
                    exec.destroy();
                } catch (Exception unused2) {
                    e26.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f249092e = i3;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    private String b(String str) {
        int i3;
        int indexOf;
        int indexOf2 = str.indexOf("from");
        String trim = ((indexOf2 < 0 || (indexOf = str.indexOf(" ", (i3 = indexOf2 + 5))) <= 0) ? "*" : str.substring(i3, indexOf)).trim();
        if (trim.endsWith(":")) {
            trim = trim.substring(0, trim.length() - 1).trim();
        }
        return TextUtils.isEmpty(trim) ? "*" : trim;
    }

    private String a(String str) {
        if (!str.contains("ping")) {
            return "";
        }
        return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
    }

    private String a() {
        return TextUtils.isEmpty(this.f249090c) ? this.f249089b : this.f249090c;
    }
}
