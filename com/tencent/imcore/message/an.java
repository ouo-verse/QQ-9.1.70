package com.tencent.imcore.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.MD5;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class an {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f116566a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f116566a = new ConcurrentHashMap<>();
        }
    }

    public static String a(String str) {
        if (str == null) {
            str = "0";
        }
        if (f116566a.containsKey(str)) {
            return f116566a.get(str);
        }
        String md5 = MD5.toMD5(str);
        if (f116566a.size() > 3000) {
            f116566a.clear();
        }
        f116566a.put(str, md5);
        return md5;
    }
}
