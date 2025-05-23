package com.tencent.msdk.dns.base.jni;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.base.log.c;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpDnsImpl;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16692);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        try {
            System.loadLibrary(TVKOKHttpDnsImpl.DnsResolverType.HTTP_DNS);
        } catch (Throwable unused) {
            c.i("Load dns so failed", new Object[0]);
        }
    }

    public static int a() {
        try {
            return Jni.getNetworkStack();
        } catch (Throwable unused) {
            c.i("Get cur network stack failed", new Object[0]);
            return 0;
        }
    }

    public static int b(String str) {
        try {
            return Jni.sendToUnity(str);
        } catch (Throwable unused) {
            c.i("sendToUnity failed", new Object[0]);
            return -4;
        }
    }

    public static byte[] c(byte[] bArr, String str, int i3) {
        try {
            return Jni.desCrypt(bArr, str, i3);
        } catch (Throwable unused) {
            c.i("dnsCrypt failed", new Object[0]);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, String str, int i3, byte[] bArr2) {
        try {
            return Jni.aesCrypt(bArr, str, i3, bArr2);
        } catch (Throwable unused) {
            c.i("dnsCrypt failed", new Object[0]);
            return null;
        }
    }
}
