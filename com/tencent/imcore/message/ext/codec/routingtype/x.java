package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$QQQueryBusinessTmp;
import msf.msgsvc.msg_svc$RoutingHead;

/* compiled from: P */
/* loaded from: classes7.dex */
public class x implements com.tencent.imcore.message.core.codec.d<AppInterface> {
    static IPatchRedirector $redirector_;

    public x() {
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
        return MessageHandlerConstants.NOTIFY_TYPE_PC_QQ_SEARCH_MSG_SEND_ERROR_RSP;
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
        byte[] U0 = ((QQAppInterface) appInterface).getMsgCache().U0(messageRecord.frienduin);
        msg_svc$QQQueryBusinessTmp msg_svc_qqquerybusinesstmp = new msg_svc$QQQueryBusinessTmp();
        msg_svc_qqquerybusinesstmp.to_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
        if (U0 != null) {
            int length = U0.length - 2;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, U0, 2, U0.length - 2);
            if (QLog.isColorLevel()) {
                QLog.d("PcQQSearchTmpRoutingType", 2, "wpa------>" + HexUtil.bytes2HexStr(bArr) + ",length:" + length);
            }
            msg_svc_qqquerybusinesstmp.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_routinghead.qq_querybusiness_tmp.set(msg_svc_qqquerybusinesstmp);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1023;
    }
}
