package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$RoomTypeOption extends MessageMicro<RoomManager$RoomTypeOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"room_type", "room_type_name", "hide_game_option"}, new Object[]{0, "", Boolean.FALSE}, RoomManager$RoomTypeOption.class);
    public final PBEnumField room_type = PBField.initEnum(0);
    public final PBStringField room_type_name = PBField.initString("");
    public final PBBoolField hide_game_option = PBField.initBool(false);
}
