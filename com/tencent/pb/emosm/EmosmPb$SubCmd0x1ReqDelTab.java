package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x1ReqDelTab extends MessageMicro<EmosmPb$SubCmd0x1ReqDelTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_tab_id", "rpt_tab_id"}, new Object[]{0, 0}, EmosmPb$SubCmd0x1ReqDelTab.class);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_tab_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
