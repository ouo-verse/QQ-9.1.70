package com.tencent.halley.common.d.b.b.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public byte f113480a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f113481b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, byte[]> f113482c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f113483d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113480a = (byte) 0;
        this.f113481b = null;
        this.f113482c = null;
        this.f113483d = null;
    }
}
