package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes5.dex */
public final class qqstory_struct$InteractPasterInfo extends MessageMicro<qqstory_struct$InteractPasterInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"paster_type", "paster_contents"}, new Object[]{0, ""}, qqstory_struct$InteractPasterInfo.class);
    public final PBUInt32Field paster_type = PBField.initUInt32(0);
    public final PBRepeatField<String> paster_contents = PBField.initRepeat(PBStringField.__repeatHelper__);
}
