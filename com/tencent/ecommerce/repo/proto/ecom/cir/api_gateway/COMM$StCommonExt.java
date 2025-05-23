package com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway;

import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class COMM$StCommonExt extends MessageMicro<COMM$StCommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{ThirdPartyMiniApiImpl.KEY_MAP_INFO, "attachInfo"}, new Object[]{null, ""}, COMM$StCommonExt.class);
    public final PBRepeatMessageField<COMM$Entry> mapInfo = PBField.initRepeatMessage(COMM$Entry.class);
    public final PBStringField attachInfo = PBField.initString("");
}
