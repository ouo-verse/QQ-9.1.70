package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMRoomCreatedEvent extends MessageMicro<QsmDataOuterClass$QSMRoomCreatedEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72}, new String[]{"qsm_room_id", "yes_room_id", "game_type", "race_game_play", "owner", "inviter_uid", "world_id", "svr_id", "yes_room_id_local_svr"}, new Object[]{0L, 0L, 0, 0, null, 0L, 0, 0, 0}, QsmDataOuterClass$QSMRoomCreatedEvent.class);
    public final PBUInt64Field qsm_room_id = PBField.initUInt64(0);
    public final PBUInt64Field yes_room_id = PBField.initUInt64(0);
    public final PBInt32Field game_type = PBField.initInt32(0);
    public final PBInt32Field race_game_play = PBField.initInt32(0);
    public QsmDataOuterClass$QSMPlayerInfo owner = new QsmDataOuterClass$QSMPlayerInfo();
    public final PBUInt64Field inviter_uid = PBField.initUInt64(0);
    public final PBUInt32Field world_id = PBField.initUInt32(0);
    public final PBUInt32Field svr_id = PBField.initUInt32(0);
    public final PBUInt32Field yes_room_id_local_svr = PBField.initUInt32(0);
}
