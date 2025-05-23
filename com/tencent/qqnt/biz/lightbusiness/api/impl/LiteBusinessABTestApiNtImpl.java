package com.tencent.qqnt.biz.lightbusiness.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.biz.lightbusiness.api.ILiteBusinessABTestApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/api/impl/LiteBusinessABTestApiNtImpl;", "Lcom/tencent/qqnt/biz/lightbusiness/api/ILiteBusinessABTestApi;", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class LiteBusinessABTestApiNtImpl implements ILiteBusinessABTestApi {
    static IPatchRedirector $redirector_;

    public LiteBusinessABTestApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.api.ILiteBusinessABTestApi
    @NotNull
    public String getForceMsgListShowIdStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ILiteBusinessABTestApi.a.a(this);
    }
}
