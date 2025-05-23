package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMsgBackupProxy;
import com.tencent.mobileqq.msgbackup.data.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class MsgBackupProxyImpl implements IMsgBackupProxy {
    static IPatchRedirector $redirector_;

    public MsgBackupProxyImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMsgBackupProxy
    public Object transToBackupEntity(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, boolean z16) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, messageRecord, Boolean.valueOf(z16));
        }
        if ((baseQQAppInterface instanceof QQAppInterface) && (eVar = (e) ((QQAppInterface) baseQQAppInterface).getProxyManager().getProxy(14)) != null) {
            return eVar.l(messageRecord, z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMsgBackupProxy
    public MessageRecord transToMessageRecord(BaseQQAppInterface baseQQAppInterface, Object obj) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface, obj);
        }
        if ((baseQQAppInterface instanceof QQAppInterface) && (eVar = (e) ((QQAppInterface) baseQQAppInterface).getProxyManager().getProxy(14)) != null) {
            return eVar.o(obj);
        }
        return null;
    }
}
