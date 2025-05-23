package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloCheckCreateGameRoomReq extends MessageMicro<YoloRoomOuterClass$YoloCheckCreateGameRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"game_id"}, new Object[]{0}, YoloRoomOuterClass$YoloCheckCreateGameRoomReq.class);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
}
