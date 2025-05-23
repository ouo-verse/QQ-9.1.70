package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Intent;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.ag;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    public p(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
        }
    }

    private void A(byte[] bArr, int i3) {
        if (i3 == 11) {
            z(bArr);
        }
    }

    private void z(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            C2CType0x211_SubC2CType0xb$MsgBody.MsgHeader msgHeader = new C2CType0x211_SubC2CType0xb$MsgBody().mergeFrom(bArr).msg_msg_header.get();
            if (msgHeader == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgHeader failed");
                    return;
                }
                return;
            }
            long j3 = msgHeader.uint64_to_uin.get();
            long j16 = msgHeader.uint64_room_id.get();
            Intent intent = new Intent();
            intent.setAction("tencent.video.q2v.AudioEngineReady");
            intent.putExtra("uin", String.valueOf(j3));
            intent.putExtra("c2cuin", j3);
            intent.putExtra("c2croomid", j16);
            this.f116342a.getApp().sendBroadcast(intent);
            QLog.d("svenxu", 1, "ACTION_OPPOSITE_AUDIO_ENGINE_READY Send video c2c broadcast: selfUin = " + j3 + " roomid = " + j16);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<VideoMessageProcessor><---handle0x2110xbMsg : subMsgType[0xb] MsgBody failed", e16);
            }
        }
    }

    public void B(long j3, byte[] bArr, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), bArr, Long.valueOf(j16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public ag o(int i3, MsgInfo msgInfo, SvcReqPushMsg svcReqPushMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ag) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), msgInfo, svcReqPushMsg);
        }
        if (i3 != 9002) {
            if (i3 == 9003) {
                if (msgInfo != null && svcReqPushMsg != null) {
                    ((QQAppInterface) this.f116342a).getMsgHandler().k4(svcReqPushMsg.lUin, msgInfo.vMsg, msgInfo.lFromUin, (int) msgInfo.uMsgTime, com.tencent.av.core.a.b(msgInfo.vMsg), "");
                } else {
                    f(getClass().getName(), i3);
                }
            }
        } else if (msgInfo != null && svcReqPushMsg != null) {
            B(svcReqPushMsg.lUin, msgInfo.vMsg, msgInfo.lFromUin, (int) msgInfo.uMsgTime);
        } else {
            f(getClass().getName(), i3);
        }
        return new ag(null, true);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
            return;
        }
        if (i3 == 3001) {
            if (objArr != null && objArr.length == 3) {
                A((byte[]) objArr[2], 11);
            } else {
                f(getClass().getName(), i3);
            }
        }
    }
}
