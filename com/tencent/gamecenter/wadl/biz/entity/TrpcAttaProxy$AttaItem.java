package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes6.dex */
public final class TrpcAttaProxy$AttaItem extends MessageMicro<TrpcAttaProxy$AttaItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26}, new String[]{"attaId", "valueList"}, new Object[]{"", null}, TrpcAttaProxy$AttaItem.class);
    public final PBStringField attaId = PBField.initString("");
    public final PBRepeatMessageField<TrpcAttaProxy$AttaValue> valueList = PBField.initRepeatMessage(TrpcAttaProxy$AttaValue.class);
}
