package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f305109a;

    /* renamed from: b, reason: collision with root package name */
    private String f305110b;

    /* renamed from: c, reason: collision with root package name */
    private Iterator<String> f305111c;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f305112d;

    /* renamed from: e, reason: collision with root package name */
    private Iterator<a> f305113e;

    /* renamed from: f, reason: collision with root package name */
    private a f305114f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f305115g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f305116h;

    /* renamed from: i, reason: collision with root package name */
    private String f305117i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f305118a;

        /* renamed from: b, reason: collision with root package name */
        public int f305119b;

        /* renamed from: c, reason: collision with root package name */
        public int f305120c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "[" + this.f305118a + ":" + this.f305119b + ":" + this.f305120c + "]";
        }
    }

    public b(AppRuntime appRuntime, List<String> list, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, list, str, Boolean.valueOf(z16));
            return;
        }
        this.f305116h = false;
        this.f305117i = " ";
        this.f305109a = list;
        this.f305110b = str;
        if (list != null) {
            this.f305111c = list.iterator();
        }
        this.f305116h = z16;
        b(appRuntime);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init urlProcessor. hostNum:");
        List<String> list2 = this.f305109a;
        sb5.append(list2 != null ? list2.size() : 0);
        sb5.append(" proxyIps:");
        sb5.append(this.f305117i);
        sb5.append(" params:");
        sb5.append(this.f305110b);
        sb5.append(" isHttps:");
        sb5.append(z16);
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHttpUrlProcessor", 1, sb5.toString());
    }

    private void b(AppRuntime appRuntime) {
        List<a> m3 = com.tencent.mobileqq.uftransfer.depend.a.m(appRuntime);
        this.f305112d = m3;
        if (m3 == null) {
            this.f305112d = new ArrayList();
        } else {
            this.f305117i = "";
            for (int i3 = 0; i3 < this.f305112d.size(); i3++) {
                a aVar = this.f305112d.get(i3);
                if (aVar != null) {
                    this.f305117i += aVar.toString();
                }
            }
        }
        g();
    }

    public static boolean c(String str) {
        if (!e(str) && !f(str)) {
            return false;
        }
        return true;
    }

    public static boolean d(String str) {
        int i3;
        String str2;
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            int indexOf2 = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            if (indexOf2 == -1) {
                i3 = 0;
            } else {
                i3 = indexOf2 + 3;
            }
            String substring = str.substring(i3);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            int indexOf3 = substring.indexOf("/");
            if (-1 == indexOf3) {
                indexOf3 = substring.length() - 1;
            }
            int i16 = indexOf3 + i3;
            int indexOf4 = str.indexOf("&bHost=");
            if (-1 == indexOf4 || -1 == (indexOf = str.indexOf("&bPort=", indexOf4))) {
                str2 = null;
            } else {
                str2 = str.substring(indexOf4 + 7, indexOf) + ":" + str.substring(indexOf + 7);
            }
            if (str2 == null) {
                str2 = str.substring(i3, i16);
            }
            if (str2 == null) {
                return false;
            }
            int lastIndexOf = str2.lastIndexOf(":");
            if (lastIndexOf >= 0) {
                str2 = str2.substring(0, lastIndexOf);
            }
            return c(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || str.length() < 7 || str.length() > 15 || (split = str.split("\\.")) == null || split.length != 4) {
            return false;
        }
        return IPAddressUtil.isIPv4LiteralAddress(str);
    }

    public static boolean f(String str) {
        return IPAddressUtil.isIPv6LiteralAddress(str);
    }

    private void g() {
        Iterator<a> it = this.f305112d.iterator();
        this.f305113e = it;
        if (it.hasNext()) {
            this.f305114f = this.f305113e.next();
            this.f305115g = true;
        } else {
            this.f305115g = false;
        }
        List<String> list = this.f305109a;
        if (list != null) {
            this.f305111c = list.iterator();
        }
    }

    public String a() {
        Iterator<String> it;
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<String> list = this.f305109a;
        if (list != null && list.size() != 0 && (it = this.f305111c) != null) {
            if (!it.hasNext()) {
                if (this.f305113e.hasNext()) {
                    this.f305114f = this.f305113e.next();
                    this.f305111c = this.f305109a.iterator();
                } else if (this.f305115g) {
                    this.f305115g = false;
                    this.f305111c = this.f305109a.iterator();
                } else {
                    com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHttpUrlProcessor", 1, "getNextUrl: no proxy no host, so return null");
                    return null;
                }
            }
            String next = this.f305111c.next();
            if (this.f305115g) {
                int lastIndexOf = next.lastIndexOf(":");
                if (lastIndexOf > 0) {
                    str3 = next.substring(0, lastIndexOf);
                    str2 = next.substring(lastIndexOf + 1);
                } else {
                    if (this.f305116h) {
                        str2 = "443";
                    } else {
                        str2 = "80";
                    }
                    str3 = next;
                }
                if (this.f305116h) {
                    str = "https://" + this.f305114f.f305118a + ":" + this.f305114f.f305119b + this.f305110b + "&bHost=" + str3 + "&bPort=" + str2;
                } else {
                    str = "http://" + this.f305114f.f305118a + ":" + this.f305114f.f305119b + this.f305110b + "&bHost=" + str3 + "&bPort=" + str2;
                }
            } else if (this.f305116h) {
                str = "https://" + next + this.f305110b;
            } else {
                str = "http://" + next + this.f305110b;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHttpUrlProcessor", 1, "getNextUrl: url:" + str + " host:" + next);
            return str;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpUrlProcessor", 1, "getNextUrl: no host, so return null");
        return null;
    }
}
