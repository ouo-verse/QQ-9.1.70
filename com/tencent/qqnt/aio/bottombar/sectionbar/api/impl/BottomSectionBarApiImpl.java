package com.tencent.qqnt.aio.bottombar.sectionbar.api.impl;

import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarVB;
import com.tencent.qqnt.aio.bottombar.sectionbar.api.IBottomSectionBarApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0004\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/api/impl/BottomSectionBarApiImpl;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/api/IBottomSectionBarApi;", "Lcom/tencent/aio/base/mvvm/a;", "", "getBottomSectionBarVB", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class BottomSectionBarApiImpl implements IBottomSectionBarApi {
    static IPatchRedirector $redirector_;

    public BottomSectionBarApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.api.IBottomSectionBarApi
    @NotNull
    public a<Object, Object> getBottomSectionBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new BottomSectionBarVB();
    }
}
