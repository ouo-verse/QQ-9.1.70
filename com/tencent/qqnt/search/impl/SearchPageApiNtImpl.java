package com.tencent.qqnt.search.impl;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.search.ISearchPageApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/search/impl/SearchPageApiNtImpl;", "Lcom/tencent/qqnt/search/ISearchPageApi;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class SearchPageApiNtImpl implements ISearchPageApi {
    static IPatchRedirector $redirector_;

    public SearchPageApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.search.ISearchPageApi
    public void openSearchPageApi(@NotNull ISearchPageApi.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            ISearchPageApi.a.a(this, bVar);
        }
    }
}
