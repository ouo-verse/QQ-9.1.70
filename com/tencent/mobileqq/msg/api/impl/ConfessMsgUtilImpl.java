package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ConfessMsgUtilImpl implements IConfessMsgUtil {
    static IPatchRedirector $redirector_;

    public ConfessMsgUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConfessMsgUtil
    public void bindC2CFirstMsgConfessInfo(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, messageRecord, str);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            ConfessMsgUtil.c((QQAppInterface) baseQQAppInterface, messageRecord, str);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConfessMsgUtil
    public void bindConfessInfo(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, messageRecord, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            ConfessMsgUtil.d((QQAppInterface) baseQQAppInterface, messageRecord, str, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConfessMsgUtil
    public void bindGroupFirstMsgConfessInfo(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, messageRecord, str);
        } else if (baseQQAppInterface instanceof QQAppInterface) {
            ConfessMsgUtil.e((QQAppInterface) baseQQAppInterface, messageRecord, str);
        }
    }
}
