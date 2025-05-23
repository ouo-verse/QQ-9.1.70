package com.tencent.relation.common.servlet.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.relation.common.servlet.IRelationSSORequestHandler;
import com.tencent.relation.common.servlet.RelationSSORequestHandler;
import com.tencent.relation.common.servlet.c;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationSSORequestHandlerImpl implements IRelationSSORequestHandler {
    static IPatchRedirector $redirector_;

    public RelationSSORequestHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.servlet.IRelationSSORequestHandler
    public void request(AppRuntime appRuntime, String str, byte[] bArr, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, str, bArr, cVar);
        } else {
            RelationSSORequestHandler.a().b(appRuntime, str, bArr, cVar);
        }
    }
}
