package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class intchk$RspBody extends MessageMicro<intchk$RspBody> {
    public static final int MSG_CHECK_CONFIG_RSP_FIELD_NUMBER = 3;
    public static final int MSG_REPORT_CHECK_RESULT_RSP_FIELD_NUMBER = 4;
    public static final int UINT32_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_subcmd", "uint32_result", "msg_check_config_rsp", "msg_report_check_result_rsp"}, new Object[]{0, 0, null, null}, intchk$RspBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public intchk$FetchCheckConfigRsp msg_check_config_rsp = new intchk$FetchCheckConfigRsp();
    public intchk$ReportCheckResultRsp msg_report_check_result_rsp = new intchk$ReportCheckResultRsp();
}
