package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$GetStatusJumpSchemeReq extends MessageMicro<ZplanAvatarProto$GetStatusJumpSchemeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"obi_uin", "type"}, new Object[]{0L, 0L}, ZplanAvatarProto$GetStatusJumpSchemeReq.class);
    public final PBUInt64Field obi_uin = PBField.initUInt64(0);
    public final PBUInt64Field type = PBField.initUInt64(0);
}
