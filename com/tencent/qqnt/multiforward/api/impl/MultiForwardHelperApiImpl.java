package com.tencent.qqnt.multiforward.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.helper.z;
import com.tencent.qqnt.multiforward.api.IMultiForwardHelperApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/multiforward/api/impl/MultiForwardHelperApiImpl;", "Lcom/tencent/qqnt/multiforward/api/IMultiForwardHelperApi;", "", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MultiForwardHelperApiImpl implements IMultiForwardHelperApi {
    static IPatchRedirector $redirector_;

    public MultiForwardHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.multiforward.api.IMultiForwardHelperApi
    @NotNull
    public h[] getLifeCycleHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new h[]{new z()};
    }
}
