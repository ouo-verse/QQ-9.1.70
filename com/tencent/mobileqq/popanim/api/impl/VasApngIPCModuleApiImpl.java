package com.tencent.mobileqq.popanim.api.impl;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.popanim.api.IVasApngIPCModuleApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.an;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/popanim/api/impl/VasApngIPCModuleApiImpl;", "Lcom/tencent/mobileqq/popanim/api/IVasApngIPCModuleApi;", "()V", "isLoaded", "", "load", "", "adapter", "Lcom/tencent/image/URLDrawableHandler$Adapter;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class VasApngIPCModuleApiImpl implements IVasApngIPCModuleApi {
    static IPatchRedirector $redirector_;

    public VasApngIPCModuleApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.popanim.api.IVasApngIPCModuleApi
    public boolean isLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return an.h().isLoaded();
    }

    @Override // com.tencent.mobileqq.popanim.api.IVasApngIPCModuleApi
    public void load(@NotNull URLDrawableHandler.Adapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapter);
        } else {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            an.h().load(adapter);
        }
    }
}
