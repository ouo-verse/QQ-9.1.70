package com.tencent.protofile.getopenid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class GetOpenidProto$GetOpenidEntry extends MessageMicro<GetOpenidProto$GetOpenidEntry> {
    public static final int ID_FIELD_NUMBER = 2;
    public static final int OPENID_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"type", "id", "openid"}, new Object[]{0, 0L, ""}, GetOpenidProto$GetOpenidEntry.class);
    public final PBUInt32Field type = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f342198id = PBField.initUInt64(0);
    public final PBStringField openid = PBField.initString("");
}
