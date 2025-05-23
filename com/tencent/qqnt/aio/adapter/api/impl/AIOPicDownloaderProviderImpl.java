package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.libra.download.ILibraDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.NTLibraDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOPicDownloaderProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPicDownloaderProviderImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOPicDownloaderProvider;", "()V", "provideDownloader", "Lcom/tencent/libra/download/ILibraDownloader;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOPicDownloaderProviderImpl implements IAIOPicDownloaderProvider {
    static IPatchRedirector $redirector_;

    public AIOPicDownloaderProviderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPicDownloaderProvider
    @NotNull
    public ILibraDownloader provideDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ILibraDownloader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return NTLibraDownloader.f190586d;
    }
}
