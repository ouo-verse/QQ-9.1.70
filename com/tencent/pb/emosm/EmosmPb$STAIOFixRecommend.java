package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$STAIOFixRecommend extends MessageMicro<EmosmPb$STAIOFixRecommend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"u32_pos", "rpt_list"}, new Object[]{0, null}, EmosmPb$STAIOFixRecommend.class);
    public final PBUInt32Field u32_pos = PBField.initUInt32(0);
    public final PBRepeatMessageField<EmosmPb$STRecommendTabInfo> rpt_list = PBField.initRepeatMessage(EmosmPb$STRecommendTabInfo.class);
}
