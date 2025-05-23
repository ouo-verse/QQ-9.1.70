package com.tencent.trpcprotocol.qqstranger.room_game_dispatch.room_game_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomGameComm$MusicGameData extends MessageMicro<RoomGameComm$MusicGameData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"music_style"}, new Object[]{null}, RoomGameComm$MusicGameData.class);
    public RoomGameComm$MusicStyle music_style = new MessageMicro<RoomGameComm$MusicStyle>() { // from class: com.tencent.trpcprotocol.qqstranger.room_game_dispatch.room_game_comm.RoomGameComm$MusicStyle
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"style_id", QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, "style_desc"}, new Object[]{0L, "", ""}, RoomGameComm$MusicStyle.class);
        public final PBInt64Field style_id = PBField.initInt64(0);
        public final PBStringField style_name = PBField.initString("");
        public final PBStringField style_desc = PBField.initString("");
    };
}
