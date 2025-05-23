package com.tencent.hlyyb.downloader.a.a;

import com.tencent.hlyyb.downloader.a.a.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends a {
    static IPatchRedirector $redirector_;

    public d(com.tencent.hlyyb.downloader.e.f.a aVar, Map<String, String> map, a.C5817a c5817a, boolean z16, com.tencent.hlyyb.downloader.a.a aVar2, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, map, c5817a, Boolean.valueOf(z16), aVar2, Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        this.f114388y = aVar2;
        this.f114365b = aVar;
        this.f114370g = map;
        this.f114374k = z16;
        this.f114366c = z17;
        if (c5817a != null) {
            a(c5817a);
        }
        this.f114364a = i3;
    }
}
