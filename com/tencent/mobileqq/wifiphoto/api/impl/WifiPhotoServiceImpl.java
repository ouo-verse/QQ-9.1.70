package com.tencent.mobileqq.wifiphoto.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/api/impl/WifiPhotoServiceImpl;", "Lcom/tencent/mobileqq/wifiphoto/api/IWifiPhotoService;", "()V", "disconnect", "", "enterWifiPhoto", "context", "Landroid/content/Context;", "page", "", "source", "", "init", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class WifiPhotoServiceImpl implements IWifiPhotoService {
    static IPatchRedirector $redirector_;

    public WifiPhotoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService
    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.B();
        }
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService
    public void enterWifiPhoto(@NotNull Context context, @NotNull String page, int source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, page, Integer.valueOf(source));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(page, "page");
        com.tencent.mobileqq.wifiphoto.impl.global.f.D(com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a, context, page, source, 0, 8, null);
    }

    @Override // com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            com.tencent.mobileqq.wifiphoto.impl.global.f.f317624a.G();
        }
    }
}
