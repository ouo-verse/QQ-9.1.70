package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$AddFansGroupReq extends MessageMicro<UserProxyCmdOuterClass$AddFansGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"live_room_id", "live_uid", "group_id_list"}, new Object[]{0L, 0L, ""}, UserProxyCmdOuterClass$AddFansGroupReq.class);
    public final PBUInt64Field live_room_id = PBField.initUInt64(0);
    public final PBUInt64Field live_uid = PBField.initUInt64(0);
    public final PBRepeatField<String> group_id_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
