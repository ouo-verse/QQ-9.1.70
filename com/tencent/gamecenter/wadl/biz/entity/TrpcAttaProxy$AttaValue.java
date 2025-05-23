package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes6.dex */
public final class TrpcAttaProxy$AttaValue extends MessageMicro<TrpcAttaProxy$AttaValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, TrpcAttaProxy$AttaValue.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
