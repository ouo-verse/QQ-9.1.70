package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$Bank extends MessageMicro<BindBank$Bank> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"bank_id", "name", "promotion", "image_id", "proto_file", "card_type"}, new Object[]{"", "", "", "", null, null}, BindBank$Bank.class);
    public final PBStringField bank_id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField promotion = PBField.initString("");
    public final PBStringField image_id = PBField.initString("");
    public final PBRepeatMessageField<BindBank$ProtoFile> proto_file = PBField.initRepeatMessage(BindBank$ProtoFile.class);
    public final PBRepeatMessageField<BindBank$CardType> card_type = PBField.initRepeatMessage(BindBank$CardType.class);
}
