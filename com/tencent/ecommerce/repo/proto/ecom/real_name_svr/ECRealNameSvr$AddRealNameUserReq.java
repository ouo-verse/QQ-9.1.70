package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$AddRealNameUserReq extends MessageMicro<ECRealNameSvr$AddRealNameUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "id_card"}, new Object[]{"", ""}, ECRealNameSvr$AddRealNameUserReq.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField id_card = PBField.initString("");
}
