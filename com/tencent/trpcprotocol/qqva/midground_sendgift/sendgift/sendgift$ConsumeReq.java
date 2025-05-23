package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$ConsumeReq extends MessageMicro<sendgift$ConsumeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66, 74, 80, 88}, new String[]{"req_msg", "info", "scene_id", "combo_seq", "combo_cnt", "all_combo_cnt", "plat", "report_ext", "ext_dict", "pay_from", "send_type"}, new Object[]{ByteStringMicro.EMPTY, null, 0, 0L, 0, 0, 0, "", null, 0, 0}, sendgift$ConsumeReq.class);
    public final PBBytesField req_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public sendgift$OrderInfo info = new sendgift$OrderInfo();
    public final PBInt32Field scene_id = PBField.initInt32(0);
    public final PBUInt64Field combo_seq = PBField.initUInt64(0);
    public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
    public final PBUInt32Field all_combo_cnt = PBField.initUInt32(0);
    public final PBInt32Field plat = PBField.initInt32(0);
    public final PBStringField report_ext = PBField.initString("");
    public final PBRepeatMessageField<sendgift$ExtData> ext_dict = PBField.initRepeatMessage(sendgift$ExtData.class);
    public final PBEnumField pay_from = PBField.initEnum(0);
    public final PBEnumField send_type = PBField.initEnum(0);
}
