package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class eCoqw {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f382206a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382206a = new LinkedHashSet();
        }
    }

    public static int a() {
        Set<String> set = f382206a;
        if (set.isEmpty()) {
            set.add(LwgsO.a(LwgsO.U0));
            set.add(LwgsO.a(LwgsO.V0));
            set.add(LwgsO.a(LwgsO.W0));
            set.add(LwgsO.a(LwgsO.X0));
            set.add(LwgsO.a(LwgsO.Y0));
            set.add(LwgsO.a(LwgsO.Z0));
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
