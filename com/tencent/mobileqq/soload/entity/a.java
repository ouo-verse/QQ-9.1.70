package com.tencent.mobileqq.soload.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.util.f;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f288683a;

    /* renamed from: b, reason: collision with root package name */
    public int f288684b;

    /* renamed from: c, reason: collision with root package name */
    public long f288685c;

    /* renamed from: d, reason: collision with root package name */
    public List<Long> f288686d;

    /* renamed from: e, reason: collision with root package name */
    public long f288687e;

    /* renamed from: f, reason: collision with root package name */
    public int f288688f;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f288686d = new LinkedList();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            a aVar = new a();
            Uri parse = Uri.parse(str);
            aVar.f288683a = parse.getQueryParameter("ver");
            aVar.f288684b = k(parse.getQueryParameter("loadCTs"), 0);
            aVar.f288685c = l(parse.getQueryParameter("lastLCT"), 0L);
            aVar.f288686d = j(parse.getQueryParameters("prc"));
            aVar.f288687e = l(parse.getQueryParameter("runCPT"), 0L);
            aVar.f288688f = k(parse.getQueryParameter("runCTs"), 0);
            return aVar;
        } catch (Throwable th5) {
            QLog.e("SoLoadWidget.SoCrashInfo", 1, th5, new Object[0]);
            return null;
        }
    }

    public static void c(String str, String str2, int i3) {
        a i16 = f.i(str, str2);
        if (i16 == null) {
            i16 = new a(str2);
        }
        if (i3 == 1) {
            int i17 = i16.f288688f + 1;
            i16.f288688f = i17;
            if (i17 >= 999) {
                i16.f288688f = 0;
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            i16.f288686d.add(Long.valueOf(serverTimeMillis));
            if (i16.f288686d.size() >= 3) {
                if (Math.abs(serverTimeMillis - i16.f288686d.get(0).longValue()) <= 1800000) {
                    i16.f288687e = serverTimeMillis;
                } else {
                    while (i16.f288686d.size() >= 3) {
                        i16.f288686d.remove(0);
                    }
                }
            }
            f.P(i16, str);
            return;
        }
        if (i3 == 0) {
            int i18 = i16.f288684b + 1;
            i16.f288684b = i18;
            if (i18 > 2) {
                com.tencent.mobileqq.soload.config.a.b().h(str, str2);
                f.c(str);
                f.K(str);
            } else {
                if (i18 == 1) {
                    i16.f288685c = NetConnInfoCenter.getServerTimeMillis();
                }
                f.P(i16, str);
            }
        }
    }

    private static List<Long> j(List<String> list) {
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                long l3 = l(it.next(), 0L);
                if (l3 > 0) {
                    linkedList.add(Long.valueOf(l3));
                }
            }
        }
        if (linkedList.size() > 1) {
            Collections.sort(linkedList);
        }
        return linkedList;
    }

    private static int k(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable unused) {
            }
        }
        return i3;
    }

    private static long l(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (Throwable unused) {
            }
        }
        return j3;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.append("ver=");
        sb5.append(this.f288683a);
        sb5.append("&loadCTs=");
        sb5.append(this.f288684b);
        sb5.append("&lastLCT=");
        sb5.append(this.f288685c);
        sb5.append("&runCTs=");
        sb5.append(this.f288688f);
        sb5.append("&runCPT=");
        sb5.append(this.f288687e);
        Iterator<Long> it = this.f288686d.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            sb5.append("&prc=");
            sb5.append(longValue);
        }
        return sb5.toString();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f288684b >= 2 && Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.f288685c) < 21600000) {
            return true;
        }
        return false;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f288684b >= 2 && Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.f288685c) >= 21600000) {
            return true;
        }
        return false;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f288687e > 0) {
            return true;
        }
        return false;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (f() && Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.f288687e) <= 7200000) {
            return true;
        }
        return false;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (e() || f() || i()) {
            return true;
        }
        return false;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        int i3 = this.f288688f;
        if (i3 > 0 && i3 % 3 == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "SoCrashInfo{mSoVer='" + this.f288683a + "', mLoadCrashTimes=" + this.f288684b + ", mFirstLoadCrashTime=" + this.f288685c + ", mRunCrashProtectTime=" + this.f288687e + ", mPreRunCrashTimes=" + this.f288686d + ", mRunCrashTimes=" + this.f288688f + '}';
    }

    a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f288686d = new LinkedList();
            this.f288683a = str;
        }
    }
}
