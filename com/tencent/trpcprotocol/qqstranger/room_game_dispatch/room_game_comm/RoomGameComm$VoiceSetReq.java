package com.tencent.trpcprotocol.qqstranger.room_game_dispatch.room_game_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomGameComm$VoiceSetReq extends MessageMicro<RoomGameComm$VoiceSetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"topic_id"}, new Object[]{0L}, RoomGameComm$VoiceSetReq.class);
    public final PBInt64Field topic_id = PBField.initInt64(0);
}
