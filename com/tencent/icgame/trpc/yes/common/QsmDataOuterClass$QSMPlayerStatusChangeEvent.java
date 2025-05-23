package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMPlayerStatusChangeEvent extends MessageMicro<QsmDataOuterClass$QSMPlayerStatusChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"qsm_room_id", "yes_room_id", "player_info", "player_status"}, new Object[]{0L, 0L, null, 0}, QsmDataOuterClass$QSMPlayerStatusChangeEvent.class);
    public final PBUInt64Field qsm_room_id = PBField.initUInt64(0);
    public final PBUInt64Field yes_room_id = PBField.initUInt64(0);
    public QsmDataOuterClass$QSMPlayerInfo player_info = new QsmDataOuterClass$QSMPlayerInfo();
    public final PBInt32Field player_status = PBField.initInt32(0);
}
