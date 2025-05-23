package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$SmobaConfigItem extends MessageMicro<GameDataServerOuterClass$SmobaConfigItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"key", "value"}, new Object[]{"", 0}, GameDataServerOuterClass$SmobaConfigItem.class);
    public final PBStringField key = PBField.initString("");
    public final PBRepeatField<Integer> value = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
