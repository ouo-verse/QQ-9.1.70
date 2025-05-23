package com.tencent.mobileqq.qqperftool.common;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Boolean f274251a;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f274252b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10250);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274251a = Boolean.TRUE;
            f274252b = new HashSet();
        }
    }

    public static void a(@NonNull String str, @NonNull String str2) {
        if (f274251a.booleanValue()) {
            e.a(str, str2);
            return;
        }
        Set<String> set = f274252b;
        if (set.size() > 0 && set.contains(str)) {
            e.a(str, str2);
        }
    }
}
