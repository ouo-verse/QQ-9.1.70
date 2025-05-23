package com.tencent.gamecenter.wadl.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class DataOpenapiSvr$GetGameDistributeDataReq extends MessageMicro<DataOpenapiSvr$GetGameDistributeDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guild_id"}, new Object[]{""}, DataOpenapiSvr$GetGameDistributeDataReq.class);
    public final PBStringField guild_id = PBField.initString("");
}
