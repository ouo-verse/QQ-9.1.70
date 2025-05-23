package com.tencent.mobileqq.msf.core.net.t;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.album.GuildFeedPreviewCustomization;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/* compiled from: P */
@SuppressLint({"DefaultLocale"})
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: l, reason: collision with root package name */
    private static final String f249367l = "PingAndTraceroute";

    /* renamed from: a, reason: collision with root package name */
    private boolean f249368a;

    /* renamed from: b, reason: collision with root package name */
    private String f249369b;

    /* renamed from: c, reason: collision with root package name */
    private String f249370c;

    /* renamed from: d, reason: collision with root package name */
    private int f249371d;

    /* renamed from: e, reason: collision with root package name */
    private int f249372e;

    /* renamed from: f, reason: collision with root package name */
    private int f249373f;

    /* renamed from: g, reason: collision with root package name */
    private int f249374g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f249375h;

    /* renamed from: i, reason: collision with root package name */
    private a f249376i;

    /* renamed from: j, reason: collision with root package name */
    private HashMap<String, String> f249377j;

    /* renamed from: k, reason: collision with root package name */
    private String f249378k;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f249379a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f249380b;

        /* renamed from: c, reason: collision with root package name */
        public String f249381c;

        /* renamed from: d, reason: collision with root package name */
        public String f249382d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f249379a = 0;
            this.f249380b = false;
            this.f249381c = "";
            this.f249382d = "";
        }
    }

    public e(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            return;
        }
        this.f249368a = false;
        this.f249369b = "";
        this.f249370c = "";
        this.f249371d = 60;
        this.f249372e = 10;
        this.f249373f = GuildFeedPreviewCustomization.DEFAULT_CHOOSE_VIDEO_DURATION;
        this.f249374g = 3;
        this.f249375h = false;
        this.f249376i = new a();
        this.f249377j = null;
        this.f249378k = "";
        this.f249369b = str;
        this.f249368a = z16;
    }

    public void a(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f249377j = hashMap;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
        }
    }

    public a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f249376i : (a) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Throwable, java.lang.Exception] */
    public a c() {
        String str;
        Process exec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ?? e16 = SystemClock.elapsedRealtime();
        StringBuilder sb5 = new StringBuilder();
        try {
            if (!TextUtils.isEmpty(this.f249378k)) {
                str = "/system/bin/ping " + this.f249378k;
                if (!str.contains(LogCmdOptions.CLEAR)) {
                    str = str + "-c 4 ";
                }
                if (!str.contains("-w")) {
                    str = str + "-w 10 ";
                }
            } else {
                str = "/system/bin/ping -c 4 -w 10 ";
            }
            String str2 = str + a();
            if (QLog.isColorLevel()) {
                QLog.d(f249367l, 2, "pingCommand : " + str2);
            }
            try {
                exec = RuntimeMonitor.exec(Runtime.getRuntime(), str2);
            } catch (Exception unused) {
                e16.printStackTrace();
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(f249367l, 2, e17, new Object[0]);
            }
        }
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                new String();
                do {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append("\n");
                } while (SystemClock.elapsedRealtime() - e16 < this.f249373f);
                this.f249376i.f249380b = true;
                try {
                    exec.exitValue();
                } catch (Exception e18) {
                    exec.destroy();
                    e16 = e18;
                    this.f249376i.f249382d = sb5.toString();
                    a aVar = this.f249376i;
                    aVar.f249381c = a(aVar.f249382d.toLowerCase());
                    return this.f249376i;
                }
            } catch (Exception e19) {
                e16 = e19;
                e16.printStackTrace();
                try {
                    exec.exitValue();
                    e16 = e16;
                } catch (Exception e26) {
                    exec.destroy();
                    e16 = e26;
                }
                this.f249376i.f249382d = sb5.toString();
                a aVar2 = this.f249376i;
                aVar2.f249381c = a(aVar2.f249382d.toLowerCase());
                return this.f249376i;
            }
            this.f249376i.f249382d = sb5.toString();
            a aVar22 = this.f249376i;
            aVar22.f249381c = a(aVar22.f249382d.toLowerCase());
            return this.f249376i;
        } catch (Throwable th5) {
            try {
                exec.exitValue();
            } catch (Exception e27) {
                try {
                    exec.destroy();
                } catch (Exception unused2) {
                    e27.printStackTrace();
                }
                throw th5;
            }
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x016d, code lost:
    
        if (r20.f249376i.f249380b == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x016f, code lost:
    
        r0 = "Traceroute succ host: " + r20.f249369b + "(" + r20.f249370c + ") TTL: " + r20.f249376i.f249379a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01be, code lost:
    
        if (r20.f249368a == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c4, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01c6, code lost:
    
        com.tencent.qphone.base.util.QLog.d(r9, 2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ca, code lost:
    
        r20.f249376i.f249382d = r5.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d4, code lost:
    
        return r20.f249376i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0196, code lost:
    
        r0 = "Traceroute fail host: " + r20.f249369b + "(" + r20.f249370c + ") TTL: " + r20.f249376i.f249379a;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da A[Catch: Exception -> 0x0135, TRY_LEAVE, TryCatch #1 {Exception -> 0x0135, blocks: (B:13:0x0032, B:15:0x0036, B:30:0x00c1, B:31:0x00c7, B:32:0x00d0, B:34:0x00da, B:38:0x00e7, B:40:0x0102, B:61:0x010f, B:63:0x0116, B:64:0x011a, B:66:0x0122, B:71:0x012d), top: B:12:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fe  */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a d() {
        boolean z16;
        long elapsedRealtime;
        int i3;
        String str;
        int i16;
        String b16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb5 = new StringBuilder();
        boolean z17 = true;
        int i17 = 1;
        while (true) {
            int i18 = this.f249371d;
            String str3 = f249367l;
            if (i17 >= i18) {
                break;
            }
            Object obj = "*";
            String str4 = "";
            int i19 = 0;
            ?? r65 = z17;
            while (i19 < this.f249374g) {
                try {
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    i3 = this.f249372e;
                    str = str3;
                    i16 = (int) (elapsedRealtime - elapsedRealtime2);
                } catch (Exception e16) {
                    e = e16;
                }
                try {
                    int i26 = this.f249373f;
                    if (i16 >= i26) {
                        a aVar = this.f249376i;
                        aVar.f249380b = r65;
                        aVar.f249379a = i17;
                        sb5.append("\n");
                        aVar.f249382d = sb5.toString();
                        return this.f249376i;
                    }
                    int i27 = i26 - i16;
                    if (i27 < 10000) {
                        i3 = (i27 / 1000) + 1;
                    }
                    String a16 = a(a(), i17, i3);
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    String a17 = a(a16);
                    if (!TextUtils.isEmpty(a17)) {
                        this.f249370c = a17;
                        if (!this.f249375h) {
                            this.f249376i.f249381c = a17;
                            String str5 = "Traceroute to " + this.f249369b + " (" + a17 + "), " + this.f249371d + " hops max, 60 byte packets, mTimeout " + this.f249372e + ReportConstant.COSTREPORT_PREFIX;
                            this.f249375h = r65;
                            if (this.f249368a) {
                                str3 = str;
                                QLog.d(str3, (int) r65, str5);
                            } else {
                                str3 = str;
                            }
                            sb5.append(str5);
                            sb5.append("\n");
                            b16 = b(a16);
                            if (b16.equals("*")) {
                                if (b16.equals(obj)) {
                                    b16 = "";
                                } else {
                                    obj = b16;
                                }
                                str2 = String.format("%s %10d ms ", b16, Long.valueOf(elapsedRealtime3 - elapsedRealtime)).toString();
                            } else {
                                str2 = " * ";
                            }
                            sb5.append(str2);
                            i19++;
                            str4 = str2;
                            r65 = 1;
                        }
                    }
                    str3 = str;
                    b16 = b(a16);
                    if (b16.equals("*")) {
                    }
                    sb5.append(str2);
                    i19++;
                    str4 = str2;
                    r65 = 1;
                } catch (Exception e17) {
                    e = e17;
                    str3 = str;
                    e.printStackTrace();
                    String str6 = "Ping error: " + e.getMessage();
                    if (this.f249368a) {
                        z16 = true;
                        QLog.d(str3, 1, str6);
                    } else {
                        z16 = true;
                    }
                    sb5.append(str6);
                    sb5.append("\n");
                    i17++;
                    z17 = z16;
                }
            }
            sb5.append("\n");
            if (this.f249368a) {
                QLog.d(str3, 1, str4);
            }
            if (!this.f249369b.equals(obj) && !this.f249370c.equals(obj)) {
                z16 = true;
                i17++;
                z17 = z16;
            }
            a aVar2 = this.f249376i;
            aVar2.f249380b = true;
            aVar2.f249379a = i17;
            break;
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f249371d = i3;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.f249372e = i3;
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.BufferedReader] */
    private String a(String str, int i3, int i16) throws Exception {
        String str2 = "";
        Runtime runtime = Runtime.getRuntime();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("/system/bin/ping -c 1 -s 60 -w ");
        sb5.append(i16);
        sb5.append(" -t ");
        sb5.append(i3);
        ?? e16 = " ";
        sb5.append(" ");
        sb5.append(str);
        Process exec = RuntimeMonitor.exec(runtime, sb5.toString());
        try {
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
                            }
                        }
                    }
                    exec.exitValue();
                } catch (Exception e18) {
                    e16 = e18;
                    e16.printStackTrace();
                    try {
                        exec.exitValue();
                    } catch (Exception e19) {
                        exec.destroy();
                    }
                }
            } catch (Exception unused) {
                e16.printStackTrace();
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

    public e(String str, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.f249368a = false;
        this.f249369b = "";
        this.f249370c = "";
        this.f249371d = 60;
        this.f249372e = 10;
        this.f249373f = GuildFeedPreviewCustomization.DEFAULT_CHOOSE_VIDEO_DURATION;
        this.f249374g = 3;
        this.f249375h = false;
        this.f249376i = new a();
        this.f249377j = null;
        this.f249378k = "";
        this.f249369b = str;
        this.f249368a = z16;
        this.f249373f = i3;
    }

    private String a(String str) {
        if (!str.contains("ping")) {
            return "";
        }
        return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
    }

    private String a() {
        return TextUtils.isEmpty(this.f249370c) ? this.f249369b : this.f249370c;
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f249378k = str;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }
}
