package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$InfoC2SCreateSessionRsp extends MessageMicro<AudioTransClientTransInfo$InfoC2SCreateSessionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"enum_channel_type", "rpt_msg_interface_list", "bool_client_ans", "uint32_combine_num", "enum_translator_type"}, new Object[]{1, null, Boolean.FALSE, 0, 1}, AudioTransClientTransInfo$InfoC2SCreateSessionRsp.class);
    public final PBEnumField enum_channel_type = PBField.initEnum(1);
    public final PBRepeatMessageField<AudioTransCommon$NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon$NetAddr.class);
    public final PBBoolField bool_client_ans = PBField.initBool(false);
    public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
    public final PBEnumField enum_translator_type = PBField.initEnum(1);
}
