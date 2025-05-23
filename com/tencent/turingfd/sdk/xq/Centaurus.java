package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Centaurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f382648a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(EmojiHomeUiPlugin.HOMEPAGE_RDM_EVENT_MANY_REQUESTS);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382648a = new LinkedHashSet();
        }
    }

    public static int a() {
        Set<String> set = f382648a;
        if (set.isEmpty()) {
            set.add(Ccontinue.a(Ccontinue.U0));
            set.add(Ccontinue.a(Ccontinue.V0));
            set.add(Ccontinue.a(Ccontinue.W0));
            set.add(Ccontinue.a(Ccontinue.X0));
            set.add(Ccontinue.a(Ccontinue.Y0));
            set.add(Ccontinue.a(Ccontinue.Z0));
        }
        Iterator<String> it = set.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            try {
                Class.forName(it.next());
                i3 |= 1 << i16;
            } catch (Throwable unused) {
            }
            i16++;
        }
        return i3;
    }
}
