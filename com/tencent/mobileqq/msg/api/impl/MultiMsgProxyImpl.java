package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.c;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes15.dex */
public class MultiMsgProxyImpl implements IMultiMsgProxy {
    static IPatchRedirector $redirector_;

    public MultiMsgProxyImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMultiMsgProxy
    public byte[] packPbFromMultiMsgWithNest(BaseQQAppInterface baseQQAppInterface, HashMap<String, ArrayList<MessageRecord>> hashMap, HashMap<String, String> hashMap2, boolean z16) {
        MultiMsgProxy multiMessageProxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, hashMap, hashMap2, Boolean.valueOf(z16));
        }
        if ((baseQQAppInterface instanceof QQAppInterface) && (multiMessageProxy = ((QQAppInterface) baseQQAppInterface).getMultiMessageProxy()) != null) {
            return multiMessageProxy.u(hashMap, hashMap2, z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMultiMsgProxy
    public HashMap<String, ArrayList<MessageRecord>> queryMultiMsgWithNest(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        MultiMsgProxy multiMessageProxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        }
        if ((baseQQAppInterface instanceof QQAppInterface) && (multiMessageProxy = ((QQAppInterface) baseQQAppInterface).getMultiMessageProxy()) != null) {
            return multiMessageProxy.y(messageRecord);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMultiMsgProxy
    public HashMap<String, ArrayList<MessageRecord>> unpackPbToMultiMsgWithNest(BaseQQAppInterface baseQQAppInterface, byte[] bArr, HashMap<String, String> hashMap, MessageRecord messageRecord, c cVar) {
        MultiMsgProxy multiMessageProxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashMap) iPatchRedirector.redirect((short) 5, this, baseQQAppInterface, bArr, hashMap, messageRecord, cVar);
        }
        if ((baseQQAppInterface instanceof QQAppInterface) && (multiMessageProxy = ((QQAppInterface) baseQQAppInterface).getMultiMessageProxy()) != null) {
            return multiMessageProxy.M(bArr, hashMap, messageRecord, cVar);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMultiMsgProxy
    public void updateMultiMsg(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        MultiMsgProxy multiMessageProxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        } else if ((baseQQAppInterface instanceof QQAppInterface) && (multiMessageProxy = ((QQAppInterface) baseQQAppInterface).getMultiMessageProxy()) != null) {
            multiMessageProxy.N(messageRecord, null);
        }
    }
}
