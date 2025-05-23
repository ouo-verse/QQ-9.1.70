package com.tencent.imcore.message.ext.codec.routingtype;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$GrpTmp;
import msf.msgsvc.msg_svc$RoutingHead;

/* compiled from: P */
/* loaded from: classes7.dex */
public class n implements com.tencent.imcore.message.core.codec.d<AppInterface> {
    static IPatchRedirector $redirector_;

    public n() {
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
        return 6000;
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
        msg_svc$GrpTmp msg_svc_grptmp = new msg_svc$GrpTmp();
        if (TextUtils.isEmpty(messageRecord.senderuin)) {
            msg_svc_grptmp.group_uin.set(Long.valueOf(messageRecord.selfuin).longValue());
            if (QLog.isColorLevel()) {
                QLog.d("GrpTmpRoutingType", 2, "createSendRichTextMsgReq, senderuin error, senderuin: " + messageRecord.senderuin + " frienduin: " + messageRecord.frienduin + " msgtype: " + messageRecord.msgtype);
            }
        } else {
            msg_svc_grptmp.group_uin.set(Long.valueOf(messageRecord.senderuin).longValue());
        }
        msg_svc_grptmp.to_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
        msg_svc_routinghead.grp_tmp.set(msg_svc_grptmp);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.d
    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1000;
    }
}
