package com.tencent.qqnt.biz.lightbusiness.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.biz.lightbusiness.api.ILiteBusinessABTestApi;
import com.tencent.qqnt.lightbusinesskit.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/api/impl/LiteBusinessABTestApiImpl;", "Lcom/tencent/qqnt/biz/lightbusiness/api/ILiteBusinessABTestApi;", "()V", "getForceMsgListShowIdStr", "", "qq-light-business-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class LiteBusinessABTestApiImpl implements ILiteBusinessABTestApi {
    static IPatchRedirector $redirector_;

    public LiteBusinessABTestApiImpl() {
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
        return a.f359319a.e();
    }
}
