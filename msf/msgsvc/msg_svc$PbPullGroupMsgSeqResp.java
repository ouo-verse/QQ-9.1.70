package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbPullGroupMsgSeqResp extends MessageMicro<msg_svc$PbPullGroupMsgSeqResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "group_info_resp"}, new Object[]{0, "", null}, msg_svc$PbPullGroupMsgSeqResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<GroupInfoResp> group_info_resp = PBField.initRepeatMessage(GroupInfoResp.class);

    /* loaded from: classes28.dex */
    public static final class GroupInfoResp extends MessageMicro<GroupInfoResp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "member_seq", "group_seq"}, new Object[]{0L, 0L, 0L}, GroupInfoResp.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt64Field member_seq = PBField.initUInt64(0);
        public final PBUInt64Field group_seq = PBField.initUInt64(0);
    }
}
