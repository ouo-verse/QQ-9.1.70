package com.tencent.imcore.message.ext.codec.routingtype;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$NearByDatingTmp;
import msf.msgsvc.msg_svc$RoutingHead;

/* compiled from: P */
/* loaded from: classes7.dex */
public class v implements com.tencent.imcore.message.core.codec.d<AppInterface> {
    static IPatchRedirector $redirector_;

    public v() {
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
        return 8012;
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
        msg_svc$NearByDatingTmp msg_svc_nearbydatingtmp = new msg_svc$NearByDatingTmp();
        msg_svc_nearbydatingtmp.to_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        msg_svc_nearbydatingtmp.reply.set(qQAppInterface.getMessageFacade().getLastMessage(messageRecord.frienduin, 1010).hasReply);
        byte[] q06 = qQAppInterface.getMsgCache().q0(messageRecord.frienduin);
        if (q06 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("nearby_dating", 4, "\u53d1\u9001\u9644\u8fd1\u4eba\u7ea6\u4f1a\u4e34\u65f6\u4f1a\u8bdd\u6d88\u606f \u6709keyNearbyDating------>" + HexUtil.bytes2HexStr(q06) + ",length:" + q06.length);
            }
            msg_svc_nearbydatingtmp.sig.set(ByteStringMicro.copyFrom(q06));
        }
        msg_svc_routinghead.nearby_dating_tmp.set(msg_svc_nearbydatingtmp);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1010;
    }
}
