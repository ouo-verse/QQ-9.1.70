package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$Request extends MessageMicro<ZplanAvatarProto$Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"cmd", "get_status", "is_exist_status", "create_status", "set_status", "get_status_jump_scheme"}, new Object[]{0, null, null, null, null, null}, ZplanAvatarProto$Request.class);
    public final PBEnumField cmd = PBField.initEnum(0);
    public ZplanAvatarProto$GetStatusReq get_status = new ZplanAvatarProto$GetStatusReq();
    public ZplanAvatarProto$IsExistStatusReq is_exist_status = new ZplanAvatarProto$IsExistStatusReq();
    public ZplanAvatarProto$CreateStatusReq create_status = new ZplanAvatarProto$CreateStatusReq();
    public ZplanAvatarProto$SetStatusReq set_status = new ZplanAvatarProto$SetStatusReq();
    public ZplanAvatarProto$GetStatusJumpSchemeReq get_status_jump_scheme = new ZplanAvatarProto$GetStatusJumpSchemeReq();
}
