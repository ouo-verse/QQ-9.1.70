package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$BusinessWPATmp;
import msf.msgsvc.msg_svc$RoutingHead;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements com.tencent.imcore.message.core.codec.d<AppInterface> {
    static IPatchRedirector $redirector_;

    public c() {
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
        return 8010;
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
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        byte[] k06 = qQAppInterface.getMsgCache().k0(messageRecord.frienduin);
        msg_svc$BusinessWPATmp msg_svc_businesswpatmp = new msg_svc$BusinessWPATmp();
        msg_svc_businesswpatmp.to_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
        if (k06 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessCRMRoutingType", 2, "conversation------>sig:" + HexUtil.bytes2HexStr(k06) + ",length:" + k06.length);
            }
            msg_svc_businesswpatmp.sig.set(ByteStringMicro.copyFrom(k06));
        } else {
            byte[] l06 = qQAppInterface.getMsgCache().l0(messageRecord.frienduin);
            if (l06 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCRMRoutingType", 2, "conversation------>sigt:" + HexUtil.bytes2HexStr(l06) + ",length:" + l06.length);
                }
                msg_svc_businesswpatmp.sigt.set(ByteStringMicro.copyFrom(l06));
            }
        }
        msg_svc_routinghead.business_wpa_tmp.set(msg_svc_businesswpatmp);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1024;
    }
}
