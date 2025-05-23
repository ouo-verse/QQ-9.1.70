package com.tencent.qimei.ak;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.aa.f;
import com.tencent.qimei.ap.d;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final Map<String, a> f343048h;

    /* renamed from: a, reason: collision with root package name */
    public final String f343049a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f343050b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f343051c;

    /* renamed from: d, reason: collision with root package name */
    public int f343052d;

    /* renamed from: e, reason: collision with root package name */
    public Qimei f343053e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f343054f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f343055g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18597);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343048h = new ConcurrentHashMap();
        }
    }

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343050b = false;
        this.f343051c = false;
        this.f343052d = 0;
        this.f343049a = str;
    }

    public static synchronized a a(String str) {
        a aVar;
        synchronized (a.class) {
            Map<String, a> map = f343048h;
            aVar = map.get(str);
            if (aVar == null) {
                aVar = new a(str);
                map.put(str, aVar);
            }
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b() {
        long j3;
        long c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f343054f) {
            return this.f343050b;
        }
        Context e16 = d.c().e();
        boolean z16 = false;
        if (e16 != null) {
            try {
                j3 = InstalledAppListMonitor.getPackageInfo(e16.getPackageManager(), e16.getPackageName(), 0).firstInstallTime;
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            c16 = f.b(this.f343049a).c("a_i_t");
            if (c16 != 0) {
                f.b(this.f343049a).a("a_i_t", j3);
            } else if (j3 > c16) {
                z16 = true;
            }
            this.f343054f = true;
            return z16;
        }
        j3 = 0;
        c16 = f.b(this.f343049a).c("a_i_t");
        if (c16 != 0) {
        }
        this.f343054f = true;
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[Catch: all -> 0x00d6, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0006, B:7:0x000c, B:11:0x0018, B:13:0x0024, B:14:0x00c6, B:16:0x00cc, B:22:0x0028, B:25:0x0033, B:27:0x006b, B:28:0x0071, B:35:0x00ae, B:37:0x00b4, B:38:0x00b7, B:39:0x00c3, B:41:0x0088, B:42:0x008f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        this.f343050b = b();
        if (this.f343055g) {
            i3 = this.f343052d;
        } else {
            String canonicalName = a.class.getCanonicalName();
            if (canonicalName == null) {
                canonicalName = "";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cm_");
            sb5.append(com.tencent.qimei.ab.a.b(canonicalName + this.f343049a));
            File file = new File(com.tencent.qimei.u.a.a(sb5.toString()));
            long j3 = 0;
            long lastModified = file.exists() ? file.lastModified() : 0L;
            long c16 = f.b(this.f343049a).c("m_f_m_t");
            if (c16 != 0) {
                if (lastModified == 0) {
                    i16 = 2;
                } else if (lastModified >= c16) {
                    if (lastModified > c16) {
                        i16 = 4;
                    }
                    i16 = 0;
                }
                if (i16 > 0) {
                }
                this.f343055g = true;
                i3 = i16;
            } else if (lastModified != 0) {
                i16 = 1;
                if (i16 > 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    f.b(this.f343049a).a("m_f_m_t");
                }
                this.f343055g = true;
                i3 = i16;
            } else {
                try {
                    file.createNewFile();
                    j3 = file.lastModified();
                } catch (IOException unused) {
                }
                f.b(this.f343049a).a("m_f_m_t", j3);
                i16 = 0;
                if (i16 > 0) {
                }
                this.f343055g = true;
                i3 = i16;
            }
        }
        this.f343052d = i3;
        return (this.f343050b || this.f343051c) && i3 > 0;
    }
}
