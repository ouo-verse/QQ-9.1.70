package com.tencent.lyric.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f147091a;

    /* renamed from: b, reason: collision with root package name */
    public static int f147092b;

    /* renamed from: c, reason: collision with root package name */
    public static int f147093c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f147091a = 0;
        f147092b = 1;
        f147093c = 2;
    }
}
