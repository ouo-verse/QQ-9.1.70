package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$GetMemberListRsp extends MessageMicro<RoomManager$GetMemberListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"ret_code", "ret_msg", "user_info", "total", "is_end"}, new Object[]{0, "", null, 0L, Boolean.FALSE}, RoomManager$GetMemberListRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<RoomManager$UserInfo> user_info = PBField.initRepeatMessage(RoomManager$UserInfo.class);
    public final PBUInt64Field total = PBField.initUInt64(0);
    public final PBBoolField is_end = PBField.initBool(false);
}
