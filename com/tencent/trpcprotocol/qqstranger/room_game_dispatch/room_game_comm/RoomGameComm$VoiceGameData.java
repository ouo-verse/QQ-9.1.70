package com.tencent.trpcprotocol.qqstranger.room_game_dispatch.room_game_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomGameComm$VoiceGameData extends MessageMicro<RoomGameComm$VoiceGameData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"topic"}, new Object[]{null}, RoomGameComm$VoiceGameData.class);
    public RoomGameComm$Topic topic = new MessageMicro<RoomGameComm$Topic>() { // from class: com.tencent.trpcprotocol.qqstranger.room_game_dispatch.room_game_comm.RoomGameComm$Topic
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"topic_id", "topic_name"}, new Object[]{0L, ""}, RoomGameComm$Topic.class);
        public final PBInt64Field topic_id = PBField.initInt64(0);
        public final PBStringField topic_name = PBField.initString("");
    };
}
