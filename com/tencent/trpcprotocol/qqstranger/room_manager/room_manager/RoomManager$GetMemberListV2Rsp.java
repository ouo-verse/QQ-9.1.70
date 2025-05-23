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
public final class RoomManager$GetMemberListV2Rsp extends MessageMicro<RoomManager$GetMemberListV2Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58}, new String[]{"ret_code", "ret_msg", "user_info", "cookies", "total", "is_end", "member_cnt"}, new Object[]{0, "", null, "", 0L, Boolean.FALSE, null}, RoomManager$GetMemberListV2Rsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<RoomManager$UserInfo> user_info = PBField.initRepeatMessage(RoomManager$UserInfo.class);
    public final PBStringField cookies = PBField.initString("");
    public final PBUInt64Field total = PBField.initUInt64(0);
    public final PBBoolField is_end = PBField.initBool(false);
    public RoomManager$MemberCount member_cnt = new MessageMicro<RoomManager$MemberCount>() { // from class: com.tencent.trpcprotocol.qqstranger.room_manager.room_manager.RoomManager$MemberCount
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"stage_user_cnt"}, new Object[]{0}, RoomManager$MemberCount.class);
        public final PBUInt32Field stage_user_cnt = PBField.initUInt32(0);
    };
}
