package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes28.dex */
public final class msg_transmit$PbMultiMsgNew extends MessageMicro<msg_transmit$PbMultiMsgNew> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg"}, new Object[]{null}, msg_transmit$PbMultiMsgNew.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417538msg = PBField.initRepeatMessage(msg_comm$Msg.class);
}
