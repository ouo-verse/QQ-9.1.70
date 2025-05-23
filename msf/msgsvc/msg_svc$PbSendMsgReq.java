package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm$AppShareInfo;
import msf.msgcomm.msg_comm$ContentHead;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_receipt$ReceiptReq;

/* loaded from: classes28.dex */
public final class msg_svc$PbSendMsgReq extends MessageMicro<msg_svc$PbSendMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 64, 72, 82, 90, 98, 106, 112}, new String[]{"routing_head", "content_head", "msg_body", "msg_seq", "msg_rand", "sync_cookie", "app_share", "msg_via", "data_statist", "multi_msg_assist", "input_notify_info", "msg_ctrl", "receipt_req", "multi_send_seq"}, new Object[]{null, null, null, 0, 0, ByteStringMicro.EMPTY, null, 0, 0, null, null, null, null, 0}, msg_svc$PbSendMsgReq.class);
    public msg_svc$RoutingHead routing_head = new msg_svc$RoutingHead();
    public msg_comm$ContentHead content_head = new msg_comm$ContentHead();
    public im_msg_body$MsgBody msg_body = new im_msg_body$MsgBody();
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_rand = PBField.initUInt32(0);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public msg_comm$AppShareInfo app_share = new msg_comm$AppShareInfo();
    public final PBUInt32Field msg_via = PBField.initUInt32(0);
    public final PBUInt32Field data_statist = PBField.initUInt32(0);
    public msg_svc$MultiMsgAssist multi_msg_assist = new msg_svc$MultiMsgAssist();
    public msg_svc$PbInputNotifyInfo input_notify_info = new MessageMicro<msg_svc$PbInputNotifyInfo>() { // from class: msf.msgsvc.msg_svc$PbInputNotifyInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_pb_reserve;
        public final PBBytesField ios_push_wording;
        public final PBUInt64Field to_uin = PBField.initUInt64(0);
        public final PBUInt32Field ime = PBField.initUInt32(0);
        public final PBUInt32Field notify_flag = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"to_uin", "ime", "notify_flag", "bytes_pb_reserve", "ios_push_wording"}, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro}, msg_svc$PbInputNotifyInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
            this.ios_push_wording = PBField.initBytes(byteStringMicro);
        }
    };
    public msg_ctrl$MsgCtrl msg_ctrl = new msg_ctrl$MsgCtrl();
    public im_receipt$ReceiptReq receipt_req = new MessageMicro<im_receipt$ReceiptReq>() { // from class: tencent.im.msg.im_receipt$ReceiptReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"command", "msg_info"}, new Object[]{1, null}, im_receipt$ReceiptReq.class);
        public final PBEnumField command = PBField.initEnum(1);
        public im_receipt$MsgInfo msg_info = new MessageMicro<im_receipt$MsgInfo>() { // from class: tencent.im.msg.im_receipt$MsgInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint32_msg_random"}, new Object[]{0L, 0L, 0, 0}, im_receipt$MsgInfo.class);
            public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
            public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
        };
    };
    public final PBUInt32Field multi_send_seq = PBField.initUInt32(0);
}
