package com.tencent.mobileqq.webview.webso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f314993a;

    /* renamed from: b, reason: collision with root package name */
    public String f314994b;

    /* renamed from: c, reason: collision with root package name */
    public String f314995c;

    /* renamed from: d, reason: collision with root package name */
    public String f314996d;

    /* renamed from: e, reason: collision with root package name */
    public String f314997e;

    public a(HttpRsp httpRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) httpRsp);
            return;
        }
        this.f314993a = "\r\n";
        c(httpRsp.rspinfo);
        this.f314997e = httpRsp.body;
    }

    private void a(String str) {
        String[] split;
        if (str != null && str.length() > 0 && (split = str.split(" ")) != null && split.length == 3) {
            this.f314995c = split[0];
            this.f314994b = split[1];
            this.f314996d = split[2];
        }
    }

    private void b(String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            try {
                Field declaredField = HttpRequestPackage.class.getDeclaredField(str);
                if (declaredField != null) {
                    declaredField.set(this, str2);
                }
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
            }
        }
    }

    private void c(String str) {
        try {
            String[] split = str.substring(0, str.indexOf(HttpRsp.HTTP_HEADER_END) - 1).split("\r\n");
            int length = split.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (i3 == 0) {
                    a(split[i3]);
                } else {
                    String str2 = split[i3];
                    int indexOf = str2.indexOf(":");
                    b(str2.substring(0, indexOf).trim(), str2.substring(indexOf + 1, str2.length()));
                }
            }
        } catch (Exception e16) {
            QLog.e("HttpResponsePackage", 1, e16.toString());
        }
    }
}
