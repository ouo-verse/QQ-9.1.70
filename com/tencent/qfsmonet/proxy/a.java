package com.tencent.qfsmonet.proxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.IMonetProcessor;
import com.tencent.qfsmonet.api.MonetContext;
import com.tencent.qfsmonet.api.inputstream.IMonetSurfaceInputStream;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import com.tencent.qfsmonet.api.outputstream.IMonetSurfaceOutputStream;
import com.tencent.qfsmonet.inputstream.d;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.process.q;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public static IMonetProcessor a() {
        return new q();
    }

    @Nullable
    public static IMonetSingleInputModule b(@NonNull MonetContext monetContext, String str) {
        try {
            return (IMonetSingleInputModule) Class.forName(MonetModuleInner.class.getPackage().getName() + "." + str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b("MonetFactory", "createSingleInputModule failed, ex=" + e16.toString());
            return null;
        }
    }

    @NonNull
    public static IMonetSurfaceInputStream c(@NonNull MonetContext monetContext) {
        return new d(monetContext);
    }

    @Nullable
    public static IMonetSurfaceOutputStream d(@NonNull MonetContext monetContext) {
        com.tencent.qfsmonet.outputstream.b bVar = new com.tencent.qfsmonet.outputstream.b(monetContext);
        if (bVar.c()) {
            return bVar;
        }
        return null;
    }
}
