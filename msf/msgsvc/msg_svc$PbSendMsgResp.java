package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_receipt$ReceiptResp;

/* loaded from: classes28.dex */
public final class msg_svc$PbSendMsgResp extends MessageMicro<msg_svc$PbSendMsgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 58, 66, 72, 80, 106}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "send_time", "uint32_svrbusy_wait_time", "msg_send_info", "errtype", "trans_svr_info", "receipt_resp", "text_analysis_result", "uint32_msg_info_flag", "msgeleminfo_servtype37"}, new Object[]{0, "", 0, 0, null, 0, null, null, 0, 0, ByteStringMicro.EMPTY}, msg_svc$PbSendMsgResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field send_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_svrbusy_wait_time = PBField.initUInt32(0);
    public msg_svc$MsgSendInfo msg_send_info = new MessageMicro<msg_svc$MsgSendInfo>() { // from class: msf.msgsvc.msg_svc$MsgSendInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"receiver"}, new Object[]{0}, msg_svc$MsgSendInfo.class);
        public final PBUInt32Field receiver = PBField.initUInt32(0);
    };
    public final PBUInt32Field errtype = PBField.initUInt32(0);
    public msg_svc$TransSvrInfo trans_svr_info = new msg_svc$TransSvrInfo();
    public im_receipt$ReceiptResp receipt_resp = new im_receipt$ReceiptResp();
    public final PBUInt32Field text_analysis_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_info_flag = PBField.initUInt32(0);
    public final PBBytesField msgeleminfo_servtype37 = PBField.initBytes(ByteStringMicro.EMPTY);
}
