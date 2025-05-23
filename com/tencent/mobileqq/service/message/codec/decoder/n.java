package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.av.s;
import com.tencent.av.service.k;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.cs.head$Head;
import tencent.im.msg.im_msg_body$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements k.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // com.tencent.av.service.k.a
        public void a(com.tencent.av.service.k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) kVar);
            } else {
                kVar.h();
            }
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(MessageHandler messageHandler, String str, int i3, long j3, long j16, long j17, byte[] bArr, boolean z16) {
        try {
            new com.tencent.av.service.k(BaseApplication.getContext()).b(new a());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "exception when process qcall offline msg", e16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [byte[]] */
    private byte[] d(String str, byte[] bArr, int i3, int i16, int i17) {
        byte[] bArr2 = null;
        try {
            head$Head head_head = new head$Head();
            byte[] bArr3 = new byte[i16];
            System.arraycopy(bArr, i3, bArr3, 0, i16);
            head_head.mergeFrom(bArr3);
            int i18 = head_head.msg_msg_head.msg_content_head.uint32_type.get();
            int i19 = head_head.msg_msg_head.msg_content_head.uint32_subtype.get();
            if (i18 == 562 && i19 == 17) {
                int i26 = i3 + i16;
                im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
                byte[] bArr4 = new byte[i17];
                System.arraycopy(bArr, i26, bArr4, 0, i17);
                im_msg_body_msgbody.mergeFrom(bArr4);
                ?? byteArray = im_msg_body_msgbody.msg_content.get().toByteArray();
                bArr2 = byteArray;
                str = byteArray;
            } else {
                str = str;
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "error msgType:" + i18 + ", or subType:" + i19);
                    str = str;
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "error when process qcall offline msg", e16);
            }
        }
        return bArr2;
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().msg_content.has()) {
            long j3 = msg_comm_msg.msg_head.get().msg_time.get();
            long j16 = msg_comm_msg.msg_head.get().msg_uid.get();
            long j17 = msg_comm_msg.msg_head.get().msg_seq.get();
            long j18 = msg_comm_msg.msg_head.get().from_uin.get();
            msg_comm_msg.msg_head.get().to_uin.get();
            String str = j17 + "-" + j16;
            if (QLog.isColorLevel()) {
                QLog.d("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall :  key:" + str);
            }
            if (messageHandler.Q.getMsgCache().v1(j18, str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("decodeC2CMsgPkg_QCall", 2, "msg has been pulled");
                    return;
                }
                return;
            }
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            long longValue = Long.valueOf(messageHandler.Q.getCurrentAccountUin()).longValue();
            byte[] byteArray = msg_comm_msg.msg_body.get().msg_content.get().toByteArray();
            long j19 = K0 - j3;
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[4];
            System.arraycopy(byteArray, 0, bArr, 0, 4);
            System.arraycopy(byteArray, 4, bArr2, 0, 4);
            int a16 = s.a(bArr, 4);
            int a17 = s.a(bArr2, 4);
            if (a16 > 0 && a17 > 0) {
                byte[] d16 = d("decodeC2CMsgPkg_QCall", byteArray, 8, a16, a17);
                if (d16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("decodeC2CMsgPkg_QCall", 2, "msg sharp content null, return;");
                        return;
                    }
                    return;
                }
                boolean b16 = com.tencent.av.core.a.b(d16);
                if (((!aVar.f286154i && !aVar.f286159n) || aVar.f286148c == aVar.f286149d) && (aVar.f286148c != aVar.f286149d || b16)) {
                    b(messageHandler, "decodeC2CMsgPkg_QCall", (int) j3, j18, longValue, j19, d16, b16);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall return null:,isReaded:" + aVar.f286154i + "syncOther:" + aVar.f286159n + ",isSharpRequest" + b16);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("decodeC2CMsgPkg_QCall", 2, "invalid head length:" + a16 + " or body length:" + a17);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("VideoQCallDecoder", 2, "<---decodeC2CMsgPkg_QCall return null:hasBody:" + msg_comm_msg.msg_body.has() + ",hasMsgContent" + msg_comm_msg.msg_body.get().msg_content.has());
        }
    }
}
