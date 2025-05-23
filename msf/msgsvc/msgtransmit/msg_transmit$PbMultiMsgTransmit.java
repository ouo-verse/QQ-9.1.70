package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes28.dex */
public final class msg_transmit$PbMultiMsgTransmit extends MessageMicro<msg_transmit$PbMultiMsgTransmit> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg", "pbItemList"}, new Object[]{null, null}, msg_transmit$PbMultiMsgTransmit.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417539msg = PBField.initRepeatMessage(msg_comm$Msg.class);
    public final PBRepeatMessageField<msg_transmit$PbMultiMsgItem> pbItemList = PBField.initRepeatMessage(msg_transmit$PbMultiMsgItem.class);
}
