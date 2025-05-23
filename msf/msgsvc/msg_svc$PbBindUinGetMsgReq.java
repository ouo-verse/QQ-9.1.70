package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbBindUinGetMsgReq extends MessageMicro<msg_svc$PbBindUinGetMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"bind_uin", "bind_uin_sig", "sync_flag", "sync_cookie"}, new Object[]{0L, ByteStringMicro.copyFromUtf8(""), 0, ByteStringMicro.copyFromUtf8("")}, msg_svc$PbBindUinGetMsgReq.class);
    public final PBUInt64Field bind_uin = PBField.initUInt64(0);
    public final PBBytesField bind_uin_sig = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBEnumField sync_flag = PBField.initEnum(0);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
}
