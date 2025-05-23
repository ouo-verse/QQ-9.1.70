package com.tencent.centaur.host.loader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f99082a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f99083b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("myths");
        String str = File.separator;
        sb5.append(str);
        f99082a = sb5.toString();
        f99083b = "myths" + str + "centaur-diff" + str;
    }
}
