package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$BatchConsumeReq extends MessageMicro<sendgift$BatchConsumeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64}, new String[]{"send_infos", "scene_id", "combo_seq", "combo_cnt", "all_combo_cnt", "plat", "pay_from", "send_type"}, new Object[]{null, 0, 0L, 0, 0, 0, 0, 0}, sendgift$BatchConsumeReq.class);
    public final PBRepeatMessageField<sendgift$BatchSendInfo> send_infos = PBField.initRepeatMessage(sendgift$BatchSendInfo.class);
    public final PBInt32Field scene_id = PBField.initInt32(0);
    public final PBUInt64Field combo_seq = PBField.initUInt64(0);
    public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
    public final PBUInt32Field all_combo_cnt = PBField.initUInt32(0);
    public final PBInt32Field plat = PBField.initInt32(0);
    public final PBEnumField pay_from = PBField.initEnum(0);
    public final PBEnumField send_type = PBField.initEnum(0);
}
