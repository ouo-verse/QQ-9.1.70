package com.tencent.halley.downloader.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f113690a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, e> f113691b;

    public d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f113690a = "";
        this.f113691b = new HashMap();
        this.f113690a = str;
    }

    public final void a(Map<String, com.tencent.halley.downloader.d.a> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        if (map != null && !map.isEmpty()) {
            this.f113691b.clear();
            for (Map.Entry<String, com.tencent.halley.downloader.d.a> entry : map.entrySet()) {
                this.f113691b.put(entry.getKey(), new e(entry.getValue()));
            }
            return;
        }
        com.tencent.halley.common.utils.d.c("IPPool", "input ipInfos is empty or null");
    }
}
