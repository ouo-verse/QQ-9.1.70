package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$QueryRealNameListReq extends MessageMicro<ECRealNameSvr$QueryRealNameListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cookie"}, new Object[]{""}, ECRealNameSvr$QueryRealNameListReq.class);
    public final PBStringField cookie = PBField.initString("");
}
