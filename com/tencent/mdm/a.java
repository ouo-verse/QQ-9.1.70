package com.tencent.mdm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f151494a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f151494a = new ConcurrentHashMap<>();
        }
    }

    public static String a(String str) {
        String str2 = f151494a.get(str);
        if (str2 == null && (str2 = SecUtil.getFileMd5(new File(str))) != null) {
            f151494a.put(str, str2);
        }
        return str2;
    }
}
