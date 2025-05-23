package com.tencent.trpcprotocol.qqstranger.room_game_dispatch.room_game_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomGameComm$MusicSetReq extends MessageMicro<RoomGameComm$MusicSetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"style_id"}, new Object[]{0L}, RoomGameComm$MusicSetReq.class);
    public final PBInt64Field style_id = PBField.initInt64(0);
}
