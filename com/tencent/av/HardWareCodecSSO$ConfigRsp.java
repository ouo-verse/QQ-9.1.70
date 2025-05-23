package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class HardWareCodecSSO$ConfigRsp extends MessageMicro<HardWareCodecSSO$ConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"codec_info"}, new Object[]{null}, HardWareCodecSSO$ConfigRsp.class);
    public final PBRepeatMessageField<HardWareCodecSSO$PowerInfo> codec_info = PBField.initRepeatMessage(HardWareCodecSSO$PowerInfo.class);
}
