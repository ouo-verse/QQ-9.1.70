package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class msg_svc$PbSearchRoamMsgInCloudReq extends MessageMicro<msg_svc$PbSearchRoamMsgInCloudReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"serialize_reqbody"}, new Object[]{ByteStringMicro.EMPTY}, msg_svc$PbSearchRoamMsgInCloudReq.class);
    public final PBBytesField serialize_reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
}
