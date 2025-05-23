package com.tencent.mobileqq.unitedconfig_android.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IFreesiaFetcher;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/api/impl/FreesiaFetcherImpl;", "Lcom/tencent/mobileqq/unitedconfig_android/api/IFreesiaFetcher;", "()V", "fetchAll", "", "fetchNoLogin", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class FreesiaFetcherImpl implements IFreesiaFetcher {
    static IPatchRedirector $redirector_;

    public FreesiaFetcherImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IFreesiaFetcher
    public void fetchAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNull(api, "null cannot be cast to non-null type com.tencent.mobileqq.unitedconfig_android.api.impl.UnitedConfigManagerImpl");
        ((UnitedConfigManagerImpl) api).fetchAll();
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.api.IFreesiaFetcher
    public void fetchNoLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNull(api, "null cannot be cast to non-null type com.tencent.mobileqq.unitedconfig_android.api.impl.UnitedConfigManagerImpl");
        ((UnitedConfigManagerImpl) api).fetchNoLogin();
    }
}
