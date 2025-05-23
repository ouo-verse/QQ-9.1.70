package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$GetSharedPadListRspBody extends MessageMicro<TimDocSSOMsg$GetSharedPadListRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48}, new String[]{"uint32_retcode", "uint32_total_count", "uint32_timestamp", "rpt_msg_pad_list", "uint32_offset", "bool_endflag"}, new Object[]{0, 0, 0, null, 0, Boolean.FALSE}, TimDocSSOMsg$GetSharedPadListRspBody.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBRepeatMessageField<TimDocSSOMsg$PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg$PadInfo.class);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBBoolField bool_endflag = PBField.initBool(false);
}
