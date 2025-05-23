package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$ShakeWindow;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ad extends af {
    static IPatchRedirector $redirector_;

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, boolean z16) {
        im_msg_body$Elem im_msg_body_elem;
        int i3;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body_elem = it.next();
                if (im_msg_body_elem.shake_window.has()) {
                    break;
                }
            } else {
                im_msg_body_elem = null;
                break;
            }
        }
        if (im_msg_body_elem == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:ShakeWindow;\n");
        }
        im_msg_body$ShakeWindow im_msg_body_shakewindow = im_msg_body_elem.shake_window.get();
        MessageForShakeWindow messageForShakeWindow = (MessageForShakeWindow) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_SHAKE_WINDOW);
        messageForShakeWindow.msgtype = MessageRecord.MSG_TYPE_SHAKE_WINDOW;
        messageForShakeWindow.f203106msg = "[Shake Window]";
        ShakeWindowMsg shakeWindowMsg = new ShakeWindowMsg();
        shakeWindowMsg.mType = im_msg_body_shakewindow.uint32_type.get();
        shakeWindowMsg.mReserve = im_msg_body_shakewindow.uint32_reserve.get();
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        shakeWindowMsg.onlineFlag = i3;
        shakeWindowMsg.shake = true;
        byte[] bytes = shakeWindowMsg.getBytes();
        messageForShakeWindow.msgData = bytes;
        if (bytes == null) {
            if (QLog.isColorLevel()) {
                sb5.append("c2cMsgContent.data:null;\n");
                return;
            }
            return;
        }
        list2.add(messageForShakeWindow);
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        d(list, list2, sb5, z16);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        return im_msg_body_elem.shake_window.has();
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1000;
    }
}
