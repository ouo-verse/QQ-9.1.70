package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbPullGroupMsgSeqReq extends MessageMicro<msg_svc$PbPullGroupMsgSeqReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"group_info_req"}, new Object[]{null}, msg_svc$PbPullGroupMsgSeqReq.class);
    public final PBRepeatMessageField<GroupInfoReq> group_info_req = PBField.initRepeatMessage(GroupInfoReq.class);

    /* loaded from: classes28.dex */
    public static final class GroupInfoReq extends MessageMicro<GroupInfoReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "last_seq"}, new Object[]{0L, 0L}, GroupInfoReq.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt64Field last_seq = PBField.initUInt64(0);
    }
}
