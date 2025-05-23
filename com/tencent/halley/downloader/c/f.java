package com.tencent.halley.downloader.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final f f113695a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12212);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f113695a = new f((byte) 0);
            }
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static Map<String, com.tencent.halley.downloader.d.a> a(List<String> list) {
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3);
            try {
                hashMap.put(str, com.tencent.halley.downloader.g.a.a(InetAddress.getAllByName(str)));
            } catch (UnknownHostException e16) {
                e16.printStackTrace();
            }
        }
        return hashMap;
    }

    /* synthetic */ f(byte b16) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
    }
}
