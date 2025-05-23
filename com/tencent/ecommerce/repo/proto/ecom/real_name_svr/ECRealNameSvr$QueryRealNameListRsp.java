package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$QueryRealNameListRsp extends MessageMicro<ECRealNameSvr$QueryRealNameListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cookie", "users"}, new Object[]{"", null}, ECRealNameSvr$QueryRealNameListRsp.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBRepeatMessageField<ECRealNameSvr$User> users = PBField.initRepeatMessage(ECRealNameSvr$User.class);
}
