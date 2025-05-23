package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype31;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ae extends af {
    static IPatchRedirector $redirector_;

    public ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(QQAppInterface qQAppInterface, List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, boolean z16, com.tencent.mobileqq.troop.data.c cVar) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("ShareLocationElemDecoder", 2, "decodePBMsgElems_LbsShareMsg: invoked. ", "elems = [" + list + "], msgRecords = [" + list2 + "], logBuilder = [" + ((Object) sb5) + "], msg = [" + msg_comm_msg + "]");
        }
        if (list != null && list.size() != 0) {
            if (z16) {
                if (qQAppInterface.getLongAccountUin() == msg_comm_msg.msg_head.to_uin.get()) {
                    str = msg_comm_msg.msg_head.from_uin.get() + "";
                } else {
                    str = msg_comm_msg.msg_head.to_uin.get() + "";
                }
            } else if (cVar != null) {
                str = cVar.f294891a;
            } else {
                str = msg_comm_msg.msg_head.to_uin.get() + "";
            }
            for (im_msg_body$Elem im_msg_body_elem : list) {
                if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.uint32_service_type.get() == 31 && im_msg_body_elem.common_elem.bytes_pb_elem.has()) {
                    try {
                        new MessageMicro<hummer_commelem$MsgElemInfo_servtype31>() { // from class: tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype31
                            static final MessageMicro.FieldMap __fieldMap__;
                            public final PBBytesField bytes_ext;
                            public final PBBytesField bytes_text;

                            static {
                                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_text", "bytes_ext"}, new Object[]{byteStringMicro, byteStringMicro}, hummer_commelem$MsgElemInfo_servtype31.class);
                            }

                            {
                                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                                this.bytes_text = PBField.initBytes(byteStringMicro);
                                this.bytes_ext = PBField.initBytes(byteStringMicro);
                            }
                        }.mergeFrom(im_msg_body_elem.common_elem.bytes_pb_elem.get().toByteArray());
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.e("ShareLocationElemDecoder", 1, "decodePBMsgElems_LbsShareMsg: failed. ", e16);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                sb5.append("elemType:LbsShareMsg;\n");
            }
            MessageForLocationShare messageForLocationShare = (MessageForLocationShare) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_AIO_FOR_LOCATION_SHARE);
            messageForLocationShare.msgtype = MessageRecord.MSG_TYPE_AIO_FOR_LOCATION_SHARE;
            messageForLocationShare.f203106msg = BaseApplication.getContext().getString(R.string.vs7);
            messageForLocationShare.isSharingLocation = true;
            messageForLocationShare.frienduin = str;
            messageForLocationShare.parse();
            list2.add(messageForLocationShare);
            if (QLog.isColorLevel()) {
                sb5.append("LbsShareMsg.msg: ");
                sb5.append(messageForLocationShare.toString() + "\n");
                sb5.append("\n");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ShareLocationElemDecoder", 2, "decodePBMsgElems_LbsShareMsg msg decode failed");
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        d((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), list, list2, sb5, msg_comm_msg, z17, cVar);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && 31 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
            return true;
        }
        return false;
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
