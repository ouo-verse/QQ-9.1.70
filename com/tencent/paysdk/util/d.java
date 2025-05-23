package com.tencent.paysdk.util;

import androidx.annotation.RestrictTo;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Gson f342087a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8156);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342087a = new Gson();
        }
    }

    public static <T> T a(String str, Class<T> cls) {
        return (T) f342087a.fromJson(str, (Class) cls);
    }

    public static <T> String b(T t16) {
        return f342087a.toJson(t16);
    }
}
