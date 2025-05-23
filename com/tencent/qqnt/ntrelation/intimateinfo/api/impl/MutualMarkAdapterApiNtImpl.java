package com.tencent.qqnt.ntrelation.intimateinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IMutualMarkAdapterApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/MutualMarkAdapterApiNtImpl;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IMutualMarkAdapterApi;", "()V", "upgradeIconUrlToVersion2", "", "url", "contacts_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class MutualMarkAdapterApiNtImpl implements IMutualMarkAdapterApi {
    static IPatchRedirector $redirector_;

    public MutualMarkAdapterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IMutualMarkAdapterApi
    @Nullable
    public String upgradeIconUrlToVersion2(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        return "";
    }
}
