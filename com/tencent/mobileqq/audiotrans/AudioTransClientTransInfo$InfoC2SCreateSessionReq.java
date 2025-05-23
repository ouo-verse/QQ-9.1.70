package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$InfoC2SCreateSessionReq extends MessageMicro<AudioTransClientTransInfo$InfoC2SCreateSessionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 74}, new String[]{"enum_business_type", "rpt_member_list", "enum_business_direction", "uint32_session_test_flag", "uint32_client_ver", "enum_term", "enum_net_type", "bool_translate", "result_report_addr"}, new Object[]{1, "", 1, 0, 0, 1, 1, Boolean.FALSE, null}, AudioTransClientTransInfo$InfoC2SCreateSessionReq.class);
    public final PBEnumField enum_business_type = PBField.initEnum(1);
    public final PBRepeatField<String> rpt_member_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField enum_business_direction = PBField.initEnum(1);
    public final PBUInt32Field uint32_session_test_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
    public final PBEnumField enum_term = PBField.initEnum(1);
    public final PBEnumField enum_net_type = PBField.initEnum(1);
    public final PBBoolField bool_translate = PBField.initBool(false);
    public AudioTransCommon$NetAddr result_report_addr = new AudioTransCommon$NetAddr();
}
