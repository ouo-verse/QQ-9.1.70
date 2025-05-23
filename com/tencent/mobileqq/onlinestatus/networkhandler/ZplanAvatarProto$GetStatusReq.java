package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$GetStatusReq extends MessageMicro<ZplanAvatarProto$GetStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"obj_uin"}, new Object[]{0L}, ZplanAvatarProto$GetStatusReq.class);
    public final PBUInt64Field obj_uin = PBField.initUInt64(0);
}
