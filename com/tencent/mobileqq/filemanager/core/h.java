package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.IProxyIpService;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f207651a;

    /* renamed from: b, reason: collision with root package name */
    private String f207652b;

    /* renamed from: c, reason: collision with root package name */
    private Iterator<String> f207653c;

    /* renamed from: d, reason: collision with root package name */
    private List<IProxyIpService.ProxyIp> f207654d;

    /* renamed from: e, reason: collision with root package name */
    private Iterator<IProxyIpService.ProxyIp> f207655e;

    /* renamed from: f, reason: collision with root package name */
    private IProxyIpService.ProxyIp f207656f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f207657g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f207658h = false;

    public h(QQAppInterface qQAppInterface, String str) {
        String substring;
        int indexOf;
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
            this.f207651a = arrayList;
            arrayList.add(str2);
            this.f207653c = this.f207651a.iterator();
            this.f207652b = substring;
        }
        b(qQAppInterface);
    }

    private void b(QQAppInterface qQAppInterface) {
        List<IProxyIpService.ProxyIp> proxyIp = ((IProxyIpService) qQAppInterface.getRuntimeService(IProxyIpService.class, "all")).getProxyIp(5);
        this.f207654d = proxyIp;
        if (proxyIp == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("HttpUrlProcessor", 4, "HttpUrlProcessor: getProxyIp return null, so new empty ProxyList");
            }
            this.f207654d = new ArrayList();
        }
        e();
    }

    public static boolean c(String str) {
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
            int indexOf5 = str2.indexOf(":");
            if (indexOf5 >= 0) {
                str2 = str2.substring(0, indexOf5);
            }
            return d(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || str.length() < 7 || str.length() > 15 || (split = str.split("\\.")) == null || split.length != 4) {
            return false;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            try {
                int parseInt = Integer.parseInt(split[i3]);
                if (parseInt >= 0 && parseInt <= 255) {
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return true;
    }

    public String a() {
        String str;
        String str2;
        List<String> list = this.f207651a;
        if (list != null && list.size() != 0) {
            if (!this.f207653c.hasNext()) {
                if (this.f207655e.hasNext()) {
                    this.f207656f = this.f207655e.next();
                    this.f207653c = this.f207651a.iterator();
                } else if (this.f207657g) {
                    this.f207657g = false;
                    this.f207653c = this.f207651a.iterator();
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
                    }
                    return null;
                }
            }
            String next = this.f207653c.next();
            QLog.e("HttpUrlProcessor", 4, "waterLog- getNextUrl: host[" + next + "]");
            if (this.f207657g) {
                int indexOf = next.indexOf(":");
                if (indexOf > 0) {
                    String substring = next.substring(0, indexOf);
                    str2 = next.substring(indexOf + 1);
                    next = substring;
                } else if (this.f207658h) {
                    str2 = "443";
                } else {
                    str2 = "80";
                }
                if (this.f207658h) {
                    str = "https://" + this.f207656f.f417211ip + ":" + this.f207656f.port + this.f207652b + "&bHost=" + next + "&bPort=" + str2;
                } else {
                    str = "http://" + this.f207656f.f417211ip + ":" + this.f207656f.port + this.f207652b + "&bHost=" + next + "&bPort=" + str2;
                }
            } else if (this.f207658h) {
                str = "https://" + next + this.f207652b;
            } else {
                str = "http://" + next + this.f207652b;
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

    public void e() {
        Iterator<IProxyIpService.ProxyIp> it = this.f207654d.iterator();
        this.f207655e = it;
        if (it.hasNext()) {
            this.f207656f = this.f207655e.next();
            this.f207657g = true;
        } else {
            this.f207657g = false;
        }
        List<String> list = this.f207651a;
        if (list != null) {
            this.f207653c = list.iterator();
        }
    }

    public void f(boolean z16) {
        this.f207658h = z16;
    }

    public h(QQAppInterface qQAppInterface, List<String> list, String str) {
        this.f207651a = list;
        this.f207652b = str;
        if (list != null) {
            this.f207653c = list.iterator();
        }
        b(qQAppInterface);
    }
}
