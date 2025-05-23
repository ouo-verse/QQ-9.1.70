package com.tencent.mobileqq.uniformdownload.filemanager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.IProxyIpService;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f305986a;

    /* renamed from: b, reason: collision with root package name */
    private String f305987b;

    /* renamed from: c, reason: collision with root package name */
    private Iterator<String> f305988c;

    /* renamed from: d, reason: collision with root package name */
    private List<IProxyIpService.ProxyIp> f305989d;

    /* renamed from: e, reason: collision with root package name */
    private Iterator<IProxyIpService.ProxyIp> f305990e;

    /* renamed from: f, reason: collision with root package name */
    private IProxyIpService.ProxyIp f305991f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f305992g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f305993h;

    public a(AppRuntime appRuntime, String str) {
        String substring;
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        this.f305993h = false;
        int indexOf2 = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        int i3 = indexOf2 != -1 ? indexOf2 + 3 : 0;
        int indexOf3 = str.substring(i3).indexOf("/") + i3;
        String str2 = null;
        if (-1 == indexOf3 && -1 == indexOf3) {
            substring = null;
        } else {
            int indexOf4 = str.indexOf("&bHost=");
            if (-1 != indexOf4 && -1 != (indexOf = str.indexOf("&bPort=", indexOf4))) {
                str2 = str.substring(indexOf4 + 7, indexOf) + ":" + str.substring(indexOf + 7);
            }
            if (str2 == null) {
                str2 = str.substring(i3, indexOf3);
                substring = str.substring(indexOf3);
            } else {
                substring = str.substring(indexOf3, indexOf4);
            }
        }
        if (str2 != null && substring != null) {
            ArrayList arrayList = new ArrayList(1);
            this.f305986a = arrayList;
            arrayList.add(str2);
            this.f305988c = this.f305986a.iterator();
            this.f305987b = substring;
        }
        b(appRuntime);
    }

    private void b(AppRuntime appRuntime) {
        List<IProxyIpService.ProxyIp> proxyIp = ((IProxyIpService) appRuntime.getRuntimeService(IProxyIpService.class, "all")).getProxyIp(5);
        this.f305989d = proxyIp;
        if (proxyIp == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("HttpUrlProcessor", 4, "HttpUrlProcessor: getProxyIp return null, so new empty ProxyList");
            }
            this.f305989d = new ArrayList();
        }
        c();
    }

    public String a() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        List<String> list = this.f305986a;
        if (list != null && list.size() != 0) {
            if (!this.f305988c.hasNext()) {
                if (this.f305990e.hasNext()) {
                    this.f305991f = this.f305990e.next();
                    this.f305988c = this.f305986a.iterator();
                } else if (this.f305992g) {
                    this.f305992g = false;
                    this.f305988c = this.f305986a.iterator();
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
                    }
                    return null;
                }
            }
            String next = this.f305988c.next();
            QLog.e("HttpUrlProcessor", 4, "waterLog- getNextUrl: host[" + next + "]");
            if (this.f305992g) {
                int indexOf = next.indexOf(":");
                if (indexOf > 0) {
                    String substring = next.substring(0, indexOf);
                    str2 = next.substring(indexOf + 1);
                    next = substring;
                } else if (this.f305993h) {
                    str2 = "443";
                } else {
                    str2 = "80";
                }
                if (this.f305993h) {
                    str = "https://" + this.f305991f.f417211ip + ":" + this.f305991f.port + this.f305987b + "&bHost=" + next + "&bPort=" + str2;
                } else {
                    str = "http://" + this.f305991f.f417211ip + ":" + this.f305991f.port + this.f305987b + "&bHost=" + next + "&bPort=" + str2;
                }
            } else if (this.f305993h) {
                str = "https://" + next + this.f305987b;
            } else {
                str = "http://" + next + this.f305987b;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("HttpUrlProcessor", 4, "getNextUrl: url:" + str);
            }
            return str;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("HttpUrlProcessor", 4, "getNextUrl: no host, so return null");
        }
        return null;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<IProxyIpService.ProxyIp> it = this.f305989d.iterator();
        this.f305990e = it;
        if (it.hasNext()) {
            this.f305991f = this.f305990e.next();
            this.f305992g = true;
        } else {
            this.f305992g = false;
        }
        List<String> list = this.f305986a;
        if (list != null) {
            this.f305988c = list.iterator();
        }
    }
}
