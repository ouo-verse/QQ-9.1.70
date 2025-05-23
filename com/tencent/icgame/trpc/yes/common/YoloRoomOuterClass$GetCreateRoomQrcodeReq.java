package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$GetCreateRoomQrcodeReq extends MessageMicro<YoloRoomOuterClass$GetCreateRoomQrcodeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"room_type", "qq_live_room_id", "enter_condition", "live_uid"}, new Object[]{0, 0L, 0, 0L}, YoloRoomOuterClass$GetCreateRoomQrcodeReq.class);
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBUInt64Field qq_live_room_id = PBField.initUInt64(0);
    public final PBInt32Field enter_condition = PBField.initInt32(0);
    public final PBUInt64Field live_uid = PBField.initUInt64(0);
}
