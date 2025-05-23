package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$MyRead extends MessageMicro<value$MyRead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"hw_ids"}, new Object[]{0L}, value$MyRead.class);
    public final PBRepeatField<Long> hw_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
