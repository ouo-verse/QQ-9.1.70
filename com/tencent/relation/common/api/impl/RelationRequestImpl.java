package com.tencent.relation.common.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.relation.common.api.IRelationRequest;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationRequestImpl implements IRelationRequest {
    static IPatchRedirector $redirector_;

    public RelationRequestImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
