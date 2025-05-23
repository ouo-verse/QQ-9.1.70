package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbUnReadMsgSeqReq extends MessageMicro<msg_svc$PbUnReadMsgSeqReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info", "thirdqq_unread_info"}, new Object[]{null, null, null, null, null}, msg_svc$PbUnReadMsgSeqReq.class);
    public msg_svc$PbC2CUnReadMsgNumReq c2c_unread_info = new MessageMicro<msg_svc$PbC2CUnReadMsgNumReq>() { // from class: msf.msgsvc.msg_svc$PbC2CUnReadMsgNumReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], msg_svc$PbC2CUnReadMsgNumReq.class);
    };
    public final PBRepeatMessageField<msg_svc$PbBindUinUnReadMsgNumReq> binduin_unread_info = PBField.initRepeatMessage(msg_svc$PbBindUinUnReadMsgNumReq.class);
    public msg_svc$PbPullGroupMsgSeqReq group_unread_info = new msg_svc$PbPullGroupMsgSeqReq();
    public msg_svc$PbPullDiscussMsgSeqReq discuss_unread_info = new MessageMicro<msg_svc$PbPullDiscussMsgSeqReq>() { // from class: msf.msgsvc.msg_svc$PbPullDiscussMsgSeqReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"discuss_info_req"}, new Object[]{null}, msg_svc$PbPullDiscussMsgSeqReq.class);
        public final PBRepeatMessageField<DiscussInfoReq> discuss_info_req = PBField.initRepeatMessage(DiscussInfoReq.class);

        /* loaded from: classes28.dex */
        public static final class DiscussInfoReq extends MessageMicro<DiscussInfoReq> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"conf_uin", "last_seq"}, new Object[]{0L, 0L}, DiscussInfoReq.class);
            public final PBUInt64Field conf_uin = PBField.initUInt64(0);
            public final PBUInt64Field last_seq = PBField.initUInt64(0);
        }
    };
    public msg_svc$PbThirdQQUnReadMsgNumReq thirdqq_unread_info = new msg_svc$PbThirdQQUnReadMsgNumReq();
}
