package com.tencent.ecommerce.repo.proto.ecom.common_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECComm$ProductID extends MessageMicro<ECComm$ProductID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "id", "sub_type"}, new Object[]{0, "", ""}, ECComm$ProductID.class);
    public final PBUInt32Field type = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105225id = PBField.initString("");
    public final PBStringField sub_type = PBField.initString("");
}
