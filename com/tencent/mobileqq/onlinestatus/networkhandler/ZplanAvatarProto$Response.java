package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$Response extends MessageMicro<ZplanAvatarProto$Response> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret_code", "ret_msg", "get_status", "is_exist_status", "get_status_jump_scheme"}, new Object[]{0, "", null, null, null}, ZplanAvatarProto$Response.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public ZplanAvatarProto$GetStatusRsp get_status = new ZplanAvatarProto$GetStatusRsp();
    public ZplanAvatarProto$IsExistStatusRsp is_exist_status = new ZplanAvatarProto$IsExistStatusRsp();
    public ZplanAvatarProto$GetStatusJumpSchemeRsp get_status_jump_scheme = new ZplanAvatarProto$GetStatusJumpSchemeRsp();
}
