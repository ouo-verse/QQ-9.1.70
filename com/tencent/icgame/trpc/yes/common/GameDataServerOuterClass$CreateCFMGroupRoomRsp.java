package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$CreateCFMGroupRoomRsp extends MessageMicro<GameDataServerOuterClass$CreateCFMGroupRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cfm_room_id", "cfm_trans_svr_id"}, new Object[]{"", ""}, GameDataServerOuterClass$CreateCFMGroupRoomRsp.class);
    public final PBStringField cfm_room_id = PBField.initString("");
    public final PBStringField cfm_trans_svr_id = PBField.initString("");
}
