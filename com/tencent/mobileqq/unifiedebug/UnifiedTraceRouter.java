package com.tencent.mobileqq.unifiedebug;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.httpcore.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UnifiedTraceRouter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f305780a;

    /* renamed from: b, reason: collision with root package name */
    public int f305781b;

    /* renamed from: c, reason: collision with root package name */
    public String f305782c;

    /* renamed from: d, reason: collision with root package name */
    public float f305783d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f305784e;

    /* renamed from: f, reason: collision with root package name */
    public List<a> f305785f;

    /* renamed from: g, reason: collision with root package name */
    public QQAppInterface f305786g;

    /* renamed from: h, reason: collision with root package name */
    public String f305787h;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f305791a;

        /* renamed from: b, reason: collision with root package name */
        public String f305792b;

        /* renamed from: c, reason: collision with root package name */
        public String f305793c;

        /* renamed from: d, reason: collision with root package name */
        public float f305794d;

        public a(String str, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UnifiedTraceRouter.this, str, Float.valueOf(f16));
            } else {
                this.f305793c = str;
                this.f305794d = f16;
            }
        }

        public JSONArray a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JSONArray) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.mo162put(this.f305793c);
                jSONArray.put(this.f305794d);
            } catch (JSONException unused) {
            }
            return jSONArray;
        }
    }

    public UnifiedTraceRouter(QQAppInterface qQAppInterface, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) handler);
            return;
        }
        this.f305780a = 32;
        this.f305781b = 1;
        this.f305787h = "";
        this.f305786g = qQAppInterface;
        this.f305784e = handler;
        this.f305785f = new ArrayList();
    }

    public String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (str.contains("PING")) {
            return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        }
        return "";
    }

    public String b(String str) {
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (str.contains(HttpHeaders.FROM)) {
            String substring = str.substring(str.indexOf(HttpHeaders.FROM) + 5);
            if (substring.contains("(")) {
                int indexOf2 = substring.indexOf("(");
                int indexOf3 = substring.indexOf(")");
                if (indexOf2 >= 0 && indexOf3 >= 0) {
                    return substring.substring(indexOf2 + 1, indexOf3);
                }
                return substring;
            }
            String substring2 = substring.substring(0, substring.indexOf("\n"));
            if (substring2.contains(":")) {
                indexOf = substring2.indexOf(":");
            } else {
                indexOf = substring2.indexOf(" ");
            }
            if (indexOf > 0) {
                return substring2.substring(0, indexOf);
            }
            return substring2;
        }
        int indexOf4 = str.indexOf("(");
        int indexOf5 = str.indexOf(")");
        if (indexOf4 >= 0 && indexOf5 >= 0) {
            return str.substring(indexOf4 + 1, indexOf5);
        }
        return null;
    }

    public String c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (str.contains("time=")) {
            String substring = str.substring(str.indexOf("time=") + 5);
            return substring.substring(0, substring.indexOf(" "));
        }
        return "";
    }

    public String d(String str) throws IOException, RuntimeException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        String format = String.format("/system/bin/ping -i 0.2 -c 1 -s 0 -t %d -W 4 %s", Integer.valueOf(this.f305781b), str);
        long currentTimeMillis = System.currentTimeMillis();
        Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), format);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            str2 = str2 + readLine + "\n";
            if (readLine.contains(HttpHeaders.FROM) || readLine.contains("from")) {
                this.f305783d = (float) (System.currentTimeMillis() - currentTimeMillis);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedTraceRouter", 2, "ping url = " + str + " result = " + str2);
        }
        try {
            exec.destroy();
        } catch (Exception unused) {
        }
        if (!str2.equals("")) {
            if (this.f305781b == 1) {
                this.f305782c = a(str2);
                if (QLog.isColorLevel()) {
                    QLog.d("UnifiedTraceRouter", 2, "final ip: " + this.f305782c);
                }
            }
            return str2;
        }
        throw new IllegalArgumentException("ping result is empty");
    }

    public void e(long j3, String str, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, map);
        } else {
            this.f305784e.post(new Runnable(str, j3, map) { // from class: com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f305788d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f305789e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Map f305790f;

                {
                    this.f305788d = str;
                    this.f305789e = j3;
                    this.f305790f = map;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UnifiedTraceRouter.this, str, Long.valueOf(j3), map);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        String d16 = UnifiedTraceRouter.this.d(this.f305788d);
                        StringBuilder sb5 = new StringBuilder();
                        UnifiedTraceRouter unifiedTraceRouter = UnifiedTraceRouter.this;
                        sb5.append(unifiedTraceRouter.f305787h);
                        sb5.append(d16);
                        sb5.append("\n");
                        unifiedTraceRouter.f305787h = sb5.toString();
                        float f16 = UnifiedTraceRouter.this.f305783d;
                        if (!d16.contains("100%") || d16.contains("exceed")) {
                            UnifiedTraceRouter unifiedTraceRouter2 = UnifiedTraceRouter.this;
                            if (unifiedTraceRouter2.f305781b == 32) {
                                String c16 = unifiedTraceRouter2.c(d16);
                                if (!TextUtils.isEmpty(c16)) {
                                    f16 = Float.parseFloat(c16);
                                }
                            }
                        }
                        UnifiedTraceRouter unifiedTraceRouter3 = UnifiedTraceRouter.this;
                        a aVar = new a(unifiedTraceRouter3.b(d16), f16);
                        aVar.f305791a = UnifiedTraceRouter.this.f305781b;
                        try {
                            aVar.f305792b = InetAddress.getByName(aVar.f305793c).getHostName();
                        } catch (UnknownHostException e16) {
                            QLog.e("UnifiedTraceRouter", 1, "UnknownHost error: " + e16.getMessage());
                        }
                        UnifiedTraceRouter.this.f305785f.add(aVar);
                        if (!TextUtils.isEmpty(d16)) {
                            List<a> list = UnifiedTraceRouter.this.f305785f;
                            a aVar2 = list.get(list.size() - 1);
                            if (aVar2.f305793c.equals(UnifiedTraceRouter.this.f305782c)) {
                                UnifiedTraceRouter unifiedTraceRouter4 = UnifiedTraceRouter.this;
                                if (unifiedTraceRouter4.f305781b < 32) {
                                    unifiedTraceRouter4.f305781b = 32;
                                    unifiedTraceRouter4.f305785f.remove(aVar2);
                                    UnifiedTraceRouter.this.f305784e.postDelayed(this, 100L);
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    for (a aVar3 : UnifiedTraceRouter.this.f305785f) {
                                        QLog.d("UnifiedTraceRouter", 2, "ttl: " + aVar3.f305791a + ", " + aVar3.f305792b + ", " + aVar3.f305793c + ", " + aVar3.f305794d + "ms");
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("UnifiedTraceRouter", 2, UnifiedTraceRouter.this.f305787h);
                                }
                                ((SecSpyFileManager) UnifiedTraceRouter.this.f305786g.getManager(QQManagerFactory.SEC_SPY_FILEMANAGER)).m(this.f305789e, this.f305788d, this.f305790f, UnifiedTraceRouter.this.f305785f);
                                UnifiedTraceRouter unifiedTraceRouter5 = UnifiedTraceRouter.this;
                                unifiedTraceRouter5.f305781b = 1;
                                unifiedTraceRouter5.f305785f = new ArrayList();
                                return;
                            }
                            UnifiedTraceRouter unifiedTraceRouter6 = UnifiedTraceRouter.this;
                            int i3 = unifiedTraceRouter6.f305781b;
                            if (i3 < 32) {
                                unifiedTraceRouter6.f305781b = i3 + 1;
                                unifiedTraceRouter6.f305784e.postDelayed(this, 100L);
                            }
                        }
                    } catch (Exception e17) {
                        QLog.e("UnifiedTraceRouter", 1, "traceRoute error: " + e17.getMessage());
                        ((SecSpyFileManager) UnifiedTraceRouter.this.f305786g.getManager(QQManagerFactory.SEC_SPY_FILEMANAGER)).n(this.f305789e, e17.getMessage());
                    }
                }
            });
        }
    }
}
