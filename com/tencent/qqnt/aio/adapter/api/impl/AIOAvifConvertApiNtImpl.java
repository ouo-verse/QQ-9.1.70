package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOAvifConvertApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOAvifConvertApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOAvifConvertApi;", "()V", "convertAvif2Jpg", "", "srcPath", "picWidth", "", "picHeight", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOAvifConvertApiNtImpl implements IAIOAvifConvertApi {
    static IPatchRedirector $redirector_;

    public AIOAvifConvertApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvifConvertApi
    @NotNull
    public String convertAvif2Jpg(@NotNull String srcPath, long picWidth, long picHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, srcPath, Long.valueOf(picWidth), Long.valueOf(picHeight));
        }
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        return srcPath;
    }
}
