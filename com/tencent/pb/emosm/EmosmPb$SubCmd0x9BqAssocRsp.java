package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x9BqAssocRsp extends MessageMicro<EmosmPb$SubCmd0x9BqAssocRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_assoc_bqs", "i32_reset_exposure_flag"}, new Object[]{null, 0}, EmosmPb$SubCmd0x9BqAssocRsp.class);
    public final PBRepeatMessageField<EmosmPb$BqAssocInfo> rpt_assoc_bqs = PBField.initRepeatMessage(EmosmPb$BqAssocInfo.class);
    public final PBInt32Field i32_reset_exposure_flag = PBField.initInt32(0);
}
