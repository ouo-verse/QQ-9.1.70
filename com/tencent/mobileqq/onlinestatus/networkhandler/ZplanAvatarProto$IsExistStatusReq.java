package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$IsExistStatusReq extends MessageMicro<ZplanAvatarProto$IsExistStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"obj_uin", "key"}, new Object[]{0L, ""}, ZplanAvatarProto$IsExistStatusReq.class);
    public final PBUInt64Field obj_uin = PBField.initUInt64(0);
    public final PBStringField key = PBField.initString("");
}
