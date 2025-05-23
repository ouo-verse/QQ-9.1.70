package com.tencent.mobileqq.app.handler.receivesuccess;

import SharpSvrPack.MultiVideoMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, FromServiceMsg fromServiceMsg) {
        if ("MultiVideo.s2c".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && com.tencent.av.q.f74190a) {
            MultiVideoMsg multiVideoMsg = (MultiVideoMsg) messageHandler.decodePacket(fromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg s2c, type=0x%X csCmd=0x%X", Byte.valueOf(multiVideoMsg.type), Short.valueOf(multiVideoMsg.csCmd)));
            }
            if (multiVideoMsg.type >= 32) {
                return;
            }
            messageHandler.Q.getGAudioHandler().y(multiVideoMsg.video_buff);
            if (multiVideoMsg.type != 10) {
                ToServiceMsg createToServiceMsg = messageHandler.createToServiceMsg("MultiVideo.s2cack");
                createToServiceMsg.extraData.putByte("ver", multiVideoMsg.ver);
                createToServiceMsg.extraData.putByte("type", multiVideoMsg.type);
                createToServiceMsg.extraData.putShort("cscmd", multiVideoMsg.csCmd);
                createToServiceMsg.extraData.putShort("subcmd", multiVideoMsg.subCmd);
                createToServiceMsg.extraData.putLong(ShortVideoConstants.FROM_UIN, multiVideoMsg.from_uin);
                createToServiceMsg.extraData.putLong("to_uin", multiVideoMsg.to_uin.get(0).longValue());
                createToServiceMsg.extraData.putLong("msg_seq", multiVideoMsg.msg_seq);
                createToServiceMsg.extraData.putLong("msg_uid", multiVideoMsg.msg_uid);
                createToServiceMsg.extraData.putLong(QQHealthReportApiImpl.MSG_TYPE_KEY, multiVideoMsg.msg_type);
                createToServiceMsg.extraData.putLong(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, multiVideoMsg.msg_time);
                createToServiceMsg.extraData.putByteArray("video_buff", multiVideoMsg.video_buff);
                createToServiceMsg.extraData.putLong("msg_dataflag", multiVideoMsg.msg_dataflag);
                messageHandler.send(createToServiceMsg);
            }
        }
    }
}
