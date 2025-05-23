package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetDiscussMsgReq extends MessageMicro<msg_svc$PbGetDiscussMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"discuss_uin", "end_seq", "begin_seq", "last_get_time", "discuss_info_seq", "filter", "member_seq"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0, 0L}, msg_svc$PbGetDiscussMsgReq.class);
    public final PBUInt64Field discuss_uin = PBField.initUInt64(0);
    public final PBUInt64Field end_seq = PBField.initUInt64(0);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field last_get_time = PBField.initUInt64(0);
    public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0);
    public final PBEnumField filter = PBField.initEnum(0);
    public final PBUInt64Field member_seq = PBField.initUInt64(0);
}
