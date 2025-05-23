package com.tencent.relation.common.dispatch.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.dispatch.IDispatcherManager;
import com.tencent.relation.common.dispatch.c;
import java.util.Iterator;
import tencent.im.s2c.msgtype0x210.submsgtype0x14e.submsgtype0x14e$MsgBody;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DispatcherManagerImpl extends com.tencent.relation.common.dispatch.a<submsgtype0x14e$MsgBody, c<submsgtype0x14e$MsgBody>> implements IDispatcherManager<c<submsgtype0x14e$MsgBody>> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DispatcherManagerImpl";

    public DispatcherManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            registerDefaultListener();
        }
    }

    private void registerDefaultListener() {
        c<submsgtype0x14e$MsgBody> cVar;
        Iterator<Class<? extends c<submsgtype0x14e$MsgBody>>> it = a.f364714a.iterator();
        while (it.hasNext()) {
            try {
                cVar = it.next().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "initProfileComponentMap create collector fail.", e16);
                cVar = null;
            }
            if (cVar != null) {
                registerDispatchListener(cVar.a(), cVar);
            }
        }
    }

    @Override // com.tencent.relation.common.dispatch.IDispatcherManager
    public void handleMsgBody(submsgtype0x14e$MsgBody submsgtype0x14e_msgbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) submsgtype0x14e_msgbody);
        } else if (submsgtype0x14e_msgbody != null) {
            dispatchEvent(submsgtype0x14e_msgbody.type.get(), submsgtype0x14e_msgbody);
        }
    }

    @Override // com.tencent.relation.common.dispatch.IDispatcherManager
    public void deregisterDispatchListener(int i3, c<submsgtype0x14e$MsgBody> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            deregisterEventListener(i3, cVar);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.relation.common.dispatch.a
    public void handleEvent(c<submsgtype0x14e$MsgBody> cVar, submsgtype0x14e$MsgBody submsgtype0x14e_msgbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) submsgtype0x14e_msgbody);
        } else {
            if (cVar == null || submsgtype0x14e_msgbody == null) {
                return;
            }
            cVar.b(submsgtype0x14e_msgbody);
        }
    }

    @Override // com.tencent.relation.common.dispatch.IDispatcherManager
    public void registerDispatchListener(int i3, c<submsgtype0x14e$MsgBody> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            registerEventListener(i3, cVar);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) cVar);
        }
    }
}
