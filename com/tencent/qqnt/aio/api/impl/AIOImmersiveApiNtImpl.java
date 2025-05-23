package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOImmersiveApi;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOImmersiveApiNtImpl;", "Lcom/tencent/qqnt/aio/api/IAIOImmersiveApi;", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOImmersiveApiNtImpl implements IAIOImmersiveApi {
    static IPatchRedirector $redirector_;

    public AIOImmersiveApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOImmersiveApi
    public boolean enableImmersive(@NotNull com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).booleanValue();
        }
        return IAIOImmersiveApi.a.a(this, aVar);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOImmersiveApi
    @NotNull
    public Pair<Drawable, Drawable> getImmersiveDrawable(@NotNull Context context, @NotNull Drawable drawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, this, context, drawable, Integer.valueOf(i3));
        }
        return IAIOImmersiveApi.a.b(this, context, drawable, i3);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOImmersiveApi
    public boolean getNavigationBarSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return IAIOImmersiveApi.a.c(this);
    }
}
