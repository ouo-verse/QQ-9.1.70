package com.tencent.trpcprotocol.qqstranger.room_game_dispatch.room_game_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomGameComm$MusicGameOption extends MessageMicro<RoomGameComm$MusicGameOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"opt_name", "music_styles"}, new Object[]{"", null}, RoomGameComm$MusicGameOption.class);
    public final PBStringField opt_name = PBField.initString("");
    public final PBRepeatMessageField<RoomGameComm$MusicStyle> music_styles = PBField.initRepeatMessage(RoomGameComm$MusicStyle.class);
}
