package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x151.SubMsgType0x151$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class z implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x151");
        }
        try {
            new MessageMicro<SubMsgType0x151$MsgBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x151.SubMsgType0x151$MsgBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_msg_type", "msg_s2c_msg_content"}, new Object[]{0, null}, SubMsgType0x151$MsgBody.class);
                public final PBInt32Field int32_msg_type = PBField.initInt32(0);
                public SubMsgType0x151$S2CMsgContent msg_s2c_msg_content = new MessageMicro<SubMsgType0x151$S2CMsgContent>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x151.SubMsgType0x151$S2CMsgContent
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_red_point_msg", "entry_red_dot_update_msg", "portal_red_dot_update_msg"}, new Object[]{null, null, null}, SubMsgType0x151$S2CMsgContent.class);
                    public SubMsgType0x151$RedPointMsg msg_red_point_msg = new MessageMicro<SubMsgType0x151$RedPointMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x151.SubMsgType0x151$RedPointMsg
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_red_point_num"}, new Object[]{0}, SubMsgType0x151$RedPointMsg.class);
                        public final PBUInt32Field uint32_red_point_num = PBField.initUInt32(0);
                    };
                    public SubMsgType0x151$RedDotEntryUpdateMsg entry_red_dot_update_msg = new MessageMicro<SubMsgType0x151$RedDotEntryUpdateMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x151.SubMsgType0x151$RedDotEntryUpdateMsg
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"update_time_ms"}, new Object[]{0L}, SubMsgType0x151$RedDotEntryUpdateMsg.class);
                        public final PBUInt64Field update_time_ms = PBField.initUInt64(0);
                    };
                    public SubMsgType0x151$RedDotPortalUpdateMsg portal_red_dot_update_msg = new MessageMicro<SubMsgType0x151$RedDotPortalUpdateMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x151.SubMsgType0x151$RedDotPortalUpdateMsg
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"update_time_ms"}, new Object[]{0L}, SubMsgType0x151$RedDotPortalUpdateMsg.class);
                        public final PBUInt64Field update_time_ms = PBField.initUInt64(0);
                    };
                };
            }.mergeFrom(bArr);
            ((com.tencent.mobileqq.zplan.push.b) qQAppInterface.getBusinessHandler(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getOIDBPushHandlerName())).onReceive(337, bArr);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x151 " + e16);
            }
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgType0x210.vProtobuf);
        return null;
    }
}
