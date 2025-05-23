package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$GetBankInfoRsp extends MessageMicro<BindBank$GetBankInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66}, new String[]{"title", "sub_title", "image_format", "proto_file", "bank", "min_bank_count", "channel_id", "busi_info"}, new Object[]{"", "", "", null, null, 0, "", ""}, BindBank$GetBankInfoRsp.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField image_format = PBField.initString("");
    public final PBRepeatMessageField<BindBank$ProtoFile> proto_file = PBField.initRepeatMessage(BindBank$ProtoFile.class);
    public final PBRepeatMessageField<BindBank$Bank> bank = PBField.initRepeatMessage(BindBank$Bank.class);
    public final PBInt32Field min_bank_count = PBField.initInt32(0);
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField busi_info = PBField.initString("");
}
