package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WadlTrpcReport$DcRecord extends MessageMicro<WadlTrpcReport$DcRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"dcId", "data"}, new Object[]{"", null}, WadlTrpcReport$DcRecord.class);
    public final PBStringField dcId = PBField.initString("");
    public final PBRepeatMessageField<WadlTrpcReport$KV> data = PBField.initRepeatMessage(WadlTrpcReport$KV.class);
}
