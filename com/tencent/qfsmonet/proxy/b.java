package com.tencent.qfsmonet.proxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.IMonetProcessor;
import com.tencent.qfsmonet.api.IMonetProxyFactory;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.inputstream.IMonetSurfaceInputStream;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import com.tencent.qfsmonet.api.outputstream.IMonetSurfaceOutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements IMonetProxyFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.qfsmonet.proxy.a f342620a;

    /* compiled from: P */
    /* renamed from: com.tencent.qfsmonet.proxy.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private static class C9302b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static b f342621a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26389);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f342621a = new b(null);
            }
        }
    }

    /* synthetic */ b(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
    }

    public static b a() {
        return C9302b.f342621a;
    }

    @Override // com.tencent.qfsmonet.api.IMonetProxyFactory
    @NonNull
    public IMonetProcessor createMonetProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IMonetProcessor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.qfsmonet.proxy.a.a();
    }

    @Override // com.tencent.qfsmonet.api.IMonetProxyFactory
    @Nullable
    public IMonetSingleInputModule createSingleInputModule(@NonNull MonetContext monetContext, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IMonetSingleInputModule) iPatchRedirector.redirect((short) 5, (Object) this, (Object) monetContext, (Object) str);
        }
        return com.tencent.qfsmonet.proxy.a.b(monetContext, str);
    }

    @Override // com.tencent.qfsmonet.api.IMonetProxyFactory
    @NonNull
    public IMonetSurfaceInputStream createSurfaceInputStream(@NonNull MonetContext monetContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IMonetSurfaceInputStream) iPatchRedirector.redirect((short) 3, (Object) this, (Object) monetContext);
        }
        return com.tencent.qfsmonet.proxy.a.c(monetContext);
    }

    @Override // com.tencent.qfsmonet.api.IMonetProxyFactory
    @Nullable
    public IMonetSurfaceOutputStream createSurfaceOutputStream(@NonNull MonetContext monetContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IMonetSurfaceOutputStream) iPatchRedirector.redirect((short) 4, (Object) this, (Object) monetContext);
        }
        return com.tencent.qfsmonet.proxy.a.d(monetContext);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342620a = null;
            this.f342620a = new com.tencent.qfsmonet.proxy.a();
        }
    }
}
