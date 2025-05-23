package com.tencent.mobileqq.fts.v2.tokenizer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Reader;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Reader f211795a;

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
