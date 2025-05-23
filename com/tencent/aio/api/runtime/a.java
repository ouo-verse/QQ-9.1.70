package com.tencent.aio.api.runtime;

import androidx.annotation.MainThread;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.runtime.b;
import kotlin.Deprecated;
import ts.d;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a extends b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @MainThread
    public abstract ts.a f();

    public abstract AIOParam g();

    @Deprecated(message = "\u5e9f\u5f03, \u4e0d\u518d\u7ef4\u62a4")
    public abstract c h();

    public abstract d i();
}
