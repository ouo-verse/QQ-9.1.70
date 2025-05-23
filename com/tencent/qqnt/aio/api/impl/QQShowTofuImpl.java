package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.api.IQQShowTofu;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/QQShowTofuImpl;", "Lcom/tencent/qqnt/aio/api/IQQShowTofu;", "", "id", "", "checkNeedTimeStampForQQShowTofu", "Lcom/tencent/aio/main/businesshelper/h;", "getAIOTofuHelper", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class QQShowTofuImpl implements IQQShowTofu {
    static IPatchRedirector $redirector_;

    public QQShowTofuImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IQQShowTofu
    public boolean checkNeedTimeStampForQQShowTofu(long id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, id5)).booleanValue();
        }
        return ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).checkNeedTimeStampForQQShowTofu(id5);
    }

    @Override // com.tencent.qqnt.aio.api.IQQShowTofu
    @NotNull
    public com.tencent.aio.main.businesshelper.h getAIOTofuHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.main.businesshelper.h) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.mobileqq.aio.helper.r();
    }
}
