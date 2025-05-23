package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class QQProtectRisks$QQProtectRisksResponse extends MessageMicro<QQProtectRisks$QQProtectRisksResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 58}, new String[]{"uint32_sec_cmd", "str_no_risk_text", "risk_info_list", "uint32_qpim_switches", "str_risk_tip_text", "uint32_cache_time", "str_risk_exist"}, new Object[]{0, "", null, 0, "", 0, ""}, QQProtectRisks$QQProtectRisksResponse.class);
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
    public final PBStringField str_no_risk_text = PBField.initString("");
    public final PBRepeatMessageField<QQProtectRisks$RiskInfo> risk_info_list = PBField.initRepeatMessage(QQProtectRisks$RiskInfo.class);
    public final PBUInt32Field uint32_qpim_switches = PBField.initUInt32(0);
    public final PBStringField str_risk_tip_text = PBField.initString("");
    public final PBUInt32Field uint32_cache_time = PBField.initUInt32(0);
    public final PBStringField str_risk_exist = PBField.initString("");
}
