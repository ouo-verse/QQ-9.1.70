package com.tencent.mobileqq.app.handler.receivesuccess;

import SharpSvrPack.MultiVideoMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, FromServiceMsg fromServiceMsg) {
        if ("MultiVideo.c2sack".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && com.tencent.av.q.f74190a) {
            MultiVideoMsg multiVideoMsg = (MultiVideoMsg) messageHandler.decodePacket(fromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, String.format("onReceive multi video msg c2sack, type=0x%X csCmd=0x%X", Byte.valueOf(multiVideoMsg.type), Short.valueOf(multiVideoMsg.csCmd)));
            }
            if (multiVideoMsg.type >= 32) {
                return;
            }
            messageHandler.Q.getGAudioHandler().v(multiVideoMsg.video_buff);
        }
    }
}
