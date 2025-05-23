package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$GameOption extends MessageMicro<RoomManager$GameOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"game_id", CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_option", "game_ctrl"}, new Object[]{0, "", ByteStringMicro.EMPTY, null}, RoomManager$GameOption.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField game_name = PBField.initString("");
    public final PBBytesField game_option = PBField.initBytes(ByteStringMicro.EMPTY);
    public RoomManager$GameCtrl game_ctrl = new RoomManager$GameCtrl();
}
