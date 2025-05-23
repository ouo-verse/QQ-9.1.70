package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbUnReadMsgSeqResp extends MessageMicro<msg_svc$PbUnReadMsgSeqResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"c2c_unread_info", "binduin_unread_info", "group_unread_info", "discuss_unread_info", "thirdqq_unread_info"}, new Object[]{null, null, null, null, null}, msg_svc$PbUnReadMsgSeqResp.class);
    public msg_svc$PbC2CUnReadMsgNumResp c2c_unread_info = new MessageMicro<msg_svc$PbC2CUnReadMsgNumResp>() { // from class: msf.msgsvc.msg_svc$PbC2CUnReadMsgNumResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "msg_num"}, new Object[]{0, "", 0}, msg_svc$PbC2CUnReadMsgNumResp.class);
        public final PBUInt32Field result = PBField.initUInt32(0);
        public final PBStringField errmsg = PBField.initString("");
        public final PBUInt32Field msg_num = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<msg_svc$PbBindUinUnReadMsgNumResp> binduin_unread_info = PBField.initRepeatMessage(msg_svc$PbBindUinUnReadMsgNumResp.class);
    public msg_svc$PbPullGroupMsgSeqResp group_unread_info = new msg_svc$PbPullGroupMsgSeqResp();
    public msg_svc$PbPullDiscussMsgSeqResp discuss_unread_info = new MessageMicro<msg_svc$PbPullDiscussMsgSeqResp>() { // from class: msf.msgsvc.msg_svc$PbPullDiscussMsgSeqResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "discuss_info_resp"}, new Object[]{0, "", null}, msg_svc$PbPullDiscussMsgSeqResp.class);
        public final PBUInt32Field result = PBField.initUInt32(0);
        public final PBStringField errmsg = PBField.initString("");
        public final PBRepeatMessageField<DiscussInfoResp> discuss_info_resp = PBField.initRepeatMessage(DiscussInfoResp.class);

        /* loaded from: classes28.dex */
        public static final class DiscussInfoResp extends MessageMicro<DiscussInfoResp> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"conf_uin", "member_seq", "conf_seq"}, new Object[]{0L, 0L, 0L}, DiscussInfoResp.class);
            public final PBUInt64Field conf_uin = PBField.initUInt64(0);
            public final PBUInt64Field member_seq = PBField.initUInt64(0);
            public final PBUInt64Field conf_seq = PBField.initUInt64(0);
        }
    };
    public msg_svc$PbThirdQQUnReadMsgNumResp thirdqq_unread_info = new msg_svc$PbThirdQQUnReadMsgNumResp();
}
