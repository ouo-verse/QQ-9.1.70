package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IPicLoaderApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PicLoaderApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IPicLoaderApi;", "()V", "getLoadResultListener", "Lcom/tencent/libra/listener/ILoaderResultListener;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class PicLoaderApiNtImpl implements IPicLoaderApi {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/PicLoaderApiNtImpl$a", "Lcom/tencent/libra/listener/ILoaderResultListener;", "Lcom/tencent/libra/request/Option;", "option", "", "retCode", "", "onDownloadResult", "onDecodeResult", "onLoadResult", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements ILoaderResultListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.libra.listener.ILoaderResultListener
        public void onDecodeResult(@NotNull Option option, int retCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) option, retCode);
            } else {
                Intrinsics.checkNotNullParameter(option, "option");
            }
        }

        @Override // com.tencent.libra.listener.ILoaderResultListener
        public void onDownloadResult(@NotNull Option option, int retCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) option, retCode);
            } else {
                Intrinsics.checkNotNullParameter(option, "option");
            }
        }

        @Override // com.tencent.libra.listener.ILoaderResultListener
        public void onLoadResult(@NotNull Option option, int retCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) option, retCode);
            } else {
                Intrinsics.checkNotNullParameter(option, "option");
            }
        }
    }

    public PicLoaderApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPicLoaderApi
    @NotNull
    public ILoaderResultListener getLoadResultListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ILoaderResultListener) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }
}
