package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$CommTmp;
import msf.msgsvc.msg_svc$RoutingHead;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ad implements com.tencent.imcore.message.core.codec.d<AppInterface> {
    static IPatchRedirector $redirector_;

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return MessageHandlerConstants.NOTIFY_TYPE_TRIBE_TMP;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public boolean c(msg_svc$RoutingHead msg_svc_routinghead, MessageRecord messageRecord, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, msg_svc_routinghead, messageRecord, appInterface)).booleanValue();
        }
        msg_svc$CommTmp msg_svc_commtmp = new msg_svc$CommTmp();
        msg_svc_commtmp.to_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
        msg_svc_commtmp.c2c_type.set(1);
        msg_svc_commtmp.svr_type.set(149);
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(messageRecord.frienduin, 1001);
        if (QLog.isColorLevel()) {
            QLog.d("TribeTmpRoutingType", 2, "TRIBE_TMP------>reply=" + lastMessage.hasReply);
        }
        byte[] c16 = qQAppInterface.getMsgCache().c1(messageRecord.frienduin);
        if (c16 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("fight_accost", 4, "\u53d1\u9001\u5174\u8da3\u90e8\u843d\u4e34\u65f6\u4f1a\u6d88\u606f \u6709key------>" + HexUtil.bytes2HexStr(c16) + ",length:" + c16.length);
            }
            msg_svc_commtmp.sig.set(ByteStringMicro.copyFrom(c16));
        }
        msg_svc_routinghead.comm_tmp.set(msg_svc_commtmp);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 10002;
    }
}
