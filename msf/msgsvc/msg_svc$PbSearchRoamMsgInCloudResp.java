package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes28.dex */
public final class msg_svc$PbSearchRoamMsgInCloudResp extends MessageMicro<msg_svc$PbSearchRoamMsgInCloudResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg", "serialize_rspbody"}, new Object[]{null, ByteStringMicro.EMPTY}, msg_svc$PbSearchRoamMsgInCloudResp.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417537msg = PBField.initRepeatMessage(msg_comm$Msg.class);
    public final PBBytesField serialize_rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
}
