package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        if (aVar.f286157l) {
            return;
        }
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().msg_content.has() && !aVar.f286154i && !aVar.f286159n) {
            long j3 = msg_comm_msg.msg_head.get().msg_time.get();
            long j16 = msg_comm_msg.msg_head.get().msg_uid.get();
            long j17 = msg_comm_msg.msg_head.get().msg_seq.get();
            long j18 = msg_comm_msg.msg_head.get().from_uin.get();
            long j19 = msg_comm_msg.msg_head.get().to_uin.get();
            Long.valueOf(messageHandler.Q.getCurrentAccountUin()).longValue();
            String str = j18 + "-" + j19 + "-" + j17 + "-" + j16;
            if (QLog.isColorLevel()) {
                QLog.d("VideoDecoder", 2, "<---decodeC2CMsgPkg_Video :  key:" + str);
            }
            byte[] byteArray = msg_comm_msg.msg_body.get().msg_content.get().toByteArray();
            long K0 = com.tencent.mobileqq.service.message.e.K0() - j3;
            byte a16 = com.tencent.av.core.a.a(byteArray);
            if (!AVCoreSystemInfo.isSupportSharpAudio()) {
                if (QLog.isColorLevel()) {
                    QLog.d("svenxu", 2, "Discard video message cause device not support");
                    return;
                }
                return;
            }
            if (K0 >= 60) {
                if (QLog.isColorLevel()) {
                    QLog.d("svenxu", 2, "Discard video message because of time out " + K0 + " s");
                    return;
                }
                return;
            }
            HashMap hashMap = (HashMap) aVar.a(1000);
            HashSet hashSet = (HashSet) aVar.a(1001);
            if (a16 == 1) {
                if (!AVCoreSystemInfo.isSupportSharpAudio()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("shanezhaiSHARP", 2, "discard video push message because the sdk is lower");
                        return;
                    }
                    return;
                } else {
                    if (hashMap != null) {
                        hashMap.put(Long.valueOf(j18), msg_comm_msg);
                        return;
                    }
                    return;
                }
            }
            if (a16 == 3 && AVCoreSystemInfo.isSupportSharpAudio() && hashSet != null) {
                hashSet.add(Long.valueOf(j18));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("VideoDecoder", 2, "<---decodeC2CMsgPkg_Video return null:hasBody:" + msg_comm_msg.msg_body.has() + ",hasMsgContent" + msg_comm_msg.msg_body.get().msg_content.has() + ",isReaded:" + aVar.f286154i + "syncOther:" + aVar.f286159n);
        }
    }
}
