package com.tencent.qqnt.search.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.quicksearch.QuickSearchHelper;
import com.tencent.qqnt.search.api.IAIOHashTagSearchLinkApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/search/api/impl/AIOHashTagSearchLinkApiImpl;", "Lcom/tencent/qqnt/search/api/IAIOHashTagSearchLinkApi;", "()V", "newInputHelper", "Lcom/tencent/mobileqq/search/quicksearch/QuickSearchHelper;", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AIOHashTagSearchLinkApiImpl implements IAIOHashTagSearchLinkApi {
    static IPatchRedirector $redirector_;

    public AIOHashTagSearchLinkApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.search.api.IAIOHashTagSearchLinkApi
    @NotNull
    public QuickSearchHelper newInputHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new QuickSearchHelper() : (QuickSearchHelper) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
