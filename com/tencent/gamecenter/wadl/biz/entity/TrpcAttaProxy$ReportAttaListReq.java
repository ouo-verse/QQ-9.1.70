package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes6.dex */
public final class TrpcAttaProxy$ReportAttaListReq extends MessageMicro<TrpcAttaProxy$ReportAttaListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"attaList"}, new Object[]{null}, TrpcAttaProxy$ReportAttaListReq.class);
    public final PBRepeatMessageField<TrpcAttaProxy$AttaItem> attaList = PBField.initRepeatMessage(TrpcAttaProxy$AttaItem.class);
}
