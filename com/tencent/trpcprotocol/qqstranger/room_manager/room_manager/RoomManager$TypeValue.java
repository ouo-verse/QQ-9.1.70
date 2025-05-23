package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$TypeValue extends MessageMicro<RoomManager$TypeValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"tid", "value", "str"}, new Object[]{0, 0L, ""}, RoomManager$TypeValue.class);
    public final PBInt32Field tid = PBField.initInt32(0);
    public final PBRepeatField<Long> value = PBField.initRepeat(PBInt64Field.__repeatHelper__);
    public final PBRepeatField<String> str = PBField.initRepeat(PBStringField.__repeatHelper__);
}
