package com.tencent.trpcprotocol.qqstranger.room_admin.room_admin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomAdmin$IsKickOutRsp extends MessageMicro<RoomAdmin$IsKickOutRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret_code", "ret_msg", "is_kickout", "kick_user"}, new Object[]{0, "", Boolean.FALSE, null}, RoomAdmin$IsKickOutRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBoolField is_kickout = PBField.initBool(false);
    public RoomAdmin$KickOutUser kick_user = new MessageMicro<RoomAdmin$KickOutUser>() { // from class: com.tencent.trpcprotocol.qqstranger.room_admin.room_admin.RoomAdmin$KickOutUser
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"admin_uid", "target_uid", "end_time"}, new Object[]{"", "", 0L}, RoomAdmin$KickOutUser.class);
        public final PBStringField admin_uid = PBField.initString("");
        public final PBStringField target_uid = PBField.initString("");
        public final PBUInt64Field end_time = PBField.initUInt64(0);
    };
}
