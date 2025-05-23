package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LBSShare$GetShopsByIdsReq extends MessageMicro<LBSShare$GetShopsByIdsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ids"}, new Object[]{""}, LBSShare$GetShopsByIdsReq.class);
    public final PBRepeatField<String> ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
