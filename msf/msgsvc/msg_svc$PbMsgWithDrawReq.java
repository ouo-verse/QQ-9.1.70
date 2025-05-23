package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class msg_svc$PbMsgWithDrawReq extends MessageMicro<msg_svc$PbMsgWithDrawReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"c2c_with_draw", "group_with_draw"}, new Object[]{null, null}, msg_svc$PbMsgWithDrawReq.class);
    public final PBRepeatMessageField<msg_svc$PbC2CMsgWithDrawReq> c2c_with_draw = PBField.initRepeatMessage(msg_svc$PbC2CMsgWithDrawReq.class);
    public final PBRepeatMessageField<msg_svc$PbGroupMsgWithDrawReq> group_with_draw = PBField.initRepeatMessage(msg_svc$PbGroupMsgWithDrawReq.class);
}
