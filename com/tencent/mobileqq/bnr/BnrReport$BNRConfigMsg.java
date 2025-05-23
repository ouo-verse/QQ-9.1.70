package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BnrReport$BNRConfigMsg extends MessageMicro<BnrReport$BNRConfigMsg> {
    public static final int CMD_FIELD_NUMBER = 2;
    public static final int EXT_INFO_FIELD_NUMBER = 4;
    public static final int MSG_REQ_BODY_FIELD_NUMBER = 10;
    public static final int MSG_RSP_BODY_FIELD_NUMBER = 11;
    public static final int SEQ_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 82, 90}, new String[]{"uin", "cmd", "seq", "ext_info", "msg_req_body", "msg_rsp_body"}, new Object[]{0L, 0, 0, null, null, null}, BnrReport$BNRConfigMsg.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public BnrReport$ExtInfo ext_info = new BnrReport$ExtInfo();
    public BnrReport$BNReportConfigReq msg_req_body = new BnrReport$BNReportConfigReq();
    public BnrReport$BNReportConfigRsp msg_rsp_body = new BnrReport$BNReportConfigRsp();
}
