package com.tencent.halley.common.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Object f113390a;

    /* renamed from: b, reason: collision with root package name */
    protected a f113391b;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z16, Object obj);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract boolean a(byte[] bArr, int i3, boolean z16, Object obj, a aVar, int i16);
}
