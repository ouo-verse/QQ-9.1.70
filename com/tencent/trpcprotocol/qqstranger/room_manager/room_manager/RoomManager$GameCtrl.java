package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$GameCtrl extends MessageMicro<RoomManager$GameCtrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"game_versions", "room_types"}, new Object[]{null, 0}, RoomManager$GameCtrl.class);
    public final PBRepeatMessageField<RoomManager$GameVersion> game_versions = PBField.initRepeatMessage(RoomManager$GameVersion.class);
    public final PBRepeatField<Integer> room_types = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
