package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$GetPadListRspBody extends MessageMicro<TimDocSSOMsg$GetPadListRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64}, new String[]{"uint32_retcode", "uint32_total_count", "uint32_timestamp", "uint32_offset", "bool_endflag", "rpt_msg_pad_list", "bytes_timestamp", "uint32_auto_fresh_interval"}, new Object[]{0, 0, 0, 0, Boolean.FALSE, null, ByteStringMicro.EMPTY, 0}, TimDocSSOMsg$GetPadListRspBody.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBBoolField bool_endflag = PBField.initBool(false);
    public final PBRepeatMessageField<TimDocSSOMsg$PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg$PadInfo.class);
    public final PBBytesField bytes_timestamp = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_auto_fresh_interval = PBField.initUInt32(0);
}
