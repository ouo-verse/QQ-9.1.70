package com.tencent.qimei.j;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f343319a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f343319a = Uri.parse("content://cn.nubia.identity/identity");
        }
    }
}
