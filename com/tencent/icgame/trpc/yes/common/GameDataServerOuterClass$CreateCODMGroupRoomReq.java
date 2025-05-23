package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$CreateCODMGroupRoomReq extends MessageMicro<GameDataServerOuterClass$CreateCODMGroupRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uid", GdtGetUserInfoHandler.KEY_AREA, "plat_id", "room_type", "play_list"}, new Object[]{0L, 0, 0, 0, ""}, GameDataServerOuterClass$CreateCODMGroupRoomReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field plat_id = PBField.initUInt32(0);
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBRepeatField<String> play_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
