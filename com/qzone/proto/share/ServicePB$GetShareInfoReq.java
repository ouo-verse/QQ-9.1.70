package com.qzone.proto.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes39.dex */
public final class ServicePB$GetShareInfoReq extends MessageMicro<ServicePB$GetShareInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"encrypted_data"}, new Object[]{""}, ServicePB$GetShareInfoReq.class);
    public final PBStringField encrypted_data = PBField.initString("");
}
