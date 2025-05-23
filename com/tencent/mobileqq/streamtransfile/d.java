package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, c> f290266a;

    /* renamed from: b, reason: collision with root package name */
    private static List<String> f290267b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f290266a = new HashMap<>();
            f290267b = new ArrayList();
        }
    }

    public static List<String> a() {
        return f290267b;
    }

    public static HashMap<String, c> b() {
        return f290266a;
    }
}
