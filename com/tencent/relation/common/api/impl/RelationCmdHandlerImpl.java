package com.tencent.relation.common.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationCmdHandler;
import com.tencent.relation.common.servlet.RelationRequestHandler;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationCmdHandlerImpl implements IRelationCmdHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RelationCmdHandlerImpl";

    public RelationCmdHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.api.IRelationCmdHandler
    public String getRelationRequestHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return RelationRequestHandler.f364746h;
    }

    @Override // com.tencent.relation.common.api.IRelationCmdHandler
    public void sendRequest(AppInterface appInterface, String str, byte[] bArr, com.tencent.relation.common.servlet.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, str, bArr, bVar);
            return;
        }
        RelationRequestHandler relationRequestHandler = (RelationRequestHandler) appInterface.getBusinessHandler(RelationRequestHandler.f364746h);
        if (relationRequestHandler == null) {
            QLog.e(TAG, 2, "sendRequest error handler is null,cmd = " + str);
            bVar.onUpdate(0, false, null);
            return;
        }
        relationRequestHandler.Z0(str, bArr, bVar);
    }
}
