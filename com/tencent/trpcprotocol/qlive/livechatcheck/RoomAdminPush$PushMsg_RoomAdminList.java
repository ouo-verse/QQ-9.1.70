package com.tencent.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class RoomAdminPush$PushMsg_RoomAdminList extends MessageMicro<RoomAdminPush$PushMsg_RoomAdminList> {
    public static final int ADMINS_FIELD_NUMBER = 1;
    public static final int IS_MASTER_IN_ROOM_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"admins", "is_master_in_room"}, new Object[]{null, Boolean.FALSE}, RoomAdminPush$PushMsg_RoomAdminList.class);
    public final PBRepeatMessageField<RoomAdminPush$RoomAdminDetail> admins = PBField.initRepeatMessage(RoomAdminPush$RoomAdminDetail.class);
    public final PBBoolField is_master_in_room = PBField.initBool(false);
}
