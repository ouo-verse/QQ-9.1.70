package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.av.hd_video_2$MsgBody;
import com.tencent.av.r;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x158.SubMsgType0x158$SharpVideoMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l implements n {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, long j3, long j16, long j17, byte[] bArr, boolean z16) {
        int i3;
        int i16;
        boolean z17;
        if (z16) {
            String valueOf = String.valueOf(j3);
            String valueOf2 = String.valueOf(j16);
            hd_video_2$MsgBody hd_video_2_msgbody = new hd_video_2$MsgBody();
            try {
                hd_video_2_msgbody.mergeFrom(bArr);
                i3 = hd_video_2_msgbody.msg_invite_body.uint32_new_business_flag.get();
                try {
                } catch (Exception e16) {
                    e = e16;
                    i16 = 0;
                    e.printStackTrace();
                    if (-1 != i3) {
                    }
                    com.tencent.av.o.k(j16, j3, 208);
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                i3 = -1;
            }
            if (hd_video_2_msgbody.msg_invite_body.msg_temp_session.has()) {
                if (hd_video_2_msgbody.msg_invite_body.msg_temp_session.uint32_relationship_type.has()) {
                    int s16 = r.s(hd_video_2_msgbody.msg_invite_body.msg_temp_session.uint32_relationship_type.get(), false, 1);
                    if (s16 != -1) {
                        i16 = s16;
                    } else {
                        i16 = 0;
                    }
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("SharpVideoV2Decoder", 2, "uinType" + i16 + " translateType:" + s16);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        e.printStackTrace();
                        if (-1 != i3) {
                        }
                        com.tencent.av.o.k(j16, j3, 208);
                        if (QLog.isColorLevel()) {
                        }
                    }
                    if (-1 != i3) {
                        VideoMsgTools.l(messageHandler.Q, 0, 6, true, valueOf, valueOf2, false, null, false, msg_comm_msg);
                    } else {
                        String valueOf3 = String.valueOf(j3);
                        if (i3 == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        VideoMsgTools.l(messageHandler.Q, i16, 6, z17, valueOf, valueOf3, false, null, false, msg_comm_msg);
                    }
                    com.tencent.av.o.k(j16, j3, 208);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("SharpVideoV2Decoder", 2, "msg_temp_session not include");
            }
            i16 = 0;
            if (-1 != i3) {
            }
            com.tencent.av.o.k(j16, j3, 208);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SharpVideoV2Decoder", 2, "Discard video message because of time out " + j17 + " s");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0163, code lost:
    
        if (r28.f286148c == r28.f286149d) goto L34;
     */
    @Override // com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(msg_comm$MsgType0x210 msg_comm_msgtype0x210, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar, MessageHandler messageHandler) {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg_comm_msgtype0x210, msg_comm_msg, list, aVar, messageHandler);
            return;
        }
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().msg_content.has()) {
            long j17 = msg_comm_msg.msg_head.get().msg_time.get();
            long j18 = msg_comm_msg.msg_head.get().msg_uid.get();
            long j19 = msg_comm_msg.msg_head.get().msg_seq.get();
            long j26 = msg_comm_msg.msg_head.get().from_uin.get();
            String str = j19 + "-" + j18;
            if (QLog.isColorLevel()) {
                QLog.d("SharpVideoV2Decoder", 2, "decodeC2CMsgPkg_SharpVideo :  key:" + str);
            }
            if (messageHandler.Q.getMsgCache().v1(j26, str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SharpVideoV2Decoder", 2, "msg has been pulled");
                    return;
                }
                return;
            }
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            long longAccountUin = messageHandler.Q.getLongAccountUin();
            byte[] byteArray = msg_comm_msgtype0x210.msg_content.get().toByteArray();
            long j27 = K0 - j17;
            QLog.d("SharpVideoV2Decoder", 2, "msgContent: " + Arrays.toString(byteArray));
            SubMsgType0x158$SharpVideoMsg subMsgType0x158$SharpVideoMsg = new SubMsgType0x158$SharpVideoMsg();
            try {
                subMsgType0x158$SharpVideoMsg.mergeFrom(byteArray);
                if (QLog.isColorLevel()) {
                    QLog.d("SharpVideoV2Decoder", 2, "sharpVideoMsg type:" + subMsgType0x158$SharpVideoMsg.type.get());
                }
                byte[] byteArray2 = subMsgType0x158$SharpVideoMsg.video_buff.get().toByteArray();
                boolean b16 = com.tencent.av.core.a.b(byteArray2);
                QLog.d("SharpVideoV2Decoder", 2, "video_buff: " + Arrays.toString(byteArray2));
                if (!aVar.f286154i && !aVar.f286159n) {
                    j3 = j17;
                    if (aVar.f286148c != aVar.f286149d || b16) {
                        if (b16) {
                            j16 = j26;
                            messageHandler.Q.getMsgCache().M(j16, str, K0);
                            com.tencent.av.o.k(longAccountUin, j16, 215);
                        } else {
                            j16 = j26;
                        }
                        if (!AVCoreSystemInfo.isSupportSharpAudio()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SharpVideoV2Decoder", 2, "Discard video message cause device not support");
                            }
                            if (b16) {
                                com.tencent.av.o.k(longAccountUin, j16, 212);
                                return;
                            }
                            return;
                        }
                        if (j27 >= 60) {
                            a(messageHandler, msg_comm_msg, j16, longAccountUin, j27, byteArray2, b16);
                            return;
                        }
                        if (b16) {
                            com.tencent.av.o.k(longAccountUin, j16, 211);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SharpVideoV2Decoder", 2, "===========handleSharpVideoMessageResp 1234========");
                        }
                        messageHandler.k4(longAccountUin, byteArray2, j16, (int) j3, b16, subMsgType0x158$SharpVideoMsg.trace_info.trace_id.get());
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("SharpVideoV2Decoder", 2, "decodeC2CMsgPkg_SharpVideo return null:,isReaded:" + aVar.f286154i + "syncOther:" + aVar.f286159n + ",isSharpRequest" + b16);
                        return;
                    }
                    return;
                }
                j3 = j17;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SharpVideoV2Decoder", 2, "parse message failed" + e16);
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("SharpVideoV2Decoder", 2, "decodeC2CMsgPkg_SharpVideo return null:hasBody:" + msg_comm_msg.msg_body.has() + ", hasMsgContent" + msg_comm_msg.msg_body.get().msg_content.has());
        }
    }
}
