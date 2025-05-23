package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes6.dex */
public final class TrpcAttaProxy$ReportAttaReq extends MessageMicro<TrpcAttaProxy$ReportAttaReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"id", "attaValue"}, new Object[]{"", null}, TrpcAttaProxy$ReportAttaReq.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f106729id = PBField.initString("");
    public final PBRepeatMessageField<TrpcAttaProxy$AttaValue> attaValue = PBField.initRepeatMessage(TrpcAttaProxy$AttaValue.class);
}
