package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.activity.specialcare.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, List<g.a>> f186572a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<String, g.a> f186573b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40958);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f186572a = new HashMap<>();
            f186573b = new HashMap<>();
        }
    }
}
