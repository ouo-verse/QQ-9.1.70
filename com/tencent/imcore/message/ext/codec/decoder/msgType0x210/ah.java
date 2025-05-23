package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0x15d.SubMsgType0x15d$PCSupportInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x15d.SubMsgType0x15d$StatusEventMessage;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ah implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        int i3;
        MessageHandler messageHandler;
        byte b16;
        byte b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        QLog.d("SubType0x15d", 2, "decode buffer");
        SubMsgType0x15d$StatusEventMessage subMsgType0x15d$StatusEventMessage = new SubMsgType0x15d$StatusEventMessage();
        try {
            subMsgType0x15d$StatusEventMessage.mergeFrom(bArr);
            SubMsgType0x15d$PCSupportInfo subMsgType0x15d$PCSupportInfo = subMsgType0x15d$StatusEventMessage.pc_support_info.get();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "RequestPushStatus status:" + subMsgType0x15d$PCSupportInfo.is_pc.get() + "supportdataline:" + subMsgType0x15d$PCSupportInfo.support_dataline.get());
            }
            QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
            RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
            if (subMsgType0x15d$StatusEventMessage.event_type.get() == 1 && subMsgType0x15d$PCSupportInfo.is_pc.get() == 1) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MessageHandler", 4, "PConline now");
                }
                i3 = 1;
            } else {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MessageHandler", 4, "PCoffline now");
                }
                i3 = 0;
            }
            byte b18 = (byte) (((rd0.g) qQAppInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).q(new ArrayList<>(subMsgType0x15d$StatusEventMessage.online_devices.get())) ? 1 : 0);
            MessageHandler messageHandler2 = (MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
            DataLineHandler dataLineHandler = (DataLineHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            if (subMsgType0x15d$StatusEventMessage.plat_type.get() == 2) {
                if (subMsgType0x15d$StatusEventMessage.event_type.get() == 1) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Q.msg.MessageHandler", 4, Integer.valueOf(subMsgType0x15d$StatusEventMessage.client_type.get()), ": online now");
                    }
                    if (registerProxySvcPackHandler.h3(1, subMsgType0x15d$StatusEventMessage.client_type.get() == 110)) {
                        messageHandler2.R4();
                    }
                    b17 = 1;
                } else {
                    if (subMsgType0x15d$StatusEventMessage.event_type.get() == 2) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("Q.msg.MessageHandler", 4, Integer.valueOf(subMsgType0x15d$StatusEventMessage.client_type.get()), ": offline now");
                        }
                        registerProxySvcPackHandler.h3(0, subMsgType0x15d$StatusEventMessage.client_type.get() == 110);
                        messageHandler2.F4(1);
                    }
                    b17 = 0;
                }
                registerProxySvcPackHandler.X2(1);
                b(qQAppInterface, subMsgType0x15d$StatusEventMessage, b17, 1);
                dataLineHandler.P3(b18);
                messageHandler = messageHandler2;
            } else if (subMsgType0x15d$StatusEventMessage.plat_type.get() == 1) {
                byte b19 = subMsgType0x15d$StatusEventMessage.event_type.get() == 1 ? (byte) 1 : (byte) 0;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "mac online push status:" + ((int) b19) + ",cDataline:1");
                }
                registerProxySvcPackHandler.j3(i3);
                registerProxySvcPackHandler.k3(subMsgType0x15d$PCSupportInfo.support_dataline.get());
                registerProxySvcPackHandler.l3(subMsgType0x15d$PCSupportInfo.support_print.get());
                registerProxySvcPackHandler.m3(subMsgType0x15d$PCSupportInfo.support_view_pc_file.get());
                registerProxySvcPackHandler.n3(subMsgType0x15d$PCSupportInfo.pc_version.get());
                registerProxySvcPackHandler.c3(subMsgType0x15d$StatusEventMessage.client_type.get());
                registerProxySvcPackHandler.b3(subMsgType0x15d$StatusEventMessage.instance_id.get());
                registerProxySvcPackHandler.g3(b18);
                registerProxySvcPackHandler.W2();
                registerProxySvcPackHandler.X2(i3);
                registerProxySvcPackHandler.o3(new ArrayList<>(subMsgType0x15d$StatusEventMessage.online_devices.get()));
                messageHandler = messageHandler2;
                dataLineHandler.D3().i(i3, subMsgType0x15d$PCSupportInfo.support_dataline.get(), subMsgType0x15d$PCSupportInfo.support_print.get(), subMsgType0x15d$PCSupportInfo.support_view_pc_file.get(), subMsgType0x15d$PCSupportInfo.pc_version.get());
                b(qQAppInterface, subMsgType0x15d$StatusEventMessage, b19, 0);
                dataLineHandler.Q3(b18);
            } else {
                messageHandler = messageHandler2;
                if (subMsgType0x15d$StatusEventMessage.client_type.get() != 78082 && (subMsgType0x15d$StatusEventMessage.client_type.get() == 110 || subMsgType0x15d$StatusEventMessage.client_type.get() == 109)) {
                    if (subMsgType0x15d$StatusEventMessage.event_type.get() == 1) {
                        messageHandler.H4();
                        b16 = 1;
                    } else {
                        if (subMsgType0x15d$StatusEventMessage.event_type.get() == 2) {
                            messageHandler.F4(2);
                        }
                        b16 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "mobile online push status:" + ((int) b16) + ",cDataline:1");
                    }
                    registerProxySvcPackHandler.i3(b16);
                    registerProxySvcPackHandler.X2(1);
                    b(qQAppInterface, subMsgType0x15d$StatusEventMessage, b16, 2);
                } else if (subMsgType0x15d$StatusEventMessage.client_type.get() == 78082) {
                    int i16 = subMsgType0x15d$StatusEventMessage.event_type.get() == 1 ? 1 : 0;
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "watch online push status:" + i16 + ",cDataline:1");
                    }
                }
            }
            messageHandler.notifyUI(6016, true, new Object[]{Byte.valueOf(b18)});
            return null;
        } catch (Exception e16) {
            QLog.w("SubType0x15d", 1, "merge from exception", e16);
            return null;
        }
    }

    public void b(QQAppInterface qQAppInterface, SubMsgType0x15d$StatusEventMessage subMsgType0x15d$StatusEventMessage, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, subMsgType0x15d$StatusEventMessage, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        if (b16 == 1 && com.tencent.mobileqq.filemanager.fileassistant.util.h.a(qQAppInterface)) {
            com.tencent.mobileqq.filemanager.fileassistant.util.h.y(qQAppInterface, i3, true);
            com.tencent.mobileqq.filemanager.fileassistant.util.h.r(qQAppInterface);
        }
        ((RegisterProxySvcPackHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).o3(new ArrayList<>(subMsgType0x15d$StatusEventMessage.online_devices.get()));
    }
}
