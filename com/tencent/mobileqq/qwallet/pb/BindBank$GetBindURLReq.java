package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$GetBindURLReq extends MessageMicro<BindBank$GetBindURLReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bank_id", "bank_type", "token_id", "agreement"}, new Object[]{"", "", "", null}, BindBank$GetBindURLReq.class);
    public final PBStringField bank_id = PBField.initString("");
    public final PBStringField bank_type = PBField.initString("");
    public final PBStringField token_id = PBField.initString("");
    public final PBRepeatMessageField<BindBank$ProtoFile> agreement = PBField.initRepeatMessage(BindBank$ProtoFile.class);
}
