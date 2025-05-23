package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.o;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$ContentHead;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements com.tencent.mobileqq.service.message.codec.decoder.d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (r10.auto_reply.get() == 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(MessageHandler messageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, long j3, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().rich_text.has() && msg_comm_msg.msg_head.get().c2c_cmd.has()) {
            if (!msg_comm_msg.content_head.has()) {
                if (QLog.isColorLevel()) {
                    QLog.e("NormalBuddyDecoder", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
                    return;
                }
                return;
            }
            msg_comm$ContentHead msg_comm_contenthead = msg_comm_msg.content_head.get();
            if (msg_comm_contenthead.auto_reply.has()) {
                z19 = true;
            }
            z19 = false;
            List<im_msg_body$Elem> list2 = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
            if (z19) {
                if (list2 != null && list2.size() > 0) {
                    String string = BaseApplicationImpl.getApplication().getString(R.string.f170517tj);
                    String e16 = new o().e1(list2);
                    if (!TextUtils.isEmpty(e16)) {
                        MessageRecord d16 = q.d(-10000);
                        d16.msgtype = -10000;
                        d16.f203106msg = string + " " + e16;
                        list.add(d16);
                        return;
                    }
                    return;
                }
                return;
            }
            p.f(messageHandler, list, msg_comm_msg, true, z16, null);
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
        } else {
            c(messageHandler, list, msg_comm_msg, aVar.f286338a, aVar.f286155j, aVar.f286154i, aVar.f286157l);
        }
    }
}
