package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$ListParam extends MessageMicro<YoloRoomOuterClass$ListParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"index", "value"}, new Object[]{0, ""}, YoloRoomOuterClass$ListParam.class);
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBRepeatField<String> value = PBField.initRepeat(PBStringField.__repeatHelper__);
}
