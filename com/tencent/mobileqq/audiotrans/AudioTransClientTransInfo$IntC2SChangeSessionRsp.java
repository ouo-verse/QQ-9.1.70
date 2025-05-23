package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$IntC2SChangeSessionRsp extends MessageMicro<AudioTransClientTransInfo$IntC2SChangeSessionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_combine_num", "enum_channel_type", "rpt_msg_interface_list"}, new Object[]{0, 1, null}, AudioTransClientTransInfo$IntC2SChangeSessionRsp.class);
    public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
    public final PBEnumField enum_channel_type = PBField.initEnum(1);
    public final PBRepeatMessageField<AudioTransCommon$NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon$NetAddr.class);
}
