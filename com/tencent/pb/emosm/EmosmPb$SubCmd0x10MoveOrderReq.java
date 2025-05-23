package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x10MoveOrderReq extends MessageMicro<EmosmPb$SubCmd0x10MoveOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_tab_id"}, new Object[]{0}, EmosmPb$SubCmd0x10MoveOrderReq.class);
    public final PBRepeatField<Integer> uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
